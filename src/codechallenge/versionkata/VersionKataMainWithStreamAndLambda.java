package codechallenge.versionkata;

import codechallenge.versionkata.domain.FileRecord;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.Instant;
import java.util.Collections;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

/*
 * get the apps using latest version api - impl with parllel stream usage
 * */
public class VersionKataMainWithStreamAndLambda {

    public static void main(String[] args) throws IOException {
        Instant start=Instant.now();
        Files.lines(Paths.get("/home/krishna/Documents/DEV/inputs/input_vkata.csv"))
                .map(FileRecord::new)
                .collect(groupingBy(FileRecord::getaPIName, toList()))
                .entrySet()
                .parallelStream()
                .forEach((e) -> {
                    Collections.sort(e.getValue(), FileRecord::compareVersion);
                    String version = e.getValue().get(e.getValue().size() - 1).getVersion();
                    e.getValue()
                            .parallelStream()
                            .filter(r -> r.getVersion().equalsIgnoreCase(version))
                            .forEach(r -> r.printAppName());
                });
        Instant stop=Instant.now();
        System.out.println(Duration.between(start,stop).toMillis());
    }
}
