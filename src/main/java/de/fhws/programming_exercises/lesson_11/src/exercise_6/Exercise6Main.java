package de.fhws.programming_exercises.lesson_11.src.exercise_6;

public class Exercise6Main{
    public static void main(String[] args){
        String[] text = {
                "Hello there!",
                "",
                "My name is Matija.",
                "I love programming!",
                "I don't want to do it anymore.",
                "This exercise is very confusing."};

        Document document = new Document(text);

        formattedPrint(document);

        switchRows(document);

        firstInsert(document);

        secondInsert(document);

    }

    /**
     * Prints the formatted version of the "document" text
     *
     * @param document Document
     */
    private static void formattedPrint(Document document){
        String spacer = createSpacer(document.getMaxWidth());
        System.out.println(spacer);
        document.print();
        System.out.println(spacer);
        System.out.printf("=> This document has %d characters %n", document.countCharacters());
        System.out.println();
    }

    /**
     * Prints the document after switching 2 rows
     *
     * @param document Document
     */
    private static void switchRows(Document document){
        document.switchRows(4, 5);
        formattedPrint(document);
    }

    /**
     * Prints the document after inserting one row to the end
     *
     * @param document Document
     */
    private static void firstInsert(Document document){
        String[] insert1 = {
                "But I have to, and hopefully it works out :)"
        };
        document.insertDocument(insert1, 5);
        formattedPrint(document);
    }

    /**
     * Prints the document after inserting 2 rows in the middle
     *
     * @param document Document
     */
    private static void secondInsert(Document document){
        String[] insert2 = {
                "But sometimes you come upon an interesting problem.",
                "Like today, for example."};
        document.insertDocument(insert2, 3);
        formattedPrint(document);
    }

    /**
     * Creates a spacer (to visualize a page) from the longest row
     *
     * @param maxWidth length of the longest row
     * @return a series of -'s as a spacer
     */
    private static String createSpacer(int maxWidth){
        String spacer;
        spacer = "-".repeat(maxWidth);
        return spacer;
    }
}