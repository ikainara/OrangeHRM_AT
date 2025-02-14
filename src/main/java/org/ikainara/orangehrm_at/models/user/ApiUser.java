package org.ikainara.orangehrm_at.models.user;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.ikainara.orangehrm_at.models.DataObject;
import org.ikainara.orangehrm_at.models.buzz.Employee;

@Data
@NoArgsConstructor
public class ApiUser implements DataObject {
    private Integer id;
    private String userName;
    private Boolean deleted, status;
    private Employee employee;
    private UserRole userRole;
}
