
Because the Jackpot minigame contains time-based elements, a traditional test would be difficult. 
Instead, we used print statements throughout the program to verify the state of the jackpot at each point in time.
Critically, the RandomSymbols, TargetSymbol, and HitSymbol variables were printed. 
We made sure a new list of RandomSymbols is being generated each time the jackpot minigame is run and that the TargetSymbol is always taken from the RandomSymbols list.

For the timer, we used LocalDateTime class, printing out the local time at the start and end of the process to ensure that time elapsed during the process. 
There were errors during testing where the start time automatically updated to the current time when while-loops were employed in the Jackpot class, thus we removed the while-loop and put it instead in the Main class.
The SecondsElapsed variable allows us to see that the jackpot is iterating through the RandomSymbols list every 3 seconds (verifiable by checking the hit symbol against the seconds elapsed).

At the end of each Jackpot session, calculations of 'health' and 'skill' are done with our character classes initiated using the Jackpot callAttack() method, simulating the characters in-game dealing damage to each other. 
The jackpot loops until one party's health reaches 0, thus completing the minigame.

# Terminal Transcript 

## Win Case

Welcome to a minigame!
To attack your opponent, you will need to play the jackpot...
...and hit the target!
<Stop the spinning jackpot at the right time to land on the intended target.>

Jackpot Spins!
Symbols rotate every 3 seconds.
This is the list of random symbols:
[e, 7, g, f, e, l, @, $, l, d]
Target Symbol: e
Starting Time: 2023-10-24T09:40:59.918150
Press s + Enter to stop the spin.


Ending Time: 2023-10-24T09:41:02.032987
Seconds Elapsed: 2
Hit Symbol: e
Hit!

MC now has a skill level of 15.
MC attacked Enemy with skill 15!
Enemy now has -5 health!


You won!

Process finished with exit code 0

## Lose Case

Welcome to a minigame!
To attack your opponent, you will need to play the jackpot...
...and hit the target!
<Stop the spinning jackpot at the right time to land on the intended target.>

Jackpot Spins!
Symbols rotate every 3 seconds.
This is the list of random symbols:
[x, (, w, l, [, ѝ, <, w, ^, :]
Target Symbol: ѝ
Starting Time: 2023-10-24T10:08:12.737666
Press s + Enter to stop the spin.
s
Ending Time: 2023-10-24T10:08:35.349970
Time Elapsed: 22
Hit Symbol: w
Miss!

MC now has a skill level of 5.
MC attacked Enemy with skill 5!
Enemy now has 5 health!

Enemy now has a skill level of 15.
Enemy attacked MC with skill 15!
MC now has -5 health!


You lost!

Process finished with exit code 0



