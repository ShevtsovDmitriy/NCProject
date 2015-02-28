package DBConnection;

import java.util.HashMap;

/**
 * Created by Дмитрий on 28.02.2015.
 */
public class DBObject {

    public static enum objectType {User, Accaunt, Credit }

    private long ID;
    private objectType type;
    private String info;
    private HashMap<String, Object> attributes;

    public DBObject(long ID, objectType type, HashMap<String, Object> attributes) {
        this.ID = ID;
        this.type = type;
        this.attributes = attributes;
    }

    public long getID() {
        return ID;
    }

    public objectType getType() {
        return type;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public HashMap<String, Object> getAttributes() {
        return attributes;
    }

    public Object getAttributeByName(String attrName){
        if (attributes.containsKey(attrName))
            return attributes.get(attrName);
        return null;
    }
}
