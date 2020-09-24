public class BasicFunctions {

    public static String reverseSentence(String str){
        char arr[] = new char[str.length()];
        char temp[] = new char[str.length()];
        String finalStr = "";
        int loc = 0;

        for(int i = 0; i < str.length(); i++) {
            arr[i] = str.charAt(i);
        }
        //Convert
        for(int j = str.length() - 1; j >= 0 ; j--){
            temp[j] = arr[loc];
            loc++;
        }
        //Convert first char caps
        temp[0] = Character.toUpperCase(temp[0]);
        temp[str.length() - 1] = Character.toLowerCase((temp[str.length() - 1]));

        //Convert char array back to String
        for(int i = 0; i < str.length(); i++) {
            finalStr = finalStr + temp[i];
        }

        return finalStr;
    }

    /**
     * Returns if Prime or not and then number its divisible by
     * @param num
     * @return
     */
    public static String isPrimeNumber(int num){
        int guess = 2;
        while(guess < num ){
            if(num % guess == 0) {
                return "Not Prime, Divisible by: " + guess;
            }
            guess++;
        }
        return num + " is a Prime Number";
    }



    public static void main(String[] args){
        //System.out.println(reverseSentence("This is the end for you my master"));
        System.out.println(isPrimeNumber(29));

    }
}
