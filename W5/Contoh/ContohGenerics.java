// ==========================================
// 1. GENERIC CLASS (Kelas Generik)
// ==========================================
// Huruf <T> (Type) adalah parameter tipe yang akan diganti 
// dengan tipe data asli (seperti String atau Integer) saat objek dibuat.
class Penyimpanan<T> {
    private T data; // Tipe data dari variabel 'data' ini fleksibel

    // Constructor
    public Penyimpanan(T data) {
        this.data = data;
    }

    // Getter
    public T getData() {
        return data;
    }

    // Setter
    public void setData(T data) {
        this.data = data;
    }
}

// ==========================================
// 2. MAIN CLASS (Tempat Program Dijalankan)
// ==========================================
public class ContohGenerics {

    // ==========================================
    // 3. GENERIC METHOD (Metode Generik)
    // ==========================================
    // Huruf <E> (Element) digunakan untuk metode ini saja.
    // Metode ini bisa menerima argumen dengan tipe data apa pun.
    public static <E> void tampilkanInfo(E elemen) {
        System.out.println("Isi Data : " + elemen);
        System.out.println("Tipe Data: " + elemen.getClass().getSimpleName());
        /* getClass() digunakan untuk meminta informasi lengkap tentang dari class mana objek ini diciptakan.
        jika pada kode kita masukan Halo Dunia, maka Output nya java.lang.String.
        untuk mengambil nama class nya saja tanpa nama package misal ingin mengambil String tapi membuang java.lang
        maka gunakan getSimpleName() */
        System.out.println("----------------------------");
    }

    public static void main(String[] args) {
        
        System.out.println("=== MENGGUNAKAN GENERIC CLASS ===");
        
        // Membuat objek Penyimpanan KHUSUS untuk String
        Penyimpanan<String> simpanTeks = new Penyimpanan<>("Belajar Java Generics");
        System.out.println("Data Teks: " + simpanTeks.getData());
        // simpanTeks.setData(100); // <- Ini akan ERROR, karena hanya menerima String!

        // Membuat objek Penyimpanan KHUSUS untuk Integer
        Penyimpanan<Integer> simpanAngka = new Penyimpanan<>(2026);
        System.out.println("Data Angka: " + simpanAngka.getData());

        
        System.out.println("\n=== MENGGUNAKAN GENERIC METHOD ===");
        
        // Memanggil metode dengan berbagai macam tipe data
        // Java secara otomatis menebak tipe datanya berdasarkan argumen yang dimasukkan
        tampilkanInfo("Halo Dunia");  // E akan menjadi String
        tampilkanInfo(99.99);         // E akan menjadi Double
        tampilkanInfo(true);          // E akan menjadi Boolean
    }
}