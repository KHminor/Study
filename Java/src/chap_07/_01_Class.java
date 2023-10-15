package chap_07;

public class _01_Class {
    public static void main(String[] args) {
        // 객체 지향 프로그래밍 (OOP: Object-Oriented Programming)
        // 유지보수 용이
        // 높은 재사용성

        // 차량용 블랙박스
        // 모델명, 해상도, 가격, 색상

        // 우리가 만든 첫 번째 제품
        String modelName = "까망이";
        String resolution = "FHD";
        int price = 200_000;
        String color = "블랙";

        // 새로운 제품을 개발
        // 클래스명 객체이름 = new 클래스명();
        BlackBox bbox = new BlackBox();
    }
}
