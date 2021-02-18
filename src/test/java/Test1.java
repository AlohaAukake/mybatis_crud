

import domain.Account;
import domain.QueryVo;
import domain.User;
import mapper.AccountMapper;
import mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Test1 {

    private InputStream in;
    private SqlSession session;
    private UserMapper userMapper;
    private AccountMapper accountMapper;


    @Before
    public void init() throws Exception {
        SqlSessionFactory factory = null;
        SqlSessionFactoryBuilder builder = null;
        in = Resources.getResourceAsStream("SqlMapperCfg.xml");
        builder = new SqlSessionFactoryBuilder();
        factory = builder.build(in);
        session = factory.openSession(true);
        userMapper = session.getMapper(UserMapper.class);
        accountMapper = session.getMapper(AccountMapper.class);
    }

    @After
    public void destroy() throws Exception {
//        session.commit();
        in.close();
        session.close();
    }

    //------------------------------------------------------------------------//


    @Test
    public void testGetUsers() {
        List<User> list = userMapper.findAll2();
        for (User user : list) {
            System.out.println("----------------------------------------------------------------");
            System.out.println(user);
            for (Account account : user.getAccounts()) {
                System.out.println(account);
            }
            System.out.println("----------------------------------------------------------------");
        }
    }

    @Test
    public void testGetAllAccountByRsMap() {
        List<Account> list = accountMapper.getAllAccountByResMap();
        for (Account account : list) {
            System.out.println(account);
        }
    }


    @Test
    public void testFindAll() {
        List<User> all = userMapper.findAll();
        System.out.println(all.toString());
    }

    @Test
    public void testSaveUser() {
        User user = new User("Jack11", new Date(), "男", "美国纽约1");
        System.out.println("保存前：" + user);
        userMapper.saveUser(user);
        System.out.println("保存后：" + user);
    }

    @Test
    public void testDeleteById() {
        userMapper.deleteById(8);
    }

    @Test
    public void testGetUser() {
        User user = userMapper.getUser(1);
        System.out.println(user);
    }

    @Test
    public void testUpdateUser() {
        User user = userMapper.getUser(1);
        user.setUsername("周杰伦111");
        userMapper.updateUser(user);
    }

    @Test
    public void testGetUserByName() {
        List<User> name = userMapper.getUserByName("%周%");
        System.out.println(name);
    }

    @Test
    public void testGetUserByVo() {
        QueryVo vo = new QueryVo();
        User user = new User();
        user.setUsername("%周%");
        vo.setUser(user);
        List<User> name = userMapper.getUserByQueryVo(vo);
        System.out.println(name);
    }

    @Test
    public void testGetUserCount() {
        int count = userMapper.getUserCount();
        System.out.println("User count： " + count);
    }

    @Test
    public void testGetUserByUser() {
        User user = new User();
        user.setUsername("%周%");
        user.setSex("女");
        List<User> name = userMapper.getUserByUsername(user);
        System.out.println(name);
    }

    @Test
    public void testForeach() {
        QueryVo vo = new QueryVo();
        List<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(11);
        ids.add(13);
        vo.setIds(ids);
        List<User> name = userMapper.getUserByVo(vo);
        System.out.println(name);
    }
}
