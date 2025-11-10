public class Primes {
    private int MAX_PRIME_ARRAY_SIZE = 100;
    private int currentPrime;
    private int[] primesArray = new int[MAX_PRIME_ARRAY_SIZE];
    public Primes(){
        this.currentPrime = 0;
        primesArray = this.genPrimes(2);
    }
    public int next(){
        //andando a incrementi di 1 non ho mai il caso dove l'indice supera la dimensione massima
        if(this.currentPrime == MAX_PRIME_ARRAY_SIZE){
            primesArray = this.genPrimes(primesArray[this.currentPrime - 1]);
            //resetto l'indice per scorrere l'array di primi
            this.currentPrime = 0;
        }
        return primesArray[this.currentPrime++];
    }

    //metodo utility per generare un array contenente MAX_PRIME_ARRAY_SIZE primi, partendo dal numero start
    private int[] genPrimes(int start){
        int primeGenerated = 0;
        int currentNumber = start;
        int[] primes = new int[MAX_PRIME_ARRAY_SIZE];
        while(primeGenerated < MAX_PRIME_ARRAY_SIZE){
            if(this.isPrime(currentNumber)){
                primes[primeGenerated++] = currentNumber;
            }
            currentNumber++;
        }

        return primes;
    }

    private boolean isPrime(int n){
        for(int i = 2; i*i <= n; i++){
            if(n % i == 0) return false;
        }
        return true;
    }
}
