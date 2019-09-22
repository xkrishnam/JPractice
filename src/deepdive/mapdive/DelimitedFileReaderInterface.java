package deepdive.mapdive;
/*
auther : Krishna

common interface to read any file having delimited tokens
 */

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public interface DelimitedFileReaderInterface<I> {
    List<I> readItem(Path filePath, ItemMapper<I> mapper) throws IOException;
}
