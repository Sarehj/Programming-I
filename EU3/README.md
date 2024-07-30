# Inheritance, class hierarchies and polymorphism

## The representation of chess pieces

### A) The chess-board and the pieces
A chess-board consists of 8 by 8 squares.
A particular square on the chess-board is identified by its row and column. The rows can be designated by the letters a, b, c, d, e, f, g, and h, and the columns with the digits 1, 2, 3, 4, 5, 6, 7, and 8. In this notation the square a4 is found in row a and column 4. A square, which from now on will be called a field, is a container for a chess piece. A chess piece can be placed on the field, or be removed from it. A field is also a carrier of information: it can be marked or unmarked.

A number of chess pieces belong to the chess-board. A piece can enter the board on a certain field, or be removed from the board. When it is on the board, the piece can mark all the fields it can reach in a single move. The piece can also remove the markings. A piece can find out if its on the board or not. The pieces are distinguished by their colour (white or black) and their name. The names of the pieces are Pawn, Rook, Knight, Bishop, Queen, and King.

### B) The presentation of the pieces
The program ReachableFieldsOnChessboard creates a chess-board and a number of pieces. Then the pieces introduce themselves. A piece enters the chess-board (on a random field) and marks all the fields it can reach in a single move. The piece waits a moment and then removes the markings. Finally the piece steps off the chess-board to make room for the next piece.