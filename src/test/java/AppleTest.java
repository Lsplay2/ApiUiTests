
import com.codeborne.selenide.SelenideElement;
import org.junit.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class AppleTest  {

    private final static String BASE_URL = "https://appleinsider.ru/";


    @Test
    public void checkInput() {
        open("https://jut.su/");

        SelenideElement searchbox = $x("//input[@name = 'ystext']");

        searchbox.setValue("Гоблин");
        searchbox.pressEnter();

        SelenideElement firstResult = $x("//h1[@class = 'header_video allanimevideo anime_padding_for_title']");
        firstResult.shouldHave(text("Смотреть Перерождение: Монстр все серии"));
    }

    @Test
    public void checkVisible() {
        open("https://jut.su/");

        SelenideElement element = $x("//a[@class = 'yt_i circle']");
        element.shouldBe(visible);
    }

    @Test
    public void checkHref() {
        open("https://animego.org/");

        SelenideElement clickSearch = $(By.id("navbar-search"));
        clickSearch.click();
        SelenideElement inputElement = $x("//input[@placeholder= 'Поиск аниме, манги, людей и персонажей']");
        inputElement.setValue("Магия");
        inputElement.pressEnter();

        SelenideElement firstElement = $x("//div[@class = 'animes-grid-item col-6 col-sm-6 col-md-4 col-lg-3 col-xl-2 col-ul-2']");
        firstElement.shouldHave(text("Магия Стеллы"));
        int i = 0;
    }

}
