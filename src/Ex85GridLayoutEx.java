import javax.swing.*;
import java.awt.*;

public class Ex85GridLayoutEx extends JFrame {
    public Ex85GridLayoutEx() {
        super("GridLayout 예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container contentPane = getContentPane();
        Container.setLayout(null);

        contentPane.setLayout(new GridLayout(1, 10));

        for (int i = 1; i <= 10; i++) {
            String text = Integer.toString(i);
            JButton button = new JButton(text);
            contentPane.add(button);
        }
        setSize(500, 200);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Ex85GridLayoutEx();
    }
}
