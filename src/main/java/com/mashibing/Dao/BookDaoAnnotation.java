package com.mashibing.Dao;

import com.mashibing.bean.Book;
import org.apache.ibatis.annotations.Select;


public interface BookDaoAnnotation {

    @Select("select * from book where id = #{id}")
    public Book selectBookById(Integer id);

}
