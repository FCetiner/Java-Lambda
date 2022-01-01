package practice;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Q03 {
	 public static void main(String[] args) {
	        //String isimlerden olusan bir list olusturun
	        //Konsoldaki farkl� ��eleri uzunluklar�yla birlikte yazd�r�n.
	//Konsoldaki farkl� ��eleri yazd�r�n, uzunluklar�na g�re s�ralay�n.
	//Konsoldaki farkl� ��eleri yazd�r�n, son karakterlerine g�re s�ralay�n.
	//Konsoldaki farkl� ��eleri ters s�rada yazd�r�n.
	//Uzunlu�u 7'den k���k olan farkl� ��eleri ters s�rada konsolda b�y�k harflerle yazd�r�n.
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
	        //Konsoldaki farkl� ��eleri yazd�r�n, son karakterlerine g�re s�ralay�n
	        list.stream().distinct().sorted(Comparator.comparing(t-> t.charAt(t.length()-1))).forEach(t-> System.out.print(t+" "));
	        System.out.println();
	        System.out.println("*********************");
	        //Konsoldaki farkl� ��eleri ters s�rada yazd�r�n.
	        list.stream().distinct().sorted(Comparator.reverseOrder()).forEach(t-> System.out.println(t));
	        System.out.println();
	        System.out.println("*********************");
	        //Uzunlu�u 7'den k���k olan farkl� ��eleri ters s�rada konsolda b�y�k harflerle yazd�r�n.
	        list.
	                stream().
	                distinct().
	                filter(t->t.length()<7).
	                map(t-> t.toUpperCase()).
	                sorted(Comparator.reverseOrder()).
	                forEach(t-> System.out.print(t+" "));

	    }
	}