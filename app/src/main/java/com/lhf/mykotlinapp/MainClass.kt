package com.lhf.mykotlinapp

/**
 * Created by Joshua on 2020/6/3.
 */
class MainClass {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println("Hello, Kotlin!")
//            testVars(1, 2, 3, 4, 5)
//            testLambda()
//            testString()
//            testNullCheck()
            testRange()
        }

        private fun testRange() {
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
        private fun testNullCheck() {
            println("MainClass.testNullCheck")
//            var age: String = null // 默认不能赋值为空
            var age: String? = null // 类型后面加?表示可为空
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
        private fun testString() {
            println("MainClass.testString")
            var a = 1
            // 模板中的简单名称：
            val s1 = "a is $a"
            println(s1)
            a = 2
            // 模板中的任意表达式：
            val s2 = "${s1.replace("is", "was")}, but now is $a"
            println(s2)
        }

        /**
         * Lambda表达式
         */
        private fun testLambda() {
            println("MainClass.testLambda")
            val sumlambda: (Int, Int) -> Int = { x, y -> x + y }
            println(sumlambda(1, 2))
        }

        /**
         * 函数的可变长参数可以用 vararg 关键字进行标识
         */
        fun testVars(vararg v: Int) {
            println("MainClass.testVars")
            for (vt in v) {
                print(vt)
            }
            println()
        }

    }
}
