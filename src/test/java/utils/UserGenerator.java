package utils;

//выносим тестовые данные в отдельный статический метод

import pojos.UserRequest;

public class UserGenerator {
    public static UserRequest getSimpleUser() {
        return UserRequest.builder()
                .name("simple")
                .job("automation")
                .build();
    }
}
