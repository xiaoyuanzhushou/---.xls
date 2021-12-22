package com.example.afinal

import java.io.File
import org.jsoup.Jsoup


class ScoreService {

    fun getScore(content: String): List<DegreeData>{
        val scores = ArrayList<DegreeData>()

        val file = File(content)

        val doc = Jsoup.parse(file, "UTF-8")

        val elements = doc.getElementById("semesterGrade").getElementsByTag("tbody")

        val nextElements = elements.select("td")
//        val latterelements = nextElements.select("a")

//        println(latterelements.html())
//        println(nextElements.html())
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

        if (nextElements.size > 0){
            for (i in 0 until nextElements.size){
                val degreeData = DegreeData()
                degreeData.course = nextElements[3 + 14 * i].select("a").text()
                degreeData.final_result = nextElements[12 + 14 * i].text()
                degreeData.grade_point = nextElements[13 + 14 * i].text()

                println(degreeData)
                //到这里都还能跑，因为print出来了

                scores.add(degreeData)
                //是这里的问题吗？？
            }
        }

        return scores
//    for (i in 1 until  nextElements.size){
//
//    }

        //找到id为semesterGrade的部分并传入elements
//        println(latterelements.html())


        //（测试）打出element测试
    }


}
