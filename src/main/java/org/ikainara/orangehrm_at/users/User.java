package org.ikainara.orangehrm_at.users;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class User {
    private String username;
    private String password;
}
