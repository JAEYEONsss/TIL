import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Deque<Integer> deque = new LinkedList<>();
        int times = Integer.parseInt(br.readLine());

        for(int i = 1; i<=times; i++)
            deque.offer(i);

        while (deque.size() > 1) {
            deque.pollFirst();

            Integer top = deque.pollFirst();
            deque.offer(top);
        }

        System.out.println(deque.peek());
        }
}
