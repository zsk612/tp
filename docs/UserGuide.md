# User Guide
By: `Team F11-1` Since: `Sept 2020` License: `MIT`

## Table of content
1. [**Introduction**](#intro)
1. [**Quick Start**](#quickstart)
1. [**Features**](#features)<br>
3.1. [Main Menu](#main-menu)<br>
&nbsp;&nbsp;&nbsp;&nbsp;3.1.1. [Viewing Help: `help`](#main-help)<br>
&nbsp;&nbsp;&nbsp;&nbsp;3.1.2. [Entering Profile Menu: `profile`](#main-profile)<br>
&nbsp;&nbsp;&nbsp;&nbsp;3.1.3. [Entering Diet Menu: `diet`](#main-diet)<br>
&nbsp;&nbsp;&nbsp;&nbsp;3.1.4. [Entering Workout Menu: `workout`](#main-workout)<br>
&nbsp;&nbsp;&nbsp;&nbsp;3.1.5.  [Ending The Schwarzenegger: `end`](#main-end)<br>
3.2. [Profile Menu](#profile-menu)<br>
&nbsp;&nbsp;&nbsp;&nbsp;3.2.1. [Viewing Help: `help`](#profile-help)<br>
&nbsp;&nbsp;&nbsp;&nbsp;3.2.2. [Adding a Profile: `add`](#profile-add)<br>
&nbsp;&nbsp;&nbsp;&nbsp;3.2.3. [Viewing a Profile: `view`](#profile-view)<br>
&nbsp;&nbsp;&nbsp;&nbsp;3.2.4. [Deleting a Profile: `delete`](#profile-delete)<br>
&nbsp;&nbsp;&nbsp;&nbsp;3.2.5. [Editing a Profile: `edit`](#profile-edit)<br>
&nbsp;&nbsp;&nbsp;&nbsp;3.2.6. [Returning to Main Menu: `end`](#profile-end)<br>
3.3. [Diet Menu](#diet-menu)<br>
&nbsp;&nbsp;&nbsp;&nbsp;3.3.1. [Viewing Help: `help`](#diet-help)<br>
&nbsp;&nbsp;&nbsp;&nbsp;3.3.2. [Starting to record diet data: `meal`](#diet-start)<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;3.3.2.1. [Viewing Help: `help`](#meal-help)<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;3.3.2.2. [Adding Food Items for the Current Meal: `add`](#meal-add)<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;3.3.2.3. [Listing Data for the Current Meal: `list`](#meal-list)<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;3.3.2.4. [Deleting Data From the Current Meal: `delete`](#meal-delete)<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;3.3.2.5. [Clearing Data From the Current Meal: `clear`](#meal-clear)<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;3.3.2.6. [Ending the Recording of Meal Data: `end`](#meal-end)<br>
&nbsp;&nbsp;&nbsp;&nbsp;3.3.3. [Listing All Past Diet Sessions: `list`](#diet-list)<br>
&nbsp;&nbsp;&nbsp;&nbsp;3.3.4. [Editing a Past Diet Session: `edit`](#diet-edit)<br>
&nbsp;&nbsp;&nbsp;&nbsp;3.3.5. [Deleting a Past Diet Session: `delete`](#diet-delete)<br>
&nbsp;&nbsp;&nbsp;&nbsp;3.3.6. [Clearing All Past Diet Sessions: `clear`](#diet-clear)<br>
&nbsp;&nbsp;&nbsp;&nbsp;3.3.7. [Returning to Main Menu: `end`](#diet-end)<br>
3.4. [Workout Menu](#workout-menu)<br>
&nbsp;&nbsp;&nbsp;&nbsp;3.4.1. [Viewing Help: `help`](#workout-help)<br>
&nbsp;&nbsp;&nbsp;&nbsp;3.4.2. [Starting a New Workout Session: `new`](#workout-start)<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;3.4.2.1. [Viewing Help: `help`](#ws-help)<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;3.4.2.2. [Adding Data for Current Workout Session: `add`](#ws-add)<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;3.4.2.3. [Listing Data for the Current Workout Session: `list`](#ws-list)<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;3.4.2.4. [Deleting Data From the Current Workout Session: `delete`](#ws-delete)<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;3.4.2.5. [Ending the Recording Data for the Current Workout Session: `end`](#ws-end)<br>
&nbsp;&nbsp;&nbsp;&nbsp;3.4.3. [Listing All Past Workout Sessions: `list`](#workout-list)<br>
&nbsp;&nbsp;&nbsp;&nbsp;3.4.4. [Editing a Workout Session: `edit`](#workout-edit)<br>
&nbsp;&nbsp;&nbsp;&nbsp;3.4.5. [Deleting a Workout Session: `delete`](#workout-delete)<br>
&nbsp;&nbsp;&nbsp;&nbsp;3.4.6. [Searching a List of Workout Session: `search`](#workout-search)<br>
&nbsp;&nbsp;&nbsp;&nbsp;3.4.7. [Clearing All Workout Sessions: `clear`](#workout-clear)<br>
&nbsp;&nbsp;&nbsp;&nbsp;3.4.8. [Returning to Main Menu: `end`](#workout-end)
1. [**Command Summary**](#command-summary)
1. [**Notes**](#notes)

## 1. <a id="intro">Introduction</a>

The Schwarzenegger is a desktop command line interface-based app for managing all your needs regarding fitness. With the built-in personal assistant, you are able to track your daily workout and diet sessions based on your profile. If you can type fast, The Schwarzenegger can help you maximise your efficiency for maintaining fitness.

## 2. <a id="quickstart">Quick Start</a>

When you first start using The Schwarzenegger, please ensure that you follow the instructions below:

1. Ensure you have Java `11` or above installed in your Computer.
1. Download the latest `duke.jar` from [here](https://github.com/AY2021S1-CS2113T-F11-1/tp/releases).
1. Copy the file to the folder you want to use as the home folder for The Schwarzenegger.
1. Open command prompt (on Windows)  or terminal (on MacOS/ Linux) and change to the directory of the folder of the application in step 3.
1. Key in `java -jar duke.jar`. If the setup is correct, you should see something like below:

    ```
         ______________________________________________________________________________
         Welcome back to Schwarzenegger!
         It seems like your profile data is corrupted!
         Please add your profile again using "add" command under Profile Menu.
         For more information on command syntax, please type "help".
         ______________________________________________________________________________
    
    Main Menu >>>>>
    ```
   
1. To use The Schwarzenegger, simply type a valid command into the terminal and press <kbd>Enter</kbd> to run the command.<br>
    Example: Typing `help` command and pressing <kbd>Enter</kbd> will show you a list of available commands in The Schwarzenegger and their descriptions.
1. Some example commands you can try:
    - `help` : Shows all commands in The Schwarzenegger and their descriptions.
    - `profile` : Directs you to Profile Menu where you can add and manage your profile.
    - `diet` : Directs you to Diet Menu where you can add and manage your diet records.
    - `workout` : Directs you to Workout Menu where you can add and manage your workout records.
1. A summary of all the supported commands in Duke can be found in [Section 4. Command Summary](#command-summary).<br>
Refer to [Section 3. Features](#features) for the detailed instructions of the various features in The Schwarzenegger.

## 3. <a id="features">Features</a> 
This section includes 4 sub-sections which will guide you through the features available in Main Menu, Profile Menu, Workout Menu and Diet Menu. In explaining the syntax, we will adhere to the following format:

***
:information_source: **Command Format**

- Words that are in `[UPPER_CASE]` are the parameters to be supplied by you.<br>
Example: in `add /n [NAME] /h [HEIGHT] /w [WEIGHT] /e [EXPECTED_WEIGHT] /c [DAILY_CALORIES_INTAKE]`, `[NAME]`, `[HEIGHT]`, `[WEIGHT]`, `[EXPECTED_WEIGHT]` and `[DAILY_CALORIES_INTAKE]` are parameters which can be used as `add /n Schwarzenegger /h 188 /w 113 /e 100 /c 2500`.
- Words that are enclosed with `<` and `>` are optional parameters. However, if all the parameters in a command are optional, you need to supply at least 1 of them.<br>
Example: in `edit </n [NAME]> </h [HEIGHT]> </w [WEIGHT]> </e [EXPECTED_WEIGHT]> </c [DAILY_CALORIES_INTAKE]>`, `</n [NAME]>`, `</h [HEIGHT]>`, `</w [WEIGHT]>`, `</e [EXPECTED_WEIGHT]>` and `</c [DAILY_CALORIES_INTAKE]>` are optional parameters which can be used as `edit /h 180`, `edit /h 180 /w 50` or `edit /h 180 /w 50 /e 55`. Since all of them are optional parameters, you need to supply at least 1 of them.
- Optional parameters with `…` after them can be used multiple times including zero times. <br>
Example: for `<TAG>...`, the following format for Search Command: `search /t <TAG>... </d [DATE]>` can be used as `search /t chest` or `search /t chest bicep`.
***

### 3.1. <a id="main-menu">Main Menu</a>
You can get access to Profile Menu, Diet Menu and Workout Menu from Main Menu.
The available commands in Main Menu are listed below:

#### 3.1.1. <a id="main-help">Viewing Help: `help`</a>
You can see a complete list of available commands under Main Menu and how to use them.

__Format:__ `help`<br>

Example: `help`<br>

Expected outcome:

```
    ______________________________________________________________________________
    profile  - profile
          Go to Profile Menu to manage your profile
    workout  - workout
          Go to Workout Menu to manage your workout records and create new workout records
    diet     - diet
          Go to Diet Menu to manage your past diet records and create new diet records
    end      - end
          Exit the program
    ______________________________________________________________________________
```


#### 3.1.2. <a id="main-profile">Entering Profile Menu: `profile`</a>
The program will direct you to the Profile Menu.

__Format:__ `profile`
  
Example: `profile`

Expected outcome:

```
    ______________________________________________________________________________
    Entering Profile Menu...
    ______________________________________________________________________________

Profile Menu >>>>>
```

#### 3.1.3. <a id="main-diet">Entering Diet Menu: `diet`</a>
The program will direct you to the Diet Menu.

__Format:__ `diet`  

Example: `diet`

Expected outcome:

#### 3.1.4. <a id="main-workout">Entering Workout Menu: `workout`</a>
The program will direct you to the Workout Menu.

__Format:__ `workout`  

Example: `workout`

Expected outcome:

#### 3.1.5. <a id="main-end">Ending The Schwarzenegger: `end`</a>
You enter this command when you want to terminate The Schwarzenegger.

__Format:__ `end`  

Example: `end`

Expected outcome:

```
    ______________________________________________________________________________
    Bye, you have exited the Schwarzenegger.
    ______________________________________________________________________________
```

### 3.2. <a id="profile-menu">Profile Menu</a>
Profile Menu manages your profile including your name, physique data and expected daily calories intake. 

#### 3.2.1. <a id="profile-help">Viewing Help: `help`</a>
You can see a complete list of available commands under Profile Menu and how to use them.

__Format:__ `help`  

Example: `help`

Expected outcome:

```
    ______________________________________________________________________________
    add      - add /n [NAME] /h [HEIGHT] /w [WEIGHT] /e [EXPECTED_WEIGHT] /c [DAILY_CALORIES_INTAKE]
          Add your new profile
    view     - view
          View your profile
    edit     - edit </n [NAME]> </h [HEIGHT]> </w [WEIGHT]> </e [EXPECTED_WEIGHT]> </c [DAILY_CALORIES_INTAKE]>
          Edit your existing profile. You may edit only 1 field or all fields
    delete   - delete
          Delete your existing profile
    ______________________________________________________________________________
```

#### 3.2.2. <a id="profile-add">Adding a Profile: `add`</a>
You can add your profile for the most customized experience in The Schwarzenegger. Your height should in centimeters and your input weight should be in kilograms.

__Format:__ `add /n [NAME] /h [HEIGHT] /w [WEIGHT] /e [EXPECTED_WEIGHT] /c [EXPECTED_DAILY_CALORIES_INTAKE]`  

Example: `add /n Schwarzenegger /h 188 /w 113 /e 100 /c 2500`

This command adds a profile with the name Schwarzenegger, height 188 cm, weight 113 kg, expected weight 100 kg and expected daily intake of 2500 calories.

Expected outcome:

```
    ______________________________________________________________________________
    Got it. Here's a confirmation of your profile:
        Name: Schwarzenegger
        Height: 188 cm
        Weight: 113.0 kg
        Expected Weight: 100.0 kg
        Expected daily calories intake: 2500.0 calories
        Your BMI: 32.0 (Obesity Class 1)
    ______________________________________________________________________________
```

#### 3.2.3. <a id="profile-view">Viewing a Profile: `view`</a>
You can view your profile recorded in the program. The Schwarzenegger will also show your current BMI and give you suggestions on an expected weight for better fitness if it detects your current expectation is not appropriate.

__Format:__ `view`  

Example: `view`

Expected outcome:

```
    ______________________________________________________________________________
    Here's your profile:
        Name: Schwarzenegger
        Height: 188 cm
        Weight: 113.0 kg
        Expected Weight: 100.0 kg
        Expected daily calories intake: 2500.0 calories
        Your BMI: 32.0 (Obesity Class 1)
    ______________________________________________________________________________
```

#### 3.2.4. <a id="profile-delete">Deleting a Profile: `delete`</a>
You can delete your profile from the program. The program will ask for your confirmation, and it will only delete after you type in exactly "YES".

__Format:__ `delete`  

Example: `delete`

Expected outcome:
- If you type "YES" for confirmation:

```
    ______________________________________________________________________________
    Alright! I've deleted your profile.
    ______________________________________________________________________________
```

- If you do not type "YES" for confirmation:

```
    ______________________________________________________________________________
    You have aborted the action!
    ______________________________________________________________________________
```

#### 3.2.5. <a id="profile-edit">Editing a Profile: `edit`</a>
You can edit the profile after adding to the program.

__Format:__ `edit </n [NAME]> </h [HEIGHT]> </w [WEIGHT]> </e [EXPECTED_WEIGHT]> </c [DAILY_CALORIES_INTAKE]>`  

Example: <br>
- `edit /h 180`<br>
This command edits your current height to 180 centimeters.<br>
Expected outcome:<br>
    ```
        ______________________________________________________________________________
        Yay! Your profile is edited successfully. Here's your new profile:
            Name: Schwarzenegger
            Height: 180 cm
            Weight: 113.0 kg
            Expected Weight: 100.0 kg
            Expected daily calories intake: 2500.0 calories
            Your BMI: 32.0 (Obesity Class 1)
        ______________________________________________________________________________`
    ```
- `edit /h 180 /w 50`<br>
This command edits your current height to 180 centimeters and current weight to 50 kilograms.<br>
Expected outcome:<br>
    ```
         ______________________________________________________________________________
         Yay! Your profile is edited successfully. Here's your new profile:
                Name: Schwarzenegger
                Height: 180 cm
                Weight: 50.0 kg
                Expected Weight: 100.0 kg
                Expected daily calories intake: 2500.0 calories
                Your BMI: 15.4 (Underweight)
         ______________________________________________________________________________
    ```
  
- `edit /h 180 /w 50 /e 55`<br>
This command edits your current height to 180 centimeters, current weight to 50 kilograms and expected weight to 55 kilograms.<br>
Expected outcome:<br>
    ```
         ______________________________________________________________________________
         Yay! Your profile is edited successfully. Here's your new profile:
                Name: Schwarzenegger
                Height: 180 cm
                Weight: 50.0 kg
                Expected Weight: 55.0 kg
                Expected daily calories intake: 2500.0 calories
                Your BMI: 15.4 (Underweight)
         ______________________________________________________________________________
    ```

|:bulb:| You may edit from 1 field to all fields in your profile. |
|------|:-----------|              
    
#### 3.2.6. <a id="profile-end">Returning to Main Menu: `end`</a>
You use this command to switch back to the Main Menu.

__Format:__ `end`  

Example: `end`

Expected outcome:

```
    ______________________________________________________________________________
    Returning to Main Menu...
    ______________________________________________________________________________
```

### 3.3. <a id="diet-menu">Diet Menu</a>

### 3.3.1. <a id="diet-help">Viewing Help: `help`</a>
You can see a complete list of available commands under Diet Menu and how to use them.

__Format:__ `help`
Example: `help`
 
### 3.3.2. <a id="diet-start">Starting to Record Diet Data: `meal`</a>
This command creates a new meal session.
You will be directed immediately into the meal session.

The date and tag can be added on creation with "/d" for date and "/t" for meal type.

__Format:__ `meal /d [date] /t [type]`
 
Example: `meal /d 2020-08-05 /t lunch`

Situation | Example |  Outcome
----------|--------|------------------
Create a meal session | `meal`| a meal session of type unspecified with today's date will be created
Create a meal session with date and type| `meal /d 2020-05-04 breakfast`| A meal session with date 2020-05-04 and type breakfast will be created

#### 3.3.2.1. <a id="meal-help">Viewing Help: `help`</a>
You can see a complete list of available commands under Diet Session and how to use them.

__Format:__ `help` 

Example: `help`
#### 3.3.2.2. <a id="meal-add">Adding Food Items for the Current Meal: `add`</a>
This command adds a food item into the current meal session

__Format:__ `add [food name] /c [amount of calories]` 

Example: `add chicken nuggets /c 120`

#### 3.3.2.3. <a id="meal-list">Listing Data for the Current Meal: `list`</a>
Lists all the added dishes for the current meal, with a numbered sequence according to sequence entered.

__Format:__ `list` 

Example: `list`

#### 3.3.2.4. <a id="meal-delete">Deleting Data From the Current Meal: `delete`</a>
Deletes the dish according to the ID in the current meal session list.

__Format:__ `delete [dish ID]`

Example: `delete 3`
 
#### 3.3.2.5. <a id="meal-clear">Clearing Data From the Current Meal: `clear`</a>
Clears all the dishes in the current meal list.

__Format:__ `clear` 

Example: `clear`

#### 3.3.2.6. <a id="meal-end">Ending the Recording of Meal Data: `end`</a>
Ends the current meal session and saves the data.

__Format:__ `end` 

Example: `end`

### 3.3.3. <a id="diet-list">Listing All Past Diet Sessions: `list`</a>
Obtains a list of information about past diet sessions together with their numbered index.

__Format:__ `list`

Example: `list`

### 3.3.4. <a id="diet-edit">Editing a Past Diet Session: `edit`</a>
Edits a previous meal session based on a numbered index that can be found in the list.

__Format:__ `edit [index number]`

Example: `edit 3` 

### 3.3.5. <a id="diet-delete">Deleting a Past Diet Session: `delete`</a>
Deletes a previous meal session based on a numbered index that can be found in the list.

__Format:__ `delete [index number]`

Example: `delete 3`
 
### 3.3.6. <a id="diet-clear">Clearing All Past Diet Sessions: `clear`</a>
Deletes all previous diet sessions.

__Format:__ `clear`

Example: `clear`

### 3.3.7. <a id="diet-end">Returning to Main Menu: `end`</a>
Ends the current meal session and saves the data.

__Format:__ `end` 
Exits the diet manager and returns you back to the main menu.

__Format:__ `end`

Example: `end`

### 3.4. <a id="workout-menu">Workout Menu</a>

### 3.4.1. <a id="workout-help">Viewing Help: `help`</a>
You can see a complete list of available commands under Workout Menu and how to use them.

__Format:__ `help`

Example |  Outcome
--------|------------------
**Command**: <br> `help` <br><br> **Description:** <br> show help manual| TODO:actual code UI output

### 3.4.2. <a id="workout-start">Starting a New Workout Session: `new`</a>
Creates a new workout session and go into the session. 
You can add tags with “/t”. Tags are optional and more than one tag can be attached to a session.

__Format:__ `new /t <tag1> <tag2>`  
Tags are optional and more than one tag can be attached to a session.

Example: `new /t legs chest`

Situation | Example |  Outcome
----------|--------|------------------
Create a workout session with tags "leg" and "chest" | `new /t legs chest`| TODO: sthst
Repeated tags are attached| `new /t legs legs`| Only one will be added

#### 3.4.2.1. <a id="ws-help">Viewing Help: `help`</a>
You can see a complete list of available commands under Workout Session and how to use them.

__Format:__ `help`  

Example: `help`

#### 3.4.2.2. <a id="ws-add">Adding Data for Current Workout Session: `add`</a>
Adds moves with number of moves per set and weights of equipment (if the move does not require weights, input 0 for weight).

__Format:__ `add [name of move] /n [number of moves per set] /w [weight]`  

Example: `add squat /n 15 /w 40`

#### 3.4.2.3. <a id="ws-list">Listing Data for the Current Workout Session: `list`</a>
Lists all the added moves for the current workout session, with a numbered sequence according to sequence entered.

__Format:__ `list`  

Example: `list`

#### 3.4.2.4. <a id="ws-delete">Deleting Data From the Current Workout Session: `delete`</a>
Deletes the move according to move ID in the current workout session list.


__Format:__ `delete [move ID]`  

Example: `delete 1`

#### 3.4.2.5. <a id="ws-end">Ending the Recording Data for the Current Workout Session: `end`</a>
Ends the current workout session and saves the relevant data.


__Format:__ `end`  

Example: `end`

### 3.4.3. <a id="workout-list">Listing All Past Workout Sessions: `list`</a>
You can see all your past workout sessions. They will be summarised and 
printed in a table with their index, creation date and tags.

__Format:__ `list`  

Example |  Outcome
--------|------------------
**Command**: <br> `list` <br><br>| TODO:actual code UI output

### 3.4.4. <a id="workout-edit">Editing a Workout Session: `edit`</a>
You can edit a past workout session in the record list. You will go into the specific workout session after typing this command.

__Format:__ `edit <INDEX>` 

The index can be found by listing the results

Example |  Outcome
--------|------------------
**Command**: <br> `edit 1` <br><br> **Description:** <br> Edit the record at index 1.| TODO:actual code UI output

### 3.4.5. <a id="workout-delete">Deleting a Workout Session: `delete`</a>
You can delete a past workout session in the record list.

__Format:__ `delete <INDEX>` 

The index can be found by listing the results

Example |  Outcome
--------|------------------
**Command**: <br> `delete 1` <br><br> **Description:** <br> Delete the record at index 1.| TODO:actual code UI output

### 3.4.6. <a id="workout-search">Searching a List of Workout Session: `search`</a>
You can search for a list of workout sessions that matches certain conditions. For example, 
you can search for sessions created on a specific day or sessions that contains certain tags.

__Format:__ `Search /d <DATE> /t <tag1> <tag2>`

You can search records containing (a list of) tags with `/t` followed by the tags. If multiple tags are written, only sessions that contains all the tags will be selected.

You can search records created on a specific day with `/d` followed by a date.
Date should be keyed in  following one of the supported formats. 
[See here](#notes) for a complete list of format supported. If the format is not recognised, sessions created on any day will be accepted.

The conditions are optional. You may have zero, one or both conditions while searching.
If both conditions are specified, only sessions that meet both conditions will be selected.

You can see all the sessions that meet the conditions. They will be summarised and 
printed in a table with their index, creation date and tags.

Situation | Example |  Outcome
----------|--------|------------------
Search all sessions created on Oct 17 2020 | `search /d 20201018`|TODO:sthst
Search all sessions with "arm" tag| `search /t arm`|sth
Search all sessions with "arm" tag on Oct 17 2020| `search /t arm /d 20201018`|sth

### 3.4.7. <a id="workout-clear">Clearing All Workout Sessions: `clear`</a>
You can erase all workout sessions.

__Format:__ `clear`

This command is dangerous as you will not be able to 
recover the data.
After typing this command, you will be asked to reconfirm it by typing in
`YES`. Else the action will be aborted. 

Example |  Outcome
--------|------------------
**Command**: <br> `clear`| TODO:

### 3.4.8. <a id="workout-end">Returning to Main Menu: `end`</a>

You can return to the main menu.

__Format:__ `end`

After typing in this, you will see your prompt in your terminal
changes from `workout>>>` to `main>>>`. 
 
Example |  Outcome
--------|------------------
**Command**: <br> `clear`| TODO:

## 4. <a id="command-summary">Command Summary</a>

**Main Menu**

**Action** |  **Format**
--------|----------------------
Help|`help`
Profile Menu |`profile`
Diet Menu|`diet`
Workout Menu|`workout`
End|`end`

**Profile Menu**

**Action** |  **Format**
--------|----------------------
Help|`help`
Add |`add /n [NAME] /h [HEIGHT] /w [WEIGHT] /e [EXPECTED_WEIGHT] /c [EXPECTED_DAILY_CALORIES_INTAKE]`<br><br>E.g. `add /n Schwarzenegger /h 188 /w 113 /e 100 /c 2500`
View|`view`
Edit|`edit /n [NAME] /h [HEIGHT] /w [WEIGHT] /e [EXPECTED_WEIGHT] /c [EXPECTED_DAILY_CALORIES_INTAKE]`<br><br>E.g. `edit /w 110`, `edit /h 175 /w 110`, `edit /h 175 /w 110 /e 90`
Delete|`delete`
Return to Main Menu|`end`

**Diet Menu**

**Action** |  **Format**
--------|----------------------
Help|`help`
Start meal session |`meal /d [date] /t [type]`<br><br>E.g. `meal /d 2020-05-04 /t breakfast`
List|`list`
Edit|`edit [meal session ID]`<br><br>E.g. `edit 1`
Delete|`delete [meal session ID]`<br><br>E.g. `delete 1`
Clear|`clear`
Return to Main Menu|`end`

**Diet Session**

**Action** |  **Format**
--------|----------------------
Help|`help`
Add |`add [dish] /c [calorie count]`<br><br>E.g. `add spinach /c 90`
List|`list`
Delete|`delete [dish ID]`<br><br>E.g. `delete 1`
Clear|`clear`
Return to Main Menu|`end`

**Workout Menu**

**Action** |  **Format**
--------|----------------------
Start workout session |`new /t <tag1> <tag2>`<br><br>E.g. `new /t leg chest`
List|`list`
Edit|`edit <session ID>`<br><br>E.g. `edit 1`
Delete|`delete <session ID>`<br><br>E.g. `delete 1`
Search|`search /d <date> /t <tag1> <tag2>`<br><br>E.g. `search /t leg chest /d 20201018`
Help|`help`
Clear|`clear`
Return to Main Menu|`end`

## 5. <a id="notes">Notes</a>

[1] Here shows all 12 valid formats.
    
    `yyyyMMdd HH:mm`
    `yyyy-MM-dd HH:mm`
    `yyyy MM dd HH:mm`
    `yyyy/MM/dd HH:mm`
    
    `yyyyMMdd HHmm`
    `yyyy-MM-dd HHmm`
    `yyyy MM dd HHmm`
    `yyyy/MM/dd HHmm`
    
    `yyyyMMdd`
    `yyyy-MM-dd`
    `yyyy MM dd`
    `yyyy/MM/dd`
