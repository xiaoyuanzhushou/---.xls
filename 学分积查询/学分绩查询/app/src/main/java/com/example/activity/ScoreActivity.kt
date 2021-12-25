package com.example.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.widget.TextView
import com.example.parse_service.ScoreService
import com.example.parse_service.ScoreService.getScore
import org.w3c.dom.Text
import javax.crypto.SecretKey

class ScoreActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_score)

        val textView: TextView = findViewById(R.id.textView)

        val bundle = intent.extras

        val string = bundle?.getString("String")

//        val scores = getScore(string.toString())



        //作为示范
        //测试用例




















        val exa: String = "        DegreeData(course=计算机系统基础, final_result=78, grade_point=3),\n" +
                "        DegreeData(course=大学生心理健康教育, final_result=90, grade_point=3.9),\n" +
                "        DegreeData(course=程序设计基础Ⅲ, final_result=85, grade_point=3.7),\n" +
                "        DegreeData(course=计算机系统基础实验, final_result=68, grade_point=2),\n" +
                "        DegreeData(course=足球初级, final_result=92, grade_point=3.9),\n" +
                "        DegreeData(course=中国近现代史纲要, final_result=72, grade_point=2.3),\n" +
                "        DegreeData(course=高等数学（上）, final_result=83, grade_point=3.3),\n" +
                "        DegreeData(course=智能时代的计算机科学, final_result=P, grade_point=),\n" +
                "        DegreeData(course=线性代数Ⅰ, final_result=90, grade_point=3.9),\n" +
                "        DegreeData(course=军事理论, final_result=75, grade_point=1),\n" +
                "        DegreeData(course=程序设计基础III实验, final_result=81, grade_point=3.3),\n" +
                "        DegreeData(course=大学英语（Ⅱ）, final_result=74, grade_point=2.3),\n" +
                "        DegreeData(course=军事技能训练, final_result=优秀, grade_point=4),\n" +
                "        DegreeData(course=信息技术基础认知与实践, final_result=88, grade_point=3.7),\n" +
                "        DegreeData(course=大学美育, final_result=66, grade_point=1.7),\n" +
                "        DegreeData(course=离散数学, final_result=78, grade_point=3),\n" +
                "        DegreeData(course=思想道德与法治, final_result=84, grade_point=3.3),\n" +
                "        egreeData(course=大学物理II（上）, final_result=79, grade_point=3),\n" +
                "        DegreeData(course=数据结构（双语), final_result=83, grade_point=3.3),\n" +
                "        DegreeData(course=篮球初级, final_result=77, grade_point=2.7),\n" +
                "        DegreeData(course=电路基础 III, final_result=73, grade_point=2.3),\n" +
                "        DegreeData(course=电路基础实验, final_result=81, grade_point=3.3),\n" +
                "        DegreeData(course=大学英语核心能力（阅读）, final_result=74, grade_point=2.3),\n" +
                "        DegreeData(course=高等数学（下）, final_result=71, grade_point=2),\n" +
                "        DegreeData(course=大学物理实验I（上）, final_result=77, grade_point=2.7),\n" +
                "        DegreeData(course=数据结构实验（双语), final_result=88, grade_point=3.7),\n" +
                "        DegreeData(course=大学英语（Ⅲ）, final_result=72, grade_point=2.3),\n" +
                "        DegreeData(course=概率论与数理统计, final_result=87, grade_point=3.7)\n"

        textView.text = exa
    }
}