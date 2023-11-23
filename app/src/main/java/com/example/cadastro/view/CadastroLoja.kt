package com.example.helloworld.view

import android.annotation.SuppressLint
import android.graphics.drawable.Icon
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.cadastro.repositorios.LojaRepositorio
import com.example.cadastro.view.component.CaixaDeTexto
import java.util.UUID

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CadastroLoja(navController: NavController) {

    val repositorioLoja = LojaRepositorio()

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    Text(text = "Cadastrar Loja")
                },
                navigationIcon = {
                    IconButton(
                        onClick = { navController.popBackStack()}
                    ) {
                        Icon(imageVector = Icons.Outlined.ArrowBack, contentDescription = "Botão Voltar")
                    }
                }
            )
        }
    ) { innerPadding ->

        var nomeLoja by remember {
            mutableStateOf("")
        }

        var endereco by remember {
            mutableStateOf("")
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(innerPadding)
        ) {
            CaixaDeTexto(
                value = nomeLoja,
                onValueChange = {
                    nomeLoja = it
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                label ="Nome Loja",
                maxLines = 1
            )

            CaixaDeTexto(
                value = endereco,
                onValueChange = {
                    endereco = it
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                label ="Endereço",
                maxLines = 2
            )

            Button(
                modifier = Modifier.fillMaxWidth()
                    .padding(10.dp),
                onClick = {
                    repositorioLoja.salvarLoja(UUID.randomUUID().toString(), nomeLoja, endereco)
                }
            ) {
                Text(text = "Cadastrar")
            }
        }

    }
}