import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Character{
    private Connection conn; // not working yet
    private String name;
    private String catchPhrase;
    private ResultSet rs;
    private int characterID;

    /**
     * Make characters
     * @param name: String
     * @param catchPhrase: String
     */
    public Character(String name, String catchPhrase){
        this.name = name;
        this.catchPhrase = catchPhrase;
        this.characterID = -1;
    }

    public int addCharacter() {
        try {
            int result = 0;
            String sql = "INSERT INTO newCharacter (name, catchphrase) VALUES (?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, this.getname());
            ps.setString(2, this.getCatchPhrase());

            result = ps.executeUpdate();

            String stmt = "SELECT LAST_INSERT_ID()";
            rs = conn.prepareStatement(stmt).executeQuery();
            rs.next();

            characterID = rs.getInt(1);

            return(result);
        } // end of try

        catch(SQLException sqle) {
            sqle.printStackTrace();
            return -1;
        } // end of catch
    }

    /**
     * get name of character
     */
    public String getname(){
        return this.name;
    }

    /**
     * get character id
     */
    public int getID(){
        return this.characterID;
    }

    /**
     * @return character's catchphrase
     */
    public String getCatchPhrase(){
        return this.catchPhrase;
    }



}
