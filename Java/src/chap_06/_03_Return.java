package chap_06;

public class _03_Return {

    // void는 반환값이 x
    // return 값을 전달할 경우 void를 제거 후
    // 해당 자리에 return 값의 타입을 작성

    // 호텔 전화번호
    public static String getPhoneNumber() {
        String phoneNumber = "02-1234-5678";
        return phoneNumber;
    }

    // 호텔 주소
    public static String getAddress() {
        return "부산시";
    }
    
    // 호텔 액티비티
    public static String getActivities() {
        return "볼링장, 탁구장, 노래방";    
    }
    
    public static void main(String[] args) {
        String contactNumber = getPhoneNumber();
        System.out.println("호텔 전화번호: " + contactNumber);
        System.out.println("호텔 주소는: " + getAddress());
        System.out.println("호텔 액티비티: " + getActivities());
    }
}
