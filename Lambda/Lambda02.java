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
		System.out.println();
		System.out.println(" *** ");
		carpCiftEl1(list);
		System.out.println();
		System.out.println(" *** ");
		carpCiftEl2(list);
		System.out.println();
		System.out.println(" *** ");
		mini4(list);

	}
	// List'in �ift olan elemanlar�n karelerini aliniz ve en buyugunu yazd�r�n�z

	public static void ciftKareMax(List<Integer> list) {
//		Optional<Integer> maxEl = list.stream().filter(Lambda01::ciftBul).map(t -> t * t).reduce(Integer::max);
		Optional<Integer> maxEl = list.stream().filter(Lambda01::ciftBul).map(t -> t * t).reduce(Integer::max);
		//reduce(Math::max) da kullan�labilir ancak �nteger  daha specific oldugu i�in h�zl� �al���r
		// reduce() return edilen eleman null yada int'den buyuk olur ihtimali i�in Java
		// g�venlik olarak handle ederek
		// optional class gerekli k�l�yor
		System.out.println(maxEl);
	}

	//Listteki t�m elemanlar�n toplam�n� yazd�r�n Lambda exp.
	
	public static void toplaEl1(List<Integer> list) {
		Optional<Integer> toplam=list.stream().reduce((t,u)->t+u);
		//t her zaman de�erini atanan de�erden al�r
		//u her zaman de�erini list.stream()'den al�r(ak��)
		//t ilk degerden sonraki degerlerini i�lemden al�r
		
		System.out.println(toplam);
	}
	//Listteki t�m elemanlar�n toplam�n� yazd�r�n
	//Method reference
	public static void toplaEl2(List<Integer> list) {
		Optional<Integer> toplam=list.stream().reduce(Integer::sum);
		Optional<Integer> toplam2=list.stream().reduce(Math::addExact);
		//t her zaman de�erini atanan de�erden al�r
		//u her zaman de�erini list.stream()'den al�r(ak��)
		//t ilk degerden sonraki degerlerini i�lemden al�r
		
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
		//pozitif de�er �retiniz
			System.out.println(carp);
		}
	//List'teki elemanlardan en kucugunu 4 farkl� yontem ile yazdiriniz
	
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
	
	
}
