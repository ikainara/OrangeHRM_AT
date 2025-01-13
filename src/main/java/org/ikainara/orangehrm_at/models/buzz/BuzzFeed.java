package org.ikainara.orangehrm_at.models.buzz;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class BuzzFeed {
    private List<Buzz> data;
    private Meta meta;
    private List<Object> rels;
}
