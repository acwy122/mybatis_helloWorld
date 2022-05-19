package com.mashibing.Dao;

import com.mashibing.bean.Emp;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;


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
}
