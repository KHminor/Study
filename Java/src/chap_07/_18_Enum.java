package chap_07;

public class _18_Enum {
    public static void main(String[] args) {
        // 열거형 (Enum): 상수들의 묶음
        // 달력: JAN, FEB, MAR, ...
        // 옷 사이즈: S, M, L, XL ...
        // OS 종류: WIN10, WIN11 ...
        // 해상도: HD, FHD, QHD, UHD ...
        // 에러 코드 등

        // enum은 main 밖에서 따로 작성하여 사용

        Resolution resolution = Resolution.UHD;
        System.out.println(resolution);

        System.out.print("동영상 녹화 품질: ");
        switch (resolution) {
            case HD:
                System.out.println("일반화질");
                break;
            case FHD:
                System.out.println("고화질");
                break;
            case UHD:
                System.out.println("초고화질");
                break;
        }

        resolution = Resolution.valueOf("UHD"); // 문자열로부터 값을 가져와서 열거형으로 변경
        System.out.println(resolution);

        System.out.println();
        for (Resolution myRes: Resolution.values()) {
            System.out.println(myRes.name() + "\t:\t" + myRes.ordinal());
        }

        System.out.println();
        for (Resolution myRes: Resolution.values()) {
            System.out.println(myRes.name() + "\t:\t" + myRes.getWidth() + "px");
        }
    }
}

enum Resolution {
    // 열거형에 값을 추가하고자 한다면 아래와 같이
    // 보통 private final을 사용하여 변수를 만들어준 다음
    // enum 의 이름에 해당하는 생성자 형태로 만들어 주고 파라미터를 추가해주기!
    HD(1280), FHD(1920), UHD(3840);

    private final int width;
    Resolution(int width) {
        this.width = width;
    }

    public int getWidth() {
        return width;
    }
}