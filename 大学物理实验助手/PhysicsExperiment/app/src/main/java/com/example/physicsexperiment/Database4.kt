package com.example.physicsexperiment

/**
 * 存储实验4的数据，数据处理公式和数据处理的方法及结果的类
 */
class Database4 {

    /**
     * 1，物距像距法测凸透镜焦距，单位cm，1组
     */

    /**
     * 填入部分
     */
    var u: Double = 0.0

    var v: Double = 0.0

    /**
     * 2，自准直法测凸透镜焦距，单位cm，5组
     */

    /**
     * 填入部分
     */
    var f: Array<Double> = arrayOf(0.0,0.0,0.0,0.0,0.0)

    /**
     * 3，位移法测凸透镜焦距，单位cm，5组
     */

    /**
     * 填入部分
     */
    var L: Array<Double> = arrayOf(0.0,0.0,0.0,0.0,0.0)

    var D: Double = 0.0

    /**
     * 4，物距像距法测凹透镜焦距，单位cm，1组
     */

    /**
     * 填入部分（改为A'B'，A"B"，L2）
     */
    var positionOfA1B1: Double = 0.0

    var positionOfA2B2: Double = 0.0

    var positionOfL2: Double = 0.0

    /**
     * 5，自准直法测凹透镜焦距，单位cm，5组
     */

    /**
     * 填入部分
     */
    var x1: Array<Double> = arrayOf(0.0,0.0,0.0,0.0,0.0)

    var x2: Array<Double> = arrayOf(0.0,0.0,0.0,0.0,0.0)

    /**
     * X-不确定度,mm
     */
    var uBX4: Double = 0.5/3

    var uCX4: Double = uBX4

    /**
     * u和v的不确定度,cm
     */
    var uAu4: Double = 0.000000
}