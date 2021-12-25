package com.example.myapplication.assistant.beans
import kotlin.math.ln

/**
 * 存储实验9的数据，数据处理公式和数据处理的方法及结果的类
 */
class Database9 {

    /**
     * 测高电阻，漏电电阻（相同），单位μF（C），V（U），nC（Q0），s（t），nC（Q），10组
     */

    /**
     * 输入部分
     */
    var C: Double = 1.0

    var U: Double = 0.0

    var Q0: Double = 0.0

    var t: Array<Double> = arrayOf(0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0)

    var Q: Array<Double> = arrayOf(1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0)

    /**
     * 计算部分
     */
    var averaget9: Double = (t[0]+t[1]+t[2]+t[3]+t[4]+t[5]+t[6]+t[7]+t[8]+t[9])/10

    var averaget29: Double = (t[0]*t[0]+t[1]*t[1]+t[2]*t[2]+t[3]*t[3]+
            t[4]*t[4]+t[5]*t[5]+t[6]*t[6]+t[7]*t[7]+t[8]*t[8]+t[9]*t[9])/10

    var averagetlnQ: Double = averaget9* ln(Q[0])+averaget9* ln(Q[1])+
            averaget9* ln(Q[2])+averaget9* ln(Q[3])+ averaget9* ln(Q[4])+
            averaget9* ln(Q[5])+ averaget9* ln(Q[6])+ averaget9* ln(Q[7])+
            averaget9* ln(Q[8])+ averaget9* ln(Q[9])

    var tlnQ: Double = t[0]* ln(Q[0])+t[1]* ln(Q[1])+t[2]* ln(Q[2])+t[3]* ln(Q[3])+
            t[4]* ln(Q[4])+t[5]* ln(Q[5])+t[6]* ln(Q[6])+
            t[7]* ln(Q[7])+t[8]* ln(Q[8])+t[9]* ln(Q[9])

    var R: Double = (averaget29-averaget9*averaget9)/(C*(averagetlnQ*tlnQ))

    constructor(
        C: Double,
        U: Double,
        Q0: Double,
        t: Array<Double>,
        Q: Array<Double>,
        averaget9: Double,
        averaget29: Double,
        averagetlnQ: Double,
        tlnQ: Double,
        R: Double
    ) {
        this.C = C
        this.U = U
        this.Q0 = Q0
        this.t = t
        this.Q = Q
        this.averaget9 = averaget9
        this.averaget29 = averaget29
        this.averagetlnQ = averagetlnQ
        this.tlnQ = tlnQ
        this.R = R
    }

    fun dataProcess(){

        /**
         * 计算部分
         */
        averaget9 = (t[0]+t[1]+t[2]+t[3]+t[4]+t[5]+t[6]+t[7]+t[8]+t[9])/10

        averaget29 = (t[0]*t[0]+t[1]*t[1]+t[2]*t[2]+t[3]*t[3]+
                t[4]*t[4]+t[5]*t[5]+t[6]*t[6]+t[7]*t[7]+t[8]*t[8]+t[9]*t[9])/10

        averagetlnQ = averaget9* ln(Q[0])+averaget9* ln(Q[1])+
                averaget9* ln(Q[2])+averaget9* ln(Q[3])+ averaget9* ln(Q[4])+
                averaget9* ln(Q[5])+ averaget9* ln(Q[6])+ averaget9* ln(Q[7])+
                averaget9* ln(Q[8])+ averaget9* ln(Q[9])

        tlnQ = t[0]* ln(Q[0])+t[1]* ln(Q[1])+t[2]* ln(Q[2])+t[3]* ln(Q[3])+
                t[4]* ln(Q[4])+t[5]* ln(Q[5])+t[6]* ln(Q[6])+
                t[7]* ln(Q[7])+t[8]* ln(Q[8])+t[9]* ln(Q[9])

        R = (averaget29-averaget9*averaget9)/(C*(averagetlnQ*tlnQ))
    }
}