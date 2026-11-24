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
public class EmployeeMergeSort {
    
    public void mergeSort(ArrayList<Employee> employees) { //this method receives the list of employees
        
        if(employees.size() <= 1) { //this will stop our list of dividing itself until we arrive <=1 result
            return;
        }
        
        int middle = employees.size() / 2; //.size gets the number of employees
        
        ArrayList<Employee> left = new ArrayList<>(); //share the total of employees in two list - empty now.
        ArrayList<Employee> right = new ArrayList<>();
        
        for (int i = 0; i < middle; i++) { //add employees from total list to the left side
            left.add(employees.get(i));
        }
        
        for (int i = middle; i < employees.size(); i++) { //add employees from total list to the right side
            right.add(employees.get(i));
        }
        
        mergeSort(left); //call the part left of the mergeSort method.
        mergeSort(right); //call the right part of our list inside mergeSort method.
        
        merge(employees, left, right); //combine both sorted lists in alphabetical order on the output
    }
    
    private void merge(ArrayList<Employee>employees, //call the mergeSort method and with the index "i=0" controls the position on the three list of employees
                       ArrayList<Employee> left, 
                       ArrayList<Employee> right) {
        int i = 0;
        int j = 0;
        int k = 0;
        
        while (i < left.size() && j < right.size()) { //while compare conditions where both conditions must be true (&&)
            
            if (left.get(i).getName().compareToIgnoreCase( //comparteToIgnoreCase compare names to define which letter come first/next in the alphabet
                right.get(j).getName()) <= 0) {
                
                employees.set(k, left.get(i));
                i++;
                
            } else {
                
                employees.set(k, right.get(j)); //It takes the comparison and orde the list into alphabetical order
                j++;
            }
            
            k++;
        }
        
        while (i < left.size()) {
            employees.set(k, left.get(i));
            i++;
            k++;
            
            }
        
        while (j < right.size()) {
            employees.set(k, right.get(j));
            j++;
            k++;
        }
       
    }
    
}
