import java.util.ArrayList;
import java.util.List;

// ==========================================
// 1. PEMBUATAN HIERARKI KELAS
// ==========================================

// Kelas Induk Tertinggi
class Person {
    protected String nama;

    public Person(String nama) {
        this.nama = nama;
    }

    public String getNama() {
        return nama;
    }
}

// Employee adalah turunan dari Person
class Employee extends Person {
    public Employee(String nama) {
        super(nama);
    }
}

// PartTime adalah turunan dari Employee
class PartTime extends Employee {
    public PartTime(String nama) {
        super(nama + " (Part-Time)");
    }
}

// FullTime adalah turunan dari Employee
class FullTime extends Employee {
    public FullTime(String nama) {
        super(nama + " (Full-Time)");
    }
}


// ==========================================
// 2. KELAS UTAMA & PENGGUNAAN WILDCARD
// ==========================================
public class ContohWildCard {

    // --------------------------------------------------------
    // A. UNBOUNDED WILDCARD <?> 
    // Menerima List apa saja. Hanya bisa membaca.
    // --------------------------------------------------------
    public static void absenKehadiran(List<?> listOrang) {
        System.out.println("Daftar Hadir:");
        for (Object obj : listOrang) {
            // Karena tipenya ?, Java hanya mengenalnya sebagai Object
            // Kita harus melakukan casting (pengecekan) jika ingin memanggil getNama()
            if (obj instanceof Person) {
                System.out.println("- " + ((Person) obj).getNama() + " hadir.");
            }
        }
    }

    // --------------------------------------------------------
    // B. UPPER BOUNDED WILDCARD <? extends Employee> 
    // Menerima Employee, PartTime, dan FullTime.
    // Cocok untuk: MENGAMBIL/MEMBACA data spesifik Karyawan.
    // --------------------------------------------------------
    public static void bayarGaji(List<? extends Employee> listKaryawan) {
        System.out.println("\nProses Pembayaran Gaji:");
        for (Employee emp : listKaryawan) {
            // Kita yakin 100% ini pasti Employee atau turunannya, 
            // jadi bisa langsung memanggil getNama() tanpa casting
            System.out.println("Mentransfer gaji ke rekening: " + emp.getNama());
        }
        // listKaryawan.add(new PartTime("Budi")); // <-- ERROR! Tidak bisa merekrut/menambah di sini
    }

    // --------------------------------------------------------
    // C. LOWER BOUNDED WILDCARD <? super Employee> 
    // Menerima Employee, Person, atau Object.
    // Cocok untuk: MEMASUKKAN/MENAMBAH karyawan baru ke dalam List.
    // --------------------------------------------------------
    public static void rekrutKaryawanBaru(List<? super Employee> departemen) {
        // Kita bisa memasukkan tipe Employee dan turunannya ke dalam list ini
        departemen.add(new FullTime("Andi"));
        departemen.add(new PartTime("Siti"));
        System.out.println("\n[INFO] Andi dan Siti berhasil direkrut ke dalam departemen!");
    }


    // ==========================================
    // 3. BLOK EKSEKUSI (MAIN)
    // ==========================================
    public static void main(String[] args) {
        
        // Persiapan List
        List<Person> listMasyarakat = new ArrayList<>();
        listMasyarakat.add(new Person("Bapak RW"));
        
        List<Employee> listSemuaKaryawan = new ArrayList<>();
        listSemuaKaryawan.add(new Employee("Joko (Manager)"));
        
        List<PartTime> listPekerjaLepas = new ArrayList<>();
        listPekerjaLepas.add(new PartTime("Rina"));


        // --- Uji Coba Unbounded <?> ---
        // Bisa menerima semua jenis list
        absenKehadiran(listMasyarakat);
        absenKehadiran(listPekerjaLepas);


        // --- Uji Coba Upper Bounded <? extends Employee> ---
        // bayarGaji(listMasyarakat); // <-- ERROR! Person bukan turunan Employee
        bayarGaji(listSemuaKaryawan); // Sukses
        bayarGaji(listPekerjaLepas);  // Sukses, karena PartTime turunan Employee


        // --- Uji Coba Lower Bounded <? super Employee> ---
        // rekrutKaryawanBaru(listPekerjaLepas); // <-- ERROR! PartTime bukan induk dari Employee
        
        // Kita bisa merekrut karyawan ke dalam listSemuaKaryawan 
        rekrutKaryawanBaru(listSemuaKaryawan);
        
        // Ajaibnya, kita juga bisa merekrut Karyawan ke dalam kumpulan Masyarakat Umum (Person)
        // Karena Karyawan pada dasarnya juga adalah Person!
        rekrutKaryawanBaru(listMasyarakat);

        
        // Mari kita cek isi list masyarakat sekarang
        System.out.println("\nIsi List Masyarakat setelah rekrutmen:");
        absenKehadiran(listMasyarakat);
    }
}