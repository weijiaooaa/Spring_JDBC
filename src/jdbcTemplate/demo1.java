package jdbcTemplate;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import jdbc_bean.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

//演示jdbc模板
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:jdbcTemplate/applicationContext.xml")
public class demo1 {
    @Resource(name = "userDao")
    private UserDao ud;
    @Test
    public void fun1()throws Exception{
        //准备连接池
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://127.0.0.1:3306/xupt?characterEncoding = UTF-8");
        dataSource.setUser("root");
        dataSource.setPassword("admin");
        //创建Jdbc模板对象
        JdbcTemplate jt = new JdbcTemplate();
        jt.setDataSource(dataSource);

        //书写sql，并执行

        String sql = "insert into hero values(null,'海贼王',245,321)";
        jt.update(sql);  //update方法用于执行新增、修改、删除等语句
    }

    @Test
    public void fun2()throws Exception{
        User u = new User();

        u.setName("tom");
        ud.save(u);
    }
    @Test
    public void fun3()throws Exception{
        User u = new User();
        u.setId(13);
        u.setName("Jerry");
        ud.update(u);
    }
    @Test
    public void fun4()throws Exception{

        ud.delete(13);
    }
    @Test
    public void fun5()throws Exception{
        System.out.println(ud.getTotalCount());
    }

    @Test
    public void fun6()throws Exception{
        System.out.println(ud.getById(3));
    }
    @Test
    public void fun7()throws Exception{
        System.out.println(ud.gatAll());
    }

}
