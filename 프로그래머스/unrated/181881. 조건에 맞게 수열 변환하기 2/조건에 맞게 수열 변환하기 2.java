import java.util.Arrays;

class Solution {
    public int solution(int[] arr) {
        int count = 0;
        int[] newArr = new int[arr.length];
        while(true){
        	for(int i = 0; i < arr.length; i++){
            	if(arr[i] >= 50 && arr[i] % 2 == 0){
                	newArr[i] = arr[i] / 2;
            	}else if(arr[i] < 50 && arr[i] % 2 == 1){
                	newArr[i] = arr[i] * 2 + 1;
            	}else
                    newArr[i] = arr[i];
        	}
            if(Arrays.equals(arr, newArr))break;
            else{
                for(int i = 0; i < newArr.length; i++){
                    arr[i] = newArr[i];
                }
                //Arrays.fill(newArr, 0);
                count++;
            }
        }
        return count;
    }
}