class GenericsTypeOld{
    private Object T; //Mendeklarasikan atribut T dengan tipe Objek 

    public Object get(){
        return T;
    }

    public void set (Object T){
        this.T = T;
    }
}

public class main{
    public static void main (String args[]){
        GenericsTypeOld type = new GenericsTypeOld(); //Membuat Objek baru dari sebuah Class GenericsTypeOld dan menyimpannya pada variabel referensi type

        type.set("Java"); //Memasukan kata "java" pada variabel type

        String str = (String)type.get(); //Mengambil data yang ada pada type dan mengubahnya (cast) menjadi sebuah String untuk dimasukkan kedalam variabel str

        System.out.println(str);

    }
}