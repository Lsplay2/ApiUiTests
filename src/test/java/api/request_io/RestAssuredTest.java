package api.request_io;

import api.request_io.ListPojo.ColorsData;
import api.request_io.updatePojo.SuccessResponse;
import api.request_io.updatePojo.User;
import io.qameta.allure.Epic;
import io.restassured.http.ContentType;
import org.junit.Assert;
import org.junit.Test;

import java.time.Clock;
import java.util.List;

import static io.restassured.RestAssured.given;
@Epic("Rest Assured Tests")
public class RestAssuredTest {

    private static final String URL = "https://reqres.in";

    @Test
    public void checkAvatarAndIdTest() {

        Specifications.installSpec(Specifications.requestSpec(URL), Specifications.responseSpecOK200());

        List<Datum> users = given()
                .when()
                .get("/api/users?page=2")
                .then().log().all()
                .extract().body().jsonPath().getList("data", Datum.class);
        //Check avatar
        users.stream().forEach(x -> Assert.assertTrue(x.getAvatar().contains(x.getId().toString())));

        //Check email
        Assert.assertTrue(users.stream().allMatch(x -> x.getEmail().endsWith("@reqres.in")));


        //Check avatar default
        List<String> avatars = users.stream().map(Datum::getAvatar).toList();
        List<String> ids = users.stream().map( x -> x.getId().toString()).toList();

        for (int i = 0; i < avatars.size(); i++) {
            Assert.assertTrue(avatars.get(i).contains(ids.get(i)));
        }
    }

    @Test
    public void successRegTest() {
        Specifications.installSpec(Specifications.requestSpec(URL), Specifications.responseSpecOK200());

        Integer id = 4;
        String token = "QpwL5tke4Pnpja7X4";

        Register user = new Register("eve.holt@reqres.in", "pistol");

        SuccessReg successReg = given()
                .body(user)
                .when()
                .post("/api/register")
                .then().log().all()
                .extract().as(SuccessReg.class);

        Assert.assertNotNull(successReg.getToken());
        Assert.assertNotNull(successReg.getId());

        Assert.assertEquals(id, successReg.getId());
        Assert.assertEquals(token, successReg.getToken());
    }

    @Test
    public void unSuccessRegTestWithoutPassword() {
        Specifications.installSpec(Specifications.requestSpec(URL), Specifications.responseSpecError400());

        Integer id = 4;
        String token = "QpwL5tke4Pnpja7X4";

        Register user = new Register("sydney@fife", "");

        UnSuccessReg unSuccessReg = given()
                .body(user)
                .post("/api/register")
                .then().log().all()
                .extract().as(UnSuccessReg.class);

        Assert.assertEquals("Missing password", unSuccessReg.getError());
    }

    @Test
    public void checkYearsTest() {
        Specifications.installSpec(Specifications.requestSpec(URL), Specifications.responseSpecOK200());

        List<ColorsData> colorsData = given()
                .when()
                .get("/api/unknown")
                .then().log().all()
                .extract().body().jsonPath().getList("data", ColorsData.class);

        List<Integer> yearsList = colorsData.stream().map(ColorsData::getYear).toList();

        List<Integer> sortedYears = yearsList.stream().sorted().toList();

        Assert.assertEquals(yearsList, sortedYears);
    }

    @Test
    public void checkDeleteTest() {
        Specifications.installSpec(Specifications.requestSpec(URL), Specifications.responseSpecUnique(204));

        given()
                .when()
                .delete("/api/users/2")
                .then().log().all();
    }

    @Test
    public void checkDataServerAndServer() {
        Specifications.installSpec(Specifications.requestSpec(URL), Specifications.responseSpecOK200());

        User user = new User("morpheus" , "zion resident");
        SuccessResponse response = given()
                .body(user)
                .when()
                .put("/api/users/2")
                .then().log().all()
                .extract().as(SuccessResponse.class);
        String regex = "(.{10})$";
        String regex2 = "(.{4})$";
        String currentTime = Clock.systemUTC().instant().toString().replaceAll(regex, "");
        Assert.assertEquals(currentTime, response.getUpdatedAt().replaceAll(regex2, ""));
    }


}
