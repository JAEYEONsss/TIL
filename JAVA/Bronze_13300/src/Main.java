import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("/Users/yang/Desktop/ajou/4-1/자바코테/TIL/JAVA/Bronze_13300/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] memberInfo = br.readLine().split(" ");

        int total = Integer.parseInt(memberInfo[0]);//총 학생 수
        int maxNum = Integer.parseInt(memberInfo[1]);//방에 들어갈 수 있는 애들 max
        int result = 0;
        int[] man = new int[6];
        int[] woman = new int[6];

        for (int i = 0; i < total; i++) {
            String[] temp = br.readLine().split(" ");
            int sex = Integer.parseInt(temp[0]);
            int num = Integer.parseInt(temp[1]);

            if(sex == 0) woman[num-1] += 1;
            else man[num-1] += 1;
        }

        for (int i = 0; i < 6; i++) {
            int tempMan = man[i];
            int tempWoman = woman[i];

            while (tempMan > 0) {
                tempMan -= maxNum;
                result += 1;
            }

            while (tempWoman > 0) {
                tempWoman -= maxNum;
                result += 1;
            }
        }

        System.out.println(result);
    }
}
