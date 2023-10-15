package chap_05;
import java.util.Arrays;

public class _05_ASCII {
    public static void main(String[] args) {
        // 아스키 코드 (ANSI): 미국 표준 코드
        char c = 'A';
        System.out.println(c);
        System.out.println((int) c);

        String[][] seats = new String[10][15];
        char ch = 'A';
        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[i].length; j++) {
                seats[i][j] = String.valueOf(ch) + (j+1);
            }
            ch++;
        }
        System.out.println(Arrays.deepToString(seats));
    }
}
