package chap_07.camera;

public final class ActionCam extends Camera { // 클래스 자체에 final을 작성하면 상속자체를 할 수 없게 됨.

    public final String lens = "광각렌즈";

    public ActionCam() {
        super("액션 카메라");
    }

    public final void makeVideo() {
        System.out.println(this.name + ": " + this.lens + "로 촬영한 멋진 비디오를 제작합니다.");
    }
}
