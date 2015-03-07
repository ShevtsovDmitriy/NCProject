package DBConnection;

import Bank.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

/**
 * Created by Дмитрий on 07.03.2015.
 */
public class DBAPI {

    public static <T> T getObject(){
        DBObject result =  DBTools.executeSelect("select o.Object_id, O.Name, p.Value, a.NAME attr_name  " +
                "from Objects O left join  Params p on O.Object_id = p.Object_id " +
                "left join ATTRIBUTES a on p.ATTRIBUTE_ID = a.ATTRIBUTE_ID ", new ResultSetHandler<DBObject>() {
            @Override
            public DBObject handle(ResultSet rs) {
                DBObject result;
                HashMap<String, Object> params = new HashMap<String, Object>();
                System.out.print("\n" + "something in handler" + "\n");

                try {
                    rs.next();

                    params.put("name", rs.getString("NAME"));
                    do {
                        params.put(rs.getString("ATTR_NAME"), rs.getString("VALUE"));
                        result = new DBObject(rs.getInt("OBJECT_ID"), DBObject.objectType.User, params);
                    } while (rs.next());
                    return result;
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return null;
            }
        });




        return (T)result;
    }

}
