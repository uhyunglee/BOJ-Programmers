import java.io.*;
import java.time.LocalTime;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        String start = st.nextToken();
        String end = st.nextToken();
        String quit = st.nextToken();


        LocalTime s = timeParser(start);
        LocalTime e = timeParser(end);
        LocalTime q = timeParser(quit);

        Set<String> in = new HashSet<>();

        Set<String> counted = new HashSet<>();

        String str;
        int count = 0;

        while ((str = br.readLine()) != null) {
            st = new StringTokenizer(str, " ");
            LocalTime time = timeParser(st.nextToken());
            String member = st.nextToken();

            if (time.isBefore(s) || time.equals(s)) {
                in.add(member);
            }

            if ((time.isAfter(e) || time.equals(e)) && (time.isBefore(q) || time.equals(q))) {
                if (in.contains(member)) {
                    counted.add(member);
                }
            }
        }

        System.out.println(counted.size());
    }

    static LocalTime timeParser(String s) {
        StringTokenizer st = new StringTokenizer(s, ":");
        LocalTime time = LocalTime.of(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        return time;
    }
}