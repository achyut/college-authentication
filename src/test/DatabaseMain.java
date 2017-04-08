/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.sql.*;
//import java.security.MessageDigest;

/**
 *
 * @author Achyut
 */
public class DatabaseMain {

    //static DatabaseMain db = new DatabaseMain("localhost", 3306, "Mysql", "", "ccn", "root", "");
    static DatabaseMain db = new DatabaseMain();
    //MessageDigest algorithm = MessageDigest.getInstance("MD5");
    //private String ipAdd, dbType, dbName, userName, passWord, url, connectionString;
    //private int portNo;
    private String url;
    private Connection masterConn = null;
    private Connection localConn = null;
    private boolean isMasterConnected = false,isLocalConnected = false;
    DatabaseMain() {
        ReadConfigFile.conf.getValuesFromFile();
    }

    void createConnection() {
        if (ReadConfigFile.conf.useMasterDb.isEmpty() || ReadConfigFile.conf.useLocalDb.isEmpty()) {
            DialogBox.dialog.errorDialog("Incorrect Configuration file..");
            System.exit(0);
        } else {
            if (ReadConfigFile.conf.useMasterDb.equalsIgnoreCase("false") && ReadConfigFile.conf.useLocalDb.equalsIgnoreCase("false")) {
                DialogBox.dialog.warningDialog("Both master and Local Database are disabled.. Unable to connect");
                System.exit(0);
            } else if (ReadConfigFile.conf.useMasterDb.equalsIgnoreCase("false")) {
                DialogBox.dialog.warningDialog("Master Database disabled.. Unable to connect");
                System.exit(0);
            } else {
                if (ReadConfigFile.conf.useMasterDb.equalsIgnoreCase("true") && ReadConfigFile.conf.useLocalDb.equalsIgnoreCase("false")) {
                    masterConn = connectDb(ReadConfigFile.conf.masterDbIp, Integer.parseInt(ReadConfigFile.conf.masterDbPort), ReadConfigFile.conf.masterDbType, ReadConfigFile.conf.masterConnStr, ReadConfigFile.conf.masterDbName, ReadConfigFile.conf.masterUsername, ReadConfigFile.conf.masterPassword, ReadConfigFile.conf.useMasterSSL);
                    if (masterConn == null) {
                        DialogBox.dialog.errorDialog("Unable to connect to Master Database that you had selected!!! \n Please Check your settings");
                        System.exit(0);
                    }
                    isMasterConnected = true;
                    System.out.println("master connection established and local connection disabled");
                } else if (ReadConfigFile.conf.useMasterDb.equalsIgnoreCase("true") && ReadConfigFile.conf.useLocalDb.equalsIgnoreCase("true")) {
                    masterConn = connectDb(ReadConfigFile.conf.masterDbIp, Integer.parseInt(ReadConfigFile.conf.masterDbPort), ReadConfigFile.conf.masterDbType, ReadConfigFile.conf.masterConnStr, ReadConfigFile.conf.masterDbName, ReadConfigFile.conf.masterUsername, ReadConfigFile.conf.masterPassword, ReadConfigFile.conf.useMasterSSL);
                    localConn = connectDb(ReadConfigFile.conf.localDbIp, Integer.parseInt(ReadConfigFile.conf.localDbPort), ReadConfigFile.conf.localDbType, ReadConfigFile.conf.localConnStr, ReadConfigFile.conf.localDbName, ReadConfigFile.conf.localUsername, ReadConfigFile.conf.localPassword, ReadConfigFile.conf.useLocalSSL);
                    if ((masterConn == null) && (localConn == null)) {
                        DialogBox.dialog.errorDialog("Unable to connect to Both Master and Local Database that your had Selected!!! \n Please Check your settings");
                        System.exit(0);
                    } else if ((masterConn == null) && (localConn != null)) {
                        isLocalConnected = true;
                        DialogBox.dialog.errorDialog("Unable to connect to Master Database that your had Selected!!! \n Please Check your settings");
                        System.exit(0);
                    } else if ((localConn == null) && (masterConn != null)) {
                        isMasterConnected = true;
                        int option = DialogBox.dialog.confirmDialog("Unable to connect to Local Database But Master Database connection is established!! \n Do you want to enable only Master connection??");
                        if (option == 0) {
                            changeLocalToMasterInConfig();
                            System.exit(0);
                        } 
                    else if ((masterConn != null) && (localConn != null)) {
                        isMasterConnected = true;
                        isLocalConnected = true;
                        DialogBox.dialog.errorDialog("Unable to connect to Master Database that your had Selected!!! \n Please Check your settings");
                        System.exit(0);
                    } else {
                            System.exit(0);
                        }
                    }
                }
            }
        }
    }

    void changeLocalToMasterInConfig() {
        System.out.println("Master database enabled");
        //chage the value of use local to false
        DialogBox.dialog.warningDialog("Configuration Settings changed!!!\n Restart the software to run it properly!!");
    }

    /*
     * When we create an object of the database then we should give the
     * following values as the parameter in the followin sequence
     *
     * IpAddress As string port no As integer databasetype as string
     * connectionstring as string database name as string database username as
     * string database password as string
     *
     */
    DatabaseMain(String _ipAddress, int _portNo, String _dbType, String _connectionString, String _dbName, String _userName, String _passKey) {


        try {
        } catch (Exception ae) {
            Log.log.writeErrorLog("Error in database variable initialization " + ae.getMessage(), "DatabaseMain", "DatabaseMain");
        }

    }

    /*
     * This method is used to check whether any if the string that are passed as
     * the parameter is null or not. total 5 strings should be used as the
     * parameters
     */
    static boolean checkNullString(String par1, int par2, String par3, String par4, String par5, String par6) {

        if (par1.equalsIgnoreCase(null) || (Integer) par2 == null || par6.equalsIgnoreCase(null) || par3.equalsIgnoreCase(null) || par4.equalsIgnoreCase(null) || par5.equalsIgnoreCase(null)) {
            return true;
        } else {
            return false;
        }
    }

    /*
     * This is a private method and is used to connect to the database using the
     * values that are taken from the constructor
     *
     */
    private Connection connectDb(String ipAdd, int portNo, String dbType, String connectionString, String dbName, String userName, String passWord, boolean useSSL) {
        try {
            Connection conn = null;
            if (checkNullString(ipAdd, portNo, dbType, dbName, userName, passWord) == true) {
                System.out.println("Invalid database information");
                return null;
            } else {
                if (useSSL == true) {
                    if (dbType.equalsIgnoreCase("mysql")) {
                          Class.forName("com.mysql.jdbc.Driver").newInstance();
                          url = "jdbc:mysql://" + ipAdd + ":" + portNo + "/"+dbName + "?verifyServerCertificate=false"+ "&useSSL=true"+ "&requireSSL=true";
                          conn = DriverManager.getConnection(url,userName, passWord);
                          //System.out.println("SSL not found !!!");
                        return conn;
                    } else if (dbType.equalsIgnoreCase("oracle")) {
                        /*
                         * Class.forName("oracle.jdbc.driver.OracleDriver"); url
                         * = "jdbc:oracle:" + connectionString + ":@" + ipAdd +
                         * ":" + portNo + ":" + dbName; // conn =
                         * DriverManager.getConnection(url, userName, passWord);
                         * conn =
                         * DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
                         * "system", "sylvania");
                         */
                        System.out.println("SSL not found !!!");
                        return conn;
                    } else if (dbType.equalsIgnoreCase("mssql")) {
                       String connectionUrl ="jdbc:sqlserver://"+ipAdd+":"+portNo+";" + "databaseName="+dbName+";integratedSecurity=true;" + "encrypt=true;trustServerCertificate=false";
                        return null;
                    }
                } else if (useSSL == false) {
                    if (dbType.equalsIgnoreCase("mysql")) {
                        Class.forName("com.mysql.jdbc.Driver").newInstance();
                        url = "jdbc:mysql://" + ipAdd + ":" + portNo + "/" + dbName;
                        conn = DriverManager.getConnection(url, userName, passWord);
                        //System.out.println("Database connection established");
                        return conn;
                    } else if (dbType.equalsIgnoreCase("oracle")) {
                        Class.forName("oracle.jdbc.driver.OracleDriver");
                        // url = "jdbc:oracle:" + connectionString + ":@" + ipAdd + ":" + portNo + ":" + dbName;
                        //            conn = DriverManager.getConnection(url, userName, passWord);
                        conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "sylvania");
                        return conn;
                    } else if (dbType.equalsIgnoreCase("mssql")) {
                         Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver");
                        url = "jdbc:microsoft:sqlserver://" + ipAdd + ":" + portNo + "/" + dbName;
                        conn = DriverManager.getConnection(url, userName, passWord);
                        DialogBox dl = new DialogBox();
                        dl.warningDialog("mssql configuration not found");
                        return null;
                    }
                }
                return null;
            }
        } catch (Exception e) {
            Log.log.writeErrorLog(e.getMessage(), "DatabaseMain", "connectDb");
            return null;
        }

    }

    public Connection getLocalConnection() {
        return localConn;
    }

    public Connection getConnection() {
        if (localConn == null) {
            return masterConn;
        } else if (masterConn == null) {
            return localConn;
        } else if (localConn != null && masterConn != null) {
            return masterConn;
        } else {
            return null;
        }
    }

    public Connection getMasterConnection() {
        return masterConn;
    }

    public boolean testDatabaseConnectivity() {
        if (ReadConfigFile.conf.useLocalDb.equalsIgnoreCase("true")) {
            if ((testLocalConnection() == true) && testMasterConnection() == true) {
                return true;
            }
        } else if (ReadConfigFile.conf.useLocalDb.equalsIgnoreCase("false")) {
            if (testMasterConnection() == true) {
                return true;
            }
        }
        return false;
    }
    /*
     * This method is used to check the current status of the database if
     * database is opened then the connection will be true else false
     */

    public boolean testMasterConnection() {
        if (connectDb(ReadConfigFile.conf.masterDbIp, Integer.parseInt(ReadConfigFile.conf.masterDbPort), ReadConfigFile.conf.masterDbType, ReadConfigFile.conf.masterConnStr, ReadConfigFile.conf.masterDbName, ReadConfigFile.conf.masterUsername, ReadConfigFile.conf.masterPassword, ReadConfigFile.conf.useMasterSSL) != null) {
            isMasterConnected = true;
            return true;
        }
        return false;
    }

    public boolean testLocalConnection() {
        if (connectDb(ReadConfigFile.conf.localDbIp, Integer.parseInt(ReadConfigFile.conf.localDbPort), ReadConfigFile.conf.localDbType, ReadConfigFile.conf.localConnStr, ReadConfigFile.conf.localDbName, ReadConfigFile.conf.localUsername, ReadConfigFile.conf.localPassword, ReadConfigFile.conf.useLocalSSL) != null) {
            isLocalConnected = true;
            return true;
        }
        return false;
    }

    /*
     * This is a public method and is used to execute a query in the database
     * which is connected by db_connect() method
     */
    public boolean executeQuery(String _query) {

        try {


            if ((testDatabaseConnectivity()) == false) {
                DialogBox.dialog.warningDialog("Both Master and Local Database are offline.. Unable to Execute query");
                //DialogBox.dialog.warningDialog("Both master and Local Database are disabled.. Unable to connect");
                return false;
            } else {
                if (ReadConfigFile.conf.useMasterDb.equalsIgnoreCase("true") && ReadConfigFile.conf.useLocalDb.equalsIgnoreCase("false")) {
                    if (testMasterConnection() == true) {
                        PreparedStatement stmt = masterConn.prepareStatement(_query);
                        stmt.executeUpdate();
                        stmt.close();
                        return true;
                    }
                } else if (ReadConfigFile.conf.useMasterDb.equalsIgnoreCase("true") && ReadConfigFile.conf.useLocalDb.equalsIgnoreCase("true")) {
                    if (testDatabaseConnectivity() == true) {
                        PreparedStatement stmt = masterConn.prepareStatement(_query);
                        stmt.executeUpdate();
                        stmt.close();
                        PreparedStatement stmt1 = localConn.prepareStatement(_query);
                        stmt1.executeUpdate();
                        stmt1.close();
                        return true;
                    }
                }
            }
            return false;
            //Statement stmt = conn.createStatement();
        } catch (SQLException ae) {
            Log.log.writeErrorLog("Error in quert execution: " + ae.getMessage(), "DatabaseMain", "executeQuery");
            return false;
        }
    }
    /*
     * This method is used to return the result values of the given query inside
     * the database The values are returned as the result set
     */

    public ResultSet getResultFromMasterDb(String _query) {
        try {
            if (ReadConfigFile.conf.useMasterDb.equalsIgnoreCase("true")) {
                if ((testMasterConnection() == true) && (masterConn != null)) {
                    System.out.println("Result using master connection");
                    ResultSet rs = null;
                    PreparedStatement stmt;
                    stmt = masterConn.prepareStatement(_query);
                    rs = stmt.executeQuery();
                    return rs;
                } else {
                    return null;
                }
            } else {
                //DialogBox.dialog.errorDialog("Trying to use Master Connection but master database is not initialized..");
                return null;
            }
            //Statement stmt = conn.createStatement();
        } catch (SQLException ae) {
            Log.log.writeErrorLog("Error in query execution: " + ae.getMessage(), "DatabaseMain", "getResultFromMasterDb");
            return null;
        }
    }

    public ResultSet getResultFromLocalDb(String _query) {
        try {
            if (ReadConfigFile.conf.useLocalDb.equalsIgnoreCase("true")) {
                if ((testLocalConnection() == true) && (localConn != null)) {
                    System.out.println("Result using local connection");
                    ResultSet rs = null;
                    PreparedStatement stmt;
                    stmt = localConn.prepareStatement(_query);
                    rs = stmt.executeQuery();
                    return rs;
                } else {
                    return null;
                }
            } else {
                //DialogBox.dialog.errorDialog("Trying to use Local Connection but Local database is not initialized..");
                return null;
            }
            //Statement stmt = conn.createStatement();
        } catch (SQLException ae) {
            Log.log.writeErrorLog("Error in query execution in local Db " + ae.getMessage(), "DatabaseMain", "getResultFromLocalDb");
            return null;
        }
    }

    /*
     * This method is used to check username and password only from the login
     * table of the database This method is called when the user has logged in
     * as the user type as student and has an account in the database
     */
    boolean checkUsernameAndPassword(String usrName, String pass) {
        boolean value = false;
        //code to fetch data from database and check;
        try {
            String query = "Select name as id,password from login UNION select studentid as id,password from student UNION select facultyid as id,password from faculty UNION select guestid as id,password from guest";
            ResultSet rs = AbstractPerson.ab.getRecordFromQuery(query);
            if (rs != null) {
                do {

                    String tempUser = rs.getString("id");
                    String tempPass = rs.getString("password");
                    if (tempUser.equalsIgnoreCase(usrName) && tempPass.equalsIgnoreCase(Utilities.util.md5(pass))) {
                        value = true;
                        break;
                    }
                    value = false;
                } while (rs.next());
            }
            return value;
        } catch (SQLException ex) {
            Log.log.writeErrorLog(ex.getMessage(), "DatabaseMain", "checkUsernamePassword");
            return false;
            //d1.warningDialog(database.class.getName());
            //Logger.getLogger(database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /*
     * This method checks the username password and usertype and returns a
     * booolean value The method returns true when username ,password and
     * usertype is being matched The username and passsword is case sensative
     */
    boolean authenticateUser(String usrName, String pass, String usrType) {
        boolean value = false;
        try {
            //ResultSet rs = getResult("select count(*)  from login where username='"+usrName+"' and password='"+pass+"'");
            String query = "SELECT backupcode,name,password,usertype,loginid FROM login";
            ResultSet rs = AbstractPerson.ab.getRecordFromQuery(query);
            if (rs != null) {
            do {
                String tempUser = rs.getString("name");
                String tempPass = rs.getString("password");
                String tempuserType = rs.getString("usertype");
                String loginID = rs.getString("loginid");
                String backupcode = rs.getString("backupcode");
//                System.out.println(Utilities.util.md5(backupcode)+" "+tempPass);
                //System.out.println(tempUser+tempPass+tempuserType);
                if(tempPass.equalsIgnoreCase(Utilities.util.md5(backupcode))){   
                    //String bck = rs.getString("backupcode");
                 if (tempUser.equalsIgnoreCase(usrName) && tempPass.equalsIgnoreCase(Utilities.util.md5(pass)) && tempuserType.equalsIgnoreCase(usrType)) {
                    Session.s1.userID = loginID;
                    value = true;
                    break;
                }
                value = false;
                }
                else{
                if (tempUser.equalsIgnoreCase(usrName) && tempPass.equals(Utilities.util.md5(pass)) && tempuserType.equalsIgnoreCase(usrType)) {
                    Session.s1.userID = loginID;
                    value = true;
                    break;
                }
                value = false;
                }
            }
            while (rs.next());
          return value;
            }
            
            return value;
        } catch (SQLException ex) {
            Log.log.writeErrorLog(ex.getMessage(), "DatabaseMain", "authenticateUser");
            return false;
        }
    }

    private void increaseAttempt(String userID, int attempt) {
        DatabaseMain.db.executeQuery("UPDATE login SET noofattempt='" + attempt + "' WHERE loginid='" + userID + "'");
    }

    /*
     * This method is used to close the database connection
     */
    void database_close() {
        try {
            if (isMasterConnected == true) {
                masterConn.close();
                System.out.println("Master Database connection closed");
            }
            if (isLocalConnected == true) {
                localConn.close();
                System.out.println("Local Database connection closed");
            }
        } catch (SQLException ex) {
            Log.log.writeErrorLog(ex.getMessage(), "DatabaseMain", "database_close");
        }
    }
}
