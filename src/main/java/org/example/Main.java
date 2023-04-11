package org.example;

import java.sql.SQLException;
import java.util.Scanner;
public class Main
{
    public static void main(String[] args) throws SQLException
    {
        EmployeeDatabase employeeDatabase = new EmployeeDatabase();


        System.out.println("Enter yours choice (1-3): ");
        System.out.println("1.Add Employee");
        System.out.println("2.Update Employee");
        System.out.println("3.Delete Employee");
        Scanner sc = new Scanner(System.in);
        int Select = sc.nextInt();

        boolean bool = true;

        while(bool) {

            switch (Select) {
                case 1 -> AddEmployee.add();
                case 2 -> UpdateEmployee.update();
                case 3 -> DeleteEmployee.delete();
                default -> System.out.println("---------Invalid---------");
            }
            System.out.println("If you want to continue enter true ");
            bool = sc.nextBoolean();

            employeeDatabase.permanentJson();
            employeeDatabase.partTimeJson();
            employeeDatabase.contractJson();
        }
    }
}
