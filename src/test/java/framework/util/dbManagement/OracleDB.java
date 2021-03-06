package framework.util.dbManagement;

import framework.util.propertyManagement.PayPlusProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.sql.*;

/**
 * Created by karthik.m on 6/26/2018.
 */

/**
 * Created by rahul.rana on 5/4/2017.
 */
public class OracleDB {
    private static Connection connection;
    private String url, username, password;
    private Statement stmt;
    public ResultSet rset;
    PayPlusProperties properties = PayPlusProperties.getInstance();

    private static final Logger LOGGER = LoggerFactory.getLogger(OracleDB.class);

    public OracleDB() {
//        url = "jdbc:oracle:thin:@" + properties.getProperty("db.ip") + ":" + properties.getProperty("db.port") + ":" + properties.getProperty("db.sid");
        url = "jdbc:postgresql://" + properties.getProperty("db.ip") + ":" + properties.getProperty("db.port") + "/" + properties.getProperty("db.sid");
        username = properties.getProperty("db.username");
        password = properties.getProperty("db.password");
    }

    /**
     * Open DB Connection
     */
    public void OpenDBConnection() {
        try {
            // Load the JDBC driver
//            String driverName = "oracle.jdbc.driver.OracleDriver";
            String driverName = "org.postgresql.Driver";
            Class.forName(driverName);
            // Create a connection to the database
            connection = DriverManager.getConnection(url, username, password);
            stmt = connection.createStatement();
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found from database");
            e.printStackTrace();
        } catch (SQLException e1) {
            System.out.println("ORACLE Connection error ");
            e1.printStackTrace();
        }
    }

    /**
     * Execute a Query
     *
     * @param Query
     * @return
     * @throws IOException
     */
    public ResultSet RunQuery(String Query) throws IOException {
        System.out.print("DQuery:" + Query + "\n");
        try {
            if (connection == null) {
                OpenDBConnection();
            }
            stmt = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rset = stmt.executeQuery(Query);
        } catch (SQLException e1) {
            LOGGER.error("Query Execution Error");
            e1.printStackTrace();
        }
        return rset;
    }

    public ResultSet RunUpdateQuery(String Query) throws IOException {
        LOGGER.info("DQuery:" + Query + "\n");
        try {
            if (connection == null) {
                OpenDBConnection();
            }
            stmt = connection.createStatement();

            int res = stmt.executeUpdate(Query);
            System.out.println(res);
        } catch (SQLException e1) {
            LOGGER.error("Query Execution Error");
            e1.printStackTrace();
        }
        return rset;
    }

    /**
     * Close Oracle connection
     *
     * @throws IOException
     */
    public void CloseConnection() throws IOException {
        try {
            connection.close();
            connection = null;
        } catch (SQLException e1) {
            LOGGER.error("Query Execution Error");
            e1.printStackTrace();
        }
    }
}

