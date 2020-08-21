package br.com.monteoliva.testegithub.view.main

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager

import kotlinx.android.synthetic.main.activity_main.*

import org.koin.android.viewmodel.ext.android.viewModel

import br.com.monteoliva.testegithub.R
import br.com.monteoliva.testegithub.model.gson.Item
import br.com.monteoliva.testegithub.presenter.MVP
import br.com.monteoliva.testegithub.presenter.Presenter
import br.com.monteoliva.testegithub.view.BaseActivity
import br.com.monteoliva.testegithub.view.main.adapter.ItemAdapter

class MainActivity : BaseActivity(R.layout.activity_main), MVP.View {
    private lateinit var presenter: MVP.Presenter

    private val viewModel: MainViewModel by viewModel()

    override fun initViews(bundle: Bundle?) {
        setupToolBar(R.id.toolbar)
        setActionBarTitle("")
        toolbarTitle(getString(R.string.title))

        presenter = Presenter()
        presenter.setView(this)

        swipeRefresh.setOnRefreshListener {
            presenter.loadUpdate()
        }
    }

    override fun initViewModel() {
        presenter.loadRepos()
        viewModel.itensLiveData.observe(this, Observer { load(it) })
    }

    override fun back(resultCode: Int) { finish() }
    override fun showProgressBar(visible: Int) {
        when(visible) {
            View.VISIBLE -> mainProgress.show()
            View.GONE    -> mainProgress.hide()
        }
    }

    override fun updateListRecycler(list: MutableList<Item>?) {
        viewModel.setList(list!!)
    }

    override fun updateList(list: MutableList<Item>?) {
        viewModel.updateList(list!!)
        swipeRefresh.isRefreshing = false
    }

    private fun load(list: MutableList<Item>?) {
        Log.d("LOAD","Update Load")
        val lm = LinearLayoutManager(this)
        val itemAdapter: ItemAdapter = ItemAdapter(list!!)

        rv.apply {
            setHasFixedSize(true)
            layoutManager = lm
            adapter = itemAdapter
        }

        presenter.showProgressBar(false)
    }
}