/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

/**
 *
 * @author Achyut
 * 
 */

public class ClockTime extends Thread{   
    String time = null;
    JLabel timeLabel = new JLabel();
    public String getDate(){
        Thread thd = new Thread(){
        public void run(){
            while(true){
                try {
                    repaint();
                    sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(ClockTime.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
    }
    };
        return time;
    }
    
    void repaint(){
        TimeDate tmd = new TimeDate();
        timeLabel.setText(tmd.timestampToFullDate(System.currentTimeMillis()));
    }
}