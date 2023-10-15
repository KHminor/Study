package chap_07;

public class _09_GetterSetter {
    public static void main(String[] args) {
        BlackBox b1 = new BlackBox();
        b1.modelName = "까망이";
        b1.resolution = "FHD";
        b1.price = 200000;
        b1.color = "블랙";

        // 즉, Getter, Setter 를 사용한다면 의도하지 않은 입출력에 대한 조건처리를 통해
        // 행위를 제어할 수 있다.
        BlackBox b2 = new BlackBox();
        b2.setModelName("하양이");
        b2.setPrice(-5000);
        b2.setColor("화이트");

        System.out.println("가격: " + b2.getPrice() + "원");
        System.out.println("해상도: " + b2.getResolution());

        // Getter&Setter 메서드를 작성하여도 아래 코드를 작성하게 되면
        // 인스턴스의 price 값이 변경되는데 이러한 행위를 제제하기 위해서 접근 제어자를 사용
        b2.price = -5000;
    }
}
