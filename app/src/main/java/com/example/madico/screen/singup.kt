package com.example.madico.screen

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons

import androidx.compose.material.icons.filled.LockOpen
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PhoneAndroid
import androidx.compose.material.icons.filled.ShareLocation
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.madico.R.drawable.signup
import com.example.madico.api.api
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

@Composable
@Preview
fun singupSceen(){
    var namevalueholder by remember {
        mutableStateOf("")
    }
    var passwordvalueholder by remember {
        mutableStateOf("")
    }
    var passwordVisible by remember { mutableStateOf(false) }
    var phonevalueholder by remember {
        mutableStateOf("")
    }
    var emailvalueholder by remember {
        mutableStateOf("")
    }
    var zipvalueholder by remember {
        mutableStateOf("")
    }
    var addressvalueholder by remember {
        mutableStateOf("")
    }

    Column(modifier = Modifier
        .fillMaxSize()
        .background(color = androidx.compose.ui.graphics.Color.White)
        .verticalScroll(rememberScrollState())){
        Image(painter= painterResource(id = signup), contentDescription = null,modifier = Modifier
            .padding(top = 0.dp)
            .heightIn(210.dp)
            .width(250.dp)
            .align(Alignment.CenterHorizontally), contentScale = ContentScale.Fit)


       OutlinedTextField(value =(namevalueholder), onValueChange ={
           namevalueholder= it
       }, label = {
           Text(text = "Enter your name")
       }, maxLines = 1, singleLine = true , leadingIcon = {
           Icon(imageVector = Icons.Default.Person, contentDescription = null)
       }, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text), modifier = Modifier
           .fillMaxWidth()
           .padding(horizontal = 20.dp)
           , shape = RoundedCornerShape(corner = CornerSize(10.dp)))
        Spacer(modifier = Modifier.padding(1.dp))
        OutlinedTextField(
            value = passwordvalueholder,
            onValueChange = { passwordvalueholder = it },
            label = { Text("Enter password") },
            maxLines =1,
            singleLine = true,
            leadingIcon = { Icon(imageVector = Icons.Default.LockOpen, contentDescription = null) },
            trailingIcon = {
                IconButton(onClick = { passwordVisible = !passwordVisible }) {
                    Icon(imageVector = if (passwordVisible) Icons.Filled.Visibility else Icons.Filled.VisibilityOff,
                        contentDescription = if (passwordVisible) "Hide password" else "Show password")

                }
            },
            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp), shape = RoundedCornerShape(10.dp)
        )
        Spacer(modifier = Modifier.padding(1.dp))
        OutlinedTextField(value =(phonevalueholder), onValueChange ={
            phonevalueholder= it
        }, label = {
            Text(text = "Enter Phone number")
        }, maxLines = 1, singleLine = true , leadingIcon = {
            Icon(imageVector = Icons.Default.PhoneAndroid, contentDescription = null)
        }, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone), modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
          , shape = RoundedCornerShape(corner = CornerSize(10.dp)))
        Spacer(modifier = Modifier.padding(1.dp))
        OutlinedTextField(value =(emailvalueholder), onValueChange ={
            emailvalueholder= it
        }, label = {
            Text(text = "Enter Email")
        }, maxLines = 1, singleLine = true , leadingIcon = {
            Icon(imageVector = Icons.Default.MailOutline, contentDescription = null)
        }, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email), modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
            , shape = RoundedCornerShape(corner = CornerSize(10.dp)))
        Spacer(modifier = Modifier.padding(1.dp))
        OutlinedTextField(value =(zipvalueholder), onValueChange ={
            zipvalueholder= it
        }, label = {
            Text(text = "Enter Zip/Pin code")
        }, maxLines = 1, singleLine = true , leadingIcon = {
            Icon(imageVector = Icons.Default.ShareLocation, contentDescription = null)
        }, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number), modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
            , shape = RoundedCornerShape(corner = CornerSize(10.dp)))
        Spacer(modifier = Modifier.padding(1.dp))
        OutlinedTextField(value =(addressvalueholder), onValueChange ={
            addressvalueholder = it
        }, label = {
            Text(text = "Enter Address")
        }, maxLines = 6, minLines = 3, singleLine = false ,
         keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email), modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
            , shape = RoundedCornerShape(corner = CornerSize(15.dp)))
        Spacer(modifier = Modifier.padding(18.dp))
        var context:Context = LocalContext.current
        Button(onClick = {
            GlobalScope.launch {
                try {

                    api.instance.createuser(name = namevalueholder, password = passwordvalueholder, email = emailvalueholder, phone = phonevalueholder, pin = zipvalueholder, address = addressvalueholder)
                }
                catch (e:Exception){

                }

            }
        }, modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 15.dp)
            .heightIn(48.dp), shape = RoundedCornerShape(7.dp)){
            Text(text = "Sign up")
        }
        Row (modifier = Modifier.fillMaxWidth()){
            Text(text = "Already have an account?", modifier = Modifier.padding(top = 5.dp, start = 60.dp, bottom = 30.dp), color = androidx.compose.ui.graphics.Color.Black, fontSize = 13.sp)
            Text(text = "Sign in",modifier = Modifier.padding(top = 5.dp, start = 3.dp, bottom = 60.dp), fontWeight = FontWeight.ExtraBold, fontSize = 14.sp)

        }


    }



}