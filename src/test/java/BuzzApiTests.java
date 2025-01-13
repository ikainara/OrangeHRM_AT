import org.ikainara.orangehrm_at.annotations.OrangeTest;
import org.ikainara.orangehrm_at.api.OrangeClientFacade;
import org.ikainara.orangehrm_at.users.AdminUser;

import static org.assertj.core.api.Assertions.assertThat;

public class BuzzApiTests {

    @OrangeTest("HRM-003")
    public void getBuzzTest() {
        var resp = new OrangeClientFacade().getBuzzFeed(new AdminUser());
        assertThat(resp.isSuccessful()).isTrue();
        var buzzList = resp.body();
        assertThat(buzzList.getData()).isNotEmpty();
    }
}
