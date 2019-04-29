package jdbcTemplate;

import jdbc_bean.User;

import java.util.List;

public interface UserDao {

    //增
    void save(User u);
    // 删
    void delete(Integer u);

    // 改
    void update(User u);
    // 查
    User getById(Integer id);
    //查
    int getTotalCount();
    //查
    List<User> gatAll();
}
