# User Guide
By: `Team F11-1` Since: `Sept 2020` License: `MIT`

## Table of content
1. [**Introduction**](#1-introduction)
1. [**Quick Start**](#2-quick-start)
1. [**Features**](#3-features)<br>
3.1. [Main Menu](#31-main-menu)<br>
&nbsp;&nbsp;&nbsp;&nbsp;3.1.1. [Viewing help: `help`](#311-viewing-help-help)<br>
&nbsp;&nbsp;&nbsp;&nbsp;3.1.2. [Entering Profile Menu: `profile`](#312-entering-profile-menu-profile)<br>
&nbsp;&nbsp;&nbsp;&nbsp;3.1.3. [Entering Diet Menu: `diet`](#313-entering-diet-menu-diet)<br>
&nbsp;&nbsp;&nbsp;&nbsp;3.1.4. [Entering Workout Menu: `workout`](#314-entering-workout-menu-workout)<br>
&nbsp;&nbsp;&nbsp;&nbsp;3.1.5.  [Exiting The Schwarzenegger: `end`](#315-exiting-the-schwarzenegger-end)<br>
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
1. [Command summary](#4-command-summary)
1. [Notes](#5-notes)

## 1. Introduction

The Schwarzenegger is a desktop command line interface-based app for managing all your needs 
regarding fitness. If you can type fast, The Schwarzenegger can help you 
maximise your efficiency for maintaining fitness.

## 2. Quick Start

When you first start using The Schwarzenegger, please ensure that you follow the instructions below:

1. Ensure you have Java 11 or above installed in your Computer.
1. Download the latest duke.jar from [here](https://github.com/AY2021S1-CS2113T-F11-1/tp/releases).
1. Copy the file to the folder you want to use as the home folder for the gymming application.
1. Open terminal or command prompt and change to the directory of the folder of the application.
1. Key in java -jar duke.jar

## 3. Features 
This section includes 4 sub sections which will guide you through the features available in Main Menu, Profile Menu, Workout Menu and Diet Menu.
### 3.1. Main Menu
You can get access to Profile Menu, Workout Menu and Diet Menu from Main Menu.
The available commands in Main Menu are listed below:

#### 3.1.1. Viewing help: `help`
The program will show a message explaining which commands are available for you to switch to the menu that you want (i.e. Profile Menu, Workout Menu and Diet Menu).

__Format:__ `help`  

Example: `help`
#### 3.1.2. Entering Profile Menu: `profile`
The program will direct you to the Profile Menu.

__Format:__ `profile`  

Example: `profile`
#### 3.1.3. Entering Diet Menu: `diet`
The program will direct you to the Diet Menu.

__Format:__ `diet`  

Example: `diet`
#### 3.1.4. Entering Workout Menu: `workout`
The program will direct you to the Workout Menu.

__Format:__ `workout`  

Example: `workout`
#### 3.1.5. Exiting The Schwarzenegger: `end`
Terminates The Schwarzenegger.

__Format:__ `end`  

Example: `end`
### 3.2. Profile Menu
Profile Menu manages your profile including your name, age and physique data. 

#### 3.2.1. Viewing help: `help`
The program will show a message explaining which commands are available Profile Menu.

__Format:__ `help`  

Example: `help`
#### 3.2.2. Adding a profile: `add`
You can add your profile for the most customized experience in The Schwarzenegger. Your height should in centimeters and your input weight should be in kilograms.

__Format:__ `add /n [name] /a [age] /h [height] /w [weight] /e [expected weight]`  

Example: `add /n Schwarzenegger /a 30 /h 188 /w 113 /e 100`

This command adds a profile with the name Schwarzenegger, age 30, height 188 cm, weight 113 kg and expected weight 100 kg.
#### 3.2.3. Viewing a profile: `view`
You can view your profile recorded in the program. The Schwarzenegger will also show your current BMI and give you suggestions on your expected weight to be fitter.

__Format:__ `view`  

Example: `view`
#### 3.2.4. Deleting a profile: `delete`
You can delete your profile from the program.

__Format:__ `delete`  

Example: `delete`
#### 3.2.5. Editing a profile: `edit`
You can edit the profile after adding to the program.

__Format:__ `edit /n [name or ]edit /h [height] or edit /w [weight] or edit /a [age] or edit /e [expection]`  

Example: `edit /h 180`

This command edits your current height in the system to 180 centimeters.
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

**Meal Menu**

**Action** |  **Format**
--------|----------------------
Help|`help`
Start meal session |`meal /d [date] /t [type]`<br><br>E.g. `meal /d 2020-05-04 /t breakfast`
List|`list`
Edit|`edit [meal session ID]`<br><br>E.g. `edit 1`
Delete|`delete [meal session ID]`<br><br>E.g. `delete 1`
Clear|`clear`
Back to main menu|`end`

**Meal Session**

**Action** |  **Format**
--------|----------------------
Help|`help`
add |`add [dish] /c [calorie count]`<br><br>E.g. `add spinach /c 90`
List|`list`
Delete|`delete [dish ID]`<br><br>E.g. `delete 1`
Clear|`clear`
Back to meal menu|`end`

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
Back to main menu|`end`

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