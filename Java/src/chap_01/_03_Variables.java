package chap_01;

public class _03_Variables {
    public static void main(String[] args) {
        String name = "히히";
        int time = 15;
        System.out.println(name + ", "+ time + "시에 배송 시작한닷!");
        System.out.println(name + ", 배송 완료되었다!");

        double d = 3.14123456789; // 정밀한 실수를 적용하고자 할 경우엔 double 사용
        float f = 3.14123456789F;
        System.out.println(d);
        System.out.println(f);

//        int i = 1000000000000000; // int 는 -+ 12억까지라 범위를 벗어나서 넣을 수 없음
        long l = 1000000000000000L;
        l = 1_000_000_000_000_000L;
        System.out.println(l);
    }
}
