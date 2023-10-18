package algo;

import java.io.*;
import java.util.StringTokenizer;

public class 상수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] li = new int[2];
        int x = 0;
        while (st.hasMoreTokens()) {
            String num = st.nextToken();
            String reverse = "";

            for (int i = num.length()-1; i >= 0; i--) {
                reverse += num.charAt(i);
            }
            li[x] = Integer.parseInt(reverse);
            x++;
        }
        if (li[0] > li[1]) System.out.println(li[0]);
        else System.out.println(li[1]);
    }
}
