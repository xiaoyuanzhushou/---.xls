package com.example.physicsexperiment

import kotlin.math.sqrt

/**
 * 存储实验10的数据，数据处理公式和数据处理的方法及结果的类
 */
class Database10 {

    /**
     * 1，He-Ne激光波长测量，单位mm，4组
     */

    /**
     * 输入部分,nm-lambdaS
     */
    var X0: Array<Double> = arrayOf(0.0,0.0,0.0,0.0)

    var X1: Array<Double> = arrayOf(0.0,0.0,0.0,0.0)

    val lambdaS: Double = 632.8

    /**
     * 2，钠双线波长差的测量，单位 次（N），mm（X10，XN），1组
     */

    /**
     * 输入部分（X10改为X0），nm-averagelambda,deltalambdaS
     */
    var N: Int = 0

    var X10: Double = 0.0

    var XN: Double = 0.0

    val averagelambda: Double = 589.3

    val deltalambdaS: Double = 0.597

    /**
     * 计算部分
     */
    var deltad: Double = (X1[0]-X0[0]+X1[1]-X0[1]+X1[2]-X0[2]+X1[3]-X0[3])/4

    var lambda: Double = 2*deltad/40

    var E1: Double = sqrt((lambda-lambdaS)*(lambda-lambdaS))/lambdaS

    var deltalambda: Double = (averagelambda*averagelambda)/(2*deltad)

    var E2: Double = sqrt((deltalambda-deltalambdaS)*(deltalambda-deltalambdaS))/deltalambdaS

    constructor(
        X0: Array<Double>,
        X1: Array<Double>,
        N: Int,
        X10: Double,
        XN: Double,
        deltad: Double,
        lambda: Double,
        E1: Double,
        deltalambda: Double,
        E2: Double
    ) {
        this.X0 = X0
        this.X1 = X1
        this.N = N
        this.X10 = X10
        this.XN = XN
        this.deltad = deltad
        this.lambda = lambda
        this.E1 = E1
        this.deltalambda = deltalambda
        this.E2 = E2
    }

    fun dataProcess(){

        /**
         * 计算部分
         */
        deltad = (X1[0]-X0[0]+X1[1]-X0[1]+X1[2]-X0[2]+X1[3]-X0[3])/4

        lambda = 2*deltad/40

        E1= sqrt((lambda-lambdaS)*(lambda-lambdaS))/lambdaS

        deltalambda = (averagelambda*averagelambda)/(2*deltad)

        E2 = sqrt((deltalambda-deltalambdaS)*(deltalambda-deltalambdaS))/deltalambdaS
    }
}