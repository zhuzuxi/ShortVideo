package com.backend.service;

import com.backend.dto.VideoUserDto;
import com.backend.entity.Video;
import com.backend.mapper.VideoMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.Region;
import com.qiniu.storage.model.FileInfo;
import com.qiniu.util.Auth;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.*;

@SpringBootTest
public class VideoServiceTest {

    @Test
    void getUrl(String key) throws UnsupportedEncodingException {
        String fileName = "FpLhreYOpPbFyL_j1Pk0H8ZMT4Mq";//上传视频之后会返回文件名（key）
        String domainOfBucket = "http://s3c51zvtx.hn-bkt.clouddn.com"; //测试外链
        String encodedFileName = URLEncoder.encode(fileName, "utf-8").replace("+", "%20");
        String publicUrl = String.format("%s/%s", domainOfBucket, encodedFileName);
        String accessKey = "w3VdBuR5aZoHP-v3NIjNJiOh0DwEq5Fh9EtQj1rM";//对象空间ak
        String secretKey = "Aog2_0SGoZ0IXNltTpn9pPcxsl0R7oPkNW_AMQGO";//对象空间sk
        Auth auth = Auth.create(accessKey, secretKey);
        long expireInSeconds = 3600;//1小时，可以自定义链接过期时间
        String finalUrl = auth.privateDownloadUrl(publicUrl, expireInSeconds);
        System.out.println(finalUrl);
    }

    @Resource
    private VideoService videoService;
    @Test
    void testupload(){
        String localFilePath = "D:\\qiniuyun_data\\videos";//这里输入
        videoService.uploadVideo(localFilePath);}


    @Resource
    private VideoMapper videoMapper;


    @Test
    void testcommend(){
        for (VideoUserDto videoUserDto : videoService.recommendVideos(1).getData()) {
            System.out.println(videoUserDto);
        }
    }

    @Resource(name = "myAuth")
    private Auth auth;
    @Test
    void uploadtoken(){
        String upToken = auth.uploadToken("xzqmsgh");
        System.out.println(upToken);
    }

    @Test
    public BucketManager.FileListIterator getQNResources(){
        //构造一个带指定 Region 对象的配置类
        Configuration cfg = new Configuration(Region.region0());
//...其他参数参考类注释
        String bucket = "xzqmsgh";
        BucketManager bucketManager = new BucketManager(auth, cfg);

//文件名前缀
        String prefix = "";
//每次迭代的长度限制，最大1000，推荐值 1000
        int limit = 1000;
//指定目录分隔符，列出所有公共前缀（模拟列出目录效果）。缺省值为空字符串
        String delimiter = "";

//列举空间文件列表
        BucketManager.FileListIterator fileListIterator = bucketManager.createFileListIterator(bucket, prefix, limit, delimiter);
        return fileListIterator;

    }

    @Test
    void updateDataBase(){
        BucketManager.FileListIterator resources = getQNResources();
        List<String> keyList=new ArrayList<String>();
        while (resources.hasNext()){
            FileInfo[] fileInfos = resources.next();
            for (FileInfo fileInfo : fileInfos) {
                keyList.add(fileInfo.key);
            }
        }

        System.out.println(keyList);
        ArrayList<String> flags = new ArrayList<>();
        List<String> list = Arrays.asList(
                "#美女",
                "#生活",
                "#钓鱼",
                "#运动",
                "#科技",
                "#知识分享官",
                "#解压",
                "#新闻热点",
                "#宠物",
                "#搞笑",
                "#帅哥",
                "#美妆",
                "#测试用户");

        HashMap<String, Integer> map = new HashMap<>();

        int i=2;
        for (String s : list) {
            map.put(s,i);
            i++;

        }




        for (Video video : videoMapper.selectAllVideo()) {
            UpdateWrapper<Video> updateWrapper = new UpdateWrapper<>();
            updateWrapper.eq("id",video.getId());
//            video.setVideoUrl(keyList.get(i));
            video.setAuthorId(Long.valueOf(map.get(video.getFlag())));
            videoMapper.update(video,updateWrapper);

        }
    }

    @Test
    String  splitURL(String url){
//        String url="http://s3c51zvtx.hn-bkt.clouddn.com/FgUhpPIfL4p52qt2jUQzudGvkBpT?e=1699174761&token=w3VdBuR5aZoHP-v3NIjNJiOh0DwEq5Fh9EtQj1rM:dQ9C0yHkKq1TQGQ3_01bxnn8XNg=";
        String s = url.split("http://s3c51zvtx.hn-bkt.clouddn.com/")[1];
        s=s.split("\\?e=")[0];
        return s;
    }

//    @Test




}
