public class Executive extends Employee{
    private double bonus;

    //Set eksekutif dengan spesifikasi informasi
    public Executive (String eName, String eAddress, String ePhone,String esocSecNumber, double rate){
        super(eName,eAddress,ePhone,esocSecNumber,rate);

        bonus = 0; //bonus belum diberikan
    }

    //Pemberian bonus untuk eksekutif ini
    public void awardBonus(double execBonus){
        bonus = execBonus;
    }

    //kompilasi dan kembalikan pay untuk eksekutif 
    /*dimana employee biasa mendapatkan bayaran ditambah one-time bonus */
    @Override
    public double pay(){
        double payment = super.pay() +bonus;
        return payment;
    }
}