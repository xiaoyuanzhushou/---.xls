package com.example.physicsexperiment

/**
 * 实现实验序号和题目存储的类
 */
class Question {

    private var order: Int = 0

    private var name: String = ""

    constructor(order: Int, name: String){
        this.order = order
        this.name = name
    }

}