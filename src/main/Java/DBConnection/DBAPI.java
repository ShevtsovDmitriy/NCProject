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
        DBObject result =  DBTools.executeSelect("select o.Object_id, O.Name, p.Value, p.Attribute_id from Objects " +
                "O left join  Params p on O.Object_id = p.Object_id", new ResultSetHandler<DBObject>() {
            @Override
            public DBObject handle(ResultSet rs) {
                DBObject result;
                HashMap<String, Object> params = new HashMap<String, Object>();
                try {
                    params.put("name", rs.getString("name"));
                    params.put("value", rs.getString("value"));
                    result =  new DBObject(rs.getInt("object_id"), DBObject.objectType.User, params);
                    return result;
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return null;
            }
        });

        User res = new User();
    }

}
