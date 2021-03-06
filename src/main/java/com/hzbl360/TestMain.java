package com.hzbl360;

import com.hzbl360.mapper.RoleMapper;
import com.hzbl360.mapper.UserMapper;
import com.hzbl360.pojo.SysRole;
import com.hzbl360.pojo.SysUser;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TestMain {

    private static SqlSessionFactory sqlSessionFactory;
    @BeforeClass
    public static void init(){
        try {
            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public SqlSession getSqlSession(){
        return sqlSessionFactory.openSession();
    }

    @Test
    public void testSeslectAll(){
        SqlSession sqlSession = getSqlSession();
        List<SysUser> selectAll = sqlSession.selectList("com.hzbl360.mapper.UserMapper.selectAll");
        System.out.println(selectAll);

    }

    @Test
    public void testUserSelectById(){
        SqlSession sqlSession = getSqlSession();

        SysUser sysUser = sqlSession.selectOne("com.hzbl360.mapper.UserMapper.selectById", 1);
        System.out.println(sysUser);
    }


    @Test
    public void selectRoleByUserId(){
        SqlSession sqlSession = getSqlSession();
        List<SysRole> sysRoles = sqlSession.selectList("com.hzbl360.mapper.UserMapper.selectRoleByUserId",2);

        System.out.println(sysRoles);
    }

    @Test
    public void insert(){

//        SysUser sysUser = new SysUser(null,"test1","123456","test1@qq.com","测试用户1","a.jpg",new Date());

        SysUser sysUser = new SysUser();
        sysUser.setUsernName("禾中");
        sysUser.setUserPassword("password");
        sysUser.setUserEmail("hezhong@360.com");
        sysUser.setUserInfo("禾中测试");
        sysUser.setCreateTime(new Date());

        SqlSession sqlSession = getSqlSession();
        System.out.println(sysUser);
        //返回受影响行数
        int insert = sqlSession.insert("com.hzbl360.mapper.UserMapper.insert", sysUser);
        System.out.println(insert);
    }

    @Test
    public void insert2(){
        SysUser sysUser = new SysUser();
        sysUser.setUsernName("2222禾中");
        sysUser.setUserPassword("222222密码");
        sysUser.setUserEmail("2222demo@hzbl360.com");
        sysUser.setUserInfo("禾中测试2323232");
        sysUser.setCreateTime(new Date());

        SqlSession sqlSession = getSqlSession();

        int insert = sqlSession.insert("com.hzbl360.mapper.UserMapper.insert2", sysUser);
        System.out.println(sysUser.getId());
        System.out.println(insert);
    }

    @Test
    public void updateById(){
        SysUser sysUser = new SysUser();
        sysUser.setId(2l);
        sysUser.setUsernName("2222禾中");
        sysUser.setUserPassword("222222密码");
        sysUser.setUserEmail("2222demo@hzbl360.com");
        sysUser.setUserInfo("禾中测试2323232");
        sysUser.setCreateTime(new Date());

        SqlSession sqlSession = getSqlSession();
        int update = sqlSession.update("com.hzbl360.mapper.UserMapper.updateById", sysUser);
        System.out.println(update);
    }

    /**
     * 映射接口多参数
     */
    @Test
    public void selectRoleByUserIdAndRoleEnable(){

        SqlSession sqlSession = getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<SysRole> sysRoles = mapper.selectRoleByUserIdAndRoleEnable(1L, 2);

        System.out.println(sysRoles);
    }

    @Test
    public void selectByIdList(){

        SqlSession sqlSession = getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        ArrayList<Long> idList = new ArrayList<Long>();
        idList.add(1L);
        idList.add(2L);

        List<SysUser> sysUsers = mapper.selectByIdList(idList);
        System.out.println(sysUsers);
    }


    @Test
    public void selectRoleById(){
        SqlSession sqlSession = getSqlSession();
        SysRole o = sqlSession.selectOne("com.hzbl360.mapper.RoleMapper.selectRoleById", 1);
        System.out.println(o);
    }

    @Test
    public void  selectUserAndRoleByIdSelect(){
        SqlSession sqlSession = getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        SysUser sysUser = mapper.selectUserAndRoleByIdSelect(2L);
        System.out.println(sysUser);

    }

    @Test
    public void selectUserAndRoleByIdSelect2(){
        SqlSession sqlSession = getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        List<SysUser> sysUser1 = mapper.selectUserAndRoleByIdSelect2();
        for(SysUser sysUser:sysUser1){
            System.out.println(sysUser);
        }

    }

    @Test
    public void selectAllUserAndRoles(){
        SqlSession sqlSession = getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<SysUser> sysUsers = mapper.selectAllUserAndRoles();
        for (SysUser sysUser:sysUsers){
            System.out.println(sysUser);
        }
    }

    @Test
    public void selectAllRoleAndPrivileges(){
        SqlSession sqlSession = getSqlSession();
        RoleMapper mapper = sqlSession.getMapper(RoleMapper.class);
        List<SysRole> sysRoles = mapper.selectAllRoleAndPrivileges();
        for (SysRole sysRole:sysRoles){
            System.out.println(sysRole);
        }
    }
}
