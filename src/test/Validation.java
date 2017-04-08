/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.sql.ResultSet;
import java.sql.SQLException;


public class Validation {

    int curr_year, batch1;
    static Validation val = new Validation();
    /*
     * This method validates if the student with given roll no exists or not
     */

    public boolean validateGuestId(String id, String message) {
        if (checkNull(id, message) == true) {
            return false;

        } else {
            //DialogBox.dialog.validationDialog("Password is invalid!!!!");
            return true;
        }

    }

    public boolean isNumber(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public boolean validateID(String id) {
        if (id.isEmpty()) {
            DialogBox.dialog.errorDialog("ID cannot be empty");
            return false;
        } else {
            if (id.length() > 4&&id.length()<=15) {

                String tempID = id.substring(0, 4);
                String num = id.substring(4);
                if (tempID.equalsIgnoreCase("gst-") || tempID.equalsIgnoreCase("fac-") || tempID.equalsIgnoreCase("usr-")) {
                    if (isNumber(num) && num.length() >= 4) {
                        return true;
                    }
                    DialogBox.dialog.errorDialog("Guest ID must contain more 3 numbers");
                    return false;
                } else if (isNumber(tempID)) {
                    if (validateRoll(id, "Roll No")) {
                        return true;
                    }
                }
                DialogBox.dialog.errorDialog("Invalid ID");
                return false;
            }
            DialogBox.dialog.errorDialog("ID Cannot be less than 4 characters and greater than 15 characters");
            return false;
        }
    }

    public boolean validateGuestID(String id) {
        if (id.isEmpty()) {
            DialogBox.dialog.errorDialog("ID cannot be empty");
            return false;
        } else {
            if (id.length() > 4 && id.length()<=15) {
                String tempID = id.substring(0, 4);
                String num = id.substring(4);
                if (tempID.equalsIgnoreCase("gst-")) {
                    if (isNumber(num) && num.length() >= 4) {
                        return true;
                    }
                    DialogBox.dialog.errorDialog("Guest ID must contain more 3 numbers");
                    return false;
                }
                DialogBox.dialog.errorDialog("Invalid Guest ID");
                return false;
            }
            DialogBox.dialog.errorDialog("ID Cannot be less than 4 and greater than 15 characters");
            return false;
        }
    }

    public boolean validateUserID(String id) {
        if (id.isEmpty()) {
            DialogBox.dialog.errorDialog("ID cannot be empty");
            return false;
        } else {
            if (id.length() > 4&&id.length()<=15) {
                String tempID = id.substring(0, 4);
                String num = id.substring(4);
                if (tempID.equalsIgnoreCase("usr-")) {
                    if (isNumber(num) && num.length() >= 4) {
                        return true;
                    }
                    DialogBox.dialog.errorDialog("User ID must contain more 3 numbers");
                    return false;
                }
                DialogBox.dialog.errorDialog("Invalid User ID");
                return false;
            }
            DialogBox.dialog.errorDialog("ID Cannot be less then 4 and greater than 15 characters");
            return false;
        }
    }

    public boolean validateFacultyID(String id) {
        if (id.isEmpty()) {
            DialogBox.dialog.errorDialog("ID cannot be empty");
            return false;
        } else {
            if (id.length() > 4 && id.length()<=15) {
                String tempID = id.substring(0, 4);
                String num = id.substring(4);
                if (tempID.equalsIgnoreCase("fac-")) {
                    if (isNumber(num) && num.length() >= 4) {
                        return true;
                    }
                    DialogBox.dialog.errorDialog("Faculty ID must contain more 3 numbers");
                    return false;
                }
                DialogBox.dialog.errorDialog("Invalid faculty ID");
                return false;
            }
            DialogBox.dialog.errorDialog("ID Cannot be less then 4 and greater than 15 characters");
            return false;
        }
    }

    public boolean validateCheckIn(String id, String Name) {
        ResultSet studentRecord = Student.std.getStudentInfo(id, Name);
        try {
            if (studentRecord.getString("studentid").equals(id) == true) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ae) {
            Log.log.writeErrorLog(ae.getMessage(), "Validation", "validateCheckIn");
            return false;
        }
    }

    public boolean validateComputerInfo(String compid, String macadd, String labno, String processor, String harddisk, String ram, String cd, String brand) {
        if ((validateCompId(compid, "Id") && validateMac1(macadd, "Macaddrress") && validateLabno(labno, "LabNo") && validateProcessor(processor, "Processor") && validateHarddisk(harddisk, "harddisk") && validateRam(ram, "RAM") && validateCd(cd, "CD") && validateBrand(brand, "Brand")) == true) {
            return true;
        } else {
            return false;
        }
    }

    public boolean validateCompId(String compid, String name) {
        if (checkNull(compid, name) == true) {
            return false;
        } else if(compid.length()>10){
            DialogBox.dialog.warningDialog("Invalid computer id!!It can be of max. 10 characters");
            return false;
        }
        else {
            return true;
        }
    }

    public boolean validateLabno(String labno, String name) {
        
        if (checkNull(labno, name) == true) {
            return false;
        }else if(labno.length()>5){
            DialogBox.dialog.warningDialog("Invalid Labno!!It can be of max. 5 characters");
            return false;
        }
        else {
            return true;
        }
    }

    public boolean validateProcessor(String processor, String name) {
        if (checkNull(processor, name) == true) {
            return false;
        } else {
            return true;
        }
    }

    public boolean validateHarddisk(String harddisk, String name) {
        if (checkNull(harddisk, name) == true) {
            return false;
        } else {
            return true;
        }
    }

    public boolean validateRam(String ram, String name) {
        if (checkNull(ram, name) == true) {
            return false;
        } else {
            return true;
        }
    }

    public boolean validateCd(String cd, String name) {
        if (checkNull(cd, name) == true) {
            return false;
        } else {
            return true;
        }
    }

    public boolean validateBrand(String brand, String name) {
        if (checkNull(brand, name) == true) {
            return false;
        } else {
            return true;
        }
    }

    boolean validateStudentInfo(String roll, String name, String branch, String batch, String phone, String add, String mac1, String mac2, String valid) {
        if ((validateName(name, "Name") && validateRoll(roll, "Rollno") && validateBranch(branch, "branch") && validateYear(batch, "Batch") && validatePhoneNo(phone, "phoneno") && validateAddress(add, "Address") && validateMac1(mac1, "Macadd1") && validateMac2(mac2)) == true) {
            if ((Integer.parseInt(valid) < Integer.parseInt(batch)) || (Integer.parseInt(valid) > Integer.parseInt(batch) + 6)) {
                DialogBox.dialog.warningDialog("valid upto should be greater than the batch and should not be greater than 6 years ");
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    public boolean validateGuestInfo(String id, String name, String add, String phone, String ref, String occupation, String valid) {
        if ((validateName(name, "Name") && validateGuestID(id) && validatePhoneNo(phone, "Phone no") && validateAddress(add, "Address") && validateRef(ref, "Reference") && validateOccupation(occupation, "occupation") && validateValidUpto(valid, "validupto")) == true) {
            return true;
        } else {
            return false;
        }

    }

    public boolean validateFacultyInfo(String id, String name, String add, String phone, String dept, String profile, String valid) {
        if ((validateName(name, "Name") && validateFacultyID(id) && validatePhoneNo(phone, "Phone no") && validateAddress(add, "Address") && validateBranch(dept, "department") && validateProfile(profile, "profile") && validateValidUpto(valid, "validupto")) == true) {
            return true;
        } else {
            return false;
        }
    }

    public boolean validateBlacklistInfo(String id, String duration, String addedby, String reason) {
        if ((validateID(id) && validateDuration(duration, "Duration") && validateAddedBy(addedby, "Addedby") && validateReason(reason, "Reason")) == true) {
            return true;
        } else {
            return false;
        }
    }

    public boolean validateUserInfo(String id, String name, String password, String userType, String address, String phone) {
        if ((validateUserID(id) && validateName(name, "username") && validatePassword(password, "Password") && validateUserType(userType, "Usertype") && validateAddress(address, "Address") && validatePhoneNo(phone, "Phone")) == true) {
            return true;
        } else {
            return false;
        }
    }

    public boolean validateUserType(String userType, String name) {
        if (checkNull(userType, name) == true) {
            return false;
        } else //DialogBox.dialog.validationDialog("UserType is invalid!!!!");
        {
            return true;
        }
    }

    public boolean validatePassword(String password, String name) {
        if (checkNull(password, name) == true) {
            return false;
        } else {
            //DialogBox.dialog.validationDialog("Password is invalid!!!!");
            return true;
        }
    }

    public boolean validateRoll(String roll, String FieldName) {
        if ((checkNull(roll, FieldName) == true)) {
            return false;
        } else if (roll.length() < 6) {
            DialogBox.dialog.errorDialog("Roll No Should not be less then 6 characters in length");
            return false;
        } else if (isNumber(roll) == false) {
            DialogBox.dialog.errorDialog("Roll No Should be a Number type");
            return false;
        }
        return true;

    }

    public boolean validateName(String name1, String name) {
        if (checkNull(name1, name) == true) {
            return false;
        } 
        else if(name.length()>20){
            DialogBox.dialog.warningDialog("Name is too  long!!It can be of max. 20 characters");
            return false;
        }
        else // DialogBox.dialog.validationDialog("Name is invalid!!!!");
        {
            return true;
        }
    }

    public boolean validateAddress(String addr, String name) {
        if (checkNull(addr, name) == true) {
            return false;
        } 
         else if(addr.length()>30){
            DialogBox.dialog.warningDialog("Address is too long!!It can be of max. 30 characters");
            return false;
        }
        else 
        {
            return true;
        }
    }

    public boolean validateBranch(String branch, String name) {

        if (!branch.equals("------") && !branch.equals(" ")) {
            return true;
        } else {
            DialogBox.dialog.errorDialog("Please choose a Branch ");
            return false;
        }
    }

    public boolean validateYear(String batch, String name) {

        if (!batch.equals("------") && !batch.equals(" ")) {
            return true;
        } else {
            DialogBox.dialog.errorDialog("Please choose a batch");
            return false;
        }

     }

    public boolean validatePhoneNo(String phone, String name) {
        if (checkNull(phone, name) == true) {
            return false;
        } else if (isNumber(phone) == false) {
            DialogBox.dialog.warningDialog("Phone Number should be a Number");
            return false;
        } else if(phone.length()>15){
            DialogBox.dialog.warningDialog("Invalid phone no!!");
            return false;
        }
        else //DialogBox.dialog.validationDialog("Address is invalid!!!!");
        {
            return true;
        }
    }

    public boolean validateMac1(String mac, String name) {

        if(mac.length()>17){
            DialogBox.dialog.warningDialog("Invalid Mac address!!");
            return false;
        }
/*    String reg2 = /^[A-Fa-f0-9]{1,2}\:[A-Fa-f0-9]{1,2}\:[A-Fa-f0-9]{1,2}\:[A-Fa-f0-9]{1,2}\:[A-Fa-f0-9]{1,2}\:[A-Fa-f0-9]{1,2}$/;
   //if (mac.matches("/^[A-Fa-f0-9]{1,2}\-[A-Fa-f0-9]{1,2}\-[A-Fa-f0-9]{1,2}\-[A-Fa-f0-9]{1,2}\-[A-Fa-f0-9]{1,2}\-[A-Fa-f0-9]{1,2}$/")) {
      return true;
   }else if (reg2.test(macaddr)) {
      return true;
   } else {
      return false;
   }
  
*/
        return true;
    }

    public boolean validateMac2(String mac) {
         if(mac.length()>17){
            DialogBox.dialog.warningDialog("Invalid mac address!!");
            return false;
        }
        return true;
    }

    public boolean validateValidUpto(String valid, String name) {
        if ((checkNull(valid, name) == true)) {
            return false;
        } else if (isNumber(valid) == false) {
            DialogBox.dialog.warningDialog("Valid Upto should be a Number");
            return false;
        } else if ((valid.length() != 4)) {
            DialogBox.dialog.errorDialog("Valid Upto should be 4 characters length");
            return false;
        } else {
            String temp = "";
            String yr1 = (TimeDate.time.timestampToFullDate(AbstractPerson.ab.currentTimeStamp()));
            for (int i = 0; i <= 3; i++) {
                temp = temp + yr1.charAt(i);
            }
            //System.out.print(temp);
            curr_year = Integer.parseInt(temp);
            if ((curr_year > Integer.parseInt(valid)) || (curr_year < (Integer.parseInt(valid) - 4))) {
                DialogBox.dialog.errorDialog("Enter a valid validupto(greater than " + temp + " and less than " + (curr_year + 4) + ")");
                return false;
            } else {
                return true;
            }

        }

    }

    public boolean validateRef(String ref, String name) {
        if (checkNull(ref, name) == true) {
            return false;
        } 
        else if(ref.length()>20){
            DialogBox.dialog.warningDialog("Invalid compu!!It can be of max. 20 characters");
            return false;
        }
        else //DialogBox.dialog.validationDialog("Address is invalid!!!!");
        {
            return true;
        }
    }

    public boolean validateOccupation(String occ, String name) {
        if (checkNull(occ, name) == true) {
            return false;
        }else if(occ.length()>30){
            DialogBox.dialog.warningDialog("Invalid occupation!!It can be of max. 30 characters");
            return false;
        }
        else //DialogBox.dialog.validationDialog("Address is invalid!!!!");
        {
            return true;
        }
    }

    public boolean validateProfile(String profile, String name) {
        if (checkNull(profile, name) == true) {
            return false;
        }else if(profile.length()>30){
            DialogBox.dialog.warningDialog("Invalid profile!!It can be of max. 30 characters");
            return false;
        }
        else //DialogBox.dialog.validationDialog("Address is invalid!!!!");
        {
            return true;
        }
    }

    public boolean validateReason(String reason, String name) {
        
        if (checkNull(reason, name) == true) {
            return false;
        } else if(reason.length()>50){
            DialogBox.dialog.warningDialog("Reason is too long!!Cannot exceed 50 characters");
            return false;
        }
        else 
        {
            return true;
        }
    }

    public boolean validateDuration(String duration, String name) {
        if (checkNull(duration, name) == true) {
            return false;
        } else if (isNumber(duration) == false) {
            DialogBox.dialog.warningDialog("Duration should be a Number");
            return false;
        } else //DialogBox.dialog.validationDialog("Address is invalid!!!!");
        {
            return true;
        }
    }

    public boolean validateAddedBy(String addedby, String name) {
        if (checkNull(addedby, name) == true) {
            return false;
        } 
        else if(addedby.length()>20){
            DialogBox.dialog.warningDialog("Addedby is too long!!Cannot exceed 20 characters");
            return false;
        }
        else 
        {
            return true;
        }
    }

    public boolean checkNull(String par1, String name) {
        if (par1.isEmpty()) {
            DialogBox.dialog.validationDialog("" + name + ": Field cannot be empty!!!");
            return true;
        } else {
            return false;
        }
    }

    public boolean validateCurrent(String ID) {
        ResultSet currentResult = AbstractPerson.ab.getCurrenttableResult(ID);
        try {
            String id = currentResult.getString("id");
            if (id.compareTo(ID) == 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ae) {
            Log.log.writeErrorLog(ae.getMessage(), "Validation", "validateCurrent");
            return false;
        }
    }
}
