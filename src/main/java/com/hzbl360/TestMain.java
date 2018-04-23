package com.hzbl360;

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
        List<SysRole> sysRoles = sqlSession.selectList("com.hzbl360.mapper.UserMapper.selectRoleByUserId");

        System.out.println(sysRoles);
    }
}
