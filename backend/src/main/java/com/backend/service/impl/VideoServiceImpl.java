package com.backend.service.impl;

import com.backend.common.Constant;
import com.backend.dto.VideoUserDto;
import com.backend.entity.Result;
import com.backend.entity.User;
import com.backend.mapper.UserMapper;
import com.backend.util.fileUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.backend.entity.Video;
import com.backend.service.VideoService;
import com.backend.mapper.VideoMapper;
import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
* @author oo
* @description 针对表【video】的数据库操作Service实现
* @createDate 2023-10-31 11:10:08
*/
@Service
public class VideoServiceImpl extends ServiceImpl<VideoMapper, Video>
    implements VideoService{

    @Value("${qiniu.domainOfBucket}")
    private String domainOfBucket;

    @Resource
    private Auth auth;//七牛云空间对象认证

    @Resource
    private UploadManager uploadManager;

    @Resource
    private VideoMapper videoMapper;

//    @Resource
//    private Jedis jedis;

    @Resource
    private UserMapper userMapper;



    String localFilePath = "D:\\qiniuyun_data\\videos";

    @Override
    //D:\qiniuyun_data\videos 该路径下直接是视频了 你可以优化一下 做个递归获取这个路径下所有视频文件
    public void uploadVideo(String localFilePath) {
        String bucket="xzqmsgh";
        String key=null;
        String upToken = auth.uploadToken(bucket);
//如果是Windows情况下，格式是 D:\\qiniu\\test.png
        File file=new File(localFilePath);

        List<String> AllAbsolutePath = fileUtils.getAllFileAbsolutePathFromDirectory(localFilePath, Constant.VIDEO_TYPE);

        for (String path : AllAbsolutePath) {
            try {
                Response response = uploadManager.put(path, key, upToken);
                //解析上传成功的结果
                DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
                Video video = new Video();
                video.setVideoUrl(getUrl(putRet.key));
                videoMapper.insert(video);

            } catch (QiniuException ex) {
                ex.printStackTrace();
                if (ex.response != null) {
                    System.err.println(ex.response);

                    try {
                        String body = ex.response.toString();
                        System.err.println(body);
                    } catch (Exception ignored) {
                    }
        }

            }
        }

    }

    @Override
//    这个是做资源链接拼接
    public String getUrl(String key) {
        String encodedFileName = null;
        try {
            encodedFileName = URLEncoder.encode(key, "utf-8").replace("+", "%20");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        String publicUrl = String.format("%s/%s", domainOfBucket, encodedFileName);
        long expireInSeconds = 3600;//1小时，可以自定义链接过期时间
        String finalUrl = auth.privateDownloadUrl(publicUrl, expireInSeconds);
        return finalUrl;
    }

    /**
     * 需要考虑 300条视频刷完之后 该如何refresh 和 解决重复刷到的问题
     *
     * @param pagenum
     * @return
     */
    @Override
    public Result<List<VideoUserDto>> recommendVideos(Integer pagenum) {

        /**
         * 简易的推荐
         */
        QueryWrapper<Video> videoQueryWrapper = new QueryWrapper<>();
        videoQueryWrapper.orderByDesc("shares","'collection'","likes");
        Page<Video> page=new Page<>(pagenum,30);
        Page<Video> videoPage = videoMapper.selectPage(page, videoQueryWrapper);
        if (Objects.isNull(videoPage.getRecords())){
            return Result.ERR(500,"网络异常请稍后再试",null);
        }
        List<Video> videoList = videoPage.getRecords();

        /**
         * 获得作者对象列表
         */
        List<Long> authorIdList=new ArrayList<>();
        for (Video record : videoList) {
            authorIdList.add(record.getAuthorId());
        }
        QueryWrapper<User> userQueryWrapper=new QueryWrapper<>();
        userQueryWrapper.in("id",authorIdList);
        List<User> userList = userMapper.selectList(userQueryWrapper);


        /**
         * 拼接成 VideoUserDto
         */
        List<VideoUserDto> videoUserDtoList = new ArrayList<>();
        for (int i=0;i<userList.size();i++){
            videoUserDtoList.add(new VideoUserDto(videoList.get(i),userList.get(i)));
        }


        Collections.shuffle(videoUserDtoList);
        return Result.SUCCEED(String.format("获取第%d页成功",pagenum),videoUserDtoList);
    }
}




