public class Sequence {
  private String result = "";

  private final boolean isPrime(final int n) {
    if (n <= 1) return false;
    for (int i = 2; i * i <= n; i++) {
      if (n % i == 0) return false;
    }
    return true;
  }

  public void check(final int index, final int[] numbersList, final StringBuilder strbd){
    int currentNumber = 0;
    final StringBuilder currentSequence = new StringBuilder();

    for(int i = index; i < numbersList.length; i++){
      currentNumber = currentNumber * 10 + numbersList[i];

      currentSequence.append(numbersList[i]);

      if(currentNumber > 9973){
        break;
      } else if(isPrime(currentNumber)){
        final StringBuilder newBuilder = new StringBuilder(strbd);
        newBuilder.append(currentSequence + " ");

        this.check(i + 1, numbersList, newBuilder);
      }
    }

    if (result.length() <= strbd.length()) {
      result = strbd.toString();
    }
  }

  public void show(final int[] numbersList) {
    for(int i = 0; i < numbersList.length; i++){
      this.check(i, numbersList, new StringBuilder());
    }

    final String[] numbers = this.result.split(" ");
    final StringBuilder resultBuilder = new StringBuilder();

    for(int i = 0; i < numbers.length; i++){
      resultBuilder.append(numbers[i]);
    }

    System.out.println(resultBuilder.toString());
  }
}
