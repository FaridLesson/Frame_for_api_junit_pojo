package pojos;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;
import utils.DataDeserializer;

import java.time.LocalDateTime;

//Ответ на создание юзера
@Data
public class CreateUserResponse extends UserRequest{
    private int id;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'hh:mm:ss.SSSZ")//переводим в Стринг и задем формат времени
    @JsonDeserialize(using = DataDeserializer.class)
    private LocalDateTime createdAt;//тут будет наше время создания
}
