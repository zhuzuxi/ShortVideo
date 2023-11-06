package com.backend.mapper;

import com.backend.entity.User;
import com.backend.vo.UserVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
* @author oo
* @description 针对表【user】的数据库操作Mapper
* @createDate 2023-10-31 11:10:01
* @Entity com.backend.entity.User
*/
@Mapper
public interface UserMapper extends BaseMapper<User> {

    /**
     * 根据用户id查询用户所有的关注
     * @param userId
     * @return
     */
    @Select("select u.id, u.username, u.img, f.follow_status " +
            "from user u, user_follows f " +
            "where f.user_id = #{userId} and u.id = f.follow_id")
    public List<UserVO> getFollowsByUserId(Long userId);

    /**
     * 根据用户id查询用户所有的粉丝信息
     * @param userId
     * @return
     */
    @Select("select u.id, u.username, u.img, f.follow_status " +
            "from user u, user_follows f " +
            "where f.follow_id = #{userId} and u.id = f.user_id")
    List<UserVO> getFansByUserId(Long userId);
}




