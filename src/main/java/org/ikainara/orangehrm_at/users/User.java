package org.ikainara.orangehrm_at.users;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.ikainara.orangehrm_at.interfaces.LoginUser;

import static org.ikainara.orangehrm_at.FakerFactory.getFaker;

@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Data
public class User implements LoginUser {
    @Builder.Default
    @JsonAlias("userName")
    String username = getFaker().name().username() + "_" + getFaker().random().hex(4);
    @Builder.Default
    String password = getFaker().ohrmFaker().getDefaultPassword();
}
