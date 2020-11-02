package com.whj.mapper;

import com.whj.pojo.Order;

import java.util.List;

public interface OrderMapper {
    List<Order> getByUid(Integer uid);
}
