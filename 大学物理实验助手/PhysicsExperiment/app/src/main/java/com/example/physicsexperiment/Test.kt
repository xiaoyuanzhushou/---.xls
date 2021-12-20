package com.example.physicsexperiment


    var data: Database1 = Database1()

    /**
     * 测试实验1的数据输入输出
     */
    fun main() {

        println("Test Start\n")

        println("input f\n")

        data.f = readLine()!!.toInt()

        println("input t\n")

        data.t = readLine()!!.toInt()

        println("input xi\n")

        for (i in 0..9) {

            data.Xi[i] = readLine()!!.toInt()
        }

        println(
            "f: ${data.f}\n" +
                    "t: ${data.t}\n" +
                    "xi: ${data.Xi}\n"
        )

    }
