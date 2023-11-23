package com.example.cadastro.repositorios

import com.example.cadastro.datasource.DataSource

class LojaRepositorio() {

    private val dataSource = DataSource()

    fun salvarLoja(id: String, nomeLoja: String, endereco: String) {
        dataSource.salvarLoja(id,nomeLoja,endereco)
    }
}