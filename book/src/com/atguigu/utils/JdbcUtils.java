package com.atguigu.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author ChanceZhou
 * @create 2021-11-04-15:51
 */
public class JdbcUtils {

    private static DruidDataSource dataSource;
    //同一线程操作
    private static ThreadLocal<Connection> conns = new ThreadLocal<>();


    static {
        try {
            Properties props = new Properties();

            InputStream is = JdbcUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
            props.load(is);
            dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(props);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    /**
     * 获取数据库连接池
     * null失败
     *
     * @return
     */
//    public static Connection getConnection() {
//        Connection conn = null;
//
//        try {
//            conn = dataSource.getConnection();
//        } catch (Exception throwables) {
//            throwables.printStackTrace();
//        }
//        return conn;
//    }
    public static Connection getConnection() {
        Connection conn = conns.get();
        if (conn == null) {
            try {
                conn = dataSource.getConnection();
                conns.set(conn);//保存到ThreadLocal对象中,供给后面的jdbc操作使用
                conn.setAutoCommit(false);//设置为手动管理
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return conn;
    }

    /**
     * 提交和关闭事务
     */
    public static void commitAndClose() {
        Connection conn = conns.get();
        if (conn != null) {
            try {
                conn.commit();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    conn.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        conns.remove();//一定要执行（Tomcat服务器底层使用了线程池技术）
    }

    /**
     * 回滚和关闭事务
     */
    public static void rollbackAndClose() {
        Connection conn = conns.get();
        if (conn != null) {
            try {
                conn.rollback();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    conn.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        conns.remove();//一定要执行（Tomcat服务器底层使用了线程池技术）
    }
    /**
     * 关闭数据库连接池
     *
     * @param conn
     */
//    public static void close(Connection conn) {
//        if (conn != null) {
//            try {
//                conn.close();
//            } catch (SQLException throwables) {
//                throwables.printStackTrace();
//            }
//        }
//    }
}
