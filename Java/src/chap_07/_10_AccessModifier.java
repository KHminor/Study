package chap_07;

public class _10_AccessModifier {
    public static void main(String[] args) {
        // 접근 제어자
        // private: 해당 클래스 내에서만 접근 가능
        // public: 모든 클래스에서 접근 가능 -> 또한 public 클래스의 경우엔 반드시 자바 파일 이름 또한 클래스 명과 같아야 한다.
        // default: (아무것도 적지 않았을 때) 같은 패키지 내에서만 접근 가능
        // protected: 같은 패키지 내에서는 접근 가능하지만, 다른 패키인 경우 자식 클래스에서 접근 가능


        // ctrl + R: 같은 것 한번에 다 찾아서 변경
        BlackBoxRefurbish b1 = new BlackBoxRefurbish();
        b1.modelName = "까망이";
        b1.resolution = "FHD";
        b1.setPrice(200000);
        b1.color = "블랙";

        // 즉, Getter, Setter 를 사용한다면 의도하지 않은 입출력에 대한 조건처리를 통해
        // 행위를 제어할 수 있다.
        BlackBoxRefurbish b2 = new BlackBoxRefurbish();
        b2.setModelName("하양이");
        b2.setPrice(-5000);
        b2.setColor("화이트");

        System.out.println("가격: " + b2.getPrice() + "원");
        System.out.println("해상도: " + b2.getResolution());

        // Getter&Setter 메서드를 작성하여도 아래 코드를 작성하게 되면
        // 인스턴스의 price 값이 변경되는데 이러한 행위를 제제하기 위해서 접근 제어자를 사용
    }
}
