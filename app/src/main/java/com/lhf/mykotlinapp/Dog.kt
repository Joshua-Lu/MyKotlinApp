package com.lhf.mykotlinapp

import kotlin.math.roundToInt

/**
 *
 * @author Joshua
 * @date 2023/2/3 14:34
 */
// 构造方法里，var 或 val修饰后，才会创建该参数对应的属性，否则只是普通的方法参数
class Dog(var name: String, weight_param: Int) {
    var weight = weight_param
        set(value) {
            if (value > 0) {
                // 这里要使用field代替weight，否则会陷入死循环
                field = value
            }
        }
    var weightInKg: Double
        get() = weight / 2.0
        set(value) {
            weight = (value * 2).roundToInt()
        }

    fun bark() {

    }
}