package deepdive.mapdive;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

public class DataArchiveDaoImpl {
    List<IMDBTitleBasic> imdbTitleBasicList;
    Map<Integer,List<IMDBTitleBasic>> yearwiseIMDBTitleBasicMap;

    public List<IMDBTitleBasic> getImdbTitleBasicList() {
        return imdbTitleBasicList;
    }


    public void setImdbTitleBasicList(List<IMDBTitleBasic> imdbTitleBasicList) {
        this.imdbTitleBasicList = imdbTitleBasicList;
        yearwiseIMDBTitleBasicMap=imdbTitleBasicList.stream()
                .collect(groupingBy(IMDBTitleBasic::getStartYear,toList()));
    }

    public Map<Integer, List<IMDBTitleBasic>> getYearwiseIMDBTitleBasicMap() {
        return yearwiseIMDBTitleBasicMap;
    }
}
