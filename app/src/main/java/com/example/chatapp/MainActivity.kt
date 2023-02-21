package com.example.chatapp


import android.os.Bundle
import com.example.chatapp.R
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.*
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.chatapp.destinations.ChatViewDestination
import com.example.chatapp.destinations.SingUpScreenDestination
import com.example.chatapp.destinations.loginScreenDestination
import com.example.chatapp.ui.theme.ChatAppTheme
import com.google.firebase.FirebaseApp
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        FirebaseApp.initializeApp(this)
        setContent {
            ChatAppTheme {
                // A surface container using the 'background' color from the theme
                Column(modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White)) {
                    DestinationsNavHost(navGraph = NavGraphs.root)
                }
            }
        }
    }
}

@Composable
@Destination
fun SingUpScreen(nav: DestinationsNavigator) {
//    var textShopName by remember { mutableStateOf("") }
    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var value by remember {
        mutableStateOf("")
    }

    var showPassword by remember {
        mutableStateOf(false)
    }
    Image(
        modifier = Modifier.fillMaxWidth(),
        painter =  painterResource(R.drawable.rectangle_8),
        contentDescription = null
    )
    Box(modifier = Modifier.fillMaxSize()) {
        Card(modifier = Modifier
            .fillMaxWidth()
            .align(Alignment.BottomCenter)
            .height(575.dp),
            shape = RoundedCornerShape(60.dp,0.dp,0.dp,0.dp)
        ) {
            Card(modifier = Modifier
                .fillMaxSize()
                .background(color = Color(0xFFFFFFFF)),) {
                Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment =Alignment.CenterHorizontally ) {
                    Spacer(modifier = Modifier.height(52.dp))
                    Text(text = "Sign Up"
                        , color = Color(0xFFFFA925),
                        fontSize = 36.sp,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(50.dp))
                    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                        OutlinedTextField(
                            modifier = Modifier.size(310.dp,58.dp),
                            value = email, onValueChange = { email = it },
                            textStyle = TextStyle.Default.copy(
                                fontSize = 14.sp,
                                color = Color(0xFFCCCCCC)
                            ),
                            shape = RoundedCornerShape(10.dp),
                            colors = TextFieldDefaults.outlinedTextFieldColors(
                                focusedBorderColor = Color(0xFFFFA925),
                                focusedLabelColor = Color(0xFFFFA925),
                                unfocusedBorderColor = Color(0xFFF6F7FB),
                                backgroundColor = Color(0xFFF6F7FB),

                                ),
                            leadingIcon = { Icon(imageVector = Icons.Default.Email, contentDescription = "Email Icon", tint = Color(0xFFC5C5C7)) },

                            placeholder = {
                                Text(text = " alberto@gmail.com ", fontSize = 14.sp, color = Color(0xff262626))
                            },
                            singleLine = true,
                            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),

                            )
                    }
                    Spacer(modifier = Modifier.height(30.dp))
                    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                        OutlinedTextField(
                            modifier = Modifier.size(310.dp,58.dp),
                            value = password, onValueChange = { password = it },
                            textStyle = TextStyle.Default.copy(
                                fontSize = 14.sp,
                                color = Color(0xFFCCCCCC)
                            ),
                            shape = RoundedCornerShape(10.dp),
                            colors = TextFieldDefaults.outlinedTextFieldColors(

                                focusedBorderColor = Color(0xFFFFA925),
                                unfocusedBorderColor = Color(0xFFF6F7FB),
                                backgroundColor = Color(0xFFF6F7FB),
                                ),
                            leadingIcon = {
                                Icon(
                                    imageVector = Icons.Default.Lock,
                                    contentDescription = "Lock Icon", tint = Color(0xFFC5C5C7)
                                )
                            },



                            trailingIcon = {
                                IconButton(onClick = { showPassword = !showPassword }) {
                                    Icon(
                                        painter = if (showPassword) painterResource(R.drawable.vector__9_) else painterResource(R.drawable.visibility),
                                        contentDescription = if (showPassword) "Show Password" else "Hide Password"
                                    )
                                }
                            },
                            visualTransformation = if (showPassword) VisualTransformation.None else PasswordVisualTransformation(),

                            placeholder = {
                                Text(text = " alberto@gmail.com ", fontSize = 14.sp, color = Color(0xFF262626))
                            },
                            singleLine = true,
                            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),

                            )
                    }

                     Spacer(modifier = Modifier.height(140.dp))
                        Button(modifier = Modifier
                            .fillMaxWidth()
//                            .height(58.dp)
                            .padding(40.dp, 0.dp),onClick = {
                            nav.navigate(loginScreenDestination)
                            //your onclick code here
                            nav.navigate(ChatViewDestination)
                        },shape = RoundedCornerShape(10.dp),colors = ButtonDefaults.buttonColors(backgroundColor =Color(0xFFFFA925))) {
                            Text(text = "Sign Up",color = Color(0xFFFFFFFF))
                        }
                    Row(modifier = Modifier
                        .fillMaxWidth()
//                        .padding(40.dp, 0.dp)
                        , horizontalArrangement = Arrangement.Center) {
                        Text(modifier = Modifier.padding(0.dp,17.dp),text = "Dont have a account? ",fontSize = 12.sp)
                        TextButton(onClick = { /*TODO*/ }, modifier = Modifier.padding(0.dp)) {
                            Text  ("sign up here", color = Color(0xffffA925), fontSize = 12.sp)
                        }
                    }


                }




            }
        }
    }
}
@Composable
@Destination(start = true)
fun loginScreen(nav: DestinationsNavigator) {

    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var value by remember {
        mutableStateOf("")
    }

    var showPassword by remember {
        mutableStateOf(false)
    }
    Image(
        modifier = Modifier.fillMaxWidth(),
        painter =  painterResource(R.drawable.rectangle_8),
        contentDescription = null
    )
    Box(modifier = Modifier.fillMaxSize()) {
        Card(modifier = Modifier
            .fillMaxWidth()
            .align(Alignment.BottomCenter)
            .height(575.dp),
            shape = RoundedCornerShape(60.dp,0.dp,0.dp,0.dp)
        ) {
            Card(modifier = Modifier
                .fillMaxSize()
                .background(color = Color(0xFFFFFFFF)),) {
                Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment =Alignment.CenterHorizontally ) {
                    Spacer(modifier = Modifier.height(52.dp))
                    Text(text = "Log In"
                        , color = Color(0xFFFFA925),
                        fontSize = 36.sp,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(50.dp))
                    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                        OutlinedTextField(
                            modifier = Modifier.size(310.dp,58.dp),
                            value = email, onValueChange = { email = it },
                            textStyle = TextStyle.Default.copy(
                                fontSize = 14.sp,
                                color = Color(0xFFCCCCCC)
                            ),
                            shape = RoundedCornerShape(10.dp),
                            colors = TextFieldDefaults.outlinedTextFieldColors(
                                focusedBorderColor = Color(0xFFFFA925),
                                focusedLabelColor = Color(0xFFFFA925),
                                unfocusedBorderColor = Color(0xFFF6F7FB),
                                backgroundColor = Color(0xFFF6F7FB),

                                ),
                            leadingIcon = { Icon(imageVector = Icons.Default.Email, contentDescription = "Email Icon", tint = Color(0xFFC5C5C7)) },

                            placeholder = {
                                Text(text = " alberto@gmail.com ", fontSize = 14.sp, color = Color(0xff262626))
                            },
                            singleLine = true,
                            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),

                            )
                    }
                    Spacer(modifier = Modifier.height(30.dp))
                    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                        OutlinedTextField(
                            modifier = Modifier.size(310.dp,58.dp),
                            value = password, onValueChange = { password = it },
                            textStyle = TextStyle.Default.copy(
                                fontSize = 14.sp,
                                color = Color(0xFFCCCCCC)
                            ),
                            shape = RoundedCornerShape(10.dp),
                            colors = TextFieldDefaults.outlinedTextFieldColors(

                                focusedBorderColor = Color(0xFFFFA925),
                                unfocusedBorderColor = Color(0xFFF6F7FB),
                                backgroundColor = Color(0xFFF6F7FB),
                            ),
                            leadingIcon = {
                                Icon(
                                    imageVector = Icons.Default.Lock,
                                    contentDescription = "Lock Icon", tint = Color(0xFFC5C5C7)
                                )
                            },



                            trailingIcon = {
                                IconButton(onClick = { showPassword = !showPassword }) {
                                    Icon(
                                        painter = if (showPassword) painterResource(R.drawable.vector__9_) else painterResource(R.drawable.visibility),
                                        contentDescription = if (showPassword) "Show Password" else "Hide Password"
                                    )
                                }
                            },
                            visualTransformation = if (showPassword) VisualTransformation.None else PasswordVisualTransformation(),

                            placeholder = {
                                Text(text = " alberto@gmail.com ", fontSize = 14.sp, color = Color(0xFF262626))
                            },
                            singleLine = true,
                            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),

                            )
                    }
                    Row(modifier = Modifier
                        .fillMaxWidth()
                        .padding(40.dp, 0.dp) , horizontalArrangement = Arrangement.End) {
                        TextButton(onClick = { /*TODO*/ }, modifier = Modifier.padding(0.dp)) {
                            Text  ("forgot Password ?", color = Color(0xffffA925), fontSize = 12.sp)
                        }                    }

                    Spacer(modifier = Modifier.height(120.dp))
                    Button(modifier = Modifier
                        .fillMaxWidth()
//                            .height(58.dp)
                        .padding(40.dp, 0.dp),onClick = {
                        //your onclick code here
                          nav.navigate(ChatViewDestination)
                    },shape = RoundedCornerShape(10.dp),colors = ButtonDefaults.buttonColors(backgroundColor =Color(0xFFFFA925))) {
                        Text(text = "Login",color = Color(0xFFFFFFFF))
                    }
                    Row(modifier = Modifier
                        .fillMaxWidth()
//                        .padding(40.dp, 0.dp)
                        , horizontalArrangement = Arrangement.Center) {
                        Text(modifier = Modifier.padding(0.dp,17.dp),text = "Dont have a account? ",fontSize = 12.sp)
                        TextButton(onClick = { /*TODO*/
                                             nav.navigate(SingUpScreenDestination)
                                             }, modifier = Modifier.padding(0.dp)) {
                            Text  ("login here", color = Color(0xffffA925), fontSize = 12.sp)
                        }
                    }


                }




            }
        }
    }
}
@Composable
@Destination
fun ContactView(nav: DestinationsNavigator){
    Column(modifier = Modifier.fillMaxSize()) {
        Row(verticalAlignment = Alignment.Top,
            modifier = Modifier
                .fillMaxWidth()
                .height(58.dp)
                .padding(10.dp, 5.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Button(
                onClick = {
//                            nav.navigate(searchNoteDestination)
                },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color(0xFFFAFAFA),
                    contentColor = androidx.compose.ui.graphics.Color.White
                ),
                modifier = Modifier
//                .align(Alignment.End)
                    .size(48.dp, 48.dp),
                shape = RoundedCornerShape(15.dp),
                contentPadding = PaddingValues(0.dp, 10.dp, 0.dp, 10.dp)
            ) {
                Icon(Icons.Default.Search, contentDescription = "Search", tint = Color(0xffa3a3a3))
            }

            Text(
                modifier = Modifier.align(Alignment.CenterVertically),
                text = "Home",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,

                color = androidx.compose.ui.graphics.Color.Black,
            )

            Column() {
                Row(
                ) {

                    Column() {
                        Button(
                            onClick = {
//                            nav.navigate(searchNoteDestination)
                            },
                            colors = ButtonDefaults.buttonColors(
                                backgroundColor = Color(0xFFFAFAFA),
                                contentColor = androidx.compose.ui.graphics.Color.White
                            ),
                            modifier = Modifier
                                .align(Alignment.End)
                                .size(48.dp, 48.dp),
                            shape = RoundedCornerShape(15.dp),
                            contentPadding = PaddingValues(0.dp, 0.dp, 0.dp, 0.dp)
                        ) {
                            Image(
                                painter = painterResource(R.drawable.unsplash_tn8dlxwudma),
                                contentDescription = "Search"
                            )
                        }
                    }

                }

            }
        }
        Row(horizontalArrangement = Arrangement.SpaceBetween,modifier = Modifier
            .fillMaxWidth()
            .padding(30.dp)) {
            Column() {
                Card(shape = RoundedCornerShape(16.5.dp)
                    ,modifier = Modifier.size(116.dp,153.dp), backgroundColor = Color(0xfffafafa)) {
                    
                }
            }
            Column() {
                Card(shape = RoundedCornerShape(16.5.dp),modifier = Modifier.size(116.dp,153.dp), backgroundColor = Color(0xfffafafa)) {

                }
            }
            Column() {
                Card(shape = RoundedCornerShape(16.5.dp),modifier = Modifier.size(116.dp,153.dp), backgroundColor = Color(0xfffafafa)) {

                }
            }
        }
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            Card(modifier = Modifier.size(347.dp,171.dp), backgroundColor = Color(0xfffafafa),shape = RoundedCornerShape(16.5.dp)) {
            }
        }
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp), horizontalArrangement = Arrangement.Center) {
            Column() {
                Card(shape = RoundedCornerShape(16.5.dp),modifier = Modifier.size(103.dp,125.dp), backgroundColor = Color(0xfffafafa)) {
                    
                }
            }
            Column(modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp, 0.dp, 0.dp, 0.dp)) {
                Row(modifier = Modifier
                    .size(231.dp, 20.dp)
                    .background(Color(0xfffafafa))) {
                }
                Spacer(modifier = Modifier.height(15.dp))
                Row(modifier = Modifier
                    .size(231.dp, 20.dp)
                    .background(Color(0xfffafafa))) {
                }
                Spacer(modifier = Modifier.height(15.dp))
                Row(modifier = Modifier
                    .size(231.dp, 20.dp)
                    .background(Color(0xfffafafa))) {
                }
                Spacer(modifier = Modifier.height(15.dp))
                Row(modifier = Modifier
                    .size(231.dp, 20.dp)
                    .background(Color(0xfffafafa))) {
                }
            }
        }
        Row(modifier = Modifier
            .fillMaxSize()
            .padding(0.dp, 0.dp, 30.dp, 50.dp), verticalAlignment = Alignment.Bottom, horizontalArrangement = Arrangement.End) {
            Button(
                onClick = {
//                            nav.navigate(searchNoteDestination)
                },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color(0xFFFFA925),
                    contentColor = androidx.compose.ui.graphics.Color.White
                ),
                modifier = Modifier
                    .size(48.dp, 48.dp),
                shape = RoundedCornerShape(40.dp),
                contentPadding = PaddingValues(0.dp, 0.dp, 0.dp, 0.dp)
            ) {
                Image(
                    painter = painterResource(R.drawable.frame__1_),
                    contentDescription = "Chat"
                )
            }
        }
    }

}

@Composable
@Destination
fun ChatView(nav: DestinationsNavigator){
    Column(modifier = Modifier.fillMaxSize()) {
        Row(verticalAlignment = Alignment.Top,
            modifier = Modifier
                .fillMaxWidth()
                .height(58.dp)
                .padding(10.dp, 5.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Button(
                onClick = {
//                            nav.navigate(searchNoteDestination)
                },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color(0xFFFAFAFA),
                    contentColor = androidx.compose.ui.graphics.Color.White
                ),
                modifier = Modifier
//                .align(Alignment.End)
                    .size(48.dp, 48.dp),
                shape = RoundedCornerShape(15.dp),
                contentPadding = PaddingValues(0.dp, 10.dp, 0.dp, 10.dp)
            ) {
                Icon(Icons.Default.Search, contentDescription = "Search", tint = Color(0xffa3a3a3))
            }

            Text(
                modifier = Modifier.align(Alignment.CenterVertically),
                text = "Home",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,

                color = androidx.compose.ui.graphics.Color.Black,
            )

            Column() {
                Row(
                ) {

                    Column() {
                        Button(
                            onClick = {
//                            nav.navigate(searchNoteDestination)
                            },
                            colors = ButtonDefaults.buttonColors(
                                backgroundColor = Color(0xFFFfffff),
                                contentColor = androidx.compose.ui.graphics.Color.White
                            ),
                            modifier = Modifier
                                .align(Alignment.End)
                                .size(48.dp, 48.dp),
                            shape = RoundedCornerShape(20.dp),
                            contentPadding = PaddingValues(0.dp, 0.dp, 0.dp, 0.dp)
                        ) {
                            Image(
                                painter = painterResource(R.drawable.unsplash_tn8dlxwudma),
                                contentDescription = "User"
                            )
                        }
                    }

                }

            }
        }

//        Row(modifier = Modifier
//            .fillMaxWidth()
//            .padding(20.dp), horizontalArrangement = Arrangement.Center) {
//            Card(modifier = Modifier
//                .size(375.dp, 80.dp)
//                ) {
//            Row(modifier = Modifier.fillMaxSize()) {
//             Column(horizontalAlignment = Alignment.Start, verticalArrangement = Arrangement.Center,
//                 modifier = Modifier
//                     .padding(10.dp)
//                     .align(alignment = Alignment.CenterVertically)) {
//               Image(modifier = Modifier.size(48.dp,48.dp),painter = painterResource(R.drawable.unsplash_tn8dlxwudma__1_), contentDescription = "user" )
//             }
//                Column( modifier = Modifier.align(alignment = Alignment.CenterVertically)) {
//                    Text(text = "Alberto dwdfw", fontSize = 14.sp, fontWeight = FontWeight.SemiBold)
//                    Text(text = "say any thing ...", fontSize = 10.sp, color = Color(0xffFFA925))
//                }
//                Spacer(modifier = Modifier.width(130.dp))
//
//                Column( horizontalAlignment = Alignment.End,modifier = Modifier
//                    .align(alignment = Alignment.CenterVertically)
//                    .fillMaxWidth()
//                    .padding(5.dp)) {
//                  Text(textAlign = TextAlign.Center,text = " 2 min ago ", fontSize = 10.sp,)
//                    Spacer(modifier = Modifier.height(5.dp))
//                  Card(shape = RoundedCornerShape(10.dp),modifier = Modifier.size(16.dp,16.dp), backgroundColor = Color(0xffFFA925)) {
//                      Text(textAlign = TextAlign.Center,text = "1", fontSize = 10.sp, color = Color(0xffffffff))
//                  }
//
//              }
//            }
//            }
//        }

        LazyColumn(modifier = Modifier
            .fillMaxWidth()
            .height(580.dp)) {


            // Add 5 items
            items(8) { index ->
                Row(modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp), horizontalArrangement = Arrangement.Center) {
                    Card(modifier = Modifier
                        .size(375.dp, 80.dp)
                    ) {
                        Row(modifier = Modifier.fillMaxSize()) {
                            Column(horizontalAlignment = Alignment.Start, verticalArrangement = Arrangement.Center,
                                modifier = Modifier
                                    .padding(10.dp)
                                    .align(alignment = Alignment.CenterVertically)) {
                                Image(modifier = Modifier.size(48.dp,48.dp),painter = painterResource(R.drawable.unsplash_tn8dlxwudma__1_), contentDescription = "user" )
                            }
                            Column( modifier = Modifier.align(alignment = Alignment.CenterVertically)) {
                                Text(text = "Alberto dwdfw", fontSize = 14.sp, fontWeight = FontWeight.SemiBold)
                                Text(text = "say any thing ...", fontSize = 10.sp, color = Color(0xffFFA925))
                            }
                            Spacer(modifier = Modifier.width(130.dp))

                            Column( horizontalAlignment = Alignment.End,modifier = Modifier
                                .align(alignment = Alignment.CenterVertically)
                                .fillMaxWidth()
                                .padding(5.dp)) {
                                Text(textAlign = TextAlign.Center,text = " 2 min ago ", fontSize = 10.sp,)
                                Spacer(modifier = Modifier.height(5.dp))
                                Card(shape = RoundedCornerShape(10.dp),modifier = Modifier.size(16.dp,16.dp), backgroundColor = Color(0xffFFA925)) {
                                    Text(textAlign = TextAlign.Center,text = "1", fontSize = 10.sp, color = Color(0xffffffff))
                                }

                            }
                        }
                    }
                }
            }


        }


        Row(modifier = Modifier
            .fillMaxSize()
            .padding(0.dp, 0.dp, 30.dp, 50.dp), verticalAlignment = Alignment.Bottom, horizontalArrangement = Arrangement.End) {
            Button(
                onClick = {
//                            nav.navigate(searchNoteDestination)
                },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color(0xFFFFA925),
                    contentColor = androidx.compose.ui.graphics.Color.White
                ),
                modifier = Modifier
                    .size(48.dp, 48.dp),
                shape = RoundedCornerShape(40.dp),
                contentPadding = PaddingValues(0.dp, 0.dp, 0.dp, 0.dp)
            ) {
                Image(
                    painter = painterResource(R.drawable.frame__1_),
                    contentDescription = "Chat"
                )
            }
        }
    }

}
@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ChatAppTheme {
        Greeting("Android")
    }
}