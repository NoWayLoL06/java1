import javax.swing.*;
import java.awt.*;

public class Ex82ContentPanelEx extends JFrame {
    public Ex82ContentPanelEx() {
        setTitle("ContentPane과 JFrame 예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container contentPane = getContentPane();
        contentPane.setBackground(Color.ORANGE);
        contentPane.setLayout(new FlowLayout(FlowLayout.LEFT, 30, 40));

        contentPane.add(new JButton("OK"));
        contentPane.add(new JButton("Cancel"));
        contentPane.add(new JButton("Ignore"));

        setSize(300, 150);
        setVisible(true);
}
    public static void main(String[] args) {
        new Ex82ContentPanelEx();
    }
}