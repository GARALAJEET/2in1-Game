import java.util.*;

class User {
    String fullName;
    String birthday;
    String GameId;
    String password;
    int gameCoin;
    int game1_coin = 0;
    int game2_coin = 0;
    int game1_score = 0;
    int game2_score = 0;

    User(String fullName, String birthday, String GameId, String password) {
        this.fullName = fullName;
        this.birthday = birthday;
        this.GameId = GameId;
        this.password = password;
        this.gameCoin = 100;
    }

    void show() {
        System.out.println("**********DETAILS*********");
        System.out.println("FULL NAME: " + fullName);
        System.out.println("BIRTHDAY: " + birthday);
        System.out.println("GAME I'D: " + GameId);
        System.out.println("gameCoin " + gameCoin);
        System.out.println("PASSWORD IS NAME+BIRTH YEAR(YYYY).");
        System.out.println("***************************");
    }
}

public class Project {
    User user_list[] = new User[10000];
    int count = 0;
    int demo = 0;
    String name;

    public User userVerify(String GameId, String password) {
        for (int i = 0; i < count; i++) {
            if (user_list[i].GameId.equals(GameId) && user_list[i].password.equals(password)) {
                return user_list[i];
            }
        }
        return null;
    }

    public void getLoginDetails(String full_name, String dob) {
        for (int i = 0; i < count; i++) {
            if (user_list[i].fullName.equals(full_name) && user_list[i].birthday.equals(dob)) {
                user_list[i].show();
                return;
            }
        }
        System.out.println("user not found");
        return;
    }

    public void login() {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter your name:");
        String fullName = sc.nextLine();
        // System.out.print("enter your birthday (DD/MM/YYYY)");
        // String birthday = sc.nextLine();
        String ar[] = fullName.split(" ");
        name = ar[0];
         boolean birth_condition = true;
        int DD = 0;
        int MM = 0;
        int YYYY = 0;
        String  dd=null;
        String  yyyy=null;
        String birthday=null;
        // while (birth_condition) {
        //     System.out.println("Enter birthday date (DD/MM/YYYY):");
        //      birthday = sc.nextLine();
        //     String[] arr = birthday.split("/");
        //     dd=arr[0];
        //     yyyy=arr[2];
        //     if (arr.length == 3) {
        //         try {
        //             DD = Integer.parseInt(ar[0]);
        //             MM = Integer.parseInt(ar[1]);
        //             YYYY = Integer.parseInt(ar[2]);
        //             if (DD > 0 && DD < 32 && MM > 0 && MM < 13 && YYYY > 0 && YYYY < 2025) {
        //                 birth_condition = false;
        //             }
        //              else
        //               {
        //                 System.out.println("Invalid date. Please enter again.");
        //              }
        //         } 
        //         catch (NumberFormatException e) 
        //         {
        //             System.out.println("Invalid input format. Please enter again.");
        //         }
        //     } 
        //     else {
        //         System.out.println("Invalid input format. Please enter again.");
        //     }
        // }
        // boolean birth_condition = true;
        // int DD = 0;
        // int MM = 0;
        // int YYYY = 0;

        while (birth_condition) {
            System.out.println("Enter birthday date (DD/MM/YYYY):");
             birthday = sc.nextLine();
            String[] arr1 = birthday.split("/");
            if (arr1.length == 3) {
                try {
                    DD = Integer.parseInt(arr1[0]);
                    dd=arr1[0];
                    yyyy=arr1[2];
                    MM = Integer.parseInt(arr1[1]);
                    YYYY = Integer.parseInt(arr1[2]);
                    if (DD > 0 && DD < 32 && MM > 0 && MM < 13 && YYYY > 0 && YYYY < 2025) {
                        birth_condition = false;
                    } else {
                        System.out.println("Invalid date. Please enter again.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input format. Please enter again.");
                }
            } else {
                System.out.println("Invalid input format. Please enter again.");
            }
        }

       if(!birth_condition){
        System.out.println("yes");
       }
       else{
        System.out.print("no");
       }

        // sc.close();
        // if(!birth_condition){
        //     System.out.println("yes");
        // }
        // else{
        //     System.out.println("no");
        // }

        // String ar1[] = birthday.split("/");
        // GameId=name+birth-date(DD);
        String GameId = ar[0] + dd;
        // System.out.println(GameId);
        // password=name+birth-year(YYYY);
        String password = ar[0] +yyyy;
        // System.out.println(password);
        User user = new User(fullName, birthday, GameId, password);
        user_list[count] = user;
        demo++;
        count++;
    }

    public void guessTheNumber(Project s2) {
        Scanner sc = new Scanner(System.in);
        System.out.println("# INSTRUCTION FOR GAME NAME GUESS THE NUMBER #");
        System.out.println(
                "-> In This game you guess right number in 5 attempt if  you can do it you got 20 game coin.");
        System.out.println(
                "-> In this game, you will receive the some hints for each attempt number.\n-> When attempting the first plate number, you can get one hint by exchanging 1 game coin.\n -> For the second and third attempts, you can get two hints by exchanging 2 game coins.");
        System.out.println("->To participate in this game, you must pay an entry fee of 10 game coins. Good luck!");
        System.out.println("-> for payment enter gameId and password.");
        System.out.println(" enter GAMEI'D.");
        String gameid_ans = sc.nextLine();
        System.out.println("enter password.");
        String password_ans = sc.nextLine();
        User currlyLoginUse = userVerify(gameid_ans, password_ans);
        if (currlyLoginUse != null) {
            System.out.println("payment done");
            game_child(currlyLoginUse);
        } else {
            System.out.println("-->GameI'D and password is wrong go to check GameI'D and password");
            System.out.println("-->TO CHEACK DETAILS ");
            s2.show();
        }
    }

    void game_child(User currlyLoginUse1) {
        Scanner sc = new Scanner(System.in);
        currlyLoginUse1.gameCoin = currlyLoginUse1.gameCoin - 10;
        int winPrize = 20;
        Random ra = new Random();
        // Scanner sc=new Scanner(System.in);
        int n = ra.nextInt(91) + 9;
        // System.out.print(n);
        // to check given number is odd or even
        System.out.println("There are few to hints to guess the number.");
        if (n % 2 == 0) {
            System.out.println("Given number is even number.");
        } else {
            System.out.println("Given number is odd number");
        }
        // to check prime number or not
        int temp = 0;
        for (int i = 1; i < n; i++) {
            if (n % i == 0) {
                temp++;
            }
        }
        if (temp == 2) {
            System.out.println("Given number is a prime number.");
        } else {
            System.out.println("Given number is not a prime number.");
        }
        // to check how many digit in the number.
        int temp1 = n;
        int digit = 0;
        while (temp1 > 0) {
            digit++;
            temp1 = temp1 / 10;
        }
        System.out.println("This number has " + digit + " digit");
        int i = 1;
        while (i <= 5) {
            System.out.println("enter your ans");
            int ans = sc.nextInt();

            if (ans == n) {
                System.out.println("congratuelations ! you guess corrct number.");
                System.out.println("your final prize is " + winPrize + " gameCoin");
                currlyLoginUse1.game1_score++;
                currlyLoginUse1.gameCoin = currlyLoginUse1.gameCoin + winPrize;
                System.out.println("your TOTAL GameCoin is  " + currlyLoginUse1.gameCoin + " GameCoin");
                currlyLoginUse1.game1_coin = winPrize;
                break;
            } else {
                System.out.println("oops you given wrong ans.");
                System.out.println("remain attempt is:" + (5 - i));
                i++;
                switch (i) {
                    case 2:
                        int temp2 = n;
                        int r;
                        int sum = 0;
                        if (digit == 2) {
                            while (temp2 > 0) {
                                r = temp2 % 10;
                                sum = sum + r;
                                temp2 = temp2 / 10;
                            }
                            System.out.println("Sum of given number digit is: " + sum);
                            winPrize = winPrize - 1;
                        }
                        break;
                    case 3:
                        int temp3 = n;
                        int r1, r2;
                        r1 = temp3 % 10;
                        temp3 = temp3 / 10;
                        r2 = temp3 % 10;
                        System.out.println("Subraction of given number digit is: " + (r2 - r1));
                        winPrize = winPrize - 2;
                        break;
                    case 4:
                        int temp4 = n;
                        int multi = 1;
                        int r4;
                        while (temp4 > 0) {
                            r4 = temp4 % 10;
                            multi = multi * r4;
                            temp4 = temp4 / 10;
                        }
                        System.out.println("multiplication of given number digit is: " + multi);
                        winPrize = winPrize - 2;
                        break;
                    case 5:
                        System.out.println("last try to win this game.");
                        break;
                    default:
                        System.out.println("better luck next time");
                        System.out.println("ANS WAS " + n);
                        System.out.println("your TOTAL GameCoin is" + currlyLoginUse1.gameCoin);
                        break;
                }
            }
        }
    }

    void show() {
        Scanner sc = new Scanner(System.in);
        System.out.println(" FOR YOUR LOGIN DETATILS");
        System.out.println("enter your name:");
        String full_name = sc.nextLine();
        System.out.println("enter your DOB(DD/MM/YYYY):");
        String dob = sc.nextLine();
        getLoginDetails(full_name, dob);
    }

    void game2() {
        Scanner sc = new Scanner(System.in);
        Random ra = new Random();
        System.out.println("ENTER FEE OF THIS GAME IS 5 GAME COIN.");
        System.out.println("FOR PAYMENT ");
        System.out.println(" enter GAMEI'D.");
        String gameid_ans = sc.nextLine();
        System.out.println("enter password.");
        String password_ans = sc.nextLine();
        User currlyLoginUse = userVerify(gameid_ans, password_ans);
        if (currlyLoginUse != null) {
            System.out.println("payment done");
            currlyLoginUse.gameCoin = currlyLoginUse.gameCoin - 5;
            System.out.println("instruction");
            System.out.println(
                    "The winner of this 5 round match will be determined by whoever wins the most rounds. The player who achieves the most victories will come out on top and win the game. Good luck to both players!This match 5 round match who win maximum match this one win this game");
            System.out.println(
                    "u and computer playing this game \n" + "0 for rock\n" + "1 for paper\n" + "2 for scissor\n"
                            + "let's start game");
            int playercount = 0;
            int computercount = 0;
            int draw = 0;
            int p_point = 0;
            for (int i = 1; i <= 5; i++) {
                System.out.println("select your weapon");
                int user_weapon = sc.nextInt();
                int computer_weapon = ra.nextInt(3);
                System.out.println("computer selected his weapon\n" + computer_weapon);
                if (user_weapon == 0 && computer_weapon == 0) {
                    System.out.println("draw");
                    draw++;
                } else if (user_weapon == 0 && computer_weapon == 1) {
                    System.out.println("computer is winner");
                    p_point = 0;
                    computercount++;
                } else if (user_weapon == 0 && computer_weapon == 2) {
                    System.out.println(currlyLoginUse.fullName + " is winner");
                    p_point++;
                    currlyLoginUse.gameCoin++;
                    currlyLoginUse.game2_coin++;
                    playercount++;
                } else if (user_weapon == 1 && computer_weapon == 0) {
                    System.out.println(currlyLoginUse.fullName + " is winner");
                    p_point++;
                    currlyLoginUse.gameCoin++;
                    currlyLoginUse.game2_coin++;
                    playercount++;
                } else if (user_weapon == 1 && computer_weapon == 1) {
                    System.out.println("draw");
                    p_point = 0;
                    draw++;
                } else if (user_weapon == 1 && computer_weapon == 2) {
                    System.out.println("computer is winner");
                    p_point = 0;
                    computercount++;
                } else if (user_weapon == 2 && computer_weapon == 2) {
                    System.out.println("draw");
                    p_point = 0;
                    draw++;
                } else if (user_weapon == 2 && computer_weapon == 1) {
                    System.out.println(currlyLoginUse.fullName + " is winner");
                    p_point++;
                    currlyLoginUse.gameCoin++;
                    currlyLoginUse.game2_coin++;
                    playercount++;
                } else if (user_weapon == 2 && computer_weapon == 0) {
                    System.out.println(" computer is winner");
                    computercount++;
                }
            }
            System.out.println("Score board");
            System.out.println("computer Score " + computercount);
            System.out.println(currlyLoginUse.fullName + "'s" + " Score " + playercount);
            System.out.println("draw Score" + draw);
            if (computercount < playercount) {
                System.out.println("winner is " + currlyLoginUse.fullName);
                currlyLoginUse.game2_score++;
            } else if (computercount > playercount) {
                System.out.println("winner is computer");
            } else {
                System.out.println("draw Match" + draw);
            }
            if (p_point == 3) {
                currlyLoginUse.gameCoin = currlyLoginUse.gameCoin + 3;
                currlyLoginUse.game1_coin = currlyLoginUse.game2_coin + 3;
                System.out.println("Final gamecoin is  " + currlyLoginUse.gameCoin);
            }
        } else {
            System.out.println("worng  useri'd or password");
        }
    }

    public void scoer_board() {

        for (int i = 0; i < demo; i++) {
            System.out.println((i + 1) + "." + "USER I'D\t:" + user_list[i].GameId + "        ");
            System.out.println("  USER GAME1 WINNIHG MATCH :" + user_list[i].game1_score);
            System.out.println("  USER GAME2 WINNIG MATCH :" + user_list[i].game2_score);
            System.out.println("  USER GAME1 WINNING GAMECOIN:" + user_list[i].game1_coin);
            System.out.println("  USER GAME2 WINNING GAMECOIN:" + user_list[i].game2_coin);
            System.out.println("  " + "USER TOTAL GAME COIN :" + user_list[i].gameCoin);
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("### WELLCOME TO GAME ###");
        Project s1 = new Project();
        while (true) {
            System.out.println("1.TO PLAY GAME CREATE YOUR GAME PROFILE.");
            System.out.println("2.FOR VIEW LOGIN  DETAILS.");
            System.out.println("3.TO PLAY 1ST GAME NAME GUESS THE NUMBER.");
            System.out.println("4.TO PLAY 2ND GAME NAME ROCK PAPER SCISSOR");
            System.out.println("5.TO VIEW SCORE BOARD");
            System.out.println("6.TO EXIT GAME");
            int a = sc.nextInt();
            switch (a) {
                case 1:
                    // To Rigistration
                    s1.login();
                    System.out.println("Rigistration completed");
                    System.out.println("-> enter 2 to go to next step");
                    break;
                case 2:
                    // diplay your id pass
                    s1.show();
                    break;
                case 3:
                    // 1st game
                    s1.guessTheNumber(s1);
                    break;
                case 4:
                    // 2nd game
                    s1.game2();
                    break;
                case 5:
                    s1.scoer_board();
                    break;
                case 6:
                    break;
                default:
                    System.out.println("chose from 1 to 6");
                    break;
            }
            if (a == 6) {
                break;
            }
        }
    }
}
