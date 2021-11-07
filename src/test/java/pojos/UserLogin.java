package pojos;

import lombok.AllArgsConstructor;
import lombok.Data;

//POJO объект для логина
@Data
@AllArgsConstructor
public class UserLogin {
    String email;
    String password;
}
