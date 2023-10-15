package chap_09;

import java.util.HashSet;
import java.util.LinkedHashSet;

public class _06_HashSet {
    public static void main(String[] args) {
        // 세트: 중복 x
        // HashSet<자료형>
        HashSet<String> set = new HashSet<>();
        // 데이터 추가
        set.add("삼겹살");
        set.add("쌈장");
        set.add("음료");
        set.add("소금");
        set.add("후추");
        set.add("삼겹살");
        set.add("깻잎");
        set.add("상추");
        set.add("삼겹살");

        System.out.println("=====================");
        System.out.println(set.size());
        for (String s: set) {
            System.out.println(s);
        }

        System.out.println("=====================");
        //  확인, set은 순서가 보장되지 않기에 indexOf() x
        System.out.println(set.contains("쌈장"));

        System.out.println("=====================");
        // 제거
        set.remove("깻잎");
        for (String s: set) {
            System.out.println(s);
        }

        System.out.println("=====================");
        // 전체 제거
        set.clear();
        if (set.isEmpty()) {
            System.out.println("없당");
        }


        System.out.println("=====================");
        // 만약 순서가 보장된 set 형식을 사용하고 싶다면, LinkedHashSet
        // 추가된 순서대로 값이 저장됨.
        HashSet<Integer> set2 = new LinkedHashSet<>();
        set2.add(1);
        set2.add(13);
        set2.add(2);
        for (int s: set2) {
            System.out.println(s);
        }
    }
}
