package com.backend.controller;

import com.backend.entity.Result;
import com.backend.entity.VideoCategory;
import com.backend.service.VideoCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * ClassName: CategoryController
 * Package: com.backend.controller
 * Descirption:
 *
 * @Author QLM
 * @Create 2023/11/3 14:19
 * @Version 1.0
 */
@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private VideoCategoryService videoCategoryService;

    @GetMapping("/list")
    public Result<List<VideoCategory>> listCategory(){
        List<VideoCategory> list = videoCategoryService.getAll();
        return Result.SUCCEED(list);
    }
}
