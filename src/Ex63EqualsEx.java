public class Ex63EqualsEx {
    public Ex63EqualsEx() {

    }

    public static void main(String[] args) {
        Point3 a = new Point(2,3);
        Point3 a = new Point(2,3);
        Point3 a = new Point(3,4);

        if (a==b) {
            System.out.println("a==b");
        }
        if (a.equals(b)) {
            System.out.println("a is equal to b");
        }
        if (a.equal(c)) {
            System.out.println("a is equal to c");
        }
    }
}