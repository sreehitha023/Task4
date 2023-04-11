package org.example;

import java.sql.SQLException;
import java.util.Scanner;

class AddEmployee {


    public static void add() throws SQLException {

        EmployeeDatabase employeeDatabase = new EmployeeDatabase();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the Employee id : ");
        int id = sc.nextInt();
        System.out.println("Enter Employee name : ");
        sc.nextLine();
        String name = sc.nextLine();
        System.out.println("Enter Employee salary : ");
        int salary = sc.nextInt();
        System.out.println("1.Permanent Employee");
        System.out.println("2.PartTime Employee");
        System.out.println("3.Contract Employee");
        int select = sc.nextInt();

        switch (select) {
            case 1 -> {
                System.out.println("Enter Employee bonus : ");
                int bonus = sc.nextInt();
                PermanentEmployee permanentEmployee = new PermanentEmployee(id, name, salary, bonus);
                try {
                    employeeDatabase.addEmployee(permanentEmployee);

                } catch (SQLException e) {
                    e.printStackTrace();


                }
            }
            case 2 -> {
                System.out.println("Enter hoursWorked : ");
                int hoursWorked = sc.nextInt();
                PartTimeEmployee partTimeEmployee = new PartTimeEmployee(id, name, salary, hoursWorked);
                try {
                    employeeDatabase.addEmployee(partTimeEmployee);


                } catch (SQLException e) {
                    e.printStackTrace();

                }
            }
            case 3 -> {
                System.out.println("Enter contractPeriod : ");
                int contractPeriod = sc.nextInt();
                ContractEmployee contractEmployee = new ContractEmployee(id, name, salary, contractPeriod);
                try {
                    employeeDatabase.addEmployee(contractEmployee);

                } catch (SQLException e) {
                    e.printStackTrace();

                }
            }
            default -> {
            }
        }
    }
}
