# Student Profile App - First Android Compose Application

## Overview
A simple Android app demonstrating basic Jetpack Compose concepts including layouts, state management, and interactivity.

---

## Step 1: Create New Android Studio Project

1. Open Android Studio
2. Click "New Project"
3. Select "Empty Activity" (Compose)
4. Name: `StudentProfileApp`
5. Package name: `com.example.studentprofile`
6. Minimum SDK: API 24 (Android 7.0)
7. Click "Finish"

---

## Step 2: MainActivity.kt

Replace the content of `MainActivity.kt` with:

```kotlin
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
            text = "John Doe",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
        
        Spacer(modifier = Modifier.height(8.dp))
        
        // Student ID
        Text(
            text = "Student ID: 2024001",
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
                InfoRow(label = "Year", value = "First Year")
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
```

---

## Step 3: Run the App

1. Click the "Run" button (green play icon) or press Shift+F10
2. Select your emulator or connected device
3. Wait for the app to build and install

---

## Key Concepts Demonstrated

### 1. **Composable Functions**
```kotlin
@Composable
fun StudentProfileScreen() {
    // UI code here
}
```
- Functions marked with `@Composable` annotation
- These functions describe UI elements
- Can be previewed without running the app

### 2. **State Management**
```kotlin
var likeCount by remember { mutableStateOf(0) }
```
- `remember` keeps the state across recompositions
- `mutableStateOf` creates observable state
- When state changes, UI automatically updates

### 3. **Layout Composables**
- **Column**: Arranges children vertically
- **Row**: Arranges children horizontally
- **Box**: Stacks children on top of each other
- **Spacer**: Adds empty space

### 4. **Modifiers**
```kotlin
modifier = Modifier
    .fillMaxSize()
    .padding(16.dp)
```
- Chain modifiers to customize composables
- Control size, padding, background, etc.

### 5. **Material Design 3**
- Uses `MaterialTheme` for consistent styling
- `Button`, `Card`, `Text` follow Material Design
- Automatic dark mode support

### 6. **Preview**
```kotlin
@Preview(showBackground = true, showSystemUi = true)
```
- See UI without running the app
- Speeds up development
- Can create multiple previews

---

## Teaching Points to Emphasize

### For Students:

1. **Everything is a Function**
   - Unlike XML layouts, Compose uses Kotlin functions
   - Functions can take parameters and return UI

2. **Declarative UI**
   - Describe WHAT you want, not HOW to build it
   - UI automatically updates when state changes

3. **State Hoisting**
   - The like counter demonstrates state management
   - State flows down, events flow up

4. **Reusability**
   - `InfoRow` is reused multiple times
   - Create composable functions for repeated UI elements

5. **Preview is Your Friend**
   - Use `@Preview` to see changes instantly
   - No need to run the app for every small change

---

## Live Coding Tips for Class

### Step-by-step Demonstration:

1. **Start Simple**
   ```kotlin
   @Composable
   fun Greeting() {
       Text(text = "Hello DGL 114!")
   }
   ```

2. **Add Styling**
   ```kotlin
   Text(
       text = "Hello DGL 114!",
       fontSize = 24.sp,
       fontWeight = FontWeight.Bold
   )
   ```

3. **Add Layout**
   ```kotlin
   Column(
       modifier = Modifier.padding(16.dp)
   ) {
       Text(text = "Hello")
       Text(text = "DGL 114!")
   }
   ```

4. **Add Interactivity**
   ```kotlin
   var count by remember { mutableStateOf(0) }
   Button(onClick = { count++ }) {
       Text("Clicked $count times")
   }
   ```

---

## Extensions for Advanced Students

### Challenge 1: Add More State
```kotlin
var name by remember { mutableStateOf("John Doe") }
var studentId by remember { mutableStateOf("2024001") }
```

### Challenge 2: Add TextField
```kotlin
OutlinedTextField(
    value = name,
    onValueChange = { name = it },
    label = { Text("Enter Name") }
)
```

### Challenge 3: Add Navigation
- Show how to navigate to another screen
- Introduce NavHost and NavController

### Challenge 4: Change Theme Colors
- Modify `ui/theme/Color.kt`
- Show how Material Theme propagates

---

## Common Issues & Solutions

### Issue 1: Preview Not Showing
**Solution**: Make sure the preview function has no parameters and is annotated with `@Preview`

### Issue 2: State Not Updating
**Solution**: Ensure you're using `remember { mutableStateOf() }` and the `by` keyword

### Issue 3: Import Errors
**Solution**: Let Android Studio auto-import, or manually add:
```kotlin
import androidx.compose.runtime.*
```

### Issue 4: App Crashes on Run
**Solution**: Check minimum SDK version is set correctly (API 24+)

---

## Homework Assignment Ideas

1. **Personalize the App**
   - Change name and student ID to their own
   - Modify colors and text sizes

2. **Add Features**
   - Add a dislike button
   - Add more info fields (email, phone)
   - Change the emoji based on like count

3. **Experiment with Layouts**
   - Rearrange elements
   - Try different modifier combinations
   - Add images or icons

4. **State Practice**
   - Add a toggle switch for dark mode
   - Create a counter that increments by different values

---

## Additional Resources for Students

- **[Official Compose Tutorial](developer.android.com/jetpack/compose/tutorial)** 
- **[Compose Pathway](developer.android.com/courses/pathways/compose)**
- **[Material Design 3](m3.material.io)** 
- **[Compose Documentation](developer.android.com/jetpack/compose)** 

---
