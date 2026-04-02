package JavaProblem2;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ProblemTwo{
    public static void main (String[] args){
        List<Student> list = Arrays.asList(
            new Student(101, "Joe"), 
            new Student(103, "Zulkifli"), 
            new Student(102, "Riza"), 
            new Student(104, "Alice"), 
            new Student(105, "Joshua"), 
            new Student(100,"Joshua")
        );
        List<Student> ans = list.stream()
            .sorted((s1,s2) ->{
                if (s1.getNama().equalsIgnoreCase(s2.getNama())){
                    return Integer.compare(s1.getID(),s2.getID());
                } else {
                    return s1.getNama().compareToIgnoreCase(s2.getNama());
                }
            })
            .collect(Collectors.toList());
        for(Student s : ans){
            System.out.println(s);
        }
    }
}