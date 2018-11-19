package com.blogjava;

public class Tiles {
	private ChessBoard chessBoard;
	private Piece[] pieces = new Piece[ 90 ];
	private Rule rule = new Rule();

	public Tiles( ChessBoard chessBoard) {
		this.chessBoard = chessBoard;
	}
	
	public int size() {
		return pieces.length;
	}

	public Tiles loadFromFen( FenRecord fenRecord ) {
		while( true ) {
			Piece piece = fenRecord.fetchNextPiece();
			if( piece != null ) {
				int posInTiles = piece.getPosInTiles();
				pieces[ posInTiles ] = piece;
				if( chessBoard != null )
					chessBoard.getPositions()[ posInTiles ].setImgPiece( piece.getImage() );
			} else
				break;
		}

		return this;
	}

	public Piece getPiece( int pos ) {
		return pieces[ pos ];
	}

	public boolean movePiece( int oldPos, int newPos ) {
		boolean canMove = false;
		
		canMove = rule.isRightPath( this, oldPos, newPos );
		if( canMove ) {
			pieces[ newPos ] = pieces[ oldPos ];
			pieces[ newPos ].setPosInBoard( newPos );
			pieces[ oldPos ] = null;
			if( chessBoard != null ) {
				chessBoard.getPositions()[ newPos ].setImgPiece( pieces[ newPos ].getImage() );
				chessBoard.getPositions()[ oldPos ].setImgPiece( null );
			}
		}
		
		return canMove;
	}

}
