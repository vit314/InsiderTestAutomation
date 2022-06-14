package tests;

import base.Base;
import org.testng.annotations.Test;

public class Sokolovskaya_HomeWork_23 extends Base {

    @Test
    public void sauceDemoPositiveLoginTest() throws InterruptedException {

        openPage();

        loginBase();

        addtocart();

        shoppingcart();

        remove();

        reactburgermenu();

        logout();


    }
}
