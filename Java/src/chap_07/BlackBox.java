package chap_07;

public class BlackBox {
    String modelName;
    String resolution;
    int price;
    String color;
    int serialNumber; // 시리얼 번호

    static int counter = 0; // 시리얼 번호 생성해주는 역할

    // 생성자
    // 객체 생성시 자동으로 호출되는 메서드
    BlackBox() {
//        System.out.println("기본 생성자 호출");
//        this.serialNumber = ++counter;
//        System.out.println("새로운 시리얼 넘버를 발급받았습니다.");
    }

    BlackBox(String modelName, String resolution, int price, String color) {
        // 기본 생성자를 호출시 this() 만 작성하면 됨.
//        this();
//
//        System.out.println("사용자 정의 생성자 호출");
//        this.modelName = modelName;
//        this.resolution = resolution;
//        this.price = price;
//        this.color = color;
    }

    // static 을 붙이면 클래스 변수, 붙이지 않으면 인스턴스 변수
    static boolean canAutoReport = false; // 자동 신고 기능

    // 메서드
    void autoReport() {
        if (canAutoReport) {
            System.out.println("충돌이 감지되어 자동으로 신고합니다.");
        } else {
            System.out.println("자동 신고 기능이 지원되지 않습니다.");
        }
    }

    void insertMemoryCard(int capacity) {
        System.out.println("메모리 카드가 삽입되었습니다.");
        System.out.println("용량은 " + capacity + "GB 입니다.");
    }

    int getVideoFileCount(int type) {
        if (type == 1) {
            // 일반 영상
            return 9;
        } else if (type == 2) {
            // 이벤트 영상
            return 1;
        } return 10;
    }

    void record(boolean showDateTime, boolean showSpeed, int min) {
        System.out.println("녹화를 시작합니다.");
        if (showDateTime) {
            System.out.println("영상에 날짜정보가 표시됩니다.");
        }
        if (showSpeed) {
            System.out.println("영상에 속도정보가 표시됩니다.");
        }
        System.out.println("영상은 " + min + "분 단위로 기록됩니다.");
    }

    // 아래와 같이 위 함수를 다시 불러오는 이유는
    // 아래 함수에서 하드코딩을 해서 입력을 해둔다면 데이터 변경시 많은 작업을 다시 한 번 더 해야하기 때문.
    void record() {
        record(true,true,5);
    }

    // static으로 지정한 클래스 변수는 static 메서드에서 바로 사용 가능.
    // 또한 인스턴스 생성하지 않고도 사용 가능.
    static void callServiceCenter() {
        System.out.println("서비스 센터(1588-0000) 로 연결합니다.");
        canAutoReport = true;
    }

    // this를 붙이면 클래스 인스턴스 변수를 의미
    // 만약 파라미터 값과 변수의 값이 서로 다를 경우엔 this를 굳이 붙이지 않아도 가능
    void appendModelName(String modelName) {
        this.modelName += modelName;
    }


    // Getter: 값을 가져오는 메서드, Setter: 값을 수정하는 메서드
    String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    String getResolution() {
        if (resolution == null || resolution.isEmpty()) { //.isEmpty() == "" 빈 문자열
            return "판매자에게 문의하세요.";
        }
        return this.resolution;
    }

    void setResolution(String resolution) {
        this.resolution = resolution;
    }

    int getPrice() {
        return this.price;
    }

    void setPrice(int price) {
        if (price < 100000) {
            this.price = 100000;
        } else {
        this.price = price;
        }
    }

    String getColor() {
        return this.color;
    }

    void setColor(String color) {
        this.color = color;
    }
}
