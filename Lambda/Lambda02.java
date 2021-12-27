package Lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Lambda02 {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>(Arrays.asList(12, -3, 65, 3, 7, 34, 22, -60, 42, 15));
		ciftKareMax(list);
		System.out.println();
		System.out.println(" *** ");
		toplaEl1(list);
		System.out.println();
		System.out.println(" *** ");
		carpCiftEl1(list);
		System.out.println();
		System.out.println(" *** ");
		carpCiftEl2(list);
		System.out.println();
		System.out.println(" *** ");
		mini4(list);
		System.out.println();
		System.out.println(" *** ");
		onBestenBuyukTekSayý(list);

	}
	// List'in çift olan elemanlarýn karelerini aliniz ve en buyugunu yazdýrýnýz

	public static void ciftKareMax(List<Integer> list) {
//		Optional<Integer> maxEl = list.stream().filter(Lambda01::ciftBul).map(t -> t * t).reduce(Integer::max);
		Optional<Integer> maxEl = list.stream().filter(Lambda01::ciftBul).map(t -> t * t).reduce(Integer::max);
		//reduce(Math::max) da kullanýlabilir ancak ýnteger  daha specific oldugu için hýzlý çalýþýr
		// reduce() return edilen eleman null yada int'den buyuk olur ihtimali için Java
		// güvenlik olarak handle ederek
		// optional class gerekli kýlýyor
		System.out.println(maxEl);
	}

	//Listteki tüm elemanlarýn toplamýný yazdýrýn Lambda exp.
	
	public static void toplaEl1(List<Integer> list) {
		Optional<Integer> toplam=list.stream().reduce((t,u)->t+u);
		//t her zaman deðerini atanan deðerden alýr
		//u her zaman deðerini list.stream()'den alýr(akýþ)
		//t ilk degerden sonraki degerlerini iþlemden alýr
		
		System.out.println(toplam);
	}
	//Listteki tüm elemanlarýn toplamýný yazdýrýn
	//Method reference
	public static void toplaEl2(List<Integer> list) {
		Optional<Integer> toplam=list.stream().reduce(Integer::sum);
		Optional<Integer> toplam2=list.stream().reduce(Math::addExact);
		//t her zaman deðerini atanan deðerden alýr
		//u her zaman deðerini list.stream()'den alýr(akýþ)
		//t ilk degerden sonraki degerlerini iþlemden alýr
		
		System.out.println(toplam);
	}
	//List'teki cift elemanlarin carpimini yazdiriniz.
	//Method Reference...
	
	public static void carpCiftEl1(List<Integer> list) {
	Optional<Integer>carp=list.stream().filter(Lambda01::ciftBul).reduce(Math::multiplyExact);
		
		System.out.println(carp);
	}
	
	//List'teki cift elemanlarin  yazdiriniz.
	//Lambda expression...
	
	public static void carpCiftEl2(List<Integer> list) {
		Optional<Integer>carp=list.stream().filter(Lambda01::ciftBul).reduce((x,y)->(x*y));
		//pozitif deðer üretiniz
			System.out.println(carp);
		}
	//List'teki elemanlardan en kucugunu 4 farklý yontem ile yazdiriniz
	
	public static void mini1(List<Integer> list) {
		Optional<Integer>min=list.stream().reduce(Integer::min);
		System.out.println(min);
	}
	public static void mini2(List<Integer> list) {
		Optional<Integer>min=list.stream().reduce(Math::min);
		System.out.println(min);
	}
	public static int minBul(int x,int y) {
		return x<y?x:y;
	}
	public static void mini3(List<Integer> list) {
		Optional<Integer>min=list.stream().reduce(Lambda02::minBul);
		System.out.println(min);
	}
	public static void mini4(List<Integer> list) {
		Optional<Integer>min=list.stream().reduce((x,y)->x<y?x:y);
		System.out.println(min);
	}
	//List'teki 15'ten buyuk en kucvuk tek sayiyi yazdiriniz
	
	public static void onBestenBuyukTekSayý(List<Integer> list) {
	System.out.println(	list.
							stream().
							filter(t-> t%2==1).
							filter(t-> t>15).
							reduce(Integer::min));
    //list'in cift  elemanlarinin kareleri ni kucukten buyuge yazdiriniz
	}
    public static void ciftElKareSýralý(List<Integer> list){
       list.
                stream().
                distinct().
                filter(Lambda01::ciftBul).
                map(t-> t*t).
                sorted().
                forEach(Lambda01::printEl);
    }
//list'in tek  elemanlarinin kareleri ni buykten kucuge  yazdiriniz
    public static void tekKareBuyuktenKucuge(List<Integer> list){
  list.
            stream().
            distinct().
            filter(t-> t%2!=0).
            map(t-> t*t).
            sorted(Comparator.reverseOrder()).
            forEach(Lambda01::printEl);
}

			
	
	
	
	
}
