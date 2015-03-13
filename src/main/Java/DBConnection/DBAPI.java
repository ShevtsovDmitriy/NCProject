package DBConnection;

import Bank.User;

import java.math.BigInteger;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Дмитрий on 07.03.2015.
 * Чтение объектов из базы
 */
public class DBAPI {

    //возвращает объект с указанным ID в виде DBObject`а
    public static DBObject getObject(BigInteger id){
        ArrayList<Object> params = new ArrayList<>();
        params.add(id);


        return DBTools.executeSelect("select o.Object_id, O.Name, a.NAME attr_name, a.ATTR_TYPE, p.Value, p.DATA_VALUE, p.CLOB_VALUE, r.REFERENCE" +
                "  from Objects O " +
                "  left JOIN ATT_OBJ_TYPES aot on  O.OBJECT_TYPE_ID = aot.OBJECT_TYPE_ID" +
                "  LEFT join ATTRIBUTES a on aot.ATTRIBUTE_ID = a.ATTRIBUTE_ID" +
                "  left join  Params p on p.OBJECT_ID = O.OBJECT_ID and p.ATTRIBUTE_ID = a.ATTRIBUTE_ID" +
                "  left join REFERENCES r on r.OBJECT_ID = O.OBJECT_ID and r.ATTRIBUTE_ID = aot.ATTRIBUTE_ID" +
                "  where O.OBJECT_ID = ? ", params, new ResultSetHandler<DBObject>() {
            @Override
            public DBObject handle(ResultSet rs) {
                DBObject result;
                HashMap<String, Object> params = new HashMap<>();
                try {
                    rs.next();

                    params.put("name", rs.getString("NAME"));
                    do {
                        if (rs.getInt("ATTR_TYPE") == 0){
                            params.put(rs.getString("ATTR_NAME"), rs.getString("VALUE"));
                        }
                        if (rs.getInt("ATTR_TYPE") == 1) {
                            params.put(rs.getString("ATTR_NAME"), new Integer(rs.getString("VALUE")));
                        }
                        if (rs.getInt("ATTR_TYPE") == 2) {
                            params.put(rs.getString("ATTR_NAME"), rs.getString("DATE_VALUE"));
                        }
                        if (rs.getInt("ATTR_TYPE") == 3) {
                            params.put(rs.getString("ATTR_NAME"), rs.getString("REFERENCE"));
                        }
                        if (rs.getInt("ATTR_TYPE") == 5) {
                            params.put(rs.getString("ATTR_NAME"), rs.getString("CLOB_VALUE"));
                        }
                    } while (rs.next());
                    result = new DBObject(rs.getInt("OBJECT_ID"), DBObject.objectType.User, params);
                    return result;
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return null;
            }
        });
    }

}
