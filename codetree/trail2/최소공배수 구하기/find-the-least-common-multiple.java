import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        // Please write your code here.

        System.out.print(lcm(n,m));
    }

    public static int gcd(int a, int b) {

        while (b != 0) {
            int r = a % b;
            
            // gcd(a,b) = gcd(b,r)
            a = b;
            b = r;
        }

        return a;
    }

    public static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }
}