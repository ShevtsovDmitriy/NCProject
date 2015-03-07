package DBConnection;

import Bank.*;

/**
 * Created by Дмитрий on 07.03.2015.
 */
public class UserDAO implements BankObjectDAO {

    public static User getObject(){
        DBObject obj = DBAPI.getObject();

        User result = new User(null, (String)obj.getAttributeByName("name"), User.userType.simpleClient, (String)obj.getAttributeByName("address"));
        return result;

    }

}
