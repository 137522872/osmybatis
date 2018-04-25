package com.hzbl360.pojo;

import java.util.Date;
import java.util.List;


/**
 * 角色表
 */
public class SysRole {
    private Long id;
    private String roleName;
    private Integer enable;
    private Long createBy;
    private Date createTime;

    private SysUser user;
    List<SysPrivilege> privilegeList;

    private CreateInfo createInfo;


    public SysRole() {
    }

    public CreateInfo getCreateInfo() {
        return createInfo;
    }

    public void setCreateInfo(CreateInfo createInfo) {
        this.createInfo = createInfo;
    }

    public SysRole(Long id, String roleName, Integer enable,
                   Long createBy, Date createTime) {
        this.id = id;
        this.roleName = roleName;
        this.enable = enable;
        this.createBy = createBy;
        this.createTime = createTime;
    }

    public List<SysPrivilege> getPrivilegeList() {
        return privilegeList;
    }

    public void setPrivilegeList(List<SysPrivilege> privilegeList) {
        this.privilegeList = privilegeList;
    }

    public SysUser getUser() {
        return user;
    }

    public void setUser(SysUser user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Integer getEnable() {
        return enable;
    }

    public void setEnable(Integer enable) {
        this.enable = enable;
    }

    public Long getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "SysRole{" +
                "id=" + id +
                ", roleName='" + roleName + '\'' +
                ", enable=" + enable +
                ", createBy=" + createBy +
                ", createTime=" + createTime +
                ", user=" + user +
                '}';
    }
}
