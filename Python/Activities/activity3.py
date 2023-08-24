player1 = input("Enter first player name")
player2 = input("enter 2nd player name")

selection1 = str(input(player1 + "choose anyone option among ROCK,PAPER,SCISSOR").lower())
selection2 = str(input(player2 + "choose anyone option among ROCK,PAPER,SCISSOR").lower())

'''if(selection1 == "scissors"):
    elif(selection2 == "paper"):
        print(player1 + "won the game")
    else:
        print(player2 + " won the match")

if(selection1 == "paper"):
    elif(selection2 == "rock"):
        print(player1 + "won the game")
    else:
        print(player2 + " won the match")


Rock beats scissors
Scissors beats paper
Paper beats rock'''


if selection1 == selection2:
    print("It's a tie!")
elif selection1 == 'rock':
    if selection2 == 'scissors':
        print("Rock wins!")
    else:
        print("Paper wins!")
elif selection1 == 'scissors':
    if selection2 == 'paper':
        print("Scissors win!")
    else:
        print("Rock wins!")
elif selection1 == 'paper':
    if selection2 == 'rock':
        print("Paper wins!")
    else:
        print("Scissors win!")
else:
    print("Invalid input! You have not entered rock, paper or scissors, try again.")