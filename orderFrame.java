import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class orderFrame extends JFrame {
    String[] pageName;
    int[] menuNum;
    Option hamOp, sideOp, beverOp;
    private static final int FRAME_WIDTH = 600;
    private static final int FRAME_HEIGHT = 800;

    public orderFrame() {
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        getContentPane().setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        pageName = new String[]{"HAMBURGER", "SIDEDISH", "BEVERAGE"};
        menuNum = new int[]{10, 10, 10};

        // 상단 버튼
        JPanel banner = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton btnHome = new JButton("홈으로");
        banner.add(btnHome);
        banner.setBackground(Color.red);

        // 메뉴 페이지 선택 버튼
        JPanel categoryArea = new JPanel(new GridLayout(1, 3));
        JLabel btnHamburger = new JLabel("햄버거");
        JLabel btnSidedish = new JLabel("사이드 메뉴");
        JLabel btnBeverage = new JLabel("음료수");
        categoryArea.add(btnHamburger);
        categoryArea.add(btnSidedish);
        categoryArea.add(btnBeverage);
        categoryArea.setBackground(Color.gray);

        // CardLayout을 사용한 페이지 전환 패널
        menuPage menuPage = new menuPage(pageName, menuNum);
        menuPage.setBounds(0, 95, FRAME_WIDTH, 500);

        btnHamburger.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                menuPage.showPage("HAMBURGER");
            }
        });
        btnSidedish.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                menuPage.showPage("SIDEDISH");
            }
        });
        btnBeverage.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                menuPage.showPage("BEVERAGE");
            }
        });

        // 장바구니
        JPanel basketArea = new JPanel(new FlowLayout(FlowLayout.CENTER));
        basketArea.setBackground(Color.white);

        // 결제 버튼
        JButton btnPay = new JButton("결제");

        // 위치 조정
        categoryArea.setBounds(0, 35, FRAME_WIDTH, 60);
        banner.setBounds(0, 0, FRAME_WIDTH, 35);
        menuPage.setBounds(0, 95, FRAME_WIDTH, 500);
        basketArea.setBounds(10, 600, FRAME_WIDTH - 120, 160);
        btnPay.setBounds(490, 630, 90, 120);

        // add로 추가하기
        getContentPane().add(banner);
        getContentPane().add(menuPage); // menuPage 추가
        getContentPane().add(basketArea);
        getContentPane().add(btnPay);
        getContentPane().add(categoryArea);

        // 홈 화면 패널
        JPanel homePanel = createHomePanel();
        homePanel.setBounds(0, 0, FRAME_WIDTH, FRAME_HEIGHT);
        getContentPane().add(homePanel);
        homePanel.setVisible(true);

        btnHome.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                menuPage.setVisible(false);
                categoryArea.setVisible(false);
                basketArea.setVisible(false);
                btnPay.setVisible(false);
                homePanel.setVisible(true);
            }
        });

        setVisible(true);
    }

    private JPanel createHomePanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        JButton startButton = new JButton("시작하기");
        panel.add(startButton);

        startButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                getContentPane().getComponent(0).setVisible(true);  // banner
                getContentPane().getComponent(1).setVisible(true);  // menuPage
                getContentPane().getComponent(2).setVisible(true);  // basketArea
                getContentPane().getComponent(3).setVisible(true);  // btnPay
                getContentPane().getComponent(4).setVisible(true);  // categoryArea
                panel.setVisible(false);
            }
        });

        return panel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new orderFrame();
            }
        });
    }
}

