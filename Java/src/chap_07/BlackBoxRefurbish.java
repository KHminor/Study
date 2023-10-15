package chap_07;

public class BlackBoxRefurbish {

    // Getter&Setter를 간단히 만드는 방법
    // 메뉴 -> Code -> Generate -> 생성하고 싶은 것 클릭

    public String modelName;
    String resolution; // 같은 패키지 내에서만
    private int price; // 같은 클래스 내에서만
    protected String color;

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getResolution() {
        if (resolution == null || resolution.isEmpty()) { //.isEmpty() == "" 빈 문자열
            return "판매자에게 문의하세요.";
        }
        return this.resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        if (price < 100000) {
            this.price = 100000;
        } else {
            this.price = price;
        }
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
