package deepdive.mapdive;

import java.util.StringTokenizer;

public interface ItemMapper<I> {
    I map(StringTokenizer tokens);
}
