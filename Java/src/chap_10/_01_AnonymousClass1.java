package chap_10;

public class _01_AnonymousClass1 {
    public static void main(String[] args) {
        // 익명 클래스
        Coffee c1 = new Coffee();
        c1.order("아메리카노");
        System.out.println("====================");

        Coffee c2 = new Coffee();
        c2.order("라떼");
        System.out.println("====================");

        // 익명 클래스 사용, 해당 클래스에 있는 메서드를 재정의할 수 있다.
        Coffee specialCoffee = new Coffee() {
            @Override
            public void order(String coffee) {
                super.order(coffee);
                System.out.println("서비스 추가요");
            }
        };
        specialCoffee.order("딸기 라떼");
    }
}

class Coffee {
    public void order(String coffee) { // void를 적는 이유는 return 값이 없기에.
        System.out.println("주문하신 " + coffee + "가 나왔습니다.");
    }
}
