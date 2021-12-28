package Lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Lambda03 {

	public static void main(String[] args) {
		 List<String> list = new ArrayList<String>(Arrays.asList("Mehmet", "emre", "nilgun", "y�ld�x", "kader", "emine", "islam", "islam", "emre"));

	        buyukHarfTekrarsizSira(list);
	        System.out.println();
	        System.out.println(" *** ");
	        karakterSayisiTekrarsizTersSirali(list);
	        System.out.println();
	        System.out.println(" *** ");
	        karakterSayisiSiraliEl(list);
	        System.out.println();
	        System.out.println(" *** ");
	        sonHarfineTersS�ral�El(list);
	        System.out.println();
	        System.out.println(" *** ");
	        ciftKareTekrarsizTersS�rali(list);
	        System.out.println();
	        System.out.println(" *** ");
	        harfSayisi7Kontrol(list);
	        System.out.println();
	        System.out.println(" *** ");
	        wIleBaslayanEl(list);
	        System.out.println();
	        System.out.println(" *** ");
	        xBitmeKontrol(list);
	        System.out.println();
	        System.out.println(" *** ");
	        karakterSay�s�EnBuyuk(list);
	        System.out.println();
	        System.out.println(" *** ");
	        karakterSay�s�EnBuyuk2(list);
	        System.out.println();
	        System.out.println(" *** ");
	        ilkElemanHaricSonHarfS�ral�(list);

	    }

	    //List elemanlarini alafabetik buyuk harf ve  tekrarsiz yazdiriniz
	    public static void buyukHarfTekrarsizSira(List<String> list) {
	        list.
	                stream().//akisa girdi
	                // map(t->t.toUpperCase()).//elelmanlar byk harf update edildi
	                        map(String::toUpperCase).//elelmanlar byk harf update edildi
	                sorted().//alfabetik sira
	                distinct().//tekrarsiz  yapildi
	                forEach(t -> System.out.print(t + " "));//yazdirilidi
	        //EMRE EM�NE KADER MEHMET N�LGUN YILDIZ �SLAM


	    }

	    //list elelmanlarinin character sayisini ters sirali olarak tekrarsiz yazdiriniz
	    public static void karakterSayisiTekrarsizTersSirali(List<String> list) {
	        list.
	                stream().
	                map(t -> t.length()).//String data karakter say�s�na update edildi
	                sorted(Comparator.reverseOrder()).//ters s�ra
	                distinct().//tekrars�z
	                forEach(Lambda01::printEl);//yazd�r�ld�
	    }

	    //List elemanlarini character sayisina gore kckten byk egore yazdiriniz.

	    public static void karakterSayisiSiraliEl(List<String> list) {
	        list.
	                stream().
	                sorted(Comparator.comparing(t -> t.length())).//Karakter say�s�na g�re �zel s�ralama yap�ld�
	                forEach(t -> System.out.print(t + " "));
	    }

	    //list elelmanlarinin son harfine gore ters sirali yazdiriniz
	    public static void sonHarfineTersS�ral�El(List<String> list) {
	        list.
	                stream().
	                sorted(Comparator.//Kar��la�t�rma methodlar�n�n oldugu class
	                        comparing(t -> t.toString().
	                        charAt(t.toString().length() - 1)).//son indexe kar��l�k gelen harf
	                        reversed()).//Son indexe gore ters s�ralar
	                forEach(t -> System.out.print(t + " "));
	    }

	    //uzunlugu cift sayi olan elemanlarin uzunluklarinin karelerini hesaplayan, tekrarsiz buyukten kucuge sirali yazdiriniz.
	    public static void ciftKareTekrarsizTersS�rali(List<String> list) {
	        list.
	                stream().
	                map(t -> t.length() * t.length()).
	                filter(Lambda01::ciftBul).
	                distinct().
	                sorted(Comparator.reverseOrder()).
	                forEach(Lambda01::printEl);
	    }

	    //List elelmmalarinin karakter sayisini 7 ve 7 'den az olma durumunu kontrol ediniz
	    public static void harfSayisi7Kontrol(List<String> list) {
	    /*  boolean kontrol= list.
	              stream().
	              allMatch(t-> t.length()<=7);//her bir eleman� harf say�s�n <= e�le�mesine bak
	        if(kontrol){
	             System.out.println("List elemanlar� 7 harfden buyuk de�il ");
	        }else {
	            System.out.println("List elemanlar� 7 den b�y�k");
	        }
	       // System.out.println(kontrol);*/

	        System.out.println(list.
	                stream().
	                allMatch(t -> t.length() <= 7) ?
	                "List elemanlar� 7 harfden buyuk de�il" :
	                "List elemanlar� 7 den b�y�k");
	    }

	    //List elelmanlarinin "W" ile baslamas�n� kontrol ediniz
	    public static void wIleBaslayanEl(List<String> list) {
	        System.out.println(list.
	                stream().
	                noneMatch(t -> t.toLowerCase().startsWith("w")) ? "w ile ba�layan isim yok" : "w ile ba�layan isim var");

	    }

	    public static void xBitmeKontrol(List<String> list) {
	        System.out.println(list.
	                stream().
	                anyMatch(t -> t.endsWith("x")) ? "x ile biten isim var" : "x ile biten isim yok");

	        //  noneMatch(t -> t.startsWith("w"))--->  "hicbiri W ile baslamiyor" : "birileri W ile basliyor"
	//  allMatch(t -> t.startsWith("w")) --->  "hepsi W ile basliyor" : "bir tanesi W ile baslamiyor"
	//  anyMatch(t -> t.startsWith("w")) --->  "herhangibiri W ile basliyor" : "hicbiri W ile baslamiyor"

	    }

	    //Karakter say�s� en b�y�k eleman� yazd�r�n
	    public static void karakterSay�s�EnBuyuk(List<String> list) {
	        System.out.println(list.
	                stream().
	                sorted(Comparator.comparing(t -> t.toString().length()).//length karakter uzunluguna gore s�ralad�
	                        reversed()).//ters s�ralad�
	                      findFirst());//ilk eleman� ald�
	         }

	    public static void karakterSay�s�EnBuyuk2(List<String> list) {
	      Stream<String> sonIs�m= list.
	                stream().
	                sorted(Comparator.comparing(t -> t.toString().length()).//length karakter uzunluguna gore s�ralad�
	                        reversed()).//ters s�ralad�
	                        limit(1); //limit(a) Ak��tan ��kan elemanlar� a parametresine gore limitler
	        //limit methodundan ��kan veriler datad�r bu yuzden ham verinin i�lenmesi gerekir. Bunu Liste �eviririz ve kullanabiliriz
	        //Bir magazan�n 100 musterisinden en fazla al��veri� yapan 5 mu�terisi al�nabilir ve i�leme devam edilebilir
	        System.out.println(Arrays.toString(sonIs�m.toArray()));
	    }

	    //list elemanlarini son harfine g�re siralay�p ilk eleman hari� kalan elemanlari yazdiniz

	    public static void ilkElemanHaricSonHarfS�ral� (List<String> list){
	        list.
	                stream().
	                sorted(Comparator.comparing(t->t.toString().
	                        charAt(t.length()-1))).
	                skip(1).//aki�tan ��kan elamalar�n 1. parametreyi al�r
	                forEach(t-> System.out.print(t+" "));
	    }






	}
