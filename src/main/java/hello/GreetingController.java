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

@Controller
public class GreetingController {

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model) {
         CallDatabase();
        model.addAttribute("name", name);
        return "greeting";
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
}


