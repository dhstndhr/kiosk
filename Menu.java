import javax.swing.*;
import javax.swing.text.html.Option;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Menu extends JLabel {
    //image
    private String MenuName;
    private int menuPrice;
    private String imagePath;
    public Menu(String MenuName, String imagePath, int menuPrice) {
        this.menuPrice = menuPrice;
        this.MenuName = MenuName;
        super.setLayout(new FlowLayout()); //위 이미지, 아래에 제목 들어가도록.
        super.setSize(50,50); //메뉴 크기
        add(new JLabel(new ImageIcon(imagePath)));
        add(new JTextField(MenuName));
        setVisible(true);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {




            }
        });
    }
    void init(){
    }
    String getMenuName(){
        return this.MenuName;
    }
    void unDisplay(){
        setVisible(false);
    }
    void setMenuName(String newName){
        this.MenuName = newName;
    }
    String getImagePath(){
        return imagePath;
    }



}
