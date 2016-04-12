package release;

import java.util.Arrays;

public class LogicalOperators
{
	
	public static void main(String[] args)
	{
		//test the methods
		//boolean[] l_arrOfBol = {false, true, false, false, true, true, 2>4, 2==6, 7<6};
		//boolean[] l_arrOfBol = {true, false, false, false };
		boolean[] l_arrOfBol = {true, true, true, true};
		//boolean[] l_arrOfBol = {true, true, true, false};

		boolean l_result ; 
		
		/*
			String  	l_resultStr = "" ;
			l_resultStr = myTestH02(l_arrOfBol);
			System.out.println( "RESULT from myTestH02() = " + l_resultStr );
		*/
		
		l_result = myConjunctionIter( l_arrOfBol ) ; 
		System.out.println( "RESULT from myConjunctionIter() = " + l_result + "\n");
		

		l_result = myConjunctionRec(l_arrOfBol);
		System.out.println( "RESULT from myConjunctionRec() = " + l_result + "\n" );
		
			
	}

	public static String myTestH02(boolean[] p_arrOfBol)
	{
		String l_result = "" ;
		boolean[] l_arrOfBolOneLessItem ; 
		
		try 
		{
			System.out.println( "length = "  + p_arrOfBol.length );
			System.out.println( "value = "  + p_arrOfBol[0] );
			
			if ( 1 < p_arrOfBol.length )
			{
				System.out.print("p_arrOfBol=");
				System.out.println( Arrays.toString(p_arrOfBol) );
				l_arrOfBolOneLessItem = Arrays.copyOfRange( p_arrOfBol, 1, p_arrOfBol.length);
				
				System.out.print("l_arrOfBolOneLessItem=");
				System.out.println( Arrays.toString( l_arrOfBolOneLessItem ));
				
				l_result = Boolean.toString( p_arrOfBol[0] ) + ", " + myTestH02( l_arrOfBolOneLessItem );
			}
			else
			{
				//System.out.println( "LAST value = "  + p_arrOfBol[0] );
				l_result = Boolean.toString(p_arrOfBol[0] );
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return l_result;
	}
	

	
	//This method takes a boolean array as input, 
	//and returns the conjunction of all of
    //the values in the array using a loop.
	//conjunction: (X1&&X2)&&X3...Xn
	
	
	public static boolean myConjunctionIter(boolean[] p_arrOfBol)
	{
		boolean l_result ;
		int 	l_arrLength = 0 ;
		
		l_arrLength = p_arrOfBol.length;
		System.out.println( "length = "  + l_arrLength );
		l_result = p_arrOfBol[0];
		
		for(int i=1; i< l_arrLength; i++)
		{
			System.out.println( p_arrOfBol[i] );
			System.out.println( "i=" + i );
			l_result = l_result && p_arrOfBol[i] ;
			System.out.println( "result = " + l_result );
		}
		
		return l_result;
	}
	
	public static boolean myConjunctionRec(boolean[] p_arrOfBol)
	{
		boolean l_result = true ;
		boolean[] l_arrOfBolOneLessItem ; 
		
		try 
		{
			System.out.println( "length = "  + p_arrOfBol.length );
			System.out.println( "value = "  + p_arrOfBol[0] );

			if ( 1 < p_arrOfBol.length )
			{
				System.out.print("p_arrOfBol=");
				System.out.println( Arrays.toString(p_arrOfBol) );

				l_arrOfBolOneLessItem = Arrays.copyOfRange( p_arrOfBol, 1, p_arrOfBol.length);
	
				System.out.print("l_arrOfBolOneLessItem=");
				System.out.println( Arrays.toString( l_arrOfBolOneLessItem ));
				
				l_result =  p_arrOfBol[0] && myConjunctionRec( l_arrOfBolOneLessItem );
			}
			else
			{
				//System.out.println( "LAST value = "  + p_arrOfBol[0] );
				
				l_result = p_arrOfBol[0];
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return l_result;
	}
	
	
	
	//This method takes a boolean array as input, 
	//and returns the conjunction of all of the
    //values in the array using recursive method calls.
	
	
	//method that takes a boolean array as input, 
	//and returns the disjunction of all of the
    //values in the array using a loop.
	//disjunction:((x1||x2||x3...xn))
	
	//This method takes a boolean array as input, 
	//and returns the disjunction of all of the
	//values in the array using recursive method calls.
	
	
	
}

