package com.mashibing.Dao;

import com.mashibing.bean.Book;

public interface BookDao {

    //    @Insert()
    public Integer save(Book book);
    //    @Update()
    public Integer update(Book book);
    //    @Delete()
    public Integer delete(Integer id);
    //    @Select()
    public Book selectBookById(Integer id);


}
