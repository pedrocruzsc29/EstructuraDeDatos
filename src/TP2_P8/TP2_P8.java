package TP2_P8;


public class TP2_P8 {

    // CARGAR NOTAS EN LA MATRIZ BIDIMENSIONAL
    public static void LoadNotes(double[][] notes){

        for (int i = 0; i < notes.length; i++){
            System.out.println("Estudiante N° " + (i+1) + " : ");
            for (int j = 0; j < notes[i].length; j++){
                notes[i][j] = Helper.GetValidDouble("Nota N° " + (i + 1) +  " | Materia " + (j + 1) + " : ");
            }
        }
    }

    // MOSTRAR NOTAS, ESTUDIANTES Y MATERIAS

    public static void ShowNotes(double [][] notes){
        for (int i = 0; i < notes.length; i++){
            System.out.println("Estudiante N° " + (i+1) + " : ");
            for (int j = 0; j < notes[i].length; j++){
                System.out.println("Nota: " + notes[i][j]);
            }
        }
    }

    // CALCULAR PROMEDIOS DE ESTUDIANTES

    public static void Average(double [][] notes){
        for (int i = 0; i < notes.length; i++){
            double amount = 0;
            System.out.println("Promedio de Estudiante N° " + (i+1) + ": ");
            for (int j = 0; j < notes[i].length; j++){
                amount = amount + notes[i][j];
            }
            System.out.println(String.format("%.2f",amount/notes[i].length));
        }
    }

    // CALCULAR PROMEDIOS DE ASIGNATURAS

    public static void AverageSubjects(double [][] notes){
        int estudiantes = notes.length;
        int materias = notes[0].length;
        for (int j = 0; j < materias; j++){
            double amount = 0;
            for (int i = 0; i < estudiantes; i++){
                amount = amount + notes[i][j];
            }
            System.out.println(String.format("Promedio de Materia N° " + (j+1) + ": %.2f",amount/estudiantes));
        }

    }

    // ENCONTRAR CALIFICACIÓN MÁS ALTA

    public static void HighestMark(double [][] notes){
        double max = 0;
        int fila = 0;
        int columna = 0;
        boolean band = true;
        for (int i = 0; i < notes.length; i++){
            for (int j = 0; j < notes[i].length; j++){
                if (band){
                    max = notes[i][j];
                    fila = i + 1;
                    columna = j + 1;
                    band = false;
                }else{
                    if (max < notes[i][j]){
                        max = notes[i][j];
                        fila = i + 1;
                        columna = j + 1;
                    }
                }
            }
        }
        System.out.println("### Nota más alta: " + max + " Fila: " + fila + " Columna: " + columna);
    }

    // ENCONTRAR CALIFICACIÓN MÁS BAJA

    public static void LowestMark(double [][] notes){
        double min = 0;
        int fila = 0;
        int columna = 0;
        boolean band = true;
        for (int i = 0; i < notes.length; i++){
            for (int j = 0; j < notes[i].length; j++){
                if (band){
                    min = notes[i][j];
                    fila = i + 1;
                    columna = j + 1;
                    band = false;
                }else{
                    if (min > notes[i][j]){
                        min = notes[i][j];
                        fila = i + 1;
                        columna = j + 1;
                    }
                }
            }
        }
        System.out.println("### Nota más baja: " + min + " Fila: " + fila + " Columna: " + columna);
    }

    // ESTUDIANTES QUE APROBARON TODAS LAS MATERIAS

    public static int PassedStudents(double[][] notes){

        int estudiantes = 0;
        for (int i = 0; i < notes.length; i++){
            boolean aproboTodo = true; // Nos aseguramos de que se inicialice nuevamente
            for (int j = 0; j < notes[i].length; j++){
                if (notes[i][j] < 6.0){
                    aproboTodo = false;
                    break;
                }
            }
            if (aproboTodo){
                estudiantes++;
            }
        }
        return estudiantes;
    }

    // ESTUDIANTES QUE APROBARON UNA ASIGNATURA

    public static int SubjectStudentsPassed(int columna, double [][] notes){
        int estudiantes = 0;
        for (int i = 0; i < notes.length; i++){
            if (notes[i][columna] >= 6.0){
                estudiantes++;
            }
        }
        return estudiantes;
    }

    // COMPARAR DOS NOTAS

    public static double TwoMarksComparison(double max, double mark) {
        boolean band = false;
        if (band) {
            max = mark; // 0 = 8 -> 8
            band = true;
        } else {
            if (mark > max)
                max = mark;
        }
        return max;
    }

    // OBTENER LAS NOTAS MAYORES

    public static double[] MaxMarks (double[][] notes){
        double max = 0;
        double [] maxMarks = new double[notes.length];
        for (int i = 0; i < notes.length; i++){
            double maxMark = 0;
            for (int j = 0; j < notes[i].length; j++){
                maxMark = TwoMarksComparison(max,notes[i][j]);
            }
            maxMarks[i] = maxMark;
        }
        return maxMarks;
    }

    // MOSTRAR NOTA MAXIMA

    public static void ShowHighestMarks(double[] marks){
        for (int i = 0; i < marks.length; i++){
            System.out.println("Estudiante N° " + (i+1) + " : " + marks[i]);
        }
    }

    // MAIN CONTROLLER
    public static void main(String[]args ){
        int op = 0;
        System.out.println("### FACULTAD - UNJU ###");
        int estudiantes = Helper.GetValidNumber("Estudiantes: ");
        int materias = Helper.GetValidNumber("Materias: ");
        double [][] notes = new double [estudiantes][materias];
        LoadNotes(notes);
        do{
            System.out.println("### MENU ###");
            System.out.println("1) Ver notas");
            System.out.println("2) Promedios de estudiantes");
            System.out.println("3) Promedios por asignatura");
            System.out.println("4) Calificación mas alta y baja");
            System.out.println("5) Estudiantes aprobados");
            System.out.println("6) Estudiantes aprobados por asignatura");
            System.out.println("7) Notas maximas de alumnos");
            System.out.println("8) Salir");
            op = Helper.GetValidNumber("Elija una opción: ");
            switch(op){
                case 1:
                    ShowNotes(notes);
                    break;
                case 2:
                    System.out.println("### PROMEDIO DE ESTUDIANTES ###");
                    Average(notes);
                    break;
                case 3:
                    System.out.println("### PROMEDIO DE MATERIAS ###");
                    AverageSubjects(notes);
                    break;
                case 4:
                    System.out.println("### NOTA MÁS ALTA Y MÁS BAJA ###");
                    HighestMark(notes);
                    LowestMark(notes);
                    break;
                case 5:
                    System.out.println("### ESTUDIANTES APROBADOS ###");
                    System.out.println("Cantidad ->" + PassedStudents(notes));
                    break;
                case 6:
                    System.out.println("### ESTUDIANTES APROBADOS POR MATERIA ###");
                    int columnas = 0;
                    columnas = Helper.GetValidSubjectIndex(notes);
                    System.out.println("ESTUDIANTES APROBADOS DE MATERIA N° " +
                            columnas + " : " + SubjectStudentsPassed(columnas,notes));
                    break;
                case 7:
                    System.out.println("### NOTAS MAXIMAS ###");
                    double [] marks = MaxMarks(notes);
                    ShowHighestMarks(marks);
                    break;
                case 8:
                    System.out.println("### FIN DEL PROGRAMA ###");
                    break;
                default:
                    System.out.println("Elija una opción valida!");
            }

        }while(op!=8);

    }

}
    // zerocool