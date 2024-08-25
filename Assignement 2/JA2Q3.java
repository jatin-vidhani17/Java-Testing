import java.util.Scanner;

class matrix{
    int column,row;
    int[][] arr;

    void setMatrix(){
        Scanner scan = new Scanner(System.in);
        
        System.out.print("Enter the Row Size : ");
        this.row = scan.nextInt();
        scan.nextLine();

        System.out.print("Enter the Column Size : ");
        this.column = scan.nextInt();
        scan.nextLine();
        
        this.arr = new int[row][column];
        for(int i=0;i<row;i++){
            for (int j = 0; j < column; j++) {
                System.out.print("Enter The Number on mat["+(i+1)+"]["+(j+1)+"] : ");
                this.arr[i][j] = scan.nextInt();
                scan.nextLine();
            }
        }
    }

    void displayMatrix(){
        for(int i=0;i<row;i++){
            for (int j = 0; j < column; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    void addMatrix(matrix mat1,matrix mat2){
        if (mat1.column == mat2.column && mat1.row == mat2.row) {
            this.column = mat1.column;
            this.row = mat2.row;
            this.arr = new int[row][column];
            for (int i = 0; i < mat1.row; i++) {
                for (int j = 0; j < mat2.column; j++) {
                    this.arr[i][j] = mat1.arr[i][j] + mat2.arr[i][j]; 
                }
            }
        }
        else{
            System.err.println("Sorry, we can't add these matrices as their dimensions do not match.");
        }
    }

    void matrixMultiplication(matrix mat1,matrix mat2){
        if (mat1.column == mat2.row) {
            this.row = mat1.row;
            this.column = mat2.column;
            this.arr = new int[row][column];
            for (int i = 0; i < mat1.row; i++) {
                for (int j = 0; j < mat2.column; j++) {
                    this.arr[i][j] = 0; // Initialize the element to 0
                    for (int k = 0; k < mat1.column; k++) {
                        this.arr[i][j] += mat1.arr[i][k] * mat2.arr[k][j];
                    }
                }
            }
        } else {
            System.err.println("Sorry, we can't multiply these matrices as the number of columns of the first matrix does not match the number of rows of the second matrix.");
        }
    }

    void subMatrix(matrix mat1,matrix mat2){
        if (mat1.column == mat2.column && mat1.row == mat2.row) {
            this.column = mat1.column;
            this.row = mat2.row;
            this.arr = new int[row][column];
            for (int i = 0; i < mat1.row; i++) {
                for (int j = 0; j < mat2.column; j++) {
                    this.arr[i][j] = mat1.arr[i][j] - mat2.arr[i][j]; 
                }
            }
        }
        else{
            System.err.println("Sorry, we can't subtract these matrices as their dimensions do not match.");
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        matrix mat1 = new matrix();
        matrix mat2 = new matrix();
        matrix mat3 = new matrix();

        System.out.println("Enter first matrix:");
        mat1.setMatrix();
        mat1.displayMatrix();

        System.out.println("Enter second matrix:");
        mat2.setMatrix();
        mat2.displayMatrix();

        while (true) {
            System.out.print("Choose operation (1: Add, 2: Subtract, 3: Multiply, 4: Exit) : ");
            int choice = scan.nextInt();
            scan.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("The Result Matrix of Addition is:");
                    mat3.addMatrix(mat1, mat2);
                    mat3.displayMatrix();
                    break;
                case 2:
                    System.out.println("The Result Matrix of Subtraction is:");
                    mat3.subMatrix(mat1, mat2);
                    mat3.displayMatrix();
                    break;
                case 3:
                    System.out.println("The Result Matrix of Multiplication is:");
                    mat3.matrixMultiplication(mat1, mat2);
                    mat3.displayMatrix();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return; // Exit the main method and thus the program
                default:
                    System.err.println("Invalid choice. Please enter 1, 2, 3, or 4.");
            }
        }
    }
}

/*
 
Output : 

Enter first matrix:
Enter the Row Size : 3
Enter the Column Size : 3
Enter The Number on mat[1][1] : 1
Enter The Number on mat[1][2] : 2
Enter The Number on mat[1][3] : 3
Enter The Number on mat[2][1] : 4
Enter The Number on mat[2][2] : 5
Enter The Number on mat[2][3] : 6
Enter The Number on mat[3][1] : 7
Enter The Number on mat[3][2] : 8
Enter The Number on mat[3][3] : 9
1 2 3 
4 5 6 
7 8 9
Enter second matrix:
Enter the Row Size : 3
Enter the Column Size : 4
Enter The Number on mat[1][1] : 1
Enter The Number on mat[1][2] : 2
Enter The Number on mat[1][3] : 3
Enter The Number on mat[1][4] : 4
Enter The Number on mat[2][1] : 5
Enter The Number on mat[2][2] : 6
Enter The Number on mat[2][3] : 7
Enter The Number on mat[2][4] : 8
Enter The Number on mat[3][1] : 9
Enter The Number on mat[3][2] : 10
Enter The Number on mat[3][3] : 11
Enter The Number on mat[3][4] : 12
1 2 3 4 
5 6 7 8 
9 10 11 12
Choose operation (1: Add, 2: Subtract, 3: Multiply, 4: Exit) : 1
The Result Matrix of Addition is:
Sorry, we can't add these matrices as their dimensions do not match.
Choose operation (1: Add, 2: Subtract, 3: Multiply, 4: Exit) : 2
The Result Matrix of Subtraction is:
Sorry, we can't subtract these matrices as their dimensions do not match.
Choose operation (1: Add, 2: Subtract, 3: Multiply, 4: Exit) : 3
The Result Matrix of Multiplication is:
38 44 50 56 
83 98 113 128 
128 152 176 200 
Choose operation (1: Add, 2: Subtract, 3: Multiply, 4: Exit) : 4
Exiting...

*/