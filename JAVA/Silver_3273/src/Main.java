import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int times = Integer.parseInt(br.readLine());

        String[] num = br.readLine().split(" ");
        int target = Integer.parseInt(br.readLine());
        int[] realNum = new int[times];
        int numbers = 0;
        int result = 0;

        for (int i = 0; i < times; i++) {
            realNum[i] = Integer.parseInt(num[i]);
        }

        Arrays.sort(realNum);//이렇게 사용하면 배열 자체가 정렬되고, 다른 배열에 할당할 필요가 없음

        int left = 0;
        int right = times - 1;

        while (left < right) {
            int sum = realNum[left] + realNum[right];
            if (sum <= target) {
                if(sum == target)
                    result += 1;
                left += 1;
            }
            else{
                right -= 1;
            }
        }

        System.out.println(result);
    }
}
