import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        Queue<Integer> queue = new LinkedList<>();
        StringBuilder result = new StringBuilder();

        for(int i =1; i<= n; i++)
            queue.offer(i);

        result.append("<");

        while (queue.size() != 1) {
            for (int i = 1; i < k; i++) queue.offer(queue.poll());
            result.append(queue.poll());
            result.append(", ");
        }
        result.append(queue.poll() + ">");

        System.out.println(result);
    }
}
