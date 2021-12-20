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

    /**
     * 计算部分
     */
    var L: List<Int> = listOf(Xi[5]-Xi[0],Xi[6]-Xi[1],Xi[7]-Xi[2],Xi[8]-Xi[3],Xi[9]-Xi[4])

    var averageL: Int = (L[0]+L[1]+L[2]+L[3]+L[4])/5

    var LiAverageL: List<Int> = listOf(L[0]-averageL,
        L[1]-averageL, L[2]-averageL,
        L[3]-averageL, L[4]-averageL)

    var lambda: Double = 0.4*averageL

    var V: Double = f*lambda

    /**
     * L-A类不确定度
     */
    var temL1: Double = ((L[0]-averageL)*(L[1]-averageL)*(L[2]-averageL)
            *(L[3]-averageL)*(L[4]-averageL)).toDouble()

    var uAL1: Double = 1.14* sqrt(0.05*temL1)

    /**
     * L-B类不确定度,mm
     */
    var uBL1: Double = 0.000133

    /**
     * L-合成不确定度
     */
    var uCL1: Double = sqrt(uAL1*uAL1 + uBL1*uBL1)

    /**
     * lambda-不确定度
     */
    var uLambda1: Double = 0.4*uCL1

    /**
     * V-不确定度
     */
    var uV1: Double = f*uLambda1

    /**
     * 声速及相对误差
     */
    var Vt1: Double = V*sqrt(t/273.15+1)

    var E1: Double = sqrt(V-Vt1)/Vt1
}