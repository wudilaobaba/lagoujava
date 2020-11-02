package com.whj.pojo;


import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer id;
    private String username;
    private String birthday;
    private String password;

    //该用户下的订单列表
    private List<Order> orderList = new ArrayList<>();
}
