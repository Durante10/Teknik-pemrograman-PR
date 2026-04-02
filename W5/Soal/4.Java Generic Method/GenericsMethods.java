public class GenericsMethods { 
    // Java Generic Method 
    public static <T> boolean isEqual(GenericsType<T> g1, GenericsType<T> g2) { 
        //Pendeklarasian sebuah Generic Method yang ditandai oleh adanya <T> sebelum tipe return (disini adalah boolean)
        return g1.getT().equals(g2.getT()); 

    } 
    public static void main(String args[]) { 
        GenericsType<String> g1 = new GenericsType<>(); 

        g1.setT("Java"); 

        GenericsType<String> g2 = new GenericsType<>(); 

        g2.setT("Java"); 

        //Pemanggilan secara eksplisit
        boolean isEqual = GenericsMethods.<String>isEqual(g1, g2); 
        System.out.println(isEqual);
        // above statement can be written simply as  

        //Type inference
        isEqual = GenericsMethods.isEqual(g1, g2); 
        System.out.println(isEqual);

        /* 
         * This feature, known as type inference, allows you to invoke 
         * a generic method as an ordinary method, without specifying  
         * a type between angle brackets  
         */ 
        // Compiler will infer the type that is needed 
    } 
} 
