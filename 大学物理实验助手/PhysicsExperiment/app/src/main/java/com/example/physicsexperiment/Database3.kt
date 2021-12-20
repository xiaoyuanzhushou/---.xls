package com.example.physicsexperiment

import kotlin.math.sqrt

/**
 * 存储实验3的数据，数据处理公式和数据处理的方法及结果的类
 */
class Database3 {

    /**
     * 1，U1-I数据，单位mA(I1)，V(U1)，8组
     */

    /**
     * 填入部分（I1改为I）
     */
    var I1: Array<Double> = arrayOf(0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0)

    var U1: Array<Double> = arrayOf(0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0)

    /**
     * 计算部分
     */
    var averageI1: Double = (I1[0]+I1[1]+I1[2]+I1[3]+I1[4]+I1[5]+I1[6]+I1[7])/8

    var deltaI1: Array<Double> = arrayOf(I1[0]-averageI1,I1[1]-averageI1
        ,I1[2]-averageI1,I1[3]-averageI1,I1[4]-averageI1
        ,I1[5]-averageI1,I1[6]-averageI1,I1[7]-averageI1)

    var averageU1: Double = (U1[0]+U1[1]+U1[2]+U1[3]+U1[4]+U1[5]+U1[6]+U1[7])/8

    var deltaU1: Array<Double> = arrayOf(U1[0]-averageU1,U1[1]-averageU1
        ,U1[2]-averageU1,U1[3]-averageU1,U1[4]-averageU1
        ,U1[5]-averageU1,U1[6]-averageU1,U1[7]-averageU1)

    /**
     * 2，UA-I数据，单位mA(I2)，V(UA)，8组
     */

    /**
     * 填入部分（I2改为I）
     */
    var I2: Array<Double> = arrayOf(0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0)

    var UA: Array<Double> = arrayOf(0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0)

    /**
     * 计算部分
     */
    var averageI2: Double = (I2[0]+I2[1]+I2[2]+I2[3]+I2[4]+I2[5]+I2[6]+I2[7])/8

    var deltaI2: Array<Double> = arrayOf(I2[0]-averageI2,I2[1]-averageI2
        ,I2[2]-averageI2,I2[3]-averageI2,I2[4]-averageI2
        ,I2[5]-averageI2,I2[6]-averageI2,I2[7]-averageI2)

    var averageUA: Double = (UA[0]+UA[1]+UA[2]+UA[3]+UA[4]+UA[5]+UA[6]+UA[7])/8

    var deltaUA: Array<Double> = arrayOf(UA[0]-averageUA,UA[1]-averageUA
        ,UA[2]-averageUA,UA[3]-averageUA,UA[4]-averageUA
        ,UA[5]-averageUA,UA[6]-averageUA,UA[7]-averageUA)

    /**
     * I1-A类不确定度
     */
    var temI13: Double = deltaI1[0]*deltaI1[0]+deltaI1[1]*deltaI1[1]+
            deltaI1[2]*deltaI1[2]+deltaI1[3]*deltaI1[3]+deltaI1[4]*deltaI1[4]+
            deltaI1[5]*deltaI1[5]+deltaI1[6]*deltaI1[6]+deltaI1[7]*deltaI1[7]

    var uAI13: Double = 1.14* sqrt(temI13/56)

    /**
     * I1-B类不确定度,mA
     */
    var uBI13: Double = 1.0/3

    /**
     * I1-合成不确定度
     */

    var uCI13: Double = sqrt(uAI13*uAI13 + uBI13*uBI13)

    /**
     * U1-A类不确定度
     */
    var temU13: Double = deltaU1[0]*deltaU1[0]+deltaU1[1]*deltaU1[1]+
            deltaU1[2]*deltaU1[2]+deltaU1[3]*deltaU1[3]+deltaU1[4]*deltaU1[4]+
            deltaU1[5]*deltaU1[5]+deltaU1[6]*deltaU1[6]+deltaU1[7]*deltaU1[7]

    var uAU13: Double = 1.14* sqrt(temU13/56)

    /**
     * U1-B类不确定度,V
     */
    var uBU13: Double = 0.1/3

    /**
     * U1-合成不确定度
     */
    var uCU13: Double = sqrt(uAU13*uAU13 + uBU13*uBU13)

    /**
     * I2-A类不确定度
     */
    var temI23: Double = deltaI2[0]*deltaI2[0]+deltaI2[1]*deltaI2[1]+
            deltaI2[2]*deltaI2[2]+deltaI2[3]*deltaI2[3]+deltaI2[4]*deltaI2[4]+
            deltaI2[5]*deltaI2[5]+deltaI2[6]*deltaI2[6]+deltaI2[7]*deltaI2[7]

    var uAI23: Double = 1.14* sqrt(temI23/56)

    /**
     * I2-B类不确定度,mA
     */
    var uBI23: Double = 0.1/3

    /**
     * I2-合成不确定度
     */
    var uCI23: Double = sqrt(uAI23*uAI23 + uBI23*uBI23)

    /**
     * UA-A类不确定度
     */
    var temUA3: Double = deltaUA[0]*deltaUA[0]+deltaUA[1]*deltaUA[1]+
            deltaUA[2]*deltaUA[2]+deltaUA[3]*deltaUA[3]+deltaUA[4]*deltaUA[4]+
            deltaUA[5]*deltaUA[5]+deltaUA[6]*deltaUA[6]+deltaUA[7]*deltaUA[7]

    var uAUA3: Double = 1.14* sqrt(temUA3/56)

    /**
     * UA-B类不确定度,V
     */
    var uBUA3: Double = 0.1/3

    /**
     * UA-合成不确定度
     */
    var uCUA3: Double = sqrt(uAUA3*uAUA3 + uBUA3*uBUA3)
}