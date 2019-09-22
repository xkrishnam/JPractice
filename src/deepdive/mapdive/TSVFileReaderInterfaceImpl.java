package deepdive.mapdive;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.StringTokenizer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TSVFileReaderInterfaceImpl<I> implements DelimitedFileReaderInterface<I> {
    private String TSV_DELIMITER="\t";

    @Override
    public List<I> readItem(Path filePath, ItemMapper<I> mapper) throws IOException {
        Function<? super String, I> mapToItem=(line)->{
            StringTokenizer st = new StringTokenizer(line,TSV_DELIMITER);// a CSV has comma separated lines
            I item = mapper.map(st);
            return item;
        };

        return Files.lines(filePath).skip(1)
                .map(mapToItem)
                .collect(Collectors.toList());
    }
}
