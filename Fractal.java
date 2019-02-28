import java.awt.Graphics;

public class Fractal {
  private static double[] spin(double cx, double cy, double ax, double ay, double angle) {
    double[] result = new double[2];

    result[0] = ((ax - cx) * Math.cos(angle) + (ay - cy) * Math.sin(angle)) + cx;
    result[1] = ((ay - cy) * Math.cos(angle) - (ax - cx) * Math.sin(angle)) + cy;

    return result;
  }

  public static void koch(double px, double py, double qx, double qy, int n, Graphics g) {
    if(n == 0) {
      g.drawLine((int)px, (int)py, (int)qx, (int)qy);
    }
    else {
      double rx = (1 - 1.0 / 3.0) * px + (1.0 / 3.0) * qx;
      double ry = (1 - 1.0 / 3.0) * py + (1.0 / 3.0) * qy;
      double sx = (1 - 2.0 / 3.0) * px + (2.0 / 3.0) * qx;
      double sy = (1 - 2.0 / 3.0) * py + (2.0 / 3.0) * qy;

      double[] t = spin(rx, ry, sx, sy, Math.PI / 3.0);

      koch(px, py, rx, ry, n - 1, g);
      koch(rx, ry, t[0], t[1], n - 1, g);
      koch(t[0], t[1], sx, sy, n - 1, g);
      koch(sx, sy, qx, qy, n - 1, g);
    }
  }
}
