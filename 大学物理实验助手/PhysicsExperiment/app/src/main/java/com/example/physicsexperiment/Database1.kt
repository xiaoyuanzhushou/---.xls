package com.example.physicsexperiment

import kotlin.math.sqrt

/**
 * 存储实验1的数据，数据处理公式和数据处理的方法及结果的类
 */
open class Database1 {

    /**
     * 驻波法与实验法（相同），单位kHz(f)，℃(t)，cm，10组
     */

    /**
     * 填入部分
     */
    val order: Int = 1

    var f: Int = 0

    var t: Int = 0

    var Xi: Array<Int> = arrayOf(0,1,2,3,4,5,6,7,8,9)

    var L: List<Int> = listOf(0,0,0,0,0)

    var averageL: Int = 0

    var LiAverageL: List<Int> = listOf(0, 0, 0, 0, 0)

    var lambda: Double = 0.0

    var V: Double = 0.0

    /**
     * L-A类不确定度
     */
    var temL1: Double = 0.0

    var uAL1: Double = 0.0

    /**
     * L-B类不确定度,mm
     */
    var uBL1: Double = 0.000133

    /**
     * L-合成不确定度
     */
    var uCL1: Double = 0.0

    /**
     * lambda-不确定度
     */
    var uLambda1: Double = 0.0

    /**
     * V-不确定度
     */
    var uV1: Double = 0.0

    /**
     * 声速及相对误差
     */
    var Vt1: Double = 0.0

    var E1: Double = 0.0

    constructor(
        f: Int,
        t: Int,
        Xi: Array<Int>,
        L: List<Int>,
        averageL: Int,
        LiAverageL: List<Int>,
        lambda: Double,
        V: Double,
        temL1: Double,
        uAL1: Double,
        uBL1: Double,
        uCL1: Double,
        uLambda1: Double,
        uV1: Double,
        Vt1: Double,
        E1: Double
    ) {
        this.f = f
        this.t = t
        this.Xi = Xi
        this.L = L
        this.averageL = averageL
        this.LiAverageL = LiAverageL
        this.lambda = lambda
        this.V = V
        this.temL1 = temL1
        this.uAL1 = uAL1
        this.uBL1 = uBL1
        this.uCL1 = uCL1
        this.uLambda1 = uLambda1
        this.uV1 = uV1
        this.Vt1 = Vt1
        this.E1 = E1
    }

    fun dataProcess(){

        /**
         * 计算部分
         */
         L = listOf(Xi[5]-Xi[0],Xi[6]-Xi[1],Xi[7]-Xi[2],Xi[8]-Xi[3],Xi[9]-Xi[4])

         averageL = (L[0]+L[1]+L[2]+L[3]+L[4])/5

         LiAverageL = listOf(L[0]-averageL,
            L[1]-averageL, L[2]-averageL,
            L[3]-averageL, L[4]-averageL)

         lambda = 0.4*averageL

         V = f*lambda

        /**
         * L-A类不确定度
         */
         temL1 = ((L[0]-averageL)*(L[1]-averageL)*(L[2]-averageL)
                *(L[3]-averageL)*(L[4]-averageL)).toDouble()

         uAL1 = 1.14* sqrt(0.05*temL1)

        /**
         * L-B类不确定度,mm
         */
         uBL1 = 0.000133

        /**
         * L-合成不确定度
         */
         uCL1 = sqrt(uAL1*uAL1 + uBL1*uBL1)

        /**
         * lambda-不确定度
         */
         uLambda1 = 0.4*uCL1

        /**
         * V-不确定度
         */
         uV1 = f*uLambda1

        /**
         * 声速及相对误差
         */
         Vt1 = V*sqrt(t/273.15+1)

         E1 = sqrt(V-Vt1)/Vt1

    }
}