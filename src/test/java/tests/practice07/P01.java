package tests.practice07;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.WebUniversityPage;
import utilities.Driver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P01 {
     // https://webdriveruniversity.com/To-Do-List/index.html adresine gidin
    // Todos ekle : (Kahvaltiyi hazirla, Bulasiklari yika, Bebekle ilgilen, Cocugun odevine yardim et, Selenium calis, Uyu)
    // Tum yapilacaklarin uzerini ciz
    // Tum yapilacaklari sil
    // Tum yapilacaklarin silindigini dogrulayin

    /* EXPLORATORY testing : Keşif Testi (Exploratory Testing) , test senaryolarının önceden oluşturulmadığı,

     testçilerin sistemi test anında kontrol ettiği bir tür yazılım testidir.

     */

    @Test
    public void test01() {

        // https://webdriveruniversity.com/To-Do-List/index.html adresine gidin
        Driver.getDriver().get("https://webdriveruniversity.com/To-Do-List/index.html");

        // Todos ekle : (Kahvaltiyi hazirla, Bulasiklari yika, Bebekle ilgilen, Cocugun odevine yardim et, Selenium calis, Uyu)
        WebUniversityPage webUniversityPage = new WebUniversityPage();

        /*
            Buradaki listeyi yapilacaklar listesine tek tek manuel olarak eklemek yerine toplu olarak bir loop kullanarak
            ggöderebilmek amaciyla biz olusturduk
         */
        List<String> workList = new ArrayList<>(Arrays.asList("Kahvaltıyı hazırla","Bulaşıkları yıka","Bebekle ilgilen","Çocuğun ödevine yardım et","Selenium çalış","Uyu"));

        Actions actions = new Actions(Driver.getDriver());

        for (String w:workList) {
            actions.click(webUniversityPage.adNewTodo).sendKeys(w).sendKeys(Keys.ENTER).perform();
        }

        // Tum yapilacaklarin uzerini ciz
        List<WebElement>todos= webUniversityPage.todosWebElement;
        for (WebElement w: todos) {
            w.click();

        }

        // Tum yapilacaklari sil
        List<WebElement> deleteButtons = webUniversityPage.deleteButtonsWebElement;
        for (WebElement w: deleteButtons) {
            w.click();
        }

        // Tum yapilacaklarin silindigini dogrulayin
        List<WebElement>newtodos = webUniversityPage.newtodosWebElement;
        Assert.assertEquals(0,newtodos.size());











    }
}
