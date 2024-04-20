import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String direction;

        // Rooms
        String northRoom = "gold key";
        String southRoom = "silver key";
        String eastRoom = "short sword";
        boolean base = true;
        ArrayList<String> inventory = new ArrayList<>();
        boolean dragonCompanion = false;

        // Introduction
        System.out.println("You find yourself in a room, lit by a faint glow. Before you there are 4 rooms, each in one of the cardinal directions. North, South, East, West.");
        System.out.println("Which door will you take?");

        // Game Loop
        while (true) {
            direction = scanner.nextLine().toLowerCase();

            if (direction.equals("north")) {
                System.out.println("You find yourself in a room adorned with gold. On a large barrel lies a gold key.");
                inventory.add("gold key");
            } else if (direction.equals("south")) {
                System.out.println("You find yourself in a room completely covered in silver. On a small counter lies a silver key.");
                inventory.add("silver key");
            } else if (direction.equals("east")) {
                System.out.println("You enter a room filled with weapons. You find a short sword.");
                inventory.add("short sword");
            } else if (direction.equals("west")) {
                System.out.println("You enter a dark room. You can barely see anything.");

                // Encounter with Skeleton King
                System.out.println("Suddenly, a Skeleton King emerges from the darkness!");
                System.out.println("Prepare for battle!");

                // Simulate a simple battle
                int playerHealth = 100;
                int skeletonHealth = 50;
                while (playerHealth > 0 && skeletonHealth > 0) {
                    System.out.println("Your Health: " + playerHealth);
                    System.out.println("Skeleton King's Health: " + skeletonHealth);
                    System.out.println("1. Attack");
                    System.out.println("2. Defend");
                    System.out.print("Choose your action: ");

                    String action = scanner.nextLine();
                    if (action.equals("1")) {
                        // Player attacks
                        int damage = (int) (Math.random() * 20) + 10; // Random damage between 10 and 30
                        skeletonHealth -= damage;
                        System.out.println("You attack the Skeleton King and deal " + damage + " damage!");
                    } else if (action.equals("2")) {
                        // Player defends, reducing Skeleton King's potential damage
                        int defense = (int) (Math.random() * 10) + 5; // Random defense between 5 and 15
                        playerHealth += defense;
                        System.out.println("You defend against the Skeleton King's attack and heal " + defense + " health!");
                    } else {
                        System.out.println("Invalid action. Try again.");
                        continue;
                    }

                    // Skeleton King attacks
                    int skeletonDamage = (int) (Math.random() * 15) + 10; // Random damage between 10 and 25
                    playerHealth -= skeletonDamage;
                    System.out.println("The Skeleton King attacks you and deals " + skeletonDamage + " damage!");

                    // Check if someone is defeated
                    if (playerHealth <= 0) {
                        System.out.println("You have been defeated by the Skeleton King. Game Over!");
                        return;
                    } else if (skeletonHealth <= 0) {
                        System.out.println("You have defeated the Skeleton King!");
                        inventory.add("Skeleton King's Crown");
                        break;
                    }
                }

                // After defeating Skeleton King
                System.out.println("With the Skeleton King defeated, you find the 'Skeleton King's Crown'!");
                System.out.println("As you pick up the crown, a bright light envelops you.");

                // Ending - Transported to Overworld
                System.out.println("You open your eyes and find yourself in the lush, green overworld.");
                System.out.println("The air is fresh, and you breathe deeply for the first time in what feels like forever.");
                System.out.println("Congratulations! You have completed your adventure!");

                // End the game
                return;
            } else {
                System.out.println("Invalid direction. Choose again.");
                continue;
            }

            // Display inventory
            System.out.println("Inventory: " + inventory);

            // Secret Room with Baby Dragon
            if (inventory.contains("gold key") && !dragonCompanion) {
                System.out.println("You enter a hidden room with a warm glow.");
                System.out.println("In the center, you find a baby dragon, wounded and scared.");
                System.out.println("Will you help the baby dragon? (yes/no)");

                String helpDragon = scanner.nextLine().toLowerCase();
                if (helpDragon.equals("yes")) {
                    System.out.println("You offer your help to the baby dragon, tending to its wounds and soothing its fears.");
                    System.out.println("The baby dragon looks up at you with gratitude and determination.");
                    System.out.println("Congratulations! The baby dragon is now your loyal companion.");
                    dragonCompanion = true;
                } else {
                    System.out.println("You decide not to help the baby dragon and leave the room.");
                }
            }

            // Secret Room with Cool Blue Orb
            if (inventory.contains("silver key")) {
                System.out.println("You use the silver key to unlock a hidden room.");
                System.out.println("Inside, you find a pedestal with a glowing cool blue orb.");
                System.out.println("You feel a mysterious power emanating from the orb.");
                inventory.add("cool blue orb");
            }

            // Ponder the Cool Blue Orb
            if (inventory.contains("cool blue orb")) {
                System.out.println("You take out the cool blue orb from your inventory and ponder its mysterious glow.");
                System.out.println("The orb feels cold to the touch, yet it seems to pulse with energy.");
                System.out.println("You can sense ancient magic within it, but its true purpose eludes you.");
                System.out.println("You put the orb back into your inventory.");

                // Remove the orb from inventory after pondering
                inventory.remove("cool blue orb");
            }

            // Ask for next direction
            System.out.println("Which door will you take next? (or 'quit' to end)");

            // Check if player wants to quit
            String nextMove = scanner.nextLine().toLowerCase();
            if (nextMove.equals("quit")) {
                System.out.println("Exiting the game. Goodbye!");
                break;
            }
        }

        scanner.close();
    }
}
