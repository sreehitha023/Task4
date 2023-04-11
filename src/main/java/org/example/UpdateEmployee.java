package org.example;

import java.sql.SQLException;
import java.util.Scanner;
class UpdateEmployee {
    public static void update() throws SQLException
    {
        Scanner sc =new Scanner(System.in);
        EmployeeDatabase employeeDatabase = new EmployeeDatabase();
        System.out.println("Enter Employee details to modify");
        System.out.println("Enter Employee id");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter the Employee name");
        String name = sc.nextLine();
        System.out.println("Enter the Employee salary");
        int salary = sc.nextInt();
        System.out.println("Choose the type of Employee");
        System.out.println("1.Permanent Employee");
        System.out.println("2.PartTime Employee");
        System.out.println("3.Contract Employee");
        int Select = sc.nextInt();

        switch (Select) {
            case 1 -> {
                System.out.println("Enter bonus amount");
                int bonus = sc.nextInt();
                PermanentEmployee permanentEmployee = new PermanentEmployee(id, name, salary, bonus);
                try {
                    employeeDatabase.updateEmployee(permanentEmployee);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            case 2 -> {
                System.out.println("Enter hoursWorked");
                int hoursWorked = sc.nextInt();
                PartTimeEmployee partTimeEmployee = new PartTimeEmployee(id, name, salary, hoursWorked);
                try {
                    employeeDatabase.updateEmployee(partTimeEmployee);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            case 3 -> {
                System.out.println("Enter contractPeriod");
                int contractPeriod = sc.nextInt();
                ContractEmployee contractEmployee = new ContractEmployee(id, name, salary, contractPeriod);
                try {
                    employeeDatabase.updateEmployee(contractEmployee);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            default -> {
            }
        }
    }
}
