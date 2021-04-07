package com.example.compose1

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.shape.ZeroCornerSize
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.animatedVectorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose1.ui.theme.Compose1Theme
import com.example.compose1.ui.theme.Shapes
import com.example.compose1.ui.theme.orangish
import com.example.compose1.ui.theme.purplish


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Compose1Theme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Login()

                }
            }
        }
    }
}

@Composable
fun Login() {
    Surface(color = purplish,modifier = Modifier.fillMaxSize()){

    }
    Surface(color = Color.White,
        modifier = Modifier
            .height(600.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(60.dp).copy(topStart = ZeroCornerSize,topEnd = ZeroCornerSize)
    ){
        Column(modifier = Modifier.padding(16.dp),horizontalAlignment = Alignment.CenterHorizontally) {

            val md = Modifier.padding(16.dp)
             Image(painter = painterResource(R.drawable.cleaner) ,
                 contentDescription = "my image",
                 modifier = Modifier
                     .fillMaxWidth()
                     .height(200.dp)

             )
            Spacer(modifier = Modifier.padding(16.dp))

            val text = remember { mutableStateOf(TextFieldValue("johnsonyaanga@gmail.com")) }
            val passState = remember { mutableStateOf(TextFieldValue("Password")) }

            OutlinedTextField(
                value = text.value,
                onValueChange = { text.value = it },
                label = { Text("Email Address") },
                leadingIcon = {Icon(Icons.Filled.Email,"email")},
                modifier = Modifier.padding(16.dp)
            )

            OutlinedTextField(
                value = passState.value,
                onValueChange = { passState.value = it },
                label = { Text("Password") },
                leadingIcon = {Icon(Icons.Filled.Lock,"password")},
                modifier = Modifier.padding(16.dp)
            )

            CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                Text(

                    text = "Forgot password",
                    modifier = md,
                    textAlign = TextAlign.Right

                )
            }

            Button(
                onClick = { /*TODO*/ },
                shape = Shapes.medium,
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    text = "Login",
                    color = Color.White,
                    modifier = Modifier
                        .padding(3.dp)
                )

            }
          





        }

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Compose1Theme {
        Login()
    }
}