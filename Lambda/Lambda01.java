package Lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Lambda01 {
	/*
	 * 1) Lambda "Functional Programming" "Functional Programming" de
	 * "Nasil yaparim?" degil "Ne yaparim?" dusunulur. 2) "Structured Programming"
	 * de "Ne yaparim?" dan cok "Nasil Yaparim?" dusunulur 3)
	 * "Functional Programming" hiz, code kisaligi, code okunabilirligi ve hatasiz
	 * code yazma acilarindan cok faydalidir. 4) Lambda sadece
	 * collections'larda(List, Queue ve Set) ve array'lerde kullanilabilir ancak
	 * map'lerde kullanýlmaz. Lambda kullanmak hatasýz code kullanmaktýr.
	 */
	public static void main(String[] args) {

		List<Integer> list = new ArrayList<>(Arrays.asList(12, 13, 65, 3, 7, 34, 22, 60, 42, 55));
		printElStructured(list);// method call
		System.out.println();
		System.out.println("*****");
		printElfunctional(list);
		System.out.println();
		System.out.println("*****");
		printElfunctional1(list);
		System.out.println();
		System.out.println("*****");
		printCiftElStructured(list);
		System.out.println();
		System.out.println("*****");
		printCiftElFunctional1(list);
		System.out.println();
		System.out.println("*****");
		printCiftElFunctional2(list);
		System.out.println();
		System.out.println("*****");
		printCiftAltmýsKucuk(list);
		System.out.println();
		System.out.println("*****");
		tekYirmidenBuyukPrint(list);
		System.out.println();
		System.out.println("*****");
		ciftElKare1(list);
		System.out.println();
		System.out.println("*****");
		küpBirFazlaTekFunction(list);
		System.out.println();
		System.out.println("*****");
		karekokCiftFunctional(list);
		System.out.println();
		System.out.println("*****");
		maxElFunction(list);

	}

	// structured Programming ile list elemanlerinin tamamini aralarina bosluk
	// birakarak yazdiriniz
	public static void printElStructured(List<Integer> list) {
		for (Integer w : list) {
			System.out.print(w + " ");
		}
	}
	// Functional Programming ile list elemanlerinin tamamini aralarina bosluk
	// birakarak yazdiriniz

	public static void printElfunctional(List<Integer> list) {
		list.stream().forEach(t -> System.out.print(t + " ")); // t lambda expression Lambda ifadesi
		// stream() : datalarý yukarýdan aþagýya akýþ þekline getirir
		// forEach() : datanýn parametresine gore her bir elemaný iþler
		// t-> lambda operatory
		// Lambda expression yapýsý çok tavsiye edilmez daha çok Method reference
		// kullanýlýr

	}

	// Method Reference --> kendi create ettigimiz veya java'dan aldigimiz method ile
	// ClassName::MethodName

	public static void printEl(int t) { // refere edilecek method create edildi
		System.out.print(t + " ");
	}

	public static void printElfunctional1(List<Integer> list) {
		list.stream().forEach(Lambda01::printEl);
	}

	// structured Programming ile list elemanlerinin cift olanalrini ayni satirda
	// aralarina bosluk birakarak yazdiriniz
	public static void printCiftElStructured(List<Integer> list) {
		for (Integer w : list) {
			if (w % 2 == 0) {
				System.out.print(w + " ");
			}
		}
	}

	// Functional Programming ile list elemanlerinin cift olanalrini ayni satirda
	// aralarina bosluk birakarak yazdiriniz

	public static void printCiftElFunctional1(List<Integer> list) {
		list.stream().filter(t -> t % 2 == 0).forEach(Lambda01::printEl);
		// filter() akýþ içerisindeki elemanlarý istenen þarta göre filtreleme yapar
	}

	public static boolean ciftBul(int i) {// refere edilecek tohum method create Edildi
		return i % 2 == 0;
	}

	public static void printCiftElFunctional2(List<Integer> list) {
		list.stream().filter(Lambda01::ciftBul).forEach(Lambda01::printEl);
	}

	// Functional Programming ile list elemanlerinin cift olanalrini 60'dan küçük
	// olanlarýný ayni satirda aralarina bosluk birakarak yazdiriniz

	public static void printCiftAltmýsKucuk(List<Integer> list) {
		list.stream().filter(t -> t % 2 == 0 & t < 60).forEach(Lambda01::printEl);
	}

	// Functional Programming ile list elemanlerinin cift olanalrini veya 20'dan
	// büyük
	// olanlarýný ayni satirda aralarina bosluk birakarak yazdiriniz

	public static void tekYirmidenBuyukPrint(List<Integer> list) {
		list.stream().filter(t -> t % 2 == 1 || t > 20).forEach(Lambda01::printEl);
	}
	// Functional Programming ile list elemanlarinin cift olanlarýnýn karelerini
	//ayni satirda aralarina bosluk birakarak yazdiriniz
	
	public static void ciftElKare1(List<Integer> list) {
		list.stream().filter(Lambda01::ciftBul).map(t->t*t).forEach(Lambda01::printEl);
		//map bir ara iþlemdir elemanlarý istenen iþleme göre deðiþtirmek için kullanýlýr
	}
//	public static void ciftElKare2(List<Integer> list) {
//		list.stream().filter(Lambda01::ciftBul).map(Math::pow).forEach(Lambda01::printEl); //math pow double istediði için olmadý
//		
//	}
	
	//Functional Programming ile list elemanlarinin  tek olanlarinin
	// kuplerinin bir fazlasini ayni satirda aralarina bosluk birakarak yazdiriniz
	
	public static void küpBirFazlaTekFunction(List<Integer> list) {
		list.
				stream().
				filter(t->t%2==1).
				map(t-> (t*t*t)+1).
				forEach(Lambda01::printEl);
	}
	
	
	//Functional Programming ile list elemanlarinin  cift olanlarinin
	// karekoklerini ayni satirda aralarina bosluk birakarak yazdiriniz
	
	public static void karekokCiftFunctional(List<Integer> list) {
		list.
				stream().
				filter(Lambda01::ciftBul).
				map(Math::sqrt).
				forEach(t->System.out.println(t+" "));
	}
	
	//Listin en büyük elemanlarýný yazdýrýn
	
	public static void maxElFunction(List<Integer> list){
		Optional<Integer> maxEl=list.stream().reduce(Math::max);//Optional kýsmýný coklu type dir String olarak da alabilirdik
		System.out.println(maxEl);
		//reduce()-->azaltmak... bir çok datayý tek bir dataya(max min top vs iþlemler) çevirmek için kullanýlýr
		
	}
	
	
	
	
}
