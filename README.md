# 🎮 Brick Breaker PRO

A feature-rich Java Swing-based Brick Breaker game featuring 20 handcrafted levels, Endless Mode, Power-Ups, Multiple Ball Types, User Profiles, Progress Saving, and a Leaderboard System.

---

## 🚀 Features

### 🎯 Core Gameplay
- Classic Brick Breaker mechanics
- Smooth paddle and ball movement
- Mouse and keyboard controls
- Accurate collision detection
- Progressive difficulty scaling

### 🏆 20 Unique Levels
- Handcrafted level designs
- Increasing difficulty
- Different brick formations
- Special obstacle layouts
- Automatic level unlocking

### ♾️ Endless Mode
- Infinite gameplay
- Randomly generated brick patterns
- Bricks gradually move downward
- Survival challenge mode

### ⚡ Power-Ups
- 🟢 Extend Paddle
- 🔵 Extra Ball
- 🟣 Slow Motion

### 🧱 Special Bricks
| Brick Type | Description |
|------------|-------------|
| Normal Brick | Breaks in 1 hit |
| Reinforced Brick | Requires 2 hits |
| Steel Brick | Requires 3 hits |
| Gold Brick | Indestructible |

### 👤 User Management
- Multiple player profiles
- Username-based login
- Progress saving
- Automatic loading of saved data

### 📊 Leaderboard System
- Tracks top players
- Stores progress across sessions
- Displays highest completed levels

---

## 🛠️ Technologies Used

- Java
- Java Swing
- Java AWT
- Object-Oriented Programming (OOP)
- Event-Driven Programming
- File Handling (CSV Storage)

---

## 📂 Project Structure

```text
BrickBreakerPRO/
│
├── Main.java
├── MenuPanel.java
├── GamePanel.java
│
├── Ball.java
├── CircleBall.java
├── SquareBall.java
│
├── Brick.java
├── LevelGenerator.java
│
├── PowerUp.java
├── SaveManager.java
│
└── game_data.csv
```

---

## 🎮 Controls

| Key | Action |
|------|---------|
| Mouse | Move Paddle |
| ← | Move Left |
| → | Move Right |
| P | Pause Game |
| SPACE | Resume / Next Level |
| M | Return to Menu |
| ESC | Return to Menu |

---

## 🚀 Installation & Running

### Prerequisites
- Java JDK 8 or higher

Verify installation:

```bash
java -version
javac -version
```

### Compile

```bash
javac *.java
```

### Run

```bash
java Main
```

---

## 🎯 Game Modes

### Level Mode
- Complete levels sequentially
- Unlock new levels
- Progress is automatically saved

### Endless Mode
- Infinite gameplay
- Random brick generation
- Bricks continuously descend
- Survival-based scoring

---

## 💾 Save System

Player progress is stored in:

```text
game_data.csv
```

Saved data includes:
- Username
- Unlocked levels
- Player progression
- Leaderboard information

---

## 🏗️ OOP Concepts Used

### Abstraction
```java
abstract class Ball
```

### Inheritance
```java
CircleBall extends Ball
SquareBall extends Ball
```

### Polymorphism
```java
Ball ball = new CircleBall(...);
```

### Encapsulation
Game functionality is separated into dedicated classes:
- Ball
- Brick
- PowerUp
- SaveManager
- LevelGenerator
- GamePanel

---


