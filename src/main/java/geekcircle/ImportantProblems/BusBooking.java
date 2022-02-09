package com.geekcircle.ImportantProblems;

import java.util.ArrayList;
import java.util.List;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-09-20
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/
class Stoppage{
    int id;
    int sequence;
    String name;

    public Stoppage(int id, int sequence, String name) {
        this.id = id;
        this.sequence = sequence;
        this.name = name;
    }
}

class Availability {

}


public class BusBooking {
    public static void main(String[] args) throws Exception {
        String[] locations = {"Delhi", "Agra", "Gwalior", "Jhansi", "Lalitpur", "Bhopal", "Betul", "Nagpur", "Hyderabad", "Bangalore"};
        Integer N = locations.length;
        List<Stoppage> stoppages = new ArrayList<>();
        int[][] availability = new int[N][N];
        for(int i = 0; i < N; i++){
            stoppages.add(new Stoppage(i, i+1, locations[i]));
        }
        book(availability, "Gwalior", "Lalitpur", locations);
        getAvailability(availability, locations);
    }

    private static void getBooking(int[][] availability, String[] locations){

    }

    private static void book(int[][] availability, String source, String destination, String[] locations) throws Exception{
        int from = -1;
        int to = -1;
        for (int i = 0; i < locations.length; i++){
            if(source.equals(locations[i])){
                from = i;
            }
            if(destination.equals(locations[i])){
                to = i;
            }
        }
        if(from == -1 || to == -1){
            throw new Exception("Error");
        }
        int N = availability.length;
        for(int i = 0; i < N; i++){
            boolean availableFullJourney = true;
            for(int j = from; j <= to; j++){
                if(availability[i][j] == 1){
                    availableFullJourney = false;
                }
            }
            if(availableFullJourney){
                for(int j = from; j <= to; j++){
                    availability[i][j] = 1;
                }
                break;
            }
        }
    }

    private static void getAvailability(int[][] availability, String[] locations){
        int N = availability.length;
        System.out.println("Available: ");
        for(int i = 0; i < N; i++){
            int from = 0;
            int to = 0;
            while (to < N || from < N){
                while (availability[i][from] == 1){
                    from++;
                    to = from;
                    continue;
                }
                if(to+1 < N && availability[i][to+1] == 1){
                    System.out.println("From : " + locations[from] +" To :"+locations[to]);
                    while (to < N && availability[i][to+1] == 1){
                        to++;
                        from = to;
                    }
                } else if (to < N) {
                    to++;
                }
            }
            if(from != to){
                System.out.println("From : " + locations[from] +" To :"+locations[to-1]);
            }
        }
    }
}
