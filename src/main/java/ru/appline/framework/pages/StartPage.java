package ru.appline.framework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class StartPage extends BasePage {
    @FindBy(xpath = "//a[@aria-label='Ипотека']")
    WebElement mortgageElement;

    @FindBy(xpath = "//a[text()='Ипотека на готовое жильё' and contains(@class, 'link_second')]")
    WebElement mortgageCompleteHouseElement;

    @FindBy(xpath = "//div[(@class = 'kitt-top-menu__pointer kitt-top-menu__pointer_icons ' and contains(@style, 'opacity: 1'))]")
    List<WebElement> mortgageCheckSumMenuElement;

    @FindBy(xpath = "//h1[contains(@class, 'head')]")
    List<WebElement> mortgageHeaderElement;



    /**
     * Функция выбора из подменю ипотеки на готовое жильё
     *
     * @return SearchPage - т.е. переходим на страницу {@link ru.appline.framework.pages.MortgagePage}
     */
    public MortgagePage choiceMortgageCompleteHouse(){
        elementToBeClickable(mortgageElement).click();
        assertFalse(mortgageCheckSumMenuElement.isEmpty(), "Подменю не отобразилось");
        elementToBeClickable(mortgageCompleteHouseElement).click();
        assertEquals("Ипотека от 7,3%* на готовые квартиры", mortgageHeaderElement.get(0).getText(),
                "Заголовок отсутствует/не соответствует требуемому");
        return app.getMortgagePage();
    }
}
