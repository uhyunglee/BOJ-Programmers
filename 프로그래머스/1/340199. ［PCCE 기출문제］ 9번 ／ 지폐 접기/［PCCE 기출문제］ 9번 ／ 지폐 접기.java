class Solution {
    public int solution(int[] wallet, int[] bill) {
        int count = 0;
        int walletMin = Math.min(wallet[0], wallet[1]);
        int walletMax = Math.max(wallet[0], wallet[1]);
        // 90도 회전을 어떻게 표현하지 
        // 인간의 머리 : 넣어봄 -> 안됨 -> 90도 돌려서 넣어봄 
        while(true){// 
        int billMin = Math.min(bill[0],bill[1]);
        int billMax = Math.max(bill[0],bill[1]);
            if(walletMin >= billMin && walletMax >= billMax){// 들어가는 경우
                break;
            }else{ // 안들어가는 경우
                fold(bill);
                count++;
            }
        }
        return count;
    }
    public int[] fold(int[] bill){
        int width = bill[0];
        int height = bill[1];
        if(width > height){
            width /= 2;
        }else height /= 2;
        
        bill[0] = width;
        bill[1] = height;
        
        return bill;
    }
}