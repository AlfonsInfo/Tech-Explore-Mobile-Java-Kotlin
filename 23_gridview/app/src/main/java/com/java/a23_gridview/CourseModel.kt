package com.java.a23_gridview

data class CourseModel(val courseName: String,val coursImg : Int) {
    companion object{
        var dataCourse  =  arrayListOf<CourseModel>()
        //define dataCourse
        init{
            dataCourse.add(CourseModel("Course 1", R.drawable.ic_launcher_background))
            dataCourse.add(CourseModel("Course 2", R.drawable.ic_launcher_background))
            dataCourse.add(CourseModel("Course 3", R.drawable.ic_launcher_background))
        }
    }


}