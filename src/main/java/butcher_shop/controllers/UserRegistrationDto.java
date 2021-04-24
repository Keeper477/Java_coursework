package butcher_shop.controllers;


import butcher_shop.constraint.FieldMatch;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;

@FieldMatch.List({
        @FieldMatch(first = "password", second = "confirmPassword", message = "The password fields must match"),
        @FieldMatch(first = "login", second = "confirmLogin", message = "The login fields must match")
})
@Getter
@Setter
public class UserRegistrationDto {

    @NotNull
    private String password;

    @NotNull
    private String confirmPassword;

    @NotNull
    private String login;

    @NotNull
    private String confirmLogin;

    @AssertTrue
    private Boolean terms;

}
