import java.util.Arrays;
import java.util.stream.IntStream;

public class ArrayChunks {
	
	/**
	 * Given an array and chunk size, divide an array into many sub 
	 * arrays where each sub array is of length size
	 *  
	 * chunk([1,2,3,4],2) [[1,2],[3,4]]
	 * chunk([1,2,3,4,5],2)[[1,2],[3,4],[5]]
	 * chunk([1,2,3,4,5,6,7,8],3) [[1,2,3],[4,5,6],[7,8]]
	 * chunk([1,2,3,4,5],4)[[1,2,3,4],[5]]
	 * chunk([1,2,3,4],10) [[1,2,3,4]]
	 * 	 
	 * **/

	public static void main(String[] args) {
		// TODO Not working need correction
		//chunk();
		
		int[] input = {1,2,3,4,78,999,-1,456,8};
        int chunkSize = 3;

        splitArray(input,2);
       /* int[][] chunked = chunk(input, chunkSize);

        Arrays.stream(chunked)
                .map(Arrays::toString)
                    .forEach(System.out::println);*/
		//chunkUsingSplit();
	}

	
	
	public static void chunk(){
		//char[] chunk[] = {{}};
		int chunkSize = 2;
		char[] nameArray = {'1','2','3','4','5'};
		int chunks = (int)Math.ceil((double)nameArray.length / chunkSize);
		
		char chunked[] = new char[chunks];
		char[] lastChunk = {};
		
		int i =0;
		int j=0;
		
	/*	for(char c: nameArray){
			
			lastChunk = chunked[chunked.length -1];
						
			if(lastChunk == null || lastChunk.length == chunkSize){
				lastChunk = new char[chunked.length -1];
				lastChunk[i] = c;
				chunked[j] = lastChunk;
				i++;

			}else{
				lastChunk[i] = c;
				i=0;
			}
		}*/
		
		/* for (char value[]: chunked) {
	         System.out.println("Value = " +  Arrays.toString(value));
	      }*/
		 
		//String name = Arrays.toString(chunk);
		//System.out.println(name);
	}
	/**
	 * use split or slice function
	 * Create an empty chunk array
	 * Create index start at 0
	 * While index is less than array.length
	 * 		push a slice of length "size" from array into chunked
	 * 		add size to index
	 * 
	 * **/
	public static void chunkUsingSplit(){
		
		char[] nameArray = {1,2,3,4,5};
			
	}
	
	public static int[][] splitArray(int[] arrayToSplit, int chunkSize){
		
		//1. If chunk size is zero return nothing
	    if(chunkSize<=0){
	        return null;
	    }
	    
	    //2. first we have to check if the array can be split in multiple arrays of equal 'chunk' size
	    
	    int rest = arrayToSplit.length % chunkSize; 
	    
	    	//2.1 if rest>0 then our last array will have less elements than the others 
	    
	    //3. then we check in how many sub arrays we can split our input array
	    
	    //int chunks = arrayToSplit.length / chunkSize + (rest > 0 ? 1 : 0);
	    
	    int chunks = (int)Math.ceil((double)arrayToSplit.length / chunkSize);
	    
	    //We use Ceil here as we may have to add an additional array for the 'rest'
	    //4. As now we know how many arrays we need and create our result array
	    
	    int[][] arrays = new int[chunks][];
	    
	    //5. we create our resulting arrays by copying the corresponding 
	    // part from the input array. If we have a rest (rest>0), then
	    // the last array will have less elements than the others. This 
	    // needs to be handled separately, so we iterate 1 times less.
	    
	    for(int i = 0; i < (rest > 0 ? chunks - 1 : chunks); i++){
	        // this copies 'chunk' times 'chunkSize' elements into a new array
	        arrays[i] = Arrays.copyOfRange(arrayToSplit, i * chunkSize, i * chunkSize + chunkSize);
	    }
	    if(rest > 0){ // only when we have a rest
	        // we copy the remaining elements into the last chunk
	        arrays[chunks - 1] = Arrays.copyOfRange(arrayToSplit, (chunks - 1) * chunkSize, (chunks - 1) * chunkSize + rest);
	    }
	    return arrays; // that's it
	}
		
	
	public static int[][] chunkArray(int[] array, int chunkSize) {
        // first we need to get number of chunks by dividing length by chunkSize.
        int numOfChunks = (int)Math.ceil((double)array.length / chunkSize);
        
        // we declare 2d array to save in the chunks
        int[][] output = new int[numOfChunks][];

        for(int i = 0; i < numOfChunks; i++) {
            int start = i * chunkSize;
            int length = Math.min(array.length - start, chunkSize);

            int[] temp = new int[length];
            System.arraycopy(array, start, temp, 0, length);
            output[i] = temp;
        }

        return output;
    }
	
	//Using Pure java 8
	public static int[][] chunk(int[] input, int chunkSize) {
        return IntStream.iterate(0, i -> i + chunkSize)
                .limit((long) Math.ceil((double) input.length / chunkSize))
                .mapToObj(j -> Arrays.copyOfRange(input, j, j + chunkSize > input.length ? input.length : j + chunkSize))
                .toArray(int[][]::new);
    }
}
