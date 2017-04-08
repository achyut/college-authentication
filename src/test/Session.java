/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;
import java.util.Random;
/**
 *
 * @author Achyut
 * This class is used to create a session object which will handels the authentication 
 */

public class Session {

    private String sessionID;
    public String sessionUser;
    public String userID;
    private boolean authenticatedSession;
    public String sessionUserType;
    static Session s1 = new Session();
    
    Session(){
        
    }
    
    boolean AuthenticateLogin(String user, String pass, String userType) {
        DatabaseMain.db.createConnection();
        if (userType.equalsIgnoreCase("Student")) {
           // System.out.println("Inside authenticate login");
            if (DatabaseMain.db.checkUsernameAndPassword(user, pass) == true) {
                     createStudentSession();
                return true;
            }
            else {
                return false;
            }
        } 
        else if (DatabaseMain.db.authenticateUser(user, pass, userType) == true) {
            createAuthenticatedSession(user, userType); 
            DatabaseMain.db.executeQuery("UPDATE login SET lastlogin='"+TimeDate.time.timestampToFullDate(AbstractPerson.ab.currentTimeStamp())+"' WHERE name='"+user+"' AND password='"+pass+"'");
            return true;
        } else {
            return false;
        }
    }
    /*
     * 
     * This method is used to create the student sesssion 
     * By the use of this method the authenticated session 
     */
    void createStudentSession() {
        sessionID = createSessionId();
        sessionUser = "Student";
        authenticatedSession = false;
        sessionUserType = "Student";
        Log.log.writeAccessLog("Session created with session ID:"+ sessionID +" with session user: " +sessionUser);

    }
    public String getSessionID(){
        return sessionID;
    }
    void createAuthenticatedSession(String user, String userType) {
        sessionID = createSessionId();
        sessionUser = user;
        authenticatedSession = true;
        sessionUserType = userType;
        Log.log.writeAccessLog("Session created with session ID:"+ sessionID +" with session user: " +sessionUser);
    }

    public String createSessionId() {
        //random function to be bulid..
        Random rand = new Random();
        int num = rand.nextInt(99999);
        return "CCN-NITKKR-"+num;
    }

    void closeSession() {
        System.out.println("End of session");
        sessionID = null;
        sessionUser = null;
        authenticatedSession = false;
        sessionUserType = null;
        Log.log.writeAccessLog("Session closed with session ID:"+ sessionID +" with session user: " +sessionUser);
    }
}