package practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Q02 {
//  2) Bir class oluþturun, 'Q03' olarak adlandýrýn
//  3) 5 elemanlý bir tamsayý listesi oluþturun
//  4) Elemanlari doðal sýraya koyun
//  5)Konsoldaki son 3 elemanýn karelerinin toplamýný bulun.
//  6) Konsoldaki toplamý yazdýrýn
//  7) 'Fonksiyonel Programlama' kullanýn
public static void main(String[] args) {
  List<Integer> list = new ArrayList<>();
  list.add(5);//0
  list.add(7);//1
  list.add(1);//2
  list.add(4);//3
  list.add(3);//4

  Collections.sort(list);
  System.out.println(list);

  int sonuc = list.stream()
          .filter(t -> list.indexOf(t) > 1)
          .map(t -> t * t)
          .reduce(0, (t, u) -> t + u);
  System.out.println(sonuc);

}
}