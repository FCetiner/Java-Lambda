package Lambda;

import java.util.OptionalInt;
import java.util.stream.IntStream;

public class Lambda05 {

	public static void main(String[] args) {

        System.out.println(topla(10));
        System.out.println();
        System.out.println(" *** ");
        System.out.println(topla1(10));
        System.out.println();
        System.out.println(" *** ");
        System.out.println(topla2(10));
        System.out.println();
        System.out.println(" *** ");
        System.out.println(toplaIlkCift(10));
        System.out.println();
        System.out.println(" *** ");
        System.out.println(toplaIlkTek(10));
        System.out.println();
        System.out.println(" *** ");
        ikiIlkXKuvvet(5);
        System.out.println();
        System.out.println(" *** ");
        istenenSayiIlkXKuvvet(2, 3);// t�m kuvvetleri yazd�r�r
        System.out.println();
        System.out.println(" *** ");
        System.out.println(istenenSay�XKuvvet(2, 4));//x. kuvvet
        System.out.println();
        System.out.println(" *** ");
        System.out.println(istenenSay�Faktoriyel(3));

    }

    //TASK 01 --> Structured Programming ve Functional Programming ile 1'den x'e kadar tamsayilari toplayan bir program yaziniz.
    public static int topla(int x) {
        int toplam = 0;
        for (int i = 0; i < x; i++) {
            toplam += i;
        }
        return toplam;
    }

    public static int topla1(int x) {

        return IntStream.range(1, x + 1).sum();//1,2,3,..x elemanlar�n�n ak���
        //1 dahil x+1 haric
    }

    public static int topla2(int x) {

        return IntStream.rangeClosed(1, x).sum();//1 ve x dahil
    }

    //TASK 02 --> 1'den x'e kadar cift tamsayilari toplayan bir program yaziniz
    public static int toplaCift(int x) {
        return IntStream.rangeClosed(1, x).
                filter(Lambda01::ciftBul).
                sum();
    }

    //TASK 03 --> Ilk x pozitif cift sayiyi toplayan program yaziniz
    public static int toplaIlkCift(int x) {
        return IntStream.iterate(2, t -> t + 2).//2 4 6 ... x elemanlar�n ak���
                limit(x).//cift cift artt�g� i�in
                sum();
    }

    //TASK 04 --> Ilk X pozitif tek tamsayiyi toplayan programi yaziniz
    public static int toplaIlkTek(int x) {
        return IntStream.iterate(1, t -> t + 2).//1 3 5... x elemanlar�n ak���
                limit(x).//ak��taki ilk x eleman� verir
                sum();
    }

    //TASK 05 --> 2'nin ilk x kuvvetini ekrana yazdiran programi yaziniz
    public static void ikiIlkXKuvvet(int x) {
        IntStream.iterate(2, t -> t * 2).
                limit(x).//ak��taki ilk x eleman� ald�k
                forEach(Lambda01::printEl);
    }

    //TASK 06 --> Istenilen bir sayinin ilk x kuvvetini ekrana yazdiran programi yaziniz
    public static void istenenSayiIlkXKuvvet(int a, int x) {
        IntStream.iterate(a, t -> t * a).//a a*2 a*3
                limit(x).//ak��taki ilk x eleman� ald�k
                forEach(Lambda01::printEl);
    }

    //TASK 07 --> Istenilen bir sayinin faktoriyelini hesaplayan programi yaziniz
    public static OptionalInt istenenSay�Faktoriyel(int x) {
        return IntStream.rangeClosed(1, x).reduce(Math::multiplyExact);

    }

    //TASK 08 --> Istenilen bir sayinin ilk x kuvvetini bulan programi yaziniz
    public static int istenenSay�XKuvvet(int a, int x) {
        return IntStream.iterate(a, t -> t * a).//a a*2 a*3
                limit(x).//ak��taki ilk x eleman� ald�k
                reduce(0, (t, u) -> u);
        // skip(x-1); skip den sonra ��kan elemanlar� toList yaparak yazd�r�lmal�

    }

}