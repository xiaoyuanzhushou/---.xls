package com.example.physicsexperiment

import android.webkit.JsPromptResult
import kotlin.math.sqrt

/**
 * 存储实验6的数据，数据处理公式和数据处理的方法及结果的类
 */
class Database6 {

    /**
     * 1，测定圆环转动惯量数据，单位cm，g（m0，m1），s（T0，T1），3组/2组
     */

    /**
     * 填入部分（d1改为D，d2改为d，T0改为50T0，T1改为50T1）
     */
    var H: Array<Double> = arrayOf(0.0,0.0,0.0)

    var d1: Array<Double> = arrayOf(0.0,0.0,0.0)

    var d2: Array<Double> = arrayOf(0.0,0.0,0.0)

    var m0: Double = 0.0

    var T0: Double = 0.0

    var T1: Array<Double> = arrayOf(0.0,0.0,0.0)

    var D1: Double = 0.0

    var D2: Double = 0.0

    var m1: Double = 0.0

    /**
     * 2，验证平行轴定理，单位cm（a，dx），g，s，1组
     */

    /**
     * 填入部分（a改为2a，Ta改为50Ta）
     */
    var a: Double = 0.0

    var dx: Double = 0.0

    var m: Double = 0.0

    var Ta: Double = 0.0

    /**
     * 计算部分
     */
    var averaged1 = (d1[0]+d1[1]+d1[2])/3

    var averaged2 = (d2[0]+d2[1]+d2[2])/3

    var averageT1 = (T1[0]+T1[1]+T1[2])/3

    var averageH = (H[0]+H[1]+H[2])/3

    /**
     * 下面5个单位kg/(m*m)
     */
    var averageJ0: Double = (m0*9.8*averaged1*averaged2*averageT1*averageT1)/
            (12*3.14*3.14*averageH)

    var averageJ1: Double = ((m0+m1)*9.8*averaged1*averaged2*Ta)/(12*3.14*3.14*averageH)

    var averageJ2: Double = ((m0+2*m)*9.8*averaged1*averaged2*Ta)/(12*3.14*3.14*averageH)

    var averageJ: Double = averageJ1-averageJ0

    var averageJa: Double = (averageJ2 - averageJ0)/2

    /**
     * m0不确定度,g
     */
    var uAm06: Double = 0.0

    var uBm06: Double = 5.0/3

    var uCm06: Double = 5.0/3

    var uRm06: Double = uCm06/m0

    /**
     * m1不确定度,g
     */
    var uAm16: Double = 0.0

    var uBm16: Double = 5.0/3

    var uCm16: Double = 5.0/3

    /**
     * m0+m1不确定度,g
     */
    var uCm016: Double = sqrt(uCm06+uCm16)

    var uRm016: Double = uCm016/(m0+m1)

    /**
     * m0+2m不确定度,g
     */
    var uAm6: Double = 0.0

    var uBm6: Double = 5.0/3

    var uCm6: Double = 5.0/3

    var uCm02m6: Double = sqrt(uCm06+4*uCm6)

    var uRm02m: Double = uCm02m6/(m0+2*m)

    /**
     * D不确定度,cm
     */
    var uAd16: Double = 0.000000

    var uBd16: Double = 0.05/3

    var uCd16: Double = sqrt(uAd16*uAd16+uBd16*uBd16)

    var uRd16: Double = uCd16/averageH

    /**
     * d不确定度,cm
     */
    var uAd26: Double = 0.000000

    var uBd26: Double = 0.002/1.732

    var uCd26: Double = sqrt(uAd26*uAd26+uBd26*uBd26)

    var uRd26: Double = uCd26/averageH

    /**
     * H不确定度,cm
     */
    var uAH6: Double = 0.000000

    var uBH6: Double = 0.05/3

    var uCH6: Double = sqrt(uAH6*uAH6+uBH6*uBH6)

    var uRH6: Double = uCH6/averageH

    /**
     * T0不确定度,s
     */
    var uAT06: Double = 0.0

    var uBT06: Double = 0.2/1.732

    var uCT06: Double = 0.2/1.732

    var uRT06: Double = uCT06/T0

    /**
     * T1不确定度,s
     */
    var uAT16: Double = 0.0

    var uBT16: Double = 0.2/1.732

    var uCT16: Double = 0.2/1.732

    var uRT16: Double = uCT16/T0

    /**
     * Ta不确定度,s
     */
    var uATa6: Double = 0.0

    var uBTa6: Double = 0.2/1.732

    var uCTa6: Double = 0.2/1.732

    var uRTa6: Double = uCTa6/T0

    /**
     * 转动惯量J0,J1,J2,J不确定度,kg/(m*m)
     */
    var uRJ06: Double = sqrt(uRm06*uRm06+uRd16*uRd16+uRd26*uRd26+uRH6*uRH6+4*uRT06*uRT06)

    var uCJ06: Double = averageJ0*uRJ06

    var uRJ16: Double = sqrt(uRm016*uRm016+uRd16*uRd16+uRd26*uRd26+uRH6*uRH6+4*uRT16*uRT16)

    var uCJ16: Double = averageJ1*uRJ16

    var uRJ26: Double = sqrt(uRm02m*uRm02m+uRd16*uRd16+uRd26*uRd26+uRH6*uRH6+4*uRTa6*uRTa6)

    var uCJ26: Double = averageJ2*uRJ26

    var uCJ6: Double = sqrt(uCJ16*uCJ16+uCJ06*uCJ06)

    var uRJ6: Double = uCJ6/averageJ

    var uCJa6: Double = sqrt(uCJ26*uCJ26+uCJ06*uCJ06)/2

    var uRJa6: Double = uCJa6/averageJa

}