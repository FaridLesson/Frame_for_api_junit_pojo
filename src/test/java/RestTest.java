import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pojos.CreateUserResponse;
import pojos.UserPojoFull;
import pojos.UserRequest;
import utils.RestWrapper;
import utils.UserGenerator;

import static org.assertj.core.api.Assertions.assertThat;

public class RestTest {
    private static RestWrapper api;

    @BeforeAll
    public static void prepareClient() {
        api = RestWrapper.loginAs("eve.holt@reqres.in", "cityslicka");
    }


    @Test
    public void getUsers() {
        assertThat(api.user.getUser()).extracting(UserPojoFull::getEmail).contains("george.bluth@reqres.in"); //проверяем в массиве данных передаваемый объект извлекая его содержание

    }

    //Эгземпляр класса который рпедставляет json
    //создаем клиента
    @Test
    public void createUser() {
        UserRequest rq = UserGenerator.getSimpleUser();
        CreateUserResponse rs = api.user.createUser(rq);


        assertThat(rs)
                .isNotNull()
                .extracting(CreateUserResponse::getJob)
                .isEqualTo(rq.getJob());

    }
}
