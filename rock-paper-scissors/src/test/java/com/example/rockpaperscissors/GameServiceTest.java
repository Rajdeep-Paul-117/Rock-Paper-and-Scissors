package com.example.rockpaperscissors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.SpyBean;

import com.example.rockpaperscissors.service.GameServiceImpl;

public class GameServiceTest extends RockPaperScissorsApplicationTests {


    @SpyBean  
    private GameServiceImpl gameService;

    @Test
    public void playTest()
    {
        assertEquals("Enter a Valid Move",gameService.Play("ro"));
        
        when(gameService.getComputerMove()).thenReturn("rock");
        assertEquals("Game is Tie",gameService.Play("rock"));
        
        when(gameService.getComputerMove()).thenReturn("scissors");
        assertEquals("You won",gameService.Play("rock"));

        when(gameService.getComputerMove()).thenReturn("scissors");
        assertEquals("Computer Wins",gameService.Play("paper"));

    }
}
