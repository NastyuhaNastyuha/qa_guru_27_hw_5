package github;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class OpenEnterprisePageTests {
    @BeforeAll
    static void setUp() {
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void openEnterprisePage() {
        open("https://github.com/");
        $(".header-menu-wrapper").$(byTagAndText("button", "Solutions")).hover();
        $("[aria-labelledby=\"solutions-for-heading\"]").$(byText("Enterprise")).click();

        $("#hero-section-brand-heading").shouldBe(visible);
        $("#hero-section-brand-heading").shouldHave(text("The AI-powered\n" + "developer platform."));

    }
}
