package me.svbneelmne.compose.splittrip

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import me.svbneelmne.compose.splittrip.MainActivity.Companion.INR_Symbol
import me.svbneelmne.compose.splittrip.ui.theme.SplitTripTheme

class MainActivity : ComponentActivity() {

    companion object {
        const val INR_Symbol = "\u20B9"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp {
                Header()
            }
        }
    }
}


@Composable
fun MyApp(content: @Composable () -> Unit) {
    SplitTripTheme {
        Surface(color = MaterialTheme.colors.background) {
            content()
        }
    }
}

@Composable
fun Header(totalPerPerson: Double = 134.4) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp)
            .clip(shape = RoundedCornerShape(corner = CornerSize(12.dp))),
        //  .clip(shape = CircleShape.copy(app = CornerSize(12.dp)) can be used also
        color = Color(0xFF8D9BEE)
    ) {
        Column(
            modifier = Modifier.padding(12.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val total = "%.2f".format(totalPerPerson)
            Text(
                text = "Total per Person",
                style = MaterialTheme.typography.h5
            )
            Text(
                text = "$INR_Symbol $total",
                style = MaterialTheme.typography.h4,
                fontWeight = FontWeight.ExtraBold
            )
        }
    }
}



//@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApp {
        Text(text = "Hello Again")
    }
}