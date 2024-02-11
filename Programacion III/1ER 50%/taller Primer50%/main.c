#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <string.h>
#include <stdbool.h>
#include <ctype.h>
#include <math.h>

//Punto 1
//funcion para validar si el numero esta en el rango establecido
bool validNumber(int number) {
    return number >= 1 && number <= 3000;
}

void numberToRoman(int number) {
    int number2 = number;
    if (!validNumber(number)) {
        printf("Not valid.\n");
        return;
    }

    const char *roman[] = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    int romanValues[] = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

    // Construir el número romano
    char romanNumber[20];
    int i = 0;

    while (number > 0) {
        for (int j = 0; j < 13; j++) {
            if (number >= romanValues[j]) {
                while (number >= romanValues[j]) {
                    strcat(romanNumber, roman[j]);
                    number -= romanValues[j];
                }
            }
        }
    }

    printf("Roman number of %d is %s\n", number2, romanNumber);
}



// Punto 2

void primeFactors(int number) {
    int factor = 2;
    int exponent = 0;

    printf("%d = ", number);

    while (number > 1) {
        if (number % factor == 0) {
            exponent++;
            number /= factor;
        } else {
            if (exponent > 0) {
                printf("%d^%d", factor, exponent);
                if (number > 1) {
                    printf(" * ");
                }
                exponent = 0;
            }
            factor++;
        }
    }

    if (exponent >0) {
        printf("%d^%d", factor, exponent);
    }

    printf("\n");
}

//Punto 3

void properName(char *string) {

    if (string == NULL || strlen(string) == 0) {
        return;
    }

    int length = strlen(string);
    int isFirstLetter = 1;
    int resultIndex = 0;

    for (int i = 0; i < length; i++) {
        string[i] = tolower(string[i]);

        if (isspace(string[i])) {
            isFirstLetter = 1;
        } else if (isFirstLetter) {
            string[i] = toupper(string[i]);
            isFirstLetter = 0;
        }

        if (!isspace(string[i]) || (i > 0 && !isspace(string[i - 1]))) {
            string[resultIndex] = string[i];
            resultIndex++;
        }
    }
    
    string[resultIndex] = '\0';
}

//4
bool verifyEgolatet(int egolater) {
    int digito = 0, aux = egolater, sum = 0;

    while (aux > 0) {
        digito = aux % 10;
        int powDigito = pow(digito, 3);
        sum += powDigito;
        aux /= 10;
    }

    if (egolater == sum) {
        return true;
    } else {
        return false;
    }
}


int numberDivisors(int number) {
    int i, sum = 0;

    for (i = 1; i < number; i++) {
        if ((number % i) == 0) {
            sum += i;
        }
    }
    return sum;
}

//5
bool verifyFriendsNumber(int numberOne, int numberTwo) {
    int sum = 0;

    sum = numberDivisors(numberOne);

    if (sum == numberTwo) {
        sum = numberDivisors(numberTwo);
        if (sum == numberOne) {
            return true;
        }
    } else {
        return false;
    }
}

//6
const char *nameMoths[] = {"January", "February", "March", "April", "May", "June",
                           "July", "August", "September", "October", "November", "December"};

bool isLeapYear(int year) {
    return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
}

void describeDate(const char *date) {
    int day, month, year;
    if (sscanf(date, "%d/%d/%d", &day, &month, &year) == 3 &&
        month >= 1 && month <= 12 &&
        day >= 1 && day <= (month == 2 && isLeapYear(year) ? 29 : (31 - (month - 1) % 7 % 2))) {
        printf("%d de %s de %d\n", day, nameMoths[month - 1], year);
    } else {
        printf("Date not valid.\n");
    }
}

//7.
int productPoint(int array1[], int array2[], int size) {
    int result = 0;

    for (int i = 0; i < size; i++) {
        result += array1[i] * array2[i];
    }

    return result;
}

//8.
void inputMatrix(int matrix[][3]) {
    int side;
    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
            printf("Enter the element at position [%d][%d]: ",i,j);
            scanf("%d", &side);
            matrix[i][j]=side;
        }
    }
}

void multiplyMatrix(int matrix1[][3], int matrix2[][3], int result[][3]) {
    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
            result[i][j] = 0;
            for (int k = 0; k < 3; k++) {
                result[i][j] += matrix1[i][k] * matrix2[k][j];
            }
        }
    }
}

//9
void generateMagicMatrix(int n) {
    int matrix[n][n];
    int i, j;

    // Inicializar todos los elementos de la matriz a 0
    for (i = 0; i < n; i++) {
        for (j = 0; j < n; j++) {
            matrix[i][j] = 0;
        }
    }

    // Colocar el número 1 en la posición inicial
    int num = 1;
    int row = n / 2;
    int column = n - 1;

    while (num <= n * n) {
        if (row == -1 && column == n) {
            row = 0;
            column = n - 2;
        } else {
            if (column == n) {
                column = 0;
            }
            if (row < 0) {
                row = n - 1;
            }
        }

        if (matrix[row][column]) {
            row++;
            column -= 2;
            continue;
        } else {
            matrix[row][column] = num++;
        }

        row--;
        column++;
    }

    // Imprimir la matriz mágica generada
    printf("Magic Matrix of order %d x %d:\n", n, n);
    for (i = 0; i < n; i++) {
        for (j = 0; j < n; j++) {
            printf("%d\t", matrix[i][j]);
        }
        printf("\n");
    }
    printf("\n \n");
}



int main() {
    int option,c;
    char buffer[50];
    do {
        printf("\n");
        printf("\n");
    printf("Select the exercise to be performed:\n");
    printf("1. Whole Number to Roman\n");
    printf("2. Prime Factors\n");
    printf("3. Own name\n");
    printf("4. Egomaniac Numbers\n");
    printf("5. Friends Numbers\n");
    printf("6. Date\n");
    printf("7. Product Point\n");
    printf("8. Multiplication of Matrices\n");
    printf("9. Magic Matrix\n");
    printf("10. Exit\n");
        printf("Enter the option number: ");
        fgets(buffer, sizeof buffer, stdin);
        if (sscanf(buffer, "%d", &option) != 1) {
            printf("Invalid input. Please enter a number.\n");
            continue;
        }
    //Variables

    //Punto 1 y 2:
    int number;

    //Punto 3:
    char words[100];

    //Punto 4
    int numberEgolater = 0;

    //Punto 5
    int friendNumberOne = 0, friendNumberTwo = 0;

    //Punto 6
    char date[30];

    //Punto7:
    int array1[3];
    int array2[3];

    //Punto8:
    int matrix1[3][3], matrix2[3][3], result[3][3];

    //Punto 9:
    int orden;


    switch (option) {

        case 1:
            printf("Enter a number: ");
            scanf("%d", &number);
            numberToRoman(number);
            while ((c = getchar()) != '\n' && c != EOF) { }  // Limpiar el buffer de entrada
            break;

        case 2:
            printf("Enter a number: ");
            scanf("%d", &number);
            primeFactors(number);
            while ((c = getchar()) != '\n' && c != EOF) { }  // Limpiar el buffer de entrada
            break;

        case 3:
            printf("Enter a string: ");
            scanf(" %99[^\n]", words);
            printf("Input String: %s\n", words);

            properName(words);
            printf("Output String: %s\n", words);
            while ((c = getchar()) != '\n' && c != EOF) { }  // Limpiar el buffer de entrada
            break;


        case 4:
            printf("\nEnter a number for verify if is egolater\n");
            scanf("%i", &numberEgolater);

            printf("\n%s", verifyEgolatet(numberEgolater) ? "This number is egomaniacal" : "This number is not egomaniacal");
            while ((c = getchar()) != '\n' && c != EOF) { }  // Limpiar el buffer de entrada
            break;


        case 5:
            printf("\nEnter a number\n");
            scanf("%d", &friendNumberOne);

            printf("\nEnter a number\n");
            scanf("%d", &friendNumberTwo);

            printf("%s", verifyFriendsNumber(friendNumberOne, friendNumberTwo) ? "These numbers are enemies" : "These numbers are not enemies");
            while ((c = getchar()) != '\n' && c != EOF) { }  // Limpiar el buffer de entrada
            break;

        case 6:
            fflush(stdin);
            printf("Enter a date in the format dd/mm/aaaa: ");
            fgets(date, 30, stdin);

            describeDate(date);
            while ((c = getchar()) != '\n' && c != EOF) { }  // Limpiar el buffer de entrada
            break;

        case 7:
            printf("\nEnter the elements of the first array:\n");
            for (int i = 0; i < 3; i++) {
                printf("Enter the element at position [%d]: ",i);
                scanf("%d", &array1[i]);
            }

            printf("Enter the elements of the second array:\n");
            for (int i = 0; i < 3; i++) {
                printf("Enter the element at position [%d]: ",i);
                scanf("%d", &array2[i]);
            }

            int result1 = productPoint(array1, array2, 3);
            printf("\nThe dot product of the arrays is: %d\n", result1);
            while ((c = getchar()) != '\n' && c != EOF) { }  // Limpiar el buffer de entrada
            break;


        case 8:
            printf("Enter the first array:\n");
            inputMatrix(matrix1);

            printf("Enter the second array:\n");
            inputMatrix(matrix2);

            multiplyMatrix(matrix1, matrix2, result);

            printf("Multiplication result:\n");
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    printf("%d ", result[i][j]);  // Corrección en la impresión de los elementos
                }
                printf("\n");
            }
            while ((c = getchar()) != '\n' && c != EOF) { }  // Limpiar el buffer de entrada
            break;

        case 9:
            printf("Enter the order of the matrix: ");
            scanf("%d", &orden);

            if (orden % 2 == 0) {
                printf("The order of the matrix must be odd\n");//tiene que ser impar
                break;
            }

            generateMagicMatrix(orden);
            while ((c = getchar()) != '\n' && c != EOF) { }  // Limpiar el buffer de entrada
            break;

        default:
            printf("\nInvalid option. Please select a valid option.\n");
            break;
    }
    } while (option != 10);
    return 0;
}