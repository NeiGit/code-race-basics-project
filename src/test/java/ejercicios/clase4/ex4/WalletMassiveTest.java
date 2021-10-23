package ejercicios.clase4.ex4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WalletMassiveTest {

    @Test
    @DisplayName("Massive creation | ok")
    void massiveCreationOk() {
        final List<Wallet> wallets = new ArrayList<>();

        final Wallet.Builder builder = new Wallet.Builder();

        builder
                .setClientType(ClientType.PERSON)
                .setCountry("ARG")
                .setWalletType(WalletType.REGULAR);

        for (int i = 1; i <= 10; i ++) {
            builder.setCbu(i);

            final Wallet wallet = builder.build();

            wallets.add(wallet);
        }

        assertEquals(10, wallets.size());

        for (int i = 1; i <= 10; i ++) {
            final long cbu = i;

            assertTrue(wallets.stream().anyMatch(wallet -> wallet.getCbu() == cbu));
        }
    }
}