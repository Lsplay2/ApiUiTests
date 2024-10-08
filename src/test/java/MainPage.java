import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

/**
 * Main page - https://appleinsider.ru/
 */

public class MainPage {

    private final SelenideElement searchButton = $x("//form");

    public MainPage(String url) {
        Selenide.open(url);
    }

    public void clickOnSearch() {
        searchButton.click();
    }


}
