package JavaProblem3;
import java.util.Arrays;

public class ProblemThree{
    public static void main (String[] args){
        int arr[] = {12,4,3,1,9,657};
        int n = 3; /*untuk mencari nilai terbesar */

        int ans = Arrays.stream(arr)
            .boxed()
            .sorted((e1,e2) -> Integer.compare(e2,e1))
            .skip(n-1)
            .findFirst()
            .orElse(0);
        System.out.println("Elemen terbesar ke-3 adalah: " + ans);

    }
}