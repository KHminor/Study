package chap_09;

import java.util.ArrayList;
import java.util.HashMap;

public class _Quiz_09 {
    public static void main(String[] args) {
        ArrayList<Studend> list = new ArrayList<>();
        list.add(new Studend("유재석", "파이썬"));
        list.add(new Studend("박명수", "자바"));
        list.add(new Studend("김종국", "자바"));
        list.add(new Studend("조세호", "C"));
        list.add(new Studend("서장훈", "파이썬"));

        System.out.println("자바 자격증을 보유한 학생");
        System.out.println("---------------------");
        for (Studend s: list) {
            if (s.certificate.equals("자바")) { // ==: 주소값 비교, equals: 값 비교
                System.out.println(s.name);
            }
        }
    }
}


class Studend {

    public String name;
    public String certificate;

    public Studend(String name, String certificate) {
        this.name = name;
        this.certificate = certificate;
    }
}