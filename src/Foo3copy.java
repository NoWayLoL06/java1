import java.util.Scanner;
public class Foo3copy {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("월(1-12)을 입력하시오:");
        int month = scanner.nextInt();
        if(month >= 3 && month <= 5){
            System.out.print("봄입니다.");
        }
        else if(month >= 6 && month <= 8){
            System.out.print("여름입니다.");
        }
        else if(month >= 9 && month <= 11){
            System.out.print("가을입니다.");
        }
        else if(month > 12){
            System.out.print("오류입니다.");
        }
        else{
            System.out.print("겨울입니다.");
        }         
        scanner.close();
    }


        

}
