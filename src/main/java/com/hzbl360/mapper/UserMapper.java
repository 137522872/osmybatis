package com.hzbl360.mapper;

import com.hzbl360.pojo.SysRole;
import com.hzbl360.pojo.SysUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    SysUser selectById(Long id);
    List<SysUser> selectAll();
    List<SysRole> selectRoleByUserId(Long userId);

    int insert(SysUser sysUser);
    int insert2(SysUser sysUser); //返回自增主键

    int updateById(SysUser sysUser);

    List<SysRole> selectRoleByUserIdAndRoleEnable(@Param("userId") Long userId,@Param("enabled") Integer enabled);

    List<SysUser> selectByIdList(List<Long> idList);
    SysUser selectUserAndRoleByIdSelect(Long id);
}
