import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Solution {

    private static final String DB_URL = "jdbc:oracle:thin:@gromcod-lessons.cxsivpl79ocf.us-east-1.rds.amazonaws.com:1521:ORCL";
    private static final String USER = "main";
    private static final String PASS = "main1gromcod2main";

    public static void main(String[] args) {
        deleteProductsByPrice();
    }

    public static void saveProduct(){
        completeQuery("INSERT INTO PRODUCT VALUES (999,'toy','for children',60)");
    }

    private static void deleteProducts(){
        completeQuery("DELETE FROM PRODUCT WHERE NAME!='toy'");
    }

    private static void deleteProductsByPrice(){
        completeQuery("DELETE FROM PRODUCT WHERE PRICE<100");
    }

    private static void completeQuery(String sqlQuery) {

        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement statement = connection.createStatement()) {


            int response = statement.executeUpdate(sqlQuery);


        } catch (SQLException e) {
            System.out.println("Something went wrong");
            e.printStackTrace();
        }


    }


}
