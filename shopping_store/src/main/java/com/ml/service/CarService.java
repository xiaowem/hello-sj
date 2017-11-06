package com.ml.service;

import java.util.List;

import com.ml.entity.Car;
import com.ml.entity.Product;
import com.ml.util.Result;

public interface CarService {
    public Result<Car> addCar(String productId,String userId,String count);//加入购物车功能
    public Result<List<Product>> seeProductCar(String userId);//查看购物车
    public Result delProduct (String productId);//删除商品
    public Result UpdateOrder (String productId);//更新商品状态
}
