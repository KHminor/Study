package chap_09.coffee;

public class Coffee <T>{ // 클래스명 옆에 <T>
    public T name;

    public Coffee(T name) {
        this.name = name;
    }

    public void ready() {
        System.out.println("커피 준비 완료: " + name);
    }
}
