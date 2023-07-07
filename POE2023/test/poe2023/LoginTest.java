/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package poe2023;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Vuyani
 */
 public class LoginTest {
    
    public LoginTest() {
        
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of checkUserName method, of class Login.
     */
    @Test
    public void testCheckUserName1() {
        //When the user enters a correctly formatted username
        //Arrange
        Login instance = new Login();
        instance.userName = "kyl_1";
        
        //Act
        boolean result = instance.checkUserName();
        
        //Assert
        assertTrue(result);
    }
    @Test
    public void testCheckUserName2() {
        //When the user enters an incorrectly formatted username
        //Arrange
        Login instance = new Login();
        instance.userName = "kyle!!!!!!!";
        
        //Act
        boolean result = instance.checkUserName();
        
        //Assert
        assertFalse(result);
    }

    /**
     * Test of checkPasswordComplexity method, of class Login.
     */
    @Test
    public void testCheckPasswordComplexity1() {
        //The user enters a correctly formatted password
        //Arrange
        Login instance = new Login();
        instance.password = "Ch&&sec@ke99!";
       
        
        //Act
        boolean result = instance.checkPasswordComplexity();
        
        //Assert
        assertTrue(result);
    }
    @Test
    public void testCheckPasswordComplexity2() {
        //The user enters an incorrectly formatted password
        //Arrange
        Login instance = new Login();
        instance.password = "password";
        
        
        //Act
        boolean result = instance.checkPasswordComplexity();
        
        //Assert
        assertFalse(result);
    }

    /**
     * Test of registerUser method, of class Login.
     */
    @Test
    public void testRegisterUser1() {
        //User enters incorrectly formatted usename
        Login instance = new Login();
        instance.userName = "kyle!!!!!!!";
        instance.checkUserName(); //initializes the scenarios variable
        String expResult = "Username is not\n" + "successfully captured,\n" +
                            "please ensure that\n" + "your username\n" +
                            "contains an\n" + "underscore and is no\n" +
                            "more than 5\n" + "characters in length";
        
        //Act
        String result = instance.registerUser();
        
        //Assert
        assertEquals(expResult, result);
    }
    @Test
    public void testRegisterUser2() {
        //User enters correctly formatted usename
        Login instance = new Login();
        instance.userName = "kyl_1";
        instance.checkUserName(); //initializes the scenarios variable
        String expResult = "Username successfully captured!";
        
        //Act
        String result = instance.registerUser();
        
        //Assert
        assertEquals(expResult, result);
    }
    @Test
    public void testRegisterUser3() {
        //User enters correctly formatted password
        Login instance = new Login();
        instance.password= "Ch&&sec@ke99!";
        instance.checkPasswordComplexity(); //initializes the scenarios variable
        String expResult = "Password successfully captured";
        
        //Act
        String result = instance.registerUser();
        
        //Assert
        assertEquals(expResult, result);
    }
    @Test
    public void testRegisterUser4() {
        //User enters incorrectly formatted password
        Login instance = new Login();
        instance.password= "password";
        instance.checkPasswordComplexity(); //initializes the scenarios variable
        String expResult = "Password is not\n" + "successfully captured,\n" +
                          "please ensure that\n" +"the password\n" +
                          "contains at least 8\n" + "characters, a capital\n" +
                          "letter, a number and\n" + "a special character.";
        
        //Act
        String result = instance.registerUser();
        
        //Assert
        assertEquals(expResult, result);
    }
    

    /**
     * Test of loginUser method, of class Login.
     */
    @Test
    public void testLoginUser1() {
        //Arrange -- User successfully logins (correct login credentials entered
        Login instance = new Login();
        instance.userName = "kyl_1";
        instance.password = "Ch&&sec@ke99!";
        String newUsername = "kyl_1";
        String newPassword = "Ch&&sec@ke99!";
        
        //Act
        boolean result = instance.loginUser(newUsername, newPassword);
        
        //Assert
        assertTrue(result);
    }
    @Test
    public void testLoginUser2() {
        //Arrange -- User fails to login (incorrect login credentials entered)
        Login instance = new Login();
        instance.userName = "kyle1000000";
        instance.password = "Cheesecake";
        String newUsername = "k88";
        String newPassword = "Ch&&sec@50!";
        
        //Act
        boolean result = instance.loginUser(newUsername, newPassword);
        
        //Assert
        assertFalse(result);
    }
    
}
