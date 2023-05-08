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

        StringBuilder result = new StringBuilder();
        Deque<Integer> deque = new LinkedList<>();
        int times = Integer.parseInt(br.readLine());

        for (int i = 0; i < times; i++) {
            String[] input = br.readLine().split(" ");

            switch (input[0]) {
                case "push_front":
                    deque.offerFirst(Integer.parseInt(input[1]));
                    break;

                case "push_back":
                    deque.offerLast(Integer.parseInt(input[1]));
                    break;

                case "pop_front":
                    if(deque.isEmpty()){
                        result.append(-1).append("\n");
                        break;
                    }
                    else{
                        result.append(deque.pollFirst()).append("\n");
                        break;
                    }

                case "pop_back":
                    if(deque.isEmpty()){
                        result.append(-1).append("\n");
                        break;
                    }
                    else{
                        result.append(deque.pollLast()).append("\n");
                        break;
                    }

                case "size":
                    result.append(deque.size()).append("\n");
                    break;

                case "empty":
                    if(deque.isEmpty()){
                        result.append(1).append("\n");
                        break;
                    }
                    else{
                        result.append(0).append("\n");
                        break;
                    }

                case "front":
                    if(deque.isEmpty()){
                        result.append(-1).append("\n");
                        break;
                    }
                    else{
                        result.append(deque.peekFirst()).append("\n");
                        break;
                    }

                case "back":
                    if(deque.isEmpty()){
                        result.append(-1).append("\n");
                        break;
                    }
                    else{
                        result.append(deque.peekLast()).append("\n");
                        break;
                    }
            }
        }
        System.out.println(result);
    }
}
