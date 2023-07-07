/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poe2023;

import javax.swing.JOptionPane;

/**
 *
 * @author Vuyani
 */
public class Search {
    
    
    public String[] taskName;
    public int[] taskNumber;
    public String[] taskDescription;
    public String[] developDetails;
    public double [] taskDuration;
    public String[] taskID;
    public String[] taskStatus;
  
    
    public void SearchMenu(String[] taskName, int[] taskNumber, String[] taskDescription, String[] developDetails, double[] taskDuration, String[] taskID, String[] taskStatus, int numberOfTasks){
        this.taskName = taskName;
        this.taskNumber = taskNumber;
        this.taskDescription = taskDescription;
        this.developDetails = developDetails;
        this.taskDuration = taskDuration;
        this.taskID = taskID; 
        this.taskStatus = taskStatus;
        
        boolean goBack = false;
        while (!goBack)
        {
            int option;
            option = Integer.parseInt( JOptionPane.showInputDialog(null, "Report menu: \n"
                    + "Please select one of the options \n"
                    + "Option 1: Display details for tasks with 'done' status \n"
                    + "Option 2: Display details for task with longest duration \n"
                    + "Option 3: Search for task using the task name \n"
                    + "Option 4: Search for tasks assigned to a developer \n"
                    + "Option 5: Delete a task using a using the Task Name \n"
                    + "Option 6: Display report of all tasks \n"
                    + "Option 7: Back"));
            switch(option){
                case 1: displayDone();
                    break;
                case 2: displayLongest();
                    break;
                case 3: searchByName();
                    break;
                case 4: searchByDeveloper();
                    break;
                case 5: delete();
                    break;
               case 6: report();
                   break;
                case 7: goBack = true;
                    break;
                default: JOptionPane.showMessageDialog(null, "Invalid choice");
            }
        }
    }
   
    public void displayDone(){
        boolean found = false; // confirms when a task has been found
        for( int i = 0; i < taskName.length; i++)
        {
            if(taskStatus[i].equals("Done"))
            {
                JOptionPane.showMessageDialog(null, "Developer name: " + developDetails[i] + "\n"
                + "Task name: " + taskName[i] + "\n"
                + "Task duration: " + taskDuration[i]);
                found = true;
            }  
        }
        if (!found)
        {
            JOptionPane.showMessageDialog(null, "No tasks are done.");
        }
    }
    
    
    public void displayLongest(){
        double a = taskDuration[0]; //holds the longest task duration
        for(int i = 0; i < taskDuration.length; i++)
        {
            if (taskDuration[i] > a)//finds the longest task duration
            {
                a = taskDuration[i];
            }
            
        }
        
        for (int i = 0; i < taskDuration.length; i++)
        {
            if (a == taskDuration[i]){ //displays task(s) that has longest duration
                JOptionPane.showMessageDialog(null, "Developer name: " + developDetails[i] + "\n"
                  + "Task duration: " + taskDuration[i]);
               
        }
        
    }
    }
    
    
    public void searchByName(){
        
        //getting user input
        String searchName = JOptionPane.showInputDialog("Enter the name of the task you wish to display");
        boolean found = false;
        
        for(int i = 0; i < taskName.length; i++)
        {
            if(taskName[i].equals(searchName))
            {
                JOptionPane.showMessageDialog(null, "Task status: " + taskStatus[i] + "\n"
                + "Developer name: " + developDetails[i] + "\n"
                + "Task name: " + taskName[i] + "\n");
                        
                found = true;
            }
        }
        if (!found)
        {
            JOptionPane.showMessageDialog(null, "There are no tasks by that name");
        }
    }
    
    
    public void searchByDeveloper(){ 
       //getting user input
        String searchName = JOptionPane.showInputDialog("Enter the full developer name");
        boolean found = false;
        
        for(int i = 0; i < developDetails.length; i++)
        {
            if(developDetails[i].equals(searchName))
            {
                JOptionPane.showMessageDialog(null, "Task status: " + taskStatus[i] + "\n"
                    + "Task name: " + taskName[i] + "\n");
            }
        }
        if (found)
        {
            JOptionPane.showMessageDialog(null, "There are no tasks assigned to that developer");
        }
    }

    
    public void delete(){
        //method deletes a task
        String delete = JOptionPane.showInputDialog("Enter the name of the task that you want to delete:");
        
        int newSize = taskName.length - 1;
        String[] newTaskName = new String[newSize];
        int[] newTaskNumber =  new int[newSize];
        String[] newTaskDescription =  new String[newSize];
        String[] newDevelopDetails =  new String[newSize];
        double [] newTaskDuration = new double[newSize];
        String[] newTaskID =  new String[newSize];
        String[] newTaskStatus =  new String[newSize];
        
        int newIndex = 0; //holds index for the new array.
        for (int i = 0; i < taskName.length; i++) { //copies all array information into new array and skips the deleted task
            if (!taskName[i].equals(delete)) //skips the deleted item
            {
                    newTaskName[newIndex] = taskName[i];
                    newTaskNumber[newIndex] = taskNumber[i];
                    newTaskDescription[newIndex] = taskDescription[i];
                    newDevelopDetails[newIndex] = developDetails[i];
                    newTaskDuration[newIndex] = taskDuration[i];
                    newTaskID[newIndex] = taskID[i];
                    newTaskStatus[newIndex] = taskStatus[i];
                    newIndex += 1;
            }
        }
        if (newTaskName.length == taskName.length) // when the number of tasks does not change the searched name was not found
        {
            JOptionPane.showMessageDialog(null, "There are no tasks assigned to that developer");
        }
        else
        {
            
            //pasting tasks to global arrays
            taskName = newTaskName;
            taskNumber = newTaskNumber;
            taskDescription = newTaskDescription;
            developDetails = newDevelopDetails;
            taskDuration = newTaskDuration;
            taskID = newTaskID;
            taskStatus = newTaskStatus;
            
            
            JOptionPane.showMessageDialog(null, "Task successfully deleted");
        }
    }
    
     public void report(){
        for(int i = 0; i < developDetails.length; i++)
        {
            
                JOptionPane.showMessageDialog(null, "Task status: " + taskStatus[i] + "\n"
                + "Developer name: " + developDetails[i] + "\n"
                + "Task number: " + taskNumber[i] + "\n"
                + "Task name: " + taskName[i] + "\n"
                + "Task description: " + taskDescription[i] + "\n"
                + "Task ID: " + taskID[i] + "\n"
                + "Task duration: " + taskDuration[i]);
        }
    }
} 