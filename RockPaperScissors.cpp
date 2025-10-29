#include <iostream>
#include <string>
#include <chrono>
#include <cstdlib>
#include <thread>

int main () {
    while (true) { 
        std:: string rps[3] = {"Rock", "Paper", "Scissors"};

        std:: cout << "Choose rock, paper, or scissors:\n";
        std:: string userInput; 
        
        std:: cin >> userInput; 
        
        if (userInput != "rock" && userInput != "scissors" && userInput != "paper") {

            std::cout << userInput << " is not valid. Please Enter a valid input.\n";
            continue;
        }
        
        for (int i = 0; i < 3; i++) {
             std::this_thread::sleep_for(std::chrono::seconds(1));
             std:: cout << ".";
        }
        
        int choice = rand() % 3;
        std:: cout << "\nComputer chose: " << rps[choice] << "\n";
        
        if (userInput == "scissors") {
            if ( rps[choice] == "rock") {
                std::cout << "Loss!";
            }
            else if (rps[choice] == "paper") {
                std::cout << "Win!";
            }
            else {
                std::cout << "Loss!";
            }
        }
        else if (userInput == "paper") {
            if ( rps[choice] == "rock") {
                std::cout << "Win!";
            }
            else if (rps[choice] == "paper") {
                std::cout << "Tie!";
            }
            else {
                std::cout << "Loss!";
            }
        }
        else {
            if ( rps[choice] == "rock") {
                std::cout << "Tie!";
            }
            else if (rps[choice] == "paper") {
                std::cout << "Loss!";
            }
            else {
                std::cout << "Win!";
            }
        }
        
        std::cout << "\nPlay again?\n";
        std::string x;
        std::cin >> x;

        if (x == "no") {
            return false;
        }
    }

    return 0;
}
