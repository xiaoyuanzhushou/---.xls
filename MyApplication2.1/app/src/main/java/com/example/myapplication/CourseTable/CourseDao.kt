package com.example.myapplication.CourseTable

object CourseDao {
    fun getCourseData(): Array<ArrayList<CourseModel>?> {
        var courseModels= arrayOfNulls<ArrayList<CourseModel>>(7)
        for(i in 0..courseModels.size-1){
            courseModels[i]= ArrayList<CourseModel>()
        }

        var models_1:ArrayList<CourseModel> = ArrayList<CourseModel>()
        models_1.add(CourseModel(0, "软件开发基础能力训练", 2, 3, 1, "启翔楼264", (Math.random() * 10).toInt()))
        models_1.add(CourseModel(1, "软件开发基础能力训练", 7, 3, 1, "启翔楼264", (Math.random() * 10).toInt()))
//        models_1.add(CourseModel(1, "PHP", 6, 3, 1, "A483", (Math.random() * 10).toInt()))
        courseModels[0]=models_1
        var models_2:ArrayList<CourseModel> = ArrayList<CourseModel>()
//        models_1.add(CourseModel(0, "软件开发基础能力训练", 2, 3, 1, "启翔楼264", (Math.random() * 10).toInt()))
        models_2.add(CourseModel(1, "软件开发基础能力训练", 11, 3, 1, "启翔楼264", (Math.random() * 10).toInt()))
//        models_1.add(CourseModel(1, "PHP", 6, 3, 1, "A483", (Math.random() * 10).toInt()))
        courseModels[1]=models_2
        var models_3:ArrayList<CourseModel> = ArrayList<CourseModel>()
        models_3.add(CourseModel(0, "软件开发基础能力训练", 2, 3, 1, "启翔楼264", (Math.random() * 10).toInt()))
        models_3.add(CourseModel(1, "软件开发基础能力训练", 7, 3, 1, "启翔楼264", (Math.random() * 10).toInt()))
//        models_1.add(CourseModel(1, "PHP", 6, 3, 1, "A483", (Math.random() * 10).toInt()))
        courseModels[2]=models_3


        var models_4:ArrayList<CourseModel> = ArrayList<CourseModel>()
//        models_1.add(CourseModel(0, "软件开发基础能力训练", 2, 3, 1, "启翔楼264", (Math.random() * 10).toInt()))
        models_4.add(CourseModel(1, "软件开发基础能力训练", 11, 3, 1, "启翔楼264", (Math.random() * 10).toInt()))
//        models_1.add(CourseModel(1, "PHP", 6, 3, 1, "A483", (Math.random() * 10).toInt()))
        courseModels[3]=models_4

        var models_5:ArrayList<CourseModel> = ArrayList<CourseModel>()
        models_5.add(CourseModel(0, "软件开发基础能力训练", 2, 3, 1, "启翔楼264", (Math.random() * 10).toInt()))
//        models_1.add(CourseModel(1, "软件开发基础能力训练", 7, 3, 1, "启翔楼264", (Math.random() * 10).toInt()))
//        models_1.add(CourseModel(1, "PHP", 6, 3, 1, "A483", (Math.random() * 10).toInt()))
        courseModels[4]=models_5

        var models_6:ArrayList<CourseModel> = ArrayList<CourseModel>()
//        models_1.add(CourseModel(0, "软件开发基础能力训练", 2, 3, 1, "启翔楼264", (Math.random() * 10).toInt()))
        models_6.add(CourseModel(1, "软件开发基础能力训练", 7, 3, 1, "启翔楼264", (Math.random() * 10).toInt()))
//        models_1.add(CourseModel(1, "PHP", 6, 3, 1, "A483", (Math.random() * 10).toInt()))
        courseModels[5]=models_6

        var models_7:ArrayList<CourseModel> = ArrayList<CourseModel>()
        models_7.add(CourseModel(0, "软件开发基础能力训练", 2, 3, 1, "启翔楼264", (Math.random() * 10).toInt()))
        models_7.add(CourseModel(1, "软件开发基础能力训练", 7, 3, 1, "启翔楼264", (Math.random() * 10).toInt()))
//        models_1.add(CourseModel(1, "PHP", 6, 3, 1, "A483", (Math.random() * 10).toInt()))
        courseModels[6]=models_7






        return courseModels







    }
}