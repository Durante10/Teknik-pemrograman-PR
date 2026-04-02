interface MinMax<T extends Comparable<T>> { 
    /* Generic interface 
    <T extends Comparable<T>> : menerima Tipe (T) apapun yang sudah memiliki kemampuan dari Comparable. Ini merupakan batasan
    extends disini bukan hanya sebagai pewarisan biasa melainkan sebuah "batasan" tipe mana yang bisa masuk*/
    T max(); 
} 

class MyClass<T extends Comparable<T>> implements MinMax<T> { 
    /* Generic class  
    Karena class ini mengimplementasikan interface MinMaxT, Maka wajib membuat Method T max dan memberikan batasan
    yang sama dengan interfacenya*/
    T[] vals; 

    MyClass(T[] o) { 
        vals = o; 
    }

    @Override
    public T max() { 
        T v = vals[0]; 

        for (int i = 1; i < vals.length; i++) { 
            // Menggunakan method compareTo dari interface Comparable
            /*Method ini dapat digunakan pada T karena T dipaksa untuk mewariskan Comparable sehingga operasi compareto dapat dilakukan */ 
            if (vals[i].compareTo(v) > 0) { 

                v = vals[i]; 
            } 
        } 
        return v; 
    } 

} 

public class Main { 

    public static void main(String[] args) { 

        Integer[] inums = {3, 6, 2, 8, 6}; 
        Character[] chs = {'b', 'r', 'p', 'w'}; 

        /*Cara menggunakan Generic class untuk membuat objek */
        MyClass<Integer> a = new MyClass<>(inums); 
        MyClass<Character> b = new MyClass<>(chs); 

        System.out.println("Nilai Integer Terbesar: " + a.max()); 
        System.out.println("Karakter Terbesar: " + b.max()); 

    } 

} 