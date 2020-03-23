package hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.util.ArrayList;

@Controller
public class GreetingController {

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model) {
         CallDatabase();
        model.addAttribute("name", name);
        return "greeting";
    }
    @GetMapping("/homepage")
    public String homepage (Model model) {
        ArrayList<Contact> playerInfo = playerInfo();
        model.addAttribute("list", playerInfo);
        return "homepage";
    }

    public void CallDatabase() {

        // Connect to database
        String hostName = "holynamesacademy.database.windows.net";
        String dbName = "SeniorAssassin";
        String user = "hna-admin";
        String password = "HolyNames123";
        String url = String.format("jdbc:sqlserver://%s:1433;database=%s;user=%s;password=%s;encrypt=true;"
                + "hostNameInCertificate=*.database.windows.net;loginTimeout=30;", hostName, dbName, user, password);
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(url);
            String schema = connection.getSchema();
            System.out.println("Successful connection - Schema: " + schema);

            System.out.println("Query data example:");
            System.out.println("=========================================");

            // Create and execute a SELECT SQL statement.
            String selectSql = "SELECT TOP 20 pc.Name as CategoryName, p.name as ProductName "
                    + "FROM [SalesLT].[ProductCategory] pc "
                    + "JOIN [SalesLT].[Product] p ON pc.productcategoryid = p.productcategoryid";

            String selectSql2 = " SELECT * from Players; ";

            try (Statement statement = connection.createStatement();
                 ResultSet resultSet2 = statement.executeQuery(selectSql2)) {

                // Print results from select statement
                System.out.println("Top 20 categories:");
                while (resultSet2.next()) {
                    System.out.println(resultSet2.getInt(1) + " "
                            + resultSet2.getString(2));
                }
                connection.close();
            }
            catch (Exception e) {
                e.printStackTrace();
            }


            /*try (Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery(selectSql)) {

                // Print results from select statement
                System.out.println("Top 20 categories:");
                while (resultSet.next()) {
                    System.out.println(resultSet.getString(1) + " "
                            + resultSet.getString(2));
                }
                connection.close();
            }*/
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static ArrayList<Contact> playerInfo (){
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


