import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
This program reads a blog entry in from a file in the format name, month, day, year, blog text.
It will then check for valid inputs and log each blog input as a seperate object and keep track
of the number of blog entries we have logged.

DEPENDENCIES include Date.java from the book and blog.dat both in the same folder as 
BlogEntry.java and BlogEntryTester.java that are included in this package.

@author Timothy McWatters
@version 1.0

COP2253    Project 5
File Name: BlogEntryTester.java
File 2 of 2
*/

public class BlogEntryTester {
   public static void main(String[] args) {
      // creates a new instance of the Scanner class to read files in
      Scanner fileIn = null;
      
      try {
         //attempt to open the file 
         fileIn = new Scanner(
            new FileInputStream("blog.dat"));
            //use both a comma (,) and new line (\n) as delimiters
            fileIn.useDelimiter(",|\\n");
      }
      // throws an error and prints a message plus exits if file is not found
      catch (FileNotFoundException e) {
         System.out.println("File not found.");
         System.exit(0);
      }

      //variables
      String username = "";
      int day = 0;
      int month = 0;
      int year = 0;
      String blog = "";
      Date dateOfBlog = null;
      
      //First BlogEntry
      //use default content for the first BlogEntry
      //creates the first instance of the BlogEntry class
      BlogEntry entry1 = new BlogEntry();
      
      //Second BlogEntry     
      //read in content for the second BlogEntry
      username = fileIn.next();
      month = fileIn.nextInt();
      day = fileIn.nextInt();
      year = fileIn.nextInt();
      blog = fileIn.next();
      //creates a instance of the date class to be used in the second BlogEntry object.
      dateOfBlog = new Date(month, day, year);
      //creates the second instance of BlogEntry class
      BlogEntry entry2 = new BlogEntry(username, dateOfBlog, blog);
      
      //third BlogEntry     
      //read in content for the third BlogEntry
      username = fileIn.next();
      month = fileIn.nextInt();
      day = fileIn.nextInt();
      year = fileIn.nextInt();
      blog = fileIn.next();
      //creates a instance of the date class to be used in the third BlogEntry object.
      dateOfBlog = new Date(month, day, year);
      //creates the third instance of BlogEntry class
      BlogEntry entry3 = new BlogEntry(username, dateOfBlog, blog);
      
      //Tests the file input to make sure the user name and date are in the correct format
      //if they are not the correct format print an error message and continue processing the file
      //**** It was recommended to us via the elearning disscusion board that we make the dateOK() method
      //**** public instead of private in the Date class ...  you MUST ensure that you have your dateOK()
      //**** method set to public or this test will NOT work nor will the program compile without errors     
      if ((username.length() > 20) || (!dateOfBlog.dateOK(month, day, year))) {
         System.out.println("Error: I will continue to process the file, however either your username or date are out of normal limits.");
      } 
      
      //fourth BlogEntry     
      //copy in content for the fourth BlogEntry from the second
      //creates the fourth instance of BlogEntry class using the copy constructor and a Deep Copy
      BlogEntry entry4 = new BlogEntry(entry2);
      
      //set entry1's parameters using setter methods
      entry1.setUsername("Timothy A McWatters");
      entry1.setDateOfBlog(new Date(5, 16, 1978));
      entry1.setBlog("I was born today!!!");
      
      //Prints each Blog Entry testing the toString() method and each instance variables accessor method
      System.out.println("Blog Entry 1:");
      System.out.println(entry1.toString());
      System.out.println();
      System.out.println("Blog Entry 2:");
      System.out.println(entry2.toString());
      System.out.println();
      System.out.println("Blog Entry 3:");
      System.out.println(entry3.toString());
      System.out.println();
      System.out.println("Blog Entry 4:");
      System.out.println(entry4.toString());
      
      //Tests the equals() method
      System.out.println();
      //first attempt should be equal
      if (entry2.equals(entry4)) {
         System.out.println("Blog Entry 2 is equal to Entry 4");
      } else {
         System.out.println("Blog Entry 2 is NOT equal to Entry 4");
      }
      //second attempt should be NOT equal
      if (entry1.equals(entry3)) {
         System.out.println("Blog Entry 1 is equal to Entry 3");
      } else {
         System.out.println("Blog Entry 1 is NOT equal to Entry 3");
      }
      
      //prints the summary of a blog entry with more than and less tha 10 words, testing the getSummary() method
      System.out.println();
      System.out.println("Summary of Blog Entry 1 (less than 10 words):");
      System.out.println(entry1.getSummary());
      System.out.println();
      System.out.println("Summary of Blog Entry 3 (more than 10 words):");
      System.out.println(entry3.getSummary());
      
      //prints how many blogs have been entered and tests the getNumOfBlogs() method
      //(since numOfBlogs is static in the BlogEntry class it doesnt matter which instance I use to call it)
      System.out.println();
      System.out.printf("There is a total of %d Blog Entries.", entry1.getNumOfBlogs());
   }
}