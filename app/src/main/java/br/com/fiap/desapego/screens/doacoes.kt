package br.com.fiap.desapego.screens

import android.widget.Button
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType.Companion.Text
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.desapego.R
import br.com.fiap.desapego.modelodoacoes.getAllDoacoes
import br.com.fiap.desapego.modelodoacoes.getDoacoesByTitle
import br.com.fiap.desapego.modelodoacoes.modelodoacao

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DoacoesScreen(navController: NavController, cidade: String?) {

    var title by remember {
        mutableStateOf("")
    }

    var listDoacoesbytitle by remember {
        mutableStateOf(getDoacoesByTitle(title))
    }


    Box(modifier = Modifier
        .fillMaxWidth()
        .background(Color(0xFFFFFFFF))
        .padding(32.dp)
    ){
        Column(modifier = Modifier
            .padding(16.dp)
            .align(Alignment.Center)) {
            Text(
                text = "Desapegos em $cidade",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = colorResource(id = R.color.verdedoar)

            )
            Spacer(modifier = Modifier.height(16.dp))
            OutlinedTextField(
                value = title,
                onValueChange = {
                    title = it
                },
                modifier = Modifier.fillMaxWidth(),
                label = {
                    Text(text = "Filtre aqui")
                },
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedBorderColor = colorResource(id = R.color.verdedoar),
                    focusedBorderColor = colorResource(id = R.color.verdedoar)
                ),
                shape = RoundedCornerShape(16.dp),
                trailingIcon = {
                    IconButton(onClick = {
                    listDoacoesbytitle = getDoacoesByTitle(title)
                    }) {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = ""
                        )
                    }
                }
            )
            Spacer(modifier = Modifier.height(16.dp))
            LazyColumn(){
                items(listDoacoesbytitle){
                    doacaoCard(doacao = it)
                }
            }
            Button(
                onClick = {
                    navController.navigate("dados")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
                shape = RoundedCornerShape(16.dp),
                colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.verdedoar))
                //modifier = Modifier.align(Alignment.Center)
            ) {
                Text(text = "Voltar", fontSize = 20.sp, color = Color.White)
            }
        }
    }
}

@Composable
fun doacaoCard(doacao: modelodoacao) {
    Card(modifier = Modifier.padding(bottom = 8.dp)) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Column(modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .weight(3f)) {
                Text(
                    text = doacao.title,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = doacao.title,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal
                )
            }
            Text(
                text = doacao.data.toString(),
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = colorResource(R.color.verdedoar)
            )
        }
    }
}

//@Preview(showBackground = true, showSystemUi = true)
//
//@Composable
//fun DoacoesScreenPreview() {
//    DoacoesScreen()
//}