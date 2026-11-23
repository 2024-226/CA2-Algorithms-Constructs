/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package schoolmanagement;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
/**
 *
 * @author isabe
 */

//class to read the employee information txt.
public class EmployeeFileReader { 
    
    public ArrayList<Employee> readEmployees(String fileName) throws IOException {
        
        ArrayList<Employee> employees = new ArrayList<>(); //this create an empty list to store employee objects
        
        File file = new File(fileName);
        Scanner scanner = new Scanner(file);
        
        scanner.nextLine(); //make the code skip the heading on the .txt
        
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            
            if (line.trim().isEmpty()) { //prevent error in empty lines
                continue;
            }
            
            String[] data = line.split(",", -1); //separates line at comma and keep empty records.
            
            
            System.out.println("Reading line: " + line);
            System.out.println("Number of fields: " + data.length);
            
            
            String name = data[0] + " " + data[1];
            String department = data[5];
            String managerType = data[7];
            
            Employee employee = new Employee(name, managerType, department); //it will call employee class and insert the data in the correct place.
            
            employees.add(employee); //it will insert the employee information (stores into the memory)
        }
        
        scanner.close();
        
        return employees; //give the completed list of employee.
    }
    
}
