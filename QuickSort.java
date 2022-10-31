import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author dania
 */
public class QuickSort {

    public static BufferedReader bufer = new BufferedReader(new InputStreamReader(System.in));
    public static String entrada;

    public static int[] leerArreglo(int n) throws IOException {
        int[] a = new int[n];
        System.out.println("--------------------------------------------------");
        for (int i = 0; i < a.length; i++) {
            System.out.println("Escriba el valor [" + i + "]: ");
            entrada = bufer.readLine();
            a[i] = Integer.parseInt(entrada);
        }
        return a;
    }
    
    public static void quickSort(int[] listaD, int inicio, int fin){
        int pivote = listaD[inicio];
        int i = inicio;
        int j=fin;
        int mant;
        while(i<j){
            while(listaD[i]<=pivote && i<j){
                i++;
            }
            while(listaD[j]>pivote){
                j--;
            }
            if(i<j){
                mant = listaD[i];
                listaD[i]=listaD[j];
                listaD[j]=mant;
            }
        }
        listaD[inicio]= listaD[j];
        listaD[j]=pivote;
        if(inicio<j-1){
            quickSort(listaD, inicio, j-1);
        }
        if(j+1 < fin){
            quickSort(listaD, j+1, fin);
        }
    }

    public static void imprimirArreglo(int[] a) {
        System.out.println("-------------------------");
        System.out.println("Lista ordenada");
        for (int i = 0; i < a.length; i++) {
            System.out.printf("%4d", a[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        int[] array;
        int t;
        System.out.println("Programa que ordena la lista de números");
        System.out.println("Escribe la longitud de la lista a ingresar: ");
        entrada = bufer.readLine();
        t = Integer.parseInt(entrada);
        array = leerArreglo(t);
        int inicio = 0;
        int fin = array.length-1;
        quickSort(array, inicio, fin);
        imprimirArreglo(array);
    }
}
