import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class order extends JPanel {
    private ArrayList<String> orderList;
    private JPanel itemsPanel;

    public order() {
        setLayout(new BorderLayout());
        setBackground(Color.white);
        orderList = new ArrayList<>();

        itemsPanel = new JPanel();
        itemsPanel.setLayout(new BoxLayout(itemsPanel, BoxLayout.Y_AXIS));
        itemsPanel.setBackground(Color.white);

        // 스크롤 가능하게 설정
        JScrollPane scrollPane = new JScrollPane(itemsPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setPreferredSize(new Dimension(500, 200));

        add(scrollPane, BorderLayout.CENTER);
    }

    public void addToOrder(String itemName, String sideOption, String drinkOption, int price) {
        String orderItem = itemName;
        if (sideOption != null && drinkOption != null) {
            orderItem += " (사이드: " + sideOption + ", 음료: " + drinkOption + ")";
        }

        boolean itemExists = false;
        for (Component comp : itemsPanel.getComponents()) {
            if (comp instanceof JPanel) {
                JPanel panel = (JPanel) comp;
                JLabel label = (JLabel) panel.getComponent(0);
                if (label.getText().equals(orderItem)) {
                    JLabel quantityLabel = (JLabel) panel.getComponent(2); // 2번째 인덱스에서 라벨 가져오기
                    int quantity = Integer.parseInt(quantityLabel.getText());
                    quantityLabel.setText(String.valueOf(++quantity));
                    itemExists = true;
                    break;
                }
            }
        }

        if (!itemExists) {
            JPanel itemPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            itemPanel.setPreferredSize(new Dimension(500, 30)); // 크기 설정
            itemPanel.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2)); // 항목 사이 간격 조정

            JLabel itemLabel = new JLabel(orderItem);
            JLabel priceLabel = new JLabel(price + "원");
            JLabel quantityLabel = new JLabel("1");

            JButton minusButton = new JButton("-");
            JButton plusButton = new JButton("+");
            JButton deleteButton = new JButton("취소");

            minusButton.setMargin(new Insets(0, 2, 0, 2)); // 버튼 간격 조정
            plusButton.setMargin(new Insets(0, 2, 0, 2));
            deleteButton.setMargin(new Insets(0, 2, 0, 2));

            minusButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int quantity = Integer.parseInt(quantityLabel.getText());
                    if (quantity > 1) {
                        quantityLabel.setText(String.valueOf(--quantity));
                    }
                }
            });

            plusButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int quantity = Integer.parseInt(quantityLabel.getText());
                    quantityLabel.setText(String.valueOf(++quantity));
                }
            });

            deleteButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    removeItem(itemPanel);
                }
            });

            JPanel rightPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 5, 0));
            rightPanel.add(minusButton);
            rightPanel.add(quantityLabel);
            rightPanel.add(plusButton);
            rightPanel.add(priceLabel);
            rightPanel.add(deleteButton);

            itemPanel.add(itemLabel);
            itemPanel.add(rightPanel);

            itemsPanel.add(itemPanel);
        }

        revalidate();
        repaint();
    }

    private void removeItem(JPanel itemPanel) {
        itemsPanel.remove(itemPanel);
        revalidate();
        repaint();
    }

    public void clearOrder() {
        itemsPanel.removeAll();
        orderList.clear();
        revalidate();
        repaint();
    }

    public JPanel getItemsPanel() {
        return itemsPanel;
    }

    public ArrayList<String> getOrderList() {
        return orderList;
    }
}
