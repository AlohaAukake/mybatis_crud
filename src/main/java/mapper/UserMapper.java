package mapper;

import domain.QueryVo;
import domain.User;

import java.util.List;

public interface UserMapper {

    List<User> findAll2();

    List<User> findAll();

    User getUser(Integer id);

    List<User> getUserByName(String name);

    void saveUser(User user);

    void deleteById(Integer id);

    void updateUser(User user);

    int getUserCount();

    List<User> getUserByQueryVo(QueryVo vo);

    List<User> getUserByUsername(User user);

    List<User> getUserByVo(QueryVo vo);
}
