package deepdive.mapdive;

import java.util.StringTokenizer;

public class IMDBTitleBasicMapper implements ItemMapper<IMDBTitleBasic> {
    @Override
    public IMDBTitleBasic map(StringTokenizer tokens) {
        IMDBTitleBasic imdbTitleBasic=new IMDBTitleBasic();
        imdbTitleBasic.setId(checkValue(tokens.nextToken()));
        imdbTitleBasic.setTitle(checkValue(tokens.nextToken()));
        imdbTitleBasic.setPrimaryTitle(checkValue(tokens.nextToken()));
        imdbTitleBasic.setOriginalTitle(checkValue(tokens.nextToken()));
        imdbTitleBasic.setAdult(tokens.nextToken().equalsIgnoreCase("1"));
        imdbTitleBasic.setStartYear(Integer.parseInt(checkValue(tokens.nextToken())));
        imdbTitleBasic.setEndYear(Integer.parseInt(checkValue(tokens.nextToken())));
        imdbTitleBasic.setLengthMinuteRuntime(Integer.parseInt(checkValue(tokens.nextToken())));
        imdbTitleBasic.setGenre(mapStringArr(tokens.nextToken()));

        return imdbTitleBasic;
    }

    private String checkValue(String str){
        return str.equalsIgnoreCase("\\N")?"0":str;
    }

    private String[] mapStringArr(String str){
        return str.split(",");
    }
}
