package com.whj.config;

import com.whj.utils.ParameterMapping;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
@Data
@AllArgsConstructor
public class BoundSql {
    private String sqlText;//真实sql
    private List<ParameterMapping> parameterMappingList = new ArrayList<>();//原始sql中的#{}列表

}
