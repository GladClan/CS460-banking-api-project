[![Open in Codespaces](https://classroom.github.com/assets/launch-codespace-2972f46106e565e64193e422d61a12cf1da4916b45550586e14ef0a7c637dd04.svg)](https://classroom.github.com/open-in-codespaces?assignment_repo_id=16227828)
# Change for a Dollar Game

This java file will allow the user to input a number of coins, 
which the program will add up and determine if they add up to a
dollar or not.

## Lab Tasks
- Watch [Challenge: Change for a dollar game](
https://www.linkedin.com/learning/java-essential-training-syntax-and-structure-16025610/challenge-change-for-a-dollar-game?resume=false&u=54864305)
on LinkedIn 
- Open ``ChangeForADollarGame.java`` in the ``src/main/java/ChangeForADollarGame`` directory
- Write a program that will ask the user to enter the number of pennies, nickels, dimes, and quarters
- Print out whether the user got exactly one dollar and how much they were off if they did not guess correctly
  - These are templates for what the output should look like:
  - Winning input: ``Yay! That's exactly $1.00! You win!``
  - High input: ``Sorry, you lose! You were over <amount over> cents.``
  - Low input: ``Sorry, you lose! You were under <amount under> cents.``
- Run ``mvn test`` in the terminal to check your work

## Example Runs
### Winning input example
````
Welcome to 'Change for a Dollar'! Your goal is to enter enough change to make exactly $1.00
Enter your number of pennies: 10
Enter your number of nickles: 2
Enter your number of dimes: 3
Enter your number of quarters: 2
Yay! That's exactly $1.00! You win!
````
### High input example
````
Welcome to 'Change for a Dollar'! Your goal is to enter enough change to make exactly $1.00
Enter your number of pennies: 0
Enter your number of nickles: 0
Enter your number of dimes: 5
Enter your number of quarters: 5
Sorry, you lose! You were over 0.75 cents.
````
### Low input example
````
Welcome to 'Change for a Dollar'! Your goal is to enter enough change to make exactly $1.00
Enter your number of pennies: 10
Enter your number of nickles: 2
Enter your number of dimes: 3
Enter your number of quarters: 1
Sorry, you lose! You were under 0.25 cents.
````

## Grading Rubric
- Push to a remote git repository (2 points)
- Get user input for pennies, nickels, dimes, and quarters (3 points)
- Display the correct message for high input (5 points)
- Display the correct message for low input (5 points)
- Display the correct message for winning input (5 points)