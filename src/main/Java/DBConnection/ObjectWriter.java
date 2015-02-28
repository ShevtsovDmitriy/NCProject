package DBConnection;

/**
 * Created by Дмитрий on 21.02.2015.
 */
public class ObjectWriter {

    public static void writeObjectToDB(Object src){

        String query = "";



        DBTools.executeOtherDMLQuery(query);
    }
}
