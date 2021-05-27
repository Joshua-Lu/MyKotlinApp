package com.lhf.mykotlinapp

import org.junit.Test

/**
 * Created by Joshua on 2020/6/3.
 */
class MainClass {

    /**
     * 交换两个变量
     */
    @Test
    fun testSwap() {
        var a = 1
        var b = 2
        a = b.also { b = a }
        println("a = ${a}")
        println("b = ${b}")
    }

    /**
     * 字符串的使用
     */
    @Test
    fun testString1() {
        // 字符串
        val str = "Joshua"
        for (c in str) {
            println("c = ${c}")
        }
        println("===============================")
        println("str[0] = ${str[0]}") // 可以像使用数组一样，使用[i]直接获取String对应位置的字符
        println("str.get(1) = ${str.get(1)}") // 还可以使用get(i)方法获取对应位置的字符
        println("===============================")
        // 使用"""可以定义多行的字符串
        val multiStr = """
                |first line|
                |   second line|
                |third line|
            """
        println("multiStr = ${multiStr}") // 默认前面会有一些前置空格
        println("===============================")
        println("multiStr.trimIndent() = ${multiStr.trimIndent()}") // 去除前置空格
        println("===============================")
        println("multiStr.trimIndent() = ${multiStr.trimMargin()}") // 去除当前行"|"之前的空格，包括"|"
        println("===============================")
    }

    /**
     * 数组的使用
     */
    @Test
    fun testArray() {
        // 数组的创建两种方式：一种是使用函数arrayOf()；另外一种是使用工厂函数。
        val arrayA = arrayOf("1", "2", "3")
        println("arrayA = ${arrayA.contentToString()}") // 数组打印可以直接调 contentToString()
        val arrayB = Array(4) { i -> i * 2 }
        println("arrayB = ${arrayB.contentToString()}")
        // 除了类Array，还有ByteArray, ShortArray, IntArray，用来表示各个类型的数组，
        // 省去了装箱操作，因此效率更高
        val arrayC = IntArray(5) { i -> i * 2 }
        println("arrayC = ${arrayC.contentToString()}")
    }

    /**
     * 基本数据类型的使用
     */
    @Test
    fun testCommonDataType() {
        println("MainClass.testCommonDataType")
        val intNum: Int = 1_000_000 // 可以使用下划线使数字常量更易读
        println("intNum = ${intNum}")
        val doubleNum: Double = 123.5e10
        println("doubleNum = ${doubleNum}")
        val longNum: Long = 1_000_000_000_000L
        println("longNum = ${longNum}")

        println("===============================")
        // == 比较值；===比较地址
        val intNum1: Int = 1_000_000;
        val intNum2: Int = 1_000_000;
        println("intNum2 == intNum1 = ${intNum2 == intNum1}") // true
        println("intNum2 === intNum1 = ${intNum2 === intNum1}") // true
        val intNum3: Int? = 1_000_000;
        val intNum4: Int? = 1_000_000;
        println("intNum4 == intNum3 = ${intNum4 == intNum3}") // true
        // Int? 类型的，即使数值相同，比较地址结果为false
        println("intNum4 === intNum3 = ${intNum4 === intNum3}") // false
    }

    /**
     * 区间的使用
     */
    @Test
    fun testRange() {
        println("MainClass.testRange")
        println("================ 循环输出 ===============")
        for (i in 1..5) println("i = ${i}") // 循环输出1到5
        println("================ 使用 downTo ===============")
//            for (i in 5..1) println("i = ${i}") // 什么都无法输出
        for (i in 5 downTo 1) println("i = ${i}") // 从大到小，要用downTo，循环输出5到1
        println("================ 用在if语句 ===============")
        for (i in 1..5) {
            if (i in 2..4) println("i = ${i}") // 在if的判断语句里，相当于 2 <= i && i <= 4
        }
        println("================ 使用 step ===============")
        for (i in 1..5 step 2) println("i = ${i}") // 可以使用step指定步长，输出1、3、5
        println("================ 使用 until ===============")
        for (i in 1 until 5) println("i = ${i}") // 使用until，排除结束元素，相当于[1,5)
    }

    /**
     * NULL检查机制
     */
    @Test
    fun testNullCheck() {
        println("MainClass.testNullCheck")
//            var age: String = null // 默认不能赋值为空
        val age: String? = null // 类型后面加?表示可为空
        println("age = $age")
//            val age1 = age!!.toInt() // 抛出空指针异常
        val age2 = age?.toInt() // 不做处理，返回null
        println("age2 = $age2")
        val age3 = age?.toInt() ?: -1 // age为null时，返回-1
        println("age3 = $age3")
    }

    /**
     * 字符串模板
     * $表示一个变量名或者变量值
     * $varName 表示变量值
     * ${varName.fun()} 表示变量的方法返回值
     */
    @Test
    fun testString() {
        println("MainClass.testString")
        var a = 1
        // 模板中的简单名称：
        val s1 = "a is $a"
        println(s1)
        a = 2
        // 模板中的任意表达式：
        val s2 = "${s1.replace("is", "was")}, but now is $a"
        println(s2)

        // 想要打印"$"符号（它不支持反斜杠转义），可以使用${'$'}
        val s3 = "${'$'}100"
        println("s3 = ${s3}")
    }

    /**
     * Lambda表达式
     */
    @Test
    fun testLambda() {
        println("MainClass.testLambda")
        val sumlambda: (Int, Int) -> Int = { x, y -> x + y }
        println(sumlambda(1, 2))
    }

    /**
     * 函数的可变长参数可以用 vararg 关键字进行标识
     */
    @Test
    fun testVars() {
        testVars(1, 2, 3, 4, 5)
    }

    fun testVars(vararg v: Int) {
        println("MainClass.testVars")
        for (vt in v) {
            print(vt)
        }
        println()
    }

}
