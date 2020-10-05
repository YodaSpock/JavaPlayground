import java.util.ArrayList;
import java.util.Arrays;

//16.24
public class PairsWithSum {
    protected int[] numbers;
    protected int target;
    protected ArrayList<NumPair> pairs = new ArrayList<>();

    public PairsWithSum(int[] nums, int tar) {
        numbers = nums;
        target = tar;

    }

    public ArrayList<NumPair> findSorted(){

        int[] sorted = new int[numbers.length];
        Arrays.sort(numbers);
        int i = 0;
        int j = numbers.length - 1;
        while(i < j){
            if(numbers[i] + numbers[j] == target) {
                pairs.add(new NumPair(numbers[i], numbers[j]));
                i++;
            }else if(numbers[i] + numbers[j] > target){
                j--;
            }else{
                i++;
            }
        }
        System.out.println(Arrays.toString(numbers));
        return pairs;
    }

    public static void main(String[] args){
        int[] numbs = {7, 6, -3, 14, -8, 4, 12, 9, 0, 5};
        PairsWithSum sums = new PairsWithSum(numbs, 4);
        System.out.println(sums.pairs.toArray().toString());
    }
}
