package chap_01;

public class _07_TypeCasting {
    public static void main(String[] args) {
        // 형 변환
        // int score = 93 + 98.8;

        // int to float, double
        int score = 93;
        System.out.println(score);
        System.out.println((float) score); // 형 변환하고자 하는 것을 소괄호() 안에 작성
        System.out.println((double) score);

        // float, double to int
        float score_f = 93.3F;
        double score_d = 98.8;
        System.out.println((int) score_f);
        System.out.println((int) score_d);

        // 정수 + 실수 연산
        score = 93 + (int) 98.8;
        System.out.println(score);
        score_d = (double) 93 + 98.8; // 실수 타입에 넣을 땐 정수는 double, float을 작성하지 않아도 실수로 자동 변경
        System.out.println(score_d);

        // 변수에 형변환 된 데이터 집어넣기
        double convertedScoreDouble = score;
        // int -> long -> float -> double (자동 형변환)

        int convertedScoreInt = (int) score_d;
        // double -> float -> long -> int (수동 형변환)

        // 숫자를 문자열로 변환시 클래스를 불러와야함.
        String s1 = String.valueOf(93);
        s1 = Integer.toString(93);
        System.out.println(s1);

        String s2 = String.valueOf(98.8);
        s2 = Double.toString(98.8);
        System.out.println(s2);

        // 문자열을 숫자로 변환
        int i = Integer.parseInt("93");
        System.out.println(i);
        double d = Double.parseDouble("98.8");
        System.out.println(d);

        /*int error = Integer.parseInt("자바");
        System.out.println(error);*/
    }
}
