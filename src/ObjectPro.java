class Point {
    private int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class ObjectPro {
    public static void main(String[] args) {
        Point p = new Point(2, 3);
        System.out.println("p.toString(): " + p.toString());
        System.out.println("p.hashCode(): " + p.hashCode());
        System.out.println("p.getClass().getName(): " + p.getClass().getName());
    }
}
