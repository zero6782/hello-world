package sales;

import java.util.Scanner;   
 
public class TotalSales {
    static final int THIRTY_ONE = 31;
    static final int TWO = 2, THREE = 3, FOUR = 4, FIVE = 5, SIX = 6;
    //assume one month is 31days
    public static void main (final String[] args) {
        final Scanner sc = new Scanner (System.in);
        final double[][] sales;
        sales = new double[FIVE][SIX];
        //personnum is a salesperson number
        //productnum is a product number
        int personnum = 0, productnum = 0;
        //taking inputs
        System.out.println("Notice - Enter -1 if"
                + " there is no more salesperson on that day: ");
        while (personnum != -1) {
            System.out.print("Enter the salesperson number(1 to 4): ");
            personnum = sc.nextInt() - 1;
            if (personnum == -TWO) {
                System.out.print("Terminating ");
                break;
            }
            System.out.print("Enter the product number(1 to 5): ");
            productnum = sc.nextInt() - 1;
            System.out.print("Enter the total dollar value of"
                        + " that product sold that day : ");
            if (personnum < FOUR && personnum >= 0) {
                sales[personnum][productnum] += sc.nextDouble();
            } else {
                System.out.println("\nInput error!");
            }
        }
        sc.close();
        for (int k = 0; k < FOUR; k++) {
            for (int l = 0; l < FIVE; l++) {
                //this is a total products sold by that person
                sales[k][FIVE] += sales[k][l];
                //this is a total value of the sold products
                sales[FOUR][l] += sales[k][l];
            }
            //this is an entire value
            sales[FOUR][FIVE] += sales[k][FIVE];
        }
        //this is an interface using for loops (optional)
 
        /*
        System.out.println("      1     2     3     4     5     Total");
        for (int k = 0; k < FIVE; k++) {
            //this "if else" is an interface
            if (k == FOUR) {
                System.out.print("Total ");
            } else {
            System.out.print(k + 1);
            }
            for (int l = 0; l < FIVE; l++) {
                if (k == FOUR) {
                    System.out.print(sales[FOUR][l] + "     ");
                } else {
                    System.out.print("     " + sales[k][l]);
                }
            }
            //print total value if k is FOUR
            if (k < FOUR) {
            System.out.print("     " + sales[k][FIVE] + "\n");
            } else {
                System.out.print(sales[FOUR][FIVE] + "\n");
            }
        }
        */
 
        //this is an interface using printf functions (required to reduce Npath)
        //and also to make a clear organized table
        System.out.println("The result of products sold on this month:");
        System.out.printf("%-8s %-8d %-8d %-8d %-8d %-8d %-8s\n", "     ",
                1, 2, THREE, FOUR, FIVE, "Total");
        System.out.printf("%-8d %-8.2f %-8.2f %-8.2f %-8.2f %-8.2f %-8.2f\n", 1,
                sales[0][0], sales[0][1], sales[0][2], sales[0][THREE],
                sales[0][FOUR], sales[0][FIVE]);
        System.out.printf("%-8d %-8.2f %-8.2f %-8.2f %-8.2f %-8.2f %-8.2f\n", 2,
                sales[1][0], sales[1][1], sales[1][2], sales[1][THREE],
                sales[1][FOUR], sales[1][FIVE]);
        System.out.printf("%-8d %-8.2f %-8.2f %-8.2f %-8.2f %-8.2f %-8.2f\n",
                THREE, sales[2][0], sales[2][1], sales[2][2], sales[2][THREE],
                sales[2][FOUR], sales[2][FIVE]);
        System.out.printf("%-8d %-8.2f %-8.2f %-8.2f %-8.2f %-8.2f %-8.2f\n", FOUR,
                sales[THREE][0], sales[THREE][1], sales[THREE][2], sales[THREE][THREE],
                sales[THREE][FOUR], sales[THREE][FIVE]);
        System.out.printf("%-8s %-8.2f %-8.2f %-8.2f %-8.2f %-8.2f %-8.2f\n", "Total",
                sales[FOUR][0], sales[FOUR][1], sales[FOUR][2], sales[FOUR][THREE],
                sales[FOUR][FOUR], sales[FOUR][FIVE]);
    }
}
