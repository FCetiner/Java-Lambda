package Lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Lambda03 {

	public static void main(String[] args) {
		 List<String> list = new ArrayList<String>(Arrays.asList("Mehmet", "emre", "nilgun", "yýldýx", "kader", "emine", "islam", "islam", "emre"));

	        buyukHarfTekrarsizSira(list);
	        System.out.println();
	        System.out.println(" *** ");
	        karakterSayisiTekrarsizTersSirali(list);
	        System.out.println();
	        System.out.println(" *** ");
	        karakterSayisiSiraliEl(list);
	        System.out.println();
	        System.out.println(" *** ");
	        sonHarfineTersSýralýEl(list);
	        System.out.println();
	        System.out.println(" *** ");
	        ciftKareTekrarsizTersSýrali(list);
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
	        karakterSayýsýEnBuyuk(list);
	        System.out.println();
	        System.out.println(" *** ");
	        karakterSayýsýEnBuyuk2(list);
	        System.out.println();
	        System.out.println(" *** ");
	        ilkElemanHaricSonHarfSýralý(list);

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
	        //EMRE EMÝNE KADER MEHMET NÝLGUN YILDIZ ÝSLAM


	    }

	    //list elelmanlarinin character sayisini ters sirali olarak tekrarsiz yazdiriniz
	    public static void karakterSayisiTekrarsizTersSirali(List<String> list) {
	        list.
	                stream().
	                map(t -> t.length()).//String data karakter sayýsýna update edildi
	                sorted(Comparator.reverseOrder()).//ters sýra
	                distinct().//tekrarsýz
	                forEach(Lambda01::printEl);//yazdýrýldý
	    }

	    //List elemanlarini character sayisina gore kckten byk egore yazdiriniz.

	    public static void karakterSayisiSiraliEl(List<String> list) {
	        list.
	                stream().
	                sorted(Comparator.comparing(t -> t.length())).//Karakter sayýsýna göre özel sýralama yapýldý
	                forEach(t -> System.out.print(t + " "));
	    }

	    //list elelmanlarinin son harfine gore ters sirali yazdiriniz
	    public static void sonHarfineTersSýralýEl(List<String> list) {
	        list.
	                stream().
	                sorted(Comparator.//Karþýlaþtýrma methodlarýnýn oldugu class
	                        comparing(t -> t.toString().
	                        charAt(t.toString().length() - 1)).//son indexe karþýlýk gelen harf
	                        reversed()).//Son indexe gore ters sýralar
	                forEach(t -> System.out.print(t + " "));
	    }

	    //uzunlugu cift sayi olan elemanlarin uzunluklarinin karelerini hesaplayan, tekrarsiz buyukten kucuge sirali yazdiriniz.
	    public static void ciftKareTekrarsizTersSýrali(List<String> list) {
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
	              allMatch(t-> t.length()<=7);//her bir elemaný harf sayýsýn <= eþleþmesine bak
	        if(kontrol){
	             System.out.println("List elemanlarý 7 harfden buyuk deðil ");
	        }else {
	            System.out.println("List elemanlarý 7 den büyük");
	        }
	       // System.out.println(kontrol);*/

	        System.out.println(list.
	                stream().
	                allMatch(t -> t.length() <= 7) ?
	                "List elemanlarý 7 harfden buyuk deðil" :
	                "List elemanlarý 7 den büyük");
	    }

	    //List elelmanlarinin "W" ile baslamasýný kontrol ediniz
	    public static void wIleBaslayanEl(List<String> list) {
	        System.out.println(list.
	                stream().
	                noneMatch(t -> t.toLowerCase().startsWith("w")) ? "w ile baþlayan isim yok" : "w ile baþlayan isim var");

	    }

	    public static void xBitmeKontrol(List<String> list) {
	        System.out.println(list.
	                stream().
	                anyMatch(t -> t.endsWith("x")) ? "x ile biten isim var" : "x ile biten isim yok");

	        //  noneMatch(t -> t.startsWith("w"))--->  "hicbiri W ile baslamiyor" : "birileri W ile basliyor"
	//  allMatch(t -> t.startsWith("w")) --->  "hepsi W ile basliyor" : "bir tanesi W ile baslamiyor"
	//  anyMatch(t -> t.startsWith("w")) --->  "herhangibiri W ile basliyor" : "hicbiri W ile baslamiyor"

	    }

	    //Karakter sayýsý en büyük elemaný yazdýrýn
	    public static void karakterSayýsýEnBuyuk(List<String> list) {
	        System.out.println(list.
	                stream().
	                sorted(Comparator.comparing(t -> t.toString().length()).//length karakter uzunluguna gore sýraladý
	                        reversed()).//ters sýraladý
	                      findFirst());//ilk elemaný aldý
	         }

	    public static void karakterSayýsýEnBuyuk2(List<String> list) {
	      Stream<String> sonIsým= list.
	                stream().
	                sorted(Comparator.comparing(t -> t.toString().length()).//length karakter uzunluguna gore sýraladý
	                        reversed()).//ters sýraladý
	                        limit(1); //limit(a) Akýþtan çýkan elemanlarý a parametresine gore limitler
	        //limit methodundan çýkan veriler datadýr bu yuzden ham verinin iþlenmesi gerekir. Bunu Liste çeviririz ve kullanabiliriz
	        //Bir magazanýn 100 musterisinden en fazla alýþveriþ yapan 5 muþterisi alýnabilir ve iþleme devam edilebilir
	        System.out.println(Arrays.toString(sonIsým.toArray()));
	    }

	    //list elemanlarini son harfine göre siralayýp ilk eleman hariç kalan elemanlari yazdiniz

	    public static void ilkElemanHaricSonHarfSýralý (List<String> list){
	        list.
	                stream().
	                sorted(Comparator.comparing(t->t.toString().
	                        charAt(t.length()-1))).
	                skip(1).//akiþtan çýkan elamalarýn 1. parametreyi alýr
	                forEach(t-> System.out.print(t+" "));
	    }






	}
