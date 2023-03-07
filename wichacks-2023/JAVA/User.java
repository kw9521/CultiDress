import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class User {
    private ResultSet rs;
    private Connection conn; // not working yet
    private String username;
    private String password;
    private String country;
    private int userID;
    /**
     * Makes a User
     * @param username: String
     * @param password: String
     */
    public User(String username, String password, String country){
        this.username = username;
        this.password = password;
        this.country = country;
    }

    public int addUser() {
        try {
            int result = 0;
            String sql = "INSERT INTO userInfo (username, password, country) VALUES (?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, this.getUsername());
            ps.setString(2, this.getPassword());
            ps.setString(3, this.getCountry());

            result = ps.executeUpdate();

            String stmt = "SELECT LAST_INSERT_ID()";
            rs = conn.prepareStatement(stmt).executeQuery();
            rs.next();

            userID = rs.getInt(1);

            return(result);
        } // end of try

        catch(SQLException sqle) {
            sqle.printStackTrace();
            return -1;
        } // end of catch
    }

    public int connectCharacter(Character character) {
        try {
            int result = 0;
            String sql = "INSERT INTO userCharacters (userID, characterID) VALUES (?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, this.getUserID());
            ps.setInt(2, character.getID());

            result = ps.executeUpdate();
            
            return(result);
        } // end of try

        catch(SQLException sqle) {
            sqle.printStackTrace();
            return -1;
        }
    }

    /**
     * @return User's ID
     */
    public int getUserID(){
        return this.userID;
    }
    /**
     * @return String of username
     */
    public String getUsername(){
        return this.username;
    }
    /**
     * @return String of User's password
     */
    public String getPassword(){
        return this.password;
    }
    /**
     * @return String of user's country
     */
    public String getCountry() {
        return this.country;
    }
}