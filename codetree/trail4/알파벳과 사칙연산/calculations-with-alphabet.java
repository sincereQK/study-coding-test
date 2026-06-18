import java.util.*;
import java.io.*;

public class Main {
    static char[] expr;
    static List<Character> vars = new ArrayList<>();
    static Map<Character,Integer> val = new HashMap<>();
    static long answer = Long.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        expr = br.readLine().trim().toCharArray();

        Set<Character> seen = new LinkedHashSet<>();
        for (char ch : expr)
            if (ch >= 'a' && ch <= 'f') seen.add(ch);
        vars.addAll(seen);

        backtrack(0);
        System.out.println(answer);
    }


    static void backtrack(int idx) {
        if (idx == vars.size()) {
            answer = Math.max(answer, evaluate());
            return;
        }
        for (int v = 1; v <= 4; v++) {
            val.put(vars.get(idx), v);
            backtrack(idx + 1);
        }
    }

    static long evaluate() {
        long result = val.get(expr[0]);
        for (int i = 1; i < expr.length; i += 2) {
            char op = expr[i];
            long operand = val.get(expr[i + 1]);
            if (op == '+') result += operand;
            else if (op == '-') result -= operand;
            else if (op == '*') result *= operand;
        }
        return result;
    }
}