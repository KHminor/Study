package chap_08;

import chap_08.Camera.Camera;
import chap_08.Camera.FactoryCam;
import chap_08.Camera.SpeedCam;

public class _01_AbstractClass {
    public static void main(String[] args) {
        // 데이터 추상화 (Data Abstraction)
        // 추상 클래스 (아직 완성되지 않은 클래스)
        // 추상 메서드 (추상 클래스 또는 인터페이스에서만 사용 가능한, 껍데기만 있는 메서드)

        // 추상 클래스: 일반 클래스와 다를 것이 없다.
        //             다만 추상 메서드를 선언하여 상속을 통해서 자손 클래스에서 완성하도록 유도하는 클래스.
        //             즉 미완성 설계도라고도 표현.
        //             상속을 위한 클래스이기에 따로 객체를 생성할 수도 없다.
        //             그래서 추상클래스를 이용하여 일반 메서드를 작성한다면 자식 클래스에서 사용할 수 있다.

        // Camera camera = new Camera(); // 추상 클래스인 Camera 자체는 객체로 생성할 수 없음.
        FactoryCam factoryCam = new FactoryCam();
        SpeedCam speedCam = new SpeedCam();

        factoryCam.showMainFeature();
        speedCam.showMainFeature();


    }
}
