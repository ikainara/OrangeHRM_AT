package org.ikainara.orangehrm_at.models.user;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.ikainara.orangehrm_at.models.employee.ApiEmployee;

@SuperBuilder
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiUser extends PostUser {
    Integer id;
    Boolean deleted;
    ApiEmployee employee;
    ApiUserRole userRole;
}
