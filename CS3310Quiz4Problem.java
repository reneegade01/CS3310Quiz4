package cs3310quiz4problem1;
/*
CS 3310 Section 2
S. Renee Eller
Quiz #4
 */
public class CS3310Quiz4Problem
{
    public static void main(String[] args)
    {
        int initialArray[] = {48, 23, 15, 8, 1, 4, 38, 45, 73, 65, 12};
        int n = initialArray.length;

        //make new array with same length as old array
        int newArray[] = new int[n];
        CS3310Quiz4Problem ob = new CS3310Quiz4Problem();

        //we sort the array using quick sort
        ob.sorting(initialArray, 0, n - 1);
                
        int i = 0;
        int j = n - 1;
        int k = n-2;
        int toggle = 0;

        //In the case the array has an even number of elements
        if(n%2 == 0)
        {
            while(i <= j)
            {
                if(toggle == 0)
                {
                    newArray[i] = initialArray[j]; 
                    newArray[j] = initialArray[i];
                    toggle = 1;
                }
                else if(toggle == 1)
                {
                    newArray[i] = initialArray[i];
                    newArray[j] = initialArray[j];
                    toggle = 0;
                }
                i++;
                j--;
            }
        }
        //In the case the array has an odd number of elements
        else if(n%2 != 0)
        {
            while(i <= k)
            {
                if(toggle == 0)
                {
                    newArray[i] = initialArray[k];
                    newArray[k] = initialArray[i];
                    toggle = 1;
                }
                else if(toggle == 1)
                {
                    newArray[i] = initialArray[i];
                    newArray[k] = initialArray[k];
                    toggle = 0;
                }
                newArray[j] = initialArray[j];
                i++;
                k--;
            }
        }
                System.out.println("***************************************");
                System.out.println("The peak and valley result is: ");
                printArray(newArray);
                System.out.println("***************************************");

    }
    
    int partitioning(int initialArray[], int start, int end)
    {
        int pivotPoint = initialArray[end];
        int i = (start-1);
        for (int j = start; j<end; j++)
        {
            if (initialArray[j] < pivotPoint)
            {
               i++;
               int temporary = initialArray[i];
               initialArray[i] = initialArray[j];
               initialArray[j] = temporary;
            }
        }
        int temporary = initialArray[i+1];
        initialArray[i+1] = initialArray[end];
        initialArray[end] = temporary;

        return i+1;
    }

        //where quicksort is implemented
    public void sorting(int initialArray[], int start, int end)
    {
        if (start < end)
        {
            int pivotPoint = partitioning(initialArray, start, end);
            sorting(initialArray, start, pivotPoint - 1);
            sorting(initialArray, pivotPoint + 1, end);
        }
    }
    
    public static void printArray(int newArray[])
    {
        for (int i=0; i < newArray.length; ++i)
        {
                System.out.print(newArray[i] + " ");
                System.out.println();
        }
    } 
    
}
 
