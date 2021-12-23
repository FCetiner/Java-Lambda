package Lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lambda01 {
/*
		   1) Lambda "Functional Programming"
		      "Functional Programming" de "Nasil yaparim?" degil "Ne yaparim?" dusunulur.
		   2) "Structured Programming" de "Ne yaparim?" dan cok "Nasil Yaparim?" dusunulur
		   3) "Functional Programming" hiz, code kisaligi, code okunabilirligi
		   ve hatasiz code yazma acilarindan cok faydalidir.
		   4) Lambda sadece collections'larda(List, Queue ve Set) ve array'lerde kullanilabilir ancak map'lerde kullan�lmaz.
		      Lambda kullanmak hatas�z code kullanmakt�r.
		*/
	public static void main(String[] args) {
		
		List <Integer>list=new ArrayList<>(Arrays.asList(12,13,65,3,7,34,22,60,42,55));
		printElStructured(list);//method call
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

	}
	//structured Programming ile list elemanlerinin  tamamini aralarina bosluk birakarak yazdiriniz
	public static void printElStructured(List <Integer>list) {
		for (Integer w : list) {
			System.out.print(w+" ");
		}	
	}
	//Functional Programming ile list elemanlerinin  tamamini aralarina bosluk 
			//birakarak yazdiriniz
	
	public static void printElfunctional(List <Integer>list) {
		list.stream().forEach(t->System.out.print(t+" ")); 				//t lambda expression Lambda ifadesi
		//stream() : datalar� yukar�dan a�ag�ya ak�� �ekline getirir
		//forEach() : datan�n parametresine gore her bir eleman� i�ler
		//t-> lambda operatory
		//Lambda expression yap�s� �ok tavsiye edilmez daha �ok Method reference kullan�l�r
	
	}
	
	//Method Reference --> kendi create ettigimiz veya java'dan aldigimiz method ile 
	// ClassName::MethodName
	
	public static void printEl(int t){ //refere edilecek method create edildi
		System.out.print(t+" ");
	}
	
	public static void printElfunctional1(List <Integer>list) {
		list.stream().forEach(Lambda01::printEl);
	}
	
	//structured Programming ile list elemanlerinin  cift olanalrini ayni satirda aralarina bosluk birakarak yazdiriniz
	public static void printCiftElStructured(List <Integer>list) {
		for (Integer w : list) {
			if (w%2==0) {
				System.out.print(w+" ");
			}
		}
	}
	
	//Functional Programming ile list elemanlerinin  cift olanalrini ayni satirda aralarina bosluk birakarak yazdiriniz

	public static void printCiftElFunctional1(List <Integer>list) {
		list.stream().filter(t->t%2==0).forEach(Lambda01::printEl);
		
		
	}
	

}
