import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("../input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String s = br.readLine();

        int[] times = new int[26];

        for (int i = 0; i < s.length(); i++) {
            times[(int) s.charAt(i) - 97] += 1;
        }

        for (int i = 0; i < 26; i++) {
            sb.append(times[i]);
            sb.append(" ");
        }

        System.out.println(sb);
    }
}
