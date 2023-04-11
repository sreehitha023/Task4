package org.example;

class ContractEmployee extends Employee
{
    int contractperiod;

    public ContractEmployee(int id, String name, int salary, int contractperiod) {
        super(id, name, salary);
        this.contractperiod = contractperiod;
    }

    public int getContractperiod() {
        return contractperiod;
    }

}
