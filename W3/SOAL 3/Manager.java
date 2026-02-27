import java.util.Calendar;
import java.util.GregorianCalendar;

class Manager extends Employee{
    private String secretaryName;

    public Manager (String n, double s, int d, int m, int y){
        super(n,s,d,m,y);
        secretaryName = " ";
    }
    
    @Override
    public void raiseSalary(double byPercent){
        //Menambahkan bonus 1/2 % untuk setiap tahun masa kerja
        GregorianCalendar todaysDate = new GregorianCalendar();
        int currentYear = todaysDate.get(Calendar.YEAR);
        double bonus = 0.5 * (currentYear - hireyear());

        super.raiseSalary(byPercent + bonus);
    }

    //Getter
    public String getSecretaryName(){
        return secretaryName;
    }


}
