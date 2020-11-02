package com.whj.mapper;

import com.whj.pojo.Role;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IRoleMapper {
    //以下两条查询结果一样！！！
    @Select("select * from role r, user_role ur where r.id = ur.role_id and ur.user_id = #{uid}")
//    @Select("select * from role r join user_role ur on r.id = ur.role_id where ur.user_id = #{uid}")
    List<Role> getRoleByUid(Integer uid);
}
