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
        // 数组打印可以直接调 contentToString()
        println("arrayA = ${arrayA.contentToString()}") // arrayA = [1, 2, 3]
        val arrayB = Array(4) { i -> i * 2 }
        println("arrayB = ${arrayB.contentToString()}") // arrayB = [0, 2, 4, 6]
        // 除了类Array，还有ByteArray, ShortArray, IntArray，用来表示各个类型的数组，
        // 省去了装箱操作，因此效率更高
        val intArray = IntArray(5) { i -> i * 2 }
        println("intArray = ${intArray.contentToString()}") // intArray = [0, 2, 4, 6, 8]

        // 显示定义数组数据类型
        val arrayD: Array<Byte> = arrayOf(1, 2, 3)
        println("arrayD item Type ${arrayD.get(0).javaClass}") // arrayD item Type byte

        // 用空值初始化数组
        val nullArray = arrayOfNulls<String>(2)
        println("MainClass.testArray: nullArray = ${nullArray.contentToString()}") // nullArray = [null, null]

        // 获取数组大小
        println("MainClass.testArray: arrayA.size = ${arrayA.size}") // arrayA.size = 3

        // 逆序数组中的元素
        arrayA.reverse()
        println("MainClass.testArray: arrayA = ${arrayA.contentToString()}") // arrayA = [3, 2, 1]

        // 按自然顺序进行排序
        arrayA.sort()
        println("MainClass.testArray: arrayA = ${arrayA.contentToString()}") // arrayA = [1, 2, 3]

        // 找出它是否包含某项
        println("MainClass.testArray: arrayA.contains(1) = ${arrayA.contains("1")}") // arrayA.contains(1) = true

        // 计算元素和
        println("MainClass.testArray: intArray = ${intArray.contentToString()}") // intArray = [0, 2, 4, 6, 8]
        // IntArray 直接调用 sum() 方法
        println("MainClass.testArray: intArray.sum() = ${intArray.sum()}") // intArray.sum() = 20
        // 非Int的要使用sumBy，转成int
        println("MainClass.testArray: arrayA.sumBy { it.toInt() } = ${arrayA.sumBy { it.toInt() }}") // arrayA.sumBy { it.toInt() } = 6

        // 计算元素平均值
        // IntArray 直接调用 average() 方法
        println("MainClass.testArray: intArray.average() = ${intArray.average()}") // intArray.average() = 4.0

        // 找出最大、最小项
        // max()、min()已废弃，使用 maxOrNull()、minOrNull() 代替
        println("MainClass.testArray: intArray.min() = ${intArray.minOrNull()}") // intArray.min() = 0
        println("MainClass.testArray: intArray.maxOrNull() = ${intArray.maxOrNull()}") // intArray.maxOrNull() = 8

        // 遍历数组
        // 1. 遍历元素
        println("遍历元素")
        for (item in arrayA) {
            println("item in arrayA: $item")
        }
        // 2. 遍历下标
        println("遍历下标")
        for (index in arrayA.indices) {
            println("index in arrayA: $index")
        }
        // 3. 同时遍历下标和元素
        println("同时遍历下标和元素")
        for ((index, item) in arrayA.withIndex()) {
            println("index in arrayA: $index, $item")
        }
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

    @Test
    fun testClass() {
        val dog = Dog("a", 12)
        dog.name = "b"
        println("dog.weight: ${dog.weight}") // dog.weight: 12
        println("dog.weightInKg: ${dog.weightInKg}") // dog.weightInKg: 6.0
        dog.weightInKg = 5.0
        println("dog.weight: ${dog.weight}") // dog.weight: 10
        println("dog.weightInKg: ${dog.weightInKg}") // dog.weightInKg: 5.0

        // 验证参数为负数，不会修改属性weight
        dog.weight = -1
        println("dog.weight: ${dog.weight}") // dog.weight: 10
    }

    /**
     * Kotlin中 == 和 equals 是相同的，这与Java不同
     *
     * Dog 没有重写equals，== 和 equals默认是判断两个变量是否指向同一个对象
     */
    @Test
    fun testEquals() {
        // 两个不同的对象，即使属性相同，== 也返回false
        println("属性相同的两个对象")
        val dog1 = Dog("d1", 1)
        val dog2 = Dog("d1", 1)
        println("dog1 == dog2 : ${dog1 == dog2}") // false
        println("dog1.equals(dog2) : ${dog1.equals(dog2)}") // false

        // 两个指向相同对象的变量
        println("两个指向相同对象的变量")
        val dog3 = dog1
        println("dog1 == dog3 : ${dog1 == dog3}") // true
        println("dog1.equals(dog3) : ${dog1.equals(dog3)}") // true
    }

    /**
     * DogEquals 重写了equals方法，则根据重写的equals判断
     */
    @Test
    fun testEqualsOverride() {
        // 两个不同的对象，只要equals里用到的属性相同（实际是equals方法返回true），== 就返回true
        println("属性相同的两个对象")
        val dog1 = DogEquals("d1", 1)
        val dog2 = DogEquals("d1", 1)
        println("dog1 == dog2 : ${dog1 == dog2}") // true
        println("dog1.equals(dog2) : ${dog1.equals(dog2)}") // true

        // Kotlin里==就是调用equals方法，那是否有一种方式，明确的比较两个变量是否引用相同的对象？
        // 有的，Kotlin里使用的是 ===
        println("dog1 === dog2 : ${dog1 === dog2}") // false

        // 两个指向相同对象的变量
        println("两个指向相同对象的变量")
        val dog3 = dog1
        println("dog1 == dog3 : ${dog1 == dog3}") // true
        println("dog1.equals(dog3) : ${dog1.equals(dog3)}") // true

        // 两个不同的对象，只要equals里用到的属性相同（实际是equals方法返回true），
        // 即使其他属性不同，== 还是返回true
        println("equals里用到的属性相同, 其他属性不同")
        dog1.varNotInEquals = 1
        dog2.varNotInEquals = 2
        println("dog1 == dog2 : ${dog1 == dog2}") // true
        println("dog1.equals(dog2) : ${dog1.equals(dog2)}") // true

    }

    /**
     * 测试数据类
     */
    @Test
    fun testDataClass() {
        // 两个不同的对象，只要属性相同，== 就返回 true
        println("属性相同的两个对象")
        val dog1 = DogData("d1", 1)
        val dog2 = DogData("d1", 1)
        println("dog1 == dog2 : ${dog1 == dog2}") // true

        // 构造里用到的属性相同, 其他属性不同，也返回true，
        // 说明数据类自动重写equals等方法，只使用了构造方法里的变量
        println("构造里用到的属性相同, 其他属性不同")
        dog1.varNotInConstructor = 1
        dog2.varNotInConstructor = 2
        println("dog1 == dog2 : ${dog1 == dog2}") // true
        println("dog1 = ${dog1}") // dog1 = DogData(name=d1, weight=1)
        println("dog2 = ${dog2}") // dog2 = DogData(name=d1, weight=1)

        // 数据类还提供了copy方法，复制数据对象，修改部分属性
        val dogCopy = dog1.copy(name = "dogCopy")
        println("dogCopy = ${dogCopy}") // DogData(name=dogCopy, weight=1)

        // 数据类提供的componentN方法，将数据对象分解成组件属性值
        val name = dog1.component1()
        val weight = dog1.component2()
        println("name = ${name}, weight = ${weight}") // name = d1, weight = 1
        // 简便写法
        val (name1, weight1) = dog1
        println("name1 = ${name1}, weight1 = ${weight1}") // name1 = d1, weight1 = 1
    }

    /**
     * 测试空值
     */
    @Test
    fun testNull() {
//        var dog = Dog("a", 1)
//        dog = null // dog是不可空类型（Kotlin中变量默认是不可空类型），不能赋值为null

        var dog: Dog? = Dog("a", 1)
        dog = null // 定义dog类型为 Dog? 后，dog即变成可空类型

        dog = Dog("a", 1)
        // 访问可空类型的方法和属性
        // 必须先判断不为null
        // 方式一：显示判断不为null
        if (dog != null) {
            dog.bark()
        }
        // 方式二：使用Kotlin提供的安全调用 ?.
        // 这样当dog为null时，就不会调用bark()方法，也就不会出现空指针异常
        dog?.bark()

        // ?. 结合 let 使用，代替if语句
        dog?.let {
            it.bark()
        }

        // Elvis操作符 ?: 替代if表达式
        // ?: 左边的不为null，则返回左边的值，否则返回右边的值
        val nullDog: Dog? = null
        val weight = if (nullDog != null) nullDog.weight else -1
        println("MainClass.testNull: weight = ${weight}") // -1
        val weight1 = nullDog?.weight ?: -1
        println("MainClass.testNull: weight1 = ${weight1}") // -1

        // 非空断言操作符 !!
        // !! 左边为null时，抛出空指针异常，右边为null没事
        dog.canNull = null
        var x = dog!!.canNull
        println("MainClass.testNull: x = ${x}") // x = null

//        x = nullDog!!.canNull // 抛出空指针异常 NullPointerException
    }

}
