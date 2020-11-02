package com.whj.pojo;


import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer id;
    private String username;
    private String birthday;
    private String password;
}
