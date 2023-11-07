package com.backend.controller;

import com.backend.dto.UserDto;
import com.backend.entity.Result;
import com.backend.entity.User;
import com.backend.entity.Video;
import com.backend.mapper.UserMapper;
import com.backend.service.*;
import com.backend.vo.MyWorksVO;
import com.backend.vo.UserVO;
import com.backend.vo.VideoVO;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Objects;
@CrossOrigin
@RestController
@RequestMapping("/user")
public class userController {

    @Resource
    private UserService userService;

    @Resource
    private VideoService videoService;

    @Resource
    private LikeService likeService;

    @Resource
    private CollectionsService collectionsService;

    @GetMapping("/{id}")
    public Result<UserDto> getUserById(@PathVariable Integer id) {
//        return userService.getUserById(id);
        return null;
    }

    @Resource
    private UserMapper userMapper;

    @GetMapping("/page")
    public Page<User> getUserList(@RequestParam(defaultValue = "1") Integer pageNum,
                                  @RequestParam(defaultValue = "10") Integer pageSize) {
        // 创建分页对象
        Page<User> page = new Page<>(pageNum, pageSize);
        // 执行分页查询
        Page<User> userPage = userMapper.selectPage(page, null);
        return userPage;
    }

    /**
     * 获取登录用户信息
     * @param session
     * @return
     */
    @GetMapping
    public Result<User> getUser(HttpSession session){
        //获取应用上下文
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication = context.getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        //获取登陆用户信息
        User user = userService.getUserByUsername(userDetails.getUsername());
        //将User信息存入当前会话中
        session.setAttribute("user",user);
        return Result.SUCCEED(user);
    }

    /**
     * 获取用户个人作品
     * @param authorId   视频作者id
     * @return
     */
    @GetMapping("/getMyWorks/{user_id}")
    public Result<List<MyWorksVO>> getMyWorks(@PathVariable("user_id") Long authorId){
        List<MyWorksVO> myWorks = videoService.getMyWorksByUserId(authorId);

        return Result.SUCCEED(myWorks);
    }

    /**
     * 获取个人点赞的视频
     * @param userId 用户id
     * @return
     */
    @GetMapping("/getLikeVideos/{user_id}")
    public Result<List<VideoVO>> getLikeVideos(@PathVariable("user_id") Long userId){
        List<VideoVO> myLikeVideos = likeService.getLikeVideosByUserId(userId);

        return Result.SUCCEED(myLikeVideos);
    }

    /**
     * 获取用户收藏的视频
     * @param userId
     * @return
     */
    @GetMapping("/getCollectVideos/{user_id}")
    public Result<List<VideoVO>> getCollectVideos(@PathVariable("user_id") Long userId){
        List<VideoVO> collectVideos = collectionsService.getCollectVideosByUserId(userId);

        return Result.SUCCEED(collectVideos);
    }

    /**
     * 获取关注列表
     * @param userId
     * @return
     */
    @GetMapping("/getFollows/{user_id}")
    public Result<List<UserVO>> getFollows(@PathVariable("user_id") Long userId){
        List<UserVO> follows = userService.getFollows(userId);
        return Result.SUCCEED(follows);
    }


    /**
     * 获取粉丝列表
     * @param userId
     * @return
     */
    @GetMapping("/getFans/{user_id}")
    public Result<List<UserVO>> getFans(@PathVariable("user_id") Long userId){
        List<UserVO> follows = userService.getFans(userId);

        return Result.SUCCEED(follows);
    }


}
