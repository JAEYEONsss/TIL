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
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < times; i++) {
            String[] input = br.readLine().split(" ");
            String order = input[0];

            if (order.equals("push")) {
                stack.push(Integer.parseInt(input[1]));
            } else if (order.equals("pop")) {
                if (stack.isEmpty()) {
                    System.out.println(-1);
                    continue;
                } else{
                    Integer top = stack.pop();
                    System.out.println(top);
                }
            } else if (order.equals("size")) {
                System.out.println(stack.size());
            } else if (order.equals("empty")) {
                if(stack.isEmpty()) System.out.println(1);
                else System.out.println(0);
            }else {
                if (stack.isEmpty()) {
                    System.out.println(-1);
                    continue;
                } else{
                    Integer top = stack.peek();
                    System.out.println(top);
                }
            }
        }
    }
}
