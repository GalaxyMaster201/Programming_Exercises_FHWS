package de.fhws.programming_exercises.lesson_12.src.exercise_3;

import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        fillTree();

        //Tree.print();

        char input;
        while (true){
            System.out.println("Please select which action you would like to take: ");
            System.out.println("[I]nsert \n[S]earch \n[D]elete \n[P]rint");
            System.out.println("Choose [X] to terminate the program");
            System.out.print(" --> ");
            input = scanner.nextLine().charAt(0);
            input = Character.toUpperCase(input);

            if (input == 'X'){
                break;
            }

            switch (input){
                case 'I':
                    insertNode(scanner);
                    break;
                case 'S':
                    searchForNode(scanner);
                    break;
                case 'D':
                    deleteNode(scanner);
                    break;

                case 'P':
                    Tree.print();
                    break;

                default:
                    System.out.println("Your input is invalid, please try again");
                    continue;
            }
            // I found the automatic print annoying, uncomment if you want
            //Tree.print();
        }

        scanner.close();
    }

    /**
     * Allows the user to specify the name and definition for the new entry
     *
     * @param scanner Scanner
     */
    private static void insertNode(Scanner scanner){

        System.out.print("Please enter the word which you would like to add: \n --> ");
        String name = scanner.nextLine();

        System.out.print("Please enter the definition for that word: \n --> ");
        String definition = scanner.nextLine();

        Tree.insert(name, definition);
        System.out.println("Insert completed :)\n");

        waitForUser(scanner);
    }

    /**
     * Lets the user input a word they want to see the definition of.
     *
     * @param scanner Scanner
     */
    private static void searchForNode(Scanner scanner){

        System.out.print("Enter the word you want to search for: \n --> ");
        String word = scanner.nextLine();

        Node resultNode = Tree.search(word);    // get the Node from the tree

        if (resultNode != null){
            String definition = resultNode.getDefinition();                             // entry found
            System.out.println("Search completed. Here are the results :) ");
            System.out.println("Word: "+word);
            System.out.println("Definition: "+definition);
        } else{
            System.out.println("Search failed. Entry \""+word+"\" does not exist.");    // entry not found
        }

        waitForUser(scanner);
    }

    private static void deleteNode(Scanner scanner){

        System.out.print("Enter the word you would like to delete: \n --> ");
        String word = scanner.nextLine();

        boolean valid = Tree.delete(word);

        if (!valid){
            System.out.println("Delete failed. Entry \""+word+"\" does not exist.");    // entry not found
        } else{
            System.out.println("Delete completed :)");
        }

        waitForUser(scanner);
    }

    /**
     * Gives the user time to read the output.
     *
     * @param scanner Scanner
     */
    private static void waitForUser(Scanner scanner){
        System.out.println("Press the ENTER key to continue");
        scanner.nextLine();
    }

    /**
     * Fills the tree with some random stuff I googled.
     * Interesting fact: Some trees have no growth ceiling, so they could keep growing indefinitely.
     */
    private static void fillTree(){
        Tree.insert("plant", "An organism that is not an animal, especially an organism capable of photosynthesis. Typically a small or herbaceous organism of this kind, rather than a tree.");

        Tree.insert("branch", "The woody part of a tree arising from the trunk and usually dividing.");

        Tree.insert("leaf", "The usually green and flat organ that represents the most prominent feature of most vegetative plants.");

        Tree.insert("botany", "The scientific study of plants, a branch of biology. Typically those disciplines that involve the whole plant.");

        Tree.insert("trunk", "The usually single, more or less upright part of a tree, between the roots and the branches: the tree trunk.");

        Tree.insert("photosynthesis", "Any process by which plants and other photoautotrophs convert light energy into chemical energy,");

        Tree.insert("tree", "A perennial woody plant, not exactly defined, but differentiated from a shrub by its larger size (typically over a few meters in height) or growth habit, \n\t"+
                "usually having a single (or few) main axis or trunk unbranched for some distance above the ground and a head of branches and foliage.");
    }

}
