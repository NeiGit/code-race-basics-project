package ejercicios.clase4.ex3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static ejercicios.clase4.ex3.BolsonTestFixture.*;
import static ejercicios.clase4.ex3.BolsonTestFixture.bananaFresh;
import static org.junit.jupiter.api.Assertions.*;

class BolsonTest {

    @Test
    @DisplayName("addFood | ok")
    void addFood() {
        final Bolson bolson = new Bolson();

        bolson.addFood(bananaFresh, 5);
        bolson.addFood(bananaRipe, 3);
        bolson.addFood(potato, 4);
        bolson.addFood(appleGreen, 1.5);
        bolson.addFood(appleGreen2, 2);
        bolson.addFood(potato2, 2);
        bolson.addFood(carrot, 2);

        bolson.addFood(bananaFresh, 3); // should not be added

        final Map<Food, Double> kgByFood = bolson.getKgByFood();

        assertAll("Expected bolson",
                () -> assertEquals(5, kgByFood.size()),
                () -> assertEquals(5, kgByFood.get(bananaFresh)),
                () -> assertEquals(3, kgByFood.get(bananaRipe)),
                () -> assertEquals(6, kgByFood.get(potato)),
                () -> assertEquals(3.5, kgByFood.get(appleGreen)),
                () -> assertEquals(2, kgByFood.get(carrot))
        );
    }

    @Test
    @DisplayName("getFinalPrice | ok")
    void getFinalPrice() {
        final Bolson bolson = new Bolson();

        bolson.addFood(bananaFresh, 5); // 750
        bolson.addFood(bananaRipe, 3); // 382.5
        bolson.addFood(potato, 6); // 480
        bolson.addFood(appleGreen, 1.5); // 315
        bolson.addFood(appleGreen2, 2);
        bolson.addFood(carrot, 2); // 60

        final double finalPrice = bolson.getFinalPrice();

        assertEquals(1987.5, finalPrice);
    }
}