package chap_09;

import java.util.*;
//import java.util.LinkedList;


public class _08_Iterator {
    public static void main(String[] args) {
        // 이터레이터: 리스트 또는 세트를 순회하는 것.
        List<String> list = new ArrayList<>();
        // List<String> list2 = new LinkedList<>();

        list.add("유재석");
        list.add("(알 수 없음)");
        list.add("김종국");
        list.add("(알 수 없음)");
        list.add("강호동");
        list.add("(알 수 없음)");
        list.add("박명수");
        list.add("조세호");

        for (String s: list) {
            System.out.println(s);
        }
        System.out.println("========================");


        // 이터레이터 사용법
        Iterator<String> it = list.iterator();
        System.out.println(it.next());
        System.out.println(it.next());
        System.out.println(it.next());
        System.out.println(it.next());

        System.out.println("========================");
        // 커서를 처음 위치로 이동
        it = list.iterator();
        while (it.hasNext()) { // hasNext() 값이 있으면 다음으로 넘어감
            System.out.println(it.next());
        }


        System.out.println("========================");
        // 커서를 처음 위치로 이동
        it = list.iterator();
        while (it.hasNext()) { // hasNext() 값이 있으면 다음으로 넘어감
            String s = it.next();
            if (s.contains("(알 수 없음)")) {
                it.remove();
            }
        }
        for (String s: list) {
            System.out.println(s);
        }

        System.out.println("========================");
        HashSet<String> set = new HashSet<>();
        set.add("유재석");
        set.add("박명수");
        Iterator<String> itSet = set.iterator();
        while (itSet.hasNext()) {
            System.out.println(itSet.next());
        }

        System.out.println("========================");
        HashMap<String, Integer> map = new HashMap<>();
        map.put("유재석", 10);
        map.put("박명수", 5);
        // map.iterator(); // map 에선 iterator를 바로 적용할 수 없어서, key 또는 value 각각에 iterator를 적용할 수 있음.
        Iterator<String> itMapKey = map.keySet().iterator();
        Iterator<Integer> itMapValue = map.values().iterator();

        System.out.println("========================");
        // map에서 key와 value를 함께 출력하는 방법
        Iterator<Map.Entry<String, Integer>> itMap = map.entrySet().iterator();
        while (itMap.hasNext()) {
            String[] s = itMap.next().toString().split("=");
            System.out.println(Arrays.toString(s));
        }

    }
}
