package chap_09;

import chap_09.coffee.*;
import chap_09.user.User;
import chap_09.user.VIPUser;

public class _02_GenericClass {
    public static void main(String[] args) {
        // 제네릭 클래스
        CoffeeByNumber c1 = new CoffeeByNumber(33);
        CoffeeByNickname c2 = new CoffeeByNickname("유재석");
        c1.ready();
        c2.ready();

        System.out.println("================");

        CoffeeByName c3 = new CoffeeByName(34);
        CoffeeByName c4 = new CoffeeByName("박명수");
        c3.ready();
        c4.ready();

        System.out.println("================");
        //int c3Name = c3.name; // 현재 int가 들어와야 하는데 Object 타입이 들어와서 에러
        int c3Name = (int) c3.name;
        String c4Name = (String) c4.name;
        System.out.println(c3Name);
        System.out.println(c4Name);

        // c4Name = (String) c3.name; // <- 코드를 실행해야 정수를 문자로 형변환할 수 없다고 에러가 발생

        System.out.println("================");

        // Coffee<자료형>
        Coffee<Integer> c5 = new Coffee<>(35);
        Coffee<String> c6 = new Coffee<>("조세호");
        c5.ready();
        c6.ready();

        // 위에서 Coffee<타입>을 지정해줬기에 변수를 생성시에도 형변환이 필요없으며, 에러를 바로 확인할 수 있다.
        int c5Name = c5.name;
        String c6Name = c6.name;

        System.out.println("================");

        CoffeeByUser<User> c7 = new CoffeeByUser<>(new User("강호동"));
        CoffeeByUser<User> c8 = new CoffeeByUser<>(new VIPUser("서장훈"));
        c7.ready();
        c8.ready();

        System.out.println("================");
        // User를 상속하지 않는 클래스를 CoffeeByUser에 넣을 경우 아래와 같이 에러가 발생.
        // CoffeeByUser<User> c9 = new CoffeeByUser<>(new BlackBox());

        System.out.println("================");
        orderCoffee("김영철");
        orderCoffee(36);

        orderCoffee("김희철", "아메리카노");
        orderCoffee(37, "아메리카노");
    }

    public static <T> void orderCoffee(T name) {
        System.out.println("커피 준비 완료: " + name);
    }

    public static <T, V> void orderCoffee(T name, V coffee) {
        System.out.println(coffee + " 준비 완료: " + name);
    }
}

class BlackBox {

}