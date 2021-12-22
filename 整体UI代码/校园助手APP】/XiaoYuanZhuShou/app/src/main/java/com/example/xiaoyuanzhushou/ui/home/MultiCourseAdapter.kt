package com.example.xiaoyuanzhushou.ui.home;



//
//import androidx.fragment.app.Fragment
//import androidx.fragment.app.FragmentManager
//import androidx.fragment.app.FragmentStatePagerAdapter
//import androidx.viewpager.widget.PagerAdapter
//
//import com.example.xiaoyuanzhushou.courseTable.message.CourseBean;

import androidx.fragment.app.FragmentManager

import androidx.fragment.app.Fragment

import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.PagerAdapter

import com.example.xiaoyuanzhushou.courseTable.message.CourseBean;


class MultiCourseAdapter(manager: FragmentManager, val data: kotlin.collections.List<CourseBean>) : FragmentStatePagerAdapter(manager) {

        override fun getItem(position: Int): Fragment {
        return CourseDetailFragment.newInstance(data[position], true)
        }

        override fun getCount(): Int {
        return data.size
        }

        override fun getItemPosition(`object`: Any): Int {
        return PagerAdapter.POSITION_NONE
        }
        }