package chap_10;

import chap_10.converter.Conterable;
import chap_10.converter.KRWConverter;

public class _04_FunctionalInterface {
    public static void main(String[] args) {
        KRWConverter converter = new KRWConverter();
        // converter.convert(1);
        // convertUSD(converter, 2); // 현재 converter는 KRWConverter의 convert() 메서드를 실행하고자 하는 것일 뿐이기에 아래와 같이 작성도 가능.

        //convertUSD((USD) -> System.out.println(USD + " 달러 = " + (USD*1400) + "원"), 30);
        Conterable conterable = (USD) -> System.out.println(USD + " 달러 = " + (USD*1400) + "원"); // <- 함수형 인터페이스
        convertUSD(conterable, 1);
    }

    public static void convertUSD(Conterable conterter, int USD) {
        conterter.convert(USD);
    }
}
