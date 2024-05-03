## Original Design:

```plantuml
title Jackpot Minigame
abstract class Character {
skill: int
health: int
name: String
public Character(int, int, String)
changeSkill(int): void
decreaseHealth(int): void
getSkill(): int
getHealth(): int
getName(): String
attack(Character): void;
}
class MainCharacter extends Character {
public MainCharacter(int, int, String)
attack(Character): void
}
class Vin extends Character {
public Vin(int, int, String)
attack(Character): void
}
class Enemy extends Character {
public Enemy(int, int, String)
attack(Character): void
}
class Jackpot {
RandomSymbols: char[]
TargetSymbol: char
HitSymbol: char
StartingTime: LocalDateTime
EndTime: LocalDateTime
SecondsElapsed: int
state: JackpotState
spinning: boolean
startSpin(): void
endSpin(): void
callAttack(Character, Character): void
}
class JackpotState {
SPINNING
HIT
MISS
}
class UI {
introduction(): void
attackDisplay(int, Character, Character): void
toString(String): void
}
class Main {
static main(String[] args): void
}

Jackpot "1" - "1..*" Character : \tAffects stats\t
Jackpot "1..*" - "1" UI : Displays jackpot actions
Character "1..*"  - "1" UI : Displays character actions
Main "1" - "1..*" Character: Calls methods
Main "1" - "1..*" Jackpot: Calls methods
JackpotState "1..*" - "1" Jackpot: Provides states
```

```plantuml
title Jackpot Minigame
Actor Player as player
Participant "UI" as UI
Participant "Jackpot" as spin
Participant "Character Object 1" as Character1
Participant "Character Object 2" as Character2


loop Character1.Health > 0 && Character2.Health > 0?
UI -> player: Shows introduction
player -> spin: Starts the spin
player -> spin: Ends the spin
spin -> Character1: \t\tchangeSkill(int)
spin -> Character1: callAttack(Character, Character)
Character1 -> Character2: attack(Character)
Character1 -> Character2: changeHealth(int)
UI -> player: Displays the results of the attack
spin -> Character2: callAttack(Character, Character)
Character2 -> Character1: attack(Character)
Character2 -> Character1: changeHealth(int)
UI -> player: Displays the results of the attack
end
```

## Updated Design after Iteration 2:

# Controller
```plantuml
title Jackpot Minigame Controller
class MainActivity {
j: Jackpot
context: Context
mainView: IMainView
combatFragment: CombatFragment
spinnerInstructionFragment: SpinnerInstructionFragment
spinnerFragment: SpinnerFragment
count: int
game: boolean
MC: Character
enemy: Character
onCreate(Bundle): void
onDisplayIntroduction(): void
onStartingJackpot(): void
onStoppingJackpot(): void
onDisplayAttack(): void
onFinishMinigame(): void
}
```
# Model 
While the Story class is currently part of the Model section of our project, it is not for this iteration (we just wanted to get ahead), so it is not included in the Model diagram.
```plantuml
title Jackpot Minigame Model Classes
abstract class Character {
skill: int
health: int
name: String
public Character(int, int, String)
changeSkill(int): void
decreaseHealth(int): void
setHealth(int): void
getSkill(): int
getHealth(): int
getName(): String
attack(Character): void;
}
class MainCharacter extends Character {
public MainCharacter(int, int, String)
attack(Character): void
}
class Vin extends Character {
public Vin(int, int, String)
attack(Character): void
}
class Enemy extends Character {
public Enemy(int, int, String)
attack(Character): void
}
class Jackpot {
RandomSymbols: char[]
TargetSymbol: char
DisplayedSymbol: char
state: JackpotState
page: int
list: List<String>
addInstructions(): void
getRandomSymbols(): char[]
getTargetSymbol(): char
getDisplayedSymbol():char
setDisplayedSymbol(char): void
getState(): JackpotState
getPage(): int
addPage(): void
getList(): List
startSpin(): void
endSpin(): void
}
class JackpotState {
SPINNING
HIT
MISS
}

Jackpot "1" - "1..*" Character : \tAffects stats\t
JackpotState "1..*" - "1" Jackpot: Provides states
```
# View
The story fragment will eventually be used largely for dialogue. Right now, it is used to display the outcome of the minigame (whether the player won or lost), so it is included in this iteration about the minigame.
```plantuml
title Jackpot Minigame View Classes
interface ICombatView {
onDisplayAttack(): void
}
class CombatFragment implements ICombatView {
binding: FragmentCombatBinding
listener: Listener
public CombatFragment(Context, Listener)
onCreateView(LayoutInflater, ViewGroup, Bundle): View
onViewCreated(View, Bundle): void
attackDisplay(int, Character, Character): void 
}
interface ISpinnerInstructionView {
onDisplayIntroduction(): void
}
class SpinnerInstructionFragment implements ISpinnerInstructionView{
binding: FragmentInstructionBinding
listener: Listener
public SpinnerInstructionFragment(Context, Listener)
onCreateView(LayoutInflater, ViewGroup, Bundle): View
onViewCreated(View, Bundle): void
displayInstruction(String): void
}
interface ISpinnerView {
onStoppingJackpot(): void
onStartingJackpot(): void
onDisplayStory();
}
class SpinnerFragment implements ISpinnerView{
binding: FragmentSpinnerBinding
listener: Listener
public SpinnerFragment(Context, Listener)
onCreateView(LayoutInflater, ViewGroup, Bundle): View
onViewCreated(View, Bundle): void
displaySpinningSymbol(char): void
hideStopButton(): void
showStopButton(): void
displayTargetSymbol(char): void
displaySnackBar(String): void
}
interface IStoryView {

}
class StoryFragment implements IStoryView {
binding: FragmentStoryBinding
listener: ISpinnerView.Listener
public StoryFragment(Context, ISpinnerView.Listener)
onCreateView(LayoutInflater, ViewGroup, Bundle): View
onViewCreated(View, Bundle): void
displayLine(String): void
}
interface IMainView {
getRootView(): View
displayFragment(Fragment, boolean, String): void
}
class MainView implements IMainView {
fman: FragmentManager
binding: MainBinding
public MainView(FragmentActivity)
getRootView(): View
displayFragment(Fragment, boolean, String): void
}

```

```plantuml
Actor Player as player
Participant "MainActivity" as main
Participant "MainView" as view
Participant "SpinnerInstructionFragment" as instruction
Participant "Jackpot" as jackpot
Participant "Character Object 1" as Character1
Participant "Character Object 2" as Character2

main -> view: displayFragment(SpinnerInstructionFragment)
jackpot -> instruction: addInstructions()
loop page < list.size()?
player -> main: Clicks next button
main -> view: onDisplayIntroduction()
end
loop Character1.Health > 0 && Character2.Health > 0?
main -> view: displayFragment(SpinnerFragment)
player -> main: Clicks start button
main -> jackpot: onStartingJackpot()
main -> jackpot: startSpin()
player -> main: Clicks stop button
main -> jackpot: onStoppingJackpot()
main -> jackpot: endSpin()
main -> jackpot: callAttack(Character, Character)
jackpot -> Character1: changeSkill(int)
Character1 -> Character2: attack(Character)
Character1 -> Character2: changeHealth(int)
Character2 -> Character1: attack(Character)
Character2 -> Character1 : changeHealth(int)
main -> view: displaySnackBar(String)
main -> view: displayFragment(CombatFragment)
loop page < list.size()?
player -> main: Clicks next button
main -> view: onDisplayAttack()
main -> view: attackDisplay(int, Character, Character)
end
end
main -> view: onDisplayFragment(storyFragment)
player -> main: Clicks next button
main -> view: onDisplayStory()
main -> view: onDisplayLine(String)
main -> main: onFinishMinigame()
```

## Updated Design after Final Iteration:

# Controller
```plantuml
title Controller
class MainActivity {
j: Jackpot
s: Story
context: Context
mainView: IMainView
startFragment: StartFragment
combatFragment: CombatFragment
spinnerInstructionFragment: SpinnerInstructionFragment
spinnerFragment: SpinnerFragment
storyFragment: StoryFragment
spinnerIntroductionFragment: SpinnerIntroductionFragment
endFragment: EndFragment
count: int
minigame_num: int
ending_num: int
outcome: boolean
routeSet: boolean
a_count: int
b_count: int
lastChoice: String
time: long
enem_skill: int
MC: MainCharacter
vin_protag: MainCharacter
vin_enemy: Enemy
mushroom: Enemy
gorge_goblins: Enemy
forest_goblins: Enemy
dragon: Enemy
music: MediaPlayer
sound: MediaPlayer
onCreate(Bundle): void
onStartGame(): void
onNextDisplay(): void
onDisplayIntroduction(): void
onDisplaySpinner(): void
onStartingJackpot(): void
onStoppingJackpot(): void
getStoryState(): StoryState
onDisplayAttack(): void
onDisplayTutorial(): void
onSetEasy(): void
onSetMedium(): void
onSetHard(): void
onEnd(): void
setCharacter(boolean): Character
onEndingChoices(): void
onChoice1(): void
onChoice2(): void
playMusic(boolean, int): void
playSound(boolean, int): void
}
```
# Model
```plantuml
title Model Classes
abstract class Character {
skill: int
originalSkill: int
baselineSkill: int
health: int
originalHealth: int
baselineHealth: int
name: String
public Character(int, int, String)
changeSkill(int): void
decreaseHealth(int): void
getHealth(): int
setHealth(int): void
getSkill(): int
setSkill(int): void
getOriginalHealth(): int
getBaselineHealth(): int
getOriginalSkill(): int
getBaselineSkill(): int
setBaselineSkill(int): void
getName(): String
attack(Character): void;
}
class MainCharacter extends Character {
public MainCharacter(int, int, String)
attack(Character): void
}
class Enemy extends Character {
public Enemy(int, int, String)
attack(Character): void
}
class Jackpot {
randomSymbols: char[]
targetSymbol: char
displayedSymbol: char
state: JackpotState
page: int
list: List<String>
addInstructions(): void
getRandomSymbols(): char[]
getTargetSymbol(): char
getDisplayedSymbol():char
setDisplayedSymbol(char): void
getState(): JackpotState
setState(JackpotState): void
getPage(): int
addPage(): void
getList(): List
startSpin(): void
endSpin(): void
callAttack(Character, Character): void
}
class JackpotState {
SPINNING
HIT
MISS
}
class Story {
scriptList: List<String>
portraitList: List<Integer>
backgroundList: List<Integer>
aScriptList: List<String>
bScriptList: List<String>
aPortraitList: List<Integer>
bPortraitList: List<Integer>
aBackgroundList: List<Integer>
bBackgroundList: List<Integer>
aButtonChoices: List<Integer>
bButtonChoices: List<Integer>
line: int
count: int
endingChoice: boolean
state: StoryState
getLine(): int
setLine(int): void
addLine(): void
getCount(): int
addCount(): void
getEndingChoice(): boolean
getScriptList(): List<String>
getPortraitList(): List<Integer>
getBackgroundList(): List<Integer>
getAScriptList(): List<String>
getBScriptList(): List<String>
getAPortraitList(): List<Integer>
getBPortraitList(): List<Integer>
getABackgroundList(): List<Integer>
getBBackgroundList(): List<Integer>
getAButtonChoices(): List<Integer>
getBButton Choices(): List<Integer>
getState(): StoryState
introduction(): void
gorge(boolean): void
setRoute(int, int, boolean): void
route1_2(boolean): void
route1_end(boolean): int
ending1a(): void
ending1b(): void
route2_2(boolean): void
route2_end(boolean): int
ending2(): void
ending2a(): void
ending2b(): void
ending3(): void
}
class StoryState {
INTRO(int)
GORGE(int)
ROUTE1(int)
ROUTE2(int)
SETROUTE(int)
ROUTE1_2(int)
ENGING1A(int)
ENDING1B(int)
ROUTE2_2(int)
ENDING2(int)
ENDING2A(int)
ENDING2B(int)
ENDING3(int)
combatBackground: int
private StoryState(int)
getBackgroundId(): int
}

Jackpot "1..*" - "1" Story: Affects pathway taken
Jackpot "1" - "1..*" Character : \tAffects stats\t
JackpotState "1..*" - "1" Jackpot: Provides states
Story "1" - "1..*" StoryState: Provides states
```
# View
```plantuml
title View Classes
interface ICombatView {
ICombatView.Listener
attackDisplay(int, Character, Character, boolean): void
displayCombatScene(int): void
setHit(boolean): void
}
class CombatFragment implements ICombatView {
binding: FragmentCombatBinding
listener: Listener
hit: boolean
public CombatFragment(Context, Listener)
onCreateView(LayoutInflater, ViewGroup, Bundle): View
onViewCreated(View, Bundle): void
attackDisplay(int, Character, Character, boolean): void 
displayCombatScene(int): void
setHit(boolean): void
}
interface ISpinnerInstructionView {
ISpinnerInstructionView.Listener
displayInstruction(String): void
hideButtons(): void
hideNextButton(): void
showButtons(): void
}
class SpinnerInstructionFragment implements ISpinnerInstructionView{
binding: FragmentInstructionBinding
listener: Listener
public SpinnerInstructionFragment(Context, Listener)
onCreateView(LayoutInflater, ViewGroup, Bundle): View
onViewCreated(View, Bundle): void
displayInstruction(String): void
hideButtons(): void
hideNextButton(): void
showButtons(): void
}
interface ISpinnerView {
ISpinnerView.Listener
displaySpinningSymbol(char): void
hideStopButton(): void
showStopButton(): void
displayTargetSymbol(char): void
displaySnackBar(String): void
}
class SpinnerFragment implements ISpinnerView{
binding: FragmentSpinnerBinding
listener: Listener
public SpinnerFragment(Context, Listener)
onCreateView(LayoutInflater, ViewGroup, Bundle): View
onViewCreated(View, Bundle): void
displaySpinningSymbol(char): void
hideStopButton(): void
showStopButton(): void
displayTargetSymbol(char): void
displaySnackBar(String): void
}
interface IStoryView {
IStoryView.Listener
displayLine(String text): void
displayChoice1(Integer): void
displayChoice2(Integer): void
displayPortrait(int): void
displayBackground(int): void
hideChoices(): void
showChoices(): void
}
class StoryFragment implements IStoryView {
binding: FragmentStoryBinding
listener: Listener
public StoryFragment(Context, ISpinnerView.Listener)
onCreateView(LayoutInflater, ViewGroup, Bundle): View
onViewCreated(View, Bundle): void
displayLine(String): void
displayChoice1(Integer): void
displayChoice2(Integer): void
displayPortrait(int): void
displayBackground(int): void
hideChoices(): void
showChoices(): void
}
interface IMainView {
getRootView(): View
displayFragment(Fragment, boolean, String): void
}
class MainView implements IMainView {
fman: FragmentManager
binding: MainBinding
public MainView(FragmentActivity)
getRootView(): View
displayFragment(Fragment, boolean, String): void
}
interface IStartView {
IStartView.Listener
}
class StartFragment implements IStartView {
binding: FragmentStartBinding
listener: Listener
public StartFragment(Context, Listener)
onCreatView(LayoutInflater, ViewGroup, Bundle): View
onViewCreated(View, Bundle): void
}
interface IEndView{
IEndView.Listener
ending(int): void
}
class EndFragment implements IEndView {
binding: FragmentEndBiding
listener: Listener
endingNum: int
endingMessage: String
public EndFragment(Context, Listener)
onCreateView(LayoutInflater, ViewGroup, Bundle): View
onViewCreated(View, Bundle): void
ending(int): void
}
interface ISpinnerIntroductionView {
ISpinnerIntroductionView.Listener
}
class SpinnerIntroductionFragment implements ISpinnerIntroductionView {
binding: FragmentSpinnerIntroScreenBinding
listener: Listener
public SpinnerIntroductionFragment(Context, Listener)
onCreateView(LayoutInflater, ViewGroup, Bundle): View
onViewCreated(View, Bundle): void
}
```

# Minigame Sequence Diagrams
There are four minigames throughout the game. They are each the same except for the first minigame. For the first minigame, the tutorial is shown, and for the remaining minigames, the tutorial is optional and can be viewed but does not have to be.
For brevity of the Main Sequence Diagram below, the Minigame Sequence Diagrams are here.
Where [minigame 1] is located within the Main Sequence Diagram, the first minigame is played and the First Minigame Sequence Diagram can be placed at that spot.
Wherever [subsequent minigame] is located within the Main Sequence Diagram, a subsequent minigame is played and the Subsequent Minigame Sequence Diagram can be placed at that spot.

## First Minigame Sequence Diagram
```plantuml
Actor Player as player
Participant "MainActivity" as main
Participant "MainView" as view
Participant "Story" as story
Participant "StoryFragment" as sfrag
Participant "SpinnerInstructionFragment" as instruction
Participant "SpinnerFragment" as spinner
Participant "Jackpot" as jackpot
Participant "Character Object 1" as Character1
Participant "Character Object 2" as Character2

main -> view: displayFragment(SpinnerInstructionFragment)
jackpot -> instruction: addInstructions()
loop page < list.size()?
player -> main: Clicks next button
main -> instruction: onDisplayIntroduction()
end
opt chose Easy
player -> main: Clicks Easy button
main -> spinner: onSetEasy()
end
opt chose Medium
player -> main: Clicks Medium button
main -> spinner: onSetMedium()
end
opt chose Hard
player -> main: Clicks Hard button
main -> spinner: onSetHard()
end
loop Character1.Health > 0 && Character2.Health > 0?
main -> view: displayFragment(SpinnerFragment)
player -> main: Clicks start button
main -> jackpot: onStartingJackpot()
main -> jackpot: startSpin()
player -> main: Clicks stop button
main -> jackpot: onStoppingJackpot()
main -> jackpot: endSpin()
main -> jackpot: callAttack(Character, Character)
jackpot -> Character1: changeSkill(int)
Character1 -> Character2: attack(Character)
Character1 -> Character2: decreaseHealth(int)
Character2 -> Character1: attack(Character)
Character2 -> Character1 : decreaseHealth(int)
main -> view: displayFragment(CombatFragment)
loop page < list.size()?
player -> main: Clicks next button
main -> view: onDisplayAttack()
main -> view: attackDisplay(int, Character, Character)
end
end
```
## Subsequent Minigame Sequence Diagram
```plantuml
Actor Player as player
Participant "MainActivity" as main
Participant "MainView" as view
Participant "Story" as story
Participant "StoryFragment" as sfrag
Participant "SpinnerInstructionFragment" as instruction
Participant "SpinnerFragment" as spinner
Participant "Jackpot" as jackpot
Participant "Character Object 1" as Character1
Participant "Character Object 2" as Character2

opt chose Tutorial
player -> main: Clicks Tutorial button
main -> view: displayFragment(SpinnerInstructionFragment)
jackpot -> instruction: addInstructions()
loop page < list.size()?
player -> main: Clicks next button
main -> instruction: onDisplayIntroduction()
end
end
opt chose Easy
player -> main: Clicks Easy button
main -> spinner: onSetEasy()
end
opt chose Medium
player -> main: Clicks Medium button
main -> spinner: onSetMedium()
end
opt chose Hard
player -> main: Clicks Hard button
main -> spinner: onSetHard()
end
loop Character1.Health > 0 && Character2.Health > 0?
main -> view: displayFragment(SpinnerFragment)
player -> main: Clicks start button
main -> jackpot: onStartingJackpot()
main -> jackpot: startSpin()
player -> main: Clicks stop button
main -> jackpot: onStoppingJackpot()
main -> jackpot: endSpin()
main -> jackpot: callAttack(Character, Character)
jackpot -> Character1: changeSkill(int)
Character1 -> Character2: attack(Character)
Character1 -> Character2: decreaseHealth(int)
Character2 -> Character1: attack(Character)
Character2 -> Character1 : decreaseHealth(int)
main -> view: displayFragment(CombatFragment)
loop page < list.size()?
player -> main: Clicks next button
main -> view: onDisplayAttack()
main -> view: attackDisplay(int, Character, Character)
end
end
```
# Main Sequence Diagram
```plantuml
Actor Player as player
Participant "MainActivity" as main
Participant "MainView" as view
Participant "Story" as story
Participant "StoryFragment" as sfrag
Participant "SpinnerInstructionFragment" as instruction
Participant "SpinnerFragment" as spinner
Participant "Jackpot" as jackpot
Participant "Character Object 1" as Character1
Participant "Character Object 2" as Character2

main -> view: displayFragment(StartFragment)
player -> main: Clicks start button
main -> view: displayFragment(StoryFragment)
story -> sfrag: introduction()
loop page < list.size()?
player -> main: Clicks next button
main -> sfrag: onNextDisplay()
end
main -> view: [minigame 1]
main -> view: onDisplayFragment(storyFragment)
story -> sfrag: gorge(boolean)
loop page < list.size()?
player -> main: Clicks next button
main -> sfrag: onNextDisplay()
end
main -> view: [subsequent minigame]
story -> sfrag: routeSet(int, int, boolean)
loop page < list.size()?
player -> main: Clicks next button
main -> sfrag: onNextDisplay()
end
main -> view: [subsequent minigame]
main -> view: displayFragment(StoryFragment)
opt route = 1
story -> sfrag: route1_2(boolean)
end
opt route = 2
story -> sfrag: route2_2(boolean)
end
loop page < list.size()?
player -> main: Clicks next button
main -> sfrag: onNextDisplay()
end
main -> view: [subsequent minigame]
opt route = 1
opt player won
story -> sfrag: ending1b()
end
opt player lost
story -> sfrag: ending1a()
end
end
opt route = 2
opt player won
story -> sfrag: ending2()
main -> view: displayFragment(StoryFragment)
loop page < list.size()?
player -> main: Clicks next button
main -> sfrag: onNextDisplay()
end
opt a_count > b_count
story -> sfrag: ending2a()
end
opt b_count > a_count
story -> sfrag: ending2b()
end
end
opt player lost
story -> sfrag: ending3()
end
end
main -> view: displayFragment(StoryFragment)
loop page < list.size()?
player -> main: Clicks next button
main -> sfrag: onNextDisplay()
end
main -> view: displayFragment(EndFragment)
```


