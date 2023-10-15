package chap_06;

public class _Quiz_06 {

    public static String getHiddenData(String val, int start) {
        String result = val.substring(0,start);
        for (int i = start; i < val.length(); i++) {
            result += "*";
        }
        return result;
    }

    public static void main(String[] args) {
        String name = "나코딩"; // 이름
        String id = "990130-1234567"; // 주민번호
        String phone = "010-1234-5678"; // 전화번호

        System.out.println("이름: " + getHiddenData(name, 1)); // 개인정보, 비공개 시작 위치
        System.out.println("주민등록번호: " + getHiddenData(id, 8));
        System.out.println("전화번호: " + getHiddenData(phone, 9));
    }
}
