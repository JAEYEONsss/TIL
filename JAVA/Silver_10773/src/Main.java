import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int times = Integer.parseInt(br.readLine());
        int sum = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < times; i++) {
            int num = Integer.parseInt(br.readLine());

            if (num == 0) {
                if(stack.isEmpty())
                    continue;
                stack.pop();
                continue;
            }
            stack.push(num);
        }

        while (!stack.isEmpty()) {
            Integer num = stack.pop();
            sum += num;
        }

        System.out.println(sum);
    }
}
