package chap_13;
import java.util.Scanner;

public class _01_Input {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // 사용자로부터 바로 입력받기
        /*System.out.println("이름을 입력하세요.");
        String name = sc.next();
        System.out.println(name);

        // int height = sc.next(); // 에러가 발생하는 이유는 sc.next()는 String을 반환하기 때문.
        int height = Integer.parseInt(sc.next());
        int height2 = sc.nextInt(); // 위와 같이 String 타입으로 sc.next()를 받지 않고, 정수로 받는 방법
        System.out.println(height2);

        double weight = sc.nextDouble();*/

        // sc.next()는 띄워쓰기를 기준으로 분리하여 입력을 받기에, 한 단어를 충족하면 다음 sc.next()가 나오기까지 대기
        // sc.nextLine()은 한 문장을 받을 수 있음.
        System.out.println("어떤 프로그래밍 언어를 배웠나요?");
        //String lang = sc.next(); // 의도: 한 단어
        String lang = sc.nextLine(); // 의도: 한 문장
        System.out.println("언어: " + lang);

        // 만약 sc.next(); 를 사용한 뒤, 불필요한 남은 문장을 삭제하고자 한다면
        // sc.nextLine()을 실행하게 되면 남은 문장은 삭제가 된다.

        System.out.println("배우고 나니 기분은?");
        // String feeling = sc.next(); // 의도: 한 문장
        String feeling = sc.nextLine(); // 의도: 한 문장
        System.out.println("기분: " + feeling);
    }
}
