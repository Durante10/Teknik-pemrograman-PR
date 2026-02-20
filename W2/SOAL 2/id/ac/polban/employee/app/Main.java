package id.ac.polban.employee.app;

import id.ac.polban.employee.model.Department;
import id.ac.polban.employee.model.Employee;
import id.ac.polban.employee.model.EmployeeType;
import id.ac.polban.employee.service.EmployeeService;
import java.util.Scanner;

public class Main {
    public static void main (String[] args){
        Scanner input = new Scanner(System.in);
        EmployeeService service = new EmployeeService();

        while (true) {
            System.out.println("Selamat datang di Employee Management System");
            System.out.println("Total Employee saat ini: " + Employee.getTotalEmployee());
            System.out.println("1. Tambah Employee");
            System.out.println("2. Lihat Employee");
            System.out.println("3. Naikkan Gaji Employee");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");

            int pilihan = input.nextInt();
            switch (pilihan){
                case 1:
                    int id;
                    while (true) {
                        System.out.println("Masukan ID: ");
                        id = input.nextInt();
                        input.nextLine(); // Clear buffer
                        if(service.getEmployee(id) != null){
                            System.out.println("ID sudah digunakan, coba lagi.");
                            continue;
                        } else {
                            break;
                        }
                    }
                    System.out.println("Masukan Nama: ");
                    String nama = input.nextLine();

                    System.out.println("Masukan Nama Department: ");
                    String deptName = input.nextLine();
                    Department dept = new Department(deptName);

                    System.out.println("Masukan Tipe Employee (Tetap/Magang): ");
                    String typeEmp = input.nextLine();

                    System.out.println("Masukan Gaji: ");
                    double gaji = input.nextDouble();

                    EmployeeType type = new EmployeeType(typeEmp);
                    Employee employee = new Employee(id, nama, dept, type, gaji);

                    service.addEmployee(employee);
                    System.out.println("Employee berhasil ditambahkan.\n");
                    break;
                case 2:
                    System.out.println("Masukan ID Employee: ");
                    int Cariid = input.nextInt();
                    Employee emp = service.getEmployee(Cariid);
                    if(emp != null){
                        System.out.println("== Data karyawan ==\n");
                        System.out.println("ID        : " + emp.getId());
                        System.out.println("Nama      : " + emp.getName());
                        System.out.println("Department: " + emp.getDepartment().getName());
                        System.out.println("Tipe      : " + emp.getType().getType());
                        System.out.println("Gaji      : " + emp.getSalary());
                        System.out.println("\n");
                    } else {
                        System.out.println("Employee tidak ditemukan.");
                    }
                    break;
                case 3:
                    System.out.println("Masukan ID Employee: ");
                    int CariID = input.nextInt();
                    System.out.println("Masukan Persentase Kenaikan Gaji: ");
                    double persen = input.nextDouble();
                    service.raiseSalary(CariID, persen);
                    System.out.println("Gaji berhasil dinaikkan.\n");
                    break;
                case 0:
                    System.out.println("Terima kasih telah menggunakan Employee Management System.");
                    input.close();
                    return;
                default:
                    System.out.println("Pilihan tidak valid, coba lagi.");
            }
        }
    }
}