import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        String[] pos = br.readLine().split(" ");
        int cnt = 0;
        int result = 0;

        LinkedList<Integer> deque = new LinkedList<>();

        for(int i = 1; i <= Integer.parseInt(input[0]); i++)
            deque.offer(i);

        while (cnt < Integer.parseInt(input[1])) {
            if (deque.peekFirst() == Integer.parseInt(pos[cnt])) {
                deque.pollFirst();
                cnt++;
            }
            else{
                int left = deque.indexOf(Integer.parseInt(pos[cnt]));
                int right = Math.abs(deque.size() - left);

                if (left <= right) {
                    Integer remain = deque.pollFirst();
                    deque.offer(remain);
                    result++;
                }
                else{
                    Integer remain = deque.pollLast();
                    deque.offerFirst(remain);
                    result++;
                }
            }
        }
        System.out.println(result);
        }
}
