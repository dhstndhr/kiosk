import javax.swing.*;
import java.awt.*;

public class Option extends JPanel {
    private JComboBox<String> sideMenu;
    private JComboBox<String> drinkMenu;
    private JButton confirmButton;

    public Option(Runnable onConfirm) {
        setLayout(new GridLayout(3, 2));

        String[] sideOptions = {"감자튀김", "치즈스틱"};
        String[] drinkOptions = {"콜라", "사이다"};

        sideMenu = new JComboBox<>(sideOptions);
        drinkMenu = new JComboBox<>(drinkOptions);
        confirmButton = new JButton("확인");

        confirmButton.addActionListener(e -> onConfirm.run());

        add(new JLabel("사이드 메뉴 선택:"));
        add(sideMenu);
        add(new JLabel("음료 선택:"));
        add(drinkMenu);
        add(new JLabel());
        add(confirmButton);
    }

    public String getSelectedSide() {
        return (String) sideMenu.getSelectedItem();
    }

    public String getSelectedDrink() {
        return (String) drinkMenu.getSelectedItem();
    }
}
