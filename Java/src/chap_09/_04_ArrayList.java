package chap_09;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class _04_ArrayList {
    public static void main(String[] args) {
        // 컬렉션 프레임워크: 많은 데이터를 쉽고 간편하게 효과적으로 관리하기 위한 클래스들의 모음.
        // 종류: List(ArrayList, LinkedList), Set, Map

        // 만약 배열의 공간을 추가하고 싶다면?
        ArrayList<String> list = new ArrayList<>();

        // 데이터 추가: list.add(value)
        list.add("유재석");
        list.add("조세호");
        list.add("김종국");
        list.add("박명수");
        list.add("강호동");

        // 데이터 조회
        printName(list);

        System.out.println("=========================");

        // 데이터 삭제: list.remove(index or value)
        list.remove("박명수");
        printName(list);

        System.out.println("=========================");

        System.out.println("남은 학생 수 (제외 전): " + list.size());
        list.remove(list.size() - 1);
        System.out.println("남은 학생 수 (제외 후): " + list.size());

        System.out.println("=========================");
        printName(list);


        System.out.println("=========================");
        // 데이터 변경: list.set(index, value)
        System.out.println("수강권 양도 전: " + list.get(0));
        list.set(0, "이수근");
        System.out.println("수강권 양도 전: " + list.get(0));

        System.out.println("=========================");
        // 데이터 확인: list.indexOf(value) => return index
        System.out.println(list.indexOf("김종국"));
        // ArrayList 내에 포함되었는지 확인: list.Contain => return true of false
        if (list.contains("김종국")) {
            System.out.println("수강");
        } else {
            System.out.println("수강 X");
        }

        System.out.println("=========================");
        // 데이터 전체 삭제: list.clear()
        list.clear();
        if (list.isEmpty()) {
            System.out.println("수강생 없음");
        } else {
            System.out.println("수강생 있음");
        }


        System.out.println("=========================");
        // 다음 학기에 새로 공부 시작
        list.add("유재석");
        list.add("조세호");
        list.add("김종국");
        list.add("박명수");
        list.add("강호동");

        // 데이터 정렬 (오름차순) Collections.sort(ArrayList);
        Collections.sort(list, Collections.reverseOrder());
        printName(list);
    }

    // printName 메서드에 static을 붙여야하는 이유
    // main 메서드는 클래스 수준에서 호출되는 메서드이기에
    // 해당 main 메서드 내부에서 호출되는 메서드를 호출하려면 클래스 수준에서 직접 호출할 수 있도록
    // 호출되는 메서드 또한 static을 붙여줘야 한다.
    public static void printName(ArrayList<String> list) {
        for (String name : list) {
            System.out.println(name);
        }
    }
}
