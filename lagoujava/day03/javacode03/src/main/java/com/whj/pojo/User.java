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

    //表示用户关联的角色
    private List<Role> roleList = new ArrayList<>();
}
