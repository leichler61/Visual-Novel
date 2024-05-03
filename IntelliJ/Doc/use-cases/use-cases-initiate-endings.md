# Endings Use Case (use-cases-initiate-endings.md)

## 1. Primary actors and goals
- Player & System
- Player's Goal: achieve the ending to the game they want (whether that is one of the good endings or one of the bad endings)
- System's goal: display the correct ending option based on the player's gameplay

## 2. Other stakeholders and their goals
- None

## 3. Preconditions
- Player completed all previous portions of the game.
- System stored game progress and game stats accurately.


## 4. Postconditions
- Game application ends properly and game can then restart if desired.

```plantuml

|#technology|User|
|#lightblue|System|

|User|
if (User wins Boss Battle?) then (Yes)
|System|
:Display ending with dialogue options;
|User|
:Choose dialogue options;
|System|
if (User chooses correctly?) then (Yes)
|System|
:Execute good ending;
:User wins with the good ending;
stop
else (No)
:Display bad ending;
:User wins with the bad ending;
stop
endif
else (No)
|System|
:Shows the losing ending;
:User loses with the sole losing ending;
stop
endif

```