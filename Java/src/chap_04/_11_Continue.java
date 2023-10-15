package chap_04;

public class _11_Continue {
    public static void main(String[] args) {
        // Continue
        // 치킨 주문 손님중에 노쇼 손님이 있다고 가정
        // For
        int max = 20; // 최대 치킨 판매 수량
        int sold = 0; // 현재 치킨 판매 수량
        int noShow = 17; // 노쇼 손님
        for (int i = 1; i < 50; i++) {
            if (i == noShow) {
                sold++;
                continue;
            }
            if (sold == max) {
                System.out.println("금일 재료가 모두 소진되었습니다.");
                break;
            }
            System.out.println(i + "번 손님, 주문하신 치킨 나왔습니다.");
            sold++; // 판매 처리
        }
        System.out.println("영업을 종료합니다.");
    }
}
