# Team 1675 Style Guide
## Naming
### General
- **Pascal case** is a string of words with no spaces where every word starts with a capital letter (ex. ThisIsPascalCase).
- **Camel case** is a string of words with no spaces where every word starts with a capital letter except the first (ex. thisIsCamelCase).
- Acronyms should be treated as one word in Pascal case or camel case. (ex. urlIdentifier, XmlHttpRequest).
- Names should be descriptive. In general, someone who understands the overall system should be able to figure out what a given variable, method, or class is for by the name alone.
- Don't use acronyms or nicknames that the team hasn't decided upon (ex. don't decide some part of the robot is named the "whammy bar" if the team hasn't come to a concensus). Keeping a somewhat common nomenclature is important.
- Try to be as succinct as possible while still relating an entire idea (ex. turnLeft, not turnTheRobotLeft).

### Packages
- Package names should always be in all lower case.
 - Good: org.usfirst.frc.team1675.robot.commands
 - Bad: org.usfirst.frc.team1675.OI
- Our root package is org.usfirst.frc.team1675 . Classes should be logically organized in subpackages of org.usfirst.frc.team1675 .

### Classes
- Class names should always be in Pascal case.
 - Good: DriveMotor
 - Bad: driveMotor, DrIvEMoToR
- Class names generally should be nouns or noun phrases. They represent an object.
 - Good: DriveMotor, TurnLeftCommand
 - Bad: GoForward, ShootBall

### Methods
- Method names should always be in camel case.
 - Good: setSpeed
 - Bad: SetSpeed, SETspeed
- Method names should generally be verbs or verb phrases. They represent an action being done.
 - Good: turnLeft, shootBall
 - Bad: secondBall, fourMotors

### Variables
- Variable names should always be in camel case unless they are constants.
- Variable names should describe the value being stored. Don't use acronyms unless they are common acronyms.
 - Good: joystickRawX, scaledMagnitude
 - Bad: temp, jrx

## Constants
- Any value that is used that doesn't change is called a constant. If there's a raw number present in a line of code, it is a constant. Defining constants in common places makes for easier fixing and tweaking of values.
- Constants that belong to a specific class should be declared as static final variables, and NAMED_LIKE_THIS (all caps, words separated by underscores).
- Constants that describe facts about the robot in general (like wiring data) belong in the RobotMap <make this a link to the robot map source file>

## Formatting
- At this time, we will generally follow the default formatting that is generated/fixed by Eclipse when using the formatting functionality.
- General rules:
 - Java-style braces (left brace on same line as opening statement)
 - Operators and keywords are padded by whitespace. The insides of pairs of parentheses, braces, or brackets are not padded.
