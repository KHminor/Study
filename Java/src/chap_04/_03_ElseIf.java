package chap_04;

public class _03_ElseIf {
    public static void main(String[] args) {
        // 조건문 ElseIf
        // 한라봉 에이드가 있다면 +1
        // 또는 망고 주스가 있다면 +1
        // 위 항목이 없다면 아이스 아메리카노 +1
        boolean hallabongAde = true;
        boolean mangoJuice = true;
        if (hallabongAde) {
            System.out.println("한라봉 에이드 +1");
        } else if (mangoJuice) {
            System.out.println("망고 주스 +1");
        } else {
            System.out.println("아이스 아메리카노 +1");
        }
        System.out.println("음료 주문 완료 #1");
    }
}
