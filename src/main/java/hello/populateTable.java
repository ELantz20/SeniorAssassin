package hello;
import java.util.ArrayList;
import java.sql.*;


/*public class populateTable {

   ArrayList<Contact> Players= new ArrayList<Contact>();

    public void main(String[] args) {

        for (int i = 0; i < 3; i++) {

        }

    }

}
*/


public class JavaMysqlSelectExample {

    public static void main(String[] args) {
        try {
            // create our mysql database connection
            String myDriver = "org.gjt.mm.mysql.Driver";
            String myUrl = "jdbc:mysql://localhost/test";
            Class.forName(myDriver);
            Connection conn = DriverManager.getConnection(myUrl, "root", "");

            // our SQL SELECT query.
            // if you only need a few columns, specify them by name instead of using "*"
            String query = "SELECT * FROM Players";

            // create the java statement
            Statement st = conn.createStatement();

            // execute the query, and get a java resultset
            ResultSet rs = st.executeQuery(query);

            // iterate through the java resultset
            while (rs.next()) {
                int id = rs.getInt("player_id");
                String name = rs.getString("player_name");
                boolean lifeStatus = rs.getBoolean("player_lifeStatus");
                String Assignment = rs.getString("player_Assignment");

                // print the results
                System.out.format("%s, %s, %s, %s, %s, %s\n", id, name, lifeStatus, Assignment);
            }
            st.close();
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
    }
}
