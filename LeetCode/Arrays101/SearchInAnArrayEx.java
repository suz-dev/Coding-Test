package arrays101;

// What happens when we call the linearSearch function. 
public class SearchInAnArrayEx {

	public static void main(String[] args) {
		int[] arr = new int[6];

		int length = 0;

		for (int i = 0; i < 6; i++) {
			arr[length++] = i;
		}

		System.out.println("Does the array contain the element 4? - " + SearchInAnArrayEx.linearSearch(arr, length, 4));
		System.out.println("Does the array contain the element 30? - " + SearchInAnArrayEx.linearSearch(arr, length, 30));

	}

	public static boolean linearSearch(int[] arr, int length, int element) {
		if (arr == null || length == 0) {
			return false;
		}

		for (int i = 0; i < length; i++) {
			if (arr[i] == element) {
				return true;
			}
		}
		return false;
	}
}
