package Bank;

/**
 * Created by Дмитрий on 05.03.2015.
 * Информация о транзакции
 */
public class Transaction {

    public static enum transactionStatus {waiting, inProgress, success, fail}

    private Account src;
    private Account target;
    private double summ;
    private transactionStatus status;

    public Transaction(Account src, Account target, double summ) {
        this.src = src;
        this.target = target;
        this.summ = summ;
    }

    public Account getSrc() {
        return src;
    }

    public Account getTarget() {
        return target;
    }

    public double getSumm() {
        return summ;
    }

    public transactionStatus getStatus() {
        return status;
    }
}
