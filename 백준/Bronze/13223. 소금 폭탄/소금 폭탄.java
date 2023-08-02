import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String currentTime = scanner.next();
        String setTime = scanner.next();

        String[] current = currentTime.split(":");
        int currentHour = Integer.parseInt(current[0]);
        int currentMin = Integer.parseInt(current[1]);
        int currentSec = Integer.parseInt(current[2]);

        String[] set = setTime.split(":");
        int setHour = Integer.parseInt(set[0]);
        int setMin = Integer.parseInt(set[1]);
        int setSec = Integer.parseInt(set[2]);

        int currentSecAmount = currentHour*3600 + currentMin*60 + currentSec;
        int setSecAmount = setHour*3600 + setMin*60 + setSec;
        int answerSecAmount = setSecAmount - currentSecAmount;
        if(answerSecAmount <= 0) answerSecAmount += 24 * 3600;

        int answerHour = answerSecAmount / 3600;
        int answerMin = (answerSecAmount % 3600) / 60;
        int answerSec = (answerSecAmount % 60);


        String answer =  String.format("%02d:%02d:%02d",answerHour,answerMin, answerSec);

        System.out.println(answer);
    }
}
