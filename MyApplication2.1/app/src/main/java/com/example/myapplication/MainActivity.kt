package com.example.myapplication

import android.content.Context
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.*
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import butterknife.BindView
import butterknife.BindViews
import butterknife.ButterKnife
import com.cjj.MaterialRefreshLayout
import com.cjj.MaterialRefreshListener
import com.example.myapplication.CourseTable.Activity.ImportCourseActivity
import com.example.myapplication.CourseTable.ColorUtils
import com.example.myapplication.CourseTable.CornerTextView
import com.example.myapplication.CourseTable.CourseDao
import com.example.myapplication.CourseTable.CourseModel
import com.example.myapplication.R.*
import com.example.myapplication.assistant.AssistantMainActivity
import com.example.myapplication.todolist.TodoList
import com.example.myapplication.todolist.TomatoActivity
import com.example.myapplication.xuefenji.MainActivityXuefenji
import kotlinx.android.synthetic.main.activity_main.*

import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

//    @BindView(id.weekNames)
//    var weekNames: LinearLayout? = null
//
//    @BindView(id.sections)
//    var sections: LinearLayout? = null
//
//    @BindView(id.mFreshLayout)
//    var mFreshLayout: MaterialRefreshLayout? = null

    @BindViews(
        *[id.weekPanel_1, id.weekPanel_2,
            id.weekPanel_3, id.weekPanel_4, id.weekPanel_5,
            id.weekPanel_6, id.weekPanel_7])
    var mWeekViews:ArrayList<LinearLayout>? = null

    private var itemHeight = 0
    private val maxSection = 13


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_main)
        setSupportActionBar(toolbar)

        supportActionBar?.let {
            it.setDisplayHomeAsUpEnabled(true)
            it.setHomeAsUpIndicator(R.mipmap.menu2_ic)
        }


        navView.setCheckedItem(R.id.navCourse)
        //用来跳转界面
        navView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.navTomato->{
                    var  intent=Intent(this,TomatoActivity::class.java)
                    startActivity(intent)
                    drawerlayout_main.closeDrawers()

                }
                R.id.navTodolist->{
                    var  intent=Intent(this,TodoList::class.java)
                    startActivity(intent)
                    drawerlayout_main.closeDrawers()

                }
                R.id.navAssistant->{
                    var  intent=Intent(this,AssistantMainActivity::class.java)
                    startActivity(intent)
                    drawerlayout_main.closeDrawers()
                }
                R.id.navScore->{
                    var  intent=Intent(this,MainActivityXuefenji::class.java)
                    startActivity(intent)
                    drawerlayout_main.closeDrawers()

                }
            }
//            drawerlayout_main.closeDrawers()
            true
        }


        itemHeight = getResources().getDimensionPixelSize(dimen.sectionHeight)
        mWeekViews=ArrayList<LinearLayout>()
        mWeekViews!!.add(weekPanel_1)
        mWeekViews!!.add(weekPanel_2)
        mWeekViews!!.add(weekPanel_3)
        mWeekViews!!.add(weekPanel_4)
        mWeekViews!!.add(weekPanel_5)
        mWeekViews!!.add(weekPanel_6)
        mWeekViews!!.add(weekPanel_7)

        initWeekNameView()

        initSectionView()


        initWeekCourseView()
        setRefreshListener()

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            android.R.id.home->drawerlayout_main.openDrawer(GravityCompat.START)
            R.id.import_courses1->{
                var  intent=Intent(this,ImportCourseActivity::class.java)
                startActivity(intent)
            }

        }
        return true
    }



    /**
     * 初始化课程表
     */
    private fun initWeekCourseView() {
        for (i in mWeekViews!!.indices) {
            initWeekPanel(mWeekViews!![i], CourseDao.getCourseData()[i]!!)
        }
    }

    /**
     * 下拉刷新
     */
    private fun setRefreshListener() {
        mFreshLayout!!.setLoadMore(false)
        mFreshLayout!!.setMaterialRefreshListener(object : MaterialRefreshListener() {
            override fun onRefresh(materialRefreshLayout: MaterialRefreshLayout) {
                clearChildView()
                initWeekCourseView()
                mFreshLayout!!.postDelayed({ mFreshLayout!!.finishRefreshing() }, 500)
            }
        })
    }



    /**
     * 顶部布局
     */
    fun initWeekNameView(){
        for(i in 0..mWeekViews!!.size){
            var tvWeekName = TextView(this)
            var lp = LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
            lp.gravity = Gravity.CENTER or Gravity.CENTER_HORIZONTAL
            if (i != 0) {
                lp.weight = 1F;
                tvWeekName.setText("周" + intToZH(i));
                if (i == getWeekDay()) {
                    tvWeekName.setTextColor(Color.parseColor("#FF0000"));
                } else {
                    tvWeekName.setTextColor(Color.parseColor("#4A4A4A"));
                }
            } else {
                lp.weight = 0.8f;
                tvWeekName.setText(getMonth().toString() + "月");
            }
            tvWeekName.setGravity(Gravity.CENTER_HORIZONTAL);
            tvWeekName.setLayoutParams(lp);
            weekNames!!.addView(tvWeekName);

        }
    }




    /**
     * 左边节次布局
     */
    fun initSectionView(){
        for(i in 1..maxSection){
            var tvSection = TextView(this)
            var lp =LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, getResources().getDimensionPixelSize(
                dimen.sectionHeight))
            lp.gravity= Gravity.CENTER
            tvSection.gravity= Gravity.CENTER
            tvSection.setText(i.toString())
            tvSection.layoutParams=lp
            sections!!.addView(tvSection)
        }
    }







    fun getWeekDay():Int{
        var day= Calendar.getInstance().get(Calendar.DAY_OF_MONTH)-1
        if(day<=0){
            day=7
        }

        return day
    }


    fun getMonth():Int{
        val month = Calendar.getInstance().get(Calendar.MONTH)+1
        return month
    }
    /**
     * 每次刷新前清除每个LinearLayout上的课程view
     */
    fun clearChildView(){
        if(mWeekViews!=null&&mWeekViews!!.size!=null){
            for(i in 0..mWeekViews!!.size){
                if (mWeekViews!!.get(i) != null)
                    if (mWeekViews!!.get(i).getChildCount() > 0)
                        mWeekViews!!.get(i).removeAllViews();
            }
        }

    }


    fun initWeekPanel(ll:LinearLayout,data:List<CourseModel>){
        if (ll == null || data == null || data.size < 1)
            return;
        var firstCourse=data.get(0)
        for(i in 0..data.size-1){
            val courseModel: CourseModel =data.get(i)
            if(courseModel.section==0||courseModel.sectionSpan==0){
                return
            }
            var frameLayout= FrameLayout(this)

            var tv = CornerTextView(this,
                ColorUtils.getCourseBgColor(courseModel.courseFlag),dip2px(this,3F))

            var frameLp=LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                itemHeight * courseModel.sectionSpan)
            var  tvLp =  LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT)
            if (i == 0) {
                frameLp.setMargins(0, (courseModel.section- 1) * itemHeight, 0, 0)
            } else {
                frameLp.setMargins(0, (courseModel.section - (firstCourse.section + firstCourse.sectionSpan)) * itemHeight, 0, 0)
            }
            tv.setLayoutParams(tvLp)
            tv.setGravity(Gravity.CENTER)
            tv.textSize= 12F
            tv.setTextColor(Color.parseColor("#FFFFFF"));
            tv.setText(courseModel.courseName + "\n @" + courseModel.classRoom);

            frameLayout.setLayoutParams(frameLp)
            frameLayout.addView(tv)
            frameLayout.setPadding(2, 2, 2, 2)
            ll.addView(frameLayout)
            firstCourse = courseModel
            tv.setOnClickListener(View.OnClickListener() {
                @Override
                fun onClick(view: View) {
                    showToast(courseModel.courseName);
                }
            })



        }






    }







    fun showToast(mes:String){

        if(TextUtils.isEmpty(mes))
            return
        Toast.makeText(this,mes, Toast.LENGTH_SHORT).show()
    }

    fun dip2px(contrext: Context, dpvalue:Float):Int {
        val scale:Float= contrext.resources.displayMetrics.density;
        return (dpvalue*scale+0.5F).toInt()
    }


    fun  intToZH( i :Int):String{
        val zh = arrayOf("零", "一", "二", "三", "四", "五", "六", "七", "八", "九")
        val unit = arrayOf("", "十", "百", "千", "万", "十", "百", "千", "亿", "十")

        var str = ""

        var sb =StringBuffer(i.toString())

        sb=sb.reverse()

        var r=0
        var l=0

        for(j in 0..sb.length-1){
            r=sb.substring(j,j+1).toInt()
            if(j!=0){
                l=sb.substring(j-1,j).toInt()
            }
            if(j==0){
                if(r!=0||sb.length==1)
                    str =zh[r]
                continue
            }
            if (j == 1 || j == 2 || j == 3 || j == 5 || j == 6 || j == 7 || j == 9) {
                if (r != 0)
                    str = zh[r] + unit[j] + str
                else if (l != 0)
                    str = zh[r] + str
                continue
            }
            if (j == 4 || j == 8) {
                str = unit[j] + str
                if ((l != 0 && r == 0) || r != 0)
                    str = zh[r] + str
                continue
            }
        }
        if (str.equals("七"))
            str = "日"


        return str
    }



















}