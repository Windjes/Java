package Strings;

public class Separator {
    int array[];

    public Separator(int array[]) {
        this.array = array;
    }

    int[] even() {
        int a = 0, res = 0;
        for (int i : array) {
            if (i % 2 == 0) res++;
        }
        int[] evens = new int[res];
        for (int i = 0; i < array.length; i++){
            if (array[i] % 2 == 0){
                evens[a] = array[i];
                a ++;
                System.out.println(evens[a - 1]);
            }
        }

        return evens;
    }
}
