package chap_03;

public class _03_StringCompare {
    public static void main(String[] args) {
        // 문자열 비교
        String s1 = "Java";
        String s2 = "Python";

        System.out.println(s1.equals("Java")); // 두 문자열의 값이 같은지, 다른지 비교 (true,false)
        System.out.println(s1.equals(s2));
        System.out.println(s2.equals("python")); // 대소문자 비교 가능, 강한 비교
        System.out.println(s2.equalsIgnoreCase("python")); // 대소문자 비교 X , 약한 비교

        // 문자열 비교 심화 (주솟값 비교)

        // 아래는 같은 값이기에 그냥 같은 것을 참조하여 저장
        s1 = "1234";
        s2 = "1234";
        System.out.println(s1.equals(s2)); // true
        System.out.println(s1 == s2); // true

        // 아래는 같은 값이지만 새로운 객체를 생성하여 값을 전하기에 서로 다른 주소값을 가지게 됨
        s1 = new String("1234");
        s2 = new String("1234");
        System.out.println(s1.equals(s2)); // true, 값이 같은지를 비교하는 것이기에 true
        System.out.println(s1 == s2); // false, 완전히 같은지를 비교하는 것이기에 false
    }
}
