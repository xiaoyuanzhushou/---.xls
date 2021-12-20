package com.example.physicsexperiment

import kotlin.math.E
import kotlin.math.sqrt

/**
 * 存储实验8的数据，数据处理公式和数据处理的方法及结果的类
 */
class Database8 {

    /**
     * 测量数据，单位V/m（U），m（Lac），Ω，5组
     */

    /**
     * 输入部分
     */
    val U: Double = 0.2

    var R: Array<Double> = arrayOf(0.0,0.0,0.0,0.0,0.0)

    var Lac: Array<Double> = arrayOf(0.0,0.0,0.0,0.0,0.0)

    /**
     * 计算部分
     */
    var averageLac8: Double = (Lac[0]+Lac[1]+Lac[2]+Lac[3]+Lac[4])/5

    var E8: Double = U*averageLac8

    /**
     * 不确定度
     */
    var tem8: Double = (Lac[0]-averageLac8)*(Lac[0]-averageLac8)+
            (Lac[1]-averageLac8)*(Lac[1]-averageLac8)+(Lac[2]-averageLac8)*(Lac[2]-averageLac8)+
            (Lac[3]-averageLac8)*(Lac[3]-averageLac8)+(Lac[4]-averageLac8)*(Lac[4]-averageLac8)

    var uALac8: Double = 1.14*(tem8/20)

    var uCLac8: Double = uALac8

    var uCE8: Double = sqrt(U*U*uCLac8*uCLac8)

    var uRE8: Double = uCE8/E8

    constructor(
        R: Array<Double>,
        Lac: Array<Double>,
        averageLac8: Double,
        E8: Double,
        tem8: Double,
        uALac8: Double,
        uCLac8: Double,
        uCE8: Double,
        uRE8: Double
    ) {
        this.R = R
        this.Lac = Lac
        this.averageLac8 = averageLac8
        this.E8 = E8
        this.tem8 = tem8
        this.uALac8 = uALac8
        this.uCLac8 = uCLac8
        this.uCE8 = uCE8
        this.uRE8 = uRE8
    }
}