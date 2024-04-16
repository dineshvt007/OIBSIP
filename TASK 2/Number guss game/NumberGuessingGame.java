import java.util.*;

class user {

	int limit;
    int points;

    user(){
        limit=10;
        points=0;
    }
	
    void check(int r,int l){
		int i;
		Scanner scan=new Scanner(System.in);
		for(i=limit-1;i>=0;i--) {
			
            System.out.print("\nGuess the number between 1 && "+l+" : ");
            int sc=scan.nextInt();
            if(sc==r){
                System.out.println("Yeah! you found it !") ;
                points++;
				break;
            }
            else if(sc>r){
                System.out.println("you are so high  !!!") ;
				if(i==0)
		   			continue;
                System.out.println ("your's remaining chance : "+i);
            }
            else{
                System.out.println("you are too low !!!" );
				if(i==0)
		   	 		continue;
                System.out.println ("your's remaining chance : "+i);
            }
			
        }	
		System.out.println ("\nGame over !!");
		System.out.println ("\nYour score : "+points);
    } 
 }
class NumberGuessingGame {
	public static void main(String[] args) {

		int choice,rand=0,limits=0,level;
		Random obj= new Random();
		user obj1 = new user();
		Scanner sc=new Scanner(System.in);

		System.out.println("\n\t\tWelcome to Number Guessing Game !!!");
		System.out.println("\nYou have only 10 chances in this game ...!\n");

 		do{

			System.out.println("\nGame level :-\n");
			System.out.println("\t1. Easy \n");
			System.out.println("\t2. Moderate \n");
			System.out.println("\t3. Hard \n");
			System.out.print("Which level would you prefer to play : ");
			level = sc.nextInt();

			if(level == 1){
				rand= obj.nextInt(100);
				limits= 100;
			}
			else if(level == 2){
				rand= obj.nextInt(250);
				limits= 250;
			}
			else if(level == 3){
				rand= obj.nextInt(500);
				limits= 500;
			}
			else{
				System.out.println("Enter the valid level : ");
				level = sc.nextInt();
				if(level == 1){
					rand= obj.nextInt(100);
					limits= 100;
				}
				else if(level == 2){
					rand= obj.nextInt(250);
					limits= 250;
				}
				else if(level == 3){
					rand= obj.nextInt(500);
					limits= 500;
				}
			}
			
			obj1.check(rand,limits);
   			System.out.print("\nDo you like to continue(1/0) : " );
			choice= sc.nextInt();
 	    
    	}while(choice==1);
		
    	System.out.println("\nYour total score : "+obj1.points);
		System.out.println("\nBye ! See you later !!\n");
		sc.close();
	}

    @Override
    public String toString() {
        return "NumberGuessingGame []";
    }
} 