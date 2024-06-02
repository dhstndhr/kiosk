import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;


public class order extends JPanel { //장바구니 패널
    static final int MAX_SIZE = 100;
    ArrayList<Menu> orderList;
    Date today;
    static int orderNum =0;
    SimpleDateFormat form;
    static JPanel alermPanel;
    static JPanel basketPanel;
    public order() {
        init();
        today = new Date();
        orderList = new ArrayList<Menu>();
        form = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss a");
        //order 정보. form.format(today);
        add(alermPanel);
        add(basketPanel);
    }
    static void init(){
         JLabel noItems = new JLabel("no items in basket");
         JLabel yes = new JLabel("확인");
         alermPanel.setLayout(new FlowLayout());
         alermPanel.setSize(200,50);
         alermPanel.add(noItems,yes);
         alermPanel.setVisible(false);
         yes.addMouseListener(new MouseAdapter() {
             @Override
             public void mouseClicked(MouseEvent e) {
                 alermPanel.setVisible(false);
             }
         });
         basketPanel.setLayout(new GridLayout(10,1));
         basketPanel.setSize(500,100);

    }
    void goToPay(){
        if(orderList.size()!=0){
        //결제시스템으로 넘김
        }
        else{
            alermPanel.setVisible(true);

        }
    }
    Date getDate(){ //영수증 정보 확인
        return today;
    }
    void allCancel(){ //장바구니 내의 항목을 지움.

    }
    void showItems(){ // 장바구니 항목을 보여줌.

    }

}
