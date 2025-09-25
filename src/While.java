import java.util.Scanner;
public class While {
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);

        int count = 0, sum = 0, inputNum = 0;
        System.out.println("정수를 입력하고 마지막에 0을 입력하시요.");
        while ((inputNum = scanner.nextInt()) != 0) 
        {
            count++;
            sum += inputNum;
        }
        System.out.println("입력한 정수의 개수: " + count);
        System.out.println("입력한 정수의 평균: " + sum/count);
        scanner.close();
    }
}
