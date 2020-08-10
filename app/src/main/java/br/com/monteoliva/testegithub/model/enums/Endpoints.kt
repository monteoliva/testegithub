package br.com.monteoliva.testegithub.model.enums

enum class Endpoints(private val endpoint: String) {
    LIST("/search/repositories?q=language:kotlin&sort=stars&page=1");

    fun endpoint(): String = endpoint
}