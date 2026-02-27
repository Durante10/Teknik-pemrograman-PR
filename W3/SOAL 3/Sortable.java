public interface Sortable{
    int compare (Sortable b);

    public static void shell_body(Sortable [] a){
        // Shell sort body
        int n = a.length;
        for (int gap = n / 2; gap > 0; gap /= 2){
            for (int i = gap; i < n; i++){
                Sortable temp = a[i];
                int j;
                for ( j = i; j >= gap && a[j-gap].compare(temp) > 0; j -= gap){
                    a[j] = a[ j-gap ];
                }
                a[j] = temp;
            }
        }
    }
}