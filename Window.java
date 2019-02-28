import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;

public class Window extends JFrame {
  int n = 10;

  public Window() {
    setTitle("Koch Fractal");
    setSize(400, 400);
    setResizable(false);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    add(new JPanel() {
      @Override public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Fractal.koch(0, 400.0 / 2, 400.0, 400.0 / 2, n, g);
        repaint();
      }
    });
    setVisible(true);
  }
}
