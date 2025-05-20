package objectrepository;

import org.openqa.selenium.WebDriver;

public class objectrepo_initialize {

    public cartpage cp;
    public Inventoryitempage iip;
    public Inventorypage ip;
    public LoginPage lp;

    public objectrepo_initialize(WebDriver driver) {
        cp = new cartpage(driver);
        iip = new Inventoryitempage(driver);
        ip = new Inventorypage(driver);
        lp = new LoginPage(driver);
    }
}
