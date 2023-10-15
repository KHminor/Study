package chap_10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class _05_Stream {
    public static void main(String[] args) {
        // 스트림: 데이터가 흐른다?, 데이터 가공이 편리
        int[] scores = {100, 95, 90, 85, 80};
        IntStream scoreStream = Arrays.stream(scores);

        String[] langs = {"python", "java", "C", "C++", "C#"};
        Stream<String> stream = Arrays.stream(langs);

        List<String> langList = new ArrayList<>();
        // langList.add("python");
        // langList.add("java");

        // 위와 같이 추가할 수 있지만, 아래와 같이 추가할 수 있다.
        langList = Arrays.asList(langs);
        System.out.println(langList.size());
        Stream<String> langListStream = langList.stream();

        System.out.println("--------------------------------");
        // Stream.of()
        Stream<String> lagnListOfStream = Stream.of("python", "java", "C", "C++", "C#");
        lagnListOfStream.forEach(s -> System.out.println(s));
    }
}
