package com.indi.namecard

import android.graphics.drawable.Icon
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.clipRect
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.indi.namecard.ui.theme.NameCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NameCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background) {
                    NameCardContent()
                }
            }
        }
    }
}

@Composable
fun NameCardContent() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFf003a4a)),
    ) {
        NameCardPosition()
        Divider(color = Color(0xFF4d737d), thickness = 1.dp, modifier = Modifier.padding(bottom = 8.dp))
        NameCardInfoContact(contactIcon = R.drawable.ic_baseline_local_phone_24,
            contactText = stringResource(
                id = R.string.telephone))
        Divider(color = Color(0xFF4d737d), thickness = 1.dp, modifier = Modifier.padding(bottom = 8.dp))

        NameCardInfoContact(contactIcon = R.drawable.ic_baseline_share_24,
            contactText = stringResource(
                id = R.string.share))
        Divider(color = Color(0xFF4d737d), thickness = 1.dp, modifier = Modifier.padding(bottom = 8.dp))

        NameCardInfoContact(contactIcon = R.drawable.ic_baseline_email_24,
            contactText = stringResource(
                id = R.string.email))
    }
}

@Composable
fun NameCardPosition() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 200.dp, bottom = 200.dp),
        horizontalAlignment = Alignment.CenterHorizontally,

        ) {
        Image(painterResource(id = R.drawable.android_logo),
            contentDescription = null,
            modifier = Modifier.size(100.dp))
        Text(text = stringResource(id = R.string.name), fontSize = 44.sp, modifier = Modifier.padding(bottom = 8.dp))
        Text(text = stringResource(id = R.string.position), color = Color(0xFF48DC9A), fontWeight = FontWeight.Bold)

    }
}

@Composable
fun NameCardInfoContact(contactIcon: Int, contactText: String) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(start = 50.dp)) {
        Spacer(modifier = Modifier.height(40.dp))
        Icon(painter = painterResource(id = contactIcon), tint = Color(0xFF48DC9A), contentDescription = null)
        Text(contactText, Modifier.padding(start = 24.dp))
    }

}


@Preview(showBackground = true)
@Composable
fun NameCardPreview() {
    NameCardTheme {
        NameCardContent()
    }
}