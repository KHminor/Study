package chap_09.coffee;

public class CoffeeByName {
    public Object name; // Integer, Double, String, BlackBox ...
    // 해당 클래스는 Object로 받기에 값을 저장하고자 할 경우 항상 형변환을 해야하며, 서로 다른 값을 형변환시 에러가 발생할 수 도 있다.

    public CoffeeByName(Object name) {
        this.name = name;
    }

    public void ready() {
        System.out.println("커피 준비 완료: " + name);
    }
}
