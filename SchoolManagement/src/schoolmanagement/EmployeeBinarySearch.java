/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package schoolmanagement;

import java.util.ArrayList;

/**
 *
 * @author isabe
 */
public class EmployeeBinarySearch {
    
    public Employee binarySearch(ArrayList<Employee> employees,
                                 String name, int low, int high) { //binarySearch method receive the list of Employees (46 names) and define our searchin area (low0 and high45)
        
        if (low > high) {
            return null; //if we did not find the name, return null.
        }
                      
        int middle = low + (high - low) / 2; //calculate the middle position
                
        Employee middleEmployee = employees.get(middle);//return the employee that is in the middle - calculated above
        
        int comparison = name.compareToIgnoreCase(middleEmployee.getName()); //compare names
        
        if (comparison == 0) { //0 means the employee that we are seaching for
            return middleEmployee; //the employee was found, stop the search. 
            
        } else if (comparison < 0) { //if the employee is not in the middle, either the code goes to the left or to the right according to the letter
            return binarySearch(employees, name, low, middle - 1); //again, employee is found, stop the search
            
        } else {
            return binarySearch(employees, name, middle + 1, high);
            
        }
        
     }
    
}
