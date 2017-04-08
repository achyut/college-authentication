/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;
import java.lang.Runnable;
import javax.swing.*;
import java.awt.*;
import java.util.*;
/**
 *
 * @author APELY
 */
         
    class Clock extends JFrame implements Runnable
{
  Thread runner; //declare global objects
  Font clockFont;
     public Clock()
     {
         System.out.print(Thread.currentThread());
        runner = new Thread(this,"new");
        runner.start();                                         //start thread running
        clockFont = new Font("Serif", Font.BOLD, 20);    //create font instance      
       ClockPanel timeDisplay = new ClockPanel();
      this.add(timeDisplay);                    //add components
         System.out.print(runner.getName());
     }
     
     class ClockPanel extends JPanel
     {
      public void paintComponent(Graphics painter )
        {
       
          painter.setFont(clockFont);                   //create clock components
          painter.setColor(Color.black);
          painter.drawString( timeNow(), 60, 40);
        }
     }
     
     //get current time
     public String timeNow()
     {
       Calendar now = Calendar.getInstance();
       int hrs = now.get(Calendar.HOUR_OF_DAY);
       int min = now.get(Calendar.MINUTE);
       int sec = now.get(Calendar.SECOND);
       
       String time = zero(hrs)+":"+zero(min)+":"+zero(sec);
       
       return time;
     }
    
     public String zero(int num)
     {
       String number=( num < 10) ? ("0"+num) : (""+num);
       return number;                                    //Add leading zero if needed
       
     }
          
    
     public void run()
     {
       while (true  )
       {
        repaint();
                                                         //define thread task
           try
             {
               Thread.sleep(1000);
             }
              catch(InterruptedException e)
                  {
                    System.out.println("Thread failed");
                  }                 
       }
     }
     void stop(){
         try{
              System.out.print(runner.getName());
             System.out.print(Thread.currentThread());
         Thread.sleep(10000);
         }
         catch(Exception e){}
     }
    }