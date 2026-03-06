public class Hourly extends Employee{
    private int hoursWorked;

    //Set hourly employee menggunakan menggunakan informasi spesifik
    public Hourly (String eName, String eAddress, String ePhone,String socSecNumber, double rate){
        super (eName, eAddress, ePhone, socSecNumber, rate);
        hoursWorked = 0;
    }

    // Menambahkan angka spesifik dari jam ke employee untuk akumulasi hour
    public void addHours(int moreHours){
        hoursWorked += moreHours;
    }

    // Kompilasi dan 
    @Override
    public double pay(){
        double payment = payrate * hoursWorked;
        hoursWorked = 0;
        return payment;
    }

    //Mengembalikan infromasi tentang jam employee ini dalam bentuk string
    @Override
    public String toString(){
        String result = super.toString();
        result += "\nCurrent hours: " + hoursWorked;
        return result;
    }
}