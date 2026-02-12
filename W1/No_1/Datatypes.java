import java.util.Scanner;

public class Datatypes{

    // Main
    public static void main (String[] args){
        Scanner scanUtama = new Scanner(System.in);
        String tByte="-Byte";
        String tShort="-Short";
        String tInt="-Int";
        String tLong="-Long";


        System.out.println("==Program penyimpan angka==");
        System.out.println("Berapa banyak angka?");
        int j = scanUtama.nextInt();
        scanUtama.nextLine();
            for(int i = 0; i < j; i++){
                try{
                    System.out.println("Masukan Angka:");
                    long angka = scanUtama.nextLong();
                    System.out.println(angka + " Can be fitted in:");
                    if(angka >= Byte.MIN_VALUE && angka <= Byte.MAX_VALUE){
                        System.out.println(tByte);
                    }
                    if(angka >= Short.MIN_VALUE && angka <= Short.MAX_VALUE){
                        System.out.println(tShort);
                    }
                    if(angka >= Integer.MIN_VALUE && angka <= Integer.MAX_VALUE){
                        System.out.println(tInt);
                    }
                    if(angka >= Long.MIN_VALUE && angka <= Long.MAX_VALUE){
                        System.out.println(tLong);
                    }
                 } catch (Exception e){
                    System.out.println(scanUtama.next() + " Can't be fitted anywhere");
                }  
            }
        scanUtama.close();
    }
}

