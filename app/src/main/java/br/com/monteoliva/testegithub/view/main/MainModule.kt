package br.com.monteoliva.testegithub.view.main

import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

object MainModule {
    private val mainModule = module {
        viewModel { MainViewModel() }
    }

    fun loadModule() {
        loadKoinModules(
            listOf(
                mainModule
            )
        )
    }
}