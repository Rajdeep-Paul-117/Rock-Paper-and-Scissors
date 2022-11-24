package com.example.rockpaperscissors.service;

import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class GameServiceImpl implements GameService {

    private Boolean validMove(String userMove)
    {
        if(!userMove.equals("rock")
        &&!userMove.equals("scissors")
        &&!userMove.equals("paper"))
            return false;
        return true;
    }
    public String getComputerMove()
    {
        Random random = new Random();
        int input = random.nextInt(3)+1;
        if (input == 1)
            return "rock";
        else if(input == 2)
            return "paper";
        return "scissors";
    }
    private String getResult(String userMove,String computerMove)
    {
        if (userMove.equals(computerMove))
            return "Game is Tie";      
      else if (userMove.equals("rock"))
        return computerMove.equals("paper") ? "Computer Wins": "You won";   
      else if (userMove.equals("paper"))
        return computerMove.equals("scissors") ? "Computer Wins": "You won";   
      else
        return computerMove.equals("rock") ? "Computer Wins": "You won";   
    }
 
    @Override
    public String Play(String userMove) {
        userMove.toLowerCase();
        System.out.println("User entered " +userMove);
        if(!validMove(userMove))
        {
            System.out.println("Invalid Move "+userMove);
            return "Enter a Valid Move";
        }

        String computerMove=getComputerMove();
        System.out.println("Computer choosed "+computerMove);
        return getResult(userMove,computerMove);
    }
    
}
