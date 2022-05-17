package com.mashibing.Dao;

import com.mashibing.bean.Emp;


public interface EmpDao {

    public void save(Emp emp);
    public Integer update(Emp emp);
    public Integer delete(Integer empno);
    public Emp selectEmpByEmpno(Integer empno);

}
