package com.example.myapplication.assistant.beans
import kotlin.math.sqrt

/**
 * 存储实验12的数据，数据处理公式和数据处理的方法及结果的类
 */
class Database12 {

    /**
     * 1，测量两虚光源d，透镜移动距离L，及距离D，单位mm
     */

    /**
     * 填入部分
     */
    var d1: Array<Double> = arrayOf(0.0,0.0)

    var L: Array<Double> = arrayOf(0.0,0.0)

    var d2: Array<Double> = arrayOf(0.0,0.0)

    /**
     * 2，测量相邻亮纹间距ΔX，单位mm
     */

    /**
     * 填入部分
     */
    var deltaX1: Double = 0.0

    var deltaX11: Double = 0.0

    /**
     * 计算部分
     */
    var averaged1: Double = sqrt((d1[0]-d1[1])*(d1[0]-d1[1]))

    var averageL: Double = sqrt((L[0]-L[1])*(L[0]-L[1]))

    var averaged2: Double = sqrt((d2[0]-d2[1])*(d2[0]-d2[1]))

    var averaged: Double = sqrt(averaged1*averaged2)

    var averageD: Double = ((sqrt(averaged1)+ sqrt(averaged2))*averageL)/
            sqrt((sqrt(averaged2)- sqrt(averaged1))*(sqrt(averaged2)- sqrt(averaged1)))

    var deltaX: Double = (deltaX11*deltaX1)/10

    var lambda: Double = (averaged*deltaX)/averageD

    var E: Double = 0.000000

    constructor(
        d1: Array<Double>,
        L: Array<Double>,
        d2: Array<Double>,
        deltaX1: Double,
        deltaX11: Double,
        averaged1: Double,
        averageL: Double,
        averaged2: Double,
        averaged: Double,
        averageD: Double,
        deltaX: Double,
        lambda: Double,
        E: Double
    ) {
        this.d1 = d1
        this.L = L
        this.d2 = d2
        this.deltaX1 = deltaX1
        this.deltaX11 = deltaX11
        this.averaged1 = averaged1
        this.averageL = averageL
        this.averaged2 = averaged2
        this.averaged = averaged
        this.averageD = averageD
        this.deltaX = deltaX
        this.lambda = lambda
        this.E = E
    }

    fun dataProcess(){

        /**
         * 计算部分
         */
        averaged1 = sqrt((d1[0]-d1[1])*(d1[0]-d1[1]))

        averageL = sqrt((L[0]-L[1])*(L[0]-L[1]))

        averaged2 = sqrt((d2[0]-d2[1])*(d2[0]-d2[1]))

        averaged = sqrt(averaged1*averaged2)

        averageD = ((sqrt(averaged1)+ sqrt(averaged2))*averageL)/
                sqrt((sqrt(averaged2)- sqrt(averaged1))*(sqrt(averaged2)- sqrt(averaged1)))

        deltaX = (deltaX11*deltaX1)/10

        lambda= (averaged*deltaX)/averageD

        E = 0.000000
    }
}