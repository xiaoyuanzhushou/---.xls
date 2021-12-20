package com.example.physicsexperiment

import kotlin.math.sqrt

/**
 * 存储实验11的数据，数据处理公式和数据处理的方法及结果的类
 */
class Database11 {

    /**
     * 1，应变片，单位Ω（RX），1组
     */

    /**
     * 输入部分
     */
    var K: Double = 2.25

    var RX: Double = 0.0

    /**
     * 2，数据记录，单位mA（I），Ω（S），Ω（RbUp），Ω（RbDown），6组
     */

    /**
     * 输入部分，RbUp改为上行Rb，RbDown改为下行Rb
     */
    var I: Double = 0.0

    var S: Int = 0

    var RbUp: Array<Double> = arrayOf(0.0,0.0,0.0,0.0,0.0,0.0)

    var RbDown: Array<Double> = arrayOf(0.0,0.0,0.0,0.0,0.0,0.0)

    /**
     * 计算部分
     */
    var deltaR: Array<Double> = arrayOf(((RbUp[3]+RbDown[3])-(RbUp[0]+RbDown[0]))/2,
        ((RbUp[4]+RbDown[4])-(RbUp[1]+RbDown[1]))/2,((RbUp[5]+RbDown[5])-(RbUp[2]+RbDown[2]))/2)

    var averageDeltaR: Double = (((RbUp[3]+RbDown[3])-(RbUp[0]+RbDown[0]))/2+
            ((RbUp[4]+RbDown[4])-(RbUp[1]+RbDown[1]))/2+
            ((RbUp[5]+RbDown[5])-(RbUp[2]+RbDown[2]))/2)/3

    var epsilonX: Double = 0.000000

    /**
     * 不确定度,Ω
     */
    var tem11: Double = (deltaR[0]-averageDeltaR)+(deltaR[1]-averageDeltaR)+(deltaR[2]-averageDeltaR)

    var uAdeltaR: Double = 1.32*(tem11/6)

    var uBdeltaR: Double = 0.014444

    var uCdeltaR: Double = sqrt(uAdeltaR*uAdeltaR+uBdeltaR*uBdeltaR)

    var uRepsilonX: Double = 0.000000

    var uCepsilonX: Double = 0.000000

    constructor(
        K: Double,
        RX: Double,
        I: Double,
        S: Int,
        RbUp: Array<Double>,
        RbDown: Array<Double>,
        deltaR: Array<Double>,
        averageDeltaR: Double,
        epsilonX: Double,
        tem11: Double,
        uAdeltaR: Double,
        uBdeltaR: Double,
        uCdeltaR: Double,
        uRepsilonX: Double,
        uCepsilonX: Double
    ) {
        this.K = K
        this.RX = RX
        this.I = I
        this.S = S
        this.RbUp = RbUp
        this.RbDown = RbDown
        this.deltaR = deltaR
        this.averageDeltaR = averageDeltaR
        this.epsilonX = epsilonX
        this.tem11 = tem11
        this.uAdeltaR = uAdeltaR
        this.uBdeltaR = uBdeltaR
        this.uCdeltaR = uCdeltaR
        this.uRepsilonX = uRepsilonX
        this.uCepsilonX = uCepsilonX
    }
}