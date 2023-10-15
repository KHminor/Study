package chap_13;

public class _02_Output {
    public static void main(String[] args) {
        //System.out.format();
        //System.out.printf();

        System.out.println("----------- 정수 ------------");
        // System.out.printf("format", value);
        System.out.printf("%d%n", 1); // "%d": 정수 %n: 개행 -> \n을 하지 않은 건 OS적인 문제로 %n을 추천
        System.out.printf("%d %d %d%n", 1, 2, 3);
        System.out.printf("%d%n", 1234); // 1234
        System.out.printf("%6d%n", 1234); // __1234 즉, 숫자만큼 공간을 차지하도록 하기.
        System.out.printf("%06d%n", 1234); // 001234
        System.out.printf("%6d%n", -1234); // _-1234
        System.out.printf("%+6d%n", 1234); // _+1234 (항상 +- 기호 표시)
        System.out.printf("%,15d%n", 1000000000); // __1,000,000,000
        // 왼쪽 정렬
        System.out.printf("%-6d%n", 1234); // 1234__
        System.out.println();

        System.out.println("----------- 실수 ------------");
        System.out.printf("%f%n", Math.PI);
        System.out.printf("%.2f%n", Math.PI); // 3.14 소수점 둘 째자리까지 반올림해서 보이기
        System.out.printf("%6.2f%n", Math.PI); // __3.14
        System.out.printf("%-6.2f%n", Math.PI); // 3.14__
        System.out.printf("%06.2f%n", Math.PI); // 003.14
        System.out.printf("%+6.2f%n", Math.PI); // _+3.14
        System.out.printf("%+6.2f%n", -Math.PI); // _-3.14

        System.out.println("----------- 문자열 ------------");
        System.out.printf("%s%n", "Java"); // Java
        System.out.printf("%6s%n", "Java"); // __Java
        System.out.printf("%-6s%n", "Java"); // Java__
        System.out.printf("%6.2s%n", "Java"); // ____Ja  -> 문자열에서 .x 를 붙이면 x번 자리까지 출력을 의미
        System.out.printf("%.2s%n", "Java"); // Ja

        System.out.println("----------- 응용 ------------");
        System.out.println("이름 영어 수학 평균");
        System.out.println("강백호: " + 90 + " " + 80 + " " + 85.0); // 강백호 90 80 85.0
        System.out.println("서태웅: " + 100 + " " + 100 + " " + 100.0); // 서태웅 100 100 100.0
        System.out.println("채치수: " + 95 + " " + 100 + " " + 97.5); // 채치수 95 100 97.5

        System.out.println();
        System.out.println("이름      영어   수학   평균");
        System.out.printf("%-6s %4s %4s %6.1f %n", "강백호",90,80,85.0);
        System.out.printf("%-6s %4s %4s %6.1f %n", "서태웅",100,100,100.0);
        System.out.printf("%-6s %4s %4s %6.1f %n", "채치수",95,100,97.5);
    }
}
