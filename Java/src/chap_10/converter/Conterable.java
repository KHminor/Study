package chap_10.converter;

// 함수형 인터페이스는 메서드가 하나만 있어야 하기에
// 개발자와 컴퓨터가 알기 쉽도록 anotaion인 @FunctionalInterface 을 작성
@FunctionalInterface
public interface Conterable {
    // 인터페이스: ~를 할 수 있는
    // 추상화: ~ 이다.
    void convert(int USD); // 자동으로 추상화가 붙음
}
