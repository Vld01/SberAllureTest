package ru.appline.base;
import io.qameta.allure.Allure;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import ru.appline.framework.managers.InitManager;
import ru.appline.framework.managers.PageManager;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static ru.appline.framework.managers.DriverManager.getDriver;
import static ru.appline.framework.managers.InitManager.props;
import static ru.appline.framework.utils.PropConst.APP_URL;

public class BaseTests {

    /**
     * Менеджер страниц
     * @see PageManager#getPageManager()
     */
    protected PageManager app = PageManager.getPageManager();

    @BeforeClass
    public static void beforeAll() {
        InitManager.initFramework();
    }

    @Before
    public void beforeEach(){
        getDriver().get(props.getProperty(APP_URL));
    }

    @AfterClass
    public static void afterAll() {
        InitManager.quitFramework();
    }

}
