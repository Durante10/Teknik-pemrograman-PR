public class GenericsType<T> { 
    /* Generics class */
    private T t; //Tipe data bebas

    public T get() { 

        return this.t; 

    } 

    public void set(T t1) { 

        this.t = t1; 

    } 
    public static void main(String args[]) { 
        /*Cara menggunakan Generic class untuk membuat objek */
        GenericsType<String> type = new GenericsType<>(); 
        
        type.set("Java"); // valid 
        System.out.println(type.get());
        GenericsType type1 = new GenericsType(); // raw type 

        type1.set("Java"); // valid 
        System.out.println(type1.get());
        type1.set(10); // valid and autoboxing support 
        System.out.println(type1.get());

    } 
} 