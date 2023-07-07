/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package poe2023;

/**
 *
 * @author Vuyani
 */
public class POE2023 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      
        //Login object
        Login objOne = new Login();
        //registers and logs in the user
        objOne.regAndLogin();
        
        //Kanban object -- once the user has logged in the user is taken to the welcome screen
        new Task().MainMenu();
    }
    
}
