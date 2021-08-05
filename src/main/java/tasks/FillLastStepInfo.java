package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static userInterfaces.LastStepPage.*;

public class FillLastStepInfo implements Task {

    private String password;

    public FillLastStepInfo() {
        this.password = generateRandomSecurePass();
    }

    /* ESTE ES EL FEO
    private String generateRandomSecurePass() {
        final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        SecureRandom random = new SecureRandom();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            int randomIndex = random.nextInt(chars.length());
            stringBuilder.append(chars.charAt(randomIndex));
        }
        return stringBuilder.toString();
    }

     */

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(password).into(INP_PASS),
                Enter.theValue(password).into(INP_CONFIRM_PASS),
                Click.on(CHK_STAY_INFO),
                //Click.on(CHK_TERMS),
                //Click.on(CHK_POLICY),
                Click.on(BTN_SETUP)
        );

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public String generateRandomSecurePass() {
        String upperCaseLetters = RandomStringUtils.random(2, 65, 90, true, true);
        String lowerCaseLetters = RandomStringUtils.random(2, 97, 122, true, true);
        String numbers = RandomStringUtils.randomNumeric(2);
        String specialChar = RandomStringUtils.random(2, 33, 47, false, false);
        String totalChars = RandomStringUtils.randomAlphanumeric(2);
        String combinedChars = upperCaseLetters.concat(lowerCaseLetters).concat(numbers).concat(specialChar).concat(totalChars);
        List<Character> pwdChars = combinedChars.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toList());
        Collections.shuffle(pwdChars);
        return pwdChars.stream()
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                .toString();
    }

    public static FillLastStepInfo createPassAndAcceptTerms() {
        return instrumented(FillLastStepInfo.class);
    }
}
