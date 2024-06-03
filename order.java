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
            itemPanel.setPreferredSize(new Dimension(500, 20)); // 크기 설정

            JLabel itemLabel = new JLabel(orderItem);
            JLabel priceLabel = new JLabel(String.valueOf(price) + "원");
            JLabel quantityLabel = new JLabel("1");

            JButton minusButton = new JButton("-");
            JButton plusButton = new JButton("+");
            JButton deleteButton = new JButton("취소");

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

            itemPanel.add(itemLabel);
            itemPanel.add(minusButton);
            itemPanel.add(quantityLabel);
            itemPanel.add(plusButton);
            itemPanel.add(priceLabel);
            itemPanel.add(deleteButton);

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

    public ArrayList<String> getOrderList() {
        return orderList;
    }
}
