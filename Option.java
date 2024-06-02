import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Option extends JPanel {
    private CardLayout cardLayout;
    private JPanel cardPanel;
    private final static int PANEL_WIDTH = 400;
    private final static int PANEL_HEIGHT = 500;
    String[] size = {"small", "regular", "large"};
    String[] sidedish = {"potatoChip", "chicken nugget", "cheese stick"};
    String[] beverage = {"coke", "sida"};
    JComboBox<String> option1;
    JComboBox<String> option2;
    String op1Data, op2Data;

    public Option() {
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);
        for (int i = 0; i < 3; i++) {
            init(i);
        }
    }

    void init(int i) {
        setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        JPanel buttonPanel = new JPanel();
        JButton btnCancel = new JButton("취소");
        JButton btnSelect = new JButton("확인");
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        btnSelect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                op1Data = (String) option1.getSelectedItem();
                op2Data = (String) option2.getSelectedItem();
            }
        });

        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(btnCancel);
        buttonPanel.add(btnSelect);
        add(buttonPanel, BorderLayout.SOUTH);

        if (i == 1) {
            option1 = new JComboBox<>(size);
            option2 = new JComboBox<>(beverage);
        } else if (i == 2) {
            option1 = new JComboBox<>(size);
            option2 = new JComboBox<>(sidedish);
        } else {
            option1 = new JComboBox<>(beverage);
            option2 = new JComboBox<>(size);
        }

        setLayout(new BorderLayout());
        add(option1, BorderLayout.CENTER);
        add(option2, BorderLayout.CENTER);
        setVisible(false);
    }

    public void showPage(String pageName) {
        cardLayout.show(cardPanel, pageName);
    }
}
