package chap_08;

import chap_08.Camera.SpeedCam;
import chap_08.detector.*;
import chap_08.reporter.*;

public class _Quiz_08 {
    public static void main(String[] args) {
        // 문제: 인터페이스를 이용하여 과속 단속 카메라에 교통 사고 감지 및 신고 기능을 추가하기.
        // 조건:
        // 과속 단속 카메라인 SpeedCam 클래스의 detect(), report() 개선
        // 교통 사고를 감지하는 AccidentDetector 클래스 신규 생성
        // 신고 기능은 기존에 작성된 VideoReporter 클래스 활용
        // 모든 클래스는 적절한 위치에 정의
        SpeedCam speedCam = new SpeedCam();
        speedCam.setDetector(new AccidentDetector());
        speedCam.setReportor(new VideoReporter());

        speedCam.detect();
        speedCam.report();
    }
}
