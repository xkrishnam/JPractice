package deepdive.mapdive;

import java.util.Arrays;

public class IMDBTitleBasic {

    @FieldOrder(getOrder = 1)
    private String id;

    @FieldOrder(getOrder = 2)
    private String title;

    @FieldOrder(getOrder = 3)
    private String primaryTitle;

    @FieldOrder(getOrder = 4)
    private String originalTitle;

    @FieldOrder(getOrder = 5)
    private boolean adult;

    @FieldOrder(getOrder = 6)
    private int startYear;

    @FieldOrder(getOrder = 7)
    private int endYear;

    @FieldOrder(getOrder = 8)
    private int lengthMinuteRuntime;

    @FieldOrder(getOrder = 9)
    private String[] genre;


    @Override
    public String toString() {
        return "IMDBTitleBasic{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", primaryTitle='" + primaryTitle + '\'' +
                ", originalTitle='" + originalTitle + '\'' +
                ", adult=" + adult +
                ", startYear=" + startYear +
                ", endYear=" + endYear +
                ", lengthMinuteRuntime=" + lengthMinuteRuntime +
                ", genre=" + Arrays.toString(genre) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        IMDBTitleBasic that = (IMDBTitleBasic) o;

        if (adult != that.adult) return false;
        if (startYear != that.startYear) return false;
        if (endYear != that.endYear) return false;
        if (lengthMinuteRuntime != that.lengthMinuteRuntime) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (primaryTitle != null ? !primaryTitle.equals(that.primaryTitle) : that.primaryTitle != null) return false;
        if (originalTitle != null ? !originalTitle.equals(that.originalTitle) : that.originalTitle != null)
            return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(genre, that.genre);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (primaryTitle != null ? primaryTitle.hashCode() : 0);
        result = 31 * result + (originalTitle != null ? originalTitle.hashCode() : 0);
        result = 31 * result + (adult ? 1 : 0);
        result = 31 * result + startYear;
        result = 31 * result + endYear;
        result = 31 * result + lengthMinuteRuntime;
        result = 31 * result + Arrays.hashCode(genre);
        return result;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrimaryTitle() {
        return primaryTitle;
    }

    public void setPrimaryTitle(String primaryTitle) {
        this.primaryTitle = primaryTitle;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public boolean isAdult() {
        return adult;
    }

    public void setAdult(boolean adult) {
        this.adult = adult;
    }

    public int getStartYear() {
        return startYear;
    }

    public void setStartYear(int startYear) {
        this.startYear = startYear;
    }

    public int getEndYear() {
        return endYear;
    }

    public void setEndYear(int endYear) {
        this.endYear = endYear;
    }

    public int getLengthMinuteRuntime() {
        return lengthMinuteRuntime;
    }

    public void setLengthMinuteRuntime(int lengthMinuteRuntime) {
        this.lengthMinuteRuntime = lengthMinuteRuntime;
    }

    public String[] getGenre() {
        return genre;
    }

    public void setGenre(String[] genre) {
        this.genre = genre;
    }
}
