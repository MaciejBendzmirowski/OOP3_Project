package lottoNumbers;
import java.util.Scanner;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

 
public class LottoGame implements skreslanieLotto, skreslenieMULTI {
 
 
 public void wprowadzenie(){
	 System.out.println("Type your 6 numbers : ");
	 }
 
 public void wbicie(){
	 System.out.println("Type your 10 numbers: ");
}

 public static void main(String[] args) throws MyException {
    
	int licznik = 0;
	LottoGame lotto = new LottoGame();
	Scanner odczyt = new Scanner(System.in);
	
	//HASHMAP_LOTTO
	Map<Integer, String> wygranaLOTTO = new HashMap<Integer, String>();
	wygranaLOTTO.put(0, "SORRY YOU LOOSE, TRY NEXT TIME.");
	wygranaLOTTO.put(1, "SORRY YOU LOOSE, TRY NEXT TIME.");
	wygranaLOTTO.put(2, "SORRY YOU LOOSE, TRY NEXT TIME.");
	wygranaLOTTO.put(3, "YOU WON 10 ZLOTYCH !");
	wygranaLOTTO.put(4, "YOU WON 100 ZLOTYCH !!");
	wygranaLOTTO.put(5, "YOU WON 3500 ZLOTYCH  !!!");
	wygranaLOTTO.put(6, "YOU ARE MILIONARE !!!!");
	
	//HASHMAP_MULTI
	Map<Integer, String> wygranaMulti = new HashMap<Integer, String>();
	wygranaMulti.put(0, "SORRY YOU LOOSE, TRY NEXT TIME.");
	wygranaMulti.put(1, "SORRY YOU LOOSE, TRY NEXT TIME.");
	wygranaMulti.put(2, "SORRY YOU LOOSE, TRY NEXT TIME.");
	wygranaMulti.put(3, "SORRY YOU LOOSE, TRY NEXT TIME.");
	wygranaMulti.put(4, "YOU WON 2 ZLOTE !");
	wygranaMulti.put(5, "YOU WON 4 ZLOTE !!");
	wygranaMulti.put(6, "YOU WON 12 ZLOTE  !!!");
	wygranaMulti.put(7, "YOU WON 140 ZLOTYCH  !!!");
	wygranaMulti.put(8, "YOU WON 520 ZLOTYCH  !!!");
	wygranaMulti.put(9, "YOU WON 10 000 ZLOTYCH  !!!");
	wygranaMulti.put(10, "YOU WON 250 000 ZLOTYCH !!!!");
	
	//MENU
 System.out.println("CHOOSE THE GAME : ");
 System.out.println("1 : LOTTO GAME ");
 System.out.println("2 : MULTI MULTI GAME ");
 System.out.println("3 : EXIT ");
 int choose;
 
 choose = odczyt.nextInt();
if(choose<1||choose>3)
	throw new MyException();
 
 switch(choose){
 //CASE 1
     case 1:{
         System.out.println("YOU CHOOESE LOTTO GAME ");
         
         //POBIERANIE LICZB OD GRACZA I ZAPE£NIENIE TABLICY
          lotto.wprowadzenie();
         Integer[] tab1 = new Integer[6];
         for(int a=0; a<6; a++){
             tab1[a] = odczyt.nextInt();
             if(tab1[a]<1||tab1[a]>49)
            	 throw new MyException();}
         Arrays.sort(tab1);
         
         //POBRANIE WYLOSOWANIE LICZB I WYŒWIETENIE	
          LottoNumberGenerator myLotto = new LottoNumberGenerator();
          myLotto.generateNumbers();
          System.out.println(myLotto.getLottoNumbers());
          
         //ZAMIANA TREESET NA TABLICE
         int[]ints = new int[6];
         int index = 0;
         for(Integer i : myLotto.getLottoNumbers()){
        	 ints[index++] = i;
         }
        	 
       //SPRAWDZENIE TRAFIONYCH LICZB
    	 
    	 for(int m=0;m<tab1.length;m++){
             for(int j=0;j<ints.length;j++){
                 if(tab1[m]==ints[j]){
                	 System.out.println(tab1[m]);
                	 licznik++;
                	  }
             }
    	 }
    	  System.out.println("");
         System.out.println("YOU HAVE " + licznik + " CORRECT NUMBERS" );
         //SPRAWDZENIE WYGRANEJ
         
         for(Integer key : wygranaLOTTO.keySet())
        	 key = licznik;
        	 if(wygranaLOTTO.containsKey(licznik))
        		 System.out.println(" " + wygranaLOTTO.get(licznik) );
         
        	 break;
     }
      //CASE 2
         case 2:{
             System.out.println("YOU CHOOESE MULTI MULTI GAME ");
             
           //POBIERANIE LICZB OD GRACZA I ZAPE£NIENIE TABLICY
             lotto.wbicie();
             Integer[] tab2 = new Integer[10];
             for(int b=0; b<10; b++){
                 tab2[b] = odczyt.nextInt();
                 if(tab2[b]<1||tab2[b]>80)
                	 throw new MyException();}
             Arrays.sort(tab2);
             
             //POBRANIE WYLOSOWANIE LICZB I WYŒWIETENIE	
             MultiMultiGenerator myMulti = new MultiMultiGenerator();
             myMulti.generateNumbers();   
             System.out.println(myMulti.getMultiMultiNumbers());
             
           //ZAMIANA TREESET NA TABLICE
             int[]tablic = new int[20];
             int miejsc = 0;
             for(Integer z : myMulti.getMultiMultiNumbers()){
            	 tablic[miejsc++] = z;
             }
           //SPRAWDZENIE TRAFIONYCH LICZB
        	 
        	 for(int m=0;m<tab2.length;m++){
                 for(int j=0;j<tablic.length;j++){
                     if(tab2[m]==tablic[j]){
                    	 System.out.println(tab2[m]);
                    	 licznik++;
                    	  }
                 }
        	 }
        	  System.out.println("");
             System.out.println("YOU HAVE " + licznik + " CORRECT NUMBERS" );
             //SPRAWDZENIE WYGRANEJ
             
             for(Integer key : wygranaMulti.keySet())
            	 key = licznik;
            	 if(wygranaMulti.containsKey(licznik))
            		 System.out.println(" " + wygranaMulti.get(licznik) );
        
            	 break;
         }
         //CASE 3
         case 3:{
        	 System.out.println("CLOSING APPLICATION");
        	 break;
         }
 }
 }
 
}