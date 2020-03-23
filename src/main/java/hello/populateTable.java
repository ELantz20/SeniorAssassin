package hello;
import java.io.Serializable;
import java.util.ArrayList;
import java.sql.*;
import java.io.Serializable;

public class populateTable implements Serializable{

    private Integer id;
    private String name;

    public static ArrayList<Contact> main(String[] args) {
        ArrayList<Contact> Players = new ArrayList<Contact>();
        Contact newPlayer = new Contact("noName", 0);
        try {
            // create our mysql database connection
            //String myDriver = "org.gjt.mm.mysql.Driver";
            //  String myUrl = "jdbc:mysql://localhost/test";
            // Class.forName(myDriver);
            //  Connection conn = DriverManager.getConnection(myUrl, "root", "");

            String hostName = "holynamesacademy.database.windows.net";
            String dbName = "SeniorAssassin";
            String user = "hna-admin";
            String password = "HolyNames123";
            String url = String.format("jdbc:sqlserver://%s:1433;database=%s;user=%s;password=%s;encrypt=true;"
                    + "hostNameInCertificate=*.database.windows.net;loginTimeout=30;", hostName, dbName, user, password);
            Connection connection = null;


            connection = DriverManager.getConnection(url);

            // our SQL SELECT query.
            // if you only need a few columns, specify them by name instead of using "*"
            String query = "SELECT * FROM Players";

            // create the java statement
            Statement st = connection.createStatement();

            // execute the query, and get a java resultset
            ResultSet rs = st.executeQuery(query);

            // iterate through the java resultset
            while (rs.next()) {
                int id = rs.getInt("player_id");
                newPlayer.setID(id);
                String name = rs.getString("player_name");
                newPlayer.setName(name);
                boolean lifeStatus = rs.getBoolean("player_lifeStatus");
                newPlayer.setLifeStatus(lifeStatus);
                String Assignment = rs.getString("player_Assignment");
                newPlayer.assign(Assignment);

                Players.add(newPlayer);

                // print the results
                System.out.format("%s, %s, %s, %s\n", id, name, lifeStatus, Assignment);


            }
            st.close();



        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }

        return Players;


}
}
