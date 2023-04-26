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

        Deque<Integer> queue = new LinkedList<>();
        int times = Integer.parseInt(br.readLine());

        for (int i = 0; i < times; i++) {
            String[] input = br.readLine().split(" ");
            if (input[0].equals("push")) {
                queue.offer(Integer.parseInt(input[1]));
            } else if (input[0].equals("pop")) {
                if (queue.isEmpty()) {
                    System.out.println(-1);
                    continue;
                }
                System.out.println(queue.poll());
            } else if (input[0].equals("size")) {
                System.out.println(queue.size());
            } else if (input[0].equals("empty")) {
                if(queue.isEmpty())
                    System.out.println(1);
                else
                    System.out.println(0);
            } else if (input[0].equals("front")) {
                Integer front = queue.peek();
                if(front == null)
                    System.out.println(-1);
                else{
                    System.out.println(front);
                }
            }else{
                if (queue.isEmpty()) {
                    System.out.println(-1);
                }else{
                    System.out.println(queue.peekLast());
                }
            }
        }
    }
}
