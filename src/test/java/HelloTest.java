import com.suftz.ssmdemo.bean.Department;
import com.suftz.ssmdemo.bean.User;
import com.suftz.ssmdemo.mapper.DepartmentMapper;
import com.suftz.ssmdemo.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Description:
 *
 * @author zhangchengy
 * @version 1.0
 * @date 2021/1/27 22:23
 */
public class HelloTest {

    SqlSessionFactory sqlSessionFactory = null;
    SqlSession session;

    @Before
    public void init() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //这个openSession默认是不会自动提交的，
        // 传一个是否自动提交的参数openSession(boolean)可以获取自动提交的session
        session = sqlSessionFactory.openSession();
    }

    @After
    public void destroy() {
        //增删改需要手动提交事务
        session.commit();
        session.close();
    }

    @Test
    public void test1() {
        User user = (User) session.selectOne("com.suftz.demo.mybatis.dao.UserMapper.selectUser", 101);
        System.out.println(user);
    }

    @Test
    public void testGet(){
        UserMapper userMapper = session.getMapper(UserMapper.class);
        User user = userMapper.getUserByUid(101);
        System.out.println(user);
    }

    @Test
    public void testAdd(){
        UserMapper userMapper = session.getMapper(UserMapper.class);
        User user=new User("刘备",45,"liubei@suftz.com","益州");
        boolean isSuccess = userMapper.addUser(user);
        System.out.println(isSuccess);
    }

    @Test
    public void testAddAndGetKey(){
        UserMapper userMapper = session.getMapper(UserMapper.class);
        User user=new User("刘备",45,"liubei@suftz.com","益州");
        boolean isSuccess = userMapper.addUser(user);
        System.out.println("uid:"+user.getUid());
        System.out.println(isSuccess);
    }

    @Test
    public void testDelete(){
        UserMapper userMapper = session.getMapper(UserMapper.class);
        boolean isSuccess = userMapper.deleteUserByUid(104);
        System.out.println(isSuccess);
    }

    @Test
    public void testUpdate(){
        UserMapper userMapper = session.getMapper(UserMapper.class);
        User user=new User(105,"刘备qq",50,"liubei@suftz.com","益州");
        boolean isSuccess = userMapper.updateUser(user);
        System.out.println(isSuccess);
    }

    @Test
    public void testGetList(){
        UserMapper userMapper=session.getMapper(UserMapper.class);
        List<User> list=userMapper.getAllUser();
        list.forEach(System.out::println);
    }

    @Test
    public void testGetMap(){
        UserMapper userMapper=session.getMapper(UserMapper.class);
        Map<String,Object> map=userMapper.getUserMapByUid(101);
        map.forEach((k,v)->System.out.println(k+":"+v));
    }
    @Test
    public void testGetAllUserToMap(){
        UserMapper userMapper=session.getMapper(UserMapper.class);
        Map<Integer,User> map=userMapper.getAllUserToMap();
        map.forEach((k,v)->System.out.println(k+":"+v));
    }

    @Test
    public void testGet2(){
        UserMapper userMapper = session.getMapper(UserMapper.class);
        User user = userMapper.getUserByUid2(101);
        System.out.println(user);
    }

    @Test
    public void testGetUserAndDept(){
        UserMapper userMapper = session.getMapper(UserMapper.class);
        User user = userMapper.getUserAndDept(102);
        System.out.println(user);
    }

    @Test
    public void testGetUserAndDept2(){
        UserMapper userMapper = session.getMapper(UserMapper.class);
        User user = userMapper.getUserAndDept2(102);
        System.out.println(user.getName());
        System.out.println(user);
        //开启延迟加载后，只有需要使用部门信息，才会去发下一条sql语句；不开启则一次性发送两条sql语句，把关联数据都查出来
    }

    @Test
    public void testGetDeptUsersById(){
        DepartmentMapper departmentMapper=session.getMapper(DepartmentMapper.class);
        Department department=departmentMapper.getDeptUsersById(900);
        System.out.println(department);
    }

    @Test
    public void testGetDeptUsersById2(){
        DepartmentMapper departmentMapper=session.getMapper(DepartmentMapper.class);
        Department department=departmentMapper.getDeptUsersById2(900);
        System.out.println(department);
    }

    //-----------动态sql---------------

    @Test
    public void testGetUser(){
        User user=new User();
        user.setAddress("益州");
        user.setAge(45);
        UserMapper userMapper=session.getMapper(UserMapper.class);
        List<User> list=userMapper.getUser(user);
        list.forEach(System.out::println);
    }

    @Test
    public void testGetUser2(){
        User user=new User();
        user.setAddress("益州");
        user.setAge(45);
        UserMapper userMapper=session.getMapper(UserMapper.class);
        List<User> list=userMapper.getUser2(user);
        list.forEach(System.out::println);
    }

    @Test
    public void testGetUser3(){
        User user=new User();
        user.setAddress("益州");
        user.setAge(45);
        UserMapper userMapper=session.getMapper(UserMapper.class);
        List<User> list=userMapper.getUser3(user);
        list.forEach(System.out::println);
    }

    @Test
    public void testGetUser4(){
        User user=new User();
        user.setAddress("益州");
        user.setAge(45);
        UserMapper userMapper=session.getMapper(UserMapper.class);
        List<User> list=userMapper.getUser4(user);
        list.forEach(System.out::println);
    }

    @Test
    public void testGetUser5(){
        UserMapper userMapper=session.getMapper(UserMapper.class);
        List<User> list=userMapper.getUser5(Arrays.asList(101,102,103));
        list.forEach(System.out::println);
    }
    @Test
    public void testUpdateUserDynamic(){
        User user=new User();
        user.setUid(101);
        user.setAddress("蜀国");
        UserMapper userMapper=session.getMapper(UserMapper.class);
        boolean isSuccess=userMapper.updateUserDynamic(user);
        System.out.println("更新操作执行"+(isSuccess==true? "成功":"失败"));
    }
    @Test
    //Integer uid, String name, String password, Integer age, String email, String address
    public void testAddUsers(){
        List<User> list=new ArrayList<>();
        list.add(new User(108,"赵云",22,"zhaoyun@suftz.com","常山",new Department(900)));
        list.add(new User(109,"马超",26,"machao@suftz.com","西凉",new Department(901)));
        list.add(new User(110,"黄忠",60,"huangzhong@suftz.com","长沙",new Department(900)));
        UserMapper userMapper=session.getMapper(UserMapper.class);
        boolean isSuccess=userMapper.addUsers(list);
        System.out.println("批量插入操作执行"+(isSuccess==true? "成功":"失败"));
    }

    @Test
    public void testUpdateUserDynamic2(){
        User user=new User();
        user.setUid(101);
        user.setAddress("益州");
        UserMapper userMapper=session.getMapper(UserMapper.class);
        boolean isSuccess=userMapper.updateUserDynamic2(user);
        System.out.println("更新操作执行"+(isSuccess==true? "成功":"失败"));
    }
}
