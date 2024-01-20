package com.java.a18_implements_card_view

data class GameModel(var gameName : String, var gameImg : Int) {
    companion object{
        var listGame = arrayListOf<GameModel>(
            GameModel("PUBG", R.drawable.ic_launcher_background),
            GameModel("Lost Saga", R.drawable.ic_launcher_background)
        )
    }

}