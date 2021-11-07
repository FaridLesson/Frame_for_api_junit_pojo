package steps;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import pojos.CreateUserResponse;
import pojos.UserPojoFull;
import pojos.UserRequest;

import java.util.List;

import static io.restassured.RestAssured.given;

public class UserSteps {
    /*
    перенесли тестовые данные в шаги
     */
    private static final RequestSpecification REQ_SPEC =
            new RequestSpecBuilder()
                    .setBaseUri("https://reqres.in/api")//базовый урл
                    .setBasePath("/users")//адрес запроса
                    .setContentType(ContentType.JSON)//тип контента
                    .build();
                                                                            //переносим получение данных о юзере в отдельный класс
    private CreateUserResponse user;
    public CreateUserResponse createUser(UserRequest rq){
        user = given().body(rq).post().as(CreateUserResponse.class);
        return user;
    }
                                                                            //получаем id последнего созданного юзера
    public UserPojoFull getUser(){
        return given().get("/" + user.getId()).as(UserPojoFull.class);
    }


//    перенесли функцию получения юзеров в отдельный метод
    public static List<UserPojoFull> getUsers() {
        return given().spec(REQ_SPEC)
                .get()
                .jsonPath().getList("data", UserPojoFull.class);
    }

    public static UserPojoFull getUser(int id){
        return given().get("/" + id).as(UserPojoFull.class);
    }
}
