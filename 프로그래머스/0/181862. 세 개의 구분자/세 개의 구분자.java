import java.util.ArrayList;

class Solution {
    public String[] solution(String myStr) {
        ArrayList<String> list = new ArrayList<>();
        String temp = "";
        for(int i = 0; i < myStr.length(); i++){
            char ch = myStr.charAt(i);
            if(ch == 'a' || ch == 'b' || ch == 'c'){
                if(temp.length() != 0){
                    list.add(temp);
                    temp = "";
                }
                
            }else
                temp += ch;
        }
        if(temp.length() != 0){// 마지막 원소
            list.add(temp);
            temp = "";
        }
        if(list.size() == 0){
            list.add("EMPTY");
        }
        return list.toArray(new String[list.size()]);
    }
}