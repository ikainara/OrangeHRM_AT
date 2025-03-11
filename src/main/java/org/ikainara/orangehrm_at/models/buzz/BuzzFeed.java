package org.ikainara.orangehrm_at.models.buzz;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.ikainara.orangehrm_at.models.ApiResponse;

import java.util.List;

@Data
@NoArgsConstructor
public class BuzzFeed extends ApiResponse {
    private List<Buzz> data;
}
