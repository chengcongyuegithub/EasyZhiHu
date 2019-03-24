package com.ccy.easyzhihu.Dao;

import com.ccy.easyzhihu.model.User;
import org.apache.ibatis.annotations.*;

/**
 * @author chengcongyue
 * @version 1.0
 * @description com.ccy.easyzhihu.Dao
 * @date 2019/3/24
 */
@Mapper
public interface UserDAO {

    //表名
    String TABLE_NAME=" user ";
    String INSERT_FIELDS=" name,password,salt,head_url";
    String SELECT_FIELDS=" id,"+INSERT_FIELDS;

    @Insert({"insert into ",TABLE_NAME ," (",INSERT_FIELDS,")values(#{name},#{password},#{salt},#{headUrl})"})
    int addUser(User user);

    @Select({"select ",SELECT_FIELDS ," ",TABLE_NAME," where id=#{id}"})
    User selectByid(int id);

    @Update({"update ",TABLE_NAME," set password=#{password} where id=#{id}"})
    void updatePassword(User user);

    @Delete({"delete from ",TABLE_NAME," where id=#{id}"})
    void deleteById(int id);
}
