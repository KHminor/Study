package chap_04;

public class _05_For {
    public static void main(String[] args) {
        // 반복문 For
        System.out.println("어서오세요. 나코입니다.");
        // 또 다른 손님이 들어오면?
        System.out.println("어서오세요. 안녕입니다.");
        
        // 반복문 사용 For
        for (int i = 1; i < 11; i++) {
            System.out.println("어서오세요. 나코입니다. "+ i);
        }

        // 짝수만 출력
        for (int i = 0; i < 10; i += 2) {
            System.out.print(i);
            System.out.print(" ");
        }
        System.out.println();
        // 홀수만 출력
        for (int i = 1; i < 10; i += 2) {
            System.out.print(i);
            System.out.print(" ");
        }

        System.out.println();
        // 거꾸로 숫자 출력 => 5,4,3,2,1
        for (int i = 5; i > 0; i--) {
            System.out.print(i);
            System.out.print(" ");
        }
        System.out.println();
        // 1부터 10까지의 누적합
        int hap = 0;
        for (int i = 1; i < 11; i++) {
            hap += i;
        }
        System.out.println(hap);
    }
}
