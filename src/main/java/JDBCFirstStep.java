import java.sql.*;

public class JDBCFirstStep {

    private static final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
    private static final String DB_URL = "jdbc:oracle:thin:@gromcod-lessons.cxsivpl79ocf.us-east-1.rds.amazonaws.com:1521:ORCL";

    private static final String USER = "main";
    private static final String PASS = "main1gromcod2main";

    public static void main(String[] args) {

        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement statement = connection.createStatement()) {
            //1. DB Driver
            //2. create connection
            //3. create query
            //4. execute query
            //5. work with result
            //6. close all the connection


            try {
                Class.forName(JDBC_DRIVER);
            } catch (ClassNotFoundException e) {
                System.out.println("Class " + JDBC_DRIVER + " not found");
                return;
            }

            try (ResultSet resultSet = statement.executeQuery("SELECT * FROM TEST")) {
                while (resultSet.next()) {
                    System.out.println("Object found");
                }
            }

        } catch (SQLException e) {
            System.out.println("Something went wrong");
            e.printStackTrace();
        }


    }


}
