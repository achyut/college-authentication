/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 *
 * @author Achyut
 */
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Vector;
import javax.imageio.ImageIO;
import javax.media.*;
import javax.media.control.FrameGrabbingControl;
import javax.media.format.VideoFormat;
import javax.media.format.YUVFormat;
import javax.media.util.BufferToImage;

/**
 *
 * @author BUDDHIMA
 */
public class Webcam{

    static Webcam cam = new Webcam();
    private CaptureDeviceInfo device;
    private MediaLocator ml;
    private Player player;
    private Component videoScreen;
    private BufferedImage bi;
    private Image img;
    
    Webcam() {
    }

    boolean isLoaded(){
        if(videoScreen != null)
            return true;
        return false;
    }
    
    Component getVideo() {
        if(videoScreen == null){
                try {
                    //gets a list of devices how support the given videoformat
                    Vector deviceList = CaptureDeviceManager.getDeviceList(new YUVFormat());
                    //device = CaptureDeviceManager.getDevice("vfw:Microsoft WDM Image Capture (Win32):0");
                    //gets the first device in deviceList
                    device = (CaptureDeviceInfo) deviceList.firstElement();
                    //System.out.println(device.getName());
                    ml = device.getLocator();
                    player = Manager.createRealizedPlayer(ml);
                    player.start();
                    videoScreen = player.getVisualComponent();

                    /*
                    * Frame frm = new Frame();
                    *
                    * frm.setBounds(10, 10, 119, 111);//sets the size of the screen
                    *
                    * // setting close operation to the frame
                    *
                    * frm.addWindowListener(new WindowAdapter() {
                    *
                    * public void windowClosing(WindowEvent we) { System.exit(0); } });
                    *
                    * //place player and video screen on the frame
                    * //frm.add(videoScreen, BorderLayout.CENTER); JButton j = new
                    * JButton("capture"); frm.add(j);
                    * //frm.add(player.getControlPanelComponent(), BorderLayout.SOUTH);
                    * frm.setVisible(true);
                    */
                } catch (Exception e) {
                    Log.log.writeErrorLog(e.getMessage(), "Webcam", "getVideo");
                }
                
        }
        return videoScreen;
    }

    public void captureImage() {
        try {

            
            //capture image
            //Thread.sleep(10000);//wait 10 seconds before capturing photo

            FrameGrabbingControl fgc = (FrameGrabbingControl) player.getControl("javax.media.control.FrameGrabbingControl");
            Buffer buf = fgc.grabFrame();//grab the current frame on video screen
            BufferToImage btoi = new BufferToImage((VideoFormat) buf.getFormat());
            img = btoi.createImage(buf);
            int w = img.getWidth(null);
            int h = img.getHeight(null);
            bi = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
            Graphics2D g2 = bi.createGraphics();
            g2.drawImage(img, 0, 0, null);
            g2.dispose();
            //saveImagetoFile(img, "../img/MyPhoto.jpg");//save the captured image as MyPhoto.jpg
            //saveImagetoFile("sdsf");
        } catch (Exception e) {
            Log.log.writeErrorLog(e.getMessage(), "Webcam", "captureImage");
        }
    }

    void stopCam() {
        player.stop();
    }

    void startCam() {
        player.start();
    }
    Player getPlayer(){
        return player;
    }
    BufferedImage getBufferedImage() {
        return bi;
    }

    public boolean saveImagetoFile(BufferedImage bi, String folder, String str) {
        try {
            String string = "img//" + folder + "//" + str + ".jpg";
            String fileType = string.substring(string.indexOf('.') + 1);

            ImageIO.write(bi, fileType, new File(string));
            return true;

        } catch (Exception e) {
            Log.log.writeErrorLog("Error in writing image " + e.getMessage(), "Webcam", "captureImage");
            return false;
        }
    }

    public void saveImagetoFile(String str) {
        try {
            String string = "img//" + str + ".jpg";
            String fileType = string.substring(string.indexOf('.') + 1);

            ImageIO.write(bi, fileType, new File(string));

        } catch (Exception e) {
        }
    }

    public void closeCam() {
        player.close();
        player.deallocate();
        videoScreen = null;
    }

    public BufferedImage rescaleImage(BufferedImage source, int width, int height) {
        BufferedImage bi = resizeImage(width, height);
        Graphics2D g2d = bi.createGraphics();
        double xScale = (double) width / source.getWidth();
        double yScale = (double) height / source.getHeight();
        AffineTransform at = AffineTransform.getScaleInstance(xScale, yScale);
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
}
