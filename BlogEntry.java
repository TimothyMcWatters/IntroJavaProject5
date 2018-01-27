import java.util.StringTokenizer;

/**
This program reads a blog entry in from a file in the format name, month, day, year, blog text.
It will then check for valid inputs and log each blog input as a seperate object and keep track
of the number of blog entries we have logged.

DEPENDENCIES include Date.java from the book and blog.dat both in the same folder as 
BlogEntry.java and BlogEntryTester.java that are included in this package.

@author Timothy McWatters
@version 1.0

COP2253    Project 5
File Name: BlogEntry.java
File 1 of 2
*/

public class BlogEntry {
   //instance variables
   private static int numOfBlogs = 0;
   private String username = "";
   private Date dateOfBlog = null;
   private String blog = "";
   
   /**
   Constructs the BlogEntry object with default values for instance fields
   */
   public BlogEntry() {
      numOfBlogs += 1;
      username = "";
      dateOfBlog = new Date();
      blog = "";
   } //end of BlogEntry w/ 0 parameters (default)
   
   /**
   Constructs the BlogEntry object with a given username, date and blog info...the rest default values
   @param username: users name
   @param dateOfBlog: date the blog was input
   @param blog: String representation of users blog entry.
   */   
   public BlogEntry(String username, Date dateOfBlog, String blog) {
      numOfBlogs += 1;
      this.username = username;
      this.dateOfBlog = dateOfBlog;
      this.blog = blog;
   } //end of BlogEntry w/ 3 parameters

   /**
   Constructs the BlogEntry object using a Deep Copy of another BlogEntry object.
   @param otherBlogEntry: another BlogEntry object 
   */ 
   public BlogEntry(BlogEntry otherBlogEntry) {
      if (otherBlogEntry == null) {
         System.out.println("Error this is not an a real BlogEntry");
         System.exit(0);
      } else {
         this.username = otherBlogEntry.username;
         this.dateOfBlog = otherBlogEntry.dateOfBlog;
         this.blog = otherBlogEntry.blog;
         numOfBlogs += 1;
      }
   } //end of BlogEntry using deep copy
   
   /**
   Returns the number of blogs
   @return numOfBlogs: the number of blogs
   */   
   public int getNumOfBlogs() {
      return numOfBlogs;
   } // end of getNumOfBlogs method

   /**
   Returns the username of the blogger
   @return username: the username of the blogger
   */   
   public String getUsername() {
      return username;
   } // end of getUsername method

   /**
   Returns the Date of the blog
   @return dateOfBlog: the date of the blog
   */   
   public Date getDateOfBlog() {
      return dateOfBlog;
   } // end of getDateOfBlog method

   /**
   Returns the blog text
   @return blog: the username of the blogger
   */   
   public String getBlog() {
      return blog;
   } // end of getBlog method

   /**
   Sets the instance variable username
   @param username: the username of the blogger
   */   
   public void setUsername(String username) {
      this.username = username;
   } // end of setUsername method

   /**
   Sets the instance variable dateOfBlog
   @param dateOfBlog: the date of the blog
   */   
   public void setDateOfBlog(Date dateOfBlog) {
      this.dateOfBlog = dateOfBlog;
   } // end of setDateOfBlog method

   /**
   Sets the instance variable blog
   @param blog: the text of the blog
   */   
   public void setBlog(String blog) {
      this.blog = blog;
   } // end of setBlog method

   /**
   Returns the summary of the blog
   @return summary: the summary of the blog
   */   
   public String getSummary() {
      String summary = "";
      
      StringTokenizer st = new StringTokenizer(this.getBlog());
      for (int numTokens = 0; numTokens < 10 && st.hasMoreTokens(); numTokens++) {
         summary += st.nextToken() + " ";
      }
      return summary;
   } // end of getSummary method
  
   /**
   Returns the boolean representation of whether two BlogEntry Objects are the same.
   @return true: if the username and date are the same.
   @return false: if the username and date are not the same.
   */   
   public boolean equals(BlogEntry otherBlogEntry) {
      String otherBlogEntryDateString = otherBlogEntry.dateOfBlog.toString();
      if ((this.username.equals(otherBlogEntry.username)) && (this.dateOfBlog.toString().equals(otherBlogEntryDateString))) {
         return true;
      } else {
         return false;
      }
   } // end of equals method

   /**
   Returns the String representation of the BlogEntry's data
   @return String representation of BlogEntry's data
   */   
   public String toString() {
      return String.format("Author: " + getUsername() + "\nDate posted: " + getDateOfBlog() + "\nText body: " + getBlog());
   } // end of toString
   
} // end of Student class