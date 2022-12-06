fun main(args: Array<String>) {
    println(max(1,2,3,4,5,6,7,8,9,10))
    println(greetMany("hello", "matheus", "teste"))

    val arr = listOf(1, 2, 3, 4).toIntArray()
    println(max(*arr))

    for (i in 1 until 5) { print("$i ") }
    for (i in 1 until 30 step 3) { print("$i ") }
    for (i in 5 downTo 5) { print("$i ") }
    for (i in 100 downTo 1 step 10) { print("$i ") }

    for (i in (1..10).filter { it % 2 == 0}) { print("$i ")}


    val names = listOf("mbappe", "messi", "neymar")
    for (n in names) { print("$n ") }

    for (index in names.indices) {
        println("Position of ${names[index]} is $index")
    }

    for ((index, name) in names.withIndex()) {
        println("Position of $name in $index")
    }

    println(whatToDo("Sunday"))
    println(whatToDo("Wednesday"))
    println(whatToDo(3))
    println(whatToDo("Friday"))
    println(whatToDo("Munday"))
    println(whatToDo(8))

    println(systemInfo())

    val airportCodes = listOf("LAX", "SFO", "PDX", "SEA")
    val temperatures = airportCodes.map { code -> code to getTemperatureAtAirport(code)}

    for(temp in temperatures) {
        println("Airport: ${temp.first}: Temperature: ${temp.second} C")
    }

    val fruits: List<String> = listOf("Apple", "BANANA", "Grape")
    println(fruits)

    val fruitsSet = setOf("Apple", "Banana", "Apple")
    println("${fruitsSet::class}, ${fruitsSet::javaClass}")

    val sites = mapOf("pragprog" to "https://www.pragprog.com", "agiledeveloper" to "https://agiledeveloper.com")
    println(sites)

    val pragProgSite: String? = sites["pragprog"]
    val agileDeveloperSite = sites.getOrDefault("agiledeveloper", "https://default.com")

    println(pragProgSite)
    println(agileDeveloperSite)


    for((key, value) in sites) {
        println("key: $key - values: $value")
    }

    println(nickName("Matheus"))
    println(nickName("William"))
    println(nickName(null))

}

fun nickName(name: String?): String = when(name) {
    "William" -> "Bill"
    null -> "Joker"
    else -> name.reversed().uppercase()
}

fun getTemperatureAtAirport(code: String): String = "${Math.round(Math.random() * 30) + code.count()}"

fun systemInfo(): String =
    when(val numberOfCores = Runtime.getRuntime().availableProcessors()) {
        1 -> "1 core, packing this to the museum"
        in 2..16 -> "You have $numberOfCores cores"
        else -> "$numberOfCores cores!, I want your machine"
    }

fun whatToDo(dayOfWeek: Any) = when(dayOfWeek) {
    "Saturday", "Sunday" -> "Relax"
    in listOf("Monday", "Tuesday", "Wednesday", "Thursday") -> "Work Hard"
    in 2..4 -> "Work hard"
    "Friday" -> "Party"
    is String -> "What?"
    else -> "No clue"
 }

fun greetMany(msg: String = "Hello", vararg names: String) {
    println("$msg, ${names.joinToString(",")}")
}

fun max(vararg nums: Int): Int {
    var large = Int.MIN_VALUE
    for (number in nums) {
        if (number > large) {
            large = number
        }
    }

    return large
}