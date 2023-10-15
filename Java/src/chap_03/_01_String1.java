package chap_03;

public class _01_String1 {
    public static void main(String[] args) {
        String s = "I like Java and Python and C.";
        System.out.println(s.length()); // 문자열 길이
        System.out.println(s.toUpperCase()); // 대문자
        System.out.println(s.toLowerCase()); // 소문자
        System.out.println(s.contains("Java")); // 포함된 문자 찾기 (true/false)
        System.out.println(s.contains("Jaa"));
        System.out.println(s.indexOf("Java")); // 문자의 인덱스 찾기 (찾지 못할 경우 -1), 문자를 넣는다면 문자의 첫 글자 위치를 반환
        System.out.println(s.indexOf("and"));
        System.out.println(s.lastIndexOf("and")); // 찾을 문자가 여러개 있어서 마지막에 있는 문자의 위치를 찾을 경우
        System.out.println(s.startsWith("I ldf")); // 시작 문자가 해당 값이 맞는지 (true/false)
        System.out.println(s.endsWith(".")); // 끝나는 문자가 해당 값이 맞는지 (true/false)
        System.out.println(s);
    }
}
