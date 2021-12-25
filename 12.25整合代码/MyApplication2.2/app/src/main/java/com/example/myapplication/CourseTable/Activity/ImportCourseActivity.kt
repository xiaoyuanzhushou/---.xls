package com.example.myapplication.CourseTable.Activity

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.core.content.res.ResourcesCompat
import com.CourseBaseBean

import com.example.myapplication.CourseTable.Basebean.CourseDetailBean
import com.example.myapplication.CourseTable.CheckCodeErrorException
import com.example.myapplication.CourseTable.NetworkErrorException
import com.example.myapplication.CourseTable.PasswordErrorException
import com.example.myapplication.CourseTable.UserNameErrorException
import com.example.myapplication.R
import com.google.android.material.textfield.TextInputLayout
import kotlinx.android.synthetic.main.activity_import_course.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import org.jsoup.Connection
import org.jsoup.Jsoup
import java.util.*
import java.util.regex.Pattern

class ImportCourseActivity : AppCompatActivity() {

    private var year = ""
    private var term = ""
    private var importId = -1
    private val baseList = arrayListOf<CourseBaseBean>()
    private val detailList = arrayListOf<CourseDetailBean>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_import_course)
        input_code.visibility = View.INVISIBLE
        rl_code.visibility = View.INVISIBLE
        tv_tip.visibility = View.GONE
        initEvent()
    }

    private fun TextInputLayout.showError(str: String, dur: Long = 3000) {
            this@showError.error = str

            this@showError.error = null
    }
    fun initEvent(){
        iv_code.setOnClickListener {
//            refreshCode()
        }

        iv_error.setOnClickListener {
//            refreshCode()
        }
        fab_login.setOnClickListener {
            when {
                et_id.text!!.isEmpty() -> input_id.showError("学号不能为空")
                et_pwd.text!!.isEmpty() -> input_pwd.showError("密码不能为空")

                else ->login()
            }
        }





    }
    fun login(){
        var exception: Exception? = null
        var result = 0
        Toast.makeText(this, "年份为学年的起始年，学期[秋、春、夏]分别对应[1、2、3]\n例如[2019-2020春] 选择[2019 2]", Toast.LENGTH_LONG).show()
        pb_loading.visibility = View.INVISIBLE
        fab_login.isExpanded = true
        val year = Calendar.getInstance().get(Calendar.YEAR)
        val list = mutableListOf<String>()
        for (index in year - 7..year) {
            list.add(index.toString())
        }
        cardC2Dialog(list, true)


    }

    private fun refreshCode() {

            et_code.setText("")
            progress_bar.visibility = View.VISIBLE
            iv_code.visibility = View.INVISIBLE
            iv_error.visibility = View.INVISIBLE
            try {
//                val bitmap = viewModel.sudaXK?.getCheckCode()
                progress_bar.visibility = View.GONE
                iv_code.visibility = View.VISIBLE
                iv_error.visibility = View.INVISIBLE
//
            } catch (e: Exception) {
                progress_bar.visibility = View.GONE
                iv_code.visibility = View.INVISIBLE
                iv_error.visibility = View.VISIBLE
                Toast.makeText(this, "请检查是否连接校园网", Toast.LENGTH_LONG).show()
            }

    }

     fun getNWPUSchedule() {

            try {
                if (term.isEmpty()) {
                    term = "1"
                }
                var result:Int=0
                val thread:Thread= Thread(Runnable { try{
                    result =loginNWPU(et_id.text.toString(), et_pwd.text.toString(), year, term)
                    showSuccess(result)
                }catch (e: Exception) {
                    fab_login.isExpanded = false
                    when (e) {
                        is UserNameErrorException -> {
                            et_id.requestFocus()
                            input_id.showError(e.message ?: "", 5000)
                            refreshCode()
                        }
                        is PasswordErrorException -> {
                            et_pwd.requestFocus()
                            input_pwd.showError(e.message ?: "", 5000)
                            refreshCode()
                        }
                        is CheckCodeErrorException -> {
                            input_code.showError(e.message ?: "", 5000)
                            refreshCode()
                        }
                        else -> Toast.makeText(this, e.message
                            ?: "再试一次看看哦", Toast.LENGTH_LONG).show()
                    }
                }

                })
                Thread.sleep(3000L)

            } catch (e: Exception) {
                fab_login.isExpanded = false
                when (e) {
                    is UserNameErrorException -> {
                        et_id.requestFocus()
                        input_id.showError(e.message ?: "", 5000)
                        refreshCode()
                    }
                    is PasswordErrorException -> {
                        et_pwd.requestFocus()
                        input_pwd.showError(e.message ?: "", 5000)
                        refreshCode()
                    }
                    is CheckCodeErrorException -> {
                        input_code.showError(e.message ?: "", 5000)
                        refreshCode()
                    }
                    else -> Toast.makeText(this, e.message
                        ?: "再试一次看看哦", Toast.LENGTH_LONG).show()
                }
            }

    }
    fun loginNWPU(id: String, pwd: String, semestersYear: String, semestersTerm: String): Int {
        //如果你对代码有疑惑，请参考 luu.moe/102
        baseList.clear()
        detailList.clear()

        var semestersId = ""//请求中的 id 值，必填
        val headers: Map<String, String>? = mapOf("Host" to "us.nwpu.edu.cn", "User-Agent" to "Mozilla/5.0 (X11; Linux x86_64; rv:72.0) Gecko/20100101 Firefox/72.0")
        val cookies: Map<String, String>?
        val ids: String//ids 值，必填
        var response: String

        cookies = Jsoup.connect("http://us.nwpu.edu.cn/eams/login.action").headers(headers)//第一步获取cookies
                .timeout(5000).method(Connection.Method.GET).execute().cookies()


        response = Jsoup.connect("http://us.nwpu.edu.cn/eams/login.action").headers(headers).cookies(cookies)//第二步骤模拟登录
                .data("username", id).data("password", pwd).data("encodedPassword", "").data("session_locale", "zh_CN")
                .timeout(5000).method(Connection.Method.POST).execute().body()

        if (response.contains("欢迎使用西北工业大学教务系统。")) {
            //ok
        } else if (response.contains("密码错误")) {
            throw PasswordErrorException("密码错误哦")
        } else if (response.contains("账户不存在")) {
            throw UserNameErrorException("登录失败，账户不存在。")
        } else if (response.contains("验证码不正确")) {
            throw NetworkErrorException("登录失败，失败尝试过多，请尝试更换网络环境。")
        }

        response = Jsoup.connect("http://us.nwpu.edu.cn/eams/courseTableForStd.action").headers(headers).cookies(cookies)//然后获取ids
                .timeout(5000).method(Connection.Method.GET).execute().body()


        if (!response.contains("addInput(form,\"ids\",")) {
            throw NetworkErrorException("ids 获取失败，请尝试更换网络环境。")
        }
        ids = Regex("form,\"ids\",\"\\d+?(?=\")").find(response)!!.value.replace("form,\"ids\",\"", "")


        response = Jsoup.connect("http://us.nwpu.edu.cn/eams/dataQuery.action").headers(headers).cookies(cookies)//然后获取学年学期id
                .data("tagId", "semesterBar15920393881Semester").data("dataType", "semesterCalendar").data("empty", "true")
                .timeout(5000).method(Connection.Method.POST).execute().body()



        val semestersName = "秋春夏"
        var foundResults: Sequence<MatchResult>
        foundResults = Regex("(?<=id:)\\d+(?=,)").findAll(response)
        for (findText in foundResults) {
            semestersId = findText.value
            if (response.contains(regex = Regex(pattern =
                "$semestersId,schoolYear:\"$semestersYear-\\d+\",name:\""
                        + semestersName[semestersTerm.toInt() - 1].toString() + "\""))) {
                break
            } else {
                semestersId = "NOT_MATCH"
            }
        }
        if (semestersId == "NOT_MATCH") {
            throw Exception("加载课表统览数据失败，未在 dataQuery.action 中查询到 $semestersYear $semestersTerm 所对应的 id。")
        }

        var lteacher = ""//以下为"last"的意思
        var lclass = ""
        var lroom = ""
        var l01week = ""
        val lstartendweek: MutableList<Int> = mutableListOf()//一先一后分别为开始和结束

        var tstartweek: Int = -1
        var ttday: Int = -1
        var ttstartNode: Int = -1
        var ttstep = 0
        var firstornot = true
        var skipornot = false//当activity中有 -1 值的时候，可能说明这个课情况特殊（比如说是停课状态），就直接skip

        response = Jsoup.connect("http://us.nwpu.edu.cn/eams/courseTableForStd!courseTable.action").headers(headers).cookies(cookies)
                .data("ignoreHead", "1").data("setting.kind", "std").data("startWeek", "1").data("project.id", "1")
                .data("semester.id", semestersId).data("ids", ids)
                .timeout(5000).method(Connection.Method.POST).execute().body()

        if (!response.contains("var activity=null;")) {
            throw Exception("加载课表具体数据失败，未在响应中查询到识别语句。")
        }
        var res: String = Regex(pattern = "var activity=null;[\\w\\W]*(?=table0.marshalTable)").find(response)!!.value
        res = Regex(pattern = "\\n\\s*").replace(res, "\n")
        foundResults = Regex("^.+?;\$", RegexOption.MULTILINE).findAll(res)
        lstartendweek.clear()
        for (findText in foundResults) {
            val text = findText.value
            if (text.startsWith("var") or text.startsWith("table0")) {
                continue
            } else if (text.startsWith("activity")) {

                if (lstartendweek.isNotEmpty()) {//先添加“上”课
                    for (index in 1..lstartendweek.count() step 2) {
                        var perfectlroom = Regex(pattern = "\\[教学[东西]楼[A-Za-z]座\\]").replace(lroom, "")
                        perfectlroom = Regex(pattern = "\\[体育场地\\][A-Za-z]\\d+?").replace(perfectlroom, "")
                        perfectlroom = perfectlroom.replace("[实验大楼]", "")
                        detailList.add(CourseDetailBean(
                            id = baseList.size - 1, day = ttday, room = perfectlroom, teacher = lteacher,
                            startWeek = lstartendweek[index - 1], endWeek = lstartendweek[index], startNode = ttstartNode,
                            step = ttstep, type = 0, tableId = importId
                        ))
                    }
                }

                if (text.contains(",\"-1\",")) {//状态可能有问题
                    skipornot = true
                    continue
                } else {
                    skipornot = false
                }

                firstornot = true//确保下一行的index是本activity的first
                val matcher = Pattern.compile("TaskActivity\\(.+?,\"(.*?)\",.+?,\"(.+?)\",.+?,\"(.+?)\",\"(.+)\"").matcher(text)
                matcher.find()
                val matchRs = matcher.toMatchResult()
                if (lclass != matchRs.group(2)) {//课程不同
                    lstartendweek.clear()
                    lteacher = matchRs.group(1)
                    lclass = matchRs.group(2)
                    lroom = matchRs.group(3)
                    l01week = matchRs.group(4)

                    for (i in l01week.indices) {//从01状态码转为连续week情景（一前一后为start、endweek）
                        if (l01week[i] == '0' && tstartweek == -1) {
                            continue
                        } else if (l01week[i] == '1' && tstartweek == -1) {
                            tstartweek = i
                            lstartendweek.add(i)
                        } else if (l01week[i] == '1' && tstartweek != -1) {
                            continue
                        } else if (l01week[i] == '0' && tstartweek != -1) {
                            tstartweek = -1
                            lstartendweek.add(i - 1)
                        }
                    }

                    baseList.add(CourseBaseBean(
                        id = baseList.size, courseName = lclass.replace(Regex("\\([a-zA-Z0-9.]+\\).*").find(lclass)!!.value, ""),
                        color = "##FF4081",
                        tableId = importId
                    ))
                } else {//课程同，但其他的出现了不同，就要写detail
                    lstartendweek.clear()
                    lteacher = matchRs.group(1)
                    lclass = matchRs.group(2)
                    lroom = matchRs.group(3)
                    l01week = matchRs.group(4)
                    for (i in l01week.indices) {
                        if (l01week[i] == '0' && tstartweek == -1) {
                            continue
                        } else if (l01week[i] == '1' && tstartweek == -1) {
                            tstartweek = i
                            lstartendweek.add(i)
                        } else if (l01week[i] == '1' && tstartweek != -1) {
                            continue
                        } else if (l01week[i] == '0' && tstartweek != -1) {
                            tstartweek = -1
                            lstartendweek.add(i - 1)
                        }
                    }
                }
            } else if (text.startsWith("index")) {
                if (skipornot) {
                    continue
                }
                if (firstornot) {//第一次遇到index
                    val matcher = Pattern.compile("=(\\d+)\\*unitCount\\+(\\d+);").matcher(text)
                    matcher.find()
                    val matchRs = matcher.toMatchResult()
                    ttday = matchRs.group(1).toInt() + 1
                    ttstartNode = matchRs.group(2).toInt() + 1
                    ttstep = 1
                    firstornot = false
                } else {
                    ttstep++
                }
            }
        }
        if (lstartendweek.isNotEmpty()) {
            for (index in 1..lstartendweek.count() step 2) {
                var perfectlroom = Regex(pattern = "\\[教学[东西]楼[A-Za-z]座\\]").replace(lroom, "")
                perfectlroom = Regex(pattern = "\\[体育场地\\][A-Za-z]\\d+?").replace(perfectlroom, "")
                perfectlroom = perfectlroom.replace("[实验大楼]", "")
                detailList.add(CourseDetailBean(
                    id = baseList.size - 1, day = ttday, room = perfectlroom, teacher = lteacher,
                    startWeek = lstartendweek[index - 1], endWeek = lstartendweek[index], startNode = ttstartNode,
                    step = ttstep, type = 0, tableId = importId
                ))
            }
            lstartendweek.clear()
        }
        return write2DB()
    }


    fun write2DB(): Int {
//            if (baseList.isEmpty()) {
//                throw Exception("解析错误>_<请确保选择了正确的教务类型，并在显示了课程的页面")
//            }
//            if (!newFlag) {
//                courseDao.coverImport(baseList, detailList)
//            } else {
//                tableDao.insertTable(TableBean(id = importId, ta
//                bleName = "未命名"))
//                courseDao.insertCourses(baseList, detailList)
//            }
            return baseList.size
        }

    private fun showSuccess(result: Int) {
        Toast.makeText(this,
            "成功导入 $result 门课程(ﾟ▽ﾟ)/\n请在右侧栏切换后查看", Toast.LENGTH_LONG).show()
        this.finish()
//        activity!!.setResult(RESULT_OK)
//        activity!!.finish()
    }


//

    fun cardC2Dialog(years: List<String>, selectLastYear: Boolean = false) {
        ll_dialog.visibility = View.VISIBLE
        val terms = arrayOf("1", "2", "3")
        wp_term.displayedValues = terms
        wp_term.value = 0
        wp_term.minValue = 0
        wp_term.maxValue = terms.size - 1

        wp_years.displayedValues = years.toTypedArray()
        wp_years.minValue = 0
        wp_years.maxValue = years.size - 1
        if (!selectLastYear) {
            wp_years.value = 0
        } else {
            wp_years.value = wp_years.maxValue
        }

        wp_years.setOnValueChangedListener { _, _, newVal ->
            year = years[newVal]
            Log.d("选中", "选中学年$year")
        }
        wp_term.setOnValueChangedListener { _, _, newVal ->
            term = terms[newVal]
            Log.d("选中", "选中学期$term")
        }
        btn_cancel.setOnClickListener{
            ll_dialog.visibility=View.GONE
        }
        btn_to_schedule.setOnClickListener{

            getNWPUSchedule()
            ll_dialog.visibility=View.GONE





        }

    }




}