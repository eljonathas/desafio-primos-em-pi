public class Sequence {
  private String result = "";

  // O método isPrime verifica se o número recebido como parâmetro é primo.
  private final boolean isPrime(final int n) {
    if (n <= 1) return false;
    for (int i = 2; i * i <= n; i++) {
      if (n % i == 0) return false;
    }
    return true;
  }

  // O método check utiliza a recursividade para calcular os valores e formar a sequência
  public void check(final int index, final int[] numbersList, final StringBuilder strbd){
    int currentNumber = 0;
    final StringBuilder currentSequence = new StringBuilder();

    // O loop percorre todos os números da lista de números
    for(int i = index; i < numbersList.length; i++){
      currentNumber = currentNumber * 10 + numbersList[i];
      currentSequence.append(numbersList[i]);

      // Caso o valor de currentNumber exceda o limite permitido o loop é interrompido
      if(currentNumber > 9973){
        break;
      } else if(isPrime(currentNumber)){
        // Do contrário, o valor é adicionado à sequência e a função é chama novamente com o próximo index
        final StringBuilder newBuilder = new StringBuilder(strbd);
        newBuilder.append(currentSequence + " ");

        this.check(i + 1, numbersList, newBuilder);
      }
    }

    // Enquanto o tamanho de result for menor que o tamanho da sequência atual, seu valor é atualizado
    if (result.length() <= strbd.length()) {
      result = strbd.toString();
    }
  }

  // O método show retorna o resultado final
  public void show(final int[] numbersList) {
    // O loop percorre pela lista de números
    for(int i = 0; i < numbersList.length; i++){
      this.check(i, numbersList, new StringBuilder());
    }

    // Como os valores são separados por espaço em result, uma nova lista é formada com os valores separados
    final String[] numbers = this.result.split(" ");
    final StringBuilder resultBuilder = new StringBuilder();

    // Depois, os valores são ajustados para formar a sequência
    for(int i = 0; i < numbers.length; i++){
      resultBuilder.append(numbers[i]);
    }

    // Imprime a sequência
    System.out.println(resultBuilder.toString());
  }
}
