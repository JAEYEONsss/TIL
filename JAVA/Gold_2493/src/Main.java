import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class Top{
    int num;//top 인덱스
    int height;//top 높이

    public Top(int num, int height) {
        this.num = num;
        this.height = height;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int times = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        Stack<Top> stack = new Stack<>();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < times; i++) {
            int height = Integer.parseInt(input[i]);

            if (stack.isEmpty()) {
                result.append("0 ");
                stack.push(new Top(i + 1, height));
            }
            else{
                while (true) {
                    if (stack.isEmpty()) {
                        result.append("0 ");
                        stack.push(new Top(i + 1, height));
                        break;
                    }

                    Top top = stack.peek();

                    if (top.height > height) {
                        result.append(String.valueOf(top.num) + " ");
                        stack.push(new Top(i + 1, height));
                        break;
                    }else{
                        stack.pop();
                    }
                }
            }
        }
        System.out.println(result);
    }
}