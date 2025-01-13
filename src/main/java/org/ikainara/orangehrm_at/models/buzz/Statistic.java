package org.ikainara.orangehrm_at.models.buzz;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Statistic {
    private Integer numOfLikes;
    private Integer numOfComments;
    private Integer numOfShares;
}
