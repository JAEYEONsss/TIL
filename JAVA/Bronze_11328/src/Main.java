import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("/Users/yang/Desktop/ajou/4-1/자바코테/TIL/JAVA/Bronze_11328/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int times = Integer.parseInt(br.readLine());

        for (int i = 0; i < times; i++) {
            String[] temp = br.readLine().split(" ");
            String one = temp[0];
            String two = temp[1];
            int result = 0;
            char[] oneChar = new char[one.length()];
            char[] twoChar = new char[two.length()];

            if (oneChar.length == twoChar.length) {
                for (int j = 0; j < one.length(); j++) {
                    oneChar[j] = one.charAt(j);
                    twoChar[j] = two.charAt(j);
                }

                Arrays.sort(oneChar);
                Arrays.sort(twoChar);

                for (int j = 0; j < one.length(); j++) {
                    if (oneChar[j] != twoChar[j]) {
                        result = 1;
                        break;
                    }
                }

                if (result == 0)
                    System.out.println("Possible");
                else
                    System.out.println("Impossible");
            }
            else{
                System.out.println("Impossible");
            }
        }
    }
}
