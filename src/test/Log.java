/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Achyut
 */
public class Log {
    public boolean displayDialog = true;
    private String message;
    private File accessLogFile = new File("log\\access.log");
    private File errorLogFile = new File("log\\error.log"); 
    static public Log log = new Log();
      private void writeError(String error,String className,String functionName) {
      try {
          FileOutputStream out = new FileOutputStream(errorLogFile,true);
            String line = TimeDate.time.timestampToTime(TimeDate.time.currentTimeStamp())+"|"+TimeDate.time.timestampToFullDate(TimeDate.time.currentTimeStamp())+"|"+Session.s1.getSessionID()+"|"+Session.s1.sessionUser+"| Error in class: "+className+" inside function: "+functionName+" Details: "+ error + System.getProperty("line.separator");
            out.write(line.getBytes());
            out.close();
        } catch (IOException ae) {
            DialogBox.dialog.warningDialog(ae.getMessage());
        }
    }
    public void writeErrorLog(String error,String className,String functionName) {
    if (displayDialog == true) {
                DialogBox.dialog.warningDialog(error);
            } else {
                Log.log.writeError(error,className, functionName);
            }
    }
    public File getAccessFile(){

        return accessLogFile;
    }
    
    public File getErrorFile(){

        return errorLogFile;
    }
    public void writeAccessLog(String access) {
        try {
            FileOutputStream out = new FileOutputStream(accessLogFile,true);
            String line = TimeDate.time.timestampToTime(TimeDate.time.currentTimeStamp())+"|"+TimeDate.time.timestampToFullDate(TimeDate.time.currentTimeStamp())+"|"+Session.s1.getSessionID()+"|"+Session.s1.sessionUser+"| Message: "+access + System.getProperty("line.separator");
            out.write(line.getBytes());
            out.close();
        } catch (IOException ae) {
            DialogBox dl = new DialogBox();
            dl.warningDialog(ae.getMessage());
        }
    }
}
