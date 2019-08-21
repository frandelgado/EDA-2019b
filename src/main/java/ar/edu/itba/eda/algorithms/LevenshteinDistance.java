package ar.edu.itba.eda.algorithms;

public class LevenshteinDistance {

    public static int levenshteinDistance(String str1, String str2){
        char[] arr1 = str1.toUpperCase().toCharArray();
        char[] arr2 = str2.toUpperCase().toCharArray();
        int[][] matrix = new int[str1.length()+1][str2.length()+1];

        for(int i=1; i<str1.length(); i++){
            matrix[i][0] = arr1[i-1];
        }
        for(int j=1; j<str2.length(); j++){
            matrix[0][j] = arr2[j-1];
        }
        int sustitutionCost = 0;
        for(int j=1; j <= str2.length(); j++){
            for(int i=1; i <= str1.length(); i++){
                if(arr1[i-1] == arr2[j-1]){
                    sustitutionCost = 0;
                } else {
                    sustitutionCost = 1;
                }
                int minCost = Math.min(matrix[i-1][j] + 1, matrix[i][j-1] + 1);
                minCost = Math.min(matrix[i-1][j-1] + sustitutionCost, minCost);
                matrix[i][j] = minCost;
            }
        }
        return matrix[str1.length()][str2.length()];
    }

    public static double normalizedLevenshteinDistance(String str1, String str2){
        return 1d - ((double)(levenshteinDistance(str1, str2))/Math.max(str1.length(), str2.length()));

    }
}
