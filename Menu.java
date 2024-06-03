import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Menu extends JPanel {
    private String menuName;
    private int menuPrice;
    private String imagePath;
    private JPanel basketArea;

    public Menu(String menuName, String imagePath, int menuPrice, JPanel basketArea) {
        this.menuPrice = menuPrice;
        this.menuName = menuName;
        this.imagePath = imagePath;
        this.basketArea = basketArea;

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel imageLabel = new JLabel(new ImageIcon(new ImageIcon(imagePath).getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH)));
        add(imageLabel);
        add(new JLabel(menuName));
        setPreferredSize(new Dimension(300, 350)); // 메뉴 크기 설정
        setVisible(true);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                showOptions();
            }
        });
    }

    private void showOptions() {
        JFrame optionFrame = new JFrame("옵션 선택");
        optionFrame.setSize(300, 200);
        optionFrame.setLayout(new GridLayout(2, 1));
        optionFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        optionFrame.setResizable(false);

        JButton setButton = new JButton("세트");
        JButton singleButton = new JButton("단품");

        setButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println(menuName + " 세트 선택됨");
                optionFrame.dispose();
            }
        });

        singleButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println(menuName + " 단품 선택됨");
                addToBasket(menuName);
                optionFrame.dispose();
            }
        });

        optionFrame.add(setButton);
        optionFrame.add(singleButton);
        optionFrame.setLocationRelativeTo(null);
        optionFrame.setVisible(true);
    }

    private void addToBasket(String itemName) {
        basketArea.add(new JLabel(itemName));
        basketArea.revalidate();
        basketArea.repaint();
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
