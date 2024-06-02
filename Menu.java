import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Menu extends JPanel {
    private String menuName;
    private int menuPrice;
    private String imagePath;

    public Menu(String menuName, String imagePath, int menuPrice) {
        this.menuPrice = menuPrice;
        this.menuName = menuName;
        this.imagePath = imagePath;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS)); // 이미지 위, 텍스트 아래 레이아웃

        add(new JLabel(new ImageIcon(imagePath)));
        add(new JLabel(menuName));
        setPreferredSize(new Dimension(150, 150)); // 메뉴 크기 설정
        setVisible(true);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // 클릭 이벤트 처리
                System.out.println(menuName + " clicked!");
            }
        });
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
