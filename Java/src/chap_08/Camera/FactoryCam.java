package chap_08.Camera;

import chap_08.detector.Detectable;
import chap_08.reporter.Reportable;

public class FactoryCam extends Camera implements Detectable, Reportable {

    private Detectable detectable;
    private Reportable reportable;

    public void setDetectable(Detectable detectable) {
        this.detectable = detectable;
    }

    public void setReportable(Reportable reportable) {
        this.reportable = reportable;
    }

    @Override
    public void showMainFeature() {
        System.out.println("화재 감지");
    }

    @Override
    public void detect() { // 현재 변경되어진 객체의 detect() 메서드를 실행
        detectable.detect();
    }

    @Override
    public void report() {
        reportable.report();
    }
}
