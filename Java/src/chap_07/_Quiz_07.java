package chap_07;

public class _Quiz_07 {
    public static void main(String[] args) {
        // 햄버거 종류: 햄버거, 치즈버거, 새우버거
        // 각 버거는 각각의 클래스로 생성
        // 버거 이름을 담기 위한 name 변수 정의
        // 재료 정보를 표시하는 cook() 메서드 정의
        // 공통 부분은 상속 및 메서드 오버라이딩으로 처리
        // 모든 클래스는 하나의 파일에 정의
        Hamberger[] hambergers = new Hamberger[3];
        hambergers[0] = new Hamberger();
        hambergers[1] = new CheeseBerger();
        hambergers[2] = new ShrimpBerger();

        System.out.println("주문하신 메뉴를 만듭니다.");
        System.out.println("----------");
        for (Hamberger hamberger: hambergers) {
            hamberger.cook();
            System.out.println("--------------");
        }
        System.out.println("메뉴 준비가 완료되었습니다.");

    }
}


class Hamberger {
    // 양상추, 패티, 피클

    public String name;

    public Hamberger() {
        this("햄버거");
    }

    public Hamberger(String name) {
        this.name = name;
    }

    public void cook() {
        System.out.println(this.name + "를 만듭니다.");
        System.out.println("빵 사이에 들어가는 재료는?");
        System.out.println("> 양상추");
        System.out.println("+ 패티");
        System.out.println("+ 피클");
    }
}

class CheeseBerger extends Hamberger {
    // 양상추, 패티, 피클 + 치즈

    public CheeseBerger() {
        super("치즈버거");
    }

    public void cook() {
        super.cook();
        System.out.println("+ 치즈");
    }
}

class ShrimpBerger extends Hamberger {
    // 양상추, 패티, 피클 + 새우

    public ShrimpBerger() {
        super("새우버거");
    }

    public void cook() {
        super.cook();
        System.out.println("+ 새우");
    }
}