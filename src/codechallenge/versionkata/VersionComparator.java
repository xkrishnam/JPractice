package codechallenge.versionkata;

import codechallenge.versionkata.domain.FileRecord;

import java.util.Comparator;

public class VersionComparator implements Comparator<FileRecord> {


    @Override
    public int compare(FileRecord fileRecord, FileRecord t1) {
//        System.out.println(fileRecord.getVersion()+"<<>>"+t1.getVersion()+"  -->"
//                +fileRecord.getVersion().compareTo(t1.getVersion()));
        return Integer.parseInt(fileRecord.getVersion().replace('V','0'))
                -Integer.parseInt(t1.getVersion().replace('V','0'));

//for integer version
//        System.out.println(fileRecord.getVersion()+"<<>>"+t1.getVersion()+"  -->"
//                +String.valueOf(Integer.parseInt(fileRecord.getVersion())-Integer.parseInt(t1.getVersion())));
//        return Integer.parseInt(fileRecord.getVersion())-Integer.parseInt(t1.getVersion());
    }
}
