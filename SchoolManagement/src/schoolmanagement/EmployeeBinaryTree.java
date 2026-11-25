/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package schoolmanagement;

import java.util.Queue;
import java.util.LinkedList;

/**
 *
 * @author isabe
 */
public class EmployeeBinaryTree {
    
    private BinaryTree root;
    
    public void insert(Employee employee) {
        
        BinaryTree newNode = new BinaryTree(employee); //node are employees
        
        if (root == null) {
            root = newNode;
            return;
            
        }
        
        Queue<BinaryTree> queue = new LinkedList<>(); //nodes are added in a queue
        queue.add(root);
        
        while (!queue.isEmpty()) {
            
            BinaryTree current = queue.poll();
            
            if (current.left == null) { //check the positions to add left and right
                current.left = newNode;
                return;
                
            } else {
                queue.add(current.left);
            }
            
            if (current.right == null) {
                current.right = newNode;
                return;
                
            } else {
                queue.add(current.right);
            }
        }
    }
    
    public void levelOrderTraversal() {

    if (root == null) {
        System.out.println("The tree is empty.");
        return;
    }

    Queue<BinaryTree> queue = new LinkedList<>();
    queue.add(root);

    System.out.println("\nEmployee Hierarchy:");

    while (!queue.isEmpty()) {

        BinaryTree current = queue.poll();

        System.out.println(current.employee.getName());

        if (current.left != null) {
            queue.add(current.left);
        }

        if (current.right != null) {
            queue.add(current.right);
        }
    }
}
}
