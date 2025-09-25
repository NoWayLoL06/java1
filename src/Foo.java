public class Foo {
    public static void main(String[] args){
        int a = 3, b = 3, c = 3;
        
        // b = 3, a = 4
        b = a++;
        System.out.println(b + " / " + a);
        // a = 4, b = 4
        a = ++b;
        System.out.println(a + " / " + b);
        // a = 3, c = 2
        a = c--;
        System.out.println(a + " / " + c);
        // b = 1, c = 1
        b = --c;
        System.out.println(b + " / " + c);
    }


        

}
