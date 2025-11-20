import javax.swing.*;
import java.awt.*;

public class Ex86NullContainerEx extends JFrame {
    public Ex86NullContainerEx() {
        setTitle("배치관리자 없이 절대 위치 배치하는 예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container contentPane = getContentPane();
        contentPane.setLayout(null); // 절대 위치 배치 관리자로 설정

        JLabel la = new JLabel("Hello, Press Buttons!");
        la.setLocation(130, 50);
        la.setSize(200, 20);
        contentPane.add(la);

        JButton btn1 = new JButton("Hello, Press Buttons!");
        btn1.setLocation(130, 20);
        btn1.setSize(200, 20);
        contentPane.add(btn1);

    
        /*for (int i = 1; i <= 9; i++) {
            JButton btn = new JButton(Integer.toString(i));
            btn.setLocation(i*15, i*15);
            btn.setSize(50, 20);
            contentPane.add(btn);*/
        setSize(300, 200);
        setVisible(true);
        }
        
    }
        public static void main(String[] args) {
        new Ex86NullContainerEx();
    }
}
