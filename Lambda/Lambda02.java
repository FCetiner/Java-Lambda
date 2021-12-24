package Lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Lambda02 {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>(Arrays.asList(12, -3, 65, 3, 7, 34, 22, -60, 42, 15));
		ciftKareMax(list);
		System.out.println();
		System.out.println(" *** ");
		toplaEl1(list);

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
	public static void carpEl1(List<Integer> list) {
		Optional<Integer> toplam=list.stream().reduce(Integer::sum);
		Optional<Integer> toplam2=list.stream().reduce(Math::addExact);
		//t her zaman deðerini atanan deðerden alýr
		//u her zaman deðerini list.stream()'den alýr(akýþ)
		//t ilk degerden sonraki degerlerini iþlemden alýr
		
		System.out.println(toplam);
	}
}
