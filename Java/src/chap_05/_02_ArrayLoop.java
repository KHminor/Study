package chap_05;

public class _02_ArrayLoop {
    public static void main(String[] args) {
        String[] coffees = { "아메리카노", "카페모카", "라떼", "카푸치노"};
        /*for (int i = 0; i < coffees.length; i++) { // 중간에 인덱스를 통해 조건을 추가도 할 수 있음.
            System.out.println(coffees[i] + " 하나");
        }
        System.out.println("주세요");*/

        // enhanced for (for-each) 반복문 (끝까지 조회할 경우)
        // String 변수 <- 해당 변수에 배열의 값이 들어감
        for (String i: coffees) {
            System.out.println(i + " 하나");
        }
        System.out.println("주세요");
    }
}
