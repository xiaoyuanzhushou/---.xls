package com.example.parse_service

import com.example.activity.R
import com.example.scoredata.DegreeData
import java.io.File
import org.jsoup.Jsoup


object ScoreService {

    fun getScore(content: String): List<DegreeData>{
        val scores = ArrayList<DegreeData>()

        val file = File("person!historyCourseGrade.html")

        val doc = Jsoup.parse(file, "UTF-8")

        val elements = doc.getElementById("semesterGrade").getElementsByTag("tbody")

        val nextElements = elements.select("td")


        if (nextElements.size > 0){
            for (i in 0 until nextElements.size step 14){
                val degreeData = DegreeData()
                degreeData.course = nextElements[3 + i].select("a").text()
                degreeData.final_result = nextElements[12 + i].text()
                degreeData.grade_point = nextElements[13 + i].text()

//                println(degreeData)
                //到这里都还能跑，因为print出来了

                scores.add(degreeData)
                //是这里的问题吗？？
            }
        }

        return scores
    }



}
