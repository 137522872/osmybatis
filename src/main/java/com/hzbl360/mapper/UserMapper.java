package com.hzbl360.mapper;

import com.hzbl360.pojo.SysRole;
import com.hzbl360.pojo.SysUser;

import java.util.List;

public interface UserMapper {
    SysUser selectById(Long id);
    List<SysUser> selectAll();
    List<SysRole> selectRoleByUserId(Long userId);
}
