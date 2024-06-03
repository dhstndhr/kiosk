import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class orderFrame extends JFrame {
    String[] pageName;
    int[] menuNum;
    private static final int FRAME_WIDTH = 600;
    private static final int FRAME_HEIGHT = 800;
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private order basketPanel;
    private menuPage menuPagePanel;

    public orderFrame() {
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        getContentPane().setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        pageName = new String[]{"HAMBURGER", "SIDEDISH", "BEVERAGE"};
        menuNum = new int[]{2, 2, 2};

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

        // 장바구니
        basketPanel = new order();
        JScrollPane basketScrollPane = new JScrollPane(basketPanel);
        basketScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        basketScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        // 결제 버튼
        JButton btnPay = new JButton("결제");

        // 위치 조정
        categoryArea.setBounds(0, 35, FRAME_WIDTH, 60);
        banner.setBounds(0, 0, FRAME_WIDTH, 35);
        mainPanel.setBounds(0, 95, FRAME_WIDTH, 500);
        basketScrollPane.setBounds(10, 600, FRAME_WIDTH - 120, 160);
        btnPay.setBounds(490, 630, 90, 120);

        // 메뉴 페이지 패널
        menuPagePanel = new menuPage(pageName, menuNum, basketPanel, mainPanel, cardLayout);
        mainPanel.add(menuPagePanel, "menuPanel");

        // 홈 화면 패널
        JPanel homePanel = createHomePanel();
        homePanel.setBounds(0, 0, FRAME_WIDTH, FRAME_HEIGHT);
        mainPanel.add(homePanel, "homePanel");
        cardLayout.show(mainPanel, "homePanel");

        // add로 추가하기
        getContentPane().add(banner);
        getContentPane().add(mainPanel); // mainPanel 추가
        getContentPane().add(basketScrollPane);
        getContentPane().add(btnPay);
        getContentPane().add(categoryArea);

        // 이벤트 리스너
        btnHome.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                basketPanel.clearOrder(); // 장바구니 비우기
                cardLayout.show(mainPanel, "homePanel"); // 홈 화면으로 이동
            }
        });

        btnHamburger.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                showMenuPage("HAMBURGER");
            }
        });
        btnSidedish.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                showMenuPage("SIDEDISH");
            }
        });
        btnBeverage.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                showMenuPage("BEVERAGE");
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
                cardLayout.show(mainPanel, "menuPanel");
            }
        });

        return panel;
    }

    private void showMenuPage(String pageName) {
        cardLayout.show(mainPanel, "menuPanel");
        menuPagePanel.showPage(pageName);
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
