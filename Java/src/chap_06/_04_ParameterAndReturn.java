package chap_06;

public class _04_ParameterAndReturn {

    // 개행 맞추기: control + Alt + L

    public static int getPower(int num) {
        return num * num;
    }

    public static int powerByExp(int num, int exponent) {
        int result = 1;
        for (int i = 0; i < exponent; i++) {
            result *= num;
        }
        return result;
    }

    public static void main(String[] args) {
        // 전달값과 반환값이 함께 있는 메서드
        System.out.println(getPower(4));
        System.out.println(powerByExp(2, 3));
    }
}
