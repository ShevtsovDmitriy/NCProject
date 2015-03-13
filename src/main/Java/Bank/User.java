package Bank;

/**
 * Created by Дмитрий on 05.03.2015.
 * Пользователь банка
 */
public class User {

    public static enum userType{organization, simpleClient}

    private Account[] accounts;
    private String name;
    private userType type;
    private String address;

    public User(Account[] accounts, String name, userType type, String address) {
        this.accounts = accounts;
        this.name = name;
        this.type = type;
        this.address = address;
    }

    public Account[] getAccounts() {
        return accounts;
    }

    public String getName() {
        return name;
    }

    public userType getType() {
        return type;
    }

    public String getAddress() {
        return address;
    }
}
