package Lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class Lambda04 {

	public static void main(String[] args) {
		TechPro trGunduz=new TechPro("Yaz","TR gunduz",97,124);
		TechPro engGunduz=new TechPro("Kýþ","ENG gunduz",95,131);
		TechPro trGece=new TechPro("Bahar","TR gece",98,143);
		TechPro engGece=new TechPro("Sonbahar","Eng gunduz",93,151);
		   List<TechPro> list=new ArrayList<>(Arrays.asList(trGunduz,engGunduz,trGece,engGece));

		   //bu class'da agýrlýklý olarak return type calýsacagýz

		        System.out.println(batchOrt92Byk(list));
		        System.out.println();
		        System.out.println(" *** ");
		        System.out.println(ogrSayisi110Az(list));
		        System.out.println();
		        System.out.println(" *** ");
		        System.out.println(herhangiBirBaharKontrol(list));
		        System.out.println();
		        System.out.println(" *** ");
		        System.out.println(ogrSayisinaGoreSýrali(list));
		        System.out.println();
		        System.out.println(" *** ");
		        System.out.println(batchOrtGoreTersSýrali(list));
		        System.out.println();
		        System.out.println(" *** ");
		        System.out.println(ogrSayisiEnAzIkinciBatch(list));
		        System.out.println();
		        System.out.println(" *** ");
		        System.out.println(ogrcOrt95BykOgrcSayisi(list));
		        System.out.println();
		        System.out.println(" *** ");
		        System.out.println(ogrcOrt95BykOgrcSayisi1(list));
		        System.out.println();
		        System.out.println(" *** ");
		        System.out.println(ogrcSayisi130BykBatchOrt(list));


		    }
		//batch ortalamalarýnýn 92'den büyük olanlarý bulan method create ediniz

		    public static boolean batchOrt92Byk( List<TechPro> list){
		        return list.
		                stream().
		                allMatch(t->t.getBatchOrt()>92);//akýsdaki her eleman batchort field'a gore eslesmesi kontrol edildi
		    }

		    //task 02-->ogrc sayilarinin hic birinin  110 den az olmadigini  kontrol eden pr create ediniz.

		    public static boolean ogrSayisi110Az(List<TechPro> list){
		      return  list.
		              stream().
		              noneMatch(t-> t.getOgrcSayisi()<110);
		        //allMatch(t->t.getOgrcSayisi()>=110);
		    }

		    //task 03-->batch'lerde herhangi birinde "bahar" olup olmadigini  kontrol eden pr create ediniz.

		    public static boolean herhangiBirBaharKontrol(List<TechPro> list){
		      return  list.
		              stream().
		              anyMatch(t->t.getBatch().equalsIgnoreCase("bahar"));
		    }

		    //task 04-->batch'leri ogr sayilarina gore b->k siralayiniz.
		    //liste eklemek için collect(Collectors.toList() kullandýk
		    public static List<TechPro>  ogrSayisinaGoreSýrali (List<TechPro> list){
		      return  list.
		                stream().
		                sorted(Comparator.comparing(TechPro::getOgrcSayisi).reversed()).//Ogrenci sayýsý parametresine gore ters sýralý
		                collect(Collectors.toList());//collect()->akýþtaki elemanlarý istenen þarta göre toplar
		                //Collectors.toList()->collect()'e toplanan elemanlarý liste çevirir
		    }

		    //task 05-->batch'leri batch ort gore  b->k siralayip ilk3 'unu yazdiriniz.

		    public static List<TechPro> batchOrtGoreTersSýrali (List<TechPro> list){
		      return  list.
		              stream().
		              sorted(Comparator.comparing(TechPro::getBatchOrt).reversed()).
		         //     sorted(Comparator.comparingInt(t-> t.getBatchOrt())).
		              limit(3).//akýþtaki elemanlarýn ilk 3 ü alýndý
		              collect(Collectors.toList());
		    }

		    //task 06--> ogrc sayisi en az olan 2. batch'i  yazdiriniz.

		    public static List<TechPro> ogrSayisiEnAzIkinciBatch(List<TechPro> list){
		      return  list.
		              stream().
		              sorted(Comparator.comparing(TechPro::getOgrcSayisi)).
		              limit(2).//ilk iki eleman alýndý
		              skip(1).//ilk eleman atlatýldý
		              collect(Collectors.toList());
		    }

		    //task 07--> batch ort 95 'den buyuk olan batch'lerin ogrc sayilarini toplamini yazdiriniz

		    public static int ogrcOrt95BykOgrcSayisi(List<TechPro> list){
		        return list.
		                stream().
		                filter(t->t.getBatchOrt()>95).//95 den byk sarti saglandi
		                        map(t->t.getOgrcSayisi()).//batch oert olan data ogrc sayisi olarak update edildi
		                //reduce(0,Integer::sum);//ogrc sayisi toplandi
		                        reduce(0,(t,u)->t+u);//ogrc sayisi toplandi
		    }
		 
		    
		    public static int ogrcOrt95BykOgrcSayisi1(List<TechPro> list){
		        return list.
		                stream().
		                filter(t->t.getBatchOrt()>95).//95 den byk sarti saglandi
		                        mapToInt(t->t.getOgrcSayisi()).//mapToInt()--> type gore int return ederki sum() metodu çalýþýr
		                                                        // reduce e gerek kalmaz daha kýsa ve hýzlý code imkaný saðlar
		                sum();

		    }

		    //Ogrenci sayisi 130'dan buyuk olan Batch'lerin batchOrt'larinin ortalamasini bulunuz.
		    public static OptionalDouble ogrcSayisi130BykBatchOrt(List<TechPro> list){
		       return list.
		               stream().
		               filter(t->t.getOgrcSayisi()>130).
		               mapToDouble(t->t.getBatchOrt()).
		               average();
		    }







		}

