package JavaProblem;
public class Employee {
    private Integer gaji;
    private String nama;

    public Employee(String nama, Integer gaji){
        this.nama = nama;
        this.gaji = gaji;
    }

    /* Getter */
    public Integer getGaji(){
        return gaji;
    }

    public String getNama(){
        return nama;
    }

    /* Setter */
    public void setGaji(Integer gaji){
        this.gaji = gaji;
    }

    public void setNama(String nama){
        this.nama = nama;
    }
    
    public String toString(){
        String result = "Employee{name= " + getNama() +", salary= " + getGaji() + "}";
        return result;

    }
}