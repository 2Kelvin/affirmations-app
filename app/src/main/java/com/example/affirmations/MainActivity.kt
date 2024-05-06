package com.example.affirmations

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.affirmations.data.Datasource
import com.example.affirmations.model.Affirmation
import com.example.affirmations.ui.theme.AffirmationsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AffirmationsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AffirmationsApp()
                }
            }
        }
    }
}

@Composable
fun AffirmationsApp(modifier: Modifier = Modifier) {
    // loading Affirmation objects list from Datasource class method
    // and displaying each Affirmation object in AffirmationList LazyColumn composable
    AffirmationList(affirmationList = Datasource().loadAffirmations())
}

// reusable affirmation card
@Composable
fun AffirmationCard(affirmationObj: Affirmation, modifier: Modifier = Modifier) {
    OutlinedCard(modifier = modifier) {
        Column {
            Image(
                painter = painterResource(id = affirmationObj.imageResourceId),
                contentDescription = stringResource(id = affirmationObj.stringResourceId),
                modifier = modifier
                    .fillMaxWidth()
                    .height(194.dp),
                contentScale = ContentScale.Crop
            )

            Text(
                text = stringResource(id = affirmationObj.stringResourceId),
                modifier = modifier.padding(16.dp),
                style = MaterialTheme.typography.headlineSmall
            )
        }
    }
}

// all affirmations (list)
@Composable
fun AffirmationList(affirmationList: List<Affirmation>, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier.padding(horizontal = 10.dp, vertical = 5.dp)) {
        // items property contains the affirmation list &
        // adds it to the LazyColumn for display
        items(affirmationList) {oneAffirmationObj ->
            // this lambda functions iterates over each affirmation object in the list
            // and passes each one to the reusable AffirmationCard to be displayed in the UI
            AffirmationCard(
                affirmationObj = oneAffirmationObj,
                modifier = modifier.padding(8.dp)
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun AffirmationAppPreview() {
    AffirmationsTheme {
        AffirmationsApp()
    }
}