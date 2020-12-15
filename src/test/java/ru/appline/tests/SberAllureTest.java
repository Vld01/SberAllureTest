package ru.appline.tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import ru.appline.base.BaseTests;
import ru.appline.framework.utils.MyAllureListener;

public class SberAllureTest extends BaseTests {

    @Test
    public void mortgageInSberTest(){
        app.getStartPage()
                .choiceMortgageCompleteHouse()
                .checkActualPage()
                .fillField("Стоимость недвижимости", 5_180_000)
                .fillField("Первоначальный взнос", 3_058_000)
                .fillField("Срок кредита", 30)
                .fillCheckbox("Скидка 0,3% при покупке квартиры на ДомКлик", "false")
                .fillCheckbox("Страхование жизни", "false")
                .fillCheckbox("Молодая семья", "true")
                .fillCheckbox("Электронная регистрация сделки", "false")
                .checkFieldValue("Сумма кредита", "2 122 000")
                .checkFieldValue("Ежемесячный платеж", "16 922")
                .checkFieldValue("Необходимый доход", "21 784")
                .checkFieldValue("Процентная ставка", "11%");

    }
}
