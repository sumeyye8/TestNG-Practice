package tests.practice09;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SearchProductPage;
import utilities.Driver;
import utilities.TestBaseRapor;

import java.util.List;

public class SearchProductTest extends TestBaseRapor {

    // 1. Tarayiciyi baslat
    // 2. http://automationexercise.com url'ine gidin
    // 3. Ana sayfanin basariyla gorunur oldugunu dogrulayin
    // 4. Urunler butonuna tiklayin
    // 5. Kullanicinin Tum Urunler sayfasina basariyla gittigini dogrulayin
    // 6. Arama girisine urun adini girin ve Ara dugmesine tiklayin
    // 7. Aranan Urunler'in gorunur oldugunu dogrulayin
    // 8. Aramayla ilgili urunun ("blue top") gorunur oldugunu dogrulayin


    SearchProductPage searchProductPage;
    Actions actions = new Actions(Driver.getDriver());

    @Test
    public void searchProductPage() throws InterruptedException{

        extentTest = extentReports.createTest("automationexercise", "web automation");

        // 1. Tarayiciyi baslat
        // 2. http://automationexercise.com url'ine gidin
        extentTest.info("  // 1. Tarayiciyi baslat\n" +
                "        // 2. http://automationexercise.com url'ine gidin");

        Driver.getDriver().get("http://automationexercise.com");

        // 3. Ana sayfanin basariyla gorunur oldugunu dogrulayin
        extentTest.info("3. Ana sayfanin basariyla gorunur oldugunu dogrulayin");

         // String homeUrl = "http://automationexercise.com";
        // Assert.assertEquals(Driver.getDriver().getCurrentUrl(), homeUrl);


        searchProductPage = new SearchProductPage();

        // 4. Urunler butonuna tiklayin

        extentTest.info("4. Urunler butonuna tiklayin");
        searchProductPage.products.click();


        // 5. Kullanicinin Tum Urunler sayfasina basariyla gittigini dogrulayin
        extentTest.info("5. Kullanicinin Tum Urunler sayfasina basariyla gittigini dogrulayin");

        Assert.assertTrue(searchProductPage.allProductTitle.isDisplayed());

        String productPageUrl = "http://automationexercise.com";
        Assert.assertEquals(Driver.getDriver().getCurrentUrl(),productPageUrl);

        // 6. Arama girisine urun adini girin ve Ara dugmesine tiklayin

        extentTest.info("6. Arama girisine urun adini girin ve Ara dugmesine tiklayin");
        searchProductPage.searchBox.sendKeys("blue top");
        searchProductPage.searchButton.click();

        actions.click(searchProductPage.searchButton).click().perform();

        // 7. Aranan Urunler'in gorunur oldugunu dogrulayin

        extentTest.info("7. Aranan Urunler'in gorunur oldugunu dogrulayin");

        Assert.assertTrue(searchProductPage.searchedProductTitle.isDisplayed());

        List<WebElement> urunListesi = searchProductPage.searchedProductList;

       /*

        for (WebElement w: urunListesi ) {

            Assert.assertTrue(w.isDisplayed());
            Thread.sleep(500);

        }

        */


        // 8. Aramayla ilgili urunun ("blue top") gorunur oldugunu dogrulayin

        extentTest.pass("8. Aramayla ilgili urunun (\"blue top\") gorunur oldugunu dogrulandi");
        actions.click(searchProductPage.viewProduct).perform();
        Assert.assertTrue(searchProductPage.blueTop.isDisplayed());

    }
}
