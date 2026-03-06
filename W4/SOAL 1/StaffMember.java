abstract public class StaffMember{
    protected String name;
    protected String address;
    protected String phone;

    //Set staff member menggunakan informasi spesifik
    public StaffMember (String eName, String eAddress, String ePhone){
        name = eName;
        address = eAddress;
        phone = ePhone;
    }

    //Mengembalikan sebuah string yang termasuk informasi dasar employee
    public String toString(){
        String result = "Name: " + name + "\n";

        result += "Address: " + address + "\n";
        result += "Phone: " + phone;

        return result;
    }

    //Kelas turunan harus didefiniskan metode pay untuk tiap employee
    public abstract double pay();

}