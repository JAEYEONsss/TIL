import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int src = 1;
        int comp = 0;
        int fin = Integer.parseInt(br.readLine());
        int[] answer = new int[fin];
        StringBuilder result = new StringBuilder();
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < fin; i++) answer[i] = Integer.parseInt(br.readLine());

        while (src <= fin) {
            stack.push(src);
            result.append("+");
            if (stack.peek() == answer[comp]) {
                while (stack.peek() == answer[comp]) {
                    stack.pop();
                    result.append("-");
                    comp++;
                    if(stack.isEmpty())
                        break;
                }
            }
            src++;
        }

        if (!stack.isEmpty()) {
            System.out.println("NO");
            return;
        }

        for(int i = 0 ; i < result.length(); i++)
            System.out.println(result.charAt(i));
    }
}
