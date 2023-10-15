package chap_08.Camera;

public abstract class Camera {

    public String name;

    public Camera() {
        this("카메라");
    }

    public Camera(String name) {
        this.name = name;
    }

    public void takePicture() {
        System.out.println("사진을 촬영합니다.");
    }

    public void recordVideo() {
        System.out.println("동영상을 녹화합니다.");
    }

    // 추상 메서드는 선언만하고, 구현해야하는 메서드가 된다.
    public abstract void showMainFeature();
}
