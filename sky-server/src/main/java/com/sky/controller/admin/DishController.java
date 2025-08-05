package com.sky.controller.admin;

import com.sky.dto.DishDTO;
import com.sky.dto.DishPageQueryDTO;
import com.sky.entity.Dish;
import com.sky.result.PageResult;
import com.sky.result.Result;
import com.sky.service.DishService;
import com.sky.vo.DishVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/dish")
@Slf4j
public class DishController {

    @Autowired
    private DishService dishService;

    //新增菜品
    @PostMapping
    public Result save(@RequestBody DishDTO dishDTO) {
        dishService.saveWithFlavor(dishDTO);
        return Result.success();

    }

    //分页查询
    @GetMapping("/page")
    public Result<PageResult> page(DishPageQueryDTO dishPageQueryDTO) {
        PageResult pageResult = dishService.pageQuery(dishPageQueryDTO);
        return Result.success(pageResult);
    }

    //批量删除菜品
    @DeleteMapping
    public Result delete(@RequestParam List<Long> ids) {
        dishService.delete(ids);
        return Result.success();
    }


    //根据id查询菜品
    @GetMapping("/{id}")
    public Result<DishVO> getDishByIdWithFlavor(@PathVariable Long id){
        DishVO dishVO = dishService.getDishByIdWithFlavor(id);
        return Result.success(dishVO);
    }
    //修改菜品
    @PutMapping
    public Result update(@RequestBody DishDTO dishDTO) {
        dishService.updateWithFlavor(dishDTO);
        return Result.success();
    }

    //根据分类id查询菜品
    @GetMapping("/list")
    public Result<List<Dish>> getByCategoryId(Long categoryId) {
        List<Dish> dishes = dishService.getByCategoryId(categoryId);
        return Result.success(dishes);
    }

    //菜品起售状态更新
    @PostMapping("/status/{status}")
    public Result startOrStop(@PathVariable("status") Integer status, Long id) {
        dishService.startOrStop(status,id);
        return Result.success();
    }
}
