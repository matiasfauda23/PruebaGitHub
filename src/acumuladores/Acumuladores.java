package acumuladores;

public class Acumuladores {

	public boolean todosMultiplosEnAlgunaFila(int[][] mat, int num) {
	    // Verificamos si la matriz es nula, vacía o el número es no positivo
	    if (mat == null || mat.length == 0 || num <= 0) {
	        return false;
	    }

	    // Recorremos las filas de la matriz
	    boolean hayAlgunaFila = false;
	    for (int f = 0; f < mat.length; f++) {
	        // Verificamos si la fila actual cumple con ser múltiplo del parámetro dado
	        hayAlgunaFila = hayAlgunaFila || tieneTodosMultiplos(mat[f], num);
	    }
	    return hayAlgunaFila;
	}

	// Método auxiliar para verificar si todos los elementos de una fila son múltiplos del número dado
	private boolean tieneTodosMultiplos(int[] fila, int num) {
	    boolean todosMultiplos = true;
	    //Recorremos cada valor de la fila
	    for (int i = 0; i < fila.length; i++) {
	        // Si encontramos un elemento que no es múltiplo, marcamos todosMultiplos como falso
	    	todosMultiplos = todosMultiplos && esMultiplo(fila[i], num);
	    }
	    return todosMultiplos;
	}

	// Método auxiliar para verificar si un número es múltiplo del número dado
	private boolean esMultiplo(int num, int divisor) {
	    return num % divisor == 0;
	}


	
	
	


	public boolean hayInterseccionPorFila(int[][] mat, int[][] mat2) {
		// Verificamos si alguna matriz es vacía o si tienen distinta cantidad de filas
		if(esVacia(mat) || esVacia(mat2) || mat.length != mat2.length) {
			return false;
		}
		//Verificamos si todas las filas tiene interseccion
		boolean hayInterseccionTodas = true;
		for(int f = 0 ; f < mat.length ; f++) {
			//Vemos si la fila actual interseca con la otra matriz
			hayInterseccionTodas = hayInterseccionTodas && tieneInterseccion(mat[f],mat2[f]);
		}
		return hayInterseccionTodas;

	}
	//Verificamos si dos filas/arreglos tienen elementos en comun
	private boolean tieneInterseccion(int[] fil1, int[] fil2) {
		//Recorro cada elemento de la primer fila
		for(int i = 0 ; i < fil1.length ; i++) {
			//Verifico que la fila2 contenga el elemento 1.
			if(contieneElemento(fil2 , fil1[i])) {
				return true;
			}
		}
		return false;
	}

	private boolean contieneElemento(int[] arr, int elem) {
		for(int i = 0; i < arr.length ; i++ ) {
			if(arr[i] == elem) {
				return true;
			}
		}
		return false;
	}

	
	
	
	
	


	public boolean algunaFilaSumaMasQueLaColumna(int[][] mat, int nColumna) {
		//Verificamos si la matriz es vacia o indice de columna invalido
		if(mat == null || mat.length == 0 || nColumna < 0 || nColumna >= mat[0].length) {
			return false;
		}
		//Calculamos la suma de la columna  nColum
		int sumaColumna = calcularSumaColumna(mat , nColumna);
		
		// Verificamos si alguna fila tiene una suma mayor que la suma de la columna
	    return existeFilaConSumaMayorQueColumna(mat, sumaColumna);

	}
	
	private boolean existeFilaConSumaMayorQueColumna(int[][] mat, int sumaColumna) {
		boolean hayFilaConSumaMayor = false;
	    for (int f = 0; f < mat.length; f++) {
	        int sumaFila = calcularSumaFila(mat[f]);
	        hayFilaConSumaMayor = hayFilaConSumaMayor || (sumaFila > sumaColumna);
	    }
	    return hayFilaConSumaMayor;
	}
	private int calcularSumaFila(int[] fila) {
		int sumaFila = 0;
	    for (int i = 0; i < fila.length; i++) {
	        sumaFila = sumaFila + fila[i];
	    }
	    return sumaFila;
	}
	
	private int calcularSumaColumna(int[][] mat, int nColumna) {
		int sumaColumna = 0;
	    for (int i = 0; i < mat.length; i++) {
	        sumaColumna += mat[i][nColumna];
	    }
	    return sumaColumna;
	}

	
	
	
	
	
	

	public boolean hayInterseccionPorColumna(int[][] mat1, int[][] mat2) {
	    // Verificamos si las matrices tienen la misma cantidad de columnas y no están vacías
	    if (esMatrizVaciaOColumnasDesiguales(mat1, mat2)) {
	        return false;
	    }

	    // Verificamos si todas las columnas tienen intersección
	    boolean hayInterseccion = true;
	    for (int c = 0; c < mat1[0].length; c++) {
	    	//Verifico de la columna actual c tiene interseccion con mat1 y mat2
	        hayInterseccion = hayInterseccion && columnaTieneInterseccion(mat1, mat2, c);
	    }

	    return hayInterseccion;
	}

	// Método auxiliar para verificar si una columna tiene intersección
	private boolean columnaTieneInterseccion(int[][] mat1, int[][] mat2, int col) {
	    boolean tieneInterseccion = false;
	    for (int i = 0; i < mat1.length; i++) {
	        tieneInterseccion = tieneInterseccion || contieneElemento(mat2, col, mat1[i][col]);
	    }
	    return tieneInterseccion;
	}

	// Método auxiliar para verificar si una columna contiene un elemento
	private boolean contieneElemento(int[][] mat, int col, int elem) {
	    boolean encontrado = false;
	    for (int i = 0; i < mat.length; i++) {
	        encontrado = encontrado || (mat[i][col] == elem);
	    }
	    return encontrado;
	}


	
	
	
	private boolean esVacia(int[][] mat) {
		return mat == null || mat.length == 0 || mat[0].length == 0;	
	}
	// Método auxiliar para verificar si las matrices están vacías o tienen diferente cantidad de columnas
		private boolean esMatrizVaciaOColumnasDesiguales(int[][] mat1, int[][] mat2) {
		    return mat1 == null || mat2 == null || mat1.length == 0 || mat2.length == 0 || mat1[0].length != mat2[0].length;
		}
}
