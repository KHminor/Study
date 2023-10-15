package chap_09;

public class _01_Generics {
    public static void main(String[] args) {
        // 제네릭스: 다양한 타입의 객체를 지원하는 클래스나 인터페이스, 메서드를 정의하는 방법
        //          즉, 같은 기능을 하는 메서드를 여러번 반복하여 정의하지 않도록 하며 타입을 변경할 수 있도록 한다.

        // int[] iArray = {1, 2, 3, 4, 5};
        // double[] dArray = {1.0, 2.0, 3.0, 4.0, 5.0};

        // 다만 일반 자료형이 아닌 참조 자료형만 사용이 가능하기에
        // 일반 자료형은 아래와 같이 변경한 다음 사용이 가능하다.
        // int -> Integer
        // double -> Double
        Integer[] iArray = {1, 2, 3, 4, 5};
        Double[] dArray = {1.0, 2.0, 3.0, 4.0, 5.0};
        String[] sArray = {"A", "B", "C", "F", "D"};
        
        //printIntArray(iArray);
        //printDoubleArray(dArray);
        //printStringArray(sArray);

        System.out.println(" =========================== ");


        printAnyArray(iArray);
        printAnyArray(dArray);
        printAnyArray(sArray);
    }

    // 제네릭스 작성 메서드
    // T는 Type을 의미하지만, 예약어가 아닌 다른 것을 넣어도 됨. 단, 뒤의 속성에도 똑같이 입력해줘야 함.
    // 보통 T: Type, K: Key, V: Value, E: Element 를 의미.

    private static <T> void printAnyArray(T[] array) {
        for (T t: array) {
            System.out.print(t + " ");
        }
        System.out.println();
    }

//    private static void printIntArray(int[] iArray) {
//        for (int i: iArray) {
//            System.out.print(i + " ");
//        }
//        System.out.println();
//    }
//    private static void printDoubleArray(double[] dArray) {
//        for (double d: dArray) {
//            System.out.print(d + " ");
//        }
//        System.out.println();
//    }
//
//    private static void printStringArray(String[] sArray) {
//        for (String s: sArray) {
//            System.out.print(s + " ");
//        }
//    }

}
