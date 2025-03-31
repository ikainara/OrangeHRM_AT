package org.ikainara.orangehrm_at.models.employee;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static org.ikainara.orangehrm_at.FakerFactory.getFaker;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiEmployee {
    @Builder.Default
    private String firstName = getFaker().name().firstName();
    private String middleName;
    @Builder.Default
    private String lastName = getFaker().name().lastName();
    private String employeeId;
    private EmployeePicture empPicture;
    private Integer empNumber;
    private Object terminationId;
}
