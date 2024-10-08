package api.request_io;

import org.junit.Test;
import static io.restassured.RestAssured.given;

public class TestDefault {

    private static final String URL = "https://timeapi.io";


    @Test
    public void checkCurrentZoneTime() {
        Specifications.installSpec(Specifications.requestSpec(URL), Specifications.responseSpecOK200());

        String timeZone = "Europe/Amsterdam";

        CurrentTimeZone currentTimeZone = given()
                .when()
                .get("/api/time/current/zone?timeZone=Europe/Amsterdam")
                .then().log().all()
                .extract().as(CurrentTimeZone.class);


    }
}
