package com.sky.mapper;

import com.sky.entity.SetmealDish;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SetmealDishMapper {
    static List<Long> getSetmealIdsByDishIds(List<Long> ids) {
        return null;
    }

    void insertBatch(List<SetmealDish> setmealDishes);
}
