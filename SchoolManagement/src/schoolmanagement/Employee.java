/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package schoolmanagement;

/**
 *
 * @author isabe
 */
public class Employee {
    
    private String name; //store the employee name
    private String managerType; //store the employees role
    private String department;  //store the employee department
    
    public Employee(String name, String managerType, String department) { //constructor used to create 3 values for employee - name,role, depart.
        this.name = name;
        this.managerType = managerType;
        this.department = department;
    }
    
    public String getName() {
        return name;
    }
    
    public String getManagerType() {
        return managerType;
    }
    
    public String getDepartment() {
        return department;
    }
}
