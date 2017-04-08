/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

/**
 *
 * @author Achyut
 */
public class Utilities {
  static Utilities util = new Utilities();
  
  public BufferedImage rescaleImage(BufferedImage source,int width,int height) {
  BufferedImage bi = resizeImage(width, height);
  Graphics2D g2d = bi.createGraphics();
  double xScale = (double) width / source.getWidth();
  double yScale = (double) height / source.getHeight();
  AffineTransform at = AffineTransform.getScaleInstance(xScale,yScale);
  g2d.drawRenderedImage(source, at);
  g2d.dispose();
  return bi;
}

private BufferedImage resizeImage(int w, int h) {
  GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
  GraphicsDevice gd = ge.getDefaultScreenDevice();
  GraphicsConfiguration gc = gd.getDefaultConfiguration();
  BufferedImage image = gc.createCompatibleImage(w, h);
  return image;
}

public String md5(String key) {
        byte[] defaultBytes = key.getBytes();
        try {
            MessageDigest algorithm = MessageDigest.getInstance("MD5");
            algorithm.reset();
            algorithm.update(defaultBytes);
            byte messageDigest[] = algorithm.digest();

            StringBuilder hexString = new StringBuilder();
            for (int i = 0; i < messageDigest.length; i++) {
                hexString.append(Integer.toHexString(0xFF & messageDigest[i]));
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException nsae) {
           Log.log.writeErrorLog(nsae.getMessage(), "Utilities", "md5");
            return null;
        }

    }
    public String rand(String str){
    int num = rand();
    String random = str + "-" + num;
    return random;
    }
    public int rand(){
    Random rand = new Random();
    int num = rand.nextInt(999999);
    return num;
    }
    
public void writeDataInFile(File fileName,String data,boolean message){
      try {FileOutputStream out = new FileOutputStream(fileName,true);
            String line = data + System.getProperty("line.separator");
            out.write(line.getBytes());
            out.close();
            if(message)
            {
                DialogBox.dialog.successDialog(" Successfully written in "+fileName.getName());
            }
            
        } catch (IOException ae) {
            Log.log.writeErrorLog(ae.getMessage(), "TimeDate", "writeDataInFile");
        }
      }
}
