/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package schoolmanagement;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

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
            
            EmployeeMergeSort sorter = new EmployeeMergeSort();
            
            sorter.mergeSort(employees); //execute mergeSort class - list of 46 employees
            
            System.out.println("First 20 Employees in alphabetical order");
            
            for (int i = 0; i <20 && i < employees.size(); i++) { //limits the output to 20 employees
                System.out.println(employees.get(i).getName());
            }
            
            Scanner scanner = new Scanner(System.in); //allows user to input
            
            System.out.println("\nEnter the full name of the employee:");
            
            String searchName = scanner.nextLine().trim(); //this code read the name that user inserted
            
            EmployeeBinarySearch searcher = new EmployeeBinarySearch(); //create and object/searcher that allows access the methods in EmployeeBinarySearch class
            
            Employee result = searcher.binarySearch(
                        employees, searchName, 0, employees.size() - 1); //execute the searching algorithm inside EmployeeBinarySearch class
            
                        if (result != null) { //check if the employee was found/result not null - If yes, return name, role and department.
                            System.out.println("Name: " + result.getName());
                            System.out.println("Manager Type: " + result.getManagerType());
                            System.out.println("Department: " + result.getDepartment());
                            
                        } else {
                            System.out.println("Employee not found");
                            
                        }
                        
            EmployeeManagement manager = new EmployeeManagement();
            
            manager.addEmployee(employees, scanner);
            manager.displayNewEmployees();
                       
            
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
        
    }
    
}
