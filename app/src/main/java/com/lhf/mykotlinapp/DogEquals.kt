package com.lhf.mykotlinapp

import kotlin.math.roundToInt

/**
 * 重写equals方法
 *
 * @author Joshua
 * @date 2023/2/3 14:34
 */
// 构造方法里，var 或 val修饰后，才会创建该参数对应的属性，否则只是普通的方法参数
class DogEquals(var name: String, weight_param: Int) {
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

    // 没在equals里使用的变量
    var varNotInEquals = 0

    fun bark() {

    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as DogEquals

        if (name != other.name) return false
        if (weight != other.weight) return false

        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + weight
        return result
    }


}