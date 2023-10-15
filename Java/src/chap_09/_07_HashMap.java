package chap_09;

import java.util.HashMap;

public class _07_HashMap {
    public static void main(String[] args) {
        // 맵 (Key, Value), HashMap 또한 순서 보장 x
        HashMap<String, Integer> map = new HashMap<>();

        // 데이터 추가
        map.put("유재석", 10);
        map.put("박명수", 5);
        map.put("김종국", 3);

        System.out.println("총 고객 수: " + map.size());
        System.out.println("===============================");

        // 조회
        System.out.println("유재석님의 포인트: " + map.get("유재석"));
        System.out.println("===============================");

        // 확인
        if (map.containsKey("서장훈")) {
            System.out.println("서장훈님의 포인트: " + map.get("서장훈"));
        } else {
            map.put("서장훈", 1);
            System.out.println("서장훈님의 신규 등록 (포인트 1)");
        }

        System.out.println("===============================");
        // 삭제
        map.remove("유재석");
        System.out.println(map.get("유재석"));

        System.out.println("===============================");
        // 전체 삭제
        map.clear();
        System.out.println(map.isEmpty());

        System.out.println("===============================");
        // 전체 삭제
        map.put("유재석", 10);
        map.put("박명수", 5);
        map.put("김종국", 3);

        // Key 확인
        for (String key: map.keySet()) {
            System.out.println(key);
        }

        System.out.println("===============================");
        // Value 확인
        for (Integer value: map.values()) {
            System.out.println(value);
        }

        System.out.println("===============================");
        // Key & Value 확인
        for (String key: map.keySet()) {
            System.out.println("고객 이름: " + key + ",\t포인트: " + map.get(key));
        }


    }
}
