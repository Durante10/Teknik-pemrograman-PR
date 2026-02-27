public class ManagerTest {
    public static void main (String[] args){
        //Mendeklarasikan dan mengalokasiakn array untuk 3 objek Employee
        Employee[] staff = new Employee[3];

        //Mengisi array dengan kominasi Employee dan Manager (Polimorfisme)
        staff[0] = new Employee("Antonio Rossi", 2000000, 1, 10, 1989); 
        staff[1] = new Manager("Maria Biancha", 3500000, 1, 12, 1991); 
        staff[2] = new Employee("Isabel Vidal", 3000000, 1, 11, 1993); 

        //Menaikan gaji semua staf sebesar 5%
        for (int i = 0; i < 3; i++){
            staff[i].raiseSalary(5);
        }

        //Mencetak data setiap staf
        for (int i = 0; i < 3; i++){
            staff[i].print();
        }

        //mengurutkan data berdasarkan gaji dengan sortable compare
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 2 - i; j++){
                if (staff[j].compare(staff[j+1]) > 0){
                    Employee temp = staff[j];
                    staff[j] = staff[j+1];
                    staff[j+1] = temp;
                }
            }
        }
        System.out.println("\nData setelah diurutkan berdasarkan gaji:");
        //Mencetak data dari setiap staf
        for (Employee e : staff) e.print();

        //mengurutkan data berdasarkan gaji sortable shell sort
        System.out.println();
        Sortable.shell_body(staff);
        System.out.println("\nData setelah diurutkan berdasarkan gaji:");
        for (Employee e : staff) e.print();
    }
}