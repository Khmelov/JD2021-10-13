package by.it.karpovich.jd01_05;

public interface Patterns {

    char VERTICAL = '║';

    String TOP_BORDER_ARRAY_A =    "╔═══════════╦═══════════╦═══════════╦═══════════╦═══════════╗";
    String MIDDLE_BORDER_ARRAY_A = "╠═══════════╬═══════════╬═══════════╬═══════════╬═══════════╣";
    String BOTTOM_BORDER_ARRAY_A = "╚═══════════╩═══════════╩═══════════╩═══════════╩═══════════╝";

    String TOP_BORDER_ARRAY_B =    "╔═══════════╦═══════════╗";
    String MIDDLE_BORDER_ARRAY_B = "╠═══════════╬═══════════╣";
    String BOTTOM_BORDER_ARRAY_B = "╚═══════════╩═══════════╝";
    String LINE_INDENT = "%c           ";
    String PRINT_ARRAY_I = "Array[%d] = %g\t";
    String PRINT_VERTICAL_ARRAY_A = "%c A[%2d]=%3d ";
    String PRINT_VERTICAL_ARRAY_B = "%c B[%2d]=%3d ";

    int ELEMENT_LENGTH_MAX = 40;
    int ELEMENT_LENGTH_MIN = 20;
    int RANDOM_MAX_VALUE = 450;
    int RANDOM_MIN_VALUE = 103;

    double VALUE_X_MIN = 5.33;
    double VALUE_X_MAX = 9;

}