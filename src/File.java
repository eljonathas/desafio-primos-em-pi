import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class File {
  public final List<String> read(final String path) throws Exception {
    final Path filePath = Paths.get(path);

    return Files.readAllLines(filePath);
  }

  public final int[] parseLinesToNumbersList(final List<String> lines) {
    final String piValue = lines.get(0).toString();
    final int[] piArray = piValue.substring(piValue.indexOf(".") + 1).chars().mapToObj(c -> (char) c).mapToInt(c -> c - 48).toArray();
    
    return piArray;
  }
}
