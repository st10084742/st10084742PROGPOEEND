/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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
public class SearchTest {
    public SearchTest() {
        
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
    @Test
    public void testDataTask1() {
    Search s = new Search();
        s.taskName = new String[]{"Create Login"};
        s.developDetails = new String[]{"Mike Smith"};
        s.taskDuration = new double[] {5};
        s.taskStatus = new String[]{"To Do"};
    }
    @Test
    public void testDataTask2() {
    Search s = new Search();
        s.taskName = new String[]{"Create Add Features"};
        s.developDetails = new String[]{"Edward Harrison"};
        s.taskDuration = new double[] {8};
        s.taskStatus = new String[]{"Doing"};
    }
    @Test
    public void testDataTask3() {
    Search s = new Search();
        s.taskName = new String[]{"Create Reports"};
        s.developDetails = new String[]{"Samantha Paulson"};
        s.taskDuration = new double[] {2};
        s.taskStatus = new String[]{"Done"};
    }
    @Test
    public void testDataTask4() {
    Search s = new Search();
        s.taskName = new String[]{"Add Arrays"};
        s.developDetails = new String[]{"Glenda Oberholzer"};
        s.taskDuration = new double[] {11};
        s.taskStatus = new String[]{"To DO"};
    }
    @Test
    public void testDisplayDone(){
        Search details = new Search();
         details.displayDone();
    }@Test
    public void testdisplayLongest(){
        Search details = new Search();
         details.displayLongest();
    }@Test
    public void searchByName(){
        Search details = new Search();
         details.searchByName();
    }@Test
    public void searchByDeveloper(){
        Search details = new Search();
         details.searchByDeveloper();
    }@Test
    public void testdelete(){
        Search details = new Search();
         details.delete();
    }@Test
    public void testReport(){
       Search details = new Search();
         details.report();
      }
}
