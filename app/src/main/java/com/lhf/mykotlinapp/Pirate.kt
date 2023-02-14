package com.lhf.mykotlinapp

/**
 * 海贼数据类
 *
 * @property name String 姓名
 * @property age Int 年龄
 * @property reward Double 悬赏金（单位：亿贝里）
 * @property male Boolean 是否男性
 *
 * @author Joshua
 * @date 2023/2/14 22:20
 */
data class Pirate(val name: String, val age: Int, val reward: Double, val male: Boolean = true)
