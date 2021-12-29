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
        Files.lines(Paths.get("src/metin.txt")).//file eriþip file satýrlarý akýþ alýndý
                forEach(System.out::println);


        //TASK 02 --> haluk.txt dosyasini buyuk harflerle okuyunuz.(Console'a buyuk harflerle yazdiriniz)
        System.out.println("\n*** haluk.txt dosyasini buyuk harflerle okuyunuz -->  ");
        Files.lines(Paths.get("src/metin.txt")).//file eriþip file satýrlarý akýþ alýndý
                map(String::toUpperCase).//akýþdaki satýrlar büyük harf ile update edildi
                forEach(System.out::println);
        //TASK 03 --> haluk.txt dosyasindaki ilk satiri kucuk harflerle yazdiriniz.
        System.out.println("\n*** haluk.txt dosyasindaki ilk satiri kucuk harflerle okuyunuz 01 -->  ");
        Files.lines(Paths.get("src/metin.txt")).//file eriþip file satýrlarý akýþ alýndý
                limit(1).// ilk satýr alýndý
                map(String::toLowerCase).//küçük harf yapýldý
                forEach(System.out::println);
        //TASK 04 --> haluk.txt dosyasinda "basari" kelimesinin kac satirda gectiginiz yazdiriniz
        System.out.println("\n*** haluk.txt dosyasinda basari kelimesinin kac satirda gectiginiz yazdiriniz -->  ");
        System.out.println( Files.lines(Paths.get("src/metin.txt")).//file eriþip file satýrlarý akýþ alýndý
                filter(t-> t.contains("basari")).//basarý içerme þartý
                count()) ; // sartý saglayan akýþdaki elemanlar sayýldý


        //TASK 05 --> haluk.txt dosyasindaki farkli kelimeleri  yazdiriniz.
        System.out.println("\n*** haluk.txt dosyasindaki farkli kelimeleri  yazdiriniz. -->  ");
        System.out.println( Files.lines(Paths.get("src/metin.txt")).
                map(t-> t.split(" ")).//" " gore satýrdaki elemanlarý parcalayýp arraya atadý
                flatMap(Arrays::stream).//Arrays classýndan stream() ile array elemanlarýndan yeni bir akýþ oluþturdu
                distinct().//yeni akýþtaki array elemanlarý tekrarsýz hale getirildi
                collect(Collectors.toList()));//yeni akýþdaki tekrarsýz elemanlarý liste atandý
        //TASK 06 -->Files.lines(Paths.get("src/metin.txt")).
        //                forEach(System.out::println); haluk.txt dosyasindaki tum kelimeleri natural order  yazdiriniz.
        System.out.println("\n*** haluk.txt dosyasindaki tum kelimeleri natural order  yazdiriniz. -->  ");
        //TASK 07 --> haluk.txt dosyasinda "basari" kelimesinin kac kere gectigini buyuk harf kucuk harf bagýmsýz yaziniz.
        System.out.println("\n*** haluk.txt dosyasinda basari kelimesinin kac kere gectigini  yazdiriniz. -->  ");
        //TASK 08 --> haluk.txt dosyasinda "a" harfi gecen kelimelerin sayisini ekrana yazdiran programi yaziniz
        System.out.println("\n*** haluk.txt dosyasinda a harfi gecen kelimelerin sayisini ekrana yazdiran programi yazdiriniz. -->  ");
        //TASK 09 --> haluk.txt dosyasinda icinde "a" harfi gecen kelimeleri yazdiriniz
        System.out.println("\n*** haluk.txt dosyasinda a harfi gecen kelimeler yazdiriniz. -->  ");
        //TASK 10 --> haluk.txt dosyasinda kac /farklý harf kullanildigini yazdiriniz
        System.out.println("\n*** haluk.txt dosyasinda kac /farklý harf kullanildigini  yazdiriniz. -->  ");
        //TASK 11 --> haluk.txt dosyasinda kac farkli kelime kullanildigini yazdiriniz
        System.out.println("\n*** haluk.txt dosyasinda kac farkli kelime kullanildigini  yazdiriniz. -->  ");
    }
}
