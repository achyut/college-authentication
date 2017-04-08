/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import com.mysql.jdbc.Connection;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Achyut
 */
public class Report {

    void blacklistDisplayReport(String id, String name, String fromTime, String toTime, String orderby) {
        try {
            String source = "src\\reports\\BlacklistDisplay.jrxml";
            JasperReport jr = JasperCompileManager.compileReport(source);
            Map parms = new HashMap();
            parms.put("Id", id);
            parms.put("Name", name);
            parms.put("order", orderby);
            parms.put("fromTime", fromTime);
            parms.put("toTime", toTime);
            Connection con = (Connection) DatabaseMain.db.getConnection();
            JasperPrint jp = JasperFillManager.fillReport(jr, parms, con);
            JasperViewer.viewReport(jp, false);
        } catch (JRException ex) {
        }
    }

    void BlacklistCurrentReport() {
        try {
            String source = "src\\reports\\BlacklistCurrent.jrxml";
            JasperReport jr = JasperCompileManager.compileReport(source);
            Map parms = new HashMap();
            Connection con = (Connection) DatabaseMain.db.getConnection();
            JasperPrint jp = JasperFillManager.fillReport(jr, parms, con);
            JasperViewer.viewReport(jp, false);
        } catch (JRException ex) {
            Logger.getLogger(Report.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    void checkInCheckOutRecord(String id,String from,String to,boolean generateAll){
        String name = AbstractPerson.ab.getName(id);
        try {
            if(generateAll == false){
            String source = "src\\reports\\CheckInMainDisplay.jrxml";
            Map parms = new HashMap();
            parms.put("Id", id);
            parms.put("Name", name);
            parms.put("fromTime", from);
            parms.put("toTime", to);
            JasperReport jr = JasperCompileManager.compileReport(source);
            Connection con = (Connection) DatabaseMain.db.getConnection();
            JasperPrint jp = JasperFillManager.fillReport(jr, parms, con);
            JasperViewer.viewReport(jp, false);
            }
            else{
            String source = "src\\reports\\CheckInMainDisplayAll.jrxml";
            Map parms = new HashMap();
            parms.put("Id", id);
            parms.put("Name", name);
            JasperReport jr = JasperCompileManager.compileReport(source);
            Connection con = (Connection) DatabaseMain.db.getConnection();
            JasperPrint jp = JasperFillManager.fillReport(jr, parms, con);
            JasperViewer.viewReport(jp, false);
            }
            
        } catch (JRException ex) {
            Logger.getLogger(Report.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void ComputerDetails(String id,boolean generateAll){
        try {
            if(generateAll == false){
            String source = "src\\reports\\ComputerDetail.jrxml";
            Map parms = new HashMap();
            parms.put("compid", id);
            JasperReport jr = JasperCompileManager.compileReport(source);
            Connection con = (Connection) DatabaseMain.db.getConnection();
            JasperPrint jp = JasperFillManager.fillReport(jr, parms, con);
            JasperViewer.viewReport(jp, false);
            }
            
        } catch (JRException ex) {
            Logger.getLogger(Report.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    void BlacklistDisplayRecord(String id,String from,String to,boolean generateAll){
        String name = AbstractPerson.ab.getName(id);
        try {
            if(generateAll == false){
            String source = "src\\reports\\BlacklistDisplay.jrxml";
            Map parms = new HashMap();
            parms.put("Id", id);
            parms.put("Name", name);
            parms.put("fromTime", from);
            parms.put("toTime", to);
            JasperReport jr = JasperCompileManager.compileReport(source);
            Connection con = (Connection) DatabaseMain.db.getConnection();
            JasperPrint jp = JasperFillManager.fillReport(jr, parms, con);
            JasperViewer.viewReport(jp, false);
            }
            else{
            String source = "src\\reports\\BlacklistDisplayAll.jrxml";
            Map parms = new HashMap();
            parms.put("Id", id);
            parms.put("Name", name);
            JasperReport jr = JasperCompileManager.compileReport(source);
            Connection con = (Connection) DatabaseMain.db.getConnection();
            JasperPrint jp = JasperFillManager.fillReport(jr, parms, con);
            JasperViewer.viewReport(jp, false);
            }
            
        } catch (JRException ex) {
            Logger.getLogger(Report.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void printUserInfo(String id) {
        try {
            String source = "src\\reports\\UserInfo.jrxml";
            JasperReport jr = JasperCompileManager.compileReport(source);
            Map parms = new HashMap();
            parms.put("id", id);
            Connection con = (Connection) DatabaseMain.db.getConnection();
            JasperPrint jp = JasperFillManager.fillReport(jr, parms, con);
            JasperViewer.viewReport(jp, false);
        } catch (JRException ex) {
            Log.log.writeErrorLog(ex.getMessage(), "Report","printUserInfo");
        }
    }
    
    void printStudentInfo(String id) {
        try {
            String source = "src\\reports\\StudentInfo.jrxml";
            JasperReport jr = JasperCompileManager.compileReport(source);
            Map parms = new HashMap();
            parms.put("id", id);
            Connection con = (Connection) DatabaseMain.db.getConnection();
            JasperPrint jp = JasperFillManager.fillReport(jr, parms, con);
            JasperViewer.viewReport(jp, false);
        } catch (JRException ex) {
            Log.log.writeErrorLog(ex.getMessage(), "Report","printStudentInfo");
        }
    }
    void printFacultyInfo(String id) {
        try {
            String source = "src\\reports\\FacultyInfo.jrxml";
            JasperReport jr = JasperCompileManager.compileReport(source);
            Map parms = new HashMap();
            parms.put("id", id);
            Connection con = (Connection) DatabaseMain.db.getConnection();
            JasperPrint jp = JasperFillManager.fillReport(jr, parms, con);
            JasperViewer.viewReport(jp, false);
        } catch (JRException ex) {
            Log.log.writeErrorLog(ex.getMessage(), "Report","printFacultyInfo");
        }
    }
    void printGuestInfo(String id) {
        try {
            String source = "src\\reports\\GuestInfo.jrxml";
            JasperReport jr = JasperCompileManager.compileReport(source);
            Map parms = new HashMap();
            parms.put("id", id);
            Connection con = (Connection) DatabaseMain.db.getConnection();
            JasperPrint jp = JasperFillManager.fillReport(jr, parms, con);
            JasperViewer.viewReport(jp, false);
        } catch (JRException ex) {
            Log.log.writeErrorLog(ex.getMessage(), "Report","printGuestInfo");
        }
    }

    void AllComputerDetails() {
        try {
            String source = "src\\reports\\ComputerDetailAll.jrxml";
            JasperReport jr = JasperCompileManager.compileReport(source);
            Map parms = new HashMap();
            Connection con = (Connection) DatabaseMain.db.getConnection();
            JasperPrint jp = JasperFillManager.fillReport(jr, parms, con);
            JasperViewer.viewReport(jp, false);
        } catch (JRException ex) {
            Log.log.writeErrorLog(ex.getMessage(), "Report","printGuestInfo");
        }
    }

    void LabUsage(String id, String from, String to, boolean generateAll) {
        try {
            if(generateAll == false){
            String source = "src\\reports\\LabUsage.jrxml";
            Map parms = new HashMap();
            parms.put("labno", id);
            parms.put("from", from);
            parms.put("to", to);
            JasperReport jr = JasperCompileManager.compileReport(source);
            Connection con = (Connection) DatabaseMain.db.getConnection();
            JasperPrint jp = JasperFillManager.fillReport(jr, parms, con);
            JasperViewer.viewReport(jp, false);
            }
            else{
            String source = "src\\reports\\LabUsageAll.jrxml";
            Map parms = new HashMap();
            parms.put("labno", id);
            JasperReport jr = JasperCompileManager.compileReport(source);
            Connection con = (Connection) DatabaseMain.db.getConnection();
            JasperPrint jp = JasperFillManager.fillReport(jr, parms, con);
            JasperViewer.viewReport(jp, false);
            }
            
        } catch (JRException ex) {
            Logger.getLogger(Report.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void computerUsageDetail(String id, String from, String to, boolean generateAll) {
        String labno ="N/A";
        String macaddr = "N/A";
        try {
            if(generateAll == false){
            String source = "src\\reports\\ComputerUsageDetail.jrxml";
            Map parms = new HashMap();
            parms.put("compid", id);
            parms.put("from", from);
            parms.put("to", to);
            parms.put("labno", labno);
            parms.put("macaddress", macaddr);
            JasperReport jr = JasperCompileManager.compileReport(source);
            Connection con = (Connection) DatabaseMain.db.getConnection();
            JasperPrint jp = JasperFillManager.fillReport(jr, parms, con);
            JasperViewer.viewReport(jp, false);
            }
            else{
            String source = "src\\reports\\ComputerUsageDetailAll.jrxml";
            Map parms = new HashMap();
            parms.put("compid", id);
            parms.put("labno", labno);
            parms.put("macaddress",macaddr);
            JasperReport jr = JasperCompileManager.compileReport(source);
            Connection con = (Connection) DatabaseMain.db.getConnection();
            JasperPrint jp = JasperFillManager.fillReport(jr, parms, con);
            JasperViewer.viewReport(jp, false);
            }
            
        } catch (JRException ex) {
            Logger.getLogger(Report.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void checkincurrent() {
        try {
            String source = "src\\reports\\CheckInCurrent.jrxml";
            JasperReport jr = JasperCompileManager.compileReport(source);
            Map parms = new HashMap();
            Connection con = (Connection) DatabaseMain.db.getConnection();
            JasperPrint jp = JasperFillManager.fillReport(jr, parms, con);
            JasperViewer.viewReport(jp, false);
        } catch (JRException ex) {
            Logger.getLogger(Report.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
