package acumuladores;

public class AcumuladoresPrueba {
	/*Implementar metodo que recibe una matriz de enteros, mat
	 * un arreglo de enteros, vec y un valor entero k. Y retorta True
	 * si existe alguna columna donde todos sus elementos sean iguales a los 
	 * elementos de vec multiplicados por k, elemento a elemento.
	 * Utilizar acumuladores booleanos.
	 * La matriz no tiene necesariamente la misma cantidad de filas que columnas
	 *,pero el arreglo siempre tiene tantos elementos como filas de la matriz.
	 * Si la matriz es vacia o el vector es vacio, devuelve False. K siempre es un positivo.
	 */

	public static boolean existeColumnaMultiplo(int [][] mat , int [] vec , int k) {
		boolean ret = false;
		//Recorremos cada columna de mat
		for(int col = 0 ; col < mat[0].length ; col++) {
			//Verificamos si la columna actual cumple con la condicion
			ret = ret || columnaMultiploArr(mat,col,vec,k);
		}
		return ret;
	}

	private static boolean columnaMultiploArr(int[][] mat, int col, int[] vec, int k) {
		boolean ret = true;
		//Recorremos cada fila de la columna especificada
		for(int fila = 0 ; fila < mat.length ; fila++) {
			//Verificamos si el elemento en la posicion [fila][col] es igual al elemento del vector * k
			ret = ret && mat[fila][col] == vec[fila]*k;
		}
		return ret;
	}
}
