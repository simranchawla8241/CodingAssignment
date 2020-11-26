/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author simranchawla
 */
// Java program to print all palindromic 
// partitions of a given string 
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList; 
import java.util.Deque; 
import java.util.LinkedList; 
import java.util.List;


//backtracking logic
public class CodingAssignment 
{ 
	// Driver program 
	public static void main(String[] args) throws Exception
	{ 
		//String input = "BorrowOrob"; 
                BufferedReader b=new BufferedReader(new InputStreamReader(System.in));
                String input=b.readLine();

		List<List<String>> l=partition(input.toLowerCase()); 
                
                //printing
                System.out.println(l);
	} 
        public static List<List<String>> partition(String s)
        {
            List<List<String>> validDecomposition= new ArrayList<>();
            List<String> currentDecomposition=new ArrayList<>();
            decomposeString(s,0,currentDecomposition,validDecomposition);
            return validDecomposition;
            
        }
         public static void decomposeString(String s,int buildPointer,List<String> currentDecomposition,List<List<String>> validDecomposition)
         {
             if(buildPointer==s.length())
                 validDecomposition.add(new ArrayList<>(currentDecomposition));
             else
             {
                 //go step by step
                 for(int i=buildPointer;i<s.length();i++)
                 {
                     String snippet=s.substring(buildPointer,i+1);
                     //check given piece is palindrome or not
                      if(isPalindrome(snippet))
                      {
                          currentDecomposition.add(snippet);
                          decomposeString(s,i+1,currentDecomposition,validDecomposition);
                          currentDecomposition.remove(currentDecomposition.size()-1);
                          
                      }
                     
                 }
                 
             }
         }
         public static boolean isPalindrome(String s)
         {
             
             int i=0,j=s.length()-1;
             while(i<j)
             {
                 if(s.charAt(i) !=s.charAt(j))
                     return false;
                 i++;
                 j--;
             }
             return true;
         }
        

	
} 

