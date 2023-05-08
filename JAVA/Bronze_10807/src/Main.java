import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int times = Integer.parseInt(br.readLine());
        String[] temp = br.readLine().split(" ");
        int target = Integer.parseInt(br.readLine());
        int result = 0;

        int[] number = new int[times];

        for (int i = 0; i < times; i++) {
            number[i] = Integer.parseInt(temp[i]);
        }
        Arrays.sort(number);

        int left = 0;
        int right = times - 1;

        while (left <= right) {

            if(number[left] == target)
                result += 1;

            if(number[right] == target) {
                if(left != right)
                    result += 1;
            }

            left += 1;
            right -= 1;
        }

        System.out.println(result);
    }
}
