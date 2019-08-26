class NetsuiteTest {
	
	public static void main (String args []) {
		int[] values  = new int[]{1, 2, 3, 4, 4, 4, 4, 8, 8, 8, 9, 9, 9, 9};
		//int [] values = new int[]{};
		int frequentDuplicate = findMostFrequentDuplicateValue(values);
		//int randomValue = (int)(Math.random() * 100);
		int randomValue = 2;
		if (frequentDuplicate != -1)
			System.out.println ("The most frequent duplicate value in given array is " + frequentDuplicate + ".");
	        else
			System.out.println ("Wrong input or no duplicates in array.");	

		System.out.println ("Approximation of a = " + randomValue + " is " + square_root(randomValue,1e-6));
	}

	//finds the most frequent duplicate value in that array
	public static int findMostFrequentDuplicateValue(int[] values)
	{
		//checks if array is non-empty
		if (values.length == 0)
			return -1;
		
		int occurences = 0;		//number of occurences for currently processed value
		int num = values[0];		//currently processed number from array of @values
		int occurenceMax = 0;		//max occurences of so far most frequent value in array
		int occurenceMaxNum = -1;	//value of so far most frequent value in array
		
		for(int i = 0; i < values.length; i++)
		{
			//checks if we still process the same value
			if (num != values[i])
			{
				//if more frequent value has been found, variables are updated
				if (occurenceMax < occurences) {
					occurenceMax = occurences;
					occurenceMaxNum = num;
				}
				occurences = 0;
				num = values[i];
			}

			occurences++;
		}
		
		//returns -1 if there are no duplicates
		if (occurenceMax < 2)
			return -1;
		
		return occurenceMaxNum;
		
	}

	//counts an approximation of the square root of a
	public static double square_root(double a, double epsilon)
	{
		double x = a/2;
		double y;
		double xx;
		while (Math.abs(x*x - a) > epsilon)
		{
			y = a/x;
			xx = (x + y)/2;
			x = xx;
		}

		return x;

	}
} 
