package com.example.navigasi

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.navigasi.data.OrderUIState
import com.example.navigasi.ui.theme.komponen.FormatLabelHarga

@Composable
fun HalamanDua(
    orderUIState: OrderUIState,
    onCancelButtonClicked: () -> Unit,
    modifier: Modifier = Modifier
){
    val item = listOf(
        Pair(stringResource(R.string.quantity),orderUIState.jumlah),
        Pair(stringResource(R.string.flavor),orderUIState.rasa)
    )
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.SpaceBetween
    ) {

        Column(

            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Data Customer",
                modifier = Modifier.padding(20.dp),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
            Row (modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceAround){
                Text(stringResource(id = R.string.nama))
                Text(orderUIState.nama)
            }
            Spacer(modifier = Modifier.padding(20.dp))
            Row (modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceAround){
                Text(stringResource(id = R.string.alamat))
                Text(orderUIState.alamat)
            }
            Spacer(modifier = Modifier.padding(20.dp))
            Row (modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceAround){
                Text(stringResource(id = R.string.telepon))
                Text(orderUIState.noTelp)
            }

            Text(
                text = "Detail Item",
                modifier = Modifier.padding(20.dp),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )

        }
        Column(
            modifier = Modifier.padding(dimensionResource(R.dimen.padding_medium)),
            verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small))
        ) {
            item.forEach { item ->
                Column {
                    Text(item.first.uppercase())
                    Text(text = item.second.toString(), fontWeight = FontWeight.Bold)
                }
                Divider(thickness = dimensionResource(R.dimen.thickness_divider))
            }
            Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_small)))
            FormatLabelHarga(subtotal = orderUIState.harga,
                                modifier = Modifier.align(Alignment.End)
            )
        }
        Row (
            modifier = Modifier
                .weight(1f, false)
                .padding(dimensionResource(R.dimen.padding_medium))
        ){
            Column(
                verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small))
            ) {
                Button(modifier = Modifier.fillMaxWidth(),
                    onClick = {}
                ) {
                }
                OutlinedButton(modifier = Modifier.fillMaxWidth(),
                    onClick = onCancelButtonClicked
                ) {
                    Text(stringResource(R.string.cancel))
                }
            }
        }
    }
}