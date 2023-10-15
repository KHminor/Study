package chap_03;

public class _02_String2 {
    public static void main(String[] args) {
        String s = "I like Java and Python and C.";

        // 문자열 변환
        System.out.println(s.replace(" and",","));
        // 문자열 슬라이싱?
        System.out.println(s.substring(s.indexOf("Java")));
        System.out.println(s.substring(s.indexOf("Java"), s.indexOf("."))); // 파이썬의 슬라이싱처럼 끝 인덱스 값은 포함 x

        s = "          I love Java           ";
        System.out.println(s);
        System.out.println(s.trim()); // 앞 뒤 공백 제거

        // 문자열 결합
        String s1 = "Java";
        String s2 = "Python";
        System.out.println(s1+","+s2);
        System.out.println(s1.concat(",").concat(s2));
    }
}
