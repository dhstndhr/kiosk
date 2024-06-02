import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class order extends JPanel {
    static final int MAX_SIZE = 100;
    ArrayList<Menu> orderList;
    Date today;
    static int orderNum = 0;
    SimpleDateFormat form;
    static JPanel alermPanel = new JPanel();
    static JPanel basketPanel = new JPanel();

    public order() {
        init();
        today = new Date();
        orderList = new ArrayList<>();
        form = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss a");
        add(alermPanel);
        add(basketPanel);
    }

    static void init() {
        JLabel noItems = new JLabel("no items in basket");
        JLabel yes = new JLabel("확인");
        alermPanel.setLayout(new FlowLayout());
        alermPanel.setSize(200, 50);
        alermPanel.add(noItems);
        alermPanel.add(yes);
        alermPanel.setVisible(false);
        yes.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                alermPanel.setVisible(false);
            }
        });
        basketPanel.setLayout(new GridLayout(10, 1));
        basketPanel.setSize(500, 100);
    }

    void goToPay() {
        if (orderList.size() != 0) {
            // 결제 시스템으로 넘김
        } else {
            alermPanel.setVisible(true);
        }
    }

    Date getDate() {
        return today;
    }

    void allCancel() {
        // 장바구니 내의 항목을 지움.
    }

    void showItems() {
        // 장바구니 항목을 보여줌.
    }
}
