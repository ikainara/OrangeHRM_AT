package org.ikainara.orangehrm_at.models.buzz;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Employee {
    private Integer empNumber;
    private String lastName;
    private String firstName;
    private String middleName;
    private String employeeId;
    private Object terminationId;
}
