import java.util.*;

public class Group_MidLabAct3_Problem1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter array size: ");
        int size = input.nextInt();
        int[] og_array = new int[size];

        System.out.print("Enter " + size + " array elements: ");
        for (int i = 0; i < size; i++) {
            og_array[i] = input.nextInt();
        }

        int[] array = new int[og_array.length];
        for (int i = 0; i < og_array.length; i++) {
            array[i] = og_array[i];
        }
        
        System.out.println("\nChoose Sorting Algorithm:\n\t"
                + "A. Bubble Sort\n\t"
                + "B. Selection Sort\n\t"
                + "C. Insertion Sort\n\t"
                + "D. Merge Sort\n\t");
        System.out.print("Type (A/B/C/D) only: ");

        char choice = input.next().toUpperCase().charAt(0);
        boolean swapped;

        switch (choice) {
            // BUBBLE 
            case 'A':
                System.out.println("\nBUBBLE SORT:");
                for (int i = 0; i < size; i++) {
                    System.out.print(array[i] + " ");
                }
                System.out.println();
                
                for (int i = 0; i < size - 1; i++) {
                    swapped = false;
                    for (int j = 0; j < size - i - 1; j++) {
                        if (array[j] > array[j + 1]) {
                            int temp = array[j];
                            array[j] = array[j + 1];
                            array[j + 1] = temp;
                            swapped = true;
                            boolean isSame = true;
                            for (int k = 0; k < array.length; k++) {
                                if (array[k] != og_array[k]) {
                                    isSame = false;
                                    break;
                                }
                            }
                            if (!isSame) {
                                for (int num : array) {
                                    System.out.print(num + " ");
                                }
                                System.out.println();
                                for (int k = 0; k < array.length; k++) {
                                    og_array[k] = array[k];
                                }
                            }
                        }
                    }
                    if (!swapped) break;
                }
                break;
            
            // SELECTION
            case 'B':
                System.out.println("\nSELECTION SORT:");
                for (int i = 0; i < size; i++) {
                    System.out.print(array[i] + " ");
                }
                System.out.println();
                
                for (int i = 0; i < size - 1; i++) {
                    int minIndex = i;
                    for (int j = i + 1; j < size; j++) {
                        if (array[j] < array[minIndex]) {
                            minIndex = j;
                        }
                    }
                    if (minIndex != i) {
                        int temp = array[minIndex];
                        array[minIndex] = array[i];
                        array[i] = temp;
                        boolean isSame = true;
                        for (int k = 0; k < array.length; k++) {
                            if (array[k] != og_array[k]) {
                                isSame = false;
                                break;
                            }
                        }
                        if (!isSame) {
                            for (int num : array) {
                                System.out.print(num + " ");
                            }
                            System.out.println();
                            for (int k = 0; k < array.length; k++) {
                                og_array[k] = array[k];
                            }
                        }
                    }
                }
                break;
            
            // INSERTION
            case 'C':
                System.out.println("\nINSERTION SORT:");
                for (int i = 0; i < size; i++) {
                    System.out.print(array[i] + " ");
                }
                System.out.println();
                
                for (int i = 1; i < size; i++) {
                    int key = array[i];
                    int j = i - 1;
                    while (j >= 0 && array[j] > key) {
                        array[j + 1] = array[j];
                        j--;
                    }
                    array[j + 1] = key;
                    boolean isSame = true;
                    for (int k = 0; k < array.length; k++) {
                        if (array[k] != og_array[k]) {
                            isSame = false;
                            break;
                        }
                    }
                    if (!isSame) {
                        for (int num : array) {
                            System.out.print(num + " ");
                        }
                        System.out.println();
                        for (int k = 0; k < array.length; k++) {
                            og_array[k] = array[k];
                        }
                    }
                }
                break;
            
            // MERGE
            case 'D':
                System.out.println("\nMERGE SORT:");
                
                //displaying the initial array arrangement using for loop
                for (int i = 0; i < size; i++) {
                    System.out.print(array[i] + " ");
                }
                System.out.println();
                
                /*this calls the method to perform the merge sorting algorithm
                passing the initail array, start, end, and the original array to compare 
                with array changes and avoid displaying array with the same arrangement*/
                merge(array, 0, array.length - 1, og_array);
                break;
            default:
                System.out.println("Invalid Choice!");
        }
    }
    
   static void merge(int[] array, int start, int end, int[] og_array) {
       // recursive function
       if (start < end) {
           int mid = (start + end) / 2;
   
           merge(array, start, mid, og_array);
   
           merge(array, mid + 1, end, og_array);
   
           int sub1 = mid - start + 1;
           int sub2 = end - mid;
   
           int[] arr_L = new int[sub1];
           int[] arr_R = new int[sub2];
   
           for (int i = 0; i < sub1; i++) {
               arr_L[i] = array[start + i];
           }
           for (int i = 0; i < sub2; i++) {
               arr_R[i] = array[mid + 1 + i];
           }
           
           /*this is the pointers for subarrays
           arr_L (i), arr_R (j), and the main array (k)*/
           int i = 0, j = 0;
           int k = start;
           
           /*this while loop is used to compare the current element/s in arr_L and arr_R
           and continues until one of the subarrays have no elements left*/
           while (i < sub1 && j < sub2) {
               if (arr_L[i] <= arr_R[j]) {/*if arr_L element is smaller that element in arr_R
               store the element of main array with the element of arr_L then increment both 
               pointers (i,j) to move to the next array position*/
                   array[k++] = arr_L[i++];
               } else {//else store element of arr_R and j, k pointers are incremented
                   array[k++] = arr_R[j++];
               }
           }
           
           /*since the main loop above ends when one of the 2 subarrays reached the last elements,
           these following while loops are used to store the remaining elements from either of the
           2 subarrays in to the main array*/
           while (i < sub1) {
               array[k++] = arr_L[i++];
           }
   
           while (j < sub2) {
               array[k++] = arr_R[j++];
           }
           
           /*this is used to check if the current array is the same with the 
           original array or the previously stored/updated array*/
           boolean isSame = true;
           for (int n = 0; n < array.length; n++) {
               if (array[n] != og_array[n]) {//if any difference found, isSame is set to false
                  isSame = false;
                  break;
               }
           }
           /*this block of code will only print if current array is not the same with
           the previous array*/
           if (!isSame) {
               for (int num : array) {
                  System.out.print(num + " ");
               }
               System.out.println();
               
               /*then the elements in the original/previous array will be updated
               with the elements in the current array for the next merge*/
               for (int n = 0; n < array.length; n++) {
                  og_array[n] = array[n];
               }
            }
       }
   }
}