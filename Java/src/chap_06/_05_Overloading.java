package chap_06;

public class _05_Overloading {

    public static int getPower(int num) {
        return num * num;
    }

    public static int getPower(String strNum) {
        int num = Integer.parseInt(strNum);
        return num*num;
    }

    public static int getPower(int num, int exponent) {
        int result = 1;
        for (int i = 0; i < exponent; i++) {
            result *= num;
        }
        return result;
    }

    public static void main(String[] args) {
        // 메서드 오버로딩
        // 반환형이 다른 메서드의 경우엔 x
        System.out.println(getPower(3));
        System.out.println(getPower("5"));
        System.out.println(getPower(3,5));
    }
}
