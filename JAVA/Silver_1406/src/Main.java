import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("/Users/yang/Desktop/ajou/4-1/자바코테/TIL/JAVA/Silver_1406/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<Character> left = new Stack<>();
        Stack<Character> right = new Stack<>();

        String init = br.readLine();

        for (int i = 0; i < init.length(); i++) {
            left.push(init.charAt(i));
        }

        br.readLine();

        String input;
        while ((input = br.readLine()) != null) {
            if (input.charAt(0) == 'L') {
                if(left.size() == 0)
                    continue;
                right.push(left.pop());
            } else if (input.charAt(0) == 'D') {
                if(right.size() == 0)
                    continue;
                left.push(right.pop());
            } else if (input.charAt(0) == 'B') {
                if (left.size() == 0)
                    continue;
                left.pop();
            } else {
                left.push(input.charAt(2));
            }
        }

        StringBuilder result = new StringBuilder();

        while (left.size() != 0) {
            result.append(String.valueOf(left.pop()));
        }
        result.reverse();
        while (right.size() != 0) {
            result.append(String.valueOf(right.pop()));
        }

        System.out.println(result);
    }
}
