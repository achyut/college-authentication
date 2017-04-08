/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import com.mysql.jdbc.PreparedStatement;
import java.awt.image.BufferedImage;
import java.io.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Achyut
 */
public class AbstractPerson {

    protected BufferedImage image, fingerprint;
    protected String id, name, address, phone, enteredroll, addedby, addtimestamp, status, password;
    protected int validUpto;
    static AbstractPerson ab = new AbstractPerson();
    protected File tempImage, tempFingerprint;
    /*
     * List of general functions.
     */
    long currentTimeStamp() {
        return new Date().getTime();
    }

    long getTimeDifference(long outTime, long inTime) {
        return outTime - inTime;
    }

    ResultSet getRecordFromQuery(String query) {
        ResultSet temp =null;

        try {
            if (ReadConfigFile.conf.dbPriority.equalsIgnoreCase("localDb")) {
                if (ReadConfigFile.conf.useLocalDb.equalsIgnoreCase("true")) {
                    temp = DatabaseMain.db.getResultFromLocalDb(query);
                    if (temp.next() == false) {
                        temp = DatabaseMain.db.getResultFromMasterDb(query);
                        if (temp.next() == false) {
                            return null;
                        }
                        return temp;
                    }
                    return temp;
                }
                return temp;
            } else if (ReadConfigFile.conf.dbPriority.equalsIgnoreCase("masterDb")) {
                temp = DatabaseMain.db.getResultFromMasterDb(query);
                if (temp.next() == false) {
                    if (ReadConfigFile.conf.useLocalDb.equalsIgnoreCase("true")) {
                        temp = DatabaseMain.db.getResultFromLocalDb(query);
                        if (temp.next() == false) {
                            return null;
                        }
                        return temp;
                    }
                    return temp;
                }
                return temp;
            }
            return temp;
        } catch (SQLException ex) {
            if (Log.log.displayDialog == true) {
                DialogBox.dialog.warningDialog(ex.getMessage());
            } else {
                Log.log.writeErrorLog(ex.getMessage(), "AbstractPerson", "getRecordFromQuery");
            }
            return temp;
        }
    }

    ResultSet getResult(String table, String dbType, String rollNo, String name) {
        try {
            String query1 = "SELECT * FROM " + table + " WHERE " + table + "id = '" + rollNo + "'";
            String query2 = "SELECT * FROM " + table + " WHERE " + table + "id = '" + name + "'";
            String query3 = "SELECT * FROM " + table + " WHERE name = '" + name + "' and " + table + "id = '" + rollNo + "'";
            ResultSet temp = null;
            if (dbType.equalsIgnoreCase("local")) {
                if (ReadConfigFile.conf.useLocalDb.equalsIgnoreCase("true")) {
                    if (name.isEmpty()) {
                        temp = DatabaseMain.db.getResultFromLocalDb(query1);
                        if (temp.next() == false) {
                            return null;
                        }
                        return temp;
                    } else if (rollNo.isEmpty()) {
                        temp = DatabaseMain.db.getResultFromLocalDb(query2);
                        if (temp.next() == false) {
                            return null;
                        }
                        return temp;
                    } else if ((!name.isEmpty()) && (!rollNo.isEmpty())) {
                        if (table.equalsIgnoreCase("blacklistcurrent")) {
                            temp = DatabaseMain.db.getResultFromLocalDb(query1);
                        } else {
                            temp = DatabaseMain.db.getResultFromLocalDb(query3);
                        }
                        if (temp.next() == false) {
                            return null;
                        }
                        return temp;
                    }
                    return temp;
                }
                return temp;
            } else if (dbType.equalsIgnoreCase("master")) {
                if (ReadConfigFile.conf.useMasterDb.equalsIgnoreCase("true")) {
                    if (name.isEmpty()) {
                        temp = DatabaseMain.db.getResultFromMasterDb(query1);
                        if (temp.next() == false) {
                            return null;
                        }
                        return temp;
                    } else if (rollNo.isEmpty()) {
                        temp = DatabaseMain.db.getResultFromMasterDb(query2);
                        if (temp.next() == false) {
                            return null;
                        }
                        return temp;
                    } else if ((!name.isEmpty()) && (!rollNo.isEmpty())) {
                        if (table.equalsIgnoreCase("blacklistcurrent")) {
                            temp = DatabaseMain.db.getResultFromMasterDb(query1);
                        } else {
                            temp = DatabaseMain.db.getResultFromMasterDb(query3);
                        }
                        if (temp.next() == false) {
                            return null;
                        }
                        return temp;
                    }
                    return temp;
                }
                return temp;
            }
            return temp;
        } catch (SQLException ex) {
            if (Log.log.displayDialog == true) {
                DialogBox.dialog.warningDialog(ex.getMessage());
            } else {
                Log.log.writeErrorLog(ex.getMessage(), "AbstractPerson", "getResult");
            }
            return null;
        }
    }

    ResultSet returnResultSet(String table, String rollNo, String Name) {
        ResultSet temp;
        if (ReadConfigFile.conf.dbPriority.equalsIgnoreCase("masterDb")) {
            temp = getResult(table, "master", rollNo, Name);
            if (temp == null) {
                temp = getResult(table, "local", rollNo, Name);
                if (temp == null) {
                    return null;
                }
                return temp;
            }
            return temp;
        } else if (ReadConfigFile.conf.dbPriority.equalsIgnoreCase("localDb")) {
            temp = getResult(table, "local", rollNo, Name);
            if (temp == null) {
                temp = getResult(table, "master", rollNo, Name);
                if (temp == null) {
                    return null;
                }
                return temp;
            }
            return temp;
        }
        return null;
    }

    boolean checkifExist(String table, String rollNo, String Name) {

        if (returnResultSet(table, rollNo, Name) != null) {
            enteredroll = rollNo;
            return true;
        }
        return false;
    }

    ResultSet IfPersonExists(String ID, String name) {
        String query = null;
        if ((ID.isEmpty()) && (!name.isEmpty())) {
            return returnDuplicateName(name,"all");
        }
        else if ((!ID.isEmpty()) && (name.isEmpty())) {
            query = "SELECT * FROM student,guest,faculty WHERE (guest.guestid='" + ID + "') OR (student.studentid = '" + ID + "')  OR (faculty.facultyid = '" + ID + "')";
        } else if ((!name.isEmpty()) && (!ID.isEmpty())) {
             query = "select studentid as id,name,address,validupto from student where studentid = '"+ID+"' and name='"+name+"' union "
                    + " select guestid as id,name,address,validupto from guest where guestid = '"+ID+"' and name='"+name
                    + "' union"
                    + " select facultyid as id,name,address,validupto from faculty where facultyid = '"+ID+"' and name='"+name+"'";
        }
        return getRecordFromQuery(query);
    }

    public boolean checkDuplicateName(String name) {
        try {
            int total = 0;
            String query = "select count(name) as count from student where student.name='" + name + "' "
                    + "union select count(name) as count from guest where guest.name='" + name + "'"
                    + "union select count(name) as count from faculty where faculty.name ='" + name + "'";
            ResultSet rs = getRecordFromQuery(query);
            if (rs != null) {
                do {

                    total = total + rs.getInt("count");
                } while (rs.next());
            }
            if (total == 1) {
                return false;
            } else {
                return true;
            }
        } catch (Exception ae) {
            Log.log.writeErrorLog(ae.getMessage(), "AbstractPerson", "CheckDuplicateName");
            return false;
        }
    }

    public ResultSet returnDuplicateName(String name,String table) {
        String query = "";
        if(table.equalsIgnoreCase("student")){
        query = "select studentid as id,name,'Student' as userType,concat('Branch: ',branch,' Year: ',year)as other from student where name = '" + name + "'";
        }
        else if(table.equalsIgnoreCase("faculty")){
        query ="select facultyid as id,name,'Faculty' as userType,concat('Department: ',department,' Address: ',address)as other from faculty where name = '" + name + "'";
        }
        else if(table.equalsIgnoreCase("guest")){
        query ="select guestid as id ,name,'Guest' as userType,concat('Address: ',address,' Phone: ',phoneno)as other from guest where  name= '" + name + "'";
        }
        else if(table.equalsIgnoreCase("user")){
        query = "select loginid as id,name,'User' as userType,concat('Address: ',address,' Phone no: ',phoneno)as other from login where name = '" + name + "'";
        }
        else if(table.equalsIgnoreCase("blacklist")){
        query = "select loginid as id,name,'User' as userType,concat('Address: ',address,' Phone no: ',phoneno)as other from login"
                + " left join blacklistcurrent on blacklistcurrentid = loginid where name = '"+name+"' and blacklistcurrentid = loginid"
                + " union"
                + " select guestid as id ,name,'Guest' as userType,concat('Address: ',address,' Phone: ',phoneno)as other from guest"
                + " left join blacklistcurrent on blacklistcurrentid = guestid where name = '"+name+"' and blacklistcurrentid = guestid"
                + " union"
                + " select facultyid as id,name,'Faculty' as userType,concat('Department: ',department,' Address: ',address)as other from faculty"
                + " left join blacklistcurrent on blacklistcurrentid = facultyid where name = '"+name+"' and blacklistcurrentid = facultyid"
                + " union"
                + " select studentid as id,name,'Student' as userType,concat('Branch: ',branch,' Year: ',year)as other from student"
                + " left join blacklistcurrent on blacklistcurrentid = studentid where name = '"+name+"' and blacklistcurrentid = studentid"; 
                }
        else if(table.equalsIgnoreCase("checkinout")){
            query = "select loginid as id,name,'User' as userType,concat('Address: ',address,' Phone no: ',phoneno)as other from login"
                    + " left join checkincurrent on checkincurrentid = loginid where name = '"+name+"' and checkincurrentid = loginid"
                    + " union"
                    + " select guestid as id ,name,'Guest' as userType,concat('Address: ',address,' Phone: ',phoneno)as other from guest"
                    + " left join checkincurrent on checkincurrentid = guestid where name = '"+name+"' and checkincurrentid = guestid"
                    + " union"
                    + " select facultyid as id,name,'Faculty' as userType,concat('Department: ',department,' Address: ',address)as other from faculty"
                    + " left join checkincurrent on checkincurrentid = facultyid where name = '"+name+"' and checkincurrentid = facultyid"
                    + " union"
                    + " select studentid as id,name,'Student' as userType,concat('Branch: ',branch,' Year: ',year)as other from student"
                    + " left join checkincurrent on checkincurrentid = studentid where name = '"+name+"' and checkincurrentid = studentid"
                    + " union"
                    + " select loginid as id,name,'User' as userType,concat('Address: ',address,' Phone no: ',phoneno)as other from login "
                    + " left join checkinmain on checkinmainid = loginid where name = '"+name+"' and checkinmainid = loginid"
                    + " union"
                    + " select guestid as id ,name,'Guest' as userType,concat('Address: ',address,' Phone: ',phoneno)as other from guest"
                    + " left join checkinmain on checkinmainid = guestid where name = '"+name+"' and checkinmainid = guestid"
                    + " union"
                    + " select facultyid as id,name,'Faculty' as userType,concat('Department: ',department,' Address: ',address)as other from faculty"
                    + " left join checkinmain on checkinmainid = facultyid where name = '"+name+"' and checkinmainid = facultyid"
                    + " union"
                    + " select studentid as id,name,'Student' as userType,concat('Branch: ',branch,' Year: ',year)as other from student"
                    + " left join checkinmain on checkinmainid = studentid where name = '"+name+"' and checkinmainid = studentid";
        }
        else if(table.equalsIgnoreCase("blacklistdisplay")){
         query = "select loginid as id,name,'User' as userType,concat('Address: ',address,' Phone no: ',phoneno)as other from login"
                + " left join blacklistcurrent on blacklistcurrentid = loginid where name = '"+name+"' and blacklistcurrentid = loginid"
                + " union"
                + " select guestid as id ,name,'Guest' as userType,concat('Address: ',address,' Phone: ',phoneno)as other from guest"
                + " left join blacklistcurrent on blacklistcurrentid = guestid where name = '"+name+"' and blacklistcurrentid = guestid"
                + " union"
                + " select facultyid as id,name,'Faculty' as userType,concat('Department: ',department,' Address: ',address)as other from faculty"
                + " left join blacklistcurrent on blacklistcurrentid = facultyid where name = '"+name+"' and blacklistcurrentid = facultyid"
                + " union"
                + " select studentid as id,name,'Student' as userType,concat('Branch: ',branch,' Year: ',year)as other from student"
                + " left join blacklistcurrent on blacklistcurrentid = studentid where name = '"+name+"' and blacklistcurrentid = studentid"
                + " union"
                + " select loginid as id,name,'User' as userType,concat('Address: ',address,' Phone no: ',phoneno)as other from login"
                + " left join blacklistmain on blacklistmainid = loginid where name = '"+name+"' and blacklistmainid = loginid"
                + " union"
                + " select guestid as id ,name,'Guest' as userType,concat('Address: ',address,' Phone: ',phoneno)as other from guest"
                + " left join blacklistmain on blacklistmainid = guestid where name = '"+name+"' and blacklistmainid = guestid"
                + " union"
                + " select facultyid as id,name,'Faculty' as userType,concat('Department: ',department,' Address: ',address)as other from faculty"
                + " left join blacklistmain on blacklistmainid = facultyid where name = '"+name+"' and blacklistmainid = facultyid"
                + " union"
                + " select studentid as id,name,'Student' as userType,concat('Branch: ',branch,' Year: ',year)as other from student"
                + " left join blacklistmain on blacklistmainid = studentid where name = '"+name+"' and blacklistmainid = studentid";
                }
        else{
         query = "select studentid as id,name,'Student' as userType,concat('Branch: ',branch,' Year: ',year)as other from student where name = '" + name + "'"
                + " union select guestid as id ,name,'Guest' as userType,concat('Address: ',address,' Phone: ',phoneno)as other from guest where  name= '" + name + "'"
                + " union select facultyid as id,name,'Faculty' as userType,concat('Department: ',department,' Address: ',address)as other from faculty where name = '" + name + "'"
                + " union select loginid as id,name,'User' as userType,concat('Address: ',address,' Phone no: ',phoneno)as other from login where name = '" + name + "'";
        
        }
        return getRecordFromQuery(query);
    }

    String getName(String id) {
        try {
            String query = "select name as name from student where student.studentid = '" + id + "' union select name as name from guest where guest.guestid = '" + id + "' union select name as name from faculty where faculty.facultyid = '" + id + "' union select name as name from login where login.loginid = '" + id + "'";
            String tmpName = "N/A";
            ResultSet rs = getRecordFromQuery(query);
            if (rs != null) {
                    tmpName = rs.getString("name");
            }
            return tmpName;
        } catch (Exception ae) {
            return "N/A";
        }
    }

    ResultSet getAllRecord(String ID) {
        String query = "SELECT * FROM student,guest,faculty WHERE guest.guestid='" + ID + "' OR student.studentid = '" + ID + "' OR faculty.facultyid = '" + ID + "'";
        return getRecordFromQuery(query);
    }

    ResultSet getCurrenttableResult(String id) {
        String query = "SELECT * FROM checkincurrent WHERE checkincurrentid = '" + id + "'";
        return getRecordFromQuery(query);
    }

    ResultSet getCurrenttableResult() {
        String query = "SELECT * FROM checkincurrent";
        return getRecordFromQuery(query);
    }

    public boolean checkIn(String ID) {

        String checkintimestamp = TimeDate.time.timestampToFullDate(currentTimeStamp());
        if (DatabaseMain.db.executeQuery("INSERT INTO checkincurrent VALUES ('" + ID + "','" + checkintimestamp + "','" + generateSessionID() + "','" + Session.s1.sessionUser + "')")) {
            return true;
        } else {
            return false;
        }

    }

    private int generateSession() {
        int tempId = Utilities.util.rand();
        try {
            ResultSet rs = getRecordFromQuery("select max(sessionid) as sessionid from checkincurrent "
                    + "union select max(sessionid) as sessionid from checkinmain "
                    + "union select max(sessionid) as sessionid from lablogincurrent "
                    + "union select max(sessionid) as sessionid from labloginmain "
                    + "order by sessionid desc");
            if (rs != null) {
                tempId = Integer.parseInt(rs.getString("sessionid").substring(4)) + 1;
            } else {
                tempId = 1000;
            }
        } catch (Exception ae) {
            Log.log.writeErrorLog(ae.getMessage(), "User", "generateUserID");
        }
        return tempId;
    }

    public String generateSessionID() {
        return "CCN-" + generateSession();
    }

    public boolean checkOut(String id) {
        ResultSet rs;
        try {
            rs = getRecordFromQuery("SELECT * FROM  checkincurrent where checkincurrentid='" + id + "'");
            if (rs != null) {
                if (DatabaseMain.db.executeQuery("INSERT INTO checkinmain VALUES ('" + id + "','" + rs.getString("checkintimestamp") + "','" + TimeDate.time.timestampToFullDate(currentTimeStamp()) + "','" + Session.s1.sessionUser + "','" + rs.getString("sessionid") + "')")) {
                    if (DatabaseMain.db.executeQuery("DELETE FROM checkincurrent WHERE checkincurrentid='" + id + "'")) {
                        return true;
                    }
                }
            }
            return false;
        } catch (Exception e) {
            if (Log.log.displayDialog == true) {
                DialogBox.dialog.warningDialog(e.getMessage());
            } else {
                Log.log.writeErrorLog(e.getMessage(), "AbstractPerson", "checkOut");
            }
            return false;
        }
    }

    public int checkOutAll() {
        ResultSet rs;
        try {
            rs = getRecordFromQuery("SELECT * FROM  checkincurrent");
            if (rs != null) {
                do {
                    if (DatabaseMain.db.executeQuery("INSERT INTO checkinmain VALUES ('" + rs.getString("checkincurrentid") + "','" + rs.getString("checkintimestamp") + "','" + TimeDate.time.timestampToFullDate(currentTimeStamp()) + "','" + Session.s1.sessionUser + "','" + rs.getString("sessionid") + "')")) {
                        if (DatabaseMain.db.executeQuery("DELETE FROM checkincurrent WHERE checkincurrentid='" + rs.getString("checkincurrentid") + "'")) {
                          }
                        else return 0;
                    }
                    else return 0;
                } while (rs.next());
                return 1;
            }
            return 2;
        } catch (Exception e) {
            Log.log.writeErrorLog(e.getMessage(), "AbstractPerson", "checkOutAll");
            return 0;
        }
    }

    public boolean computerLogin(String ID, String computerid) {
        try{
        ResultSet rs = getRecordFromQuery("select sessionid from checkincurrent where checkincurrentid = '"+ ID +"'");
        if(rs!=null){
        String sessionid = rs.getString("sessionid");
        String checkintimestamp = TimeDate.time.timestampToFullDate(currentTimeStamp());
        if (DatabaseMain.db.executeQuery("INSERT INTO lablogincurrent VALUES ('" + ID + "','" + computerid + "','" + sessionid + "','" + checkintimestamp + "')")) {
            return true;
        } else {
            return false;
        }
        }
        return false;
        }
        catch(Exception ae){
         return false;   
        }
    }

    public boolean computerLogout(String id) {
        ResultSet rs;
        try {
            rs = getRecordFromQuery("SELECT * FROM  lablogincurrent where lablogincurrentid='" + id + "'");
            if (rs != null) {
                if (DatabaseMain.db.executeQuery("INSERT INTO labloginmain VALUES ('" + id + "','" + rs.getString("computerid") + "','" + rs.getString("sessionid") + "','" + rs.getString("logintime") + "','" + TimeDate.time.timestampToFullDate(currentTimeStamp()) + "')")) {
                    if (DatabaseMain.db.executeQuery("DELETE FROM lablogincurrent WHERE lablogincurrentid='" + id + "'")) {
                        return true;
                    }
                }
            }
            return false;
        } catch (Exception e) {
            if (Log.log.displayDialog == true) {
                DialogBox.dialog.warningDialog(e.getMessage());
            } else {
                Log.log.writeErrorLog(e.getMessage(), "AbstractPerson", "Computer logout");
            }
            return false;
        }
    }

    public int computerLogoutAll() {
        ResultSet rs;
        try {
            rs = getRecordFromQuery("SELECT * FROM  lablogincurrent");
            if (rs != null) {
                do {
                    if (DatabaseMain.db.executeQuery("INSERT INTO labloginmain VALUES ('" + rs.getString("lablogincurrentid") + "','" + rs.getString("computerid") + "','" + rs.getString("sessionid") + "','" + rs.getString("logintime") + "','" + TimeDate.time.timestampToFullDate(currentTimeStamp()) + "')")) {
                        if (DatabaseMain.db.executeQuery("DELETE FROM lablogincurrent WHERE lablogincurrentid='" + rs.getString("lablogincurrentid") + "'")) {
                            
                        }
                        else return 0;
                    }
                    else return 0;
                } while (rs.next());
                return 1;
            }
            return 2;
        } catch (Exception e) {
            Log.log.writeErrorLog(e.getMessage(), "AbstractPerson", "computerlogoutall");
            return 0;
        }
    }

    public boolean checkIfComputerLoggedIn(String Id) {
        try {
            int total = 0;
            String query = "select count(lablogincurrentid) as count from lablogincurrent where lablogincurrentid = '" + Id + "'";
            ResultSet rs = getRecordFromQuery(query);
            if (rs != null) {
                do {
                    total = total + rs.getInt("count");
                } while (rs.next());
            }
            if (total == 1) {
                return false;
            } else {
                return true;
            }
        } catch (SQLException ex) {
            Log.log.writeErrorLog(ex.getMessage(), "AbstractPerson", "checkIfComputerLoggedIn");
            return false;
        }
    }

    public boolean resetPassword(String id){
    
        return false;
    }
    public boolean blackRemoval(String id) {
        ResultSet temp;

        try {
            temp = getRecordFromQuery("SELECT * FROM blacklistcurrent WHERE blacklistcurrentid = '" + id + "'");
            if (temp != null) {
                if (DatabaseMain.db.executeQuery("INSERT INTO blacklistmain VALUES ('" + id + "','" + temp.getString("addedby") + "','" + temp.getString("reason") + "','" + temp.getString("bltimestamp") + "','" + TimeDate.time.timestampToFullDate(currentTimeStamp()) + "')")) {
                    if (Blacklist.blk.deleteBlacklist() == true) {
                        return true;
                    }
                }
                return false;
            }
            return false;
        } catch (Exception e) {
            if (Log.log.displayDialog == true) {
                DialogBox.dialog.warningDialog(e.getMessage());
            } else {
                Log.log.writeErrorLog(e.getMessage(), "AbstractPerson", "blackRemoval");
            }
            return false;
        }
    }

    int checkinValidate(String id, String name) {
        ResultSet rs;
        try {
            if (Validation.val.validateID(id) == true) {
                if (AbstractPerson.ab.getAllRecord(id) != null) {
                    if (AbstractPerson.ab.IfPersonExists(id, name) != null) {
                        if (!Blacklist.blk.ifBlacklistExists(id, "")) {
                            if (AbstractPerson.ab.getCurrenttableResult(id) == null) {
                                if (Student.std.ifStudentExists(id, name)) {
                                    rs = getRecordFromQuery("SELECT status FROM student WHERE studentid='" + id + "'");
                                    if (rs.getString("status").equalsIgnoreCase("true")) {
                                        if (AbstractPerson.ab.checkIn(id)) {
                                            return 1;
                                        }
                                    } else {
                                        return 5;
                                    }
                                } else if (Faculty.fct.ifFacultyExists(id, name)) {
                                    rs = getRecordFromQuery("SELECT status FROM faculty WHERE facultyid='" + id + "'");
                                    if (rs.getString("status").equalsIgnoreCase("true")) {
                                        if (AbstractPerson.ab.checkIn(id)) {
                                            return 2;
                                        }
                                    } else {
                                        return 5;
                                    }
                                } else if (Guest.gst.ifGuestExists(id, name)) {
                                    rs = getRecordFromQuery("SELECT status FROM guest WHERE guestid='" + id + "'");
                                    if (rs.getString("status").equalsIgnoreCase("true")) {
                                        if (AbstractPerson.ab.checkIn(id)) {
                                            return 3;
                                        }
                                    } else {
                                        return 5;
                                    }
                                }
                            } else {
                                return 6;
                            }

                        } else {

                            return 7;
                        }

                    } else {
                        return 8;
                    }
                } else {
                    return 9;
                }
            }
            return 10;
        } catch (Exception e) {
            if (Log.log.displayDialog == true) {
                DialogBox.dialog.warningDialog(e.getMessage());
            } else {
                Log.log.writeErrorLog(e.getMessage(), "AbstractPerson", "checkInValidate");
            }
            return 10;
        }
    }

    int checkoutValidate(String id, String name) {
        if (Validation.val.validateID(id) == true) {
            if (AbstractPerson.ab.getAllRecord(id) != null) {
                if (AbstractPerson.ab.IfPersonExists(id, name) != null) {
                    if ((AbstractPerson.ab.getCurrenttableResult(id) != null)) {
                        if (AbstractPerson.ab.checkOut(id)) {
                            if (Student.std.ifStudentExists(id, name)) {
                                return 1;
                            } else if (Faculty.fct.ifFacultyExists(id, name)) {
                                return 2;
                            } else if (Guest.gst.ifGuestExists(id, name)) {
                                return 3;
                            }
                        } else {
                            return 4;
                        }

                    } else {
                        return 5;
                    }

                } else {
                    return 6;
                }

            } else {
                return 7;
            }
        }
        return 8;

    }

    int searchValidate(String id) {
        if (Validation.val.validateID(id) == true) {
            if (AbstractPerson.ab.getAllRecord(id) != null) {
                if (Student.std.ifStudentExists(id, "")) {
                    return 1;
                } else if (Faculty.fct.ifFacultyExists(id, "")) {
                    return 2;
                } else if (Guest.gst.ifGuestExists(id, "")) {
                    return 3;
                } else {
                    return 4;
                }


            } else {
                return 5;
            }
        }
        return 6;
    }

    String todayStatistics(String type) {
        ResultSet rs1 = null;
        String addtime = "";
        int i, flag = 0, count = 0, j = 0;
        String current = TimeDate.time.timestampToFullDate(currentTimeStamp());

        try {
            if (type.equalsIgnoreCase("users")) {
                rs1 = getRecordFromQuery("(SELECT addtimestamp FROM student) UNION (SELECT addtimestamp FROM faculty) UNION (SELECT addtimestamp FROM guest)");
                if (rs1 != null) {
                    do {
                        flag = 0;
                        addtime = rs1.getString("addtimestamp");
                        for (i = 0; i < 10; i++) {
                            if (addtime.charAt(i) != current.charAt(i)) {
                                flag = 1;
                                break;
                            }
                        }
                        if (flag == 0) {
                            count++;
                        }
                    } while (rs1.next() == true);
                }
            } else if (type.equalsIgnoreCase("blacklist")) {
                rs1 = getRecordFromQuery("(SELECT bltimestamp FROM blacklistmain)UNION(SELECT bltimestamp FROM blacklistcurrent)");
                if (rs1 != null) {
                    do {
                        flag = 0;
                        addtime = rs1.getString("bltimestamp");
                        for (i = 0; i < 10; i++) {
                            if (addtime.charAt(i) != current.charAt(i)) {
                                flag = 1;
                                break;
                            }
                        }
                        if (flag == 0) {
                            count++;
                        }
                    } while (rs1.next() == true);
                }
            } else if (type.equalsIgnoreCase("checkin")) {

                rs1 = getRecordFromQuery("(SELECT checkintimestamp FROM checkincurrent) UNION(SELECT checkintimestamp FROM checkinmain)");
                if (rs1 != null) {
                    do {
                        flag = 0;
                        addtime = rs1.getString("checkintimestamp");

                        for (i = 0; i < addtime.length() - 8; i++) {
                            if ((addtime.charAt(i) != current.charAt(i))) {
                                flag = 1;
                                break;
                            }
                        }
                        if (flag == 0) {
                            count++;
                        }

                    } while (rs1.next() == true);
                }
            }
            return ((Integer) count).toString();
        } catch (Exception e) {
            if (Log.log.displayDialog == true) {
                DialogBox.dialog.warningDialog(e.getMessage());
            } else {
                Log.log.writeErrorLog(e.getMessage(), "AbstractPerson", "todayStatics");
            }
            return ((Integer) count).toString();
        }

    }

    void totalStatistics() {
        ResultSet rs1, rs2;
        String time;
        int i, countreg = 0, countblacklist = 0, countcheckin = 0;
        String current = TimeDate.time.timestampToFullDate(AbstractPerson.ab.currentTimeStamp());

        try {
            rs1 = getRecordFromQuery("(SELECT addtimestamp FROM student) UNION (SELECT addtimestamp FROM faculty) UNION (SELECT addtimestamp FROM guest)");
            while (rs1.next() == true) {
                countreg++;
            }

            rs2 = getRecordFromQuery("(SELECT bltimestamp FROM blacklistmain)UNION(SELECT bltimestamp FROM blacklistcurrent)");
            while (rs2.next() == true) {
                countblacklist++;

            }

            rs2 = getRecordFromQuery("(SELECT checkintimestamp FROM checkincurrent) UNION(SELECT checkintimestamp FROM checkinmain)");
            while (rs2.next() == true) {
                countcheckin++;

            }
            //System.out.println(countreg+" "+countblacklist+" "+countcheckin);

        } catch (Exception e) {
            if (Log.log.displayDialog == true) {
                DialogBox.dialog.warningDialog(e.getMessage());
            } else {
                Log.log.writeErrorLog(e.getMessage(), "AbstractPerson", "totalStatics");
            }
        }
    }

    void checkStatus() {
        ResultSet rs;
        String temp = "";
        String currenttime = TimeDate.time.timestampToFullDate(currentTimeStamp());
        for (int i = 0; i < 4; i++) {
            temp = temp + currenttime.charAt(i);
        }

        try {
            rs = getRecordFromQuery("SELECT validupto,studentid FROM student");
            if (rs != null) {
                do {
                    if (rs.getInt("validupto") < Integer.parseInt(temp)) {

                        DatabaseMain.db.executeQuery("UPDATE student SET status='false' WHERE studentid='" + rs.getString("studentid") + "'");
                    }
                } while (rs.next());
            }
            rs = getRecordFromQuery("SELECT validupto,facultyid FROM faculty");
            if (rs != null) {
                do {
                    if (rs.getInt("validupto") < Integer.parseInt(temp)) {
                        DatabaseMain.db.executeQuery("UPDATE faculty SET status='false' WHERE facultyid='" + rs.getString("facultyid") + "'");
                    }
                } while (rs.next());
            }

            rs = getRecordFromQuery("SELECT validupto,guestid FROM guest");
            if (rs != null) {
                do {
                    if (rs.getInt("validupto") < Integer.parseInt(temp)) {
                        id = rs.getString("guestid");
                        DatabaseMain.db.executeQuery("UPDATE guest SET status='false' WHERE guestid='" + id + "'");
                    }
                } while (rs.next());
            }
        } catch (Exception e) {
            if (Log.log.displayDialog == true) {
                DialogBox.dialog.warningDialog(e.getMessage());
            } else {
                Log.log.writeErrorLog(e.getMessage(), "AbstractPerson", "checkStatus");
            }
        }

    }

    void checkBlacklist() {
        ResultSet rs;
        long duration;
        String removaltimestamp;
        try {

            rs = getRecordFromQuery("SELECT * FROM blacklistcurrent");
            if (rs != null) {
                do {
                    duration = rs.getLong("duration");
                    if ((currentTimeStamp() - (TimeDate.time.fulldateToTimeStamp(rs.getString("bltimestamp")))) >= duration) {
                        removaltimestamp = TimeDate.time.timestampToFullDate(TimeDate.time.fulldateToTimeStamp(rs.getString("bltimestamp")) + duration);
                        DatabaseMain.db.executeQuery("INSERT INTO blacklistmain VALUES ('" + rs.getString("blacklistcurrentid") + "','" + rs.getString("addedby") + "','" + rs.getString("reason") + "','" + rs.getString("bltimestamp") + "','" + removaltimestamp + "')");
                        DatabaseMain.db.executeQuery("DELETE FROM blacklistcurrent WHERE blacklistcurrentid='" + rs.getString("blacklistcurrentid") + "'");
                    }
                } while (rs.next());
            }
        } catch (Exception e) {
            if (Log.log.displayDialog == true) {
                DialogBox.dialog.warningDialog(e.getMessage());
            } else {
                Log.log.writeErrorLog(e.getMessage(), "AbstractPerson", "checkBlackList");
            }
        }
    }

    public boolean saveImagetoFile(BufferedImage bi, String folder, String str) {
        try {
            String string = "img//" + folder + "//" + str + ".jpg";
            String fileType = string.substring(string.indexOf('.') + 1);

            ImageIO.write(bi, fileType, new File(string));
            return true;

        } catch (Exception e) {
            if (Log.log.displayDialog == true) {
                DialogBox.dialog.warningDialog(e.getMessage());
            } else {
                Log.log.writeErrorLog(e.getMessage(), "AbstractPerson", "saveImagetoFile");
            }
            return false;
        }
    }
}

/*
 * Guest class starts.... This class contains list of methods that manipulates
 * guest records
 */
class Guest extends AbstractPerson {

    static Guest gst = new Guest();
    String occupation, reference;

    Guest() {
    }

    boolean add(Connection con) throws SQLException, FileNotFoundException {
        String query = "INSERT INTO guest VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement psmnt = (PreparedStatement) con.prepareStatement(query);
        psmnt.setString(1, id);
        psmnt.setString(2, name);
        psmnt.setString(4, phone);
        psmnt.setString(3, address);
        psmnt.setString(5, reference);
        psmnt.setString(6, occupation);
        psmnt.setInt(7, validUpto);
        psmnt.setString(8, addedby);
        psmnt.setString(9, addtimestamp);
        psmnt.setString(10, "true");
        if (Guest.gst.image != null) {
            saveImagetoFile(Guest.gst.image, "Guest", Guest.gst.id);
            saveImagetoFile(Utilities.util.rescaleImage(Guest.gst.image, 173, 130), "Guest", "test");
            tempImage = new File("img//Guest//test.jpg");
        } else {
            tempImage = new File("src//icon//default.jpg");
        }

        psmnt.setBlob(11, new FileInputStream(tempImage), tempImage.length());

        if (Guest.gst.fingerprint != null) {
            saveImagetoFile(Utilities.util.rescaleImage(Guest.gst.fingerprint, 173, 130), "Guest", "test");
            tempFingerprint = new File("src//icon//default.jpg");
        } else {
            tempFingerprint = new File("src//icon//default.jpg");
        }
        psmnt.setBlob(12, new FileInputStream(tempFingerprint), tempFingerprint.length());
        psmnt.setString(13, Utilities.util.md5(password));
        if (psmnt.executeUpdate() > 0) {
            return true;
        } else {
            return false;
        }
    }

    boolean addGuest() {
        try {
            if (ReadConfigFile.conf.useLocalDb.equalsIgnoreCase("true")) {
                if (add(DatabaseMain.db.getLocalConnection()) == true) {
                    if (add(DatabaseMain.db.getMasterConnection()) == true) {
                        return true;
                    } else {
                        DialogBox.dialog.errorDialog("Error in adding to master database");
                        return false;
                    }
                } else {
                    DialogBox.dialog.errorDialog("Error in adding to Local database");
                    return false;
                }
            } else {
                if (add(DatabaseMain.db.getMasterConnection()) == true) {
                    return true;
                } else {
                    DialogBox.dialog.errorDialog("Error in adding to master database");
                    return false;
                }
            }
        } catch (Exception e) {
            DialogBox.dialog.warningDialog(e.getMessage());
            Log.log.writeErrorLog(e.getMessage(), "Guest", "addGuest");
            return false;
        }
    }

    boolean editGuest() {
        String temp = "", time;
        time = TimeDate.time.timestampToFullDate(currentTimeStamp());
        for (int i = 0; i < 4; i++) {
            temp = temp + time.charAt(i);
        }
        try {
            if (Guest.gst.validUpto > Integer.parseInt(temp)) {
                status = "true";
            } else {
                status = "false";
            }
            if (DatabaseMain.db.executeQuery("UPDATE guest SET  guestid='" + id + "',name='" + name + "',address='" + address + "',phoneno='" + phone + "',reference='" + reference + "',occupation='" + occupation + "',validupto='" + validUpto + "',status='" + status + "' WHERE guestid='" + enteredroll + "'") == true) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            DialogBox.dialog.warningDialog(e.getMessage());
            Log.log.writeErrorLog(e.getMessage(), "Guest", "editGuest");
            return false;
        }
    }

    boolean deleteGuest() {
        try {
            AbstractPerson.ab.blackRemoval(id);
            if (DatabaseMain.db.executeQuery("DELETE FROM guest WHERE guestid='" + id + "'")) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            if (Log.log.displayDialog == true) {
                DialogBox.dialog.warningDialog(e.getMessage());
            } else {
                Log.log.writeErrorLog(e.getMessage(), "Guest", "deleteGuest");
            }
            return false;
        }
    }

    boolean ifGuestExists(String rollNo, String Name) {
        return checkifExist("guest", rollNo, Name);
    }

    ResultSet getGuestInfo(String rollNo, String name) {
        return returnResultSet("guest", rollNo, name);
    }

    int generateGuestID() {
        int tempId = Utilities.util.rand();
        try {
            ResultSet rs = getRecordFromQuery("select guestid from guest order by guestid desc");
            if (rs != null) {
                tempId = Integer.parseInt(rs.getString("guestid").substring(4)) + 1;
            } else {
                tempId = 1000;
            }
        } catch (Exception ae) {
            Log.log.writeErrorLog(ae.getMessage(), "Guest", "generateGuestID");
        }
        return tempId;
    }

    boolean setGuestInfo(String rollNo, String Name) {
        ResultSet stdResult = Guest.gst.getGuestInfo(rollNo, Name);
        try {
            if (stdResult != null) {
                //DialogBox.dialog.warningDialog(stdResult.getString("name"));
                Guest.gst.id = stdResult.getString("guestid");
                Guest.gst.name = stdResult.getString("name");
                Guest.gst.phone = stdResult.getString("phoneno");
                Guest.gst.address = stdResult.getString("address");
                Guest.gst.reference = stdResult.getString("reference");
                Guest.gst.occupation = stdResult.getString("occupation");
                Guest.gst.validUpto = stdResult.getInt("validupto");
                Guest.gst.status = stdResult.getString("status");
                Guest.gst.addedby = stdResult.getString("addedby");
                Guest.gst.addtimestamp = stdResult.getString("addtimestamp");
                Guest.gst.password = stdResult.getString("password");
                InputStream is = stdResult.getBinaryStream("image");
                InputStream fingerprint = stdResult.getBinaryStream("fingerprint");
                try {
                    if (is != null) {
                        BufferedImage image = ImageIO.read(is);
                        Guest.gst.image = image;
                    } else {
                        File f = new File("src\\icon\\default.jpg");
                        BufferedImage im = ImageIO.read(f);
                        Guest.gst.fingerprint = im;
                        DialogBox.dialog.errorDialog("Photo of guest was null!\n Default image is used");
                    }

                } catch (IOException ex) {
                    if (Log.log.displayDialog == true) {
                        DialogBox.dialog.warningDialog(ex.getMessage());
                    } else {
                        Log.log.writeErrorLog(ex.getMessage(), "Guest", "setGuestInfo");
                    }
                }
                try {
                    if (fingerprint != null) {
                        BufferedImage fprint = ImageIO.read(fingerprint);
                        Guest.gst.fingerprint = fprint;
                    } else {
                        File f = new File("src\\icon\\default.jpg");
                        BufferedImage im = ImageIO.read(f);
                        Guest.gst.fingerprint = im;
                        DialogBox.dialog.errorDialog("fingerprint of guest was null!!\n Default image is used");
                    }
                } catch (IOException ex) {

                    if (Log.log.displayDialog == true) {
                        DialogBox.dialog.warningDialog(ex.getMessage());
                    } else {
                        Log.log.writeErrorLog(ex.getMessage(), "Guest", "setGuestInfo");
                    }
                }
                return true;
            }
            return false;
        } catch (SQLException ex) {
            if (Log.log.displayDialog == true) {
                DialogBox.dialog.warningDialog(ex.getMessage());
            } else {
                Log.log.writeErrorLog(ex.getMessage(), "Guest", "setGuestInfo");
            }
            return false;
        }

    }
}

/*
 * Faculty class beigins..... This class contains no of methods to manipulate
 * faculty data
 */
class Faculty extends AbstractPerson {

    static Faculty fct = new Faculty();
    String department, profile;

    Faculty() {
    }

    boolean add(Connection con) throws SQLException, FileNotFoundException {
        String query = "INSERT INTO faculty VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement psmnt = (PreparedStatement) con.prepareStatement(query);
        psmnt.setString(1, id);
        psmnt.setString(2, name);
        psmnt.setString(4, phone);
        psmnt.setString(3, address);
        psmnt.setString(5, department);
        psmnt.setString(6, profile);
        psmnt.setInt(7, validUpto);
        psmnt.setString(8, addedby);
        psmnt.setString(9, addtimestamp);
        psmnt.setString(10, "true");
        if (Faculty.fct.image != null) {
            saveImagetoFile(Faculty.fct.image, "Faculty", Faculty.fct.id);
            saveImagetoFile(Utilities.util.rescaleImage(Faculty.fct.image, 173, 130), "Faculty", "test");
            tempImage = new File("img//Faculty//test.jpg");
        } else {
            tempImage = new File("src//icon//default.jpg");
        }

        psmnt.setBlob(11, new FileInputStream(tempImage), tempImage.length());

        if (Faculty.fct.fingerprint != null) {
            saveImagetoFile(Utilities.util.rescaleImage(Faculty.fct.fingerprint, 173, 130), "Faculty", "test");
            tempFingerprint = new File("src//icon//default.jpg");
        } else {
            tempFingerprint = new File("src//icon//default.jpg");
        }
        psmnt.setBlob(12, new FileInputStream(tempFingerprint), tempFingerprint.length());
        psmnt.setString(13, Utilities.util.md5(password));
        if (psmnt.executeUpdate() > 0) {
            return true;
        } else {
            return false;
        }
    }

    boolean addFaculty() {
        try {
            if (ReadConfigFile.conf.useLocalDb.equalsIgnoreCase("true")) {
                if (add(DatabaseMain.db.getLocalConnection()) == true) {
                    if (add(DatabaseMain.db.getMasterConnection()) == true) {
                        return true;
                    } else {
                        DialogBox.dialog.errorDialog("Error in adding to master database");
                        return false;
                    }
                } else {
                    DialogBox.dialog.errorDialog("Error in adding to Local database");
                    return false;
                }
            } else {
                if (add(DatabaseMain.db.getMasterConnection()) == true) {
                    return true;
                } else {
                    DialogBox.dialog.errorDialog("Error in adding to master database");
                    return false;
                }
            }
        } catch (Exception e) {
            if (Log.log.displayDialog == true) {
                DialogBox.dialog.warningDialog(e.getMessage());
            } else {
                Log.log.writeErrorLog(e.getMessage(), "Faculty", "addFaculty");
            }
            return false;
        }
    }

    boolean editFaculty() {

        String temp = "", time;
        time = TimeDate.time.timestampToFullDate(currentTimeStamp());
        for (int i = 0; i < 4; i++) {
            temp = temp + time.charAt(i);
        }
        try {
            if (Faculty.fct.validUpto > Integer.parseInt(temp)) {
                status = "true";
            } else {
                status = "false";
            }
            if (DatabaseMain.db.executeQuery("UPDATE faculty SET  facultyid='" + id + "',name='" + name + "',address='" + address + "',phoneno='" + phone + "',department='" + department + "',post='" + profile + "',validupto='" + validUpto + "',status='" + status + "' WHERE facultyid='" + enteredroll + "'") == true) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            if (Log.log.displayDialog == true) {
                DialogBox.dialog.warningDialog(e.getMessage());
            } else {
                Log.log.writeErrorLog(e.getMessage(), "Faculty", "editFaculty");
            }
            return false;
        }
    }

    boolean deleteFaculty() {
        try {
            AbstractPerson.ab.blackRemoval(id);
            if (DatabaseMain.db.executeQuery("DELETE FROM faculty WHERE facultyid='" + id + "'")) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            if (Log.log.displayDialog == true) {
                DialogBox.dialog.warningDialog(e.getMessage());
            } else {
                Log.log.writeErrorLog(e.getMessage(), "Faculty", "deleteFaculty");
            }
            return false;
        }
    }

    boolean ifFacultyExists(String rollNo, String Name) {
        return checkifExist("faculty", rollNo, Name);
    }

    ResultSet getFacultyInfo(String rollNo, String name) {
        return returnResultSet("faculty", rollNo, name);
    }

    int generateFacultyID() {
        int tempId = Utilities.util.rand();
        try {
            ResultSet rs = getRecordFromQuery("select facultyid from faculty order by facultyid desc");
            if (rs != null) {
                tempId = Integer.parseInt(rs.getString("facultyid").substring(4)) + 1;

            } else {
                tempId = 1000;
            }
        } catch (Exception ae) {
            Log.log.writeErrorLog(ae.getMessage(), "Faculty", "generateFacultyID");
        }
        return tempId;
    }

    boolean setFacultyInfo(String rollNo, String Name) {
        ResultSet stdResult = Faculty.fct.getFacultyInfo(rollNo, Name);
        try {
            if (stdResult != null) {
                //DialogBox.dialog.warningDialog(stdResult.getString("name"));
                Faculty.fct.id = stdResult.getString("facultyid");
                Faculty.fct.name = stdResult.getString("name");
                Faculty.fct.phone = stdResult.getString("phoneno");
                Faculty.fct.address = stdResult.getString("address");
                Faculty.fct.department = stdResult.getString("department");
                Faculty.fct.profile = stdResult.getString("post");
                Faculty.fct.validUpto = stdResult.getInt("validupto");
                Faculty.fct.status = stdResult.getString("status");
                Faculty.fct.addedby = stdResult.getString("addedby");
                Faculty.fct.addtimestamp = stdResult.getString("addtimestamp");
                Faculty.fct.password = stdResult.getString("password");
                InputStream is = stdResult.getBinaryStream("image");
                InputStream fingerprint = stdResult.getBinaryStream("fingerprint");
                try {
                    if (is != null) {
                        BufferedImage image = ImageIO.read(is);
                        Faculty.fct.image = image;
                    } else {
                        File f = new File("src\\icon\\default.jpg");
                        BufferedImage im = ImageIO.read(f);
                        Faculty.fct.fingerprint = im;
                        DialogBox.dialog.errorDialog("Photo of faculty was null!\n Default image is used");
                    }

                } catch (IOException ex) {

                    if (Log.log.displayDialog == true) {
                        DialogBox.dialog.warningDialog(ex.getMessage());
                    } else {
                        Log.log.writeErrorLog(ex.getMessage(), "Faculty", "setFacultyInfo");
                    }
                }
                try {
                    if (fingerprint != null) {
                        BufferedImage fprint = ImageIO.read(fingerprint);
                        Faculty.fct.fingerprint = fprint;
                    } else {
                        File f = new File("src\\icon\\default.jpg");
                        BufferedImage im = ImageIO.read(f);
                        Faculty.fct.fingerprint = im;
                        DialogBox.dialog.errorDialog("fingerprint of faculty was null!!\n Default image is used");
                    }
                } catch (IOException ex) {
                    if (Log.log.displayDialog == true) {
                        DialogBox.dialog.warningDialog(ex.getMessage());
                    } else {
                        Log.log.writeErrorLog(ex.getMessage(), "Faculty", "setFacultyInfo");
                    }
                }
                return true;
            }
            return false;
        } catch (SQLException ex) {
            if (Log.log.displayDialog == true) {
                DialogBox.dialog.warningDialog(ex.getMessage());
            } else {
                Log.log.writeErrorLog(ex.getMessage(), "Faculty", "setFacultyInfo");
            }
            return false;
        }

    }
}
/*
 * Functions to manupulating current table.
 */
/*
 * public void getTime(){ return(new Date().getTime()); } Timestamp t1 =new
 * Timestamp(new Date().getTime()); //t1 = currentTimeStamp(); return t1; }
 */

class Blacklist extends AbstractPerson {

    static Blacklist blk = new Blacklist();
    public String addedby, reason, durationtype, blktimestamp;
    ;
    public long duration;

    Blacklist() {
    }

    boolean add(Connection con) throws SQLException, FileNotFoundException {
        String query = "INSERT INTO blacklistcurrent VALUES(?,?,?,?,?,?)";
        PreparedStatement psmnt = (PreparedStatement) con.prepareStatement(query);
        psmnt.setString(1, id);
        psmnt.setLong(2, duration);
        psmnt.setString(3, addedby);
        psmnt.setString(4, reason);
        psmnt.setString(5, blktimestamp);
        psmnt.setString(6, durationtype);
        if (psmnt.executeUpdate() > 0) {
            return true;
        } else {
            return false;
        }
    }

    boolean addBlacklist() {
        try {
            if (ReadConfigFile.conf.useLocalDb.equalsIgnoreCase("true")) {
                if (add(DatabaseMain.db.getLocalConnection()) == true) {
                    if (add(DatabaseMain.db.getMasterConnection()) == true) {
                        return true;
                    } else {
                        DialogBox.dialog.errorDialog("Error in adding to master database");
                        return false;
                    }
                } else {
                    DialogBox.dialog.errorDialog("Error in adding to Local database");
                    return false;
                }
            } else {
                if (add(DatabaseMain.db.getMasterConnection()) == true) {
                    return true;
                } else {
                    DialogBox.dialog.errorDialog("Error in adding to master database");
                    return false;
                }
            }
        } catch (Exception e) {
            if (Log.log.displayDialog == true) {
                DialogBox.dialog.warningDialog(e.getMessage());
            } else {
                Log.log.writeErrorLog(e.getMessage(), "Blacklist", "addBlackList");
            }

            return false;
        }
    }

    boolean editBlacklist() {
        try {
            if (DatabaseMain.db.executeQuery("UPDATE blacklistcurrent SET  blacklistcurrentid='" + id + "',duration='" + duration + "',addedby='" + addedby + "',reason='" + reason + "',bltimestamp='" + blktimestamp + "',durationtype='" + durationtype + "' WHERE blacklistcurrentid='" + enteredroll + "'") == true) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            if (Log.log.displayDialog == true) {
                DialogBox.dialog.warningDialog(e.getMessage());
            } else {
                Log.log.writeErrorLog(e.getMessage(), "Blacklist", "editBlackList");
            }
            return false;
        }
    }

    boolean deleteBlacklist() {
        try {

            if (DatabaseMain.db.executeQuery("DELETE FROM blacklistcurrent WHERE blacklistcurrentid='" + id + "'")) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            if (Log.log.displayDialog == true) {
                DialogBox.dialog.warningDialog(e.getMessage());
            } else {
                Log.log.writeErrorLog(e.getMessage(), "Blacklist", "deleteBlackList");
            }
            return false;
        }
    }

    boolean ifBlacklistExists(String rollNo, String Name) {
        return checkifExist("blacklistcurrent", rollNo, Name);
    }

    ResultSet getBlacklistInfo(String rollNo, String name) {
        return returnResultSet("blacklistcurrent", rollNo, name);
    }

    boolean setBlacklistInfo(String rollNo, String Name) {
        ResultSet stdResult = Blacklist.blk.getBlacklistInfo(rollNo, Name);
        try {
            if (stdResult != null) {
                //DialogBox.dialog.warningDialog(stdResult.getString("name"));
                Blacklist.blk.id = stdResult.getString("blacklistcurrentid");
                Blacklist.blk.duration = stdResult.getLong("duration");
                Blacklist.blk.addedby = stdResult.getString("addedby");
                Blacklist.blk.reason = stdResult.getString("reason");
                Blacklist.blk.blktimestamp = stdResult.getString("bltimestamp");
                Blacklist.blk.durationtype = stdResult.getString("durationtype");
                return true;
            }
            return false;

        } catch (SQLException ex) {
            if (Log.log.displayDialog == true) {
                DialogBox.dialog.warningDialog(ex.getMessage());
            } else {
                Log.log.writeErrorLog(ex.getMessage(), "Blacklist", "setBlackListInfo");
            }
            return false;
        }

    }
}

class User extends AbstractPerson {

    public String password;
    public String usrType;
    public String status = "true";
    public String lastlogin;
    public String message = "Welcome to Apely Distributed Authentication Systems";
    public String backupcode = id;
    static User usr = new User();
    int attempts;

    User() {
    }

    boolean addUser() {
        try {

            if (DatabaseMain.db.executeQuery("INSERT INTO login VALUES ('" + id + "','" + name + "','" + Utilities.util.md5(password) + "','" + usrType + "','" + address + "','" + phone + "','" + status + "'," + '1' + ",'" + backupcode + "','0')") == true) {
                return true;
            }
            return false;
        } catch (Exception e) {
            if (Log.log.displayDialog == true) {
                DialogBox.dialog.warningDialog(e.getMessage());
            } else {
                Log.log.writeErrorLog(e.getMessage(), "User", "addUser");
            }
            return false;
        }
    }

    boolean editUser() {
        try {
            if (DatabaseMain.db.executeQuery("UPDATE login SET  loginid='" + id + "',name='" + name + "',password='" + Utilities.util.md5(password) + "',usertype='" + usrType + "',phoneno='" + phone + "',address='" + address  +  "' WHERE loginid='" + enteredroll + "'") == true) {

                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            if (Log.log.displayDialog == true) {
                DialogBox.dialog.warningDialog(e.getMessage());
            } else {
                Log.log.writeErrorLog(e.getMessage(), "User", "editUser");
            }
            return false;
        }
    }

    boolean deleteUser() {
        try {
            if (DatabaseMain.db.executeQuery("DELETE FROM login WHERE loginid='" + id + "'")) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            if (Log.log.displayDialog == true) {
                DialogBox.dialog.warningDialog(e.getMessage());
            } else {
                Log.log.writeErrorLog(e.getMessage(), "User", "deleteUser");
            }
            return false;
        }
    }

    boolean ifUserExists(String id, String Name) {
        if (getUserInfo(id, Name) == null) {
            return false;
        } else {
            enteredroll = id;
            return true;
        }
    }

    /*
     * boolean ifAlreadyExists(String roll,String name) { ResultSet
     * temp=Student.std.getStudentInfo(roll, name); if(temp==null) return false;
     * else return true; }
     */
    ResultSet getUserInfo(String rollNo, String name) {
        return returnResultSet("login", rollNo, name);
    }

    int generateUserID() {
        int tempId = Utilities.util.rand();
        try {
            ResultSet rs = getRecordFromQuery("select loginid from login order by loginid desc");
            if (rs != null) {
                tempId = Integer.parseInt(rs.getString("loginid").substring(4)) + 1;
            } else {
                tempId = 1000;
            }
        } catch (Exception ae) {
            Log.log.writeErrorLog(ae.getMessage(), "User", "generateUserID");
        }
        return tempId;
    }

    boolean setUserInfo(String rollNo, String name) {

        try {
            ResultSet usrResult = User.usr.getUserInfo(rollNo, name);
            if (usrResult != null) {
                User.usr.id = usrResult.getString("loginid");
                User.usr.name = usrResult.getString("name");
                User.usr.password = usrResult.getString("password");
                User.usr.usrType = usrResult.getString("usertype");
                User.usr.phone = usrResult.getString("phoneno");
                User.usr.address = usrResult.getString("address");
                User.usr.status = usrResult.getString("status");
                User.usr.lastlogin = usrResult.getString("lastlogin");
                User.usr.backupcode = usrResult.getString("backupcode");
//                User.usr.message = usrResult.getString("message");
                User.usr.attempts = usrResult.getInt("noofattempt");
                return true;
            }
            return false;

        } catch (SQLException ex) {
            if (Log.log.displayDialog == true) {
                DialogBox.dialog.warningDialog(ex.getMessage());
            } else {
                Log.log.writeErrorLog(ex.getMessage(), "User", "setUserInfo");
            }
            return false;
        }
    }

    void checkAttempt(String userID) {
        try {
            int no = returnAttempt(userID);
            if (no >=3 ) {
                int nod = no + 1;
                DatabaseMain.db.executeQuery("UPDATE login SET noofattempt='" + nod + "',password='" + Utilities.util.md5(userID) + "' WHERE loginid='" + userID + "'");
                DatabaseMain.db.executeQuery("INSERT INTO message VALUES('" + userID + "','There have been more then 5 unauthorized login attempts in your account. please reset your password!!!!')");
            } else {
                int nod = no + 1;
                DatabaseMain.db.executeQuery("UPDATE login SET noofattempt='" + nod + "' WHERE loginid='" + userID + "'");
            }
        } catch (Exception ae) {
            Log.log.writeErrorLog(ae.getMessage(), "Authenticate1", "checkAttempt");
        }
    }

    void resetNoOfAttempt() {
        DatabaseMain.db.executeQuery("UPDATE login SET noofattempt='0' WHERE loginid='" + Session.s1.userID + "'");
    }

    int returnAttempt(String userID) {

        try {
            String query = "SELECT noofattempt FROM login WHERE loginid ='" + userID + "'";
            ResultSet rs = AbstractPerson.ab.getRecordFromQuery(query);
            if (rs != null) {

                int noOfAttempt = rs.getInt("noofattempt");
                return noOfAttempt;
            } else {
               // System.out.println("inside return attemp");
                return 0;
            }

        } catch (Exception ae) {
            Log.log.writeErrorLog(ae.getMessage(), "Authenticate1", "checkAttempt");
            return 0;
        }
    }

    String checkMessage() {
        //ResultSet stdResult = AbstractPerson.ab.getRecordFromQuery("SELECT message from login where loginid ='" + Session.s1.userID + "'");
        ResultSet msgResult = AbstractPerson.ab.getRecordFromQuery("SELECT message from message where messageid ='" + Session.s1.userID + "'");
        try {

            if (msgResult != null) {

                //System.out.println(tempMsg);
                String message = "";
                do {
                    String tempMsg = msgResult.getString("message");
                    message = tempMsg + "\n";
                } while (msgResult.next());
                return message;
            } else {
                return null;
            }
        } catch (SQLException ex) {
            Log.log.writeErrorLog(ex.getMessage(), "User", "check message");
            return null;
        }
    }

    boolean setSessionID(String username, String userType) {
        try {
            String query = "SELECT loginid FROM login WHERE name ='" + username + "' AND usertype='" + userType + "'";
            ResultSet rs = AbstractPerson.ab.getRecordFromQuery(query);
            if (rs != null) {
                Session.s1.userID = rs.getString("loginid");
                return true;
            }
            return false;
        } catch (Exception ae) {
            Log.log.writeErrorLog(ae.getMessage(), "Authenticate1", "checkAttempt");
            return false;
        }
    }
}
