package com.backend.controller;

import com.backend.entity.Result;
import com.backend.entity.User;
import com.backend.service.CollectionsService;
import com.backend.service.LikeService;
import com.backend.service.UserFollowsService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * 用户点赞/取消点赞
 */
@CrossOrigin

@RestController
@RequestMapping("/interact")
public class InteractController {

    @Resource
    private LikeService likeService;

    @Resource
    private CollectionsService collectionsService;

    @Resource
    private UserFollowsService userFollowsService;
    /**
     * 点赞/取消点赞视频
     * @return
     */
    @PostMapping("/like")
    public Result likeVideo(HttpSession session, Long videoId){
        User currUser = (User)session.getAttribute("user");
        Integer flag = likeService.likeOrCancel(currUser.getId(), videoId);
        if(flag==1){
            return Result.SUCCEED("点赞成功");
        }else{
            return Result.SUCCEED("取消点赞");
        }
    }

    /**
     * 收藏/取消收藏视频
     * @return
     */
    @PostMapping("/collect")
    public Result collectVideo(HttpSession session, Long videoId){
        User currUser = (User)session.getAttribute("user");
        Integer flag = collectionsService.collectOrCancel(currUser.getId(), videoId);
        if(flag==1){
            return Result.SUCCEED("收藏成功");
        }else{
            return Result.SUCCEED("取消收藏");
        }
    }

    /**
     * 关注/取消关注用户
     * @return
     */
    @PostMapping("/follow")
    public Result followUser(HttpSession session, Long userId){
        User currUser = (User)session.getAttribute("user");
        Integer flag = userFollowsService.followOrCancel(currUser.getId(), userId);
        if(flag==1){
            return Result.SUCCEED("关注成功");
        }else{
            return Result.SUCCEED("取消关注");
        }
    }


}
