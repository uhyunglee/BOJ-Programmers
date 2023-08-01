
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String doc = scanner.nextLine();
//        StringBuffer word = new StringBuffer(scanner.nextLine());
        String word = scanner.nextLine();

        int count = 0;
        int startIndex = 0;
        while(true){
            int findIndex = doc.indexOf(word, startIndex);
            if(findIndex < 0) break;
            startIndex = findIndex + word.length();
            count++;
        }


//        for(int i = 0; i < doc.length(); i++){
//            boolean isMatch = true;
//            for(int j = 0; j < word.length(); j++){
//                if(i + j >= doc.length() || doc.charAt(i+j) != word.charAt(j)){
//                    isMatch = false;break;
//                }
//            }
//            if(isMatch == true){
//                count++;
//                i+=word.length()-1;
//            }
//        }
        System.out.println(count);
    }
}
