import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("/Users/yang/Desktop/ajou/4-1/자바코테/TIL/JAVA/Bronze_1919/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] one = br.readLine().toCharArray();
        char[] two = br.readLine().toCharArray();
        int[] oneAlpha = new int[26];
        int[] twoAlpha = new int[26];
        int result = 0;

        for(int i : one) oneAlpha[i - 97] += 1;
        for(int j : two) twoAlpha[j - 97] += 1;

        for (int i = 0; i < 26; i++) {
            int minus = Math.abs(oneAlpha[i] - twoAlpha[i]);
            result += minus;
        }

        System.out.println(result);
    }
}
