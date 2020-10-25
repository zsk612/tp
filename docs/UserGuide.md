# User Guide
By: `Team F11-1` Since: `Sept 2020` License: `MIT`

## Table of content
1. [**Introduction**](#intro)
1. [**Quick Start**](#quickstart)
1. [**Features**](#features)<br>
3.1. [Main Menu](#main-menu)<br>
&nbsp;&nbsp;&nbsp;&nbsp;3.1.1. [Viewing help: `help`](#main-help)<br>
&nbsp;&nbsp;&nbsp;&nbsp;3.1.2. [Entering Profile Menu: `profile`](#main-profile)<br>
&nbsp;&nbsp;&nbsp;&nbsp;3.1.3. [Entering Diet Menu: `diet`](#main-diet)<br>
&nbsp;&nbsp;&nbsp;&nbsp;3.1.4. [Entering Workout Menu: `workout`](#main-workout)<br>
&nbsp;&nbsp;&nbsp;&nbsp;3.1.5.  [Ending The Schwarzenegger: `end`](#main-end)<br>
3.2. [Profile Menu](#32-profile-menu)<br>
&nbsp;&nbsp;&nbsp;&nbsp;3.2.1. [Viewing help: `help`](#321-viewing-help-help)<br>
&nbsp;&nbsp;&nbsp;&nbsp;3.2.2. [Adding a profile: `add`](#322-adding-a-profile-add)<br>
&nbsp;&nbsp;&nbsp;&nbsp;3.2.3. [Viewing a profile: `view`](#323-viewing-a-profile-view)<br>
&nbsp;&nbsp;&nbsp;&nbsp;3.2.4. [Deleting a profile: `delete`](#324-deleting-a-profile-delete)<br>
&nbsp;&nbsp;&nbsp;&nbsp;3.2.5. [Editing a profile: `edit`](#325-editing-a-profile-edit)<br>
&nbsp;&nbsp;&nbsp;&nbsp;3.2.6. [Returning to Main Menu: `end`](#326-ending-profile-menu-end)<br>
3.3. [Diet Menu](#33-diet-menu)<br>
&nbsp;&nbsp;&nbsp;&nbsp;3.3.1. [Listing out all commands: `help`](#331-listing-out-all-commands-help)<br>
&nbsp;&nbsp;&nbsp;&nbsp;3.3.2. [Starting to record diet data: `meal`](#332-starting-to-record-diet-data-meal)<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;3.3.2.1. [Showing help message: `help`](#3321-showing-help-message-help)<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;3.3.2.2. [Adding food items for the current meal: `add`](#3322-adding-food-items-for-the-current-meal-add)<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;3.3.2.3. [Listing data for the current meal: `list`](#3323-listing-data-for-the-current-meal-list)<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;3.3.2.4. [Deleting data from the current meal: `delete`](#3324-deleting-data-from-the-current-meal-delete)<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;3.3.2.5. [Clearing data from the current meal: `clear`](#3325-clearing-data-from-the-current-meal-clear)<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;3.3.2.6. [Stopping the recording of person’s meal data: `end`](#3326-stopping-the-recording-of-persons-meal-data-end)<br>
&nbsp;&nbsp;&nbsp;&nbsp;3.3.3. [Listing all past diet sessions: `list`](#333-listing-all-past-diet-sessions-list)<br>
&nbsp;&nbsp;&nbsp;&nbsp;3.3.4. [Editing a past diet session: `edit`](#334-editing-a-past-diet-session-edit)<br>
&nbsp;&nbsp;&nbsp;&nbsp;3.3.5. [Deleting a past diet session: `delete`](#335-deleting-a-past-diet-session-delete)<br>
&nbsp;&nbsp;&nbsp;&nbsp;3.3.6. [Clearing all past diet sessions: `clear`](#336-clearing-all-past-diet-sessions-clear)<br>
&nbsp;&nbsp;&nbsp;&nbsp;3.3.7. [Returning to Main Menu: `end`](#337-returning-to-main-menu-end)<br>
3.4. [Workout Menu](#34-workout-menu)<br>
&nbsp;&nbsp;&nbsp;&nbsp;3.4.1. [Starting a new workout session: `new`](#341-starting-a-new-workout-session-new)<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;3.4.1.1. [Adding data for current workout session: `add`](#3411-adding-data-for-current-workout-session-add)<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;3.4.1.2. [Listing data for the current workout session: `list`](#3412-listing-data-for-the-current-workout-session-list)<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;3.4.1.3. [Showing the commands available for workout session: `help`](#3413-showing-the-commands-available-for-workout-session-help)<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;3.4.1.4. [Deleting data from the current workout session: `delete`](#3414-deleting-data-from-the-current-workout-session-delete)<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;3.4.1.5. [Stopping the recording data for the current workout session: `end`](#3415-stopping-the-recording-data-for-the-current-workout-session-end)<br>
&nbsp;&nbsp;&nbsp;&nbsp;3.4.2. [Listing all past workout sessions: `list`](#342-listing-all-past-workout-sessions-list)<br>
&nbsp;&nbsp;&nbsp;&nbsp;3.4.3. [Editing a workout session: `edit`](#343-editing-a-workout-session-edit)<br>
&nbsp;&nbsp;&nbsp;&nbsp;3.4.4. [Deleting a workout session: `delete`](#344-deleting-a-workout-session-delete)<br>
&nbsp;&nbsp;&nbsp;&nbsp;3.4.5. [Searching a list of workout session: `search`](#345-searching-a-list-of-workout-session-search)<br>
&nbsp;&nbsp;&nbsp;&nbsp;3.4.6. [Showing the commands available for workout menu: `help`](#346-showing-the-commands-available-for-workout-menu-help)<br>
&nbsp;&nbsp;&nbsp;&nbsp;3.4.7. [Clearing all workout sessions: `clear`](#347-clearing-all-workout-sessions-clear)<br>
&nbsp;&nbsp;&nbsp;&nbsp;3.4.8. [Returning to Main Menu: `end`](#348-returning-to-main-menu-end)
1. [**Command summary**](#command-summary)
1. [**Notes**](#notes)

## 1. <a id="intro">Introduction</a>

The Schwarzenegger is a desktop command line interface-based app for managing all your needs 
regarding fitness. If you can type fast, The Schwarzenegger can help you 
maximise your efficiency for maintaining fitness.

## 2. <a id="quickstart">Quick Start</a>

When you first start using The Schwarzenegger, please ensure that you follow the instructions below:

1. Ensure you have Java `11` or above installed in your Computer.
1. Download the latest `duke.jar` from [here](https://github.com/AY2021S1-CS2113T-F11-1/tp/releases).
1. Copy the file to the folder you want to use as the home folder for The Schwarzenegger.
1. Open command prompt (on Windows)  or terminal (on MacOS/ Linux) and change to the directory of the folder of the application in step 3.
1. Key in java -jar duke.jar. If the setup is correct, you should see something like below:

    ```
        ______________________________________________________________________________
        Welcome new user to Schwarzenegger! :D
        Please add your profile using "add" command under Profile Menu.
        For more information on command syntax, please type "help".
        ______________________________________________________________________________
    ```
   
1. To use The Schwarzenegger, simply type a valid command into the terminal and press <kbd>Enter</kbd> to run the command.<br>
    Example: Typing `help` command and pressing <kbd>Enter</kbd> will show you a list of available commands in The Schwarzenegger and their descriptions.
1. Some example commands you can try:
    - `help` : Shows all commands in The Schwarzenegger and their descriptions.
    - `profile` : Directs you to Profile Menu where you can add and manage your profile.
    - `diet` : Directs you to Diet Menu where you can add and manage your diet records.
    - `workout` : Directs you to Workout Menu where you can add and manage your workout records.
1. A summary of all the supported commands in Duke can be found in [Section 4. Command Summary](#4-command-summary).<br>
Refer to [Section 3. Features](#3-features) for the detailed instructions of the various features in The Schwarzenegger.

## 3. <a id="features">Features</a> 
This section includes 4 sub sections which will guide you through the features available in Main Menu, Profile Menu, Workout Menu and Diet Menu.

### 3.1. <a id="main-menu">Main Menu</a>
You can get access to Profile Menu, Diet Menu and Workout Menu from Main Menu.
The available commands in Main Menu are listed below:

#### 3.1.1. <a id="main-help">Viewing help: `help`</a>
The program will show a message explaining which commands are available for you to switch to the menu that you want (i.e. Profile Menu, Workout Menu and Diet Menu).

__Format:__ `help`

Example: `help`

#### 3.1.2. <a id="main-profile">Entering Profile Menu: `profile`</a>
The program will direct you to the Profile Menu.

__Format:__ `profile`  

Example: `profile`

#### 3.1.3. <a id="main-diet">Entering Diet Menu: `diet`</a>
The program will direct you to the Diet Menu.

__Format:__ `diet`  

Example: `diet`

#### 3.1.4. <a id="main-workout">Entering Workout Menu: `workout`</a>
The program will direct you to the Workout Menu.

__Format:__ `workout`  

Example: `workout`

#### 3.1.5. <a id="main-end">Ending The Schwarzenegger: `end`</a>
You enter this command when you want to terminate The Schwarzenegger.

__Format:__ `end`  

Example: `end`

### 3.2. Profile Menu
Profile Menu manages your profile including your name, physique data and expected daily calories intake. 

#### 3.2.1. Viewing help: `help`
The program will show a message explaining which commands are available Profile Menu.

__Format:__ `help`  

Example: `help`

#### 3.2.2. Adding a profile: `add`
You can add your profile for the most customized experience in The Schwarzenegger. Your height should in centimeters and your input weight should be in kilograms.

__Format:__ `add /n [NAME] /h [HEIGHT] /w [WEIGHT] /e [EXPECTED_WEIGHT] /c [EXPECTED_DAILY_CALORIES_INTAKE]`  

Example: `add /n Schwarzenegger /h 188 /w 113 /e 100 /c 2500`

This command adds a profile with the name Schwarzenegger, height 188 cm, weight 113 kg, expected weight 100 kg and expected daily intake of 2500 calories.

#### 3.2.3. Viewing a profile: `view`
You can view your profile recorded in the program. The Schwarzenegger will also show your current BMI and give you suggestions on an expected weight for better fitness if it detects your current expectation is not appropriate.

__Format:__ `view`  

Example: `view`

#### 3.2.4. Deleting a profile: `delete`
You can delete your profile from the program. The program will ask for your confirmation, and it will only delete after you type in exactly "YES".

__Format:__ `delete`  

Example: `delete`

#### 3.2.5. Editing a profile: `edit`
You can edit the profile after adding to the program.

__Format:__ `edit /n [NAME] /h [HEIGHT] /w [WEIGHT] /e [EXPECTED_WEIGHT] /c [EXPECTED_DAILY_CALORIES_INTAKE]`  

Example: <br>
    - `edit /h 180`<br>
    This command edits your current height to 180 centimeters.<br>
    - `edit /h 180 /w 50`<br>
    This command edits your current height to 180 centimeters and current weight to 50 kilograms.<br>
    - `edit /h 180 /w 50 /e 55`<br>
     This command edits your current height to 180 centimeters, current weight to 50 kilograms and expected weight to 55 kilograms.<br>

|:bulb:| You may edit from 1 field to all fields in your profile. |
|------|:-----------|              
    
#### 3.2.6. Returning to Main Menu: `end`
You use this command to switch back to the Main Menu.

__Format:__ `end`  

Example: `end`
### 3.3. Diet Menu

### 3.3.1. Listing out all commands: `help`
You can list out all the commands in the diet menu with a brief summary of how to use them with this command.

__Format:__ `help` 
### 3.3.2. Starting to record diet data: `meal`
This command creates a new meal session.
You will be directed immediately into the meal session.

The date and tag can be added on creation with "/d" for date and "/t" for meal type.

__Format:__ `meal /d [date] /t [type]`
 
Example: `meal /d 2020-08-05 /t lunch`

Situation | Example |  Outcome
----------|--------|------------------
Create a meal session | `meal`| a meal session of type unspecified with today's date will be created
Create a meal session with date and type| `meal /d 2020-05-04 breakfast`| A meal session with date 2020-05-04 and type breakfast will be created
#### 3.3.2.1. Showing help message: `help`
You can list out all the commands in the diet session with a brief summary of how to use them with this command.

__Format:__ `help` 

Example: `help`
#### 3.3.2.2. Adding food items for the current meal: `add`
This command adds a food item into the current meal session

__Format:__ `add [food name] /c [amount of calories]` 

Example: `add chicken nuggets /c 120`
#### 3.3.2.3. Listing data for the current meal: `list`
Lists all the added dishes for the current meal, with a numbered sequence according to sequence entered.

__Format:__ `list` 

Example: `list`
#### 3.3.2.4. Deleting data from the current meal: `delete`
Deletes the dish according to the ID in the current meal session list.

__Format:__ `delete [dish ID]`

Example: `delete 3` 
#### 3.3.2.5. Clearing data from the current meal: `clear`
Clears all the dishes in the current meal list.

__Format:__ `clear` 

Example: `clear`
#### 3.3.2.6. Stopping the recording of person’s meal data: `end`
Ends the current meal session and saves the data.

__Format:__ `end` 

Example: `end`
### 3.3.3. Listing all past diet sessions: `list`
Obtains a list of information about past diet sessions together with their numbered index.

__Format:__ `list`

Example: `list`
### 3.3.4. Editing a past diet session: `edit`
Edits a previous meal session based on a numbered index that can be found in the list.

__Format:__ `edit [index number]`

Example: `edit 3` 
### 3.3.5. Deleting a past diet session: `delete`
Deletes a previous meal session based on a numbered index that can be found in the list.

__Format:__ `delete [index number]`

Example: `delete 3` 
### 3.3.6. Clearing all past diet sessions: `clear`
Deletes all previous diet sessions.

__Format:__ `clear`

Example: `clear`
### 3.3.7. Returning to Main Menu: `end`
Ends the current meal session and saves the data.

__Format:__ `end` 
Exits the diet manager and returns you back to the main menu.

__Format:__ `end`

Example: `end`
### 3.4. Workout Menu
Shows a list of commands and their way of use.

__Format:__ `help`  

Example: `help`
### 3.4.1. Starting a new workout session: `new`
Creates a new workout session and go into the session. 
Adds tags with “/t”. Tags are optional and more than one tag can be attached to a session.

__Format:__ `new /t <tag1> <tag2>`  
Tags are optional and more than one tag can be attached to a session.

Example: `new /t legs chest`

Situation | Example |  Outcome
----------|--------|------------------
Create a workout session with tags "leg" and "chest" | `new /t legs chest`|sthst
Repeated tags are attached| `new /t legs legs`| Only one will be added
#### 3.4.1.1. Adding data for current workout session: `add`
Adds moves with number of moves per set and weights of equipment (if the move does not require weights, input 0 for weight).

__Format:__ `add [name of move] /n [number of moves per set] /w [weight]`  

Example: `add squat /n 15 /w 40`

#### 3.4.1.2. Listing data for the current workout session: `list`
Lists all the added moves for the current workout session, with a numbered sequence according to sequence entered.

__Format:__ `list`  

Example: `list`

#### 3.4.1.3. Showing the commands available for workout session: `help`
Shows a list of commands and their way of use.

__Format:__ `help`  

Example: `help`
#### 3.4.1.4. Deleting data from the current workout session: `delete`
Deletes the move according to move ID in the current workout session list.


__Format:__ `delete [move ID]`  

Example: `delete 1`
#### 3.4.1.5. Stopping the recording data for the current workout session: `end`
Ends the current workout session and saves the relevant data.


__Format:__ `end`  

Example: `end`
### 3.4.2. Listing all past workout sessions: `list`
You can see all your past workout sessions. They will be summarised and 
printed in a table with their index, creation date and tags.

__Format:__ `list`  

Example |  Outcome
--------|------------------
**Command**: <br> `list` <br><br>| TODO:actual code UI output

### 3.4.3. Editing a workout session: `edit`
You can edits a past workout session in the record list. You will go into 
the specific workout session after typing this.

__Format:__ `edit <INDEX>` 

The index can be found by listing the results

Example |  Outcome
--------|------------------
**Command**: <br> `edit 1` <br><br> **Description:** <br> Edit the record at index 1.| TODO:actual code UI output
### 3.4.4. Deleting a workout session: `delete`
You can delete a past workout session in the record list.

__Format:__ `delete <INDEX>` 

The index can be found by listing the results

Example |  Outcome
--------|------------------
**Command**: <br> `delete 1` <br><br> **Description:** <br> Delete the record at index 1.| TODO:actual code UI output
### 3.4.5. Searching a list of workout session: `search`
You can searches for a list of workout sessions that matches certain conditions.For exmaple, 
you can search for sessions created on a specific day or sessions that contains certain tags.

__Format:__ `Search /d <DATE> /t <tag1> <tag2>`

You can search records containing (a list of) tags with `/t` followed by the tags. If multiple
tags are written, only sessions that contains all the tags will be selected.

You can searches records created on a specific day with `/d` followed by a date.
Date should be keyed in  following one of the supported formats. 
[See here](#5-notes) for a complete list of format supported. If the format is not 
recognised, sessions created on any day will be accepted.

The conditions are optional. You may have zero, one or both conditions while searching.
If both conditions are specified, only sessions that meet both conditions will be selected.

You can see all the sessions that meet the conditions. They will be summarised and 
printed in a table with their index, creation date and tags.

Situation | Example |  Outcome
----------|--------|------------------
Search all sessions created on Oct 17 2020 | `search /d 20201018`|TODO:sthst
Search all sessions with "arm" tag| `search /t arm`|sth
Search all sessions with "arm" tag on Oct 17 2020| `search /t arm /d 20201018`|sth

### 3.4.6. Showing the commands available for workout menu: `help`
You can see a complete list of available commands under workout manager and how to use them.

__Format:__ `help`

Example |  Outcome
--------|------------------
**Command**: <br> `help` <br><br> **Description:** <br> show help manual| TODO:actual code UI output
### 3.4.7. Clearing all workout sessions: `clear`
You can erase all workout sessions.

__Format:__ `clear`

This command is dangerous as you will not be able to 
recover the data.
After typing this command, you will be asked to reconfirm it by typing in
`YES`. Else the action will be aborted. 

Example |  Outcome
--------|------------------
**Command**: <br> `clear`| TODO:

### 3.4.8. Returning to main menu: `end`

You can return to the main menu.

__Format:__ `end`

After typing in this, you will see your prompt in your terminal
changes from `workout>>>` to `main>>>`. 
 
Example |  Outcome
--------|------------------
**Command**: <br> `clear`| TODO:

## 4. Command summary

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

## 5. Notes

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
