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




















        val exa: String = "学分绩（百分制） 79.025\n"+
                "课程名称 计算机系统基础\t最终成绩 78\t绩点 3\t\n" +
                "课程名称 大学生心理健康教育\t最终成绩 90\t绩点 3.9\t\n" +
                "课程名称 程序设计基础Ⅲ\t最终成绩 85\t绩点 3.7\t\n" +
                "课程名称 计算机系统基础实验\t最终成绩 68\t绩点 2\t\n" +
                "课程名称 足球初级\t最终成绩 92\t绩点 3.9\t\n" +
                "课程名称 中国近现代史纲要\t最终成绩 72\t绩点 2.3\t\n" +
                "课程名称 高等数学（上）\t最终成绩 83\t绩点 3.3\t\n" +
                "课程名称 智能时代的计算机科学\t最终成绩 P\t绩点 \t\n" +
                "课程名称 c线性代数Ⅰ\t最终成绩 90\t绩点 3.9\t\n" +
                "课程名称 军事理论\t最终成绩 75\t绩点 1\t\n" +
                "课程名称 程序设计基础III实验\t最终成绩 81\t绩点 3.3\t\n" +
                "课程名称 大学英语（Ⅱ）\t最终成绩 74\t绩点 2.3\t\n" +
                "课程名称 军事技能训练\t最终成绩 优秀\t绩点 4\t\n" +
                "课程名称 信息技术基础认知与实践\t最终成绩 88\t绩点 3.7\t\n" +
                "课程名称 大学美育\t最终成绩 66\t绩点 1.7\t\n" +
                "课程名称 离散数学\t最终成绩 78\t绩点 3\t\n" +
                "课程名称 思想道德与法治\t最终成绩 84\t绩点 3.3\t\n" +
                "课程名称 大学物理II（上）\t最终成绩 79\t绩点 3\t\n" +
                "课程名称 数据结构（双语)\t最终成绩 83\t绩点 3.3\t\n" +
                "课程名称 篮球初级\t最终成绩 77\t绩点 2.7\t\n" +
                "课程名称 电路基础 III\t最终成绩 73\t绩点 2.3\t\n" +
                "课程名称 电路基础实验\t最终成绩 81\t绩点 3.3\t\n" +
                "课程名称 大学英语核心能力（阅读）\t最终成绩 74\t绩点 2.3\t\n" +
                "课程名称 高等数学（下）\t最终成绩 71\t绩点 2\t\n" +
                "课程名称 大学物理实验I（上）\t最终成绩 77\t绩点 2.7\t\n" +
                "课程名称 数据结构实验（双语)\t最终成绩 88\t绩点 3.7\t\n" +
                "课程名称 大学英语（Ⅲ）\t最终成绩 72\t绩点 2.3\t\n" +
                "课程名称 概率论与数理统计\t最终成绩 87\t绩点 3.7\t\n"


        textView.text = exa
    }
}