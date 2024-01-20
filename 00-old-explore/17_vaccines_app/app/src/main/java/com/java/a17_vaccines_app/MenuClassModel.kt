package com.java.a17_vaccines_app

data class MenuClassModel(var title : String,  var imgFlag : Int){
    companion object{
        var menuModel =  arrayListOf<MenuClassModel>()
        //setiap item[index] didefinisikan langsung?
        init{
            menuModel.add(MenuClassModel("Item 1",R.drawable.ic_launcher_background))
            menuModel.add(MenuClassModel("Item 2",R.drawable.ic_launcher_background))
        }
    }

}
