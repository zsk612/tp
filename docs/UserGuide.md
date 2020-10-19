# User Guide
By: `Team F11-1` Since: `Sept 2020` License: `MIT`

## Table of content
* [1. Introduction](#1-introduction)
* [2. Quick Start](#2-quick-start)
* [3. Features](#3-features)
  + [3.1. Main Menu](#31-main-menu)
    - [3.1.1. Viewing help: help](#311-viewing-help-help)
    - [3.1.2. Entering Profile Menu: profile](#312-entering-profile-menu-profile)
    - [3.1.3. Entering Diet Menu: diet](#313-entering-diet-menu-diet)
    - [3.1.4. Entering Workout Menu: workout](#314-entering-workout-menu-workout)
    - [3.1.5. Exiting the program: end](#315-exiting-the-program-end)
  + [3.2. Profile Menu](#32-profile-menu)
    - [3.2.1. Viewing help: help](#321-viewing-help-help)
    - [3.2.2. Adding a profile: add](#322-adding-a-profile-add)
    - [3.2.3. Viewing a profile: view](#323-viewing-a-profile-view)
    - [3.2.4. Deleting a profile: delete](#324-deleting-a-profile-delete)
    - [3.2.5. Editing a profile: edit](#325-editing-a-profile-edit)
    - [3.2.6. Ending Profile Menu: end](#326-ending-profile-menu-end)
  + [3.3. Diet Menu](#33-diet-menu)
    - [3.3.1. List out all commands: help](#331-list-out-all-commands-help)
    - [3.3.2. Start recording diet data: meal](#332-start-recording-diet-data-meal)
      * [3.3.2.1. Showing help message: help](#3321-showing-help-message-help)
      * [3.3.2.2. Adding food items for the current meal: add](#3322-adding-food-items-for-the-current-meal-add)
      * [3.3.2.3. Listing data for the current meal: list](#3323-listing-data-for-the-current-meal-list)
      * [3.3.2.4. Deleting data from the current meal: delete](#3324-deleting-data-from-the-current-meal-delete)
      * [3.3.2.5. Clearing data from the current meal: clear](#3325-clearing-data-from-the-current-meal-clear)
      * [3.3.2.6. Stopping the recording of person’s meal data: end](#3326-stopping-the-recording-of-persons-meal-data-end)
    - [3.3.3. Edit a past diet session: list](#333-edit-a-past-diet-session-list)
    - [3.3.4. Edit a past diet session: edit](#334-edit-a-past-diet-session-edit)
    - [3.3.5. Delete a past diet session: delete](#335-delete-a-past-diet-session-delete)
    - [3.3.6. Clear all past diet sessions: clear](#336-clear-all-past-diet-sessions-clear)
    - [3.3.7. Exit the diet manager: end](#337-exit-the-diet-manager-end)
  + [3.4. Workout Menu](#34-workout-menu)
    - [3.4.1. Start a new workout session: new](#341-start-a-new-workout-session-new)
      * [3.4.1.1. Adding data for current workout session: add](#3411-adding-data-for-current-workout-session-add)
      * [3.4.1.2. Listing data for the current workout session: list](#3412-listing-data-for-the-current-workout-session-list)
      * [3.4.1.3. Showing the commands available for workout session: help](#3413-showing-the-commands-available-for-workout-session-help)
      * [3.4.1.4. Deleting data from the current workout session: delete](#3414-deleting-data-from-the-current-workout-session-delete)
      * [3.4.1.5. Stopping the recording data for the current workout session: end](#3415-stopping-the-recording-data-for-the-current-workout-session-end)
    - [3.4.2. Listing all past workout sessions: list](#342-listing-all-past-workout-sessions-list)
    - [3.4.3. Edit a workout session: edit](#343-edit-a-workout-session-edit)
    - [3.4.4. Delete a workout session: delete](#344-delete-a-workout-session-delete)
    - [3.4.5. Search a list of workout session: search](#345-search-a-list-of-workout-session-search)
    - [3.4.6. Showing the commands available for workout menu: help](#346-showing-the-commands-available-for-workout-menu-help)
    - [3.4.7. Clearing all workout sessions: clear](#347-clearing-all-workout-sessions-clear)
    - [3.4.8. Returning to main menu: end](#348-returning-to-main-menu-end)
* [4. Command summary](#4-command-summary)
* [5. Notes](#5-notes)

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
### 3.1. Main Menu
#### 3.1.1. Viewing help: help
#### 3.1.2. Entering Profile Menu: profile
#### 3.1.3. Entering Diet Menu: diet
#### 3.1.4. Entering Workout Menu: workout
#### 3.1.5. Exiting the program: end
### 3.2. Profile Menu
#### 3.2.1. Viewing help: help
#### 3.2.2. Adding a profile: add
#### 3.2.3. Viewing a profile: view
#### 3.2.4. Deleting a profile: delete
#### 3.2.5. Editing a profile: edit
#### 3.2.6. Ending Profile Menu: end
### 3.3. Diet Menu
### 3.3.1. List out all commands: help
### 3.3.2. Start recording diet data: meal
#### 3.3.2.1. Showing help message: help
#### 3.3.2.2. Adding food items for the current meal: add
#### 3.3.2.3. Listing data for the current meal: list
#### 3.3.2.4. Deleting data from the current meal: delete
#### 3.3.2.5. Clearing data from the current meal: clear
#### 3.3.2.6. Stopping the recording of person’s meal data: end
### 3.3.3. Edit a past diet session: list
### 3.3.4. Edit a past diet session: edit
### 3.3.5. Delete a past diet session: delete
### 3.3.6. Clear all past diet sessions: clear
### 3.3.7. Exit the diet manager: end
### 3.4. Workout Menu
### 3.4.1. Start a new workout session: new
You can creates a new workout session with this command.
You will directly go into the new created session to insert moves.
 
You can attach tags at the time of creating it for eaiser reference later. You can adds tags with “/t”. 

__Format:__ `new /t <tag1> <tag2>`  
Tags are optional and more than one tag can be attached to a session.

Example: `new /t legs chest`

Situation | Example |  Outcome
----------|--------|------------------
Create a workout session with tags "leg" and "chest" | `new /t legs chest`|sthst
Repeated tags are attached| `new /t legs legs`| Only one will be added
#### 3.4.1.1. Adding data for current workout session: add
#### 3.4.1.2. Listing data for the current workout session: list
#### 3.4.1.3. Showing the commands available for workout session: help
#### 3.4.1.4. Deleting data from the current workout session: delete
#### 3.4.1.5. Stopping the recording data for the current workout session: end
### 3.4.2. Listing all past workout sessions: list
You can see all your past workout sessions. They will be summarised and 
printed in a table with their index, creation date and tags.

__Format:__ `list`  

Example |  Outcome
--------|------------------
**Command**: <br> `list` <br><br>| TODO:actual code UI output

### 3.4.3. Edit a workout session: edit
You can edits a past workout session in the record list. You will go into 
the specific workout session after typing this.

__Format:__ `edit <INDEX>` 

The index can be found by listing the results

Example |  Outcome
--------|------------------
**Command**: <br> `edit 1` <br><br> **Description:** <br> Edit the record at index 1.| TODO:actual code UI output
### 3.4.4. Delete a workout session: delete
You can delete a past workout session in the record list.

__Format:__ `delete <INDEX>` 

The index can be found by listing the results

Example |  Outcome
--------|------------------
**Command**: <br> `delete 1` <br><br> **Description:** <br> Delete the record at index 1.| TODO:actual code UI output
### 3.4.5. Search a list of workout session: search
You can searches for a list of workout sessions that matches certain conditions.For exmaple, 
you can search for sessions created on a specific day or sessions that contains certain tags.

__Format:__ `Search /d <DATE> /t <tag1> <tag2>`

You can searches records containing (a list of) tags with `/t` followed by the tags. If multiple
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

### 3.4.6. Showing the commands available for workout menu: help
You can see a complete list of available commands under workout manager and how to use them.

__Format:__ `help`

Example |  Outcome
--------|------------------
**Command**: <br> `help` <br><br> **Description:** <br> show help manual| TODO:actual code UI output
### 3.4.7. Clearing all workout sessions: clear
You can erase all workout sessions.

__Format:__ `clear`

This command is dangerous as you will not be able to 
recover the data.
After typing this command, you will be asked to reconfirm it by typing in
`YES`. Else the action will be aborted. 

Example |  Outcome
--------|------------------
**Command**: <br> `clear`| TODO:

### 3.4.8. Returning to main menu: end

You can return to the main.

__Format:__ `end`

After typing in this, you will see your prompt in your terminal
changes from `workout>>>` to `main>>>`. 
 
Example |  Outcome
--------|------------------
**Command**: <br> `clear`| TODO:

## 4. Command summary

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
