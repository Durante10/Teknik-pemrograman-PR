class Account{
    int balance = 150;
}

public class TranserFulus {
    public static void main(String[] args) throws InterruptedException {
        Account acc1 = new Account();
        Account acc2 = new Account();

        Thread t1 = new Thread(() -> { //Menjumlahkan/transfer fulus dari acc1 ke acc2
            synchronized(acc1) { //komen disini
                System.out.println("t1 mengunci acc1");
                try {
                    Thread.sleep(100);
                } catch (Exception e) { /*Alasan perlu Exception untuk mengatasi error Execption jika terjadi dan 
                    mengeksekusi kode yang ada di blok catch. jika tidak maka java akan menghentikan program*/
                    // TODO: handle exception
                }
                synchronized(acc2){ //komen disni
                    System.out.println("t1 mengunci acc2");
                    acc2.balance += acc1.balance;
                }
            }
            
        });
        Thread t2 = new Thread(() -> { //Menjumlahkan/transfer fulus dari acc2 ke acc1
            synchronized(acc1){ //t2 mengunci acc1
                try {
                    System.out.println("t2 mengunci acc1");
                } catch (Exception e) { /*Alasan perlu Exception untuk mengatasi error Execption jika terjadi dan 
                    mengeksekusi kode yang ada di blok catch. jika tidak maka java akan menghentikan program*/
                    // TODO: handle exception
                }
                synchronized(acc2){//t2 mengunci acc2
                    System.out.println("t2 mengunci acc2");
                    acc1.balance += acc2.balance;
                }
            }            
        });
        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("===HASIL AKHIR===");
        System.out.println("Saldo acc1 = " + acc1.balance);
        System.out.println("Saldo acc2 = " + acc2.balance);
    }
    
}