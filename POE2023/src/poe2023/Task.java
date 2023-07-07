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


    
   
public class Task{
//parallel arrays
public String[] taskName;
    public int[] taskNumber;
    public String[] taskDescription;
    public String[] developDetails;
    public double[] taskDuration;
    public String[] taskID;
    public String[] taskStatus;
    private int numberOfTasks;
    
    
    //getters and setters to make arrays accessible in Search class
    public String[] getTaskName() {
        return taskName;
    }

    public void setTaskName(String[] taskName) {
        this.taskName = taskName;
    }

    public int[] getTaskNumber() {
        return taskNumber;
    }

    public void setTaskNumber(int[] taskNumber) {
        this.taskNumber = taskNumber;
    }

    public String[] getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String[] taskDescription) {
        this.taskDescription = taskDescription;
    }

    public String[] getDevelopDetails() {
        return developDetails;
    }

    public void setDevelopDetails(String[] developDetails) {
        this.developDetails = developDetails;
    }

    public double[] getTaskDuration() {
        return taskDuration;
    }

    public void setTaskDuration(double[] taskDuration) {
        this.taskDuration = taskDuration;
    }

    public String[] getTaskID() {
        return taskID;
    }

    public void setTaskID(String[] taskID) {
        this.taskID = taskID;
    }

    public String[] getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(String[] taskStatus) {
        this.taskStatus = taskStatus;
    }

    public int getNumberOfTasks() {
        return numberOfTasks;
    }

    public void setNumberOfTasks(int numberOfTasks) {
        this.numberOfTasks = numberOfTasks;
    }
    
   
   
    //main menu method
    public void MainMenu() {
        int option;
        //Housekeeping
        JOptionPane.showMessageDialog(null, "Welcome to EasyKanban");
        
        //a do while that displays main menu options
        do{
            //Prompt
            option = Integer.parseInt(JOptionPane.showInputDialog(null, "Please select one of the options:\n"
                + "Option 1) Add tasks\n"
                + "Option 2) Show report\n" //change Option 2's "Coming soon" to "Show report"
                + "Option 3) Quit"));
            
            //switch case for option selected for the main menu
         
            switch(option){
                case 1: addTasks(); break;
                case 2: if(numberOfTasks == 0){ 
//                            report(developDetails, taskName, taskID,taskDuration,taskStatus);
//                        } else{
                            JOptionPane.showMessageDialog(null,
                         "Please enter tasks before selecting this option");
                        } else {
                   Search menuObject = new Search();
                           menuObject.SearchMenu(taskName,taskNumber, taskDescription,developDetails, taskDuration,taskID,  taskStatus, numberOfTasks);
                }

                break;
                case 3: System.exit(0); break;
                default: JOptionPane.showMessageDialog(null, "You have selected an incorrect option");
                
            }
        } while(true);
        //main menu will infinitely loop until user selects Option 3 to quit
        
    }

    //the addTasks method allows the user to generate tasks
    private int addTasks() {
        //Requesting the number of tasks the user wants
         numberOfTasks = Integer.parseInt(JOptionPane.showInputDialog(null, "How many tasks would you like to enter?: "));
//        double hours;
        
        //instantiating the arrays
        taskName = new String[numberOfTasks];
        taskNumber = new int[numberOfTasks];
        taskDescription = new String[numberOfTasks];
        developDetails = new String[numberOfTasks];
        taskDuration = new double[numberOfTasks];
        taskID = new String [numberOfTasks];
        taskStatus = new String [numberOfTasks];
        
        //Prompting the user for all the tasks
        for (int i = 0; i < numberOfTasks; i++) {
            taskName[i] = JOptionPane.showInputDialog(null, "What is the task name you would like to enter?");
            taskNumber[i] = i;
            developDetails[i] =  JOptionPane.showInputDialog(null, "Enter name and last name of the developer (eg Vuyani Diko): ");
            
                   
            //Description prompt
            boolean ctrl = false;
            while (ctrl == false)
            {
                taskDescription[i] = JOptionPane.showInputDialog(null, "Please enter a task description less than 50 characters");
                //method that checks for length
                ctrl = checkTaskDescription(taskDescription[i]);
            }
            //method asks how long task will take in hours
            taskDuration[i] = Double.parseDouble(JOptionPane.showInputDialog(null, "Please enter task duration"));
            
            taskID[i] = createTaskID(i);
             
            //Prompting user for task status
            int statusNumber = 0;
            do
            {
                statusNumber = Integer.parseInt(JOptionPane.showInputDialog("Please select the status of the task:\n"
                        + "1. To Do\n"
                        + "2. Done\n"
                        + "3. Doing"));
                switch (statusNumber)
                {
                    case 1: taskStatus[i] = "To Do";break;
                    case 2: taskStatus[i] = "Done"; break;
                    case 3: taskStatus[i] = "Doing"; break;
                    default: JOptionPane.showMessageDialog(null,"Invalid Choice!");
                  
                }    
             // range check
            }while (statusNumber > 3 && statusNumber < 1);
            JOptionPane.showMessageDialog(null, printTaskDetails(i));
            
        }
        //displays task total hours using returnTotalHours method
       JOptionPane.showMessageDialog(null, "The total hours for the tasks is: " + returnTotalHours());
          
     
       
       return 1;
    
    }
    
    //method ensures that task description entered is 50 characters or less
    public boolean checkTaskDescription(String description) {
        if(description.length() <= 50)
           return true;
        else
            return false;
    }

    //createTaskID will generate ID of task (task name: task number : last three letters of developer)
    public String createTaskID(int i) {
        
        int endIndex = developDetails[i].length();
        String id = (taskName[i].substring(0, 2) + ":" + i + ":" + developDetails[i].substring((endIndex-3), endIndex)).toUpperCase();
        
        return id;
    }
    //will print every detail of a task a time when invoked
    public String printTaskDetails(int i){
        
        String message = "Task status: " + taskStatus[i] + "\n"
                + "Developer name: " + developDetails[i] + "\n"
                + "Task number: " + taskNumber[i] + "\n"
                + "Task name: " + taskName[i] + "\n"
                + "Task description: " + taskDescription[i] + "\n"
                + "Task ID: " + taskID[i] + "\n"
                + "Task duration: " + taskDuration[i];
        
        return message;
    }
    //method adds up all task hours together
    public int returnTotalHours(){
        double totalHours = 0;
        for (int j = 0; j < taskDuration.length; j++) {
            totalHours += taskDuration[j];
           
        }
       return (int)totalHours; //type cast to prevent lossy conversion
    }
    
   
}
