package com.cxy.crm.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

public class SqlSessionUtil {
    private static SqlSessionFactory sqlSessionFactory;
    static {
        try {
            sqlSessionFactory=new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //通过使用ThreadLocal来实现事务的绑定,所以类型只能是SqlSession
    private  static ThreadLocal<SqlSession> local=new ThreadLocal();

    /**
     * 将SqlSession绑定到线程上
     * @return 返回的是SqlSession对象
     */
    public static SqlSession openSession(){
        SqlSession sqlSession=  local.get();
        //当当前的SqlSession位空时，需要创建，否则直接绑定即可
        if (sqlSession == null) {
            sqlSession = sqlSessionFactory.openSession();
            local.set(sqlSession);
        }
        return sqlSession;
    }

    /**
     * 关闭SqlSession对象
     * @param sqlSession
     */
    public static  void close(SqlSession sqlSession){
        if (sqlSession != null) {
            sqlSession.close();
        }
        local.remove();
    }
}
