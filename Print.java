import java.util.Scanner;
import java.util.Random;

public class Print{
    
    char printType;
	String subType;
	char press;
	int l;
    
    
    public Print() {
	printType = ' ';
	subType = "";

}

public Print(char type, int[] track) {
	printType = type;
	l = track[2];
	press = ' ';
}

//variable = print type = # in array
//m = menu = 0
//l = league = 1
//h = help = 2
//e = exit

//for printing the main menu 
public void print(Print[] opt)
{
	//main menu
	int menuOption, helpOption;
	menuOption = 0;
	helpOption = 0;
	char exitOption;
	exitOption = ' ';
	Scanner sc = new Scanner(System.in);
	
	do {
		if (printType == 'm')
		{
			System.out.print( "[Main Menu]\n" );
			System.out.print( "1) Help\n" );
      //System.out.print( "2) Check Stats\n" );
			System.out.print( "2) Exit Game\n" );
			System.out.print( "3) Return to Game\n\n" );

			do {
				System.out.print( "Choose an option: " );
				menuOption = sc.nextInt();
				System.out.println();
			} while (menuOption != 1 && menuOption != 2 && menuOption != 3);

			//help menu
			if (menuOption == 1)
			{
				System.out.println ("[Help]\n");
				System.out.println ("What do you need help with?\n");
				System.out.println ("1) Rules\n");
				System.out.println ("2) Fighting\n");
				do {
					System.out.println ("Choose an option: ");
					helpOption = sc.nextInt();
					System.out.println ("-------------------------------------------------------------------------------------------\n\n");
				} while (helpOption != 1 && helpOption != 2);

				switch (helpOption) {
				case 1:
					opt[2].print(opt, "rules");
					break;
				case 2:
					//start fighting tutorial
					 Scanner input = new Scanner(System.in);
        Random rand = new Random();
        Charachter tut = new Charachter("Player");
        Charachter tute = new Charachter("Tutorial");
        System.out.println("[Tutorial Fight]");
        System.out.println(   "        |||||||||                                                    |||||||||                                                                                         \n" +
                "        | _   _ |                                                    | _   _ |                                                                                \n" +
                "       (  ' _ '  )                                                  (  ' _ '  )                                                                                   \n" +
                "        |  ___  |                                                    |  ___  |                                       \n" +
                "         |_____|                                                      |_____|                                    \n" +
                "  _______/     \\_______                                        _______/     \\_______                                    \n" +
                " /                     \\                                      /                     \\                                                                                  \n" +
                "|   |\\             /|   |                                    |   |\\             /|   |                                               \n" +
                "|   ||  .       .  ||   |          __      _______           |   ||  .       .  ||   |                                           \n" +
                "|   / \\           / \\   |          \\ \\    / / ____|          |   / \\           / \\   |                                                                                     \n" +
                "\\  |   | |_ | _| |   |  /           \\ \\  / / (___            \\  |   | |_ | _| |   |  /                                                                                     \n" +
                "|==|   | |_ | _| |   |==|            \\ \\/ / \\___ \\           |==|   | |_ | _| |   |==|                                                                                 \n" +
                "/  /_ _|_|__|__|_|_ _\\  \\             \\  /  ____) |          /  /_ _|_|__|__|_|_ _\\  \\                                                                               \n" +
                "|___| /            \\|___|              \\/  |_____(_)         |___| /            \\|___|                                                                               \n" +
                "      |     |      |                                               |     |      |                                                                              \n" +
                "      |     |      |                                               |     |      |                                                                       \n" +
                "      |PLA  |   PLA|                                               |TUT  |   TUT|                                                                 \n" +
                "      |     |      |                                               |     |      |                                                                    \n" +
                "      \"|\"\"|\"\"\"|\"\"|\"\"                                               \"|\"\"|\"\"\"|\"\"|\"\"                                                                   \n" +
                "       |  |   |  |      -Player-                                    |  |   |  |      -Tutorial Enemy-                                                                   \n" +
                "       |  |   |  |                                                  |  |   |  |                                                                      \n" +
                "      /   )   (   \\                                                /   )   (   \\                                                                     \n" +
                "     Ooooo     ooooO                                              Ooooo     ooooO                                                               \n" +
                "\n");
        System.out.println("Player Health: " + tut.getPlayerHealth() + "            Opponents Health: " + tute.getPlayerHealth());
        boolean end = false;
        do {

            System.out.println("Options: ");
            System.out.println("1)Hit \n2)Dodge\n3)Rest");
            int pc = input.nextInt();
            int oc = (int)(Math.random()*(4-1)) + 1;
            System.out.println(oc);

            if(pc == 1 && oc == 1)
            {
                System.out.println("Both Hit!");
                tut.getHit(tute.getPlayerDamage());
                tute.getHit(tut.getPlayerDamage());
                System.out.println("Player Health: " + tut.getPlayerHealth() + "            Opponents Health: " + tute.getPlayerHealth());
            }
            else if(pc == 1 && oc == 2)
            {
                System.out.println("Opponent dodged your attack and countered!");
                tut.getHit(tute.getPlayerDamage());
                System.out.println("Player Health: " + tut.getPlayerHealth() + "            Opponents Health: " + tute.getPlayerHealth());
            }
            else if(pc == 1 && oc == 3)
            {
                System.out.println("You Hit while opponent was resting!");
                tute.getHit(tut.getPlayerDamage());
                System.out.println("Player Health: " + tut.getPlayerHealth() + "            Opponents Health: " + tute.getPlayerHealth());
            }
            else if(pc == 2 && oc == 1)
            {
                System.out.println("You dodged your opponents attack and countered!");
                tute.getHit(tut.getPlayerDamage());
                System.out.println("Player Health: " + tut.getPlayerHealth() + "            Opponents Health: " + tute.getPlayerHealth());
            }
            else if(pc == 2 && oc == 2 )
            {
                System.out.println("Both Dodged!");
                System.out.println("Player Health: " + tut.getPlayerHealth() + "            Opponents Health: " + tute.getPlayerHealth());
            }
            else if(pc == 2 && oc == 3)
            {
                System.out.println("Opponent Rested!");
                tute.rest();
                System.out.println("Player Health: " + tut.getPlayerHealth() + "            Opponents Health: " + tute.getPlayerHealth());
            }
            else if(pc == 3 && oc == 1)
            {
                System.out.println("Opponent Hit while you were resting!");
                tut.getHit(tute.getPlayerDamage());
                System.out.println("Player Health: " + tut.getPlayerHealth() + "            Opponents Health: " + tute.getPlayerHealth());
            }
            else if(pc == 3 && oc == 2)
            {
                System.out.println("You Rested!");
                tut.rest();
                System.out.println("Player Health: " + tut.getPlayerHealth() + "            Opponents Health: " + tute.getPlayerHealth());
            }
            else if(pc == 3 && oc == 3)
            {
                System.out.println("Both Rested");
                tut.rest();
                tute.rest();
                System.out.println("Player Health: " + tut.getPlayerHealth() + "            Opponents Health: " + tute.getPlayerHealth());
            }



            if(tut.getPlayerHealth() <= 0)
            {
                System.out.println("You got Knocked Out");
                System.out.println("Tutorial Over");
                end = true;
                break;
            }
            if(tute.getPlayerHealth() <= 0)
            {
                System.out.println("You win");
                end = true;
                break;
            }

        }while(end == false);
    }
//end tutorial
        
					break;
				}
      }

		 if (menuOption == 2)
			{
				System.out.println ("[Exit Game]\n");
				do {
					System.out.println ("Are you sure you want to exit? (Y/N)\n");
					exitOption = sc.next().charAt(0);
				} while (exitOption != 'Y' && exitOption != 'N');

				switch (exitOption) {
				case 'Y':
					System.out.println ("Goodbye!\n");
					System.exit(0);
				case 'N':
					break;
				}
				System.out.println ("-------------------------------------------------------------------------------------------\n\n");

			}
  
			//return to game
			else if (menuOption == 3) {
			}
    
	} while (menuOption != 3);
}


//enter to continue or main menu
public void enter(Print[] opt)
{
	Scanner sc = new Scanner(System.in);
	do {
		System.out.print( "\nPress enter to continue\n");
		System.out.print( "Press m for the main menu\n");
		System.out.print( "-------------------------------------------------------------------------------------------\n");
		String temp = sc.nextLine();
		if (temp != null && temp.length() > 0)
			press = temp.charAt(0);
		else
			press = '\n';

		if (press == '\n') {
			press = 'm';
		}
		else if (press == 'm') {
			System.out.println();
			opt[0].print(opt);
		}
	} while (press != '\n' && press != 'm');
}


//for printing rules
public void print(Print[] opt, String subType)
{
	if (printType == 'h' && subType == "rules") {
		System.out.println ("Help - Fight Club Rules:\n");
		System.out.println ("Welcome to the World's Largest Underground Fight Club, in order to leave a millionaire as promised you will have to understand concepts of INFLATION and COMPOUND INTEREST that will \naffect the money you make during your time here.\n");
promptEnterKey();
    
		System.out.println ("Each fighter is assigned a Fight CLUB BANK ACCOUNT in addition to their PERSONAL BANK \nACCOUNT. All of your upgrades and purchases will come directly out of your personal account \nwhile the money you make in matches will be handled in your Club account.\n");
promptEnterKey();

		System.out.println ("In the Fight Club, there are different LEAGUES that each have different requirements, costs, and challenges.\n");
		System.out.println ("Each league will have 8 MATCHES and a certain number of WINS needed to move on to the next \nleague. As you progress, you will have less room for error as the amount of wins needed will \nget closer to 8.\n");
promptEnterKey();

		System.out.println ("Each league has an ENTRY FEE, and a LEAGUE WIN PERCENT of your personal account that is \nawarded as a fraction of this percentage after each win.\n");
promptEnterKey();

		System.out.println ("For example, if the league has a percent of 20% and 4 wins are needed to win the league, 5% \nof the amount that was in your personal account at\n");
		System.out.println ("the start of the league (or the PRINCIPAL amount) will be deposited into your CLUB ACCOUNT \nafter each win. This is practically SIMPLE INTEREST.\n");
		System.out.println ("However, during WIN STREAKS, this same percentage will be deposited, however the percentage \nwill be taken from your PERSONAL account PRINCIPAL \n");
		System.out.println ("balance plus the amount you have earned in your fight CLUB ACCOUNT. Thus, creating a system \nof COMPOUND INTEREST, where you are earning interest on earned interest.\n");
promptEnterKey();

		System.out.println ("In order to keep the World's Largest Underground Fight Club up and running, the owners have \nestablished a tax per match during your time here. I mean the bills aren't going to pay \nthemselves...\n");
		System.out.println ("Due to this, each league has a certain INFLATION RATE that is applied to your PERSONAL \naccount following each match, win or lose.\n");
promptEnterKey();

		System.out.println ("Obviously you came here to make money so the inflation rate isn't going to be that large as \nlong as you keep winning and you should be able to overcome it with your matches.\n");
		System.out.println ("However, after each loss in a league, the inflation rate will INCREASE by a certain percent \n(decided by each league) and during LOSING STREAKS, this inflation will be applied to both \nthe balance in your PERSONAL account as well as your CLUB account.\n");
promptEnterKey();

		System.out.println ("As mentioned, the money in your CLUB ACCOUNT is transferred to your PERSONAL ACCOUNT whether \nyou win or lose the league.\n");
		System.out.println ("If you win the league, you will be promoted to the next league where you can visit the new \nleagues ITEM SHOP prior to paying the ENTRY FEE. The amount remaining after the entry fee is \npaid is the PRINCIPAL amount for interest.\n");

promptEnterKey();

		System.out.println ("If you lose the league, you will have to try again and enter the league as if it is a new \none. You can visit the item shop again if there are any more items remaining that haven't \nbeen purchased.\n");
promptEnterKey();

		System.out.println ("If you end up losing more money to inflation than you gain from interest and can no longer \nafford the entry fee, your time at the Fight Club is over and you lose the game.\n");
promptEnterKey();

		System.out.println ("*Note that enemies will be getting stronger and item prices and entry fees are increasing as \nyou progress through the leagues, so you should aim to leave each league with as much money \nas you possibly can.\n");
		System.out.println ("Good luck!\n");

		opt[0].enter(opt);
	}
}


//for printing league information
public void print(Print[] opt, String subType, League[] lev, Bank[] acc, boolean[] res, int[] track)
{
	l = track[2];
	Scanner sc = new Scanner(System.in);
	//league intro
	if (printType == 'l' && subType == "intro")
	{
		//leagueWon = false
		res[3] = false;
    track[0] = 0;
		track[1] = 0;
    res[0] = false;
    res[1] = false;
    res[2] = false;
    
		System.out.println ("Welcome to the " + lev[l].get_name() + "!\n");
		System.out.println ("The entry fee for this league is $" + lev[l].get_entryFee());
		System.out.println ("You currently have $" + acc[0].get_balance() + " available in your personal account\n");

    //ends game if can't pay entry fee
		if (lev[l].get_entryFee() > acc[0].get_balance()) {
			System.out.println ("You do not have enough to pay the entry fee...\n");
			System.out.println ("GAME OVER\n");
			System.exit(0);
		}
    
		System.out.println ("\nPress enter to pay the entry fee\n");
		System.out.println ("-------------------------------------------------------------------------------------------\n");
		sc.nextLine();

		acc[0].set_balance('w', lev[l].get_entryFee());
		System.out.println ("New Personal Balance: $" + acc[0].get_balance());
	}

	//league info
	if (printType == 'l' && subType == "info")
	{
		acc[0].set_principal();
		System.out.println ("Here is the informaton for the " + lev[l].get_name() + ":\n");
		System.out.println ("Matches: " + lev[l].get_numMatches());
		System.out.println ("Wins Needed: " + lev[l].get_winsNeeded());

		System.out.println ("League Win Percentage Reward: " + lev[l].get_leaguePct() + "%");
		System.out.println ("Percent Paid Per Win: " + lev[l].get_winPct() + "%");
		System.out.println ("Your personal account's principal: $" + acc[0].get_principal());
		System.out.println ("Percent personal balance lost after each match to inflation: " + lev[l].get_matchInflationPct() + "%");
		System.out.println ("Percent-Increase on inflation per loss: " + lev[l].get_inflationPctAdded() + "%");


		opt[0].enter(opt);
	}

	//league end
	if (printType == 'l' && subType == "end")
	{
		System.out.println ("The " + lev[l].get_name() + " has concluded.\n");

		if (res[3] == false) {
			System.out.println ("You did not beat the league, therefore you will have to try the " + lev[l].get_name() + " again.");
		}
		else if (res[3] == true) {
			System.out.println ("You beat the " + lev[l].get_name() + " and are now moving on to the " + lev[l+1].get_name() + ".");
		}

		System.out.println ("All money in your club account will now be transferred into your personal account:\n");

		acc[0].set_balance('d', (int) acc[1].get_balance());
		System.out.println ("New Personal Balance: $" + acc[0].get_balance());

    //move to next league or end game
			if (track[2] != 5) {
				track[2] += 1;
			}
			else {
				System.out.println ("You have beat the game, congrats!\n");
				System.exit(0);
			}
    
		opt[0].enter(opt);
	}


	//league post match
	if (printType == 'l' && subType == "postMatch")
	{
    System.out.println();
    
		//won league
		if (track[1] == lev[l].get_winsNeeded())
		{
			res[3] = true;
			System.out.println ("Congratulations! You have won " + lev[l].get_winsNeeded() + " matches and beat the " + lev[l].get_name() + "!\n");

			lev[l].set_winDeposit(acc);
			lev[l].set_streakDeposit(acc);
			lev[l].set_postMatchWithdraw(acc);
			lev[l].set_streakClubWithdraw(acc, res);

			System.out.println (lev[l].get_matchInflationPct() + "% of your personal account has been withdrawn");
      if (res[1] == false){
			System.out.println ("$" + lev[l].get_winDeposit() + " has been deposited into your club account\n");
        }
       else {
			System.out.println ("$" + lev[l].get_streakDeposit() + " has been deposited into your club account\n");
        }
      
			acc[0].set_balance(lev, track, res);
			System.out.println ("New Personal Balance: $" + acc[0].get_balance());

			acc[1].set_balance(lev, track, res);
			System.out.println ("New Club Balance: $" + acc[1].get_balance());

			opt[0].enter(opt);
		}

		//won match with no streak
		else if (res[0] == true && res[1] == false)
		{
			System.out.println ("Congrats on the win!");
			System.out.println ("You now have " + track[1] + "/" + lev[l].get_winsNeeded() + " wins needed to beat the league.");
			System.out.println ("There are " + (lev[l].get_numMatches() - track[0]) + " matches remaining.\n");

			lev[l].set_winDeposit(acc);
			lev[l].set_streakDeposit(acc);
			lev[l].set_postMatchWithdraw(acc);
			lev[l].set_streakClubWithdraw(acc, res);

			System.out.println (lev[l].get_matchInflationPct() + "% of your personal account has been withdrawn due to inflation.");
			System.out.println ("$" + lev[l].get_winDeposit() + " has been deposited into your club account for the win.\n");

			acc[0].set_balance(lev, track, res);
			System.out.println ("New Personal Balance: $" + acc[0].get_balance());

			acc[1].set_balance(lev, track, res);
			System.out.println ("New Club Balance: $" + acc[1].get_balance());

			opt[0].enter(opt);
		}

		//won match with streak
		else if (res[0] == true && res[1] == true)
		{
			System.out.println ("Congrats on the win!");
			System.out.println ("You now have " + track[1] + "/" + lev[l].get_winsNeeded() + " wins needed to beat the league.");
			System.out.println ("There are " + (lev[l].get_numMatches() - track[0]) + " matches remaining.\n" );
			System.out.println ("You're on a win streak!");
			System.out.println ("Your club balance will be added to your personal account's principal for the " + lev[l].get_winPct() + "% win deposit\n");

			lev[l].set_winDeposit(acc);
			lev[l].set_streakDeposit(acc);
			lev[l].set_postMatchWithdraw(acc);
			lev[l].set_streakClubWithdraw(acc, res);

			System.out.println ("\n" + lev[l].get_matchInflationPct() + "% of your personal account has been withdrawn");
			System.out.println ("$" + lev[l].get_streakDeposit() + " has been deposited into your club account\n");

			acc[0].set_balance(lev, track, res);
			System.out.println ("New Personal Balance: $" + acc[0].get_balance());

			acc[1].set_balance(lev, track, res);
			System.out.println ("New Club Balance: $" + acc[1].get_balance());

			opt[0].enter(opt);
		}

		//lose match no streak
		else if (res[0] == false && res[2] == false)
		{
			System.out.println ("You lost the match! Bummer...");
			System.out.println ("You have " + track[1] + "/" + lev[l].get_winsNeeded() + " wins needed to beat the league.");
			System.out.println ("There are " + (lev[l].get_numMatches() - track[0]) + " matches remaining.\n");

			lev[l].set_inflationPctAdded();
			lev[l].set_matchInflationPct();
			System.out.println (lev[l].get_inflationPctAdded() + "% has been added to the inflation on your personal account and is now " + lev[l].get_matchInflationPct() + "%");

			System.out.println (lev[l].get_matchInflationPct() + "% of your personal account has been withdrawn\n" );

			lev[l].set_winDeposit(acc);
			lev[l].set_streakDeposit(acc);
			lev[l].set_postMatchWithdraw(acc);
			lev[l].set_streakClubWithdraw(acc, res);

			acc[0].set_balance(lev, track, res);
			System.out.println ("New Personal Balance: $" + acc[1].get_balance());

			acc[0].set_balance(lev, track, res);
			System.out.println ("New Club Balance: $" + acc[1].get_balance());

			opt[0].enter(opt);
		}


		//lose match with streak
		else if (res[0] == false && res[2] == true)
		{
		System.out.println ("You lost the match! Bummer...");
		System.out.println ("You have " + track[1] + "/" + lev[l].get_winsNeeded() + " wins needed to beat the league.");
		System.out.println ("There are " + (lev[l].get_numMatches() - track[0]) + " matches remaining.\n");

		lev[l].set_inflationPctAdded();
		lev[l].set_matchInflationPct();

		lev[l].set_winDeposit(acc);
		lev[l].set_streakDeposit(acc);
		lev[l].set_postMatchWithdraw(acc);
		lev[l].set_streakClubWithdraw(acc, res);

		System.out.println (lev[l].get_inflationPctAdded() + "% has been added to the inflation on your personal account and is now " + lev[l].get_matchInflationPct() + "%");
		System.out.println ("This inflation will also be applied to your club account due to the losing streak");
		System.out.println ();

		System.out.println (lev[l].get_matchInflationPct() + "% of your personal account has been withdrawn");
		System.out.println (lev[l].get_matchInflationPct() + "% of your club account has been withdrawn\n");

		acc[0].set_balance(lev, track, res);
		System.out.println ("New Personal Balance: $" + acc[0].get_balance());

		acc[1].set_balance(lev, track, res);
		System.out.println ("New Club Balance: $" + acc[1].get_balance());

		opt[0].enter(opt);
		}
	}
}

public void promptEnterKey(){
   System.out.println("\nPress \"ENTER\" to continue...");
   Scanner scanner = new Scanner(System.in);
   scanner.nextLine();
  System.out.println();
}
  
}