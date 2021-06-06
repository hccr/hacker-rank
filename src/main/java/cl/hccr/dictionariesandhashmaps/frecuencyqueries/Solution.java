package cl.hccr.dictionariesandhashmaps.frecuencyqueries;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Solution {



    // Complete the freqQuery function below.
    static List<Integer> freqQuery(List<List<Integer>> queries) {
        List<Integer> output = new ArrayList<>(queries.size());

        Map<Integer, Integer> map = new HashMap<>(queries.size());
        Map<Integer, Integer> frequencyHolder = new HashMap<>(queries.size());

        final int ADD = 1;
        final int DELETE = 2;
        final int FREQUENCY = 3;

        for (List<Integer> query : queries) {
            int operation = query.get(0);
            int value = query.get(1);

            switch (operation){
                case ADD: add(value, map, frequencyHolder);
                    break;
                case DELETE: remove(value, map, frequencyHolder);
                    break;
                case FREQUENCY:
                    output.add(checkFrequency(value,frequencyHolder)?1:0);
                    break;
                default:break;
            }
        }

        return output;
    }

    static void add(int value, Map<Integer, Integer> map, Map<Integer, Integer> frequencyHolder){
        int frequency;
        if(!map.containsKey(value)){
            frequency = 1;
        }else{
            frequency = map.get(value) + 1;
        }

        map.put(value,frequency);


        int countFrequency ;
        if(frequencyHolder.containsKey(frequency)){
            countFrequency =  frequencyHolder.get(frequency) + 1 ;
        }else{
            countFrequency = 1;
        }
        frequencyHolder.put(frequency, countFrequency);

        frequency--;
        if(frequencyHolder.containsKey(frequency)){
            countFrequency = frequencyHolder.get(frequency);
            if(countFrequency <= 1){
                frequencyHolder.remove(frequency);
            }else{
                frequencyHolder.put(frequency, countFrequency - 1);
            }
        }


    }
    static void remove(int value, Map<Integer, Integer> map, Map<Integer, Integer> frequencyHolder ){
        if(!map.containsKey(value)){
            return;
        }else{
            int oldFrequency = map.get(value);
            int newFrequency;
            if(oldFrequency>1){
                newFrequency = oldFrequency - 1;
                map.put(value, newFrequency);
            }else{
               map.remove(value);
                newFrequency = 0;
            }

            //Aumentar en 1 la nueva frecuencia
            if(frequencyHolder.containsKey(newFrequency)){
                int newFrequencyCount = frequencyHolder.get(newFrequency) + 1;
                frequencyHolder.put(newFrequency, newFrequencyCount);
            }else{
                frequencyHolder.put(newFrequency, 1);
            }



            //Disminuir en 1 la antigua frecuencia
            if(frequencyHolder.containsKey(oldFrequency)){
                int oldFrequencyCount = frequencyHolder.get(oldFrequency);
                if(oldFrequencyCount>1){
                    frequencyHolder.put(oldFrequency, oldFrequencyCount-1);
                }else{
                    frequencyHolder.remove(oldFrequency);
                }
            }
        }
    }
    static boolean checkFrequency(int frequency, Map<Integer, Integer> frequencyHolder){
        return frequencyHolder.containsKey(frequency);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> queries = new ArrayList<>();

        IntStream.range(0, q).forEach(i -> {
            try {
                queries.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<Integer> ans = freqQuery(queries);

        bufferedWriter.write(
                ans.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}

