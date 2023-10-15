package chap_08;

import chap_08.Camera.FactoryCam;
import chap_08.detector.*;
import chap_08.reporter.*;

public class _02_Interface {
    public static void main(String[] args) {
        // 인터페이스: 뼈대만 제공
        // 상속 (extends): 단일 부모에게만 상속을 받을 수 있음.

        // 인터페이스: 추상클래스가 미완성 설계도라면, 인터페이스는 기본 설계도라고 할 수 있다.
        //            인터페이스도 추상클래스처럼 다른 클래슬르 작성하는데 도움을 주는 목적으로 작상하며, 클래스와 다르게 다중상속이 가능.
        //            만약, 다른 추상클래스를 상속받는데 공통된 기능이 필요할 경우엔, 해당 기능을 인터페이스로 작성하여 구현하면 편리.


        // 순서:
        // 1. interface에서 나눠줄 메서드 생성
        // 2. 하위 자식 클래스에서 interface를 상속받아서 interface에서 생성한 메서드를 override를 하여 맞춤 메서드로 변경
        // 3. 이후 해당 기능을 사용할 다른 클래스에서 인터페이스를 private 변수로 받기만 하기 (ex. private interface 변수명)
        // 4. private로 변경했기에 setter()메서드를 생성하여 어디에서든 변경할 수 있도록 하기
        // 5. 마지막으로 해당 인터페이스에서 생성한 메서드를 실행시켰을 때 setter()메서드로 변경한 클래스의 메서드로 실행하기 위해
        //     변수명.메서드(); 로 실행하기

        NormalReporter normalReporter = new NormalReporter();
        VideoReporter videoReporter = new VideoReporter();

        normalReporter.report();
        videoReporter.report();

        System.out.println();

        Detectable fireDetectable = new FireDetector();
        Detectable advancedFireDetector = new AdvancedFireDetector();

        fireDetectable.detect();
        advancedFireDetector.detect();

        System.out.println();

        FactoryCam factoryCam = new FactoryCam();
        factoryCam.setDetectable(fireDetectable);
        factoryCam.setReportable(normalReporter);

        factoryCam.detect();
        factoryCam.report();
    }
}
