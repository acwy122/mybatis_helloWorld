import com.mashibing.Dao.EmpDao;
import com.mashibing.bean.Emp;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class MyTest {
    @Test
    public void test01() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //获取与数据库相关的会话
        SqlSession sqlSession = sqlSessionFactory.openSession();
//        获取对应映射接口对象
        EmpDao mapper = sqlSession.getMapper(EmpDao.class);
//        执行具体sql语句
        Emp emp = mapper.selectEmpByEmpno(1111);
        System.out.println(emp);
//        关闭会话
        sqlSession.close();


    }


}
