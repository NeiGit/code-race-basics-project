package ejercicios.clase4.ex4;

/*
4 - Billetera, convertir a objetos:
- Agregar atributos cbu, país, tipo: persona/empresa, tipo de cuenta: regular/vip, fecha (LocalDateTime.now()).
- Agregar atributo Lista de transacciones, en principio vacía. Una Transacción tiene un tipo de operación transferencia/depósito y un monto. Cada vez que se hace una transacción debe sumarse a la lista.
- Muestra balance
- Para mayor seguridad se pide utilizar una nueva Calculadora en todas las operaciones

Estas mejoras hacen que la billetera parezca más una cuenta bancaria. Tener en cuenta para lo que sigue!

Extra: Eliminar atributo balance y resolver showBalance() utilizando la lista de transacciones.

 */

/*
  18- Billetera
    Ingresar un monto inicial de balance (double).
    Ingresar operación: 1 = ingreso, 2 = extracción, 3 = terminar.
    Si se elige ingreso, ingresar un monto y descontarle el 30% de ganancias (redondear a entero). Sumar al balance
    Si se elige extracción, ingresar un monto y descontarlo del balance. No puede bajar de 0.
    Al finalizar mostrar el balance.
public static void exercise18() {
        double balance = doubleInput("Ingrese un balance inicial de billetera");

        WalletOperation walletOperation = WalletOperation.promptChoice();

        while (walletOperation != WalletOperation.END) {
        if (walletOperation == WalletOperation.DEPOSIT) {
final double depositAmount = doubleInput("Ingrese monto a depositar", d -> d > 0);
final int tax = (int) Calculator.calculate(depositAmount, 30, Calculator.CalculatorOperation.PERCENTAGE);

        balance += (depositAmount - tax);
        print(String.format("Se han depositado exitosamente $%s", depositAmount));

        } else if (walletOperation == WalletOperation.EXTRACTION) {
final double extractionAmount = doubleInput("Ingrese monto a extraer", d -> d > 0);

        if (extractionAmount <= balance) {
        balance -= extractionAmount;
        print(String.format("Se han extraido exitosamente $%s", extractionAmount));
        } else {
        print("Fondos insuficientes para realizar la extracción");
        }
        }

        print(String.format("Balance: $%s", balance));

        walletOperation = WalletOperation.promptChoice();
        }
        }
 */

import ejercicios.clase4.Calculator;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

// - Agregar atributos cbu, país, tipo: persona/empresa, tipo de cuenta: regular/vip, fecha (LocalDateTime.now()).
public class Wallet {
    private static final int TAX_PERCENTAGE = 30;

    private long cbu;
    private String country;
    private ClientType clientType;
    private WalletType walletType;
    private LocalDateTime dateCreated;
    private List<WalletTransaction> transactions;

    public Wallet(long cbu,
                  String country,
                  ClientType clientType,
                  WalletType walletType) {

        this.cbu = cbu;
        this.country = country;
        this.clientType = clientType;
        this.walletType = walletType;

        this.dateCreated = LocalDateTime.now();
        this.transactions = new ArrayList<>();
    }

    public double showBalance() {
        double totalDeposited = 0;
        double totalExtracted = 0;

        for (WalletTransaction transaction : transactions) {
            final WalletOperation operation = transaction.getOperation();
            final double amount = transaction.getAmount();

            if (operation == WalletOperation.DEPOSIT) {
                totalDeposited += amount;
            } else if (operation == WalletOperation.EXTRACTION) {
                totalExtracted += amount;
            }
        }

        return totalDeposited - totalExtracted;
    }

    public void deposit(double amount) {
        final Calculator taxCalculator = new Calculator(amount, TAX_PERCENTAGE);
        final double taxReduction = taxCalculator.percentage();

        final Calculator reductionCalculator = new Calculator(amount, taxReduction);

        final double depositAmount = reductionCalculator.subtract();

        this.transactions.add(new WalletTransaction(WalletOperation.DEPOSIT, depositAmount));
    }

    public void extract(double amount) throws WalletException {
        if (amount > this.showBalance()) {
            throw new WalletException("Insufficient founds");
        }

        this.transactions.add(new WalletTransaction(WalletOperation.EXTRACTION, amount));
    }

    public long getCbu() {
        return cbu;
    }


    public static final class WalletException extends Exception {
        private WalletException(String message) {
            super(message);
        }
    }

    public static class Builder {
        private long cbu;
        private String country;
        private ClientType clientType;
        private WalletType walletType;

        public Wallet build() {
            return new Wallet(cbu, country, clientType, walletType);
        }

        public Builder setCbu(long cbu) {
            this.cbu = cbu;
            return this;
        }

        public Builder setCountry(String country) {
            this.country = country;
            return this;
        }

        public Builder setClientType(ClientType clientType) {
            this.clientType = clientType;
            return this;
        }

        public Builder setWalletType(WalletType walletType) {
            this.walletType = walletType;
            return this;
        }
    }
}

