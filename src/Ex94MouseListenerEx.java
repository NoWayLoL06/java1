import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Ex94MouseListenerEx extends JFrame {
    private JLabel la = new JLabel("Hello");

    public Ex94MouseListenerEx() {
        setTitle("Mouse 이벤트 예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.addMouseListener(new MyMouseListener());
        
        c.setLayout(null);
        la.setSize(50, 20);
        la.setLocation(30, 30);
        c.add(la);

        setSize(200, 200);
        setVisible(true);
    }
}
