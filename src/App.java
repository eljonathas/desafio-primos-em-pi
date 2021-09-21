import java.util.List;

public class App {
  public static void main(String[] args) throws Exception {
    // Cria novas instâncias das classes File e Sequence
    final File file = new File();
    final Sequence sequence = new Sequence();

    // Verifica se foi passado o argumento com o caminho relativo ao arquivo de teste
    if(args[0].length() > 0){
      // Corretamente informado, o caminho é lido pelo método read que retorna uma lista de strings
      final List<String> lines = file.read(args[0]);
      // Com a lista devidamente formada, o método parseLinesToNumbersList é chamado para converter seus valores em número
      final int[] numbersList = file.parseLinesToNumbersList(lines);

      // No fim, o array de números é passado para o método show que irá imprimir na tela a sequência com os valores computados
      sequence.show(numbersList);
    }else{
      System.out.println("Please, enter a file path.");
    }
  }
}
