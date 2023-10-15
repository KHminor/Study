package chap_09.coffee;

import chap_09.user.User;

// <>는 T의 값을 제한하는 것으로
// 즉, User 또는 User가 상속하는 타입만 해당 클래스에 들어올 수 있다.
public class CoffeeByUser <T extends User>{
    public T user;

    public CoffeeByUser(T user) {
        this.user = user;
    }

    public void ready() {
        System.out.println("커피 준비 완료: " + user.name);
        user.addPoint();
    }
}
