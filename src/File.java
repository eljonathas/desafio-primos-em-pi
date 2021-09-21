import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class File {
  // O método read lê o caminho para o arquivo teste e retorna seu conteúdo.
  public final List<String> read(final String path) throws Exception {
    final Path filePath = Paths.get(path);

    return Files.readAllLines(filePath);
  }

  // O método parseLinesToNumbersList irá converter o conteúdo do arquivo em uma lista de números.
  public final int[] parseLinesToNumbersList(final List<String> lines) {
    // Primeiramente a primeira linha do arquivo que contém as casas decimais de pi é convertida para string
    final String piValue = lines.get(0).toString();
    // Após isso, a lista é fragmentada e os valores após o ponto são mapeados para um array de inteiros.
    final int[] piArray = piValue.substring(piValue.indexOf(".") + 1).chars().mapToObj(c -> (char) c).mapToInt(c -> c - 48).toArray();
    
    return piArray;
  }
}
