package DBConnection;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Дмитрий on 06.02.2015.
 */
public class MyResultSetHandler implements ResultSetHandler<ResultSet> {

    @Override
    public ResultSet handle(ResultSet rs) {
        return rs;
    }
}
