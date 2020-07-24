package model;

/**
 *
 * @author ahnaf
 */
public class User {
    
    private String email;
    private String securePassword;
    private String salt;
    
    public User(String email, String securePassword, String salt){
        
        this.email = email;
        this.securePassword = securePassword;
        this.salt = salt;
        
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSecurePassword() {
        return securePassword;
    }

    public void setSecurePassword(String securePassword) {
        this.securePassword = securePassword;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }
}
