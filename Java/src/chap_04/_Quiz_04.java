package chap_04;

public class _Quiz_04 {
    public static void main(String[] args) {
        int cost = 4000;
        int max = 30_000;
        int cash = 0;
        int cnt = 10;
        String car = "장애인 차량";

        for (int i = 1; i <= cnt; i++) {
            cash += cost;
            if (cash >= max) {
                cash = 30_000;
                break;
            }
        }
        switch (car){
            case "경차":
            case "장애인 차량":
                cash /= 2;
                break;
        }
        System.out.println(car + " " + cnt + "시간의 주차 요금은 " + cash + " 원입니다.");
    }
}