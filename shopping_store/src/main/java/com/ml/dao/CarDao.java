package com.ml.dao;

import java.util.List;

import com.ml.entity.Car;
import com.ml.entity.Product;

public interface CarDao {
    public void insertCar(Car car);//添加购物车
    public List<Product>  seeCar(String userId);//查看购物车 
    public int delProduct(String str);//删除商品
    public int updateStatus(String productId);//更新订单状态
}
