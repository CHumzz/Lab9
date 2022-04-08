package ca.sait.securitydemo12.services;

import ca.sait.securitydemo12.dataaccess.UserDB;
import ca.sait.securitydemo12.models.User;
import java.util.HashMap;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AccountService {
    
    public User login(String email, String password) {
        UserDB userDB = new UserDB();
        
        try {
            User user = userDB.get(email);
            if (password.equals(user.getPassword())) {
                return user;
            }
        } catch (Exception e) {
        }
        
        return null;
    }
    
    public void resetPassword(String email, String path, String url){
        String uuid = UUID.randomUUID().toString();
        UserDB userDB = new UserDB();
        String link = url + "?uuid=" + uuid; 
        
        try {
            User user = userDB.get(email);
            if (user != null){
                Logger.getLogger(AccountService.class.getName()).log(Level.INFO, "Successful login by {0}", email);
                
                String to = user.getEmail();
                String subject = "Notes App - Reset your Password";
                String template = path + "/emailtemplates/resetpassword.html";
                
                HashMap<String, String> tags = new HashMap<>();
                tags.put("firstname", user.getFirstName());
                tags.put("lastname", user.getLastName());
                tags.put("password", user.getPassword());
                //tags.put("date", (new java.util.Date()).toString());
                
                GmailService.sendMail(to, subject,template, tags);
                
                user.setResetPasswordUuid(uuid);
                userDB.update(user);
                
            } else {
                throw new Exception("User not found");
            }
               
            
        } catch (Exception e) {
            Logger.getLogger(AccountService.class.getName()).log(Level.SEVERE, "Unuccessful reset by " + email, e);
        }
    }    
    
}
