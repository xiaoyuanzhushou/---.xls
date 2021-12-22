package com.example.xiaoyuanzhushou.courseTable.course_add

import android.text.Editable
import androidx.recyclerview.widget.RecyclerView
import com.chad.library.adapter.base.BaseQuickAdapter

import com.chad.library.adapter.base.viewholder.BaseViewHolder


import com.example.xiaoyuanzhushou.R
import com.example.xiaoyuanzhushou.courseTable.message.CourseEditBean
import com.example.xiaoyuanzhushou.courseTable.tools.Common
import com.example.xiaoyuanzhushou.courseTable.tools.CourseUtils




class AddCourseAdapter(layoutResId: Int, data: MutableList<CourseEditBean>) :
        BaseQuickAdapter<CourseEditBean, BaseViewHolder>(layoutResId, data) {

    private var mListener: OnItemEditTextChangedListener? = null

    fun setListener(listener: OnItemEditTextChangedListener) {
        mListener = listener
    }

    override fun convert(helper: BaseViewHolder, item: CourseEditBean?) {
        if (item == null) return
        //helper.setText(R.id.tv_item, "${helper.layoutPosition}")
        helper.setText(R.id.et_room, item.room)
        helper.setText(R.id.et_teacher, item.teacher)

        val week = Common.weekIntList2WeekBeanList(item.weekList.value!!).toString()
        helper.setText(R.id.et_weeks, week.substring(1, week.length - 1))

        helper.setText(R.id.et_time, "${CourseUtils.getDayStr(item.time.value!!.day)}    第${item.time.value!!.startNode} - ${item.time.value!!.endNode}节")
    }

    interface OnItemEditTextChangedListener {
        fun onEditTextAfterTextChanged(editable: Editable, position: Int, what: String)
    }

    override fun onDetachedFromRecyclerView(recyclerView: RecyclerView) {
        super.onDetachedFromRecyclerView(recyclerView)
        mListener = null
    }

}