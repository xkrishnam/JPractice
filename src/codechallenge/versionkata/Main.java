package codechallenge.versionkata;


/*
* get the apps using latest version api - impl with little stream usage
* */

import codechallenge.versionkata.domain.FileRecord;

import java.io.*;
import java.time.Duration;
import java.time.Instant;
import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

/* DO NOT CHANGE ANYTHING ABOVE THIS LINE */
/* You may add any imports here, if you wish, but only from the
   standard library */

/* Do not add a namespace declaration */

public class Main {
    public static void main (String[] args) {
        Instant start= Instant.now();
        ArrayList<String> inputData = new ArrayList<String>();
        //var aa;
        int numLines = 0;
        try {
            Stream<String> in = new BufferedReader(new FileReader("/home/krishna/Documents/DEV/inputs/input_vkata.csv")).lines();

            List<FileRecord> fileRecords=in.map(Main::addToList).collect(toList());

            Map<String ,List<FileRecord>> listMap=fileRecords.stream().collect(groupingBy(Main::getAPIName,toList()));
            Map<String,String> latestApiList=new HashMap<>();
            listMap.forEach((key, value) -> {
                value.sort(new VersionComparator());
                latestApiList.put(key,value.get(value.size()-1).getVersion());
            });

            listMap=fileRecords.stream().collect(groupingBy(Main::getAppName,toList()));
            Set<String> appNames=new HashSet<>();

            listMap.forEach((k,v)->{

                for(FileRecord fileRecord:v){
                    if(!fileRecord.getVersion().equals(latestApiList.get(fileRecord.getaPIName()))){
                        break;
                    }
                    appNames.add(k);
                }
            });

            appNames.forEach(System.out::println);


        } catch (IOException e) {
            System.out.println("IO error in input.txt or output.txt");
        }
        Instant stop=Instant.now();
        System.out.println(Duration.between(start,stop).toMillis());
    }



    static FileRecord addToList(String record){
        return new FileRecord(record);
    }
    public static String getAPIName(FileRecord fileRecord){
        return fileRecord.getaPIName();
    }

    public static  String getAppName(FileRecord fileRecord){
        return fileRecord.getAppName();
    }
}
