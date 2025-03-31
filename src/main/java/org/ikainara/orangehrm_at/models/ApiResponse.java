package org.ikainara.orangehrm_at.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ApiResponse<T> {
    private List<T> data;
    private List<Meta> meta;
    private List<Object> rels;
}
