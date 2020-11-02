package com.whj.utils;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ParameterMapping {
    private String content;//#{}这种sql解析数来的参数名
}
