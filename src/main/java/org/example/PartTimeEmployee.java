package org.example;

class PartTimeEmployee extends Employee
{
    int hoursWorked;

    public PartTimeEmployee(int id, String name, int salary, int hoursWorked) {
        super(id, name, salary);
        this.hoursWorked = hoursWorked;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }
}
