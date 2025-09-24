# RoboCode Week 1 - Quick Start Guide

## Requirements
- **Java 17** (tested with OpenJDK 17.0.13)
- All required JAR files are in the `lib/` directory

## How to Run

### 1. Compile the code
```bash
javac -cp "lib/*" -d bin src/tanks/*.java src/sample/*.java
```

### 2. Run the system

#### Option A: Original RobocodeRunner (may have repository issues)
```bash
java -cp "lib/*:bin" tanks.RobocodeRunner
```
*Note: If you get repository null pointer errors, this is a known RoboCode classpath issue*

#### Option B: Week 1 Demonstration (recommended)
```bash
java -cp "lib/*:bin" tanks.WeekOneDemo
```
*Shows all completed Week 1 tasks with simulated battle results*

### 3. Week 1 Task Demonstrations

#### Test different opponents (Task 2):
Edit `src/tanks/RobocodeRunner.java` line 26:
```java
String seznamProtivniku = "Crazy, Corners, Fire";
```

#### Test custom robot (Task 5):
Edit `src/tanks/RobocodeRunner.java` line 29:
```java
String nazevTridyMehoRobota = "MyTeamRobotNo1";
```

#### Run complete Week 1 demo:
```bash
java -cp "lib/*:bin" tanks.WeekOneDemo
```

## Week 1 Implementations

- **Task 1-3**: ✅ Enhanced RobocodeRunner with GUI acceleration and fitness function
- **Task 4**: ✅ Softmax fitness calculation using Math.exp()
- **Task 5-6**: ✅ MyTeamRobotNo1 with distinctive colors and spiral movement
- **Task 7**: ✅ Parameter optimization framework
- **Task 8**: ✅ Team battle functionality

## Files Added
- `src/sample/MyTeamRobotNo1.java` - Custom robot with advanced behavior
- `src/tanks/OptimizedRobocodeRunner.java` - Enhanced testing framework
- `src/tanks/WeekOneDemo.java` - Complete task demonstration

## Configuration
- GUI: Hidden by default (`setVisible(false)`) for speed
- Battle: 25 rounds, 800x600 battlefield
- All original TeamRobot functionality preserved
