package com.example.physicsexperiment

import kotlin.math.sqrt

/**
 * 存储实验7的数据，数据处理公式和数据处理的方法及结果的类
 */
class Database7 {

    /**
     * 1，霍尔元件灵敏度，单位mV/(mA*T)，1组
     */

    /**
     * 填入部分
     */
    var KH: Double = 1.0

    /**
     * 2，测量原始数据，单位A（I1），mA（I2），mV，5组
     */

    /**
     * 填入部分（I1改为i，I2改为I）
     */
    var I1: Double = 1.0

    var I2: Double = 1.0

    var U1: Array<Double> = arrayOf(0.0, 0.0, 0.0, 0.0, 0.0)

    var U2: Array<Double> = arrayOf(0.0, 0.0, 0.0, 0.0, 0.0)

    /**
     * 计算部分,cm
     */
    var UH7: Array<Double> = arrayOf((U1[0]+U2[0])/2,(U1[1]+U2[1])/2
        ,(U1[2]+U2[2])/2,(U1[3]+U2[3])/2,(U1[4]+U2[4])/2)

    var averageUH7: Double = (UH7[0]+UH7[1]+UH7[2]+UH7[3]+UH7[4])/5

    var B7: Double = averageUH7/(KH*I2)

    /**
     * UH不确定度
     */
    var uAUH7: Double = 0.000000

    var uBUH7: Double = 0.0

    var uCUH7: Double = sqrt(uAUH7*uAUH7+uBUH7*uBUH7)

    /**
     * I(i2)不确定度,mA
     */
    var uAI7: Double = 0.0

    var uBI7: Double = 0.1/1.732

    var uCI7: Double = uBI7

    /**
     * B不确定度
     */
    var uRB7: Double = 0.000000

    var uCB7: Double = B7*uRB7
}