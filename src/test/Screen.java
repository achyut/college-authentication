/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author Achyut
 */
public class Screen {
    static Screen scr = new Screen();
    private int screenHeight;
    private int screenWidth;

    Screen() {
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension screenSize = tk.getScreenSize();
        screenHeight = screenSize.height;
        //System.out.println(screenHeight);
        screenWidth = screenSize.width;
        //System.out.println(screenWidth);
    }

    public int getScreenHeight() {
        return screenHeight;
    }

    public int getScreenWidth() {
        return screenWidth;
    }
    public static final String date = "yyyy-MM-dd HH:mm:ss";

  public static String CurrentDateAndTime() {
  Calendar calendar = Calendar.getInstance();
  SimpleDateFormat dateFormat = new SimpleDateFormat(date);
  return dateFormat.format(calendar.getTime());
}

}