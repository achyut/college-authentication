/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.io.*;
import java.util.Properties;

/**
 *
 * @author Achyut
 */
public class ReadConfigFile {

    static ReadConfigFile conf = new ReadConfigFile();
    String useMasterDb;
    String useLocalDb;
    String dbPriority;
    boolean useMasterSSL;
    boolean useLocalSSL;
    String masterDbType;
    String masterDbIp;
    String masterDbPort;
    String masterDbName;
    String masterConnStr;
    String masterUsername;
    String masterPassword;
    String localDbType;
    String localDbIp;
    String localDbPort;
    String localDbName;
    String localConnStr;
    String localUsername;
    String localPassword;
    String rootUsername;
    String rootPassword;
    String defaultWebcam;
    String defaultFingerprint;
    String defaultLookAndFeel;
    //URL ConfigFile = getClass().getResource("config.conf");
    Properties configFile = new Properties();
    private File configurationFile = new File("./config.conf");

    ReadConfigFile() {
        try {
            configFile.load(new FileInputStream(configurationFile));
            //my_value = configFile.getProperty(“my_key");
        } catch (IOException ex) {
            // Logger.getLogger(ReadConfigFile.class.getName()).log(Level.SEVERE, null, ex);
            Log.log.writeErrorLog("Error!!!! Configuration File cannot be read.."+ex.getMessage(), "ReadConfigFile", "ReadConfigFile");
        }

    }

    public void getValuesFromFile() {

        useMasterDb = getValue("useMasterDb",false);
        useLocalDb = getValue("useLocalDb",false);
        dbPriority = getValue("dbPriority",false);

        String masterSSL = getValue("useMasterSSL",false);
        String localSSL = getValue("useLocalSSL",false);
        if (masterSSL.equalsIgnoreCase("true")) {
            useMasterSSL = true;
        } else {
            useMasterSSL = false;
        }
        if (localSSL.equalsIgnoreCase("true")) {
            useLocalSSL = true;
        } else {
            useLocalSSL = false;
        }
        masterDbType = getValue("masterDbType",false);
        masterDbIp = getValue("masterDbIp",false);
        masterDbPort = getValue("masterDbPort",false);
        masterDbName = getValue("masterDbName",false);
        masterConnStr = getValue("masterConnStr",false);
        masterUsername = getValue("masterUsername",false);
        masterPassword = getValue("masterPassword",false);

        localDbType = getValue("localDbType",false);
        localDbIp = getValue("localDbIp",false);
        localDbPort = getValue("localDbPort",false);
        localDbName = getValue("localDbName",false);
        localConnStr = getValue("localConnStr",false);
        localUsername = getValue("localUsername",false);
        localPassword = getValue("localPassword",false);

        //rootUsername;
        //rootPassword;

        defaultWebcam = getValue("defaultWebcam",false);
        defaultFingerprint = getValue("defaultFingerprint",false);
        defaultLookAndFeel = getValue("defaultLookAndFeel",false);
    }

    public void writeConfig(String key, String value) throws IOException {
        try {
            FileOutputStream out = new FileOutputStream(configurationFile, true);
            String line = key + "=" + value + System.getProperty("line.separator");
            out.write(line.getBytes());
            out.close();
            //        DialogBox.dialog.successDialog(key + value +"Sucessfully written in Configuration File.");
        } catch (IOException ae) {
            throw ae;
        }
    }

    String getValue(String key, boolean askValue) {
        try {
            String value = configFile.getProperty(key);
            if (value == null) {
                if(askValue == true){
                int opt = DialogBox.dialog.confirmDialog("Key Value not found!!!" + key + " do you want to add a new key value???");
                if (opt == 0) {
                    String val = DialogBox.dialog.getStringDialog("Enter the value for " + key + " :");
                    String line = key + "=" + val;
                    Utilities.util.writeDataInFile(configurationFile, line, true);
                    //writeConfig(key,val);
                    value = val;
                }
                }
            }
            return value;
        } catch (Exception ae) {
            Log.log.writeErrorLog(ae.getMessage(), "ReadConfigFile", "getValue");
            return null;
        }

    }

    void setValue(String field, String key) {
        try {
            configFile.setProperty(field, key);
        } catch (Exception ae) {
           Log.log.writeErrorLog(ae.getMessage(), "ReadConfigFile", "setValue");
        }

    }

    public void setKeyValue(String field, String key) //Starts reading Configuration file and finds shared path from it.
    {
        try {

            BufferedReader in = new BufferedReader(new FileReader(configurationFile));
            BufferedWriter out = new BufferedWriter(new FileWriter(configurationFile));
            String str, value;
            int index;
            while ((str = in.readLine()) != null) {
                //out.newLine();
                if (str.startsWith(field)) {
                    index = str.indexOf("=");
                    value = str.substring(index + 1);

                    //    out.append(key, index+1, key.length());
                } else {
                    writeConfig(field, key);
                }
                out.append(str);
            }
            in.close();
            out.close();
        } catch (FileNotFoundException ex) {
            Log.log.writeErrorLog(ex.getMessage(), "ReadConfigFile", "setKeyValue");
        } catch (IOException e) {
            Log.log.writeErrorLog(e.getMessage(), "ReadConfigFile", "setKeyValue");
        }
    }

    public boolean validateConfigurationFile() {
        getValuesFromFile();
        if (useMasterDb.equalsIgnoreCase("false") || useMasterDb.isEmpty()) {
            DialogBox.dialog.errorDialog("Master Database not set in Config File!!!");
            return false;
        } 
        if (useMasterDb.equalsIgnoreCase("true")) {
                 if ((masterDbType.isEmpty() == false) && (masterDbIp.isEmpty() == false) && (masterDbPort.isEmpty() == false) && (masterDbName.isEmpty() == false) && (masterUsername.isEmpty()== false)) {
                    return true;
                }
                DialogBox.dialog.errorDialog("Master Database settings are Empty in Config File!!!");
                return false;
            }
        if (useLocalDb.equalsIgnoreCase("true")) {
                
                 if (dbPriority.equalsIgnoreCase("masterDb") || dbPriority.equalsIgnoreCase("localDb")) {
                    if ((localDbType.isEmpty() == false) && (localDbIp.isEmpty() == false) && (localDbPort.isEmpty() == false) && (localDbName.isEmpty() == false) && (localUsername.isEmpty()== false)) {
                        return true;
                    }
                    else{
                        DialogBox.dialog.errorDialog("Local Database settings are Empty in Config File!!!");
                        return false; 
                    }
                }
                DialogBox.dialog.errorDialog("Invalid database priority in config file!!!");
                return false;
            }
        return false;
        }
    }

