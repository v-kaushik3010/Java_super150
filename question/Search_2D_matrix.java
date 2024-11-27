package question;

public class Search_2D_matrix {

	public static void main(String[] args) {
		
		int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
		int target = 3;
		System.out.println(Search(matrix, target));
		}
	
		// TODO Auto-generated method stub
		
		public static boolean Search(int[][] matrix, int target) {
		 for(int row = 0; row < matrix.length; row++){

	            int low = 0;
	            int high = matrix[row].length -1;
	            if(matrix[row][high]<target){
	                row++;
	                continue;
            }else{
	                while (low<=high){
	                    int mid =(int)(high + low)/2;
	                    if(matrix[row][mid]== target){
	                        return true;
	                    }
	                    else if(matrix[row][mid] >  target){
	                        high = mid-1;
                        continue;
	                        }
                        else{
                            low = mid+1;
                            continue;
	                        }
	                }
	            }

	        }return false;
	        
			
			
			
			
		     

	}

}
