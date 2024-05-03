# Baton Pass! A RPG Visual Novel.

## Introduction
Baton Pass! is an RPG Visual Novel where the player plays as the Main Character (MC), a retired hero who has been on many adventures throughout their life. 
They are approached by a young hero (Vin) who is desperate to be a hero and begs the hero to take them in as a trainee. Little does the MC know that the young trainee is willing to go through questionable means in order to get stronger. 
Throughout the story, the MC is begrudgingly convinced to help Vin, train them, and help them solve problems, including some that Vin causes to create a need for a hero that they would then fill. 
The MC then discovers Vin's intentions and has to fight them in a boss battle. The better the player trained Vin in the earlier minigames, the harder the boss battle is.

The player's original goal is to pick the right options in both fighting minigames with a jackpot mechanic and dialogue to increase the skill meter for Vin. If Vin does not have enough skill, they will engineer a problem big enough in an attempt to inspire the MC to train them harder. This does not work, and the MC instead becomes injured saving Vin and the village. The boss battle would then be engaged between the MC and Vin in which both have a low skill level. 
If Vin does have enough skill, the MC will be inspired by their success in training and will gain extra skill by reminiscing on the old days and learning a new technique. The boss battle would then be engaged between the MC and Vin in which both have a high skill level.

Puzzles would be both dialogue-based and a minigame with a jackpot mechanic. There would be one training session before each battle/problem in which the player is able to play the minigame, which serves as a kind of tutorial for the boss battle.  The more they help Vin, the better the both of them do in their battles. However, the more they help Vin, the harder Vin is to defeat in the ending boss battle.

## Business Case
Baton Pass!'s premise is its main differentiation from other games.
1) Few RPG Visual Novels currently capitalize off of the already popular anime genre of the retired hero.
2) Seldom are 'young trainees' introduced in the retired hero genre. Traditional interactions of the genre are between the retired hero and the ex-demon lord. We hope this nurturing aspect will bring in more prospective players.
3) Twist villains in the retired hero genre add a new layer of excitement to the traditional slice of life genre of the retired hero. We hope this captures the attention of audiences wishing for a mix of calmness and excitement.

## Key Functionality
- Two main characters, some side characters, and a world created with AI-generated graphics
- Fun jackpot-based minigame  as the attack system
- An eventual boss battle using the same minigame
- Enthralling story with multuple endings
- Dialogue options with diverging routes based on dialogue
- Save and load system for continued enjoyment

## Stakeholder Goals Summary
- __User:__ play the game


## Use Case Diagram

``` plantuml
@startuml
'human actors
actor "Player" as player

'system actors
actor "Minigames" <<system>> as miniGame
actor "Characters" <<system>> as characters
actor "Script" <<system>> as script

' list all use cases in package
package "Baton Pass!" {
    usecase "Gameplay" as gamePlay
}

'list relationships between actors and use cases
player --> gamePlay


gamePlay --> script

script --> miniGame
characters --> script
characters --> miniGame
gamePlay --> characters


@enduml
```



## 1. Target audience
 - RPG players
 - Mobile app game players
 - People over the age of sixteen

__Value gained by target audience:__ Fun while playing the game.

## 2. Primary actor and goals
__Player__: Play game and have fun.


## 3. Other stakeholders and their goals

* __Game producer__: Increase the number of players of the game and provide a fun experience for the player.

