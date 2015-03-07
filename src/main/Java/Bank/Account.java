package Bank;

import java.sql.Date;

/**
 * Created by Дмитрий on 05.03.2015.
 */
public class Account {

    private double amount;
    private Date startDate;

    public Account(double amount, Date startDate) {
        this.amount = amount;
        this.startDate = startDate;
    }
}
