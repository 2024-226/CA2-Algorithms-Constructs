/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package schoolmanagement;

import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeManagement { //Insertion of new employees by user

    private ArrayList<Employee> newEmployees = new ArrayList<>(); //stores new added employees

    public void addEmployee(ArrayList<Employee> employees, Scanner scanner) {

        //User can enter new employee name
        System.out.println("\nEnter new employee's full name:");
        String name = scanner.nextLine().trim();

        //Validate employee name
        while (name.isEmpty()) {
            System.out.println("Name cannot be empty. Please try again:");
            name = scanner.nextLine().trim();
        }

        //Keep data integrity with a selection of previous manager types
        String[] managerTypes = {
            "Head Deputy",
            "Senior Deputy",
            "Deputy",
            "Assistant Deputy",
            "Team Lead"
        };

        System.out.println("\nSelect Manager Type:");

        //Give a numerical list of manager types
        for (int i = 0; i < managerTypes.length; i++) {
            System.out.println((i + 1) + ". " + managerTypes[i]);
        }

        int managerChoice = 0;

        //Validate the user option for manager types
        while (managerChoice < 1 || managerChoice > managerTypes.length) {

            System.out.println("Enter your choice:");

            if (scanner.hasNextInt()) {
                managerChoice = scanner.nextInt();
                scanner.nextLine();

                if (managerChoice < 1 || managerChoice > managerTypes.length) {
                    System.out.println("Invalid option. Please try again.");
                }

            } else {
                System.out.println("Please enter a valid number.");
                scanner.nextLine();
            }
        }

        String managerType = managerTypes[managerChoice - 1];

        System.out.println("Selected Manager Type: " + managerType);

        //Return list of departments
        ArrayList<String> departments = new ArrayList<>();

        for (Employee employee : employees) {

            //Department associated to employee
            String department = employee.getDepartment();

            if (!departments.contains(department)) {
                departments.add(department);
            }
        }

        System.out.println("\nSelect Department:");

        //Present the list of departments to be chosen
        for (int i = 0; i < departments.size(); i++) {
            System.out.println((i + 1) + ". " + departments.get(i));
        }

        int departmentChoice = 0;

        //Validate the department selection
        while (departmentChoice < 1 || departmentChoice > departments.size()) {

            System.out.println("Enter your choice:");

            if (scanner.hasNextInt()) {
                departmentChoice = scanner.nextInt();
                scanner.nextLine();

                if (departmentChoice < 1 || departmentChoice > departments.size()) {
                    System.out.println("Invalid option. Please try again.");
                }

            } else {
                System.out.println("Please enter a valid number.");
                scanner.nextLine();
            }
        }

        String selectedDepartment = departments.get(departmentChoice - 1);

        System.out.println("Selected Department: " + selectedDepartment);
        
        
        Employee newEmployee = new Employee(name, managerType, selectedDepartment); //call the constructor to add new employees
        
            employees.add(newEmployee);
            newEmployees.add(newEmployee);
            
            EmployeeMergeSort sorter = new EmployeeMergeSort();
            sorter.mergeSort(employees);//MergeSort to keep the alphabetical order of new employees
            
            System.out.println("\nEmployee added successfully!");
            System.out.println("Total employees: " + employees.size());
            System.out.println("New employees: " + newEmployees.size());

    }
    
    public void displayNewEmployees() { //show de new added employees 
        
        System.out.println("\nNewly added employees:");
        
        for (Employee employee : newEmployees) {
            System.out.println("Name: " + employee.getName());
            System.out.println("Manager Type: " + employee.getManagerType());
            System.out.println("Department: " + employee.getDepartment());
            System.out.println("--------------------");
        }
    }
}
