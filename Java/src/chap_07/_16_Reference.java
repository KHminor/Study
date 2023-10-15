package chap_07;

import chap_07.camera.Camera;

public class _16_Reference {
    public static void main(String[] args) {
        // 참조
        // 기본 자료형 (Primitive Data Types) int, float, double, long, boolean // 소문자로 되어있는 것
        // 즉, 기본 자료형은 값을 넣지 않을 경우 0 값이 들어감
        int[] i = new int[3];
        System.out.println(i[0]); // 0

        double[] d = new double[3];
        System.out.println(d[0]); // 0.0

        // 참조 자료형 (Non-Primitive Data Types, Reference Data Types): String, Camera, FactoryCam, SpeedCam
        // 즉, 참조 자료형은 값을 넣지 않을 경우 null
        String[] s = new String[3];
        System.out.println(s[0]); // null

        Camera[] c = new Camera[3];
        System.out.println(c[0] == null); // true

        // ----------------
        System.out.println("===========");
        int a = 10;
        int b = 20;
        b = a;
        System.out.println(a);
        System.out.println(b);
        b = 30;
        System.out.println(a);
        System.out.println(b);

        // ----------------
        System.out.println("===========");
        Camera c1 = new Camera();
        Camera c2 = new Camera();
        c1.name = "카메라1";
        c2.name = "카메라2";
        System.out.println(c1.name);
        System.out.println(c2.name);
        c2 = c1; // 참조 자료형이기에 c2의 주소값이 c1과 같아짐.
        System.out.println(c1.name);
        System.out.println(c2.name);
        c2.name = "고장난 카메라";
        System.out.println(c1.name);
        System.out.println(c2.name);

        changeName(c2);
        System.out.println(c1.name);
        System.out.println(c2.name);

        // 만약 관계를 끊고자 한다면 아래와 같이 작성
        // c2 = null;
    }

    public static void changeName(Camera camera) {
        camera.name = "잘못된 카메라";

    }
}
