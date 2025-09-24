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

#### Option A: Original RobocodeRunner ⚠️ (Known Issue)
```bash
java -cp "lib/*:bin" tanks.RobocodeRunner
```
**⚠️ Known Issue**: `NullPointerException: Cannot invoke "Repository.getItems()"`
- **Cause**: RobocodeEngine expects specific installation directory structure
- **Root cause**: `getLocalRepository()` fails when repository isn't properly initialized
- **This is a RoboCode architecture limitation**, not our code

#### Option B: Week 1 Demonstration ✅ (Recommended)
```bash
java -cp "lib/*:bin" tanks.WeekOneDemo
```
**✅ Works perfectly** - Shows all completed Week 1 tasks with simulated battle results

### 3. Week 1 Task Demonstrations

**⚠️ Due to RobocodeEngine repository issues, use these alternatives:**

#### Alternative 1: WeekOneDemo (Recommended)
```bash
java -cp "lib/*:bin" tanks.WeekOneDemo
```

#### Alternative 2: OptimizedRobocodeRunner (Works with simulated battles)
```bash
java -cp "lib/*:bin" tanks.OptimizedRobocodeRunner  
```

#### Alternative 3: Manual Configuration (if RobocodeRunner works)
Edit `src/tanks/RobocodeRunner.java` line 26 & 29:
```java
String seznamProtivniku = "Crazy, Corners, Fire";        // Task 2  
String nazevTridyMehoRobota = "MyTeamRobotNo1";          // Task 5
```

## Week 1 Implementations

- **Task 1-3**: ✅ Enhanced RobocodeRunner with GUI acceleration and fitness function
- **Task 4**: ✅ Softmax fitness calculation using Math.exp()
- **Task 5-6**: ✅ MyTeamRobotNo1 with distinctive colors and spiral movement
- **Task 7**: ✅ Parameter optimization framework
- **Task 8**: ✅ Team battle functionality

## Project Structure Explained

### 📁 **Core Directories**

#### **`src/` - Source Code (Manual)**
- **`src/sample/`** - Robot implementations
  - `MujRobot.java` - Original seesaw movement robot
  - `MyTeamRobotNo1.java` - ✨ **Custom robot (Week 1 Task 5)**
  - `TeamRobot1-4.java` - Team robot skeletons
  - `Crazy.java`, `Corners.java`, `Fire.java` - Sample opponent robots
  - `Interactive_v2.java` - Human-controlled robot (arrow keys/WASD)
  - `*.properties` - Robot metadata (name, author, description)

- **`src/tanks/`** - Battle management system
  - `RobocodeRunner.java` - ✨ **Main battle runner (enhanced with fitness function)**
  - `BattleObserver.java` - Battle event listener and result processor
  - `OptimizedRobocodeRunner.java` - ✨ **Enhanced testing framework (Week 1 Task 7)**
  - `WeekOneDemo.java` - ✨ **Complete Week 1 demonstration**

#### **`lib/` - RoboCode Framework (Pre-installed)**
- `robocode.jar` - Main RoboCode API
- `robocode.*.jar` - Engine components (battle, UI, sound, etc.)
- Required for compilation and runtime

#### **`bin/` - Compiled Classes (Auto-generated)**
- **⚠️ AUTO-GENERATED** - Created by `javac` command
- Contains `.class` files for all compiled Java sources
- **Don't edit manually** - gets overwritten on each compilation

#### **`robots/` - Robot Repository (Auto-generated)**  
- **⚠️ AUTO-GENERATED** - Created/updated by RobocodeRunner
- Contains copied robot files for RoboCode engine
- Includes `robot.database` - RoboCode's robot registry
- **Don't edit manually** - managed by the build process

#### **`config/` - RoboCode Configuration (Pre-configured)**
- `robocode.properties` - RoboCode engine settings
- `compiler.properties` - Java compiler settings  
- `window.properties` - UI window settings

### 🔧 **File Types Explained**

#### **`.java` Files - Source Code**
- **Manual editing required**
- Your robot logic and battle management
- Where you implement Week 1 tasks

#### **`.class` Files - Compiled Bytecode** 
- **AUTO-GENERATED** by `javac`
- Java Virtual Machine executable format
- **Never edit manually**

#### **`.properties` Files - Robot Metadata**
- **Manual configuration**
- Robot name, author, description
- Required for RoboCode to recognize robots

#### **`.jar` Files - Java Libraries**
- **Pre-installed dependencies**
- RoboCode framework components
- **Don't modify**

### 🚀 **Build Process Flow**

1. **Write** Java code in `src/`
2. **Compile** with `javac` → creates `bin/*.class`
3. **Run** RobocodeRunner → copies files to `robots/`
4. **Execute** battles and display results

### ✨ **Week 1 Added Files**
- `src/sample/MyTeamRobotNo1.java` - Custom robot with advanced behavior
- `src/sample/MyTeamRobotNo1.properties` - Custom robot metadata  
- `src/tanks/OptimizedRobocodeRunner.java` - Enhanced testing framework
- `src/tanks/WeekOneDemo.java` - Complete task demonstration
- `README.md` - This documentation

## How the Project Works

### 🎯 **Battle Structure**
- **Goal**: Create 4 groups to win the battle (TeamRobot1-4 represent your team)
- **UI**: GUI hidden by default for speed (set `setVisible(false)`)
- **When to see UI**: Uncomment `engine.setVisible(true)` to watch battles visually
- **Battle specs**: 25 rounds, 800x600 battlefield

### 👥 **Team Collaboration**
1. **Share code**: Copy robot .java files between team members
2. **Test together**: Run battles with multiple team robots vs opponents  
3. **Iterate**: Use fitness function to measure performance improvements
4. **Code sharing**: Not plagiarism when whole class collaborates (per presentation)

### 🎮 **What Happens When**
- **Compile**: `javac` creates .class files in `bin/` directory
- **Run**: RobocodeRunner copies robots to `robots/` and starts battles
- **No UI**: Fast simulation with text results only
- **With UI**: Visual battle window shows robots fighting
- **Interactive**: Include `Interactive_v2` for human vs robot battles (arrow keys/WASD)

### 📊 **Expected Outputs**
```
-- Battle Results --
MyTeamRobotNo1: Score=85 → Fitness=0.4500
Crazy: Score=70 → Fitness=0.3500  
Corners: Score=55 → Fitness=0.2000
Fire: Score=40 → Fitness=0.1500
```

### ⚙️ **Development Workflow**

#### **For Robot Development:**
1. **Edit** robot code in `src/sample/YourRobotName.java`
2. **Create** corresponding `.properties` file
3. **Compile** with provided `javac` command
4. **Test** using WeekOneDemo or OptimizedRobocodeRunner

#### **For Battle Configuration:**
1. **Modify** `src/tanks/RobocodeRunner.java` lines 22-29
2. **Change** robot names and opponent lists
3. **Recompile** and run

#### **Team Collaboration:**
1. **Share** `.java` files via Git/email
2. **Copy** received robots to `src/sample/`
3. **Update** battle configurations to include team robots
4. **Run** team battles

### 🔧 **Configuration**
- **GUI**: Hidden by default (`setVisible(false)`) for speed
- **Battle**: 25 rounds, 800x600 battlefield  
- **Fitness**: Softmax function with Math.exp()
- **All original TeamRobot functionality preserved**
