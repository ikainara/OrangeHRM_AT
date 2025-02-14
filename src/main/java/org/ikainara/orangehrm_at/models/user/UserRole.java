package org.ikainara.orangehrm_at.models.user;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserRole {
    private Integer id;
    private String name, displayName;
}
