import javax.swing.*;

public class Ex81MyFrame extends JFrame {
  public Ex81MyFrame() {
    setTitle("300x300 스윙 프레임 만들기");
    setSize(300,300);
    setVisible(true);
  }

  public static void main(String[] args) {
    javax.swing.SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        new Ex81MyFrame();
      }
    });
  }
}