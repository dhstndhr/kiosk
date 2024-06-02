import javax.swing.*;
import javax.swing.text.html.Option;
import java.awt.*;
public class menuPage extends JPanel { //메뉴페이지 panel을 만드는 클래스
    Category category;
    private CardLayout cardLayout;
    private JPanel cardPanel;
    static final int PAGE_WIDTH = 600;
    static final int PAGE_HEIGHT = 500;
    int menuNum;
    String pageName;
    public menuPage(String[] pageName,int[] menuNum){
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);
        for(int i = 0; i <pageName.length; i++){
            init(pageName[i],menuNum[i]);
        }
    }
    private void init(String pageName, int menuNum){
        this.pageName = pageName;
        this.menuNum = menuNum;
        JPanel page = createMenuPage();
        super.add(page,pageName);
        //super.setSize(PAGE_WIDTH,PAGE_HEIGHT);
        //setVisible(true);

    }
    private JPanel createMenuPage(){
        JPanel page = new JPanel(new GridLayout(4,4));
        for(int i = 0; i<menuNum; i++) {
            super.add(new Menu("햄버거세트","src/image/hamburger.jpg",20000));
        }
        return page;
    }
    public void showPage(String pageName) {
        cardLayout.show(cardPanel, pageName);
    }

}
