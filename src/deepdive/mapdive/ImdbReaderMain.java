package deepdive.mapdive;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

public class ImdbReaderMain {


    public static void main(String[] args) throws IOException {
        DataArchiveDaoImpl dataArchiveDao=new DataArchiveDaoImpl();
        Path p= Paths.get("/home/krishna/Documents/DEV/datasets/imdb/x00");
        dataArchiveDao.setImdbTitleBasicList(
                new TSVFileReaderInterfaceImpl<IMDBTitleBasic>().readItem(p,new IMDBTitleBasicMapper()));
        System.out.println("data Size : "+dataArchiveDao.getImdbTitleBasicList().size());
        Collections.synchronizedMap(dataArchiveDao.getYearwiseIMDBTitleBasicMap());
        new Thread(()->{
            dataArchiveDao.getYearwiseIMDBTitleBasicMap().forEach((y,l)->{
                System.out.println(Thread.currentThread().getName()+" Total count in year-"+y+ " was"+l.size()+ " ex"+l.get(0).getEndYear());
//                try {
//                    TimeUnit.MILLISECONDS.sleep(600);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            });
        },"T1").start();

        new Thread(()->{
            dataArchiveDao.getYearwiseIMDBTitleBasicMap().forEach((y,l)->{
                System.out.println(Thread.currentThread().getName()+" Total count in year-"+y+ " was"+l.size());
                l.get(0).setEndYear(2222);
//                try {
//                    TimeUnit.MILLISECONDS.sleep(500);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            });
        },"T2").start();
    }
}
