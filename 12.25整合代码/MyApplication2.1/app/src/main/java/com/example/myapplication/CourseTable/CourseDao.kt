package com.example.myapplication.CourseTable

object CourseDao {
    fun getCourseData(): Array<ArrayList<CourseModel>?> {
        var courseModels= arrayOfNulls<ArrayList<CourseModel>>(7)
        for(i in 0..courseModels.size-1){
            courseModels[i]= ArrayList<CourseModel>()
        }

        var models_1:ArrayList<CourseModel> = ArrayList<CourseModel>()
        models_1.add(CourseModel(0, "C语言", 1, 2, 1, "A401", (Math.random() * 10).toInt()))
        models_1.add(CourseModel(1, "Ruby", 3, 3, 1, "A453", (Math.random() * 10).toInt()))
        models_1.add(CourseModel(1, "PHP", 6, 3, 1, "A483", (Math.random() * 10).toInt()))
        courseModels[0]=models_1



        return courseModels







    }
}