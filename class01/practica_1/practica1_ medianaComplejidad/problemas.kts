println("==================================================")
println("En matemáticas ustedes estudiaron un concepto llamado Coeficientes Binomiales o números combinatorios.")
println("==================================================")

fun factorial(n: Int): Long {
    return if (n == 0 || n == 1) 1 else n * factorial(n - 1)
}

fun coeficienteBinomial(n: Int, k: Int): Long {
    return factorial(n) / (factorial(k) * factorial(n - k))
}

print("\nIngrese el valor de n: ")
val n = readlnOrNull()?.toInt() as Int

print("\nIngrese el valor de k: ")
val k = readlnOrNull()?.toInt() as Int

val resultado = coeficienteBinomial(n, k)
println("\nEl coeficiente binomial de (9 sobre 4) es: $resultado")

println("==================================================")
println("Para el cálculo de la distancia entre dos puntos P1(x1, y1) hasta P2(x2, y2), tenemos:")
println("==================================================")

fun calcularDistancia(puntos: Map<String, Pair<Double, Double>>): Double {
    val (x1, y1) = puntos["P1"] ?: error("Punto P1 no encontrado")
    val (x2, y2) = puntos["P2"] ?: error("Punto P2 no encontrado")


    val dx = x2 - x1
    val dy = y2 - y1


    return Math.sqrt(dx * dx + dy * dy)
}

println("Ingrese las coordenadas del punto P1 (x1 y1):")
println("x1:")
val x1 = readLine()?.toDoubleOrNull() ?: error("Entrada inválida para x1")
println("y1:")
val y1 = readLine()?.toDoubleOrNull() ?: error("Entrada inválida para y1")

println("Ingrese las coordenadas del punto P2 (x2 y2):")
println("x2:")
val x2 = readLine()?.toDoubleOrNull() ?: error("Entrada inválida para x2")
println("y2:")
val y2 = readLine()?.toDoubleOrNull() ?: error("Entrada inválida para y2")

val puntos = mapOf(
    "P1" to Pair(x1, y1),
    "P2" to Pair(x2, y2)
)

val distancia = calcularDistancia(puntos)
println("La distancia entre los puntos es: $distancia")

println("==================================================")
println("Seiscientos Treinta y Uno => 631")
println("==================================================")

fun textToNumber(text: String): Int {
    val numbers = mapOf(
        "uno" to 1, "dos" to 2, "tres" to 3, "cuatro" to 4, "cinco" to 5,
        "seis" to 6, "siete" to 7, "ocho" to 8, "nueve" to 9, "diez" to 10,
        "once" to 11, "doce" to 12, "trece" to 13, "catorce" to 14, "quince" to 15,
        "dieciséis" to 16, "veinte" to 20, "veintiuno" to 21, "veintidós" to 22,
        "veintitrés" to 23, "veinticuatro" to 24, "veinticinco" to 25,
        "veintiséis" to 26, "veintisiete" to 27, "veintiocho" to 28,
        "veintinueve" to 29, "treinta" to 30, "cuarenta" to 40,
        "cincuenta" to 50, "sesenta" to 60, "setenta" to 70,
        "ochenta" to 80, "noventa" to 90, "cien" to 100,
        "doscientos" to 200, "trescientos" to 300, "cuatrocientos" to 400,
        "quinientos" to 500, "seiscientos" to 600, "setecientos" to 700,
        "ochocientos" to 800, "novecientos" to 900
    )

    val normalizedText = text.toLowerCase().replace("y", "").trim()
    val words = normalizedText.split("\\s+".toRegex())
    var number = 0

    for (word in words) {
        numbers[word]?.let {
            number += it
        }
    }

    return number
}

println("Ingrese el número en texto (dos o tres cifras):")
val input = readlnOrNull()?.trim()

if (input != null) {
    val number = textToNumber(input)
    println("El número es: $number")
} else {
    println("No se ha ingresado ningún valor válido.")
}
