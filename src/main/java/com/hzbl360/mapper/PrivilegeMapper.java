package com.hzbl360.mapper;


import com.hzbl360.pojo.SysPrivilege;

public interface PrivilegeMapper {

    SysPrivilege selectPrivilegeByRoleId(Long id);

}
