package ejercicios.clase4.ex4;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    final List<Wallet> wallets;

    public Bank() {
        this.wallets = new ArrayList<>();
    }

    public void addWallet(Wallet wallet) {
        this.wallets.add(wallet);
    }

    public void deposit(long cbu, double amount) {
        final Wallet wallet = this.findWallet(cbu);

        deposit(wallet, amount);
    }


    public void extract(long cbu, double amount) {
        final Wallet wallet = this.findWallet(cbu);

        extract(wallet, amount);
    }

    private void deposit(Wallet wallet, double amount) {
        wallet.deposit(amount);
    }

    private void extract(Wallet wallet, double amount) {
        try {
            wallet.extract(amount);
        } catch (Wallet.WalletException e) {
            throw new BankException(String.format("Dear customer: %s", e.getMessage()));
        }
    }

    public double showBalance(long cbu) {
        return this.findWallet(cbu).showBalance();
    }

    public void transfer(long cbuOrigin, long cbuDestination, double amount) {
        final Wallet walletOrigin = this.findWallet(cbuOrigin);
        final Wallet walletDestination = this.findWallet(cbuDestination);

        this.extract(walletOrigin, amount);
        this.deposit(walletDestination, amount);
    }

    private Wallet findWallet(long cbu) {
/*        Wallet wallet = null;
        int index = 0;

        while(wallet == null && index < wallets.size()) {
            final Wallet w = wallets.get(index);

            if (w.getCbu() == cbu) {
                wallet = w;
            }

            index ++;
        }*/
        return wallets.stream()
                .filter(w -> w.getCbu() == cbu)
                .findFirst()
                .orElseThrow(() -> new BankException("Wallet not found"));
    }

    public static final class BankException extends RuntimeException {
        private BankException(String message) {
            super(message);
        }
    }
}
