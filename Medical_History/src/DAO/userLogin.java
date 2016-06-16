/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

/**
 *
 * @author Scorpius
 */
public class userLogin {
    private String userName;
    private String pssword;
    private int type;

    
    public userLogin(String userName,String password,int type){
    
    this.userName=userName;
    this.pssword=password;
    this.type=type;
    
    }

    public userLogin() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public userLogin(String username, String password) {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   
    this.userName=username;
    this.pssword=password;
    
    }

   
    
    
    
    
    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return the pssword
     */
    public String getPssword() {
        return pssword;
    }

    /**
     * @param pssword the pssword to set
     */
    public void setPssword(String pssword) {
        this.pssword = pssword;
    }

    /**
     * @return the type
     */
    public int getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(int type) {
        this.type = type;
    }
}
