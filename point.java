import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.*;
public class Point extends JPanel {

    private Map<String, Integer> customerData;
    private String[] phoneNumData; //입력받은 전화번호 data
    private double rate; //할인 비율
    private JPanel PointPanel; //메인 패널
    private JPanel keypad;
    private JTextField displayNum; //고른 숫자를 보여줌

    public Point(double rate){
        this.rate = rate;
        BorderLayout borderLayout = new BorderLayout();
        PointPanel = new JPanel();
        init(); // 전체 panel 생성하고 pointPanel에 붙이기
    }
    void init(){
        customerData = new HashMap<>();

        phoneNumData = new String[11]; //01012345678 전화번호 들어갈 배열 초기화

        //숫자 화면 setting
        displayNum = new JTextField();
        displayNum.setEditable(false);
        PointPanel.add(displayNum,BorderLayout.NORTH);

        //숫자 키패드 만들기
        GridLayout gridLayout = new GridLayout(4,3);
        keypad = new JPanel(gridLayout);
        for(int i =1; i<10; i++) {
            Button(keypad,String.valueOf(i));
         }
        keypad.add(new JButton());
        keypad.add(new JButton("0"));
        keypad.add(new JButton());

        //취소, 확인 버튼
        JButton cancel = new JButton("취소");
        JButton getNumber = new JButton("확인");
        getNumber.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });


        //전체 패널에 붙이기
        PointPanel.add(keypad,BorderLayout.CENTER);
        PointPanel.add(cancel,BorderLayout.NORTH);
        PointPanel.add(getNumber,BorderLayout.NORTH);
        add(PointPanel);
    }
    void Button(JPanel buttonPanel, String txt){
        JButton btn = new JButton(txt);
        btn.addActionListener(new ButtonClickListener());
        buttonPanel.add(btn);
    }
    private class ButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String num = e.getActionCommand(); // 클릭된 버튼의 텍스트 가져오기
            displayNum.setText(displayNum.getText() + num); // 기존 텍스트에 클릭된 버튼의 텍스트 추가
            try{
                phoneNumData[11-phoneNumData.length] = num;
            }
            catch (Exception err){
                throw err;
            }
        }
    }
    private class ConfirmButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
                //if(isUser(phoneNum)){
                //  setPoint(rate*price);
                //}point출력
                //else{
            //      Cutomers[phoneNum] = rate*price;
            //    }
            }
    }

}
