
public class Chessboard {

    class Field {
        private char row;
        private byte column;
        private Chesspiece piece = null;
        private boolean marked = false;

        private Field(char row, byte column) {
            this.row = row;
            this.column = column;
        }

        private void put(Chesspiece piece) {
            this.piece = piece;
        }

        private Chesspiece take() {
            Chesspiece temp = this.piece;
            this.piece = null;
            return temp;
        }

        private void mark() {
            this.marked = true;
        }

        private void unmark() {
            this.marked = false;
        }

        public String toString() {
            String s = (marked) ? "xx" : "--";
            return (piece == null) ? s : piece.toString();
        }
    }

    // Define main characteristics of chessboard

    public static final int NUMBER_OF_ROWS = 8;
    public static final int NUMBER_OF_COLUMNS = 8;
    public static final int FIRST_ROW = 'a';
    public static final int FIRST_COLUMN = 1;

    // Define variable for a two dimensional array of objects of the type field

    private Field[][] fields;

    public Chessboard() {

        fields = new Field[NUMBER_OF_ROWS][NUMBER_OF_COLUMNS];

        char row;
        byte column;

        for (int r = 0; r < NUMBER_OF_ROWS; r++) {

            row = (char) (FIRST_ROW + r);
            column = FIRST_COLUMN;

            for (int c = 0; c < NUMBER_OF_COLUMNS; c++) {
                fields[r][c] = new Field(row, column);
                column++;
            }
        }
    }

    public String toString() {

        StringBuilder ch = new StringBuilder();

        ch.append("   1   2   3   4   5   6   7   8\n\n");

        for (int i = 0; i < NUMBER_OF_ROWS; i++) {

            char rowName = (char) (FIRST_ROW + i);

            ch.append(rowName).append("  ");

            for (int j = 0; j < NUMBER_OF_COLUMNS; j++) {

                ch.append(fields[i][j].toString()).append("  ");
            }

            ch.append("\n\n");

        }

        return ch.toString();
    }

    public boolean isValidField(char row, byte column) {

        return row >= 'a' && row <= 'h' && column > 0 && column <= 8;
    }

    public abstract class Chesspiece {

        private char color;
        // w - white, b - black

        private char name;

        // K - King, Q - Queen, R - Rook, B - Bishop, N - Knight, P - Pawn

        // The piece is created outside the chessboard
        protected char row = 0;
        protected byte column = -1;

        protected Chesspiece(char color, char name) {

            this.color = color;
            this.name = name;
        }

        public String toString() {
            return "" + color + name;
        }

        public boolean isOnBoard() {
            return Chessboard.this.isValidField(row, column);
        }

        public void moveTo(char row, byte column) throws NotValidFieldException {

            if (!Chessboard.this.isValidField(row, column))

                throw new NotValidFieldException("bad  field: " + row + column);

            this.row = row;
            this.column = column;
            int r = row - FIRST_ROW;
            int c = column - FIRST_COLUMN;

            Chessboard.this.fields[r][c].put(this);
        }

        public class NotValidFieldException extends Exception {
            public NotValidFieldException(String message) {
                super(message);
            }
        }

        public void moveOut() {
            Chessboard.this.fields[row - FIRST_ROW][column - FIRST_COLUMN].take();
        }

        // These methods are implemented in the subclasses of Chesspiece

        public abstract void markReachableFields();

        public abstract void unmarkReachableFields();
    }

    public class Pawn extends Chesspiece {

        public Pawn(char color, char name) {

            super(color, name);
        }

        public void markReachableFields() {

            byte col = (byte) (column + 1);

            if (Chessboard.this.isValidField(row, col)) {

                int r = row - FIRST_ROW;
                int c = col - FIRST_COLUMN;

                Chessboard.this.fields[r][c].mark();
            }
        }

        public void unmarkReachableFields() {
            byte col = (byte) (column + 1);
            if (Chessboard.this.isValidField(row, col)) {
                int r = row - FIRST_ROW;
                int c = col - FIRST_COLUMN;
                Chessboard.this.fields[r][c].unmark();
            }
        }
    }

    public class Rook extends Chesspiece {

        public Rook(char color, char name) {

            super(color, name);
        }

        public void markReachableFields() {

            for (char row1 = 'a'; row1 <= 'h'; row1++) {

                if (Chessboard.this.isValidField(row1, column) && (row1 != row)) {

                    int r = row1 - FIRST_ROW;
                    int c = column - FIRST_COLUMN;

                    Chessboard.this.fields[r][c].mark();

                }
            }

            for (byte column1 = 1; column1 <= 8; column1++) {

                if (Chessboard.this.isValidField(row, column1) && (column1 != column)) {

                    int r = row - FIRST_ROW;
                    int c = column1 - FIRST_COLUMN;

                    Chessboard.this.fields[r][c].mark();

                }
            }

        }

        public void unmarkReachableFields() {

            for (char row1 = 'a'; row1 <= 'h'; row1++) {

                if (Chessboard.this.isValidField(row1, column) && (row1 != row)) {

                    int r = row1 - FIRST_ROW;
                    int c = column - FIRST_COLUMN;

                    Chessboard.this.fields[r][c].unmark();

                }
            }

            for (byte column1 = 1; column1 <= 8; column1++) {

                if (Chessboard.this.isValidField(row, column1) && (column1 != column)) {

                    int r = row - FIRST_ROW;
                    int c = column1 - FIRST_COLUMN;

                    Chessboard.this.fields[r][c].unmark();

                }
            }

        }
    }

    public class Knight extends Chesspiece {

        public Knight(char color, char name) {

            super(color, name);
        }

        public void markReachableFields() {

            byte r = (byte) (row - FIRST_ROW);
            byte c = (byte) (column - FIRST_COLUMN);

            for (int i = -2; i <= 2; i += 4) {

                if (Chessboard.this.isValidField((char) (row + i), (byte) (column + 1))) {

                    Chessboard.this.fields[r + i][c + 1].mark();
                }

                if (Chessboard.this.isValidField((char) (row - i), (byte) (column - 1))) {
                    Chessboard.this.fields[r - i][c - 1].mark();
                }

            }

            for (int i = -1; i <= 1; i += 2) {

                if (Chessboard.this.isValidField((char) (row + i), (byte) (c + 2))) {
                    fields[r + i][c + 2].mark();
                }

                if (Chessboard.this.isValidField((char) (row - i), (byte) (c - 2))) {
                    fields[r - i][c - 2].mark();
                }

            }

        }

        public void unmarkReachableFields() {

            byte r = (byte) (row - FIRST_ROW);
            byte c = (byte) (column - FIRST_COLUMN);

            for (int i = -2; i <= 2; i += 4) {

                if (Chessboard.this.isValidField((char) (row + i), (byte) (column + 1)))

                {
                    fields[r + i][c + 1].unmark();
                }

                if (Chessboard.this.isValidField((char) (row - i), (byte) (column - 1))) {
                    fields[r - i][c - 1].unmark();
                }

            }

            for (int i = -1; i <= 1; i += 2) {

                if (Chessboard.this.isValidField((char) (row + i), (byte) (c + 2))) {
                    fields[r + i][c + 2].unmark();
                }
                if (Chessboard.this.isValidField((char) (row - i), (byte) (c - 2))) {
                    fields[r - i][c - 2].unmark();
                }

            }
        }
    }

    public class King extends Chesspiece {

        public King(char color, char name) {
            super(color, name);
        }

        public void markReachableFields() {

            byte r = (byte) (row - FIRST_ROW);
            byte c = (byte) (column - FIRST_COLUMN);

            for (int i = -1; i <= 1; i++) {

                for (int j = -1; j <= 1; j++)

                {

                    if (Chessboard.this.isValidField((char) (row + i), (byte) (column + j)))

                    {
                        fields[r + i][c + j].mark();
                    }

                    if (Chessboard.this.isValidField((char) (row - i), (byte) (column - j))) {
                        fields[r - i][c - j].mark();
                    }

                }
            }
        }

        public void unmarkReachableFields() {

            byte r = (byte) (row - FIRST_ROW);
            byte c = (byte) (column - FIRST_COLUMN);

            for (int i = -1; i <= 1; i++) {

                for (int j = -1; j <= 1; j++)

                {

                    if (Chessboard.this.isValidField((char) (row + i), (byte) (column + j)))

                    {
                        fields[r + i][c + j].unmark();
                    }

                    if (Chessboard.this.isValidField((char) (row - i), (byte) (column - j))) {
                        fields[r - i][c - j].unmark();
                    }

                }

            }
        }
    }

    public class Bishop extends Chesspiece {
        public Bishop(char color, char name) {
            super(color, name);
        }

        public void markReachableFields() {
            byte r = (byte) (row - FIRST_ROW);
            byte c = (byte) (column - FIRST_COLUMN);

            for (int i = -3; i <= 3; i++) {

                for (int j = -3; j <= 4; j++) {
                    {

                        if (i != j)
                            i = j;
                    }
                    {
                        if (Chessboard.this.isValidField((char) (row + i), (byte) (column + j)))
                        // if(Chessboard.this.isValidField(i, j) && (i != row) && (j != column))

                        {
                            fields[r + i][c + j].mark();
                        }

                        if (Chessboard.this.isValidField((char) (row - i), (byte) (column - j))) {
                            fields[r - i][c - j].mark();
                        }

                    }
                }
                for (i = -3; i <= 3; i++) {

                    for (int j = -3; j <= 3; j++) {
                        {
                            if (i != j)
                                i = j;
                        }
                        {
                            if (Chessboard.this.isValidField((char) (row + i), (byte) (column - j)))

                            {
                                fields[r + i][c - j].mark();
                            }

                            if (Chessboard.this.isValidField((char) (row - i), (byte) (column + j))) {
                                fields[r - i][c + j].mark();
                            }

                        }
                    }
                }
            }
        }

        public void unmarkReachableFields() {

            byte r = (byte) (row - FIRST_ROW);
            byte c = (byte) (column - FIRST_COLUMN);

            for (int i = -3; i <= 3; i++) {

                for (int j = -3; j <= 4; j++) {
                    {

                        if (i != j)
                            i = j;
                    }
                    {
                        if (Chessboard.this.isValidField((char) (row + i), (byte) (column + j)))

                        {
                            fields[r + i][c + j].unmark();
                        }

                        if (Chessboard.this.isValidField((char) (row - i), (byte) (column - j))) {
                            fields[r - i][c - j].unmark();
                        }

                    }
                }
                for (i = -3; i <= 3; i++) {

                    for (int j = -3; j <= 3; j++) {
                        {

                            if (i != j)
                                i = j;
                        }
                        {
                            if (Chessboard.this.isValidField((char) (row + i), (byte) (column - j)))

                            {
                                fields[r + i][c - j].unmark();
                            }

                            if (Chessboard.this.isValidField((char) (row - i), (byte) (column + j))) {
                                fields[r - i][c + j].unmark();
                            }

                        }
                    }
                }
            }
        }
    }

    public class Queen extends Chesspiece {

        public Queen(char color, char name) {
            super(color, name);
        }

        public void markReachableFields() {

            for (char row1 = 'a'; row1 <= 'h'; row1++) {

                if (Chessboard.this.isValidField(row1, column) && (row1 != row)) {

                    int r = row1 - FIRST_ROW;
                    int c = column - FIRST_COLUMN;

                    Chessboard.this.fields[r][c].mark();

                }
            }

            for (byte column1 = 1; column1 <= 8; column1++) {

                if (Chessboard.this.isValidField(row, column1) && (column1 != column)) {

                    int r = row - FIRST_ROW;
                    int c = column1 - FIRST_COLUMN;

                    Chessboard.this.fields[r][c].mark();

                }
            }

            byte r = (byte) (row - FIRST_ROW);
            byte c = (byte) (column - FIRST_COLUMN);

            for (int i = -3; i <= 3; i++) {

                for (int j = -3; j <= 4; j++) {
                    {

                        if (i != j)
                            i = j;
                    }
                    {
                        if (Chessboard.this.isValidField((char) (row + i), (byte) (column + j)))

                        {
                            fields[r + i][c + j].mark();
                        }

                        if (Chessboard.this.isValidField((char) (row - i), (byte) (column - j))) {
                            fields[r - i][c - j].mark();
                        }

                    }
                }
                for (i = -3; i <= 3; i++) {

                    for (int j = -3; j <= 3; j++) {
                        {
                            if (i != j)
                                i = j;
                        }
                        {
                            if (Chessboard.this.isValidField((char) (row + i), (byte) (column - j)))

                            {
                                fields[r + i][c - j].mark();
                            }

                            if (Chessboard.this.isValidField((char) (row - i), (byte) (column + j))) {
                                fields[r - i][c + j].mark();
                            }

                        }
                    }
                }
            }
        }

        public void unmarkReachableFields() {

            for (char row1 = 'a'; row1 <= 'h'; row1++) {

                if (Chessboard.this.isValidField(row1, column) && (row1 != row)) {

                    int r = row1 - FIRST_ROW;
                    int c = column - FIRST_COLUMN;

                    Chessboard.this.fields[r][c].unmark();

                }
            }

            for (byte column1 = 1; column1 <= 8; column1++) {

                if (Chessboard.this.isValidField(row, column1) && (column1 != column)) {

                    int r = row - FIRST_ROW;
                    int c = column1 - FIRST_COLUMN;

                    Chessboard.this.fields[r][c].unmark();

                }
            }

            byte r = (byte) (row - FIRST_ROW);
            byte c = (byte) (column - FIRST_COLUMN);

            for (int i = -3; i <= 3; i++) {

                for (int j = -3; j <= 4; j++) {
                    {

                        if (i != j)
                            i = j;
                    }
                    {
                        if (Chessboard.this.isValidField((char) (row + i), (byte) (column + j)))

                        {
                            fields[r + i][c + j].unmark();
                        }

                        if (Chessboard.this.isValidField((char) (row - i), (byte) (column - j))) {
                            fields[r - i][c - j].unmark();
                        }

                    }
                }
                for (i = -3; i <= 3; i++) {

                    for (int j = -3; j <= 3; j++) {
                        {
                            if (i != j)
                                i = j;
                        }
                        {
                            if (Chessboard.this.isValidField((char) (row + i), (byte) (column - j)))

                            {
                                fields[r + i][c - j].unmark();
                            }

                            if (Chessboard.this.isValidField((char) (row - i), (byte) (column + j))) {
                                fields[r - i][c + j].unmark();
                            }

                        }
                    }
                }
            }
        }

    }

}
