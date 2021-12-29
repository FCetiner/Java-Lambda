package Lambda;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Lambda06 {

	public static void main(String[] args) throws IOException {
		  //TASK 01 --> haluk.txt dosyasini okuyunuz.(Console'a yazdiriniz)
        System.out.println("\n*** haluk.txt dosyasini okuyunuz -->  ");
        Files.lines(Paths.get("src/metin.txt")).//file eri�ip file sat�rlar� ak�� al�nd�
                forEach(System.out::println);


        //TASK 02 --> haluk.txt dosyasini buyuk harflerle okuyunuz.(Console'a buyuk harflerle yazdiriniz)
        System.out.println("\n*** haluk.txt dosyasini buyuk harflerle okuyunuz -->  ");
        Files.lines(Paths.get("src/metin.txt")).//file eri�ip file sat�rlar� ak�� al�nd�
                map(String::toUpperCase).//ak��daki sat�rlar b�y�k harf ile update edildi
                forEach(System.out::println);
        //TASK 03 --> haluk.txt dosyasindaki ilk satiri kucuk harflerle yazdiriniz.
        System.out.println("\n*** haluk.txt dosyasindaki ilk satiri kucuk harflerle okuyunuz 01 -->  ");
        Files.lines(Paths.get("src/metin.txt")).//file eri�ip file sat�rlar� ak�� al�nd�
                limit(1).// ilk sat�r al�nd�
                map(String::toLowerCase).//k���k harf yap�ld�
                forEach(System.out::println);
        //TASK 04 --> haluk.txt dosyasinda "basari" kelimesinin kac satirda gectiginiz yazdiriniz
        System.out.println("\n*** haluk.txt dosyasinda basari kelimesinin kac satirda gectiginiz yazdiriniz -->  ");
        System.out.println( Files.lines(Paths.get("src/metin.txt")).//file eri�ip file sat�rlar� ak�� al�nd�
                filter(t-> t.contains("basari")).//basar� i�erme �art�
                count()) ; // sart� saglayan ak��daki elemanlar say�ld�


        //TASK 05 --> haluk.txt dosyasindaki farkli kelimeleri  yazdiriniz.
        System.out.println("\n*** haluk.txt dosyasindaki farkli kelimeleri  yazdiriniz. -->  ");
        System.out.println( Files.lines(Paths.get("src/metin.txt")).
                map(t-> t.split(" ")).//" " gore sat�rdaki elemanlar� parcalay�p arraya atad�
                flatMap(Arrays::stream).//Arrays class�ndan stream() ile array elemanlar�ndan yeni bir ak�� olu�turdu
                distinct().//yeni ak��taki array elemanlar� tekrars�z hale getirildi
                collect(Collectors.toList()));//yeni ak��daki tekrars�z elemanlar� liste atand�
        //TASK 06 -->Files.lines(Paths.get("src/metin.txt")).
        //                forEach(System.out::println); haluk.txt dosyasindaki tum kelimeleri natural order  yazdiriniz.
        System.out.println("\n*** haluk.txt dosyasindaki tum kelimeleri natural order  yazdiriniz. -->  ");
        //TASK 07 --> haluk.txt dosyasinda "basari" kelimesinin kac kere gectigini buyuk harf kucuk harf bag�ms�z yaziniz.
        System.out.println("\n*** haluk.txt dosyasinda basari kelimesinin kac kere gectigini  yazdiriniz. -->  ");
        //TASK 08 --> haluk.txt dosyasinda "a" harfi gecen kelimelerin sayisini ekrana yazdiran programi yaziniz
        System.out.println("\n*** haluk.txt dosyasinda a harfi gecen kelimelerin sayisini ekrana yazdiran programi yazdiriniz. -->  ");
        //TASK 09 --> haluk.txt dosyasinda icinde "a" harfi gecen kelimeleri yazdiriniz
        System.out.println("\n*** haluk.txt dosyasinda a harfi gecen kelimeler yazdiriniz. -->  ");
        //TASK 10 --> haluk.txt dosyasinda kac /farkl� harf kullanildigini yazdiriniz
        System.out.println("\n*** haluk.txt dosyasinda kac /farkl� harf kullanildigini  yazdiriniz. -->  ");
        //TASK 11 --> haluk.txt dosyasinda kac farkli kelime kullanildigini yazdiriniz
        System.out.println("\n*** haluk.txt dosyasinda kac farkli kelime kullanildigini  yazdiriniz. -->  ");
    }
}
