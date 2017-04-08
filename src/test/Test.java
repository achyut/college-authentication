package test;


/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
/**
 *
 * @author Achyut
 */
public class Test {
//import javax.swing.plaf.synth.SynthLookAndFeel;
//import javax.swing.plaf.multi.MultiLookAndFeel;
//import javax.swing.plaf.metal.MetalTheme;
//import javax.swing.plaf.nimbus.NimbusLookAndFeel;

    /**
     * @param args the command line arguments
     */
    //13827000
    public static void main(String[] args) {
        try {
            //BlackListCurrentReport r = new BlackListCurrentReport();
            //r.setVisible(true);
            //NewJFrame n = new NewJFrame();
            //n.setVisible(true);
            //abc j = new abc();
            //j.setSize(500,600);
            //j.setVisible(true);
                       // image1 img=new image1();
            //  UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
            //WebcamTest w = new WebcamTest();
            //w.setVisible(true);
            // System.out.println(md5("achyut"));
            //ReadConfigFile r = new ReadConfigFile();
            //String str = r.getValue("dbName");
            //System.out.println(str);
            //System.out.println(Utilities.util.md5("tuyhca"));
            //System.out.println(str);
            // encypted en = new encypted();
            //en.getcon();  
            //Init2 in = new Init2();
            //in.setVisible(true);
            //Log.log.writeErrorLog("hey dude", "classname", "funchtiia");
            
            FirstTimeCheck firstTime = new FirstTimeCheck();
            if (((firstTime.CheckLog()==false) && (firstTime.CheckImageFolders()==false) && (firstTime.CheckConfigFile()) == false)) {
                DialogBox.dialog.successDialog("Software is running for the first time \n Welcome To Apely Authentication Systems..");
                firstTime.createInitialConfig();
            }
            else if (firstTime.CheckLog() == false) {
                    DialogBox.dialog.errorDialog("Log folders not found!!!");
                    firstTime.createLog();
                    authenticate();
                }
            else if (firstTime.CheckImageFolders() == false) {
                    firstTime.createImageFolders();
                    authenticate();
                }
            else if (firstTime.CheckConfigFile() == false) {
                    DialogBox.dialog.errorDialog("Configuration file Not Found.");
                    firstTime.createConfigFile();
                }
            else if (((firstTime.CheckLog()==true) && (firstTime.CheckImageFolders()==true) && (firstTime.CheckConfigFile()) == true)) {
                //validateConfiguration();
                //TestDatabaseConnectivity();
               authenticate();
            }
            //Report r = new Report(); //r.makeStudentReport("109334",
            //"achyut");

            //EnterRoll r = new EnterRoll("Studentdetailsform");
            //r.setVisible(true); //Webcam cam = new Webcam(); //TestJMF4 t =
            // new TestJMF4(); // ReadConfigFile file = new ReadConfigFile(); //
            //DialogBox.dialog.errorDialog(file.getValue("dbName"));
            //InchargeFormMain.inc.setVisible(true);



            /*
             *
             * StudentEdit d = new StudentEdit("109334"); d.setVisible(true);
             *
             * ///testForm t1 = new testForm(); //t1.setVisible(true);
             *
             */


        } catch (Exception ae) {
            Log.log.writeErrorLog(ae.getMessage(), "Test", " ");
            DialogBox.dialog.errorDialog(ae.getMessage());
        }

    }
    static void authenticate(){
                Authenticate1 A1 = new Authenticate1();
                A1.setVisible(true);
/*                int height = (Screen.scr.getScreenHeight() - A1.getHeight()) / 2;
                int width = (Screen.scr.getScreenWidth() - A1.getWidth()) / 2;
                A1.setResizable(false);
                A1.setLocation(width, height);*/
    }
}
