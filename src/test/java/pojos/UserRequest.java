package pojos;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@Builder       //собирает нужные функции автоматом, помогает сократить код
@NoArgsConstructor @AllArgsConstructor    //добавляем анатации что бы не исключать дефолтные конструкции
public class UserRequest {
    private String name;
    private String job;
}
