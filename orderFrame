import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static java.awt.SystemColor.menu;
import static java.awt.SystemColor.text;

public class orderFrame extends JFrame{
    String[] pageName;
    int[] menuNum;
    Option hamOp,sideOp,beverOp;
    private static final int FRAME_WIDTH =600;
    private static final int FRAME_HEIGHT = 800;
    public orderFrame() {
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        getContentPane().setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        pageName = new String[]{"HAMBERGER", "SIDEDISH", "BEVERAGE"};
        menuNum = new int[]{10, 10, 10};

        //order page 만들기
        //상단 버튼
        JPanel banner = new JPanel(new FlowLayout(FlowLayout.LEFT));
        banner.add(new JButton("홈으로"));
        banner.setBackground(Color.red);

        //메뉴 페이지 선택 버튼
        JPanel categoryArea = new JPanel(new GridLayout(1,3));
        JLabel btnHamberger = new JLabel("햄버거");
        JLabel btnSidedish = new JLabel("사이드 메뉴");
        JLabel btnBeverage = new JLabel("음료수");
        categoryArea.add(btnHamberger,btnSidedish);
        categoryArea.add(btnSidedish);
        categoryArea.add(btnBeverage);
        categoryArea.setBackground(Color.gray);

        CardLayout cardLayout = new CardLayout();
        JPanel pagePanel = new JPanel(cardLayout);
        menuPage menuPage = new menuPage(pageName,menuNum);

        btnHamberger.addMouseListener(new MouseAdapter(){
            public void mouseClikced(MouseEvent e) {
                menuPage.showPage("HAMBURGER");
            }
        });
        btnSidedish.addMouseListener(new MouseAdapter(){
            public void mouseClikced(MouseEvent e) {
                menuPage.showPage("SIDEDISH");
            }
        });
        btnBeverage.addMouseListener(new MouseAdapter(){
            public void mouseClikced(MouseEvent e) {
                menuPage.showPage("BEVERAGE");
            }
        });

        //장바구니
        JPanel basketArea = new JPanel(new FlowLayout(FlowLayout.CENTER));
        basketArea.setBackground(Color.white);

        //결제버튼
        JButton btnPay = new JButton("결제");

        //위치조정
        categoryArea.setBounds(0,35,FRAME_WIDTH,60);
        banner.setBounds(0,0,FRAME_WIDTH,35);

        //menuArea.setBounds(0,120,FRAME_WIDTH,500);
        basketArea.setBounds(10,600,FRAME_WIDTH-120,160);
        //btnHome.setBounds(10,10,15,10);
        btnPay.setBounds(490,630,90,120);

        //add로 추가하기
        getContentPane().add(banner);
        getContentPane().add(menuPage);
        getContentPane().add(basketArea);
        getContentPane().add(btnPay);
        getContentPane().add(categoryArea);
        setVisible(true);
    }
    void basketPanel(){

    }
    void menuPanel(){

    }
}
