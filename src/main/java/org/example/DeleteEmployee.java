package org.example;

import java.sql.SQLException;
import java.util.Scanner;

class DeleteEmployee {
    public static void delete() throws SQLException{
        Scanner sc = new Scanner(System.in);
        EmployeeDatabase employeeDatabase = new EmployeeDatabase();
        System.out.println("Choose type Employee to delete");
        System.out.println("1.Permanent Employee");
        System.out.println("2.PartTime Employee");
        System.out.println("3.Contract Employee");
        int Select = sc.nextInt();
        switch (Select)
        {
            case 1:
                System.out.println("Enter the employee id");
                int id = sc.nextInt();
                employeeDatabase.deleteEmployee1(id);
                break;
            case 2:
                System.out.println("Enter the employee id");
                id = sc.nextInt();
                employeeDatabase.deleteEmployee2(id);
                break;
            case 3:
                System.out.println("Enter the employee id");
                id = sc.nextInt();
                employeeDatabase.deleteEmployee3(id);
                break;
            default:
                break;

        }
    }
}
