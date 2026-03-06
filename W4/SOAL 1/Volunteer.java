public class Volunteer extends StaffMember {

    //Set volunteer menggunakan informasi spesifik
    public Volunteer(String eName, String eAddress, String ePhone){
        super(eName, eAddress, ePhone);
    }

    @Override
    //Mengembalikan zero pay untuk volunteer
    public double pay(){
        return 0.0;
    }

}