package JavaProblem;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class ProblemOne{
    public static void main (String[] args){
        ArrayList<Employee> list = new ArrayList<>();

        list.add(new Employee ("John",50000));
        list.add(new Employee ("Rob",70000));
        list.add(new Employee ("Bob",40000));
        list.add(new Employee ("Alice",10000));

        List<Employee> sortedEMP = list.stream()
            .sorted((e1,e2) -> e1.getNama().compareTo(e2.getNama()))
            .collect(Collectors.toList());
            for(Employee e : sortedEMP){
                System.out.println(e);
            }

    }
}