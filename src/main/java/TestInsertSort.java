import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class TestInsertSort {

    public static void main(String[] args) {
        List<Integer> unSortedArray = Arrays.asList(434, 24, 4334, 434, 1111);
        List<Integer> sortedArray = selectionSort(unSortedArray, (o1, o2) -> o1 - o2);
        System.out.print("before sort: ");
        printList(unSortedArray);
        System.out.println();
        System.out.print("after sort: ");
        printList(sortedArray);

        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    private static void printList(List<Integer> sortedArray) {
        for (int i = 0; i < sortedArray.size() - 1; i++) {
            System.out.print(sortedArray.get(i) + " ");
        }
        System.out.print(sortedArray.get(sortedArray.size() - 1));
    }

    private static List<? extends Comparable> selectionSort(List<? extends Comparable> mParamList) {
        if (mParamList == null || mParamList.isEmpty()) {
            return mParamList;
        }
        ArrayList<Comparable> resultList = new ArrayList<>(mParamList);

        int minIndex = 0;
        for (int i = 0; i < resultList.size(); i++) {
            minIndex = i;
            for (int j = i + 1; j < resultList.size(); j++) {
                if (resultList.get(minIndex).compareTo(resultList.get(j)) > 0) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                Comparable temp = resultList.get(minIndex);
                resultList.set(minIndex, resultList.get(i));
                resultList.set(i, temp);
            }
        }
        return resultList;
    }

    private static <T> List<T> selectionSort(List<T> mParamList, Comparator<T> comparator) {
        if (mParamList == null || mParamList.isEmpty()) {
            return mParamList;
        }
        if (comparator == null) {
            System.out.println("comparator can't null");
            return mParamList;
        }
        List<T> resultList = new ArrayList<>(mParamList);

        int minIndex = 0;
        for (int i = 0; i < resultList.size(); i++) {
            minIndex = i;
            for (int j = i + 1; j < resultList.size(); j++) {
                if (comparator.compare(resultList.get(minIndex), resultList.get(j)) > 0) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                T temp = resultList.get(minIndex);
                resultList.set(minIndex, resultList.get(i));
                resultList.set(i, temp);
            }
        }
        return resultList;
    }

}
