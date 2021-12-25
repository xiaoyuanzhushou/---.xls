package com.example.physicsexperiment

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

    constructor(
        H: Array<Double>,
        d1: Array<Double>,
        d2: Array<Double>,
        m0: Double,
        T0: Double,
        T1: Array<Double>,
        D1: Double,
        D2: Double,
        m1: Double,
        a: Double,
        dx: Double,
        m: Double,
        Ta: Double,
        averaged1: Double,
        averaged2: Double,
        averageT1: Double,
        averageH: Double,
        averageJ0: Double,
        averageJ1: Double,
        averageJ2: Double,
        averageJ: Double,
        averageJa: Double,
        uAm06: Double,
        uBm06: Double,
        uCm06: Double,
        uRm06: Double,
        uAm16: Double,
        uBm16: Double,
        uCm16: Double,
        uCm016: Double,
        uRm016: Double,
        uAm6: Double,
        uBm6: Double,
        uCm6: Double,
        uCm02m6: Double,
        uRm02m: Double,
        uAd16: Double,
        uBd16: Double,
        uCd16: Double,
        uRd16: Double,
        uAd26: Double,
        uBd26: Double,
        uCd26: Double,
        uRd26: Double,
        uAH6: Double,
        uBH6: Double,
        uCH6: Double,
        uRH6: Double,
        uAT06: Double,
        uBT06: Double,
        uCT06: Double,
        uRT06: Double,
        uAT16: Double,
        uBT16: Double,
        uCT16: Double,
        uRT16: Double,
        uATa6: Double,
        uBTa6: Double,
        uCTa6: Double,
        uRTa6: Double,
        uRJ06: Double,
        uCJ06: Double,
        uRJ16: Double,
        uCJ16: Double,
        uRJ26: Double,
        uCJ26: Double,
        uCJ6: Double,
        uRJ6: Double,
        uCJa6: Double,
        uRJa6: Double
    ) {
        this.H = H
        this.d1 = d1
        this.d2 = d2
        this.m0 = m0
        this.T0 = T0
        this.T1 = T1
        this.D1 = D1
        this.D2 = D2
        this.m1 = m1
        this.a = a
        this.dx = dx
        this.m = m
        this.Ta = Ta
        this.averaged1 = averaged1
        this.averaged2 = averaged2
        this.averageT1 = averageT1
        this.averageH = averageH
        this.averageJ0 = averageJ0
        this.averageJ1 = averageJ1
        this.averageJ2 = averageJ2
        this.averageJ = averageJ
        this.averageJa = averageJa
        this.uAm06 = uAm06
        this.uBm06 = uBm06
        this.uCm06 = uCm06
        this.uRm06 = uRm06
        this.uAm16 = uAm16
        this.uBm16 = uBm16
        this.uCm16 = uCm16
        this.uCm016 = uCm016
        this.uRm016 = uRm016
        this.uAm6 = uAm6
        this.uBm6 = uBm6
        this.uCm6 = uCm6
        this.uCm02m6 = uCm02m6
        this.uRm02m = uRm02m
        this.uAd16 = uAd16
        this.uBd16 = uBd16
        this.uCd16 = uCd16
        this.uRd16 = uRd16
        this.uAd26 = uAd26
        this.uBd26 = uBd26
        this.uCd26 = uCd26
        this.uRd26 = uRd26
        this.uAH6 = uAH6
        this.uBH6 = uBH6
        this.uCH6 = uCH6
        this.uRH6 = uRH6
        this.uAT06 = uAT06
        this.uBT06 = uBT06
        this.uCT06 = uCT06
        this.uRT06 = uRT06
        this.uAT16 = uAT16
        this.uBT16 = uBT16
        this.uCT16 = uCT16
        this.uRT16 = uRT16
        this.uATa6 = uATa6
        this.uBTa6 = uBTa6
        this.uCTa6 = uCTa6
        this.uRTa6 = uRTa6
        this.uRJ06 = uRJ06
        this.uCJ06 = uCJ06
        this.uRJ16 = uRJ16
        this.uCJ16 = uCJ16
        this.uRJ26 = uRJ26
        this.uCJ26 = uCJ26
        this.uCJ6 = uCJ6
        this.uRJ6 = uRJ6
        this.uCJa6 = uCJa6
        this.uRJa6 = uRJa6
    }

    fun dataProcess(){

        /**
         * 计算部分
         */
        averaged1 = (d1[0]+d1[1]+d1[2])/3

        averaged2 = (d2[0]+d2[1]+d2[2])/3

        averageT1 = (T1[0]+T1[1]+T1[2])/3

        averageH = (H[0]+H[1]+H[2])/3

        /**
         * 下面5个单位kg/(m*m)
         */
        averageJ0 = (m0*9.8*averaged1*averaged2*averageT1*averageT1)/
                (12*3.14*3.14*averageH)

        averageJ1 = ((m0+m1)*9.8*averaged1*averaged2*Ta)/(12*3.14*3.14*averageH)

        averageJ2 = ((m0+2*m)*9.8*averaged1*averaged2*Ta)/(12*3.14*3.14*averageH)

        averageJ = averageJ1-averageJ0

        averageJa = (averageJ2 - averageJ0)/2

        /**
         * m0不确定度,g
         */
        uAm06 = 0.0

        uBm06 = 5.0/3

        uCm06 = 5.0/3

        uRm06 = uCm06/m0

        /**
         * m1不确定度,g
         */
        uAm16 = 0.0

        uBm16 = 5.0/3

        uCm16 = 5.0/3

        /**
         * m0+m1不确定度,g
         */
        uCm016 = sqrt(uCm06+uCm16)

        uRm016 = uCm016/(m0+m1)

        /**
         * m0+2m不确定度,g
         */
        uAm6 = 0.0

        uBm6 = 5.0/3

        uCm6 = 5.0/3

        uCm02m6 = sqrt(uCm06+4*uCm6)

        uRm02m = uCm02m6/(m0+2*m)

        /**
         * D不确定度,cm
         */
        uAd16 = 0.000000

        uBd16 = 0.05/3

        uCd16 = sqrt(uAd16*uAd16+uBd16*uBd16)

        uRd16 = uCd16/averageH

        /**
         * d不确定度,cm
         */
        uAd26 = 0.000000

        uBd26 = 0.002/1.732

        uCd26 = sqrt(uAd26*uAd26+uBd26*uBd26)

        uRd26 = uCd26/averageH

        /**
         * H不确定度,cm
         */
        uAH6 = 0.000000

        uBH6 = 0.05/3

        uCH6 = sqrt(uAH6*uAH6+uBH6*uBH6)

        uRH6 = uCH6/averageH

        /**
         * T0不确定度,s
         */
        uAT06 = 0.0

        uBT06 = 0.2/1.732

        uCT06 = 0.2/1.732

        uRT06 = uCT06/T0

        /**
         * T1不确定度,s
         */
        uAT16 = 0.0

        uBT16= 0.2/1.732

        uCT16 = 0.2/1.732

        uRT16 = uCT16/T0

        /**
         * Ta不确定度,s
         */
        uATa6 = 0.0

        uBTa6 = 0.2/1.732

        uCTa6 = 0.2/1.732

        uRTa6 = uCTa6/T0

        /**
         * 转动惯量J0,J1,J2,J不确定度,kg/(m*m)
         */
        uRJ06 = sqrt(uRm06*uRm06+uRd16*uRd16+uRd26*uRd26+uRH6*uRH6+4*uRT06*uRT06)

        uCJ06 = averageJ0*uRJ06

        uRJ16 = sqrt(uRm016*uRm016+uRd16*uRd16+uRd26*uRd26+uRH6*uRH6+4*uRT16*uRT16)

        uCJ16 = averageJ1*uRJ16

        uRJ26 = sqrt(uRm02m*uRm02m+uRd16*uRd16+uRd26*uRd26+uRH6*uRH6+4*uRTa6*uRTa6)

        uCJ26 = averageJ2*uRJ26

        uCJ6 = sqrt(uCJ16*uCJ16+uCJ06*uCJ06)

        uRJ6 = uCJ6/averageJ

        uCJa6 = sqrt(uCJ26*uCJ26+uCJ06*uCJ06)/2

        uRJa6 = uCJa6/averageJa
    }
}