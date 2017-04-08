/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author Achyut
 */
public class FirstTimeCheck {

    private boolean firstTime = true;
    File configFile = new File("config.conf");
    File logDirectory = new File("log");
    File imgDirectory = new File("img");
    File facultyImgDirectory = new File("img//Faculty");
    File studentImgDirectory = new File("img//Student");
    File guestImgDirectory = new File("img//Guest");
    File userImgDirectory = new File("img//User");

    FirstTimeCheck() {
    }

    public boolean isFirstRun() //Search for initialization file, if not found assumes that it is
    {                           // the first time that program is being executed and will create 
        //Initialization File
        if (checkInitialConfig() == true) {
            firstTime = false;
        } else {
            firstTime = true;
        }
        return firstTime;
    }

    boolean checkInitialConfig(){
        if(CheckLog() == true){
            if(CheckImageFolders() == true){
                if(CheckConfigFile() == true)
                    return true;
            }
        }
        
        return false;
            }

    void createInitialConfig() throws IOException {
        createLog();
        createImageFolders();
        createConfigFile();
            
    }

    boolean CheckLog() {
        try {
            if ((CheckLogFolder() && CheckAccessLogFile() && CheckErrorLogFile()) == true) {
                return true;
            } else {
                return false;
            }
            //CheckErrorLogFile();
        } catch (IOException ae) {
            DialogBox.dialog.warningDialog(ae.getMessage());
            return false;
        }
    }

    boolean CheckLogFolder() {
        if ((logDirectory.exists() && logDirectory.isDirectory()) == true) {
            return true;
        } else {
            return false;
        }

    }

    boolean CheckImageFolders() {

        if (imgDirectory.exists() && imgDirectory.isDirectory() && studentImgDirectory.exists() && studentImgDirectory.isDirectory() && facultyImgDirectory.exists() && facultyImgDirectory.isDirectory() && guestImgDirectory.exists() && guestImgDirectory.isDirectory() && userImgDirectory.exists() && userImgDirectory.isDirectory()) {
            return true;
        } else {
            return false;

        }
    }

    boolean createImageFolders() {
        if ((imgDirectory.exists() && studentImgDirectory.exists() && facultyImgDirectory.exists() && guestImgDirectory.exists() && userImgDirectory.exists()) == false) {
            if ((imgDirectory.mkdir() && studentImgDirectory.mkdir() && facultyImgDirectory.mkdir() && guestImgDirectory.mkdir() && userImgDirectory.mkdir()) == true) {
                DialogBox.dialog.errorDialog("Image Folders Created!!!");
                return true;
            }
        }
        if(imgDirectory.exists())
        {
            boolean value = false;
            if(!studentImgDirectory.exists()){
                DialogBox.dialog.errorDialog("Student Image directory not found!!!!");
                if(studentImgDirectory.mkdir() == true)
                {
                    DialogBox.dialog.successDialog("New Student Image directory Created!!!!");
                    value = true;
                }
                else 
                    value = false;
            }
            if(!facultyImgDirectory.exists()){
                DialogBox.dialog.errorDialog("Faculty Image directory not found!!!!");
                if(facultyImgDirectory.mkdir() == true)
                {
                    DialogBox.dialog.successDialog("New Faculty Image directory Created!!!!");
                    value = true;
                }
                 else
                    value = false;
            }
            if(!guestImgDirectory.exists()){
                DialogBox.dialog.errorDialog("Guest Image directory not found!!!!");
                if(guestImgDirectory.mkdir() == true)
                {
                    DialogBox.dialog.successDialog("New Guest Image directory Created!!!!");
                    value = true;
                }
                else
                    value = false;
            }
            if(!userImgDirectory.exists()){
                DialogBox.dialog.errorDialog("User Image directory not found!!!!");
                if(userImgDirectory.mkdir() == true)
                {
                    DialogBox.dialog.successDialog("New User Image directory Created!!!!");
                    value = true;
                }
                else
                    value = false;
            }
            return value;
        }
        else {
            return false;
        }
    }

    boolean createLog() throws IOException {
        if (CreateLogFolder() && CheckAccessLogFile() && CheckErrorLogFile()) {
            DialogBox.dialog.errorDialog("Log files created!!!");
            return true;
        } else {
            return false;
        }
    }

    boolean CreateLogFolder() {
        if (logDirectory.mkdir()) {
            DialogBox.dialog.errorDialog("Log folder created!!!");
            return true;
        } else {
            return false;
        }
    }

    boolean CheckAccessLogFile() throws IOException {
        File AccessFile = new File("./log/access.log");
        if (AccessFile.exists() && AccessFile.isFile()) {
            return true;
            //       readingConfigFile(configFile);            
        } else {

            //    log.append("[-]Configuration file !NOT! Found.\n"); 
            if (AccessFile.createNewFile() == true) {
                return true;
            } else {
                return false;
            }

        }
    }

    boolean CheckErrorLogFile() throws IOException {
        File AccessFile = new File("./log/error.log");
        if (AccessFile.exists() && AccessFile.isFile()) {
            return true;
            //       readingConfigFile(configFile);            
        } else {

            //    log.append("[-]Configuration file !NOT! Found.\n"); 
            if (AccessFile.createNewFile() == true) {
                return true;
            } else {
                return false;
            }

        }
    }

    boolean CheckConfigFile() {
        if (configFile.exists() && configFile.isFile()) {

            return true;
        } else {
            return false;
        }
    }

    boolean createConfigFile() throws IOException {
        if (configFile.createNewFile() == true) {
       String message  ="#########################################################################################################################"+ System.getProperty("line.separator")
                     + "# Welcome to APELY Distributed Authentication Systems.                                                                   #" + System.getProperty("line.separator")
                     + "# This software is developed by : Achyut Paudel and Lovely Gupta                                                         #" + System.getProperty("line.separator")
                     + "# This software is being developed for Centre of Computing and Networking, National Institute of Technology, Kurukshetra #" + System.getProperty("line.separator")
                     + "##########################################################################################################################" + System.getProperty("line.separator");

            Utilities.util.writeDataInFile(configFile, message, false);
            Init1 in1 = new Init1();
            in1.setVisible(true);
            return true;
        } else {
            return false;
        }
    }
}
