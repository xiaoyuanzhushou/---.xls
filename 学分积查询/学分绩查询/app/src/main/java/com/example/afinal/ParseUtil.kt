package com.example.afinal

import java.io.File
import org.jsoup.Jsoup

fun main(){

    val scoreService = ScoreService()

    val scores =scoreService.getScore("./person!historyCourseGrade.html")

//    println(scores)


//
//    val file = File("./person!historyCourseGrade.html")
//
//    //线下的文件
//
//    val doc = Jsoup.parse(file, "UTF-8");
//
//    //用Jsoup以UTF-8解析本地html文件 传入doc中
//
//    val elements = doc.getElementById("semesterGrade").getElementsByTag("tbody")
//
//    val nextElements = elements.select("td")
//    val latterelements = nextElements.select("a")
    //这里保存14项内容
    /*
    以此为例（一行一项 缺省也算）
    2020-2021 春
    U10P53013
    U10P53013.04
    <a href="javascript:void(0)" onclick="showInfo(37992307)" title="查看成绩详情">数据结构实验（双语)</a>
    大类平台课程
    0.5
    93.5


    85
    88

    88
    3.7
     */
//    for (i in 0 until elements.size){
//        val tdList = elements.get(i).select("td")
//        println(tdList.html())
//    }
//
//    var degreeData = ArrayList<DegreeData>()
//
//    if (nextElements.size > 0){
//        for (i in 1 until nextElements.size){
//
//        }
//    }

//    for (i in 1 until  nextElements.size){
//
//    }

    //找到id为semesterGrade的部分并传入elements
//    println(latterelements.html())


    //（测试）打出element测试


}