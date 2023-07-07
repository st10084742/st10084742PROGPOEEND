/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poe2023;

import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Vuyani
 * references: 
 * 1- https://www.tutorialspoint.com/how-can-we-limit-the-number-of-characters-inside-a-jtextfield-in-java
 * 2- 
 * 
 */



//Login method will be invoked by main method

public class Login {
    static Scanner input = new Scanner(System.in);


    //declare variables
   public String userName;
   public String password;
   public String firstName;
   public String lastName;

    int scenarios;
    boolean check1;
    boolean check2;
    
    //regAndLogin method for registering and logging in the user
    
    public void regAndLogin(){
        boolean ctrl;
        String username2;
        String password2;
      
        //do while iterates when userName is incorrectly formatted
        do{
            //user name prompt
            userName = JOptionPane.showInputDialog("Please enter username >>> ");
            
            ctrl = checkUserName();
            JOptionPane.showMessageDialog(null, registerUser());
        }while(ctrl == false);
        
        // do while iterates when password is incorrectly formatted
        do {
            //prompts the user for passoword
            password = JOptionPane.showInputDialog("Please enter password >>> ");
            ctrl = checkPasswordComplexity();
            JOptionPane.showMessageDialog(null, registerUser());
        } while(ctrl == false);
        
        //prompt
       
        firstName =  JOptionPane.showInputDialog("Please enter your first name >>> ");
        lastName = JOptionPane.showInputDialog("Please enter your lastName >>> ");
        
        
        //Logging the user in
        
        boolean endLoop = false;
        while(endLoop == false){
        username2 = JOptionPane.showInputDialog("Please login to your account:\nPlease enter a username: ");
        password2 = JOptionPane.showInputDialog("Please enter a password: ");
        
        
        
        //Checking credentials and displaying message
        JOptionPane.showMessageDialog(null, returnLoginStatus(( endLoop = loginUser(username2, password2))));
      }
    }
     
    //method that checks the username and returns a boolean
    public boolean checkUserName()
    {
       if(userName.contains("_") && (userName.length() <= 5))//single statements dont need curly braces
        {
            scenarios = 1;
            return true; // returns a true when both conditions are met
        }
        else {
            scenarios = 2;
        }
         return false;
    } //returns a false value when any one condition is false
      
    
    
    //method that checks the username and returns a boolean
    public boolean checkPasswordComplexity()
    {
        if(!password.equals(password.toLowerCase()) && 
                !password.equals(password.toUpperCase()) &&
                (password.matches(".*\\d+.*")) && 
                (password.length() >= 8)&& (((password.contains("@") || password.contains("#")
              || password.contains("!") || password.contains("~")
              || password.contains("$") || password.contains("%")
              || password.contains("^") || password.contains("&")
              || password.contains("*") || password.contains("(")
              || password.contains(")") || password.contains("-")
              || password.contains("+") || password.contains("/")
              || password.contains(":") || password.contains(".")
              || password.contains(", ") || password.contains("<")
              || password.contains(">") || password.contains("?")
              || password.contains("|")))))
        {
            scenarios = 3;
                return true;// returns a true when both conditions are met
        }
        else
        {
            scenarios = 4;
            return false;//returns a false value when any one condition is false
        }
     }
    
    
    //this registerUser method displays a message depending on user input
    public String registerUser()
    {
        String message = "";
   
    switch(scenarios)
    {
        case 1: message = "Username successfully captured!";break;
        case 2: message = "Username is not\n" + "successfully captured,\n" +
                            "please ensure that\n" + "your username\n" +
                            "contains an\n" + "underscore and is no\n" +
                            "more than 5\n" + "characters in length";break;
        case 3: message = "Password successfully captured";break;
        case 4: message = "Password is not\n" + "successfully captured,\n" +
                          "please ensure that\n" +"the password\n" +
                          "contains at least 8\n" + "characters, a capital\n" +
                          "letter, a number and\n" + "a special character.";break;

        default: System.exit(0);
    }
    return message;
    }
    
    
    //method that checks if the register details match login details
    public boolean loginUser(String newUsername, String newPassword){
        return this.userName.equals(newUsername) && this.password.equals(newPassword);
    }
    
    //method of welcoming or incorrect message
    public String returnLoginStatus(boolean loginStatus){
        if (loginStatus == true)
          return "Welcome " + firstName + "," + lastName + " it is great to see you again.";
        else
            return "Username, or password incorrect, please try again";
    }
}

        
    

