package com.sky.controller.admin;

import com.sky.dto.CategoryDTO;
import com.sky.entity.Category;
import com.sky.result.Result;
import com.sky.service.CategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "菜品分类接口")
@Slf4j
@RequestMapping("/admin/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    /**
     * 新增套餐
     * @param categoryDTO
     * @return
     */
    @PostMapping
    @ApiOperation("新增套餐")
    public Result addCategory(@RequestBody CategoryDTO categoryDTO){
            log.info("新增套餐参数{}",categoryDTO);
            categoryService.save(categoryDTO);
            return Result.success();
    }
}
