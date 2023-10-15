package chap_07;

import chap_07.camera.ActionCam;
import chap_07.camera.SlowActionCam;

public class _17_Final {
    public static void main(String[] args) {
        // Final

        // public (final) class ...
        // public (final) void ...
        // public > abstract > static > final ...

        // public final String lens = "광격렌즈"; 와 같이
        // 해당 클래스 변수를 생성 시 상수로 만들고자 한다면
        // public final 타입 변수이름 으로 작성하면 된다.
        // 그리고 바로 값을 넣기 않고 생성자에 값을 넣어도 같은 순서로 처리되기에 문제가 없다.

        ActionCam actionCam = new ActionCam();
        // actionCam.lens = "표준렌즈";
        actionCam.recordVideo();
        actionCam.makeVideo();

        System.out.println();

        SlowActionCam slowActionCam = new SlowActionCam();
        slowActionCam.makeVideo();
    }
}
