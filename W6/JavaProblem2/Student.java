package JavaProblem2;

public class Student{
    private Integer id;
    private String nama;

    public Student(Integer id, String nama){
        this.nama = nama;
        this.id = id;
    }

    /* Getter */
    public Integer getID(){
        return id;
    }

    public String getNama(){
        return nama;
    }

    /* Setter */
    public void setID(Integer id){
        this.id = id;
    }

    public void setNama(String nama){
        this.nama = nama;
    }
    
    public String toString(){
        String result = "Student{ID= " + getID() +", Name= " + getNama() + "}";
        return result;

    }
}