import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        // Please write your code here.

        gcd(n, m);
    }

    public static void gcd(int a, int b) {
        while(b != 0) {
            int r = a % b;

            a = b;
            b = r;
        }
        System.out.print(a);
    }
}