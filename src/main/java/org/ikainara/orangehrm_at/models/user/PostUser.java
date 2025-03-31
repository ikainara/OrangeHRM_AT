package org.ikainara.orangehrm_at.models.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.ikainara.orangehrm_at.enums.UserRole;
import org.ikainara.orangehrm_at.users.User;

@SuperBuilder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostUser extends User {
    Integer empNumber;
    @Builder.Default
    boolean status = true;
    @Builder.Default
    int userRoleId = UserRole.ESS.getRoleId();
}
