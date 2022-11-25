package com.rx.genericity.simple;

import java.util.ArrayList;
import java.util.List;

/**
 * {@code @author: jsf}
 * {{@code @Date} @date: 2022-11-25 11:05}
 * {{@code @Description} @Description: }
 */

public class Test {


    public static void main(String[] args) {
        Apple apple = new Apple();

        Food food = new Fruit();
        // 数组协变的
        Food [] foods = new Apple[3];

        Food [] food2 = new Apple[3];



        List<Beef> beefList = new ArrayList<>();
        //错误：不可协变
        // List<Food> foodList = beefList;
        // 错误 ： 不可逆变
        // beefList = foodList;
        // 错误：：不可协变
        // addFood(beefList);


        //<? extends E>实现了泛型的协变
        List<? extends Food> foodList = new ArrayList<>();
        List<Apple> appleList = new ArrayList<>();
        foodList = appleList; // ok 协变

        // foodList.add(new Beef()); // 错误 不能执行添加null 以外的操作
        // foodList.add(new Food());// 错误，同上，
        // foodlist.add(new Apple()); // 错误，同上
        Food food3= foodList.get(0);


        List<? super Fruit> fruitList = new ArrayList<>();
        List<Food> foodList2 = new ArrayList<>();
        // ok 逆变
        fruitList = foodList2;

        foodList2.add(new Meat());

        // fruitList.add(new Food()); 错误，只能添加 Fruit 或者 其子类


    }




    public void addFood(List<Food> foods){
        foods.add(new Apple());
    }


}
