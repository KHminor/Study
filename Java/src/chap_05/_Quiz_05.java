package chap_05;
import java.util.Arrays;

public class _Quiz_05 {
    public static void main(String[] args) {
        // 신발 사이즈는 250 ~ 295까지 5단위로 증가
        // 신발 사이즈 수는 총 10가지
        String[][] shoes = new String[10][10];
        for (int i = 0; i < shoes.length; i++) {
            int size = 250;
            for (int j = 0; j < shoes[i].length; j++) {
                shoes[i][j] = "사이즈 " + size + " (재고 있음)";
                size += 5;
            }
        }
        System.out.println(Arrays.deepToString(shoes));
    }
}

// 메서드부터 이어하기