/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import DAO.patientD;
import DAO.userLogin;
import DAO.user_details;
import java.util.ArrayList;
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
public class userDetailsCTest {
    
    public userDetailsCTest() {
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
     * Test of addNewUser method, of class userDetailsC.
     */
    @Test
    public void testAddNewUser() throws Exception {
        System.out.println("addNewUser");
        user_details newUser = null;
        userLogin newUserLogin = null;
        userDetailsC.addNewUser(newUser, newUserLogin);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getId method, of class userDetailsC.
     */
    @Test
    public void testGetId() throws Exception {
        System.out.println("getId");
        String userName = "1@2";
        int expResult = 0;
        int result = userDetailsC.getId(userName);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of returnListP method, of class userDetailsC.
     */
    @Test
    public void testReturnListP() throws Exception {
        System.out.println("returnListP");
        ArrayList<Integer> list = null;
        ArrayList<patientD> expResult = null;
        ArrayList<patientD> result = userDetailsC.returnListP(list);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
