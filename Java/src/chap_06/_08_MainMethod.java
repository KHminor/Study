package chap_06;

import java.util.Arrays;

public class _08_MainMethod {
    public static void main(String[] args) {
        // Edit Configuration -> 해당 파일에 대한 파라미터 값을 넣어주면 args에서 값을 가져올 수 있다.
        System.out.println(Arrays.deepToString(args));
        if (args.length == 1) {
            switch (args[0]) {
                case "1":
                    System.out.println("도서 조회 메뉴입니다.");
                    break;
                case "2":
                    System.out.println("도서 대출 메뉴입니다.");
                    break;
                case "3":
                    System.out.println("도서 반납 메뉴입니다.");
                    break;
                default:
                    System.out.println("잘못 입력하셨습니다.");
            }
        } else {
            System.out.println("(사용법) 1~3 메뉴 중 하나를 입력하세요.");
        }

    }
}
