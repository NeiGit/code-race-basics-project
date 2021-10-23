package ejercicios.clase4.ex4;

public class WalletTransaction {
    private final WalletOperation operation;
    private final double amount;

    public WalletTransaction(WalletOperation operation, double amount) {
        this.operation = operation;
        this.amount = amount;
    }

    public WalletOperation getOperation() {
        return operation;
    }

    public double getAmount() {
        return amount;
    }
}
