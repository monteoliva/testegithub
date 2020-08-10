package br.com.monteoliva.testegithub.presenter

import android.content.Context
import br.com.monteoliva.testegithub.model.gson.Item

class MVP {

    interface Model {
        fun loadRepos()
        fun loadUpdate()
    }

    interface Presenter {
        val context: Context
        fun setView(view: View)
        fun showProgressBar(status: Boolean)
        fun loadRepos()
        fun loadUpdate()
        fun updateListRecycler(list: MutableList<Item>?)
        fun updateList(list: MutableList<Item>?)
    }

    interface View {
        fun showProgressBar(visible: Int)
        fun updateListRecycler(list: MutableList<Item>?)
        fun updateList(list: MutableList<Item>?)
    }
}