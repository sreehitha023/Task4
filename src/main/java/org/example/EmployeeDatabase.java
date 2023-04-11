package org.example;

import org.json.*;

import java.sql.*;
import java.util.logging.Logger;



public class EmployeeDatabase {
    private final Connection connection;
    private final PreparedStatement insertEmployeeStatement1;
    private final PreparedStatement insertEmployeeStatement2;
    private final PreparedStatement insertEmployeeStatement3;
    private final PreparedStatement updateEmployeeStatement1;
    private final PreparedStatement updateEmployeeStatement2;
    private final PreparedStatement updateEmployeeStatement3;
    private final PreparedStatement deleteEmployeeStatement1;
    private final PreparedStatement deleteEmployeeStatement2;
    private final PreparedStatement deleteEmployeeStatement3;
    private final Logger logger = Logger.getLogger("employeeDatabase");


    public EmployeeDatabase() throws SQLException
    {
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Employee", "root","Sree@1234567");
        insertEmployeeStatement1=connection.prepareStatement("INSERT INTO PermanentEmployee(id,name,salary,bonus) VALUES(?,?,?,?)");
        insertEmployeeStatement2=connection.prepareStatement("INSERT INTO PartTimeEmployee(id,name,salary,hoursWorked) VALUES(?,?,?,?)");
        insertEmployeeStatement3=connection.prepareStatement("INSERT INTO ContractEmployee(id,name,salary,contractPeriod) VALUES(?,?,?,?)");
        updateEmployeeStatement1=connection.prepareStatement("UPDATE PermanentEmployee SET name = ?,salary = ?,bonus = ? WHERE id = ?");
        updateEmployeeStatement2=connection.prepareStatement("UPDATE PartTimeEmployee SET name = ?,salary = ?,hoursWorked = ? WHERE id = ?");
        updateEmployeeStatement3=connection.prepareStatement("UPDATE ContractEmployee SET name = ?,salary = ?,contractPeriod = ? WHERE id = ?");
        deleteEmployeeStatement1=connection.prepareStatement("DELETE FROM PermanentEmployee WHERE id = ?");
        deleteEmployeeStatement2=connection.prepareStatement("DELETE FROM PartTimeEmployee WHERE id = ?");
        deleteEmployeeStatement3=connection.prepareStatement("DELETE FROM ContractEmployee WHERE id = ?");
    }
    public  void addEmployee(PermanentEmployee permanentEmployee) throws SQLException
    {
        insertEmployeeStatement1.setInt(1,permanentEmployee.getId());
        insertEmployeeStatement1.setString(2,permanentEmployee.getName());
        insertEmployeeStatement1.setInt(3,permanentEmployee.getSalary());
        insertEmployeeStatement1.setInt(4,permanentEmployee.getBonus());
        insertEmployeeStatement1.executeUpdate();
        logger.info("PERMANENT EMPLOYEE ADDED");
    }
    public void addEmployee(PartTimeEmployee partTimeEmployee) throws SQLException
    {
        insertEmployeeStatement2.setInt(1,partTimeEmployee.getId());
        insertEmployeeStatement2.setString(2,partTimeEmployee.getName());
        insertEmployeeStatement2.setInt(3,partTimeEmployee.getSalary());
        insertEmployeeStatement2.setInt(4,partTimeEmployee.getHoursWorked());
        insertEmployeeStatement2.executeUpdate();
        logger.info("PART TIME EMPLOYEE ADDED");

    }
    public void addEmployee(ContractEmployee contractEmployee) throws SQLException
    {
        insertEmployeeStatement3.setInt(1,contractEmployee.getId());
        insertEmployeeStatement3.setString(2,contractEmployee.getName());
        insertEmployeeStatement3.setInt(3,contractEmployee.getSalary());
        insertEmployeeStatement3.setInt(4,contractEmployee.getContractperiod());
        insertEmployeeStatement3.executeUpdate();
        logger.info("CONTRACT EMPLOYEE ADDED");
    }

    public void updateEmployee(PermanentEmployee permanentEmployee) throws SQLException
    {
        updateEmployeeStatement1.setString(1, permanentEmployee.getName());
        updateEmployeeStatement1.setInt(2, permanentEmployee.getSalary());
        updateEmployeeStatement1.setInt(3, permanentEmployee.getBonus());
        updateEmployeeStatement1.setInt(4, permanentEmployee.getId());
        updateEmployeeStatement1.executeUpdate();
        logger.info("PERMANENT EMPLOYEE DETAILS UPDATED");
    }
    public void updateEmployee(PartTimeEmployee partTimeEmployee) throws SQLException
    {
        updateEmployeeStatement2.setString(1, partTimeEmployee.getName());
        updateEmployeeStatement2.setInt(2, partTimeEmployee.getSalary());
        updateEmployeeStatement2.setInt(3, partTimeEmployee.getHoursWorked());
        updateEmployeeStatement2.setInt(4, partTimeEmployee.getId());
        logger.info("PART TIME EMPLOYEE DETAILS UPDATED");
    }
    public void updateEmployee(ContractEmployee contractEmployee) throws SQLException
    {
        updateEmployeeStatement3.setString(1, contractEmployee.getName());
        updateEmployeeStatement3.setInt(2, contractEmployee.getSalary());
        updateEmployeeStatement3.setInt(3, contractEmployee.getContractperiod());
        updateEmployeeStatement3.setInt(4, contractEmployee.getId());
        logger.info("CONTRACT EMPLOYEE DETAILS UPDATED");
    }

    public void deleteEmployee1(int id) throws SQLException
    {
        deleteEmployeeStatement1.setInt(1,id);
        deleteEmployeeStatement1.executeUpdate();
        logger.info("DETAILS DELETED");
    }
    public void deleteEmployee2(int id) throws SQLException
    {
        deleteEmployeeStatement2.setInt(1,id);
        deleteEmployeeStatement2.executeUpdate();
        logger.info("DETAILS DELETED");
    }
    public void deleteEmployee3(int id) throws SQLException
    {
        deleteEmployeeStatement3.setInt(1,id);
        deleteEmployeeStatement3.executeUpdate();
        logger.info("DETAILS DELETED");
    }
    public void permanentJson() throws SQLException
    {
        String SELECT_EMPLOYEES_QUERY = "SELECT id, name, salary, bonus FROM PermanentEmployee";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(SELECT_EMPLOYEES_QUERY);
        JSONArray jsonArray = new JSONArray();
        while (resultSet.next()) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("id", resultSet.getInt("id"));
            jsonObject.put("name", resultSet.getString("name"));
            jsonObject.put("salary", resultSet.getInt("salary"));
            jsonObject.put("bonus",resultSet.getInt("bonus"));
            jsonArray.put(jsonObject);
        }
        System.out.println(jsonArray);
    }

    public void partTimeJson() throws SQLException
    {
        String SELECT_EMPLOYEES_QUERY = "SELECT id, name, salary, hoursWorked  FROM PartTimeEmployee";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(SELECT_EMPLOYEES_QUERY);
        JSONArray jsonArray = new JSONArray();
        while (resultSet.next()) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("id", resultSet.getInt("id"));
            jsonObject.put("name", resultSet.getString("name"));
            jsonObject.put("salary", resultSet.getInt("salary"));
            jsonObject.put("hoursWorked",resultSet.getInt("hoursWorked"));
            jsonArray.put(jsonObject);
        }
        System.out.println(jsonArray);
    }
    public void contractJson() throws SQLException {
        String SELECT_EMPLOYEES_QUERY = "SELECT id, name, salary, contractPeriod  FROM ContractEmployee";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(SELECT_EMPLOYEES_QUERY);
        JSONArray jsonArray = new JSONArray();
        while (resultSet.next()) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("id", resultSet.getInt("id"));
            jsonObject.put("name", resultSet.getString("name"));
            jsonObject.put("salary", resultSet.getInt("salary"));
            jsonObject.put("contractPeriod", resultSet.getInt("contractPeriod"));
            jsonArray.put(jsonObject);
        }
        System.out.println(jsonArray);
        connection.close();
    }
}
