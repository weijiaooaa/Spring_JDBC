package jdbcTemplate;

import jdbc_bean.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

//使用JDBC模板实现增删改查
public class UserDaoImpl extends JdbcDaoSupport implements UserDao{
    //private JdbcTemplate jt;//如果继承了jdbcDaoSupport（根据连接池创建JDBC模板）,
                             //则不需要手动注入JDBC模板，从父类方法直接获得
    @Override
    public void save(User u) {
        String sql = "insert into hero values(null,?,245,321)";
        //jt.update(sql,u.getName());
        super.getJdbcTemplate().update(sql,u.getName());
    }

    @Override
    public void delete(Integer id) {
        String sql = "delete from hero where id = ? ";
        //jt.update(sql,id);
        super.getJdbcTemplate().update(sql,id);
    }

    @Override
    public void update(User u) {
        String sql = "update hero set name = ? where id = ?";
        //jt.update(sql,u.getName(),u.getId());
        super.getJdbcTemplate().update(sql,u.getName(),u.getId());
    }

    @Override
    public User getById(Integer id) {
        String sql = "select * from hero where id=?";
        return super.getJdbcTemplate().queryForObject(sql, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet rs, int i) throws SQLException {
                User u = new User();
                u.setId(rs.getInt("id"));
                u.setName(rs.getString("name"));
                return u;
            }
        },id);
    }

    @Override
    public int getTotalCount() {
        String sql = "select (count)* from hero ";
        Integer count = super.getJdbcTemplate().queryForObject(sql,Integer.class);
        return count;
    }

    @Override
    public List<User> gatAll() {
        String sql = "select * from hero ";
        List<User> list = super.getJdbcTemplate().query(sql,new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet rs, int i) throws SQLException {
                User u = new User();
                u.setId(rs.getInt("id"));
                u.setName(rs.getString("name"));
                return u;
            }
        });
        return list;
    }
}
