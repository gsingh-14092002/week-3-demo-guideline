package com.example.studentprofileapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.studentprofileapp.ui.theme.StudentProfileAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StudentProfileAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    StudentProfileScreen()
                }
            }
        }
    }
}

@Composable
fun StudentProfileScreen() {
    // State to track like count
    var likeCount by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Header
        Text(
            text = "Student Profile",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.padding(top = 16.dp, bottom = 32.dp)
        )

        // Profile Picture Placeholder
        Box(
            modifier = Modifier
                .size(120.dp)
                .clip(CircleShape)
                .background(MaterialTheme.colorScheme.primaryContainer),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "👨‍🎓",
                fontSize = 60.sp
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Student Name
        Text(
            text = "Gagandeep singh",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Student ID
        Text(
            text = "Student ID: 0220694",
            fontSize = 16.sp,
            color = Color.Gray
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Info Card
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                InfoRow(label = "Program", value = "Mobile App Development")
                Spacer(modifier = Modifier.height(12.dp))
                InfoRow(label = "Course", value = "DGL 114")
                Spacer(modifier = Modifier.height(12.dp))
                InfoRow(label = "Semester", value = "Winter 2026")
                Spacer(modifier = Modifier.height(12.dp))
                InfoRow(label = "Year", value = "Second Year")
            }
        }

        Spacer(modifier = Modifier.height(32.dp))

        // Like Counter
        Text(
            text = "Likes: $likeCount",
            fontSize = 20.sp,
            fontWeight = FontWeight.Medium
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Interactive Buttons
        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Button(
                onClick = { likeCount++ },
                modifier = Modifier.weight(1f)
            ) {
                Text(text = "👍 Like")
            }

            OutlinedButton(
                onClick = { likeCount = 0 },
                modifier = Modifier.weight(1f)
            ) {
                Text(text = "🔄 Reset")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Additional Info Button
        Button(
            onClick = { /* Action here */ },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.secondary
            )
        ) {
            Text(text = "View Course Details")
        }
    }
}

@Composable
fun InfoRow(label: String, value: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = label,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary
        )
        Text(
            text = value,
            color = Color.DarkGray
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun StudentProfilePreview() {
    StudentProfileAppTheme {
        StudentProfileScreen()
    }
}