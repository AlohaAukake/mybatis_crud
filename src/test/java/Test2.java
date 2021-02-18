import domain.Role;
import mapper.AccountMapper;
import mapper.RoleMapper;
import mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class Test2 {
    private InputStream in;
    private SqlSession session;
    private RoleMapper roleMapper;



    @Before
    public void init() throws Exception {
        SqlSessionFactory factory = null;
        SqlSessionFactoryBuilder builder = null;
        in = Resources.getResourceAsStream("SqlMapperCfg.xml");
        builder = new SqlSessionFactoryBuilder();
        factory = builder.build(in);
        session = factory.openSession(true);
        roleMapper = session.getMapper(RoleMapper.class);
    }

    @After
    public void destroy() throws Exception {
        in.close();
        session.close();
    }

    @Test
    public void testFindAllRole() {
        List<Role> all = roleMapper.findAll();
        for (Role r : all) {
            System.out.println(r);
            System.out.println(r.getUserList());
        }
    }
}
