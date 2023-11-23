package com.example.cadastro.view.component

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CaixaDeTexto(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier,
    label: String,
    maxLines: Int
)
{
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        modifier,
        label = {
            Text(text = label)
        },
        maxLines = maxLines
    )
}