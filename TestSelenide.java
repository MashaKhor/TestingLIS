import com.codeborne.selenide.Condition;
import org.junit.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;

public class TestSelenide {

    @Test
    public void testGoogle() {
        open("https://www.google.ru/");
        $x("//textarea[@name='q']").setValue("Хорьякова Мария Дмитриевна").pressEnter();
        $x("//div[@id='result-stats']").shouldBe(Condition.visible);
    }

    // 1. Проверка наличия логотипа
    @Test
    public void testSushiLogo() {
        // открытие сайта Доставки роллов в Иркустке
        open("https://irkutsk.sushi-studio.ru/");

        $x("//div[@class='col-md-2']").shouldBe(Condition.visible);
        sleep(2000);
    }

    // 2. Проверка работы блока "Новогоднее меню" после нажатия
    @Test
    public void testSushiNewYear()
    {
        open("https://irkutsk.sushi-studio.ru/");

        $x("//div[@class='c-item-wrapper col-8 col-md-4 id-0']").click();
        $x("//div[@class='flex q-gutter-y-sm items-center full-width']").shouldBe(Condition.visible);
        sleep(2000);
    }

    // 3. Проверка открытия товара после клика
    @Test
    public void testSushiTov()
    {
        open("https://irkutsk.sushi-studio.ru/");

        $x("//div[@class='c-item-wrapper col-8 col-md-4 id-0']").click();
        $x("//div[@class='i-row-holder']").click();
        $x("//div[@class='col-24 col-md-11']").shouldBe(Condition.visible);
        sleep(2000);
    }

    // 4. Проверка показа подсказки после наведения
    @Test
    public void testSushiHover()
    {
        open("https://irkutsk.sushi-studio.ru/");

        $x("//div[@class='c-item-wrapper col-8 col-md-4 id-0']").click();
        $x("//div[@class='i-content bg-white']").click();
        $x("//div[@class='q-chip row inline no-wrap items-center q-px-sm c-sostav-item text-grey-8 q-chip--colored q-chip--outline']").hover();
        $x("//div[@class='q-chip row inline no-wrap items-center q-px-sm c-sostav-item text-grey-8 q-chip--colored q-chip--outline active']").shouldBe(Condition.visible);
        sleep(2000);
    }

    // 5. Проверка открытия строки поиска
    @Test
    public void testSushiOpenSearch()
    {
        open("https://irkutsk.sushi-studio.ru/");
        sleep(2000);

        $x("//a[@href='/catalog/search.popup']").click();
        $x("//div[@class='s-font-xl text-weight-bold q-mr-auto']").shouldBe(Condition.visible);
        sleep(2000);
    }

    // 6. Ввод в строку поиска значения
    @Test
    public void testSushiSearch()
    {
        open("https://irkutsk.sushi-studio.ru/");
        sleep(2000);

        $x("//a[@href='/catalog/search.popup']").click();
        $x("//input[@class='q-field__input q-placeholder col']").setValue("Сет").pressEnter();
        $x("//div[@class='i-content bg-white']").shouldBe(Condition.visible);
        sleep(2000);
    }

    // 7. Проверка работы ссылки Еще
    @Test
    public void testSushiSpisok()
    {
        open("https://irkutsk.sushi-studio.ru/");
        sleep(2000);

        $x("//button[@class='q-btn q-btn-item non-selectable no-outline item__link q-ml-md --wrapper-dense --icon-same q-btn--flat q-btn--rectangle text-primary q-btn--actionable q-focusable q-hoverable q-btn--dense q-btn-dropdown q-btn-dropdown--simple']").click();
        $x("//div[@class='q-menu q-position-engine scroll']").shouldBe(Condition.visible);
        sleep(2000);
    }

    // 8. Нажать на раздел "Закуски" из списка
    @Test
    public void testClickSpis()
    {
        open("https://irkutsk.sushi-studio.ru/");
        sleep(2000);

        $x("//button[@class='q-btn q-btn-item non-selectable no-outline item__link q-ml-md --wrapper-dense --icon-same q-btn--flat q-btn--rectangle text-primary q-btn--actionable q-focusable q-hoverable q-btn--dense q-btn-dropdown q-btn-dropdown--simple']").click();
        $x("//div[@class='q-item q-item-type row no-wrap q-item--clickable q-link cursor-pointer q-focusable q-hoverable']").click();
        $x("//div[@class='flex no-wrap -items-center full-width']").shouldBe(Condition.visible);
        sleep(2000);
    }


    // 9. Проверка работы ссылки "Вход"
    @Test
    public void testAutor()
    {
        open("https://irkutsk.sushi-studio.ru/");
        sleep(2000);

        $x("//a[@href='/auth']").click();
        $x("//div[@class='dialog-contents no-wrap column q-pb-md q-card']").shouldBe(Condition.visible);
        sleep(2000);
    }

    // 10. Проверка работы трех полос сверху
    @Test
    public void testMenu()
    {
        open("https://irkutsk.sushi-studio.ru/");
        sleep(2000);

        $x("//button[@class='q-btn q-btn-item non-selectable no-outline c-nav-btn q-px-xs  q-btn--flat q-btn--rectangle text-dark q-btn--actionable q-focusable q-hoverable q-btn--wrap q-btn--dense']").click();
        sleep(2000);
    }

    // 11. Проверка выбора из меню пункта "Новости"
    @Test
    public void testNews()
    {
        open("https://irkutsk.sushi-studio.ru/");
        sleep(2000);

        $x("//button[@class='q-btn q-btn-item non-selectable no-outline c-nav-btn q-px-xs  q-btn--flat q-btn--rectangle text-dark q-btn--actionable q-focusable q-hoverable q-btn--wrap q-btn--dense']").click();
        $x("//a[@href='/promotions/']").click();
        $x("//div[@class='flex items-center q-mr-auto']").shouldBe(Condition.visible);
    }

    // 12. Проверка работы ссылки Еще из верхней панели
    @Test
    public void testLinkHead()
    {
        open("https://irkutsk.sushi-studio.ru/");

        $x("//button[@class='q-btn q-btn-item non-selectable no-outline c-nav-btn q-px-xs  q-btn--flat q-btn--rectangle text-dark q-btn--actionable q-focusable q-hoverable q-btn--wrap q-btn--dense']").click();
        $x("//a[@href='/promotions/']").click();
        $x("//div[@class='c-menu q-mb-md gt-md com flex no-wrap items-center --font-size-inherit']").find(By.cssSelector("button")).click();
        $x("//div[@class='q-list']").shouldBe(Condition.visible);
        sleep(2000);
    }

    // 13. Проверка, что работает первая ссылка из выпадающего списка
    @Test
    public void testClickLinkHead()
    {
        open("https://irkutsk.sushi-studio.ru/");

        $x("//button[@class='q-btn q-btn-item non-selectable no-outline c-nav-btn q-px-xs  q-btn--flat q-btn--rectangle text-dark q-btn--actionable q-focusable q-hoverable q-btn--wrap q-btn--dense']").click();
        $x("//a[@href='/promotions/']").click();
        $x("//div[@class='c-menu q-mb-md gt-md com flex no-wrap items-center --font-size-inherit']").find(By.cssSelector("button")).click();
        $x("//div[@class='q-list']").find(By.cssSelector("div")).click();
        sleep(2000);
        $x("//h1[@class='c-title-title leading-e4 q-ma-none s-font-lg s-font-sm-2xl s-font-md-3xl s-font-lg-4xl s-font-xl-6xl text-weight-bolder ']").shouldBe(Condition.text("Камеры"));
        sleep(2000);
    }

    // 14. Проверка работы кнопка "воспользовать каталогом меню"
    @Test
    public void testClickButMenu()
    {
        open("https://irkutsk.sushi-studio.ru/");

        $x("//button[@class='q-btn q-btn-item non-selectable no-outline full-width q-btn--outline q-btn--rectangle text-grey-7 q-btn--actionable q-focusable q-hoverable q-btn--wrap']").click();
        $x("//div[@class='c-item-wrapper col-8 col-md-4 id-0']").shouldBe(Condition.visible);
        sleep(2000);
    }

    // 15. Проверка, что открывается раздел Доставка из меню
    @Test
    public void testClickDevil()
    {
        open("https://irkutsk.sushi-studio.ru/");
        sleep(2000);

        $x("//button[@class='q-btn q-btn-item non-selectable no-outline c-nav-btn q-px-xs  q-btn--flat q-btn--rectangle text-dark q-btn--actionable q-focusable q-hoverable q-btn--wrap q-btn--dense']").click();
        $x("//a[@href='/delivery/']").click();
        sleep(2000);
        $x("//h1[@class='c-title-title leading-e4 q-ma-none s-font-lg s-font-sm-2xl s-font-md-3xl s-font-lg-4xl s-font-xl-6xl text-weight-bolder ']").shouldBe(Condition.text("Доставка и самовывоз"));
        sleep(2000);
    }

    // 16. Проверка работы кнопки "Самовывоз"
    @Test
    public void testClickPickup()
    {
        open("https://irkutsk.sushi-studio.ru/");
        sleep(2000);

        $x("//button[@class='q-btn q-btn-item non-selectable no-outline c-nav-btn q-px-xs  q-btn--flat q-btn--rectangle text-dark q-btn--actionable q-focusable q-hoverable q-btn--wrap q-btn--dense']").click();
        $x("//a[@href='/delivery/']").click();
        sleep(2000);
        $x("//div[@class='q-tab relative-position self-stretch flex flex-center text-center no-outline q-tab--inactive q-focusable q-hoverable cursor-pointer']").click();
        sleep(2000);
        $x("//div[@class='q-list']").shouldBe(Condition.visible);
        sleep(2000);
    }

    // 17. Проверка наведения на элемент в каталоге
    @Test
    public void testHoverCatalog()
    {
        open("https://irkutsk.sushi-studio.ru/");

        $x("//div[@class='c-item-wrapper col-8 col-md-4 id-0']").click();
        $x("//div[@class='c-sostav-item q-px-xs q-px-md-sm q-py-xs text-grey-8 s-font-3xs']").hover();
        $x("//div[@class='q-tooltip q-tooltip--style q-position-engine no-pointer-events']").shouldBe(Condition.visible);
        sleep(2000);
    }

    // 18. Выбор подарка у товара новогоднего меню
    @Test
    public void testChoosePresent()
    {
        open("https://irkutsk.sushi-studio.ru/");

        $x("//a[@href='/catalog/novogodnee-menyu/']").click();
        $x("//div[@class='q-mb-md q-mt-sm']").click();
        $x("//div[@class='q-virtual-scroll__content']").shouldBe(Condition.visible);
        $x("//div[@class='q-virtual-scroll__content']").find(By.cssSelector("div")).click();
        $x("//div[@class='q-field__control-container col relative-position row no-wrap q-anchor--skip']").find(By.cssSelector("span")).shouldBe(Condition.text("Шампанское"));
        sleep(2000);
    }

    // 19. Проверка добавления товара в корзину
    @Test
    public void testAddBasket()
    {
        open("https://irkutsk.sushi-studio.ru/");
        sleep(2000);

        $x("//a[@href='/catalog/novogodnee-menyu/']").click();
        $x("//div[@class='q-mb-md q-mt-sm']").click();
        $x("//div[@class='q-virtual-scroll__content']").find(By.cssSelector("div")).click();
        $x("//div[@class='i-sale q-ml-auto']").click();
        sleep(2000);
    }

    // 20. Проверка очистки корзины
    @Test
    public void testClearBasket()
    {
        open("https://irkutsk.sushi-studio.ru/");
        sleep(2000);

        $x("//a[@href='/catalog/novogodnee-menyu/']").click();
        $x("//div[@class='q-mb-md q-mt-sm']").click();
        $x("//div[@class='q-virtual-scroll__content']").find(By.cssSelector("div")).click();
        $x("//div[@class='i-sale q-ml-auto']").click();
        $x("//a[@href='/cart/clear']").click();
        $x("//button[@class='q-btn q-btn-item non-selectable no-outline full-width s-font-sm s-font-md-md q-btn--unelevated q-btn--rectangle bg-primary text-white q-btn--actionable q-focusable q-hoverable q-btn--wrap']").click();
        sleep(2000);
    }
}
