package com.lhf.mykotlinapp

import com.lhf.mykotlinapp.generic.*
import kotlinx.coroutines.runBlocking
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
     * 测试数组Array
     *
     * Array大小不可变，但元素值可以修改
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
     * 测试不可变列表 List
     *
     * List与Array类似大小也是不可变得，但List里面的值也不能修改
     */
    @Test
    fun testList() {
        // 不可变列表List
        val list = listOf(1, 3, 2)
        println("MainClass.testList: list = $list")
//        list.get(0) = 2 // 不能修改，无法通过编译

        // 获取大小
        println("MainClass.testList: list.size = ${list.size}") // list.size = 3

        // 获取某个元素
        println("MainClass.testList: list.get(0) = ${list.get(0)}") // list.get(0) = 1
        println("MainClass.testList: list[0] = ${list[0]}") // list[0] = 1

        // 判断是否包含某个元素
        println("MainClass.testList: list.contains(1) = ${list.contains(1)}") // list.contains(1) = true

        // 遍历List
        // 1. 遍历元素
        println("遍历元素")
        for (item in list) {
            println("item in list: $item")
        }
        // 2. 遍历下标
        println("遍历下标")
        for (index in list.indices) {
            println("index in list: $index")
        }
        // 3. 同时遍历下标和元素
        println("同时遍历下标和元素")
        for ((index, item) in list.withIndex()) {
            println("index in list: $index, $item")
        }
    }

    /**
     * 测试可变列表 MutableList
     *
     * MutableList相比List，大小、元素值等都可以修改
     */
    @Test
    fun testMutableList() {
        val mutableList = mutableListOf(1, 3, 2)
        println("MainClass.testMutableList: mutableList = $mutableList") // [1, 3, 2]

        println("MainClass.testMutableList: 添加")
        // 添加元素
        // 1. 在末尾添加
        mutableList.add(4)
        println("MainClass.testMutableList: mutableList = $mutableList") // [1, 3, 2, 4]
        // 2. 在指定位置添加
        mutableList.add(1, 5)
        println("MainClass.testMutableList: mutableList = $mutableList") // [1, 5, 3, 2, 4]

        println("MainClass.testMutableList: 移除")
        // 移除元素
        mutableList.add(1)
        println("MainClass.testMutableList: mutableList = $mutableList") // [1, 5, 3, 2, 4, 1]
        // 1. 移除某个元素值，若有多个相同的值，移除最前面的
        mutableList.remove(1)
        println("MainClass.testMutableList: mutableList = $mutableList") // [5, 3, 2, 4, 1]
        // 2. 移除某个位置上的值
        mutableList.removeAt(1)
        println("MainClass.testMutableList: mutableList = $mutableList") // [5, 2, 4, 1]

        println("MainClass.testMutableList: 修改")
        // 修改某个位置的元素
        // 1. 使用set方法
        mutableList.set(0, 6)
        println("MainClass.testMutableList: mutableList = $mutableList") // [6, 2, 4, 1]
        // 2. 使用索引操作
        mutableList[1] = 7
        println("MainClass.testMutableList: mutableList = $mutableList") // [6, 7, 4, 1]


        println("MainClass.testMutableList: 改变顺序及批量修改")
        // 改变顺序及批量修改
        mutableList.reverse() // 翻转
        println("MainClass.testMutableList: mutableList = $mutableList") // [1, 4, 7, 6]
        mutableList.sort() // 排序
        println("MainClass.testMutableList: mutableList = $mutableList") // [1, 4, 6, 7]
        mutableList.shuffle() // 随机打乱
        println("MainClass.testMutableList: mutableList = $mutableList") // [7, 4, 6, 1]
        mutableList.removeAll(listOf(1, 2)) // 移除另一集合中所包含的元素
        println("MainClass.testMutableList: mutableList = $mutableList") // [7, 4, 6]
        mutableList.addAll(listOf(1, 2)) // 添加另一集合中所包含的元素
        println("MainClass.testMutableList: mutableList = $mutableList") // [7, 4, 6, 1, 2]
        mutableList.retainAll(listOf(1, 2)) // 仅保留另一集合中所包含的元素
        println("MainClass.testMutableList: mutableList = $mutableList") // [1, 2]
        val copyList = mutableList.toList() // 复制整个List，返回的是不可修改的List
        println("MainClass.testMutableList: copyList = $copyList") // copyList = [1, 2]
        mutableList.clear() // 清空
        println("MainClass.testMutableList: mutableList = $mutableList") // []
        println("MainClass.testMutableList: copyList = $copyList") // copyList = [1, 2]
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
     * 测试Lambda表达式
     */
    @Test
    fun testLambda() {
        println("MainClass.testLambda")
        // 显示定义参数类型及返回值类型, (Int, Int) -> Int 即为sumlambda的类型
        var sumlambda: (Int, Int) -> Int = { x, y -> x + y }
        // 使用invoke调用
        println(sumlambda.invoke(1, 2)) // 3
        // 不显示定义，编译器可以推断出来
        sumlambda = { x: Int, y: Int -> x + y }
        // 省略invoke的快捷调用
        println(sumlambda(1, 2)) // 3

        val addFive: (Int) -> Int = { x -> x + 5 }
        println("MainClass.testLambda: addFive(1) = ${addFive(1)}") // addFive(1) = 6
        // 如果lambda只有一个参数，并且编译器可以推断出它的类型，则可以用it代替参数
        val addFive1: (Int) -> Int = { it + 5 }
        println("MainClass.testLambda: addFive1(1) = ${addFive1(1)}") // addFive(1) = 6

        // 将lambda作为函数参数
        convert(10.0, { it * 2 }) // 10.0 is converted to 20.0
        // lambda是函数的最后一个参数时，还可以把表达式移到括号外面
        convert(10.0) { it * 2 } // 10.0 is converted to 20.0
        // 如果函数只有一个lambda参数，还可以把括号也省略
        convertFive {
            it * 2
        } // 5 is converted to 10

        // lambda作为函数的返回值
        val converter = getConverter("addFive")
        println("MainClass.testLambda: converter(2.0) = ${converter(2.0)}") // converter(2.0) = 7.0
        // 还可以将返回的lambda，传给另一个高阶函数
        convert(2.0, converter) // 2.0 is converted to 7.0
    }

    /**
     * 将lambda作为函数返回值的高阶函数
     *
     * lambda类型，可以使用自定义的类型别名 DoubleConverter
     */
    private fun getConverter(name: String): DoubleConverter {
        return when (name) {
            "addFive" -> { x: Double -> x + 5 }
            "double" -> { x: Double -> x * 2 }
            else -> { x: Double -> x }
        }
    }

    /**
     * 将lambda作为函数参数的高阶函数
     *
     * lambda类型，可以使用自定义的类型别名 DoubleConverter
     */
    private fun convert(x: Double, converter: DoubleConverter): Double {
        val result = converter(x)
        println("MainClass.convert: $x is converted to $result")
        return result
    }

    /**
     * 只有一个lambda参数的高阶函数
     */
    private fun convertFive(converter: (Int) -> Int): Int {
        val result = converter(5)
        println("MainClass.convert: 5 is converted to $result")
        return result
    }

    /**
     * 函数的可变长参数可以用 vararg 关键字进行标识
     */
    @Test
    fun testVars() {
        testVars(1, 2, 3, 4, 5)
    }

    private fun testVars(vararg v: Int) {
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
        // 开关，控制测试的变量是否为null
        val isNull = false

//        var dog = Dog("a", 1)
//        dog = null // dog是不可空类型（Kotlin中变量默认是不可空类型），不能赋值为null

        var dog: Dog? = Dog("a", 1)
        if (isNull) {
            dog = null // 定义dog类型为 Dog? 后，dog即变成可空类型
        }

        // 访问可空类型的方法和属性
        // 必须先判断变量不为null
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

        // Elvis操作符 ?: 在某些场景下替代if表达式
        // ?: 左边的不为null，则返回左边的值，否则返回右边的值
        val weight = if (dog != null) dog.weight else -1
        println("MainClass.testNull: weight = $weight") // 1， -1
        val weight1 = dog?.weight ?: -1
        println("MainClass.testNull: weight1 = $weight1") //1， -1

        // 非空断言操作符 !! ，在对象必须不为null的场景使用
        // !! 左边为null时，抛出空指针异常，右边为null没事
        dog?.canNull = null
        val x = dog!!.canNull // NullPointerException
        println("MainClass.testNull: x = $x") // x = null
    }

    /**
     * 测试泛型的 in 和 out
     */
    @Test
    fun testGeneric() {
        var foodSeller: Seller<Food>
        foodSeller = FoodSeller()
        // Seller<T>不加out时，该行无法编译，添加后即可编译
        // out 是协变，表示可以用子类代替父类
        foodSeller = VeganFoodSeller()

        var vegan: Consumer<VeganFood>
        vegan = Vegan()
        // Consumer<T>不加in时，该行无法编译，添加后即可编译
        // in 是逆变，表示可以用父类代替子类
        vegan = Person()
    }

    /**
     * 测试Kotlin内置高阶函数
     */
    @Test
    fun testHigherOrderFunctions() {
        val pirates = listOf(
            Pirate("Luffy", 19, 30.0),
            Pirate("Zoro", 21, 11.11),
            Pirate("Sanji", 21, 10.32),
            Pirate("Nami", 20, 3.66, false),
            Pirate("Usopp", 19, 5.0)
        )

        // 最大最小值
        // 返回最大最小值对应的对象
        val maxRewardPirate = pirates.maxByOrNull { it.reward }
        val minRewardPirate = pirates.minByOrNull { it.reward }
        println("MainClass.testHigherOrderFunctions: maxRewardPirate = $maxRewardPirate , minRewardPirate = $minRewardPirate")
        // 返回最大最小值数值
        val maxReward = pirates.maxOf { it.reward }
        val minReward = pirates.minOf { it.reward }
        println("MainClass.testHigherOrderFunctions: maxReward = $maxReward , minReward = $minReward")

        // filter函数
        // 返回符合某个条件的List
        val highRewardList = pirates.filter { it.reward > 10.0 }
        println("MainClass.testHigherOrderFunctions: highRewardList = $highRewardList")
        // 返回不符合某个条件的List
        val femaleList = pirates.filterNot { it.male }
        println("MainClass.testHigherOrderFunctions: femaleList = $femaleList")

        // map函数
        val nameList = pirates.map { it.name }
        println("MainClass.testHigherOrderFunctions: nameList = $nameList")

        // forEach
        println("姓名列表：")
        pirates.forEach { println(it.name) }

        // groupBy函数，返回的是map，其中key是groupBy的lambda参数，value是符合条件key的元素List
        pirates.groupBy { it.age }.forEach {
            println("年龄为 ${it.key} 的有：")
            it.value.forEach { pirate -> println("    ${pirate.name}") }

        }

        // fold函数
        val rewardSum = pirates.fold(0.0) { rewardSum, item -> rewardSum + item.reward }
        println("MainClass.testHigherOrderFunctions: 总悬赏金为： $rewardSum")
    }

    /**
     * 测试协程
     */
    @Test
    fun testCoroutines() {
        println("Thread.currentThread().name = ${Thread.currentThread().name}") // main
        runBlocking {
            println("Thread.currentThread().name = ${Thread.currentThread().name}") // main @coroutine#1
        }
    }

    /**
     * 作用域函数是Kotlin比较重要的一个特性，共分为以下5种：let、run、with、apply 以及 also
     */
    @Test
    fun testScopeFunctions() {
        val dog = Dog("dog", 1)
        // let: public inline fun <T, R> T.let(block: (T) -> R): R
        //
        val letReturn = dog.let {
            it.name = "letDog"
            "let return name: ${it.name}"
        }
        println("letReturn = $letReturn") // letReturn = let return name: letDog


        //run: public inline fun <T, R> T.run(block: T.() -> R): R
        val runReturn = dog.run {
            name = "runDog"
            "run return name: $name"
        }
        println("runReturn = $runReturn") // runReturn = run return name: runDog

        // with: public inline fun <T, R> with(receiver: T, block: T.() -> R): R
        val withReturn = with(dog) {
            name = "withDog"
            "with return name: $name"
        }
        println("withReturn = $withReturn") // withReturn = with return name: withDog

        // apply: public inline fun <T> T.apply(block: T.() -> Unit): T
        val applyReturn = dog.apply {
            name = "applyDog"
            "with return name: $name"
        }
        println("applyReturn = $applyReturn") // applyReturn = com.lhf.mykotlinapp.Dog@6504e3b2
        println("applyReturn.name = ${applyReturn.name}") // applyReturn.name = applyDog

        // also: public inline fun <T> T.also(block: (T) -> Unit): T
        val alsoReturn = dog.also {
            it.name = "alsoDog"
            "also return name: ${it.name}"
        }
        println("alsoReturn = $alsoReturn") // alsoReturn = com.lhf.mykotlinapp.Dog@6504e3b2
        println("alsoReturn.name = ${alsoReturn.name}") // alsoReturn.name = alsoDog
    }
}

// 代码中多处用到了 (Double) -> Double 类型，因此可以使用 typealias 定义类型别名，提高代码可读性
typealias DoubleConverter = (Double) -> Double
