package com.hzbl360.mapper;

import com.hzbl360.pojo.SysRole;

import java.util.List;

public interface RoleMapper {

    SysRole selectRoleById(Long id);
    List<SysRole> selectAllRoleAndPrivileges();
}
