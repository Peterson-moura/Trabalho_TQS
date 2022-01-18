package SWAGGLABS.Trabalho.Artur.Peterson.TQS.TI18.Framework.Utils;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;

import java.util.Locale;

public class FakerGenerations {

    private Faker faker;

    private String firstName;
    private String lastName;

    public FakerGenerations(WebDriver driver){
        faker = new Faker(new Locale("pt-BR"));

    }

    public String getFirstName() {
        return  faker.name().firstName();
    }

    public String getLastName() {
        return faker.name().lastName();
    }
    public String getPostalCode(){
        return faker.number().digits(8);
    }

}
