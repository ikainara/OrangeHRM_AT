import org.ikainara.orangehrm_at.annotations.OrangeTest;
import org.ikainara.orangehrm_at.api.OrangeClientFacade;
import org.ikainara.orangehrm_at.enums.UserRole;
import org.ikainara.orangehrm_at.models.employee.ApiEmployee;
import org.ikainara.orangehrm_at.models.user.ApiUser;
import org.ikainara.orangehrm_at.models.user.PostUser;
import org.ikainara.orangehrm_at.users.AdminUser;
import org.ikainara.orangehrm_at.users.User;

import static org.assertj.core.api.Assertions.assertThat;

public class BuzzApiTests {

    private final OrangeClientFacade clientFacade = new OrangeClientFacade();
    private User adminUser = new AdminUser();

    @OrangeTest("HRM-003")
    public void getBuzzTest() {
        var resp = clientFacade.getBuzzFeed(adminUser);
        assertThat(resp.isSuccessful()).isTrue();
        var buzzList = resp.body();
        assertThat(buzzList.getData()).isNotEmpty();
    }

    @OrangeTest("HRM-004")
    public void getUsersTest() {
        var resp = clientFacade.getUsers(adminUser);
        assertThat(resp.isSuccessful()).isTrue();
        var userList = resp.body().getData();
        var user = userList.stream().anyMatch(u-> u.getUsername().equals("Admin"));
        assertThat(user).isTrue();
    }

    @OrangeTest("HRM-005")
    public void createEmployeeAndUserTest() {
        var employee = ApiEmployee.builder().build();
        var createEmployeeResponse = clientFacade.createEmployee(adminUser, employee);
        assertThat(createEmployeeResponse.isSuccessful()).isTrue();
        var createdEmployee = createEmployeeResponse.body().getData().get(0);
        assertThat(createdEmployee.getFirstName()).isEqualTo(employee.getFirstName());
        assertThat(createdEmployee.getLastName()).isEqualTo(employee.getLastName());
        assertThat(createdEmployee.getEmpNumber()).isNotNull();
        var userToCreate = PostUser.builder().empNumber(createdEmployee.getEmpNumber()).build();
        var createUserResponse = clientFacade.createUser(adminUser, userToCreate);
        assertThat(createUserResponse.isSuccessful()).isTrue();
        var createdUser = createUserResponse.body().getData().get(0);
        assertThat(createdUser.getId()).isNotNull();
    }

    @OrangeTest("HRM-005")
    public void createEssUserByCreatedAdminUserTest() {
        var employee = ApiEmployee.builder().build();
        var createEmployeeResponse = clientFacade.createEmployee(adminUser, employee);
        assertThat(createEmployeeResponse.isSuccessful()).isTrue();
        var createdEmployee = createEmployeeResponse.body().getData().get(0);
        assertThat(createdEmployee.getFirstName()).isEqualTo(employee.getFirstName());
        assertThat(createdEmployee.getLastName()).isEqualTo(employee.getLastName());
        assertThat(createdEmployee.getEmpNumber()).isNotNull();
        var adminToCreate = PostUser.builder().userRoleId(UserRole.ADMIN.getRoleId()).empNumber(createdEmployee.getEmpNumber()).build();
        var createUserResponse = clientFacade.createUser(adminUser, adminToCreate);
        assertThat(createUserResponse.isSuccessful()).isTrue();
        var createdUser = createUserResponse.body().getData().get(0);
        assertThat(createdUser.getId()).isNotNull();

        employee = ApiEmployee.builder().build();
        createEmployeeResponse = clientFacade.createEmployee(adminUser, employee);
        var essToCreate = PostUser.builder().empNumber(createEmployeeResponse.body().getData().get(0).getEmpNumber()).build();
        createUserResponse = clientFacade.createUser(adminToCreate, essToCreate);
        assertThat(createUserResponse.isSuccessful()).isTrue();
    }
}
