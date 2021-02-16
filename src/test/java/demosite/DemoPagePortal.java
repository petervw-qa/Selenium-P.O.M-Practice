package demosite;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DemoPagePortal {

    @FindBy(xpath = "/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[3]")
    private WebElement addUser_lnk;

    @FindBy(xpath = "/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[4]")
    private WebElement loginUser_link;

    public DemoPagePortal(WebDriver webDriver) {

    }

    public void addUser() {
        addUser_lnk.click();
    }

    public void loginUser() {
        loginUser_link.click();
    }

}
