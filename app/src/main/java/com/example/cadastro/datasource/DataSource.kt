package com.example.cadastro.datasource

import com.google.firebase.firestore.FirebaseFirestore
import java.io.PrintStream

class DataSource {

    private val db = FirebaseFirestore.getInstance()

    fun salvarLoja(id: String, nomeLoja: String, endereco: String) {

        val lojaMap = hashMapOf(
            "id" to id,
            "nomeLoja" to nomeLoja,
            "endereco" to endereco
        )

        db.collection("lojas").document(id).set(lojaMap).addOnCompleteListener {

        }.addOnFailureListener {

        }
    }
}