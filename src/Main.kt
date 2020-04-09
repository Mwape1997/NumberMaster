import java.lang.IllegalArgumentException
import java.util.Scanner
import java.util.stream.IntStream

val data = arrayOf(4, 6, 7, 1)  //number to be guessed
var inputData:Int = 0   //input data
var inputDataArray = arrayOf(0, 0, 0, 0)    //input array
var valid = true    //checking if number is valid or not
var tick:Char = '\u2813'
var correctNotPlace:Char = '\u256C'
var incorrect: Char = 'X'
var resultArray = arrayOf('-', '-', '-', '-')   //result array so we can check if the player has guessed all numbers right
var inArray = false

fun main(args: Array<String>) {
    println("Welcome to the guessing game! ;)")
    UI()
}

fun UI(){
    val reader = Scanner(System.`in`)   //initialize a scanner object
    println("Enter one value at a time: ")
    for (i in 0..3){                    //populate the array with inputs
        inputData= reader.nextInt()

        if ((inputData <= 9) && !(isInArray())){    //if input is valid, we add it to the array
            inputDataArray[i] = inputData

        }

        else {  //else cycle until you get a correct input
            valid = false
            print("Invalid input!")
            while(!(valid)){
                inputData = reader.nextInt()
                if ((inputData <= 9) && !(isInArray())){
                    inputDataArray[i] = inputData
                    valid = true
                }
            }
        }
    }

    for (i in 0..3){    //print out the array elements
        println(inputDataArray[i])
    }

    result()
}

fun isInArray(): Boolean{        //checks if a value is in the array
    inArray = false
    for(i in 0..3){
        val toFind = inputData

        for (n in inputDataArray) {
            if (n == toFind) {
                return true
            }
        }
    }

    return false

}


fun result(){
/*
special chars dont show up in console so I have replaced them with :

    T : Number found in correct place
    C : Number found but in correct place
    I : Number not found
*/
    for (i in 0..3){    //cycle through the arrays
            if(inputDataArray[i] == data[i]){   //if the input is the same as the number to be guessed at the right spot
                resultArray[i] = 'T'    //return a T
                print(" T ")

            }

            else{                           //else look if that number exists anywhere in the data array
                val toFind = inputDataArray[i]  //look for the number
                var found = false

                for (n in data) {       //if you find it, put a C
                    if (n == toFind) {
                        found = true
                        break
                    }
                }

                if (found){
                    resultArray[i] = 'C'
                    print(" C ")
                }

                else{   //if not, put a I
                    resultArray[i] = 'I'
                    print(" I ")
                }
            }

        }

    for (i in 0..3){
        if(resultArray[i] != 'T'){
            println("Not Correct! Have another try :)")
            inputDataArray = arrayOf(0, 0, 0, 0)    // reset input array
            UI()
            break
        }
    }

}
