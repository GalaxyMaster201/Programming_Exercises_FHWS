package de.fhws.programming_exercises.lesson_12.src.exercise_3;

// to more easily explain the relationships between nodes I will use the terms "parent" and "child"/"children"
// children are the .left and .right Nodes of the parent Node

public class Tree{
    // TODO - Get rid of the hardcoded start node
    private static final String forbiddenName = "oOo";
    private static final Node root = new Node(forbiddenName, "root of the dictionary");


    private static Node oldCursor;
    private static Node cursor;

    /**
     * Inserts a new node with specified attributes into the correct place in the dictionary.
     *
     * @param word       name of the node
     * @param definition definition of the word
     */
    public static void insert(String word, String definition){
        resetCursor();

        while (true){
            if (word.compareToIgnoreCase(oldCursor.getWord()) < 0){     // new word to the left
                cursor = oldCursor.left;
                if (cursor == null){
                    oldCursor.left = new Node(word, definition);
                    return;
                }
            } else{                                                     // new word to the right
                cursor = oldCursor.right;
                if (cursor == null){
                    oldCursor.right = new Node(word, definition);
                    return;
                }
            }
            oldCursor = cursor;
        }
    }

    /**
     * Resets both of the cursors back to the root
     */
    private static void resetCursor(){
        oldCursor = root;
        cursor = root;
    }

    /**
     * Prints the whole dictionary
     */
    public static void print(){
        resetCursor();
        System.out.println("-".repeat(200));
        printNode(root);
    }


    /**
     * Prints the name and definition of each node through a recursive process
     *
     * @param node the currently selected node
     */
    private static void printNode(Node node){
        if (node == null){
            return;
        }

        printNode(node.left);       // go to the leftmost node

        if (!forbiddenName.equalsIgnoreCase(node.getWord())){
            System.out.printf("Word: %s %n", node.getWord());               // print name
            System.out.printf("Definition: %s %n%n", node.getDefinition()); // and definition
        }

        printNode(node.right);  // switch to the next node
    }

    /**
     * Searches the dictionary for a node with the specified name.
     *
     * @param word name of the node
     * @return the Node with the specified name or null if entry not in tree
     */
    public static Node search(String word){

        resetCursor();

        while (cursor != null){
            if (word.compareToIgnoreCase(oldCursor.getWord()) < 0){     // navigate the tree from root
                cursor = oldCursor.left;
            } else{
                cursor = oldCursor.right;
            }

            if (cursor == null || word.equalsIgnoreCase(cursor.getWord())){       // word found
                break;
            }

            oldCursor = cursor;
        }
        return cursor;
    }

    /**
     * Deletes a word from the dictionary and "reconnects" the remaining nodes accordingly.
     *
     * @param word word to delete
     * @return false - delete failed, true - delete successful
     */
    public static boolean delete(String word){

        if (forbiddenName.equalsIgnoreCase(word)){      // user want to delete the root node
            System.out.println("No.....Just no");
            return false;
        }

        if (search(word) == null){          // user wants to delete a word which is not in the dictionary
            return false;
        }

        // LEFT SIDE
        if (cursor == oldCursor.left){          // the selected node is to the left of it's parent

            if (cursor.left == null && cursor.right == null){       // word has no children, delete only
                oldCursor.left = null;
                return true;
            }

            if (cursor.right != null){
                oldCursor.left = cursor.right;
                oldCursor.left.left = cursor.left;
            } else{
                oldCursor.left = cursor.left;   // the selected node doesn't have any children to its right, bypass only
            }
        }

        // RIGHT SIDE
        if (cursor == oldCursor.right){         // the selected node is to the right of it's parent

            if (cursor.left == null && cursor.right == null){       // word has no children, delete only
                oldCursor.right = null;
                return true;
            }

            if (cursor.left != null){
                oldCursor.right = cursor.left;
                oldCursor.right.right = cursor.right;
            } else{
                oldCursor.right = cursor.right; // the selected node doesn't have children to its left, bypass only
            }


        }

        return true;
    }
}
