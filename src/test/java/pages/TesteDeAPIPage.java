package pages;

import org.junit.Test;

import static io.restassured.RestAssured.when;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.core.IsEqual.equalTo;

public class TesteDeAPIPage {

    public void enviaGetValidaNome(String name) {
        when().
                get("https://gorest.co.in/public-api/users").
                    then().statusCode(200);
//                    then().assertThat().
//                        body("data.name", hasItem(name));



    }

    public void enviaGetValidaStatusEEmail(String status, String email ) {
//        when().
//                get("https://gorest.co.in/public-api/users").
//                    then().
//                        body("data.status[1]", is(status))
//                        .body("data.email[1]", is(email));



    }



}
