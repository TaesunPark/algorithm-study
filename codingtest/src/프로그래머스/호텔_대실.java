package 프로그래머스;

import java.util.Arrays;
import java.util.PriorityQueue;


class 호텔_대실 {
    public int solution(String[][] book_time) {
        int answer = 0;
        PriorityQueue<Book> book_list = new PriorityQueue<>();

        Arrays.sort(book_time, (o1, o2) -> {
            return o1[0].toString().compareTo(o2[0].toString());
        });

        for(String[] books : book_time){
            Book book = new Book(books[0], books[1]);

            if(!book_list.isEmpty() && book_list.peek().endMin <= book.startMin){
                book_list.poll();
            } else{
                answer++;
            }
            book_list.add(book);
        }

        return answer;
    }

    static class Book implements Comparable<Book>{
        int startMin;
        int endMin;

        public Book(String startTime, String endTime){
            startMin = convertToMin(startTime);
            endMin = convertToMin(endTime) + 10;
        }

        public int convertToMin(String time){
            String[] time_value = time.split(":");
            int result = Integer.parseInt(time_value[0]) * 60 + Integer.parseInt(time_value[1]);
            return result;
        }

        @Override
        public int compareTo(Book o1){
            return this.endMin - o1.endMin;
        }

    }
}

