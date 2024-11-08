package com.zeporteiro.zeporteiroapp.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.zeporteiro.zeporteiroapp.R
import com.zeporteiro.zeporteiroapp.ui.theme.ZePorteiroAppTheme

class SignUpPage : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ZePorteiroAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    SignUpScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun SignUpScreen(modifier: Modifier = Modifier) {
    var nome by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var telefone by remember { mutableStateOf("") }
    var senha by remember { mutableStateOf("") }
    var confirmarSenha by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Top
    ) {
        Text(
            text = "Faça o seu cadastro",
            fontSize = 28.sp,
            fontWeight = FontWeight.ExtraBold,
            color = Color(0xFF294B29)
        )
        Text(
            text = "Crie uma conta para começar a controlar suas encomendas",
            fontSize = 15.sp,
            color = Color(0xFF71727A),
            modifier = Modifier.padding(top = 8.dp)
        )

        Spacer(modifier = Modifier.height(24.dp))

        CampoInput(
            value = nome,
            onValueChange = { nome = it },
            label = "Nome completo",
            placeholder = "Digite o seu nome"
        )

        CampoInput(
            value = email,
            onValueChange = { email = it },
            label = "E-mail",
            placeholder = "Digite o seu e-mail",
            keyboardType = KeyboardType.Email
        )

        CampoInput(
            value = telefone,
            onValueChange = { telefone = it },
            label = "Telefone Celular",
            placeholder = "DDD + Telefone celular",
            keyboardType = KeyboardType.Phone
        )

        InputSenha(
            value = senha,
            onValueChange = { senha = it },
            label = "Senha",
            placeholder = "Digite a sua senha"
        )

        Text(
            text = "A senha precisa de:\nMínimo 6 caracteres;\nNúmeros e caracteres especiais;",
            fontSize = 10.sp,
            color = Color(0xFF8F9098),
            modifier = Modifier.padding(top = 8.dp, bottom = 12.dp)
        )

        InputSenha(
            value = confirmarSenha,
            onValueChange = { confirmarSenha = it },
            label = "Confirmar Senha",
            placeholder = "Digite a sua senha"
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = { },
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF294B29))
        ) {
            Text("Avançar", color = Color.White)
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                "Já possui conta? ",
                color = Color(0xFF71727A),
                fontSize = 12.sp
            )
            Text(
                "Acesse agora",
                color = Color(0xFF3D3D3D),
                fontSize = 12.sp,
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}

@Composable
fun CampoInput(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    placeholder: String,
    keyboardType: KeyboardType = KeyboardType.Text
) {
    Column(modifier = Modifier.padding(vertical = 6.dp)) {
        Text(
            text = label,
            fontSize = 12.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color(0xFF3D3D3D)
        )

        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            placeholder = { Text(placeholder) },
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
            keyboardOptions = KeyboardOptions(keyboardType = keyboardType)
        )
    }
}

@Composable
fun InputSenha(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    placeholder: String
) {
    Column(modifier = Modifier.padding(vertical = 6.dp)) {
        Text(
            text = label,
            fontSize = 12.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color(0xFF3D3D3D)
        )

        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            placeholder = { Text(placeholder) },
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        )
    }
}


@Preview(showBackground = true)
@Composable
fun SignUpScreenPreview3() {
    ZePorteiroAppTheme {
        SignUpScreen()
    }
}