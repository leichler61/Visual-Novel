# CMPU-203 F23 - Team 1F

# 1st Iteration Prototype

## Functionalities
Our first iteration prototype implements a jackpot mechanic that uses the LocalDateTime class to calculate the time that has passed in seconds, and then uses this to determine how many symbols in the jackpot symbol list to iterate through, effectively 'spinning' a jackpot.
When players press any button, the jackpot stops spinning, the time that passed in seconds is calculated, and then transformed into an index to in the array of random symbols.
After determining whether the player hit or missed the target symbol, the amount of damage done is calculated from the character's skill level and applied to the other character's health.

## Limitations/Simplifying Assumptions
The player is unable to see the jackpot spin live, but can count the seconds that pass to determine which symbol the jackpot has landed on. as the prototype iterates through the list of random symbol every three seconds.
There may be some more UI interaction limitations due to us not yet plugging it into a more robust platform (i.e lack of buttons), but this should work perfectly.

## How to Run
Run Main.java to start running the prototype. The Main class serves as the controller for our project thus far, and contains the main() method. To operate the prototype, follow the instructions printed to the terminal.

# 2nd Iteration Prototype

## Functionalities
We now have transferred our first iteration from IntelliJ to Android Studio a fully functioning spinner with aesthetically designed UI. The start and stop buttons start and stop the spin, respectively, and the start button disappears after pressing so the spinner can only be started once. The spinning and target symbols continue to function from our previous iteration.
We changed the timer function from the LocalDateTime class to the CountDownTimer class. This allowed us to display a new symbol after every determined duration of time using the onTick() method. It also allowed us to start the timer with the start button and implement a time limit on the amount of time the jackpot spins. 
Before the minigame is played, we display instructions for the player. 
After the minigame is played, we display the results of the changes to the characters' health and skill statistics. The minigame is played again and these changes are displayed again until one of the characters runs out of health. Then, the player is told whether they won or lost.
An image file was uploaded for the background of our combat screen in preparation for the rest of the visual novel, which we hope will continue many background and character images.
We have utilized Lists to iterate through long dialogue, and have uploaded all of our story dialogue into Lists (seperated by sections of the story, so that the appropriate methods may be called to update the appropriate pathway of the story) so we can quickly complete the main story functions and move on to additional details, such as images and sound. This is part of our next iteration; we just wanted to get ahead.

## Limitations/Simplifying Assumptions
Due to the sync time of the CountDownTimer, there are times when the SpinningSymbol (now called DisplaySymbol) appears to jump a bit, but this effect is not too extreme. We can also change the speed of the spinner in the future if we so choose. We are currently keeping at a relatively slow speed for ease of testing different outcomes, but we may increase the speed later to increase the tension, engagement, and interest in the minigame.
We still need to connect the spinner minigame to the story, and there are no solid mechanisms for altering the backdrop of our minigame fragments as the minigame is called at different points of the game.
We may have to increase the size of the UI, as it currently may be proportionally small on a phone.
The spinner minigame also requires a certain speed of reaction that may not be possible for every player. The spinning symbols may also be hard to read.


## How to Run
Currently, you run our game in Android Studio. After running the program, Click the next button to progress text. Click the start and stop buttons to start and stop the spinning of the jackpot, respectively.


# Final Minimum Viable Product

## Functionalities
We have, in one semester, completed an RPG visual novel with five different possible endings, all completed with images, music, sound, and interface. We have implemented the final version of the jackpot minigame that is used as the main combat mechanism throughout the game, and the results for the game are varied enough that interesting outcomes are possible. The symbols generated through the jackpot are random and there are three different difficulty levels that affect how fast the jackpot spins, adding to the fun and variability of the game. The first two story events are fixed, and then depending on the player's skill in the minigames, the story can take one of two routes. These routes all have their own unique boss battles and endings. We added dialogue choice capabilites for one of the endings, allowing the player to chose what to say and having their choices affect which ending they get.

## Limitations/Simplifying Assumptions
Because of the ambition of our project and the scope of implementation, this game unfortunately needs to be finished in one sitting and your progress cannot be saved or loaded (I would like to say this is an intentional homage to the old time games when things couldn't be saved). There is no app interface to turn off sound or change the volume, so this would have to be done directly via one's phone. Because of the varying routes of the plot, it is hard to have Android Espresso play through the game by clicking the same amount of times each time.

## How to Run
Simply start the app, click Start, then let the world of Anadeia take you away.