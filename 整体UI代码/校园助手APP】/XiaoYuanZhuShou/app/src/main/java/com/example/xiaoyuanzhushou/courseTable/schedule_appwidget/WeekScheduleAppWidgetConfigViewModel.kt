package com.example.xiaoyuanzhushou.courseTable.schedule_appwidget

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.xiaoyuanzhushou.AppDatabase
import com.example.xiaoyuanzhushou.courseTable.message.AppWidgetBean
import com.example.xiaoyuanzhushou.courseTable.message.TableBean
import com.example.xiaoyuanzhushou.courseTable.message.TableSelectBean


class WeekScheduleAppWidgetConfigViewModel(application: Application) : AndroidViewModel(application) {
    private val dataBase = AppDatabase.getDatabase(application)
    private val tableDao = dataBase.tableDao()
    private val widgetDao = dataBase.appWidgetDao()

    suspend fun getDefaultTable(): TableBean {
        return tableDao.getDefaultTable()
    }

    suspend fun getTableById(id: Int): TableBean? {
        return tableDao.getTableById(id)
    }

    suspend fun insertWeekAppWidgetData(appWidget: AppWidgetBean) {
        widgetDao.insertAppWidget(appWidget)
    }

    suspend fun getTableList(): List<TableSelectBean> {
        return tableDao.getTableSelectList()
    }
}