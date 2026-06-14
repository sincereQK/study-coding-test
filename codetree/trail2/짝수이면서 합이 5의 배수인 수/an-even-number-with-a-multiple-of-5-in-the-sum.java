import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        check(N);
    }

    public static void check(int n) {
        if (n % 2 == 0) {
            int a = n % 10;
            int b = (n / 10) % 10;
            int sum = a + b;
            if (sum % 5 == 0) {
                System.out.print("Yes");

            } else {
                System.out.print("No");
            }
        } else {
            System.out.print("No");
        }
    }
}