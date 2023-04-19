import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException{
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] times = new int[10];

        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());
        int result = a * b * c;

        String answer = Integer.toString(result);
        char c1 = '0';

        for (int i = 0; i < answer.length(); i++) {
            times[(int) answer.charAt(i) - 48] += 1;
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(times[i]);
        }
    }
}
