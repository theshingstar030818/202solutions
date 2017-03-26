package app.signin;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by tanzeelrana on 3/25/2017.
 */

@PropertySource("classpath:messages.properties")
public class SigninForm {

    private static final String NOT_BLANK_MESSAGE = "notBlank.message";

    @NotBlank(message = SigninForm.NOT_BLANK_MESSAGE)
    private String username;

    @NotBlank(message = SigninForm.NOT_BLANK_MESSAGE)
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}