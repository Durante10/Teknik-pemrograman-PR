public class Commission extends Hourly{
    private double TotalSales;
    private double ComRate;

    public Commission(String eName, String eAddress, String ePhone,String socSecNumber, double rate,double commisionRate){
        super(eName,eAddress,ePhone,socSecNumber,rate);
        ComRate=commisionRate;
        TotalSales = 0.0;
    }

    public void TotalSales(double TotalSales){
        this.TotalSales += TotalSales;
    }

    @Override
    public double pay(){
        double payment = super.pay() + (TotalSales * ComRate);
        TotalSales = 0.0;
        return payment;
    }
    @Override
    public String toString(){
        String result = super.toString();
        result += "\nTotal sales: " + TotalSales;
        return result;
    }
}