import com.mashibing.Dao.BookDao;
import com.mashibing.Dao.BookDaoAnnotation;
import com.mashibing.Dao.EmpDao;
import com.mashibing.bean.Book;
import com.mashibing.bean.Emp;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

public class MyTest {

    SqlSessionFactory sqlSessionFactory = null;

    @Before
    public void init(){
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }


    @Test
    public void test01() throws IOException {

        //获取与数据库相关的会话
        SqlSession sqlSession = sqlSessionFactory.openSession();
//        获取对应映射接口对象
        EmpDao mapper = sqlSession.getMapper(EmpDao.class);
//        执行具体sql语句
        Emp emp = mapper.selectEmpByEmpno(2222);
        System.out.println(emp);
//        关闭会话
        sqlSession.close();
    }

    @Test
    public void test02(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmpDao mapper = sqlSession.getMapper(EmpDao.class);
        Emp emp = new Emp();
        emp.setEmpno(555);
        emp.setEname("465465465");
        Integer save = mapper.save(emp);
        sqlSession.commit();
        System.out.println(save);
        sqlSession.close();
    }

    @Test
    public void test03(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmpDao mapper = sqlSession.getMapper(EmpDao.class);
        Emp emp = new Emp();
        emp.setEmpno(1111);
        emp.setEname("655465");
        Integer save = mapper.update(emp);
        sqlSession.commit();
        System.out.println(save);
        sqlSession.close();
    }

    @Test
    public void test4(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmpDao mapper = sqlSession.getMapper(EmpDao.class);
        Integer save = mapper.delete(1111);
        sqlSession.commit();
        System.out.println(save);
        sqlSession.close();
    }

    @Test
    public void test05() {

        //获取与数据库相关的会话
        SqlSession sqlSession = sqlSessionFactory.openSession();
//        获取对应映射接口对象
        BookDao mapper = sqlSession.getMapper(BookDao.class);
//        执行具体sql语句
        Book book = mapper.selectBookById(1);
        System.out.println(book);
//        关闭会话
        sqlSession.close();
    }

    @Test
    public void test06() {

        //获取与数据库相关的会话
        SqlSession sqlSession = sqlSessionFactory.openSession();
//        获取对应映射接口对象
        BookDaoAnnotation mapper = sqlSession.getMapper(BookDaoAnnotation.class);
//        执行具体sql语句
        Book book = mapper.selectBookById(1);
        System.out.println(book);
//        关闭会话
        sqlSession.close();
    }

    @Test
    public void test07() {

        //获取与数据库相关的会话
        SqlSession sqlSession = sqlSessionFactory.openSession();
//        获取对应映射接口对象
        EmpDao mapper = sqlSession.getMapper(EmpDao.class);
//        执行具体sql语句
        Map<String, Emp> stringEmpMap = mapper.selectAll2();
        System.out.println(stringEmpMap);
//        关闭会话
        sqlSession.close();
    }

}
