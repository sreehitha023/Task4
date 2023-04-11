package org.example;

class PermanentEmployee extends Employee
{
    int bonus;

    public PermanentEmployee(int id, String name, int salary, int bonus) {
        super(id, name, salary);
        this.bonus = bonus;
    }

    public int getBonus() {
        return bonus;
    }

}
