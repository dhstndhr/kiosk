import javax.swing.*;
import java.awt.*;

public class menuPage extends JPanel {
    private CardLayout cardLayout;
    private JPanel cardPanel;
    private order orderPanel;
    private JPanel mainPanel;

    public menuPage(String[] pageNames, int[] menuNums, order orderPanel, JPanel mainPanel, CardLayout cardLayout) {
        this.orderPanel = orderPanel;
        this.mainPanel = mainPanel;
        this.cardLayout = cardLayout;
        this.cardPanel = new JPanel(cardLayout);

        for (String pageName : pageNames) {
            JPanel page = createMenuPage(pageName);
            cardPanel.add(page, pageName);
        }

        setLayout(new BorderLayout());
        add(cardPanel, BorderLayout.CENTER);
    }

    private JPanel createMenuPage(String pageName) {
        JPanel page = new JPanel(new GridLayout(1, 2)); // 두 개의 메뉴만 표시하도록 GridLayout 설정
        if (pageName.equals("HAMBURGER")) {
            page.add(new Menu("불고기 버거", "img/불고기 버거.png", 5000, orderPanel, mainPanel, cardLayout));
            page.add(new Menu("새우 버거", "img/새우버거.png", 6000, orderPanel, mainPanel, cardLayout));
        } else if (pageName.equals("SIDEDISH")) {
            page.add(new Menu("감자튀김", "img/감자튀김.png", 2000, orderPanel, mainPanel, cardLayout));
            page.add(new Menu("치즈스틱", "img/치즈스틱.png", 3000, orderPanel, mainPanel, cardLayout));
        } else if (pageName.equals("BEVERAGE")) {
            page.add(new Menu("콜라", "img/콜라.png", 1500, orderPanel, mainPanel, cardLayout));
            page.add(new Menu("사이다", "img/사이다.png", 2000, orderPanel, mainPanel, cardLayout));
        }
        return page;
    }

    public void showPage(String pageName) {
        cardLayout.show(cardPanel, pageName);
    }
}
