package com.mashibing.Dao;

import com.mashibing.bean.Emp;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;


public interface EmpDao {

//    @Insert()
    public Integer save(Emp emp);
//    @Update()
    public Integer update(Emp emp);
//    @Delete()
    public Integer delete(Integer empno);
//    @Select()
    public Emp selectEmpByEmpno(Integer empno);

    public List<Emp> selectEmpList();

    @MapKey("ename")
    public Map<String,Emp> selectAll2();
}
