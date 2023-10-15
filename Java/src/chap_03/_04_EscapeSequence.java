package chap_03;

public class _04_EscapeSequence {
    public static void main(String[] args) {
        // 특수문자, 이스케이프 문자 (Escape Sequence, Escape Character, Special Character)
        // \n, \t, \\, \", \'
        System.out.println("자바가");
        System.out.println("너무");
        System.out.println("재미있어요");

        // \n: 줄바꿈, \t: 탭키, \\: 역슬래쉬, \": 큰따옴표, \': 작은따옴표
        System.out.println("자바가\n너무\n재미있어요");
        System.out.println("해물파전\t9000원");
        System.out.println("김치전\t9000원");
        System.out.println("부추전\t9000원");
        System.out.println("C:\\Program Files\\Java");
        System.out.println("단비가 \"냐옹\"이라고 했어요");
        System.out.println("단비가 \'냐옹\'이라고 했어요");
        System.out.println("단비가 '냐옹'이라고 했어요");

        char c = 'A';
        c = '\'';
        System.out.println(c);
    }
}
