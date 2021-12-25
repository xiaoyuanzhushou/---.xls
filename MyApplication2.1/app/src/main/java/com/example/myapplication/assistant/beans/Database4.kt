package com.example.myapplication.assistant.beans

import kotlin.math.sqrt

/**
 * 存储实验4的数据，数据处理公式和数据处理的方法及结果的类
 */
class Database4 {

    /**
     * 1，物距像距法测凸透镜焦距，单位cm，1组
     */

    /**
     * 填入部分
     */
    var u: Double = 0.0

    var v: Double = 0.0

    /**
     * 2，自准直法测凸透镜焦距，单位cm，5组
     */

    /**
     * 填入部分
     */
    var f: Array<Double> = arrayOf(0.0,0.0,0.0,0.0,0.0)

    /**
     * 3，位移法测凸透镜焦距，单位cm，5组
     */

    /**
     * 填入部分
     */
    var L: Array<Double> = arrayOf(0.0,0.0,0.0,0.0,0.0)

    var D: Double = 0.0

    /**
     * 4，物距像距法测凹透镜焦距，单位cm，1组
     */

    /**
     * 填入部分（改为A'B'，A"B"，L2）
     */
    var positionOfA1B1: Double = 0.0

    var positionOfA2B2: Double = 0.0

    var positionOfL2: Double = 0.0

    /**
     * 5，自准直法测凹透镜焦距，单位cm，5组
     */

    /**
     * 填入部分
     */
    var x1: Array<Double> = arrayOf(0.0,0.0,0.0,0.0,0.0)

    var x2: Array<Double> = arrayOf(0.0,0.0,0.0,0.0,0.0)

    /**
     * X-不确定度,mm
     */
    var uBX41: Double = 0.5/3

    var uCX41: Double = uBX41

    /**
     * u和v的不确定度,cm
     */
    var uCu41: Double = 0.000000

    var uCv41: Double = 0.000000

    var uRf41: Double = 0.000000

    var uCf41: Double = 0.000000

    var f41: Double = u*v/(u+v)

    /**
     * 2,
     */
    var averagef42: Double = (f[0]+f[1]+f[2]+f[3]+f[4])/5

    var uAaveragef4: Double = 0.000000

    var uBaveragef4: Double = 0.5/3

    var uCaveragef4: Double = sqrt(uAaveragef4*uAaveragef4+uBaveragef4*uBaveragef4)

    var uRaveragef4: Double = uCaveragef4/averagef42

    /**
     * 3
     */
    var averageL: Double = (L[0]+L[1]+L[2]+L[3]+L[4])/5

    var tem43: Double = (L[0]-averageL)*(L[0]-averageL)+(L[1]-averageL)*(L[1]-averageL)+
            (L[2]-averageL)*(L[2]-averageL)+(L[3]-averageL)*(L[3]-averageL)+
            (L[4]-averageL)*(L[4]-averageL)

    var uAL4: Double = 1.14* sqrt(tem43/20)

    var uBL4: Double = 0.000000

    var uCL4: Double = sqrt(uAL4*uAL4+uBL4*uBL4)

    var uCD4: Double = 0.000000

    var uBD4: Double = uCD4

    var averagef43: Double = (D*D-averageL*averageL)/4*D

    var uRf43: Double = 0.000000

    var uCf43: Double = averagef43*uRf43

    /**
     * 4
     */
    var f44: Double = (u*v)/(v-u)

    var uCu44: Double = 0.000000

    var uCv44: Double = 0.000000

    var uRf44: Double = 0.000000

    var uCf44: Double = f44*uRf44

    /**
     * 5
     */
    var averagef45: Double = (f[0]+f[1]+f[2]+f[3]+f[4])/5

    var uAf45: Double = 0.000000

    var uBf45: Double = 0.5/3

    var uCf45: Double = sqrt(uAf45*uAf45+uBf45*uBf45)

    var uRf45: Double = uCf45/averagef45

    constructor(
        u: Double,
        v: Double,
        f: Array<Double>,
        L: Array<Double>,
        D: Double,
        positionOfA1B1: Double,
        positionOfA2B2: Double,
        positionOfL2: Double,
        x1: Array<Double>,
        x2: Array<Double>,
        uBX41: Double,
        uCX41: Double,
        uCu41: Double,
        uCv41: Double,
        uRf41: Double,
        uCf41: Double,
        f41: Double,
        averagef42: Double,
        uAaveragef4: Double,
        uBaveragef4: Double,
        uCaveragef4: Double,
        uRaveragef4: Double,
        averageL: Double,
        tem43: Double,
        uAL4: Double,
        uBL4: Double,
        uCL4: Double,
        uCD4: Double,
        uBD4: Double,
        averagef43: Double,
        uRf43: Double,
        uCf43: Double,
        f44: Double,
        uCu44: Double,
        uCv44: Double,
        uRf44: Double,
        uCf44: Double,
        averagef45: Double,
        uAf45: Double,
        uBf45: Double,
        uCf45: Double,
        uRf45: Double
    ) {
        this.u = u
        this.v = v
        this.f = f
        this.L = L
        this.D = D
        this.positionOfA1B1 = positionOfA1B1
        this.positionOfA2B2 = positionOfA2B2
        this.positionOfL2 = positionOfL2
        this.x1 = x1
        this.x2 = x2
        this.uBX41 = uBX41
        this.uCX41 = uCX41
        this.uCu41 = uCu41
        this.uCv41 = uCv41
        this.uRf41 = uRf41
        this.uCf41 = uCf41
        this.f41 = f41
        this.averagef42 = averagef42
        this.uAaveragef4 = uAaveragef4
        this.uBaveragef4 = uBaveragef4
        this.uCaveragef4 = uCaveragef4
        this.uRaveragef4 = uRaveragef4
        this.averageL = averageL
        this.tem43 = tem43
        this.uAL4 = uAL4
        this.uBL4 = uBL4
        this.uCL4 = uCL4
        this.uCD4 = uCD4
        this.uBD4 = uBD4
        this.averagef43 = averagef43
        this.uRf43 = uRf43
        this.uCf43 = uCf43
        this.f44 = f44
        this.uCu44 = uCu44
        this.uCv44 = uCv44
        this.uRf44 = uRf44
        this.uCf44 = uCf44
        this.averagef45 = averagef45
        this.uAf45 = uAf45
        this.uBf45 = uBf45
        this.uCf45 = uCf45
        this.uRf45 = uRf45
    }


    fun dataProcess(){

        /**
         * X-不确定度,mm
         */
        uBX41 = 0.5/3

        uCX41 = uBX41

        /**
         * u和v的不确定度,cm
         */
        uCu41 = 0.000000

        uCv41 = 0.000000

        uRf41 = 0.000000

        uCf41 = 0.000000

        f41 = u*v/(u+v)

        /**
         * 2,
         */
        averagef42 = (f[0]+f[1]+f[2]+f[3]+f[4])/5

        uAaveragef4 = 0.000000

        uBaveragef4 = 0.5/3

        uCaveragef4 = sqrt(uAaveragef4*uAaveragef4+uBaveragef4*uBaveragef4)

        uRaveragef4 = uCaveragef4/averagef42

        /**
         * 3
         */
        averageL = (L[0]+L[1]+L[2]+L[3]+L[4])/5

        tem43 = (L[0]-averageL)*(L[0]-averageL)+(L[1]-averageL)*(L[1]-averageL)+
                (L[2]-averageL)*(L[2]-averageL)+(L[3]-averageL)*(L[3]-averageL)+
                (L[4]-averageL)*(L[4]-averageL)

        uAL4 = 1.14* sqrt(tem43/20)

        uBL4 = 0.000000

        uCL4 = sqrt(uAL4*uAL4+uBL4*uBL4)

        uCD4 = 0.000000

        uBD4 = uCD4

        averagef43 = (D*D-averageL*averageL)/4*D

        uRf43 = 0.000000

        uCf43 = averagef43*uRf43

        /**
         * 4
         */
        f44 = (u*v)/(v-u)

        uCu44 = 0.000000

        uCv44 = 0.000000

        uRf44 = 0.000000

        uCf44 = f44*uRf44

        /**
         * 5
         */
        averagef45 = (f[0]+f[1]+f[2]+f[3]+f[4])/5

        uAf45 = 0.000000

        uBf45 = 0.5/3

        uCf45 = sqrt(uAf45*uAf45+uBf45*uBf45)

        uRf45 = uCf45/averagef45
    }
}