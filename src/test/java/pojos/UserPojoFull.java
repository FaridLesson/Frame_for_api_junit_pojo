package pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

//Десирилизуем полный массив объектов
@Data // ЛОМБОК - позволяет генерить все гетеры и сетеры
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserPojoFull {
	@JsonProperty("last_name")
	private String lastName;
	private int id;
	@JsonProperty("first_name")
	private String firstName;
	private String email;

}
