import javax.swing.*;
import java.awt.*;

public class menuPage extends JPanel {
    private CardLayout cardLayout;
    private JPanel cardPanel;
    private int[] menuNum;
    private String[] pageName;

    public menuPage(String[] pageName, int[] menuNum) {
        this.pageName = pageName;
        this.menuNum = menuNum;
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        for (int i = 0; i < pageName.length; i++) {
            JPanel page = createMenuPage(pageName[i], menuNum[i]);
            cardPanel.add(page, pageName[i]);
        }

        setLayout(new BorderLayout());
        add(cardPanel, BorderLayout.CENTER);
    }

    private JPanel createMenuPage(String pageName, int menuNum) {
        JPanel page = new JPanel(new GridLayout(4, 4));
        for (int i = 0; i < menuNum; i++) {
            page.add(new Menu(pageName + " " + (i + 1), "src/image/hamburger.jpg", 20000));
        }
        return page;
    }

    public void showPage(String pageName) {
        cardLayout.show(cardPanel, pageName);
    }
}
