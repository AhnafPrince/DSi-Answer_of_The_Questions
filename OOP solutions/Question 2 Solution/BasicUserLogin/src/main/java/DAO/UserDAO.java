package DAO;

import PasswordEncryption.VerifyProvidedPassword;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.regex.Pattern;
import model.User;

/**
 *
 * @author ahnaf
 */
public class UserDAO {
    
    private final String jdbcURL = "jdbc:mysql://localhost:3307/userlogin";
    private final String jdbcUsername = "root";
    private final String jdbcPassword = "";
    
    private static final String CHECK_AVAILABLE_EMAIL = "select email from userlogin.userdata where email = ?;";
    private static final String INSERT_USER_SQL = "INSERT INTO userlogin.userdata" + "  (email, securepassword, salt)"
            + "VALUES (?, ?, ?);";
    
    private static final String LOGIN_USER_SQL = "select securePassword , salt from userlogin.userdata where email= ? ;";
    
    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        if (connection == null) {
            System.out.println("Not Connected");
        }
        return connection;
    }
    
    public boolean checkAvailableEmail(String email) {

        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(CHECK_AVAILABLE_EMAIL);) {
            statement.setString(1, email);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return false;
    }
    
    
    public void insertUser(User user,PrintWriter out) throws SQLException {
        System.out.println(INSERT_USER_SQL);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER_SQL)) {

            preparedStatement.setString(1, user.getEmail());
            preparedStatement.setString(2, user.getSecurePassword());
            preparedStatement.setString(3, user.getSalt());
            
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
            out.println("Insert Success!");
        } catch (SQLException e) {
            printSQLException(e);
            out.println("Insert failed ! ");
        }
    }
    
    
    
    //this method is for verifing user email & password for login purpose
    public boolean loginUser(String email, String passWord, PrintWriter out) {

        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(LOGIN_USER_SQL);) {
            statement.setString(1, email);
            ResultSet result = statement.executeQuery();

            VerifyProvidedPassword vpf = new VerifyProvidedPassword();
  

            if (!result.next()) {
                return false;
            } else {

                String securePassword = result.getString(1);
                String salt = result.getString(2);

                if (vpf.passwordValidation(passWord, securePassword, salt)) {
                    return true;
                } else {
                    return false;
                }
            }
        } catch (SQLException e) {
            printSQLException(e);
            out.println("login failed ! ");
            return false;
        }

    }
    

    
    private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
    
    //this method is for checking whether the email syntax is valid or not
    public boolean isValid(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."
                + "[a-zA-Z0-9_+&*-]+)*@"
                + "(?:[a-zA-Z0-9-]+\\.)+[a-z"
                + "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        if (email == null) {
            return false;
        }
        return pat.matcher(email).matches();
    }

    
}
