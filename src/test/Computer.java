/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.sql.SQLException;
import java.sql.ResultSet;
/**
 *
 * @author APELY
 */
public class Computer {
    static Computer comp=new Computer();
    public String compid;
    public String macadd;
    public String labno;
    public String processor;
    public String harddisk;
    public String ram;
    public String cd;
    public String brand,computertype;
    private String enteredid;
    
       
        Computer(){}
        
            ResultSet getResult( String dbType, String id) {
        try {
            String query = "SELECT * FROM computerlist WHERE computerid = '" + id+ "'";
 
            ResultSet temp = null;
            if (dbType.equalsIgnoreCase("local")) {
                if (ReadConfigFile.conf.useLocalDb.equalsIgnoreCase("true")) {
                        temp = DatabaseMain.db.getResultFromLocalDb(query);
                        if (temp.next() == false) {
                            return null;
                        }
                        return temp;
                    } 
                
                    return temp;
                
            } else if (dbType.equalsIgnoreCase("master")) {
                if (ReadConfigFile.conf.useMasterDb.equalsIgnoreCase("true")) {
                       temp = DatabaseMain.db.getResultFromMasterDb(query);
                        if (temp.next() == false) {
                            return null;
                        }
                        return temp;
                    }
                    return temp;
                         }
            return temp;
        } catch (SQLException ex) {
            if (Log.log.displayDialog == true) {
                DialogBox.dialog.warningDialog(ex.getMessage());
            } else {
                Log.log.writeErrorLog(ex.getMessage(), "Computer", "getResult");
            }
            return null;
        }
    }

    ResultSet returnResultSet( String id) {
        ResultSet temp;
        if (ReadConfigFile.conf.dbPriority.equalsIgnoreCase("masterDb")) {
            temp = getResult( "master", id);
            if (temp == null) {
                temp = getResult( "local", id);
                if (temp == null) {
                    return null;
                }
                return temp;
            }
            return temp;
        } else if (ReadConfigFile.conf.dbPriority.equalsIgnoreCase("localDb")) {
            temp = getResult("local", id);
            if (temp == null) {
                temp = getResult("master",id);
                if (temp == null) {
                    return null;
                }
                return temp;
            }
            return temp;
        }
        return null;
    }

        boolean addComputer() {
        try {

            if (DatabaseMain.db.executeQuery("INSERT INTO computerlist VALUES ('" + compid + "','" + macadd + "','"+computertype+"','" + labno + "','" + processor + "','" + harddisk + "','" + ram + "','" + cd + "','" + brand + "')") == true) {
                return true;
            }
            return false;
        } catch (Exception e) {
            if (Log.log.displayDialog == true) {
                DialogBox.dialog.warningDialog(e.getMessage());
            } else {
                Log.log.writeErrorLog(e.getMessage(), "ComputerList", "addComputer");
            }
            return false;
        }
    }

    boolean editComputer() {
        try {
            if (DatabaseMain.db.executeQuery("UPDATE computerlist SET  computerid='" + compid + "',macaddress='" + macadd + "',labno='" +labno +"',computertype='"+computertype+ "',processor='" +processor+ "',harddisk='" +harddisk + "',ram='" + ram + "',cd='" +cd + "',brand='" +brand+"' WHERE computerid='" + enteredid + "'") == true) {

                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            if (Log.log.displayDialog == true) {
                DialogBox.dialog.warningDialog(e.getMessage());
            } else {
                    Log.log.writeErrorLog(e.getMessage(), "ComputerList", "editComputer");
            }
            return false;
        }
    }

    boolean deleteComputer() {
        try {
            if (DatabaseMain.db.executeQuery("DELETE FROM computerlist WHERE computerid='" + enteredid + "'")) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            if (Log.log.displayDialog == true) {
                DialogBox.dialog.warningDialog(e.getMessage());
            } else {
                    Log.log.writeErrorLog(e.getMessage(), "ComputerList", "deleteComputer");
            }
            return false;
        }
    }


        boolean ifComputerExists(String id) {
        if (getComputerInfo(id) == null) {
            return false;
        } else {
            enteredid = id;
            return true;
        }
    }

    /*
     * boolean ifAlreadyExists(String roll,String name) { ResultSet
     * temp=Student.std.getStudentInfo(roll, name); if(temp==null) return false;
     * else return true; }
     */
    ResultSet getComputerInfo(String id) {
        return AbstractPerson.ab.getRecordFromQuery("select * from computerlist where computerid ='"+id+"'");
    }

    public boolean setComputerInfo(String id) {

        try {
            ResultSet compResult = Computer.comp.getComputerInfo(id);
            if (compResult != null) {
                Computer.comp.compid = compResult.getString("computerid");
                Computer.comp.macadd = compResult.getString("macaddress");
                Computer.comp.labno = compResult.getString("labno");
                Computer.comp.computertype = compResult.getString("computertype");
                Computer.comp.processor= compResult.getString("processor");
                Computer.comp.harddisk = compResult.getString("harddisk");
                Computer.comp.ram = compResult.getString("ram");
                Computer.comp.cd = compResult.getString("cd");
                Computer.comp.brand = compResult.getString("brand");
                return true;
            }
            return false;

        } catch (SQLException ex) {
            if (Log.log.displayDialog == true) {
                DialogBox.dialog.warningDialog(ex.getMessage());
            } else {
                Log.log.writeErrorLog(ex.getMessage(), "Computer", "setComputerInfo");
            }
            return false;
        }

    }

    boolean ifLabExists(String id) {
              
        try{
        ResultSet rs=AbstractPerson.ab.getRecordFromQuery("Select labno from computerlist where labno='"+id+"'");
        if(rs!=null)
        return true;
        else 
         return false;
    //rs!=null?return true:return false;
        }
        catch(Exception e){
            Log.log.writeErrorLog(e.getMessage(),"Computer", "ifLabExists");
            return false;
        }
    }

    
}
