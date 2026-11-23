/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package schoolmanagement;

import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author isabe
 */
public class SchoolManagement {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        EmployeeFileReader reader = new EmployeeFileReader();
        
 
        try {
            ArrayList<Employee> employees = reader.readEmployees(
                "C:/Users/isabe/OneDrive/Documents/NetBeansProjects/SchoolManagement/src/data/Applicants_Form - Sample data file for read.txt"
            );
                        
            System.out.println("File read successfully.");
            System.out.println("Number of employees: " + employees.size());
            
            for (Employee employee : employees) {
                System.out.println(employee.getName());
            }
            
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
        
    }
    
}
