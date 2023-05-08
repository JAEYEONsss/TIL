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
        long cnt = 0;

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < times; i++) {
            int height = Integer.parseInt(br.readLine());

            if (stack.size() == 0) {
                stack.push(height);
                continue;
            }

            while (stack.peek() <= height) {
                stack.pop();
                if(stack.isEmpty())
                    break;
            }

            stack.push(height);
            cnt += (stack.size() -1);
        }
        System.out.println(cnt);
    }
}
