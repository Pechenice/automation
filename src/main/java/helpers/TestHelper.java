package helpers;

import pages.HomeLoggedPage;
import pages.HomeUnloggedPage;

import java.util.Random;

public class TestHelper {
    public HomeLoggedPage logIn(String userLogin, String userPassword) {
        HomeUnloggedPage startUnloggedPagePage = new HomeUnloggedPage();
        return startUnloggedPagePage.goToLoginPage().logIn(userLogin, userPassword);
    }

    public static String stringGenerator(String generated) {
        Random random = new Random();
        for (int i=0; i<5; i++) {
            char lowSymbols = (char) (random.nextInt(25)+97);
            char highSymbols = (char) (random.nextInt(25)+65);
            int number = random.nextInt(100);
            generated = generated + lowSymbols + number + highSymbols;
        }
        return generated;
    }
}
