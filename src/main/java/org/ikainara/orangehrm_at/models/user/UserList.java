package org.ikainara.orangehrm_at.models.user;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.ikainara.orangehrm_at.models.ApiResponse;

import java.util.List;

@Data
@NoArgsConstructor
public class UserList extends ApiResponse {
    List<ApiUser> data;
}
