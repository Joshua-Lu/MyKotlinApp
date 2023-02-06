package com.lhf.mykotlinapp

/**
 * 使用data修饰，使Dog成为数据类
 * 数据类会自动重写equals、hashCode、toString方法
 * 使用==比较两个实例时，比较的是属性值是否相等，而不是比较两个变量的引用对象是否相同
 *
 * @author Joshua
 * @date 2023/2/3 14:34
 */
data class DogData(var name: String, var weight: Int) {

    // 没在构造方法里使用的变量
    var varNotInConstructor = 0
}