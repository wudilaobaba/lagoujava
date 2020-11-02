package com.whj.pojo;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private Integer id;
    private String orderTime;
    private Double total;
    private Integer uid;

    /** 该订单属于哪个用户 */
    private User user;
}
