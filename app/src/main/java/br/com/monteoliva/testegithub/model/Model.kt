package br.com.monteoliva.testegithub.model

import com.android.volley.RequestQueue
import com.android.volley.toolbox.Volley
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.Response

import com.google.gson.Gson

import br.com.monteoliva.testegithub.model.enums.Endpoints
import br.com.monteoliva.testegithub.model.gson.Repos
import br.com.monteoliva.testegithub.presenter.MVP
import br.com.monteoliva.testegithub.utils.Constantes

class Model(private val presenter: MVP.Presenter) : MVP.Model {
    private lateinit var requestQueue: RequestQueue

    override fun loadRepos()  { load(Type.LOAD_FIRST) }
    override fun loadUpdate() { load(Type.LOAD_UPDATE) }

    private fun load(type: Type) {
        val baseUrl: String = Constantes.baseURL + Endpoints.LIST.endpoint()

        if (type == Type.LOAD_FIRST) {
            presenter.showProgressBar(true)
        }

        val request = StringRequest(
            Request.Method.GET,
            baseUrl,
            Response.Listener<String> {
                val data: Repos = Gson().fromJson(it.trim(), Repos::class.java)

                when(type) {
                    Type.LOAD_FIRST  -> presenter.updateListRecycler(data.items)
                    Type.LOAD_UPDATE -> presenter.updateList(data.items)
                }
            },
            Response.ErrorListener {
            }
        )

        requestQueue = Volley.newRequestQueue(presenter.context)
        requestQueue.add(request)
    }

    private enum class Type { LOAD_FIRST, LOAD_UPDATE }
}