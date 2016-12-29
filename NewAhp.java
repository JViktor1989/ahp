/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newahp;

/**
 *
 * @author Vitor
 */
public class NewAhp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        double matCompCrit[][] = {{1, 6, 8}, {0.17, 1, 0.2}, {0.33, 5, 0.13}};
        double matCompAlter1[][] = {{1, 0.17, 0.2, 7}, {6, 1, 4, 7}, {5, 0.25, 1, 6}, {0.14, 0.14, 0.17, 1}};
        double matCompAlter2[][] = {{1, 0.17, 0.13, 5}, {6, 1, 0.25, 7}, {8, 4, 1, 0.11}, {0.2, 0.14, 9, 1}};
        double matCompAlter3[][] = {{1, 0.14, 1, 0.13}, {7, 1, 8, 0.17}, {1, 0.13, 1, 0.13}, {8, 6, 8, 1}};

        double vetorL = valorRC(matCompCrit);

    }

    public static double[][] exibeMatriz(double[][] matrix) {
        double[][] matrizA = new double[matrix.length][matrix.length];

        System.out.println("Matriz");
        for (int i = 0; i < matrizA.length; i++) {
            for (int j = 0; j < matrizA[i].length; j++) {
                matrizA[i][j] = matrix[i][j];
                System.out.print(matrizA[i][j] + "|");
            }
            System.out.println();
        }
        System.out.println();
        return matrizA;
    }

    public static double[] somaColuna(double matrix[][]) {
        double[] vetorA = new double[matrix.length];

        System.out.println("Soma das Colunas");
        double count = 0;
        for (int i = 0; i < vetorA.length; i++) {
            for (int j = 0; j < vetorA.length; j++) {
                count += matrix[j][i];
            }
            vetorA[i] = count;
            count = 0;
        }
        for (int i = 0; i < vetorA.length; i++) {
            System.out.print("|" + vetorA[i] + "|");
        }
        System.out.println();
        return vetorA;
    }

    public static double[] somaLinha(double matrix[][]) {
        double[] vetorA = new double[matrix.length];

        System.out.println("Soma das Linhas");
        double count = 0;
        for (int i = 0; i < vetorA.length; i++) {
            for (int j = 0; j < vetorA.length; j++) {
                count += matrix[i][j];
            }
            vetorA[i] = count;
            count = 0;
        }
        for (int i = 0; i < vetorA.length; i++) {
            System.out.println("|" + vetorA[i] + "|");
        }
        System.out.println();
        return vetorA;
    }

    public static double[][] normalizar(double[][] matrix, double[] vetor) {
        double[][] matrizA = exibeMatriz(matrix);
        double[] vetorA = somaColuna(matrix);

        for (int i = 0; i < matrizA.length; i++) {
            for (int j = 0; j < matrizA[i].length; j++) {
                matrizA[j][i] = matrizA[j][i] / vetorA[i];
            }
        }
        System.out.println();
        System.out.println("Matriz normalizada");
        for (int i = 0; i < matrizA.length; i++) {
            for (int j = 0; j < matrizA[i].length; j++) {
                System.out.print(matrizA[i][j] + "|");
            }
            System.out.println();
        }
        System.out.println();
        return matrizA;
    }

    public static double[] somaNormalida(double[][] matrix) {
        double[] vetorA = new double[matrix.length];
        double[][] matrizA = normalizar(matrix, vetorA);

        System.out.println("Soma Normalizada");
        double count = 0;
        for (int i = 0; i < vetorA.length; i++) {
            for (int j = 0; j < vetorA.length; j++) {
                count += matrizA[j][i];
            }
            vetorA[i] = count;
            count = 0;
        }
        for (int i = 0; i < vetorA.length; i++) {
            System.out.print("|" + vetorA[i] + "|");
        }
        System.out.println();
        return vetorA;
    }

    public static double[] somaLinhanormalizada(double[][] matrix) {
        double[] vetorA = new double[matrix.length];
        double[][] matrizA = normalizar(matrix, vetorA);

        System.out.println("Soma das Linhas normalizadas");
        double count = 0;
        for (int i = 0; i < vetorA.length; i++) {
            for (int j = 0; j < vetorA.length; j++) {
                count += matrizA[i][j];
            }
            vetorA[i] = count;
            count = 0;
        }
        for (int i = 0; i < vetorA.length; i++) {
            System.out.println("|" + vetorA[i] + "|");
        }
        System.out.println();
        return vetorA;
    }

    public static double[] vetorNormalizdo(double[][] matrix) {
        double[] vetorA = somaLinhanormalizada(matrix);

        System.out.println("Vetor Proprio ");
        double count = 0;
        for (int i = 0; i < vetorA.length; i++) {
            count = vetorA.length;
        }
        for (int i = 0; i < vetorA.length; i++) {
            vetorA[i] = vetorA[i] / count;
        }
        for (int i = 0; i < vetorA.length; i++) {
            System.out.println("|" + vetorA[i] + "|");
        }
        System.out.println();
        return vetorA;
    }

    public static double[] vetorX(double[][] matrix) {
        double[][] matrizA = exibeMatriz(matrix);
        double[] vetorA = vetorNormalizdo(matrix);
        double[] vetorB = new double[matrix.length];

        for (int i = 0; i < matrizA.length; i++) {
            for (int j = 0; j < matrizA[i].length; j++) {
                matrizA[j][i] = matrizA[j][i] * vetorA[i];
            }
        }
        System.out.println();
        System.out.println("MatrizX");
        for (int i = 0; i < matrizA.length; i++) {
            for (int j = 0; j < matrizA[i].length; j++) {
                System.out.print(matrizA[i][j] + "|");
            }
            System.out.println();
        }
        double count = 0;
        for (int i = 0; i < matrizA.length; i++) {
            for (int j = 0; j < matrizA.length; j++) {
                count += matrizA[i][j];
            }
            vetorB[i] = count;
            count = 0;
        }
        System.out.println();
        System.out.println("VetorX");
        for (int i = 0; i < vetorB.length; i++) {
            System.out.println("|" + vetorB[i] + "|");
            {

            }
        }
        System.out.println();
        return vetorB;
    }

    public static double lambdaMax(double[][] matrix) {
        double[] vetorA = vetorNormalizdo(matrix);
        double[] vetorB = vetorX(matrix);
        double[] vetorC = new double[matrix.length];

        double count = 0;
        double counter = 0;

        System.out.println("LambMax");
        for (int i = 0; i < vetorB.length; i++) {
            vetorC[i] = vetorB[i] / vetorA[i];
            count++;
        }

        for (int i = 0; i < vetorB.length; i++) {
            System.out.println("|" + vetorC[i] + "|");
        }
        for (int i = 0; i < vetorB.length; i++) {
            counter = counter + vetorC[i];
        }
        System.out.println();
        System.out.println("SomaMax");
        System.out.println("|" + counter / count + "|");
        System.out.println();
        return counter / count;
    }

    public static double valorIC(double[][] matrix) {
        double[] vetorA = somaLinha(matrix);
        double lMax = lambdaMax(matrix);
        double count = 0;
        double reduce = 0;
        double result = 0;

        System.out.println("IC");
        for (int i = 0; i < vetorA.length; i++) {
            count++;
        }
        reduce = count - 1;
        result = (lMax - count) / reduce;

        System.out.println(result);
        System.out.println();
        return result;
        
    }

    public static double valorRC(double[][] matrix) {
        double[] tabelaRC = {0, 0, 0.58, 0.90, 1.12, 1.24, 1.32, 1.41, 1.45, 1.49, 1, 51, 1.48, 1.56, 1.57, 1.59};
        double[] vetorA = somaLinha(matrix);
        double ic = valorIC(matrix);
        double count = 0;
        double result = 0;

        System.out.println("RC");
        for (int i = 0; i < vetorA.length; i++) {
            count = tabelaRC[i];
        }
        result = ic / count;
        System.out.println(result);
        return result;
    }

}
