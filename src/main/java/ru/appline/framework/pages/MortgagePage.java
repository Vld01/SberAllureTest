package ru.appline.framework.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.junit.jupiter.api.Assertions.*;


public class MortgagePage extends BasePage {
    @FindBy(xpath = "//div[(@data-label=\"Стоимость недвижимости\")]/input")
    WebElement priceHouseElement;

    @FindBy(xpath = "//div[(@data-label=\"Первоначальный взнос\")]/input")
    WebElement firstPaymentElement;

    @FindBy(xpath = "//div[(@data-label=\"Срок кредита\")]/input")
    WebElement loanPeriodElement;

    /**
     * Метод заполнения полей
     *
     * @param nameField - имя веб элемента, поля ввода
     * @param value     - значение вводимое в поле
     * @return MortgagePage - т.е. остаемся на этой странице
     */
    @Step("Заполняем поле '{nameField}' значение '{value}'")
    public MortgagePage fillField(String nameField, int value) {
        WebElement element = null;
        switch (nameField) {
            case "Стоимость недвижимости":
                fillInputField(priceHouseElement, value);
                element = priceHouseElement;
                break;
            case "Первоначальный взнос":
                fillInputField(firstPaymentElement, value);
                element = firstPaymentElement;
                break;
            case "Срок кредита":
                fillInputField(loanPeriodElement, value);
                element = loanPeriodElement;
                break;
            default:
                fail("Поле с наименованием '" + nameField + "' отсутствует на странице " +
                        "'Ипотека на готовое жилье'");

        }
        assertEquals(value, Integer.parseInt(element.getAttribute("value")), "Поле '" + nameField + "' было заполнено некорректно");
        return this;
    }


}
