import java.sql.*;

public class JDBCExamples {

    private static final String DB_URL = "jdbc:oracle:thin:@gromcod-lessons.cxsivpl79ocf.us-east-1.rds.amazonaws.com:1521:ORCL";
    private static final String USER = "main";
    private static final String PASS = "main1gromcod2main";

    public static void main(String[] args) {

        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement statement = connection.createStatement()) {

//            boolean res = statement.execute("INSERT INTO PRODUCT VALUES (7,'toy2','for children',60)");
//            System.out.println(res);

//            boolean res = statement.execute("DELETE FROM PRODUCT WHERE NAME='toy2'");
//            System.out.println(res);

            int response = statement.executeUpdate("DELETE FROM PRODUCT WHERE NAME='toy2'");
            System.out.println(response);

        } catch (SQLException e) {
            System.out.println("Something went wrong");
            e.printStackTrace();
        }


    }


}
