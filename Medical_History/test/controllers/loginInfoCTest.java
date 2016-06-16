/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import DAO.userLogin;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Scorpius
 */
public class loginInfoCTest {
    
    public loginInfoCTest() {
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
     * Test of addNewUser method, of class loginInfoC.
     */
//    @Test
//    public void testAddNewUser() throws Exception {
//        System.out.println("addNewUser");
//        userLogin userLogin = null;
//        userLogin=new userLogin("123@gmail.com", "456", 1);
//        loginInfoC.addNewUser(userLogin);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    

 @Test
    public void testAddNewUser() throws Exception {
        System.out.println("addNewUser");
        userLogin userLogin = null;
        userLogin=new userLogin("123@gmail.com", "456", 1);
        loginInfoC.addNewUser(userLogin);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }




}
