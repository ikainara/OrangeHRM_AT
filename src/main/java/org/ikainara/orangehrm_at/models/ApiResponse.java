package org.ikainara.orangehrm_at.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.ikainara.orangehrm_at.models.buzz.Meta;

import java.util.List;

@Data
@NoArgsConstructor
public class ApiResponse {
    private Meta meta;
    private List<Object> rels;
}
