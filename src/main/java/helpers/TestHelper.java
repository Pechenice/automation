package helpers;

import pages.StartLoggedPage;
import pages.StartUnloggedPage;

import java.util.Random;

public class TestHelper {
    public StartLoggedPage logIn(String userLogin, String userPassword) {
        StartUnloggedPage startUnloggedPagePage = new StartUnloggedPage();
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
