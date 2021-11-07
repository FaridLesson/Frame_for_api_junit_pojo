import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pojos.CreateUserResponse;
import pojos.UserPojoFull;
import pojos.UserRequest;
import utils.RestWrapper;
import utils.UserGenerator;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Тесты работы с API пользователя")
@Feature("Api for users")
public class RestTest {
    private static RestWrapper api;

    @BeforeAll
    public static void prepareClient() {
        api = RestWrapper.loginAs("eve.holt@reqres.in", "cityslicka");
    }


    @Description("Проверяет отправку запроса, для получения всех пользователей")
    @DisplayName("Получение пользователя")
    @Story("List all users")
    @Test
    public void getUsers() {
        assertThat(api.user.getUser()).extracting(UserPojoFull::getEmail).contains("george.bluth@reqres.in"); //проверяем в массиве данных передаваемый объект извлекая его содержание

    }

    //Эгземпляр класса который рпедставляет json
    //создаем клиента
    @Description("Проверяет отправку запроса, для создания клиента с указанными тестовыми данными")
    @DisplayName("Создание пользователя")
    @Story("Create user")
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
