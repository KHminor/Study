package chap_07;

import chap_07.camera.Camera;
import chap_07.camera.FactoryCam;
import chap_07.camera.SpeedCam;

public class _14_Polymorphism {
    public static void main(String[] args) {
        // 다형성

        // class Person: 사람
        // class Student extends Person: 학생 (학생은 사람이다. Student is a Person)
        // class Teacher extends Person: 선생님 (선생님은 사람이다. Teacher is a Person)

        // 아래와 같이 앞에 작성한 클래스에 해당하는 함수, 변수만 사용할 수 있다.
        Camera camera = new Camera();
        Camera factoryCam = new FactoryCam();
        Camera speedCam = new SpeedCam();

        camera.showMainFeature();
        factoryCam.showMainFeature();
        speedCam.showMainFeature();

        System.out.println();
        Camera[] cameras = new Camera[3];
        cameras[0] = new Camera();
        cameras[1] = new SpeedCam();
        cameras[2] = new FactoryCam();

        for (Camera cam: cameras) {
            cam.showMainFeature();
        }

        System.out.println();
//        factoryCam.detectFire();
//        speedCam.checkSpeed();
//        speedCam.recognizeLicensePlate();

        // 위의 코드가 실행이 안되는데
        // 현재 상황에서 의도한 대로 코드를 실행하고자 한다면
        // 아래와 같이 camera가 Camera의 인스턴스이라면이라는 조건을 성립할 때 가능
        // 그래서 형변환시 소괄호() 안에 타입을 적는 것처럼
        // 소괄호 안에 클래스를 넣고 아래와 같이 작성
        if (camera instanceof Camera) {
            System.out.println("카메라 입니다.");
        }
        if (factoryCam instanceof FactoryCam) {
            ((FactoryCam) factoryCam).detectFire();
        }
        if (speedCam instanceof SpeedCam) {
            ((SpeedCam) speedCam).checkSpeed();
            ((SpeedCam) speedCam).recognizeLicensePlate();
        }

        // Object는 최상의 부모요소로서 어떠한 형태의 요소라도 넣을 수 있다고 한다.
        Object[] objs = new Object[3];
        objs[0] = new Camera();
        objs[1] = new FactoryCam();
        objs[2] = new SpeedCam();
    }
}
