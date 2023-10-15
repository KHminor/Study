package chap_07.camera;

public class SlowActionCam{

   public String name;

    public SlowActionCam() {
        this.name = "슬로우 액션 카메라"; // 현재는 this("슬로우 액션 카메라"); 하지 못하는 이유는 값이 있는 생성자를 생성하지 않았기에 안됨.
    }

    public void makeVideo() {
        System.out.println("자체 개발한 슬로우 모드 카메라");
    }
}
