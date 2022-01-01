package practice;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Q01 {
	 //        2) "Q01" olarak adland�r�lan bir class olu�turun
//  3) 5 String ��esi i�eren bir String listolu�turun.
//  4) 3 tanesi "A" harfi ile ba�layacak
//  5) Elemanlar "A" harfi ile ba�l�yorsa ve elemanlar�n uzunluklar�
//  5'ten k���kse, konsolda list olarak buyuk harflerle yazd�r�n.
	public static void main(String[] args) {
	        List<String> list=new ArrayList<>();
	        list.add("Angelea");
	        list.add("Andy");
	        list.add("Ali");
	        list.add("Emrah");
	        list.add("Nilgun");
	        System.out.println( list.stream().
	                filter(t-> t.startsWith("A")).
	                filter(t-> t.length()<5).map(String::toUpperCase).
	                collect(Collectors.toList()));
	    }



	}
