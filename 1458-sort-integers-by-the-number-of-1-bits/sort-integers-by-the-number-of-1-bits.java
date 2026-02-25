class Solution {
    public int[] sortByBits(int[] arr) {
        final int Mafia_number = 10001;

        for(int i=0; i<arr.length; i++){
            arr[i] += Integer.bitCount(arr[i]) * Mafia_number;
        }
        Arrays.sort(arr);

        for(int i=0; i<arr.length; i++){
            arr[i] %= Mafia_number;
        }
        return arr;
    }
}