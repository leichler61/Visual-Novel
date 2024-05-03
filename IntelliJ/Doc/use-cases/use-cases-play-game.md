# Gameplay Use Case (use-cases-play-game.md)

## 1. Primary actors and goals
- Player & System
- Player's Goal: play the game and have fun
- System's goal: display the game, record the game progress, react to player choices to follow the correct pathway for the game

## 2. Preconditions: 
- Application started correctly, code running with no problems.

## 3. Postconditions: 
- Smooth gameplay.
- Player reaches the end of the game.

## 4. Other stakeholders:
- None



```plantuml

|#technology|User|
|#lightblue|System|

|User|
start
:Opens app;
|System|
:Execute program;
:Generates start menu;
|User|
:Clicks start or load game;
|System|
:Runs intro sequence;
:Display intro sequence;
|User|
:Enters username;
:Engages in character dialogue with dialogue options;
|System|
:Starts minigame;
|User|
:__Execute play minigame__;
|System|
:Changes stats;
if (Skill stat > x) then (Yes);
:Engages in branch 1;
:Shows sequence 1;
:Increase stats;
else (No);
:Engages in branch 2;
:Shows sequence 2;
:Starts minigame;
|User|
:__Execute play minigame__;
endif
|System|
:Starts Boss Battle;
:Shows Boss Battle sequence;
:Starts minigame;
|User|
:__Execute play minigame__;
|System|
if (User won?) then (Yes)
|User|
:Chooses dialogue options;
|System|
:Starts ending based on dialogue options;
:__Shows ending__;
:User wins;
stop
else (No) 
:Starts ending;
:__Shows ending__;
:User loses;
stop


```