println("==================================================")
println("Si pienso en un número y le sumo 9, el resultado de esta suma lo multiplico por 3, y a este nuevo resultado le resto 5 y finalmente al valor obtenido lo divido entre 4, obtengo como resultado final un 7. ¿Cuál fue el número que pensé al principio?\n" +
        "Debe imprimir la fórmula planteada en el problema.\n" +
        "Debe imprimir la fórmula que usted aplica para resolver el problema.\n" +
        "Debe imprimir el número que se pensó al principio.")
println("==================================================\n")
println("Fórmula planteada en el problema:")
println("(x + 9) * 3 - 5) / 4 = 7")

val numeroPensado = (((7 * 4) + 5) / 3) - 9

println("\nFórmula para resolver el problema:")
println("x = (((7 * 4) + 5) / 3) - 9")

println("\nEl número que pensaste al principio es: $numeroPensado \n")


println("==================================================")
println("Supongamos que alguien toma la aguja que indica la hora en un reloj y la gira en sentido contrario desde las 2 hasta las nueve. ¿Cuántos grados habrá girado la aguja?\n" +
        "Debe imprimir la fórmula que usted aplica para resolver el problema.\n" +
        "Debe imprimir la cantidad de grados que giró la aguja.")
println("==================================================\n")

val gradosPorHora = 30
val horasGiradas = 5

val gradosGirados = horasGiradas * gradosPorHora

println("Fórmula aplicada para resolver el problema:")
println("gradosGirados = horasGiradas * gradosPorHora")
println("\ngradosGirados: $horasGiradas * gradosporhora: $gradosPorHora = ${gradosPorHora*horasGiradas}")

println("==================================================")
println("Hallar el menor de dos números enteros positivos, sin utilizar estructuras de control condicionales.\n" +
        "Debe crear por lo menos dos métodos que realicen dicha tarea.\n" +
        "Debe imprimir los dos números enteros.\n" +
        "Debe imprimir el menor de estos conforme a sus dos métodos.")
println("==================================================")

print("\nIngrese un valor entero positivo 1: ")
val num1 = readlnOrNull()?.toInt() as Int

print("\nIngrese un valor entero positivo 2: ")
val num2 = readlnOrNull()?.toInt() as Int

println("\nLos dos números ingresados son: $num1 y $num2")
println("\nEl menor número según el método 1 (min) es: ${menorConMin(num1, num2)}")
println("El menor número según el método 2 (aritmética) es: ${menorConAritmetica(num1, num2)}")

fun menorConMin(a: Int, b: Int): Int {
    return (a * (((a - b) shr 31) and 1 ) + b * (1 - (((a - b) shr 31) and 1 )))
}

fun menorConAritmetica(a: Int, b: Int): Int {
    return ((a + b - (if ((a - b) < 0) -(a - b) else (a - b))) / 2)
}


println("==================================================")
println("Determinar si dos números enteros son iguales, sin utilizar estructuras de control de condiciones, operadores de comparación o las operaciones de suma y resta.\n" +
        "Debe imprimir los dos números enteros.\n" +
        "Debe imprimir el resultado de igualdad entre estos.")
println("==================================================")

print("\nIngrese un valor entero 1: ")
val num3 = readlnOrNull()?.toInt() as Int

print("\nIngrese un valor entero 2: ")
val num4 = readlnOrNull()?.toInt() as Int

println("\nNúmero 1: $num3")
println("Número 2: $num4")
println("Los números ${num3 % num4} si el valor es 0 son igual sino son distintos.")

println("==================================================")
println("Sumar dos números enteros sin utilizar el operador aritmético de la suma.")
println("==================================================")

fun add(a: Int, b: Int): Int {
    var x = a
    var y = b
    while (y != 0) {
        val carry = x and y
        x = x xor y

        y = carry shl 1
    }
    return x
}

print("\nIngrese un valor entero positivo 1: ")
val num5 = readlnOrNull()?.toInt() as Int

print("\nIngrese un valor entero positivo 2: ")
val num6 = readlnOrNull()?.toInt() as Int

println("\nNúmero 1: $num5")
println("Número 2: $num6")

println("La suma de los números es: ${add(num5, num6)}")

