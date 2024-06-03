import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Menu extends JPanel {
    private String menuName;
    private int menuPrice;
    private String imagePath;
    private order orderPanel;
    private JPanel mainPanel;
    private CardLayout cardLayout;
    private Option optionPanel;

    public Menu(String menuName, String imagePath, int menuPrice, order orderPanel, JPanel mainPanel, CardLayout cardLayout) {
        this.menuPrice = menuPrice;
        this.menuName = menuName;
        this.imagePath = imagePath;
        this.orderPanel = orderPanel;
        this.mainPanel = mainPanel;
        this.cardLayout = cardLayout;

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel imageLabel = new JLabel(new ImageIcon(new ImageIcon(imagePath).getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH)));
        add(imageLabel);
        add(new JLabel(menuName));
        setPreferredSize(new Dimension(300, 350)); // 메뉴 크기 설정
        setVisible(true);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (menuName.equals("불고기 버거") || menuName.equals("새우 버거")) {
                    showSetSingleSelection();
                } else {
                    orderPanel.addToOrder(menuName + " 단품", null, null, menuPrice);
                }
            }
        });
    }

    private void showSetSingleSelection() {
        JPanel selectionPanel = new JPanel(new GridLayout(2, 1));
        JButton setButton = new JButton("세트");
        JButton singleButton = new JButton("단품");

        setButton.addActionListener(e -> {
            showSetOptions();
            cardLayout.show(mainPanel, "optionPanel");
        });

        singleButton.addActionListener(e -> {
            orderPanel.addToOrder(menuName + " 단품", null, null, menuPrice);
            cardLayout.show(mainPanel, "menuPanel");
        });

        selectionPanel.add(setButton);
        selectionPanel.add(singleButton);

        mainPanel.add(selectionPanel, "selectionPanel");
        cardLayout.show(mainPanel, "selectionPanel");
    }

    private void showSetOptions() {
        optionPanel = new Option(() -> {
            String selectedSide = optionPanel.getSelectedSide();
            String selectedDrink = optionPanel.getSelectedDrink();
            if (selectedSide != null && selectedDrink != null) {
                orderPanel.addToOrder(menuName + " 세트", selectedSide, selectedDrink, menuPrice + 2000); // 세트 가격 추가
                cardLayout.show(mainPanel, "menuPanel");
            }
        });

        mainPanel.add(optionPanel, "optionPanel");
        cardLayout.show(mainPanel, "optionPanel");
    }

    public String getMenuName() {
        return this.menuName;
    }

    public void unDisplay() {
        setVisible(false);
    }

    public void setMenuName(String newName) {
        this.menuName = newName;
    }

    public String getImagePath() {
        return imagePath;
    }
}
