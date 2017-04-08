/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;
import javax.swing.JOptionPane;
/**
 *
 * @author Achyut
 */
public class DialogBox {
    static DialogBox dialog = new DialogBox();
    int errorCode;
    DialogBox(String message,String Type, int code){
        errorCode=code;
                    
        JOptionPane msgBox = new JOptionPane();
                    
                JOptionPane.showMessageDialog(null,Type+":  "+ code + ": "+ message);
    
        
    }
    DialogBox(String msg){
            JOptionPane.showMessageDialog(null,"Error:   "+ msg);
        }
    DialogBox(){
       // JOptionPane.showMessageDialog(null, "Unknown dialog error!!!");
    }
    void warningDialog(String message){
        JOptionPane.showMessageDialog(null, message);
    }
    void validationDialog(String message){
        JOptionPane.showMessageDialog(null, message);
    }
    void errorDialog(String message){
        JOptionPane.showMessageDialog(null, message);
    }
    void successDialog(String message){
        JOptionPane.showMessageDialog(null,message);
    }
    int confirmDialog(String message){
        return JOptionPane.showConfirmDialog(null, message);
    }
    String getStringDialog(String message){
        return JOptionPane.showInputDialog(message);
    }
}