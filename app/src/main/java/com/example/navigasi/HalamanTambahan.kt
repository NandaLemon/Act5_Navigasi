package com.example.navigasi

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HalamanTambahan(
    onSubmitButtonClick:(MutableList<String>) -> Unit
){
    var nameTxt by rememberSaveable {
        mutableStateOf("")
    }
    var AlamatTxt by rememberSaveable {
        mutableStateOf("")
    }
    var telponTxt by rememberSaveable {
        mutableStateOf("")
    }
    var  listDataTxt : MutableList<String> = mutableListOf(nameTxt, AlamatTxt, telponTxt)

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()
    ) {

        OutlinedTextField(value = nameTxt, onValueChange ={nameTxt = it },
            label  = { Text(text = "Nama") } )
        OutlinedTextField(value = AlamatTxt, onValueChange ={AlamatTxt = it },
            label  = { Text(text = "Alamat") } )
        OutlinedTextField(value = telponTxt, onValueChange ={telponTxt= it },
            label  = { Text(text = "Telpon") } )
        Spacer(modifier = Modifier.padding(16.dp))
        Button(onClick = { onSubmitButtonClick(listDataTxt) }) {
            Text(text = stringResource(id = R.string.submit))
        }
    }
}