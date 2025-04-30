package crows.restaurantms.userservice.mapper;

import crows.restaurantms.userservice.po.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("SELECT * FROM User WHERE UserID = #{id}")
    User findById(Integer id);

    @Select("SELECT * FROM User WHERE Username = #{username}")
    User findByUsername(String username);

    @Select("SELECT * FROM User")
    List<User> findAll();

    @Insert("INSERT INTO User (Username, Password, Role, Email) " +
            "VALUES (#{username}, #{password}, #{role}, #{email})")
    @Options(useGeneratedKeys = true, keyProperty = "userID")
    int insert(User user);

    @Update("UPDATE User SET Username=#{username}, Password=#{password}, " +
            "Role=#{role}, Email=#{email} WHERE UserID=#{userID}")
    int update(User user);

    @Delete("DELETE FROM User WHERE UserID = #{id}")
    int delete(Integer id);
}
