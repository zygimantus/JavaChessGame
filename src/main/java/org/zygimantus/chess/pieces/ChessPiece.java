package org.zygimantus.chess.pieces;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;
import org.zygimantus.chess.enums.Color;
import org.zygimantus.chess.enums.Piece;

import java.util.Objects;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "piece")
@JsonSubTypes({
        @JsonSubTypes.Type(value = King.class, name = "KING"),
        @JsonSubTypes.Type(value = Queen.class, name = "QUEEN"),
        @JsonSubTypes.Type(value = Rook.class, name = "ROOK"),
        @JsonSubTypes.Type(value = Bishop.class, name = "BISHOP"),
        @JsonSubTypes.Type(value = Knight.class, name = "KNIGHT"),
        @JsonSubTypes.Type(value = Pawn.class, name = "PAWN"),
})
@Getter
@Setter
public abstract class ChessPiece {

    protected final int number;
    protected final Color color;
    protected final Piece piece;

    protected int rank;
    protected int file;

    protected ChessPiece(Color color, Piece piece, int number) {
        this.color = color;
        this.piece = piece;
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChessPiece that = (ChessPiece) o;
        return number == that.number && color == that.color && piece == that.piece;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, color, piece);
    }

    @Override
    public String toString() {
        return color + "-" + piece;
    }
}
