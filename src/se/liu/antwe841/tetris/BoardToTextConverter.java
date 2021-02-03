package se.liu.antwe841.tetris;

public class BoardToTextConverter
{
    private String str;

    public BoardToTextConverter(final Board board) {
	this.str = converter(board);
    }

    public String convertToText() {
	return str;
    }

    public String converter(Board board){
	StringBuilder builder = new StringBuilder();
	for (int row = 0; row < board.getHeight(); row++) {
	    for (int col = 0; col < board.getWidth(); col++) {
	        switch (board.getSquareAt(col, row)) {
		    case EMPTY:
			builder.append("-");
			break;
		    case I:
			builder.append("I");
			break;
		    case O:
			builder.append("O");
			break;
		    case T:
			builder.append("T");
			break;
		    case S:
			builder.append("S");
			break;
		    case Z:
			builder.append("Z");
			break;
		    case J:
			builder.append("J");
			break;
		    case L:
			builder.append("L");
			break;
		}



	    }
	    builder.append("\n");
	}
    	str = builder.toString();
	return str;
    }
}
