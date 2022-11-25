package com.rx.genericity.part3;

/**
 * {@code @author: jsf}
 * {{@code @Date} @date: 2022-11-25 11:49}
 * {{@code @Description} @Description: }
 */

public class Test {

    // 无界参数
    // public static <E> void swap(List<E> list, int i, int j);

    // 无界参数通配符 推荐 因为在使用时IDE不会对此方式发出警告
    // public static void swap(List<?> list, int i, int j);

    // 在泛型类被类型擦除的时候，之前泛型类中的类型参数部分如果没有指定上限，
    // 如<T>则会被转译成普通的Object 类型，如果指定了上限，如<T extends String>则类型参数就被替换成类型上限。

}
