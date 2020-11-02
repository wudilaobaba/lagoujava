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

//    private List<Order> orders = new ArrayList<>();
    private List<Role> roles;
}
