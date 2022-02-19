package org.zygimantus.chess.pieces;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;
import org.zygimantus.chess.enums.Color;
import org.zygimantus.chess.enums.Piece;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "piece")
@JsonSubTypes({
        @JsonSubTypes.Type(value = King.class, name = "KING"),
        @JsonSubTypes.Type(value = Queen.class, name = "QUEEN"),
        @JsonSubTypes.Type(value = Rook.class, name = "ROOK"),
        @JsonSubTypes.Type(value = Bishop.class, name = "BISHOP"),
        @JsonSubTypes.Type(value = Knight.class, name = "KNIGHT"),
        @JsonSubTypes.Type(value = Pawn.class, name = "PAWN"),
})
@Data
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
    public String toString() {
        return color + "-" + piece;
    }
}
