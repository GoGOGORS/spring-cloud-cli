package com.rx.genericity.factory;

/**
 * {@code @author: jsf}
 * {{@code @Date} @date: 2022-11-25 11:36}
 * {{@code @Description} @Description: }
 */

public class MoneyImp {

    /**
     * Money是类似函数式接口实现
     */
    private static Money<Object> IDENTITY_FUNCTION = arg -> String.valueOf(arg.hashCode());


    @SuppressWarnings("unchecked")
    public static <T> Money<T> getMoneyInstance() {
        return (Money<T>) IDENTITY_FUNCTION;
    }


    public static void main(String[] args) {
        String[] strings = { "one", "five", "ten" };
        Money<String> paperMoney = getMoneyInstance();
        for (String s : strings) {
            System.out.println(paperMoney.apply(s));
        }

        Integer[] numbers = { 1, 2, 3 };
        Money<Integer> coinMoney = getMoneyInstance();
        for (Integer n : numbers){
            System.out.println(coinMoney.apply(n));
        }

    }
}
