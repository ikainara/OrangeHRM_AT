package org.ikainara.orangehrm_at.models.buzz;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Permission {
    private Boolean canUpdate;
    private Boolean canDelete;
}
