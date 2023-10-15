package chap_06;

public class _02_Parameter {

    public static void power(int num) {
        int result = num*num;
        System.out.println(num + "의 2승은 " + result);
    }

    public static void powerByExp(int num, int exponent) {
        int result = 1;
        for (int i = 0; i < exponent; i++) {
            result *= num;
        }
        System.out.println(num + "의 " + exponent + "승은 " + result);
    }

    public static void main(String[] args) {
        // 전달값, Parameter
        power(3);
        powerByExp(2,3);
    }
}
