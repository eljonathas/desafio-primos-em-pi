import java.util.List;

public class App {
  public static void main(String[] args) throws Exception {
    final File file = new File();
    final Sequence sequence = new Sequence();

    final List<String> lines = file.read("lib/pi-1M.txt");
    final int[] numbersList = file.parseLinesToNumbersList(lines);

    sequence.show(numbersList);
  }
}
