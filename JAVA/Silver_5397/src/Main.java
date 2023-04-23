import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();

        String input;
        while((input = br.readLine()) != null) {
            Stack<Character> left = new Stack<>();
            Stack<Character> right = new Stack<>();
            StringBuilder result = new StringBuilder();

            for (int i = 0; i < input.length(); i++) {
                if (input.charAt(i) == '<') {
                    if(left.size() == 0)
                        continue;
                    right.push(left.pop());
                    continue;
                } else if (input.charAt(i) == '>') {
                    if(right.size() == 0)
                        continue;
                    left.push(right.pop());
                    continue;
                } else if (input.charAt(i) == '-') {
                    if(left.size() == 0)
                        continue;
                    left.pop();
                    continue;
                }
                left.push(input.charAt(i));
            }
            for(char word : left) result.append(word);

            if (right.size() != 0) {
                while(right.size() != 0) result.append(right.pop());

            }
            System.out.println(result);
        }
        }
}
