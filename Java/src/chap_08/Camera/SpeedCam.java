package chap_08.Camera;

import chap_08.detector.Detectable;
import chap_08.reporter.Reportable;

public class SpeedCam extends Camera implements Detectable,Reportable{

    private Detectable detector;
    private Reportable reportor;

    public void setDetector(Detectable detectable) {
        this.detector = detectable;
    }

    public void setReportor(Reportable reportable) {
        this.reportor = reportable;
    }

    @Override
    public void showMainFeature() {
        System.out.println("속도 측정, 번호 인식");
    }

    public void detect() {
        detector.detect();
    }

    public void report() {
        reportor.report();
    }
}
