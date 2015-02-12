package DBConnection;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


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
            java.sql.Statement st = connection.createStatement() ){
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

    public static <T> T executeSelect(String query, ArrayList<Object> params, ResultSetHandler<T> handler){
        ResultSet rs;

        if (query.contains(";")){
            System.out.print("\nInvalid query. Unexpected ';'");
            return null;
        }
        int i = 1;
        try  (Connection connection = source.getConnection();
            java.sql.PreparedStatement st = connection.prepareStatement(query)) {
            for (Object param: params){
                switch (param.getClass().getName()){
                    case "String": {
                        st.setString(i, (String)param);
                        i++;
                    }
                    case "int": {
                        st.setInt(i, (int)param);
                        i++;
                    }
                    case  "Date": {
                        st.setDate(i, (Date) param);
                        i++;
                    }
                    case "Double": {
                        st.setDouble(i, (Double)param);
                        i++;
                    }
                    case "Float": {
                        st.setFloat(i, (Float)param);
                        i++;
                    }
                    case "Long": {
                        st.setLong(i, (Long)param);
                        i++;
                    }
                    default: System.out.print("\nWrong parameter");

                }
            }
            rs = st.executeQuery();
            return handler.handle(rs);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.print("\nCan`t execute query");
        }
        return null;
    }

    public static int executeOtherDMLQuery(String query, ArrayList<Object> params){
        if (query.contains(";")){
            System.out.print("\nInvalid query. Unexpected ';'.");
            return 0;
        }
        if (query.toLowerCase().contains("select")){
            System.out.print("\nInvalid query. Use executeSelect method.");
            return 0;
        }
        int i = 1;
        try  (Connection connection = source.getConnection();
              java.sql.PreparedStatement st = connection.prepareStatement(query)) {
            for (Object param: params){
                switch (param.getClass().getName()){
                    case "String": {
                        st.setString(i, (String)param);
                        i++;
                    }
                    case "int": {
                        st.setInt(i, (int)param);
                        i++;
                    }
                    case  "Date": {
                        st.setDate(i, (Date) param);
                        i++;
                    }
                    case "Double": {
                        st.setDouble(i, (Double)param);
                        i++;
                    }
                    case "Float": {
                        st.setFloat(i, (Float)param);
                        i++;
                    }
                    case "Long": {
                        st.setLong(i, (Long)param);
                        i++;
                    }
                    default: System.out.print("\nWrong parameter");

                }
            }

            return st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.print("\nCan`t execute query");
        }
        return 0;
    }


}
