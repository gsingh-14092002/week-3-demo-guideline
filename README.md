# Student Profile App - First Android Compose Application

## Overview
A simple Android app demonstrating basic Jetpack Compose concepts including layouts, state management, and interactivity.

---

## STEP 0: Create New Android Studio Project

1. Open Android Studio
2. Click "New Project"
3. Select "Empty Activity" (Compose)
4. Name: `StudentProfileApp`
5. Package name: `com.example.studentprofile`
6. Minimum SDK: API 24 (Android 7.0)
7. Click "Finish"

---

## STEP 1: Basic Setup - Hello World

**Concept**: Understanding the basic structure of a Compose app

```kotlin
package com.example.studentprofileapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.studentprofileapp.ui.theme.StudentProfileAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StudentProfileAppTheme {
                Surface {
                    StudentProfileScreen()
                }
            }
        }
    }
}

@Composable
fun StudentProfileScreen() {
    Text(text = "Hello DGL 114!")
}

@Preview(showBackground = true)
@Composable
fun StudentProfilePreview() {
    StudentProfileAppTheme {
        StudentProfileScreen()
    }
}
```

### 🎯 Explain to Students:

**`MainActivity`**: 
- Entry point of your Android app
- `onCreate()` is called when app starts
- `setContent { }` replaces the old XML layout approach

**`@Composable`**: 
- Special annotation that marks a function as UI-building
- Composable functions can call other composable functions
- They describe WHAT the UI should look like

**`Text`**: 
- Basic composable for displaying text
- Takes a `text` parameter

**`@Preview`**: 
- Lets you see UI without running the app
- Click the split/design tab to see preview
- Super useful for rapid development!

**🏃 RUN IT**: Students should see "Hello DGL 114!" on screen

---


## STEP 2: Styling Text

**Concept**: Using modifiers and text properties

```kotlin
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun StudentProfileScreen() {
    Text(
        text = "Hello DGL 114!",
        fontSize = 28.sp,
        fontWeight = FontWeight.Bold,
        color = MaterialTheme.colorScheme.primary
    )
}
```

### 🎯 Explain to Students:

**`fontSize = 28.sp`**: 
- Size in Scale-independent Pixels (adjusts for user's font size settings)
- Use `.sp` for text, `.dp` for everything else

**`fontWeight = FontWeight.Bold`**: 
- Makes text bold
- Other options: `FontWeight.Light`, `FontWeight.Normal`, etc.

**`color = MaterialTheme.colorScheme.primary`**: 
- Uses theme colors (automatically supports dark mode)
- Can also use `Color.Red`, `Color.Blue`, etc.

**🏃 RUN IT**: Text is now bigger, bold, and colored

---

## STEP 3: Adding Padding with Modifiers

**Concept**: Introduction to Modifiers

```kotlin
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun StudentProfileScreen() {
    Text(
        text = "Hello DGL 114!",
        fontSize = 28.sp,
        fontWeight = FontWeight.Bold,
        color = MaterialTheme.colorScheme.primary,
        modifier = Modifier.padding(16.dp)
    )
}
```

### 🎯 Explain to Students:

**`Modifier`**:

- Changes how a composable looks or behaves
- Think of it as CSS for Compose
- Can chain multiple modifiers together

**`padding(16.dp)`**:

- Adds space around the text
- `dp` = Density-independent Pixels (scales for different screen sizes)
- 16.dp is a common spacing value

**🏃 RUN IT**: Text now has space around it

---

## STEP 4: Vertical Layout with Column

**Concept**: Arranging multiple elements vertically

```kotlin
import androidx.compose.foundation.layout.*

@Composable
fun StudentProfileScreen() {
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Text(
            text = "Hello DGL 114!",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary
        )

        Text(
            text = "Welcome to Android Development",
            fontSize = 16.sp
        )

        Text(
            text = "Let's build amazing apps!",
            fontSize = 16.sp
        )
    }
}
```

### 🎯 Explain to Students:

**`Column`**:

- Layout that stacks children vertically (top to bottom)
- Like a vertical container
- Everything inside appears one below the other

**Why Column?**:

- Most screens need vertical scrolling
- Natural reading direction
- Essential for forms, lists, and most UIs

**🏃 RUN IT**: Three text lines stacked vertically

---

## STEP 5: Adding Space Between Elements

**Concept**: Using Spacer for spacing

```kotlin
@Composable
fun StudentProfileScreen() {
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Text(
            text = "Hello DGL 114!",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Welcome to Android Development",
            fontSize = 16.sp
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Let's build amazing apps!",
            fontSize = 16.sp
        )
    }
}
```

### 🎯 Explain to Students:

**`Spacer`**:

- Invisible element that takes up space
- `height()` for vertical space in Column
- `width()` for horizontal space in Row

**Why not just padding?**:

- Spacer gives you precise control between elements
- Padding adds space around an element
- Different tools for different needs

**🏃 RUN IT**: Notice better spacing between text lines

---

## STEP 6: Centering Content

**Concept**: Alignment in layouts

```kotlin
import androidx.compose.ui.Alignment

@Composable
fun StudentProfileScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text = "Hello DGL 114!",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Welcome to Android Development",
            fontSize = 16.sp
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Let's build amazing apps!",
            fontSize = 16.sp
        )
    }
}
```

### 🎯 Explain to Students:

**`fillMaxSize()`**:

- Column takes up entire screen
- Without this, Column only takes space it needs

**`horizontalAlignment = Alignment.CenterHorizontally`**:

- Centers all children horizontally
- Other options: `Start`, `End`

**Modifier chaining**:

- Order matters!
- `fillMaxSize().padding()` vs `padding().fillMaxSize()` give different results
- Generally: size first, then padding

**🏃 RUN IT**: Content is now centered on screen

---

## STEP 7: Adding a Profile Picture (Using Box)

**Concept**: Box layout and shapes

```kotlin
import androidx.compose.foundation.background
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color

@Composable
fun StudentProfileScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(32.dp))

        // Profile Picture
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

        Text(
            text = "John Doe",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Welcome to Android Development",
            fontSize = 16.sp
        )
    }
}
```

### 🎯 Explain to Students:

**`Box`**:

- Layout that stacks children on top of each other
- Like layers in Photoshop
- Great for overlapping elements

**`size(120.dp)`**:

- Sets both width and height
- Square shape

**`clip(CircleShape)`**:

- Cuts the box into a circle
- Other shapes: `RoundedCornerShape(8.dp)`, `RectangleShape`

**`background()`**:

- Adds background color
- Applied after clip, so it's also circular

**`contentAlignment = Alignment.Center`**:

- Centers children inside the Box
- Centers the emoji inside the circle

**🏃 RUN IT**: See circular profile picture with emoji

---

## STEP 8: Creating an Info Card

**Concept**: Material Design Card component

```kotlin
@Composable
fun StudentProfileScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(32.dp))

        // Profile Picture
        Box(
            modifier = Modifier
                .size(120.dp)
                .clip(CircleShape)
                .background(MaterialTheme.colorScheme.primaryContainer),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "👨‍🎓", fontSize = 60.sp)
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "John Doe",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(8.dp))

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
            Column(modifier = Modifier.padding(16.dp)) {
                Text(text = "Program: Mobile App Development")
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = "Course: DGL 114")
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = "Semester: Winter 2026")
            }
        }
    }
}
```

### 🎯 Explain to Students:

**`Card`**:

- Material Design elevated surface
- Automatically has rounded corners and shadow
- Great for grouping related information

**`fillMaxWidth()`**:

- Card takes full width available
- `.padding(horizontal = 16.dp)` leaves space on sides

**`elevation`**:

- Creates shadow effect (depth)
- Higher values = higher shadow
- Makes UI feel layered and modern

**Nested Column**:

- Card contains another Column
- Columns can be nested inside other layouts
- Each layout manages its own children

**🏃 RUN IT**: See the information card with shadow

---

## STEP 9: Reusable Components

**Concept**: Creating reusable composable functions

```kotlin
@Composable
fun StudentProfileScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(32.dp))

        // Profile Picture
        Box(
            modifier = Modifier
                .size(120.dp)
                .clip(CircleShape)
                .background(MaterialTheme.colorScheme.primaryContainer),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "👨‍🎓", fontSize = 60.sp)
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "John Doe",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Student ID: 2024001",
            fontSize = 16.sp,
            color = Color.Gray
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Info Card using reusable component
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                InfoRow(label = "Program", value = "Mobile App Development")
                Spacer(modifier = Modifier.height(12.dp))
                InfoRow(label = "Course", value = "DGL 114")
                Spacer(modifier = Modifier.height(12.dp))
                InfoRow(label = "Semester", value = "Winter 2026")
            }
        }
    }
}

// Reusable component - can be used anywhere!
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
```

### 🎯 Explain to Students:

**`InfoRow` composable**:

- Custom reusable component
- Takes parameters like any function
- Can be used multiple times with different data

**`Row`**:

- Layout that arranges children horizontally (left to right)
- Like Column but sideways

**`Arrangement.SpaceBetween`**:

- Pushes first item to start, last item to end
- Creates space between items
- Other options: `SpaceEvenly`, `SpaceAround`, `Center`

**Why reusable components?**:

- Write once, use many times
- Easier to maintain
- Consistent look and feel
- Core principle of Compose!

**🏃 RUN IT**: Notice cleaner code with same result

---

## STEP 10: Adding Interactivity with State

**Concept**: State management and user interaction

```kotlin
import androidx.compose.runtime.*

@Composable
fun StudentProfileScreen() {
    // STATE - this remembers the value across recompositions
    var likeCount by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(32.dp))

        // Profile Picture
        Box(
            modifier = Modifier
                .size(120.dp)
                .clip(CircleShape)
                .background(MaterialTheme.colorScheme.primaryContainer),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "👨‍🎓", fontSize = 60.sp)
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "John Doe",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(8.dp))

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
            Column(modifier = Modifier.padding(16.dp)) {
                InfoRow(label = "Program", value = "Mobile App Development")
                Spacer(modifier = Modifier.height(12.dp))
                InfoRow(label = "Course", value = "DGL 114")
                Spacer(modifier = Modifier.height(12.dp))
                InfoRow(label = "Semester", value = "Winter 2026")
            }
        }

        Spacer(modifier = Modifier.height(32.dp))

        // Like counter display
        Text(
            text = "Likes: $likeCount",
            fontSize = 20.sp,
            fontWeight = FontWeight.Medium
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Like button
        Button(onClick = { likeCount++ }) {
            Text(text = "👍 Like")
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
```

### 🎯 Explain to Students:

**`var likeCount by remember { mutableStateOf(0) }`**:

- **`var`**: Variable that can change
- **`remember`**: Survives recomposition (when UI rebuilds)
- **`mutableStateOf(0)`**: Creates observable state starting at 0
- **`by`**: Kotlin delegation - lets us use `likeCount` directly instead of `likeCount.value`

**What is State?**:

- Data that can change over time
- When state changes, UI automatically updates
- Core concept in Compose!

**`Button`**:

- Material Design button component
- `onClick` parameter takes a lambda (code to run when clicked)
- Contains other composables (like Text)

**`likeCount++`**:

- Increments the counter
- Triggers recomposition
- UI updates automatically!

**String template `"Likes: $likeCount"`**:

- Embeds the variable value in the string
- Updates automatically when likeCount changes

**🏃 RUN IT**: Click the button and watch the counter increase!

---

## STEP 11: Multiple Buttons and Reset

**Concept**: Multiple interactive elements

```kotlin
import androidx.compose.foundation.layout.Arrangement

@Composable
fun StudentProfileScreen() {
    var likeCount by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(32.dp))

        Box(
            modifier = Modifier
                .size(120.dp)
                .clip(CircleShape)
                .background(MaterialTheme.colorScheme.primaryContainer),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "👨‍🎓", fontSize = 60.sp)
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "John Doe",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Student ID: 2024001",
            fontSize = 16.sp,
            color = Color.Gray
        )

        Spacer(modifier = Modifier.height(24.dp))

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                InfoRow(label = "Program", value = "Mobile App Development")
                Spacer(modifier = Modifier.height(12.dp))
                InfoRow(label = "Course", value = "DGL 114")
                Spacer(modifier = Modifier.height(12.dp))
                InfoRow(label = "Semester", value = "Winter 2026")
            }
        }

        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text = "Likes: $likeCount",
            fontSize = 20.sp,
            fontWeight = FontWeight.Medium
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Row of buttons
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
```

### 🎯 Explain to Students:

**`OutlinedButton`**:

- Button with outline instead of filled background
- Different visual style
- Same functionality as Button

**`Arrangement.spacedBy(16.dp)`**:

- Puts 16.dp space between Row children
- Cleaner than using Spacers

**`modifier = Modifier.weight(1f)`**:

- Makes both buttons take equal space
- `1f` means "1 fraction of available space"
- Both have weight 1f, so they split space 50/50

**Multiple state changes**:

- `likeCount++` increments
- `likeCount = 0` resets
- Same state variable, different operations

**🏃 RUN IT**: Try both buttons - Like increases, Reset sets to 0

---

## STEP 12: Final Touches - Complete App

**Concept**: Bringing it all together

```kotlin
@Composable
fun StudentProfileScreen() {
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

        // Profile Picture
        Box(
            modifier = Modifier
                .size(120.dp)
                .clip(CircleShape)
                .background(MaterialTheme.colorScheme.primaryContainer),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "👨‍🎓", fontSize = 60.sp)
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "John Doe",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(8.dp))

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
            Column(modifier = Modifier.padding(16.dp)) {
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

        // Full-width button with different color
        Button(
            onClick = { /* Can add navigation later */ },
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
        Greeting()
    }
}
```

### 🎯 Explain to Students:

**Button colors**:

- `ButtonDefaults.buttonColors()` customizes button appearance
- `containerColor` sets background color
- Uses theme colors for consistency

**`fillMaxWidth()`** on button:

- Button stretches across entire width
- Different from buttons with `weight(1f)` in a Row

**Layout hierarchy**:

- Column (main container)
  - Text (header)
  - Box (profile picture)
  - Text (name)
  - Card (info)
  - Row (buttons)
  - Button (full width)

**🏃 RUN IT**: Complete, polished student profile app!

---

## Final Codeblock
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

## Homework Practice Ideas

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
