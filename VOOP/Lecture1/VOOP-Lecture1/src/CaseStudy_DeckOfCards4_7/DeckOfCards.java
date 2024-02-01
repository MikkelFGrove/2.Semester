package CaseStudy_DeckOfCards4_7;

public class DeckOfCards {
    public static void main(String[] args) {
        int[] deck = new int[52];

        for (int i = 0; i < deck.length; i++){
            deck[i] = i;
        }
        displayDeck(shuffleDeck(deck));
    }

    public static int[] shuffleDeck(int[] deck){
        int[] tempDeck = new int[52];
        boolean[] used = new boolean[52];

        for (int i: deck){
            while (true){
                int rand = (int)(Math.random() * 52);
                boolean num = false;

                for (int j = 0; j < used.length; j++) {
                    if (!used[rand]){
                        num = true;
                    }
                }

                if (num){
                    tempDeck[i] = rand;
                    used[rand] = true;
                    break;
                }
            }
        }
        return tempDeck;
    }

    public static void displayDeck(int[] deck){
        int[] cards = new int[8];
        int num = 0;
        for (int i = 0; i < cards.length; i += 2) {
            cards[i] = deck[num]%13;
            cards[i+1] = deck[num]/13;
            num++;
        }
        int j = 0;
        for (int i = 0; i < cards.length; i += 2) {
            j++;
            System.out.print("Your card " + (j) + " is ");
            if (cards[i] < 10 && cards[i] > 0){
                System.out.print((i+1));
            } else if (cards[i] == 0) {
                System.out.print("an Ace ");
            } else {
                switch (cards[i]){
                    case 10:
                        System.out.print("a Jack ");
                        break;

                    case 11:
                        System.out.print("a Queen");
                        break;

                    case 12:
                        System.out.print("a King");
                        break;
                }
            }

            System.out.print(" of type ");
            switch (cards[i+1]){
                case 0:
                    System.out.println("spade");
                    break;
                case 1:
                    System.out.println("heart");
                    break;
                case 2:
                    System.out.println("diamonds");
                    break;
                case 3:
                    System.out.println("club");
                    break;
            }
        }

    }
}
