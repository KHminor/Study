package chap_10;

public class _03_Lambda {
    public static void main(String[] args) {
        // 람다식: 간결한 식의 코드 뭉치
        // 식: (전달값1, 전달값2 ...) -> { 코드 }

    }
}


//    public void print() {
//        String s = "test";
//        System.out.println(s);
//    }

//    () -> {
//        String s = "test";
//        System.out.println(s);
//    }

//    ===================================

//    public void Print(String s) {
//        System.out.println(s);
//    }

//    (s) -> System.out.println(s) // 파라미터 값 또한 타입을 알기에 타입 또한 생략 가능

//    ===================================

//    public int add(int x, int y) {
//        return x+y;
//    }

//    (x, y) -> { return x+y;} // return 이 있다면 중괄호를 없앨 수 없다.
//    (x, y) -> x+y; // return을 생략 후 중괄호를 생략할 수 있다.
