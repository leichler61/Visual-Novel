# Next Iteration Specification : Elaboration Phase 1
## Criticality

The most critical aspect of the game is the minigame, which serves as a tutorial for the boss battle. The minigame is the most actual gameplay the player engages in other than picking dialogue options.

In terms of business value, the minigame is one of the most valuable aspects of the game, as it is gameplay and would hopefully engage the player and incentivize them to keep playing the game. The minigame is also the point of plot divergence, and the player's skill at the minigame would determine which storyline and which ending they get, increasing the game's replayability.

## Coverage

Almost all of the game's systems are affected by the minigame. Introductory dialogue and overall premise are not affected by the minigame, but statistic levels, dialogue and plot events following the minigame, and the ending of the game are all dependent on the results of the minigame. If the minigame does not work correctly, we have no mechanic to determine skill level, meaning we have no variable to check in order to split the plot into its divergent paths. Additionally, without the minigame, the only actual gameplay is in picking dialogue options, greatly limiting the player's interaction with the game.

## Risk

The minigame should not be too technically complex. We will use a random number generator to create the jackpot mechanic and decide which numbers and/or symbols are the target. The most technical complexity will lie in the movement of the symbols in the "slot machine". Our project is entirely feasible, as the mechanic is simple and easily replicable. There is some uncertainty regarding usability, as the game may be difficult for users to play if they have difficulty with vision or identifying symbols. We may have to color-code them or include a sound associated with the jackpot to make the game more accessible and easier to understand.

# Next Iteration Specification : Elaboration Phase 2

# Criticality

The next important aspect of the game after the minigame is the dialogue, especially the dialogue that will lead to the minigame. Thus, the training scene & dialogue that leads to the first minigame will be the next iteration we will work on. This will determine whether we are able to implement the context surrounding the minigame(s) and call the minigame at the appropriate time for the story.

The dialogue is a major aspect of the game and the primary method of conveying the story of the game to the player. The dialogue of the first training scene leading up to the minigame, specifically, serves to introduce the minigame, which is the main gameplay aspect of the game. This dialogue is important to set up the in-story reasons for the minigame as well as to explain the rules and mechanics of the minigame to the player so they are able to play the game. These instructions are particularly important, as the training minigame serves as a tutorial for the boss battle later on. We need to be able to accurately and completely teach the user how to play the minigame so they are able to play the game again in the context of the boss battle later.

# Coverage

This dialogue impacts the player's understanding of the minigame, the rest of the game's story, and the boss battle. Its usefulness directly impacts the player's ability to play and enjoyment of the minigame, which will be repeated multiple times throughout the game. Additionally, how engaging and understandable the dialogue is will determine how interested and engaged the player is in the game, how much they are able to follow the story, and how much they enjoy the game overall.

# Risk

The dialogue risks driving the user away or decreasing their interest in the game if they do not care about story-based games, games with a lot of dialogue, or the particular storytelling present in our game. Thus, it needs to be not too long, but still descriptive and understandable. It also needs to be interesting enough to engage people and neutral enough so as to appeal to the largest amount of people possible.

The dialogue itself should not be too technically complex. We will write the dialogue ourselves and include it in the game via print and if statements. There are a few dialogue options for the player to choose from, but there are not many resulting branching paths of dialogue or story from their choices. The most major result from dialogue options is at the ending of the game, which we are not yet implementing. Dialogue in the training scene does not have much of an impact on the overall game.

This section of our project is feasible and not too large. To make it as usable as possible, we will implement a function in which the player is able to click the screen to progress the dialogue instead of the dialogue changing on a time-based schedule, so the player is able to read it at their own pace and move on when they are ready. Additionally, we will attempt to make the text as large and readable as possible.

# Next Iteration Specification : Elaboration Phase 3

# Criticality
Though we failed to implement the story as much as we'd like to in this iteration due to the complexity of reimplementing the jackpot minigame in Android Studio, we now have the fragments set up and are ready to implement in the next iteration.
We hope that along with dialogue, we will input images. If time allows, we will input music. If even more time allows, we will input animations. We have prioritized the components that directly impact the gaming experience, and have decided to forgo some things like a saving functionality and too many dialogue choices. This is to ensure we have time for the critical aspects of our game.
Story is critical because our game is based on story and dialogue.
Music is critical because without it, there aren't many 'changes' to the still image of the game, which would make going through the dialogue very boring and less engaging.
Adding animation to the minigame would be a big step in making the game look more professional and engage the player further.
The save function is important for us to practice as students, but not specifically for this game. The game should not be very long, and the best experience would likely be achieved by playing it through in one sitting, so as to remember the dialogue choices and story events that have come before.

# Coverage
The story and the minigame are the most important aspects of our game. Once this next iteration is complete, the game will be very close to done, excluding details. The story is a major part of any story-based game.
The story covers the entire game. While it does not affect the usability of the minigame, it puts the minigame into context of a larger and more interesting experience of a game. The story also affects the player's ability to affect gameplay by choosing dialogue options and thus having multiple endings to experience.
Once the images, lines, and sound effects are in place, the game is 'complete', and we'll be free to add more refined details (such as saving and loading, if time allows).

# Risk
The next iteration should not be any more technologically complex than this iteration, as we will implement the Story similarly to our Model-View-Controller architecture for displaying things to the user. The implementation of the story is entirely feasible, but our additional details are less so.
We decided to make some changes to the script to shorten the workload and decrease the ambition of our project. We hope that the dialogue and the story experience will still be meaningful to the player.
We may not have images for every scene that we would like to, so there's a risk of the background and background changes being less interesting.
We are thinking of composing our own music for the app, but we are uncertain if time will allow this. Without it, the game would likely be more boring.
As we near the final product, it will grow increasingly obvious whether this game is a fun one or not, which is the biggest risk of all for any game-makers.
In a lot of games, there is also the ability to backtrack and a history of the dialogue; by choosing not to implement these, we also risk the ease of navigating the game.
These can all be easier to implement once the main story and its branching pathways are all typed out and implemented.




