package codechallenge.versionkata.domain;

public class FileRecord {

    private String appName;
    private String aPIName;
    private String version;

    public FileRecord(String record){
        String[] records=record.split(",");
        this.appName=records[0].trim();
        this.aPIName=records[1].trim();
        this.version=records[2].trim();
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getaPIName() {
        return aPIName;
    }

    public void setaPIName(String aPIName) {
        this.aPIName = aPIName;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public void printAppName(){
        System.out.println(this.getAppName());
    }

    public static int compareVersion(FileRecord fileRecord, FileRecord t1) {
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
