package com.example.physicsexperiment

import kotlin.math.sqrt

/**
 * 存储实验2的数据，数据处理公式和数据处理的方法及结果的类
 */
class Database2 {

    /**
     * 1，测量钢丝伸长量，单位cm，8组
     */

    /**
     * 填入部分（a上，a下，m）
     */
    var aUp: Array<Double> = arrayOf(0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0)

    var aDown: Array<Double> = arrayOf(0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0)

    val m: Array<Int> = arrayOf(3,4,5,6,7,8,9,10)

    /**
     * 计算部分
     */
    var averagem: Int = (m[0]+m[1]+m[2]+m[3]+m[4]+m[5]+m[6]+m[7])/8

    var aAverage: Array<Double> = arrayOf((aUp[0]+aDown[0])/2,(aUp[1]+aDown[1])/2,
        (aUp[2]+aDown[2])/2,(aUp[3]+aDown[3])/2,(aUp[4]+aDown[4])/2,(aUp[5]+aDown[5])/2,
        (aUp[6]+aDown[6])/2,(aUp[7]+aDown[7])/2)

    var Xi: Array<Double> = arrayOf(aAverage[4]-aAverage[0],aAverage[5]-aAverage[1],
        aAverage[6]-aAverage[2],aAverage[7]-aAverage[3])

    var averageX: Double = (Xi[0]+Xi[1]+Xi[2]+Xi[3])/4

    var deltaXi: Array<Double> = arrayOf(Xi[0]-averageX,Xi[1]-averageX,Xi[2]-averageX,Xi[3]-averageX)

    /**
     * 2，测量钢丝直径D，单位mm，10组
     */

    /**
     * 填入部分
     */
    var D0: Double = 0.0

    var D1: Array<Double> = arrayOf(0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0)

    /**
     * 计算部分
     */
    var D: Array<Double> = arrayOf(D1[0]-D0,D1[1]-D0,D1[2]-D0,D1[3]-D0,D1[4]-D0
        ,D1[5]-D0,D1[6]-D0,D1[7]-D0,D1[8]-D0,D1[9]-D0)

    var averageD: Double = (D[0]+D[1]+D[2]+D[3]+D[4]+D[5]+D[6]+D[7]+D[8]+D[9])/10

    var deltaD: Array<Double> = arrayOf(D[0]-averageD,D[1]-averageD,D[2]-averageD,D[3]-averageD)

    /**
     * 3，测量H，L，b，单位cm，5组
     */

    /**
     * 填入部分
     */
    var X1: Array<Double> = arrayOf(0.0,0.0,0.0,0.0,0.0)

    var X2: Array<Double> = arrayOf(0.0,0.0,0.0,0.0,0.0)

    var b: Array<Double> = arrayOf(0.0,0.0,0.0,0.0,0.0)

    var L: Double = 0.0

    /**
     * 计算部分
     */
    var H: Array<Double> = arrayOf(0.0,0.0,0.0,0.0,0.0)

    var averageH: Double = 0.0

    var deltaH: Array<Double> = arrayOf(0.0,0.0,0.0,0.0,0.0)

    var averageL: Double = 0.0

    var averageb: Double = 0.0

    var deltab: Array<Double> = arrayOf(0.0,0.0,0.0,0.0,0.0)

    var averagel: Double = 0.0

    var averageE2: Double = 0.0

    /**
     * D-A类不确定度
     */
    var temD2: Double = 0.0

    var uAD2: Double = 0.0

    /**
     * D-B类不确定度,mm
     */
    var uBD2: Double = 0.00133

    /**
     * D-合成不确定度
     */
    var uCD2: Double = 0.0

    /**
     * X-A类不确定度
     */
    var temX2: Double = 0.0

    var uAX2: Double = 0.0

    /**
     * X-B类不确定度,mm
     */
    var uBX2: Double = 0.5/3

    /**
     * X-合成不确定度
     */
    var uCX2: Double = 0.0

    /**
     * H-A类不确定度
     */
    var temH2: Double = 0.0

    var uAH2: Double = 0.0

    /**
     * H-B类不确定度,mm
     */
    var uBH2: Double = 0.5/3

    /**
     * H-合成不确定度
     */
    var uCH2: Double = 0.0

    /**
     * L-A类不确定度
     */
    var uAL2: Double = 0.0

    /**
     * L-B类不确定度,mm
     */
    var uBL2: Double = 1.0

    /**
     * L-合成不确定度
     */
    var uCL2: Double = 0.0

    /**
     * b-A类不确定度
     */
    var temb2: Double = 0.0

    var uAb2: Double = 0.0

    /**
     * b-B类不确定度,mm
     */
    var uBb2: Double = 0.5/3

    /**
     * b-合成不确定度
     */
    var uCb2: Double = 0.0

    /**
     * m-A类不确定度
     */
    var uAm2: Double = 0.0

    /**
     * m-B类不确定度,kg
     */
    var uBm2: Double = 0.005/3

    /**
     * m-合成不确定度
     */
    var uCm2: Double = 0.0

    /**
     * l-不确定度（一块砝码的伸长量）
     */
    var uCl2: Double = 0.0

    /**
     * E-R类不确定度
     */
    var uRE2: Double = 0.0

    /**
     * E-合成不确定度
     */
    var uCE2: Double = 0.0

    constructor(
        aUp: Array<Double>,
        aDown: Array<Double>,
        aAverage: Array<Double>,
        Xi: Array<Double>,
        averageX: Double,
        deltaXi: Array<Double>,
        D0: Double,
        D1: Array<Double>,
        D: Array<Double>,
        averageD: Double,
        deltaD: Array<Double>,
        X1: Array<Double>,
        X2: Array<Double>,
        b: Array<Double>,
        L: Double,
        H: Array<Double>,
        averageH: Double,
        deltaH: Array<Double>,
        averageL: Double,
        averageb: Double,
        deltab: Array<Double>,
        averagel: Double,
        averageE2: Double,
        temD2: Double,
        uAD2: Double,
        uBD2: Double,
        uCD2: Double,
        temX2: Double,
        uAX2: Double,
        uBX2: Double,
        uCX2: Double,
        temH2: Double,
        uAH2: Double,
        uBH2: Double,
        uCH2: Double,
        uAL2: Double,
        uBL2: Double,
        uCL2: Double,
        temb2: Double,
        uAb2: Double,
        uBb2: Double,
        uCb2: Double,
        uAm2: Double,
        uBm2: Double,
        uCm2: Double,
        uCl2: Double,
        uRE2: Double,
        uCE2: Double
    ) {
        this.aUp = aUp
        this.aDown = aDown
        this.aAverage = aAverage
        this.Xi = Xi
        this.averageX = averageX
        this.deltaXi = deltaXi
        this.D0 = D0
        this.D1 = D1
        this.D = D
        this.averageD = averageD
        this.deltaD = deltaD
        this.X1 = X1
        this.X2 = X2
        this.b = b
        this.L = L
        this.H = H
        this.averageH = averageH
        this.deltaH = deltaH
        this.averageL = averageL
        this.averageb = averageb
        this.deltab = deltab
        this.averagel = averagel
        this.averageE2 = averageE2
        this.temD2 = temD2
        this.uAD2 = uAD2
        this.uBD2 = uBD2
        this.uCD2 = uCD2
        this.temX2 = temX2
        this.uAX2 = uAX2
        this.uBX2 = uBX2
        this.uCX2 = uCX2
        this.temH2 = temH2
        this.uAH2 = uAH2
        this.uBH2 = uBH2
        this.uCH2 = uCH2
        this.uAL2 = uAL2
        this.uBL2 = uBL2
        this.uCL2 = uCL2
        this.temb2 = temb2
        this.uAb2 = uAb2
        this.uBb2 = uBb2
        this.uCb2 = uCb2
        this.uAm2 = uAm2
        this.uBm2 = uBm2
        this.uCm2 = uCm2
        this.uCl2 = uCl2
        this.uRE2 = uRE2
        this.uCE2 = uCE2
    }

    fun dataProcess(){
       averagem = (m[0]+m[1]+m[2]+m[3]+m[4]+m[5]+m[6]+m[7])/8

       aAverage = arrayOf((aUp[0]+aDown[0])/2,(aUp[1]+aDown[1])/2,
            (aUp[2]+aDown[2])/2,(aUp[3]+aDown[3])/2,(aUp[4]+aDown[4])/2,(aUp[5]+aDown[5])/2,
            (aUp[6]+aDown[6])/2,(aUp[7]+aDown[7])/2)

        Xi = arrayOf(aAverage[4]-aAverage[0],aAverage[5]-aAverage[1],
            aAverage[6]-aAverage[2],aAverage[7]-aAverage[3])

        averageX = (Xi[0]+Xi[1]+Xi[2]+Xi[3])/4

        deltaXi = arrayOf(Xi[0]-averageX,Xi[1]-averageX,Xi[2]-averageX,Xi[3]-averageX)

        D = arrayOf(D1[0]-D0,D1[1]-D0,D1[2]-D0,D1[3]-D0,D1[4]-D0
            ,D1[5]-D0,D1[6]-D0,D1[7]-D0,D1[8]-D0,D1[9]-D0)

        averageD = (D[0]+D[1]+D[2]+D[3]+D[4]+D[5]+D[6]+D[7]+D[8]+D[9])/10

        deltaD = arrayOf(D[0]-averageD,D[1]-averageD,D[2]-averageD,D[3]-averageD)

        H = arrayOf(sqrt((X1[0]-X2[0])*(X1[0]-X2[0]))
            ,sqrt((X1[1]-X2[1])*(X1[1]-X2[1])),sqrt((X1[2]-X2[2])*(X1[2]-X2[2]))
            ,sqrt((X1[3]-X2[3])*(X1[3]-X2[3])),sqrt((X1[4]-X2[4])*(X1[4]-X2[4])))

        averageH = (H[0]+H[1]+H[2]+H[3]+H[4])/5

        deltaH = arrayOf(H[0]-averageH,H[1]-averageH,H[2]-averageH
            ,H[3]-averageH,H[4]-averageH)

        averageL = 0.25*averageX

        averageb = (b[0]+b[1]+b[2]+b[3]+b[4])/5

        deltab = arrayOf(b[0]-averageb,b[1]-averageb,b[2]-averageb
            ,b[3]-averageb,b[4]-averageb)

        averagel = averageX/4

        averageE2 =
            (400*averagem*9.8*averageL*averageH)/(3.14*averageD*averageD*averageb*averagel)

        /**
         * D-A类不确定度
         */
        temD2 = ((deltaD[0]*deltaD[0])+(deltaD[1]*deltaD[1])+(deltaD[2]*deltaD[2])
                +(deltaD[3]*deltaD[3])+(deltaD[4]*deltaD[4])+(deltaD[5]*deltaD[5])
                +(deltaD[6]*deltaD[6]) +(deltaD[7]*deltaD[7])+(deltaD[8]*deltaD[8])
                +(deltaD[9]*deltaD[9]))

        uAD2 = 1.06* sqrt(temD2/90)

        /**
         * D-B类不确定度,mm
         */
        uBD2 = 0.00133

        /**
         * D-合成不确定度
         */
        uCD2 = sqrt(uAD2*uAD2 + uBD2*uBD2)

        /**
         * X-A类不确定度
         */
        temX2 = ((deltaXi[0]*deltaXi[0])+(deltaXi[1]*deltaXi[1])+(deltaXi[2]*deltaXi[2])
                +(deltaXi[3]*deltaXi[3]))

        uAX2 = 1.20* sqrt(temX2/12)

        /**
         * X-B类不确定度,mm
         */
        uBX2 = 0.5/3

        /**
         * X-合成不确定度
         */
        uCX2 = sqrt(uAX2*uAX2 + uBX2*uBX2)

        /**
         * H-A类不确定度
         */
        temH2 = ((deltaH[0]*deltaH[0])+(deltaH[1]*deltaH[1])+(deltaH[2]*deltaH[2])
                +(deltaH[3]*deltaH[3])+(deltaH[4]*deltaH[4]))

        uAH2 = 1.14* sqrt(temH2/20)

        /**
         * H-B类不确定度,mm
         */
        uBH2 = 0.5/3

        /**
         * H-合成不确定度
         */
        uCH2 = sqrt(uAH2*uAH2 + uBH2*uBH2)

        /**
         * L-A类不确定度
         */
        uAL2 = 0.0

        /**
         * L-B类不确定度,mm
         */
        uBL2 = 1.0

        /**
         * L-合成不确定度
         */
        uCL2 = sqrt(uAL2*uAL2 + uBL2*uBL2)

        /**
         * b-A类不确定度
         */
        temb2 = ((deltab[0]*deltab[0])+(deltab[1]*deltab[1])+(deltab[2]*deltab[2])
                +(deltab[3]*deltab[3])+(deltab[4]*deltab[4]))

        uAb2 = 1.14* sqrt(temb2/20)

        /**
         * b-B类不确定度,mm
         */
        uBb2 = 0.5/3

        /**
         * b-合成不确定度
         */
        uCb2 = sqrt(uAb2*uAb2+ uBb2*uBb2)

        /**
         * m-A类不确定度
         */
        uAm2 = 0.0

        /**
         * m-B类不确定度,kg
         */
        uBm2 = 0.005/3

        /**
         * m-合成不确定度
         */
        uCm2 = sqrt(uAm2*uAm2 + uBm2*uBm2)

        /**
         * l-不确定度（一块砝码的伸长量）
         */
        uCl2 = uCX2/4

        /**
         * E-R类不确定度
         */
        uRE2 = (uCm2/averagem)*(uCm2/averagem)+(uCL2/averageL)*(uCL2/averageL)+
                (uCH2/averageH)*(uCH2/averageH)+(uCD2/averageD)*(uCD2/averageD)+
                (uCb2/averageb)*(uCb2/averageb)+(uCl2/averagel)*(uCl2/averagel)

        /**
         * E-合成不确定度
         */
        uCE2 = averageE2*uRE2
    }
}