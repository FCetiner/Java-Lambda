package practice;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Q03 {
	 public static void main(String[] args) {
	        //String isimlerden olusan bir list olusturun
	        //Konsoldaki farklý öðeleri uzunluklarýyla birlikte yazdýrýn.
	//Konsoldaki farklý öðeleri yazdýrýn, uzunluklarýna göre sýralayýn.
	//Konsoldaki farklý öðeleri yazdýrýn, son karakterlerine göre sýralayýn.
	//Konsoldaki farklý öðeleri ters sýrada yazdýrýn.
	//Uzunluðu 7'den küçük olan farklý öðeleri ters sýrada konsolda büyük harflerle yazdýrýn.
	        List<String> list=new ArrayList<>();
	        list.add("Lutfullah");
	        list.add("Emine");
	        list.add("Emine");
	        list.add("Yusuf");
	        list.add("Seyfullah");
	        list.add("Hakan");

	        list.stream().distinct().forEach(t-> System.out.println(t+"="+t.length()));
	        System.out.println();
	        System.out.println("*********************");
	        list.stream().distinct().sorted(Comparator.comparing(t-> t.length()-1)).forEach(t-> System.out.print(t+" "));
	        System.out.println();
	        System.out.println("*********************");
	        //Konsoldaki farklý öðeleri yazdýrýn, son karakterlerine göre sýralayýn
	        list.stream().distinct().sorted(Comparator.comparing(t-> t.charAt(t.length()-1))).forEach(t-> System.out.print(t+" "));
	        System.out.println();
	        System.out.println("*********************");
	        //Konsoldaki farklý öðeleri ters sýrada yazdýrýn.
	        list.stream().distinct().sorted(Comparator.reverseOrder()).forEach(t-> System.out.println(t));
	        System.out.println();
	        System.out.println("*********************");
	        //Uzunluðu 7'den küçük olan farklý öðeleri ters sýrada konsolda büyük harflerle yazdýrýn.
	        list.
	                stream().
	                distinct().
	                filter(t->t.length()<7).
	                map(t-> t.toUpperCase()).
	                sorted(Comparator.reverseOrder()).
	                forEach(t-> System.out.print(t+" "));

	    }
	}