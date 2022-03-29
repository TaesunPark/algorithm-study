import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BJ10814 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Person> people = new ArrayList<>();

        for (int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            people.add(new Person(age, name));
        }
        Collections.sort(people);
        for (int i=0; i<n; i++){
            System.out.println(people.get(i).age + " "+ people.get(i).name);
        }
    }

    static class Person implements Comparable<Person>{
        int age;
        String name;
        public Person(int age, String name){
            this.age = age;
            this.name = name;
        }

        @Override
        public int compareTo(Person o) {
            if (age < o.age){
                return -1;
            } else if (age > o.age){
                return 1;
            }
            return 0;
        }
    }
}
