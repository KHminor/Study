package chap_05;
import java.util.Arrays;

public class _01_Array {
    public static void main(String[] args) {
        // 배열: 같은 자료형의 값 여러 개를 저장하는 연속된 공간
        // 배열 선언 첫 번째 방법
        // String[] coffees = new String[4]; // 크기 4의 String 타입의 값을 담을 배열

        // 두 번째 방법
        // String coffees2[] = new String[4];
        // coffees[0] = "아메리카노";

        // 세 번째 방법
        // String[] coffees = new String[] { "아메리카노", "카페모카", "라떼", "카푸치노"};

        // 네 번째 방법
        String[] coffees = { "아메리카노", "카페모카", "라떼", "카푸치노"};

        // 커피 주문
        for (int i = 0; i < coffees.length; i++) {
            System.out.println(coffees[i] + " 하나");
        }

        // 값 변경
        coffees[1] = "에스프레소";

        // 다른 자료형
        int[] test = {1, 2, 3};
        double[] d = {10.0, 11.2, 13.5};
        // 배열 자체를 출력하고 싶을 경우
        // import java.util.Arrays; 로 Arrays를 가져온 다음 toString() 메서드로 변환 후 출력이 가능하다.
        System.out.println(Arrays.toString(test));
        System.out.println(d);

    }
}
