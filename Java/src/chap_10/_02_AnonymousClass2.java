package chap_10;

public class _02_AnonymousClass2 {
    public static void main(String[] args) {
        // 익명 클래스: 아래와 같이 사용하면 따로 클래스를 만들지 않고, 그때 그때 생성하면서 재정의 가능하기에 편리하다.
        HomeMadeBurger momMadeBurger = getMomMadeBerger();
        momMadeBurger.cook();
        System.out.println("=====================");

        HomeMadeBurger broMadeBurger = getBroMadeBurder();
        broMadeBurger.cook();
    }

    private static HomeMadeBurger getBroMadeBurder() {
        return new HomeMadeBurger() {
            @Override
            public void cook() {
                System.out.println("집에서 만드는 동생표 군대리아");
                System.out.println("재료: 빵, 치킨 패티, 양상추 샐러드, 마요네즈, 피클, 딸기쨈");
            }
        };
    }

    public static HomeMadeBurger getMomMadeBerger() {
        return new HomeMadeBurger() {
            @Override
            public void cook() {
                System.out.println("집에서 만드는 엄마표 수제 버거");
                System.out.println("재료: 빵, 소고기 패티, 해시브라운, 양상추, 마요네즈, 피클");
            }
        };
    }
}

abstract class HomeMadeBurger { // HomeMadeBurger만으로는 객체를 생성할 수 없으며, 상속시 cook() 메서드를 구현해야만 사용가능.
    public abstract void cook();
}