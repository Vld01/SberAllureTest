package ru.appline.tests;

import org.junit.jupiter.api.Test;
import ru.appline.base.BaseTests;

public class SberAllureTest extends BaseTests {

    @Test
    public void mortgageInSberTest(){
        app.getStartPage()
                .choiceMortgageCompleteHouse()
                .fillField("Стоимость недвижимости", 5_180_000)
                .fillField("Первоначальный взнос", 3_058_000)
                .fillField("Срок кредита", 30);

    }
}
