package tests.practice08;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HerokuTestPage;
import utilities.Driver;

import java.util.List;

public class P01 {

    // Go to https://testpages.herokuapp.com/styled/events/javascript-events.html
    // Click all the buttons and verify they are all clicked

    HerokuTestPage herokuTestPage;  // page'i class'ta olusturup @Test asamasinda atama yaparsak daha sade kod elde ederiz
    Actions actions = new Actions(Driver.getDriver());

    @Test
    public void test01() throws InterruptedException {

        // Go to https://testpages.herokuapp.com/styled/events/javascript-events.html
        Driver.getDriver().get("https://testpages.herokuapp.com/styled/events/javascript-events.html");

        // Click all the buttons and verify they are all clicked
        herokuTestPage = new HerokuTestPage();

            /*
                kodlarimizi yazarken clean code kapsaminda sade kod yazabilmek amaci ile her test methodu icerisinde
                ayri bir object create etmektense bu objecti class seviyesinde instance olarak create edip
                test methodlarinda buna deger atamak ve kullanmak daha uygun bir yontemdir
             */

        herokuTestPage.onblur.click();
        herokuTestPage.onclick.click();
        herokuTestPage.onclick.click();
        actions.contextClick(herokuTestPage.contextmenu).   // sag tiklamakla ilgili
                doubleClick(herokuTestPage.doubleclick).    // cift tiklamakla ilgili
                click(herokuTestPage.onfocus).              // tek tiklamakla ilgili
                click(herokuTestPage.keydown).             // tikladiktan sonra klavyeye basmakla ilgili
                sendKeys(Keys.ENTER).
                click(herokuTestPage.keyup).              // tikladiktan sonra klavyeye basmakla ilgili
                sendKeys(Keys.ENTER).
                click(herokuTestPage.keypress).          // tikladiktan sonra klavyeye basmakla ilgili
                sendKeys(Keys.ENTER).
                moveToElement(herokuTestPage.mouseover).
                moveToElement(herokuTestPage.mouseleave).
                moveToElement(herokuTestPage.mouseover).
                click(herokuTestPage.mousedown).perform();

        Thread.sleep(2000);

    }

    @Test (dependsOnMethods = "test01") // bu testi (test02) calistirmadan once bagli oldu testi(test01) calistir ve sonra bunu calistir
    public void test02() {

        List<WebElement> clicked = herokuTestPage.eventTriggered;   // clicked olması gereken actual, expected (11) ise benim bekledigim.
        Assert.assertEquals(11,clicked.size()); // ilgili page'e git, tetiklenen kac web element varsa listeye koy ve listeyi bana dondur.
        // Eger 11 ise Event Triggered'a eşitse test basarili demektir


    }
}
