public class Employee extends StaffMember{
    protected String socialSecurityNumber;
    protected double payrate;

    //Set employee dengan informasi spesifik
    public Employee (String eName, String eAddress, String ePhone, String socSecNumber, double rate){
        super(eName,eAddress,ePhone);

        socialSecurityNumber = socSecNumber;
        payrate = rate;
    }

    //Mengembalikan informasi tentang employee dalam bentuk String
    @Override
    public String toString(){
        String result = super.toString();

        result += "\nSocial Security Number: " + socialSecurityNumber;

        return result;
    }

    @Override
    //mengembalikan payrate untuk employee ini
    public double pay(){
        return payrate;
    }

}