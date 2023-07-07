/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package poe2023;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Vuyani
 */
public class TaskTest {
    
    
    public TaskTest() {
        
    }
    
    @BeforeClass
    public static void setUpClass() {
        
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of checkTaskDescription method, of class Task.
     */
    @Test
    public void testCheckTaskDescription() {
        
        //Arrange for first and second task
        Task t = new Task();
        t.taskName = new String[]{"Login Feature","Add Task Feature"};
        t.taskNumber = new int[]{0,1};
        t.taskDescription = new String[]{"Create Login to authenticate users","Create Add Task feature to add task users"};
        t.developDetails = new String[]{"Harrison Robyn", "Smith Mike"};
        t.taskDuration = new double[]{8,10};
        t.taskID = new String[]{"CR:0:IKE","AD:1:BYN"};
        t.taskStatus = new String[]{"To Do", "Doing"};
        
        //Test for task 1 and 2 test data
        for (int i = 0; i < t.taskName.length; i++) {
            //Arrange
            String description = t.taskDescription[i];
            Task instance = new Task();
            boolean expResult = true;

            //Act
            boolean result = instance.checkTaskDescription(description);

            //Assert
            assertEquals(expResult, result);
        }
    }
    
    /**
     * Test of createTaskID method, of class Task.
     */
    @Test
    public void testCreateTaskID1() {
        
        //Arrange for first and second task
        Task t = new Task();
        t.taskName = new String[]{"Login Feature","Add Task Feature"};
        t.taskNumber = new int[]{0,1};
        t.taskDescription = new String[]{"Create Login to authenticate users","Create Add Task feature to add task users"};
        t.developDetails = new String[]{"Harrison Robyn", "Smith Mike"};
        t.taskDuration = new double[]{8,10};
        t.taskID = new String[]{"CR:0:IKE","AD:1:BYN"};
        t.taskStatus = new String[]{"To Do", "Doing"};
        
        //Test for task 1 and 2 test data
        for (int i = 0; i < t.taskName.length; i++) {
            //Arrange
            Task instance = new Task();
            String expResult = t.taskID[i];
            
            //Act
            String result = instance.createTaskID(i);
            //Assert
            assertEquals(expResult, result);
        }
    }
    @Test
    public void testCreateTaskID2() {
        
        //Arrange for first and second task
        Task t = new Task();
        t.taskName = new String[]{"Login Feature","Add Task Feature"};
        t.taskNumber = new int[]{0,1};
        t.taskDescription = new String[]{"Create Login to authenticate users","Create Add Task feature to add task users"};
        t.developDetails = new String[]{"Harrison Robyn", "Smith Mike"};
        t.taskDuration = new double[]{8,10};
        t.taskID = new String[]{"CR:0:IKE","AD:1:BYN"};
        t.taskStatus = new String[]{"To Do", "Doing"};
        
        //Test for task 1 and 2 test data
        for (int i = 0; i < t.taskName.length; i++) {
            //Arrange
            Task instance = new Task();
            String expResult = t.taskID[i];
            
            //Act
            String result = instance.createTaskID(i);
            //Assert
            assertEquals(expResult, result);
        }
    }

    /**
     * Test of printTaskDetails method, of class Task.
     */
    @Test
    public void testPrintTaskDetails1() {
        
        //Arrange for first and second task
        Task t = new Task();
        t.taskName = new String[]{"Login Feature","Add Task Feature"};
        t.taskNumber = new int[]{0,1};
        t.taskDescription = new String[]{"Create Login to authenticate users","Create Add Task feature to add task users"};
        t.developDetails = new String[]{"Harrison Robyn", "Smith Mike"};
        t.taskDuration = new double[]{8,10};
        t.taskID = new String[]{"CR:0:IKE","AD:1:BYN"};
        t.taskStatus = new String[]{"To Do", "Doing"};
        
        //Test for task 1 and 2 data
        
        for (int i = 0; i < t.taskName.length; i++) {
            //Arrange
            Task instance = new Task();
            String expResult = "Task status: " + t.taskStatus[i] + "\n"
                + "Developer name: " + t.developDetails[i] + "\n"
                + "Task number: " + t.taskNumber[i] + "\n"
                + "Task name: " + t.taskName[i] + "\n"
                + "Task description: " + t.taskDescription[i] + "\n"
                + "Task ID: " + t.taskID[i] + "\n"
                + "Task duration: " + t.taskDuration[i];

            //Act
            String result = instance.printTaskDetails(i);

            //Assert
            assertEquals(expResult, result);
        }
    }

    /**
     * Test of returnTotalHours method, of class Task.
     */
    @Test
    public void testReturnTotalHours1() {
        //This is for the additional test data
        //Arrange
        Task instance = new Task();
        instance.taskDuration = new double[]{10,12,55,11,1};
        int expResult = 10 + 12 + 55 + 11 + 1;
        
        //Act
        int result  = instance.returnTotalHours();
        
        
        //Assert
        assertEquals(expResult, result);
    }
    
    public void testReturnTotalHours2()
    {
        //Arrange for first and second task
        Task t = new Task();
        t.taskName = new String[]{"Login Feature","Add Task Feature"};
        t.taskNumber = new int[]{0,1};
        t.taskDescription = new String[]{"Create Login to authenticate users","Create Add Task feature to add task users"};
        t.developDetails = new String[]{"Harrison Robyn", "Smith Mike"};
        t.taskDuration = new double[]{8,10};
        t.taskID = new String[]{"CR:0:IKE","AD:1:BYN"};
        t.taskStatus = new String[]{"To Do", "Doing"};

    // This is for task 1 and two
        //Arrange
        int expResult = 18;
        
        //Act
        int result = t.returnTotalHours();
        
        //Assert
        assertEquals(expResult, result);
    }
    
}
