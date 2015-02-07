package DBConnection;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBTools {

    public static DataSource source;

    static {
        try {
            source = InitialContext.doLookup("java:/jdbc/MyDB");
        } catch (NamingException e) {
            e.printStackTrace();
            System.out.print("\nCan`t open connection to database\n");
        }
    }

    public static <T> T executeSelect(String query, ResultSetHandler<T> handler){
        ResultSet rs;

        if (query.contains(";")){
            System.out.print("\nInvalid query. Unexpected ';'");
            return null;
        }

        try (Connection connection = source.getConnection();
             java.sql.Statement st = connection.createStatement() ) {
            rs = st.executeQuery(query);
            return handler.handle(rs);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.print("\nCan`t execute query");
        }
        return null;
    }

    public static int executeOtherDMLQuery(String query){
        if (query.contains(";")){
            System.out.print("\nInvalid query. Unexpected ';'.");
            return 0;
        }
        if (query.toLowerCase().contains("select")){
            System.out.print("\nInvalid query. Use executeSelect method.");
            return 0;
        }

        try (Connection connection = source.getConnection();
             java.sql.Statement st = connection.createStatement() ) {
            return st.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.print("\nCan`t execute query");
        }
        return 0;
    }





}
