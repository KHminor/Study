package chap_08.detector;

public interface Detectable {

    // interface에서 생성하는 모든 메서드의 앞에는
    // public abstract가 자동으로 들어가있어서 생략하고 작성하면 된다.
    // 또 변수를 생성한다고 했을 경우
    // 자동으로 public static final이 붙게 된다.
    String name = "감지기";
    void detect(); // 감지
}
