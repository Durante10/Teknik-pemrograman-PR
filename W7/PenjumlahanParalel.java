import java.util.Scanner;


class SharedTotal {
    private long totalAkhir = 0;

    public synchronized void add(long hasilParsial) { //Penguncian method agar hanya adad satu thread saja yang dapat mengaksesnya pada satu waktu
        totalAkhir += hasilParsial;
    }

    public long getTotal() {
        return totalAkhir;
    }
}

public class PenjumlahanParalel {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.print("Masukkan Jumlah Thread: ");
        int jumlahThread = scanner.nextInt();
        
        System.out.print("Masukkan Angka Akhir: ");
        long angkaAkhir = scanner.nextLong();

        // Memvalidasi input user
        if (jumlahThread <= 0 || angkaAkhir <= 0) {
            System.out.println("Jumlah Thread dan Angka Akhir harus lebih dari 0!");
            scanner.close();
            return;
        }

        SharedTotal sharedTotal = new SharedTotal();
        Thread[] threads = new Thread[jumlahThread]; //Pembuatan list thread dimana jumlah thread ditentukan oleh inputan user

        //Mekanisme Divide and Conquer
        long rentang = angkaAkhir / jumlahThread; //
        long sisa = angkaAkhir % jumlahThread;

        System.out.println("\n--- PROSES PENJUMLAHAN ---");

        for (int i = 0; i < jumlahThread; i++) {
          
            final long start = (i * rentang) + 1; //Menetukan nilai awal dan akhir untuk masing-masing thread
            
            //"sisa" ditambahkan pada thread terakhir agar tidak ada nilai yang tertinggal
            final long end = (i == jumlahThread - 1) ? ((i + 1) * rentang) + sisa : (i + 1) * rentang;
            final int threadId = i + 1; // id thread


            threads[i] = new Thread(() -> { //Pembuatan thread
                long hasilParsial = 0;
                
                //Tugas yang dikerjakan oleh thread
                System.out.println("Thread " + threadId + ": Menjumlahkan angka " + start + " sampai " + end);
                
                //penjumlahan rentang angka
                for (long j = start; j <= end; j++) {
                    hasilParsial += j;
                }
                
                //Hasil parsial masing-masing thread
                System.out.println("Hasil parsial (Thread " + threadId + ") = " + hasilParsial);
                
                //Menyimpan nilainya kedalam variabel totalakhir yang ada di class sharedtotal
                sharedTotal.add(hasilParsial);
            });

            threads[i].start();
        }


        try { //membuat main thread menunggu sampai thread lain selesai mengerjakan tugasnya
            for (int i = 0; i < jumlahThread; i++) {
                threads[i].join();
            }
        } catch (InterruptedException e) { // handle Exception
            System.out.println("Main thread diinterupsi!");
        }

   
        System.out.println("\n--- HASIL AKHIR ---");
        System.out.println("Total Penjumlahan 1 sampai " + angkaAkhir + " = " + sharedTotal.getTotal());

        scanner.close();
    }
}