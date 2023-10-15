package chap_09;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class _05_LinkedList {
    public static void main(String[] args) {
        // 링크드 리스트
        LinkedList<String> list = new LinkedList<>();

        // 데이터 추가
        list.add("유재석");
        list.add("조세호");
        list.add("김종국");
        list.add("박명수");
        list.add("강호동");

        // 첫번째 값 조회
        System.out.println(list.get(0));
        System.out.println(list.getFirst());
        // 마지막 값 조회
        System.out.println(list.get(list.size() - 1));
        System.out.println(list.getLast());

        System.out.println("=========================");
        // 추가
        list.addFirst("서장훈"); // 배열의 가장 앞에 추가
        list.addLast("미미");
        printName(list);

        System.out.println("=========================");
        // 원하는 인덱스에 값 추가
        list.add(1, "김영철");
        printName(list);

        System.out.println("=========================");
        // 삭제
        System.out.println(list.size());
        // list.remove(1);
        System.out.println(list.get(1));
        list.remove("김영철");
        System.out.println(list.get(1));

        System.out.println("=========================");
        // 처음과 마지막 학생의 삭제
        list.removeFirst();
        list.removeLast();
        printName(list);

        System.out.println("=========================");
        // 변경
        System.out.println(list.get(0));
        list.set(0,"카리나");
        System.out.println(list.get(0));

        System.out.println("=========================");
        // 확인
        System.out.println(list.indexOf("카리나"));
        if (list.contains("카리나")) {
            System.out.println(true);
        } else {
            System.out.println(true);
        }

        System.out.println("=========================");
        // 전체삭제
        list.clear();
        if (list.isEmpty()) {
            System.out.println("돈이 없다");
        } else {
            System.out.println("아직 돈 벌 수 이써");
        }

        System.out.println("=========================");
        // 정렬
        list.add("유재석");
        list.add("조세호");
        list.add("김종국");
        list.add("박명수");
        list.add("강호동");
        printName(list);
        System.out.println("=========================");
        Collections.sort(list);
        printName(list);
        System.out.println("=========================");
        Collections.sort(list, Collections.reverseOrder());
        printName(list);
    }

    public static void printName(LinkedList<String> list) {
        for (String name : list) {
            System.out.println(name);
        }
    }
}
