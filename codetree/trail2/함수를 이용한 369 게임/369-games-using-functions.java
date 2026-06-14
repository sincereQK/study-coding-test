import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        int B = sc.nextInt();

        int result = count369(A, B);

        System.out.print(result);
    }

    public static int count369(int a, int b) {
        int count = 0;

        for (int i = a; i <= b; i++) {
            if (i % 3 == 0) {
                count++;
            } else {
                int num = i;
                while (num > 0) {
                    int digit = num % 10;
                    if (digit == 3 || digit == 6 || digit == 9) {
                        count++;
                        break;
                    } else {
                        num /= 10;
                    }
                }
            }
        }

        return count;
    }
}