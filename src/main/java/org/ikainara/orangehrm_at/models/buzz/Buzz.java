package org.ikainara.orangehrm_at.models.buzz;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class Buzz {
    private Integer id;
    private Post post;
    private String type;
    private Boolean liked;
    private String text;
    private Employee employee;
    private Statistic stats;
    private String createdDate;
    private String createdTime;
    private Object originalPost;
    private Permission permission;
    private List<Integer> photoIds;
}
