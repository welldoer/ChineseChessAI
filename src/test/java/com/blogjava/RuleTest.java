package com.blogjava;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class RuleTest {
	private Rule rule;

	@Before
	public void setUp() throws Exception {
		rule = new Rule();
	}

	@Test
	public void testRuleRookBasicSteps() {
		Piece piece = new Piece( PieceType.ROOK_BLACK, 40 );
		assertThat( rule.hasDirectPath( piece,  4 ) ).isTrue();
		assertThat( rule.hasDirectPath( piece, 85 ) ).isTrue();
		assertThat( rule.hasDirectPath( piece, 36 ) ).isTrue();
		assertThat( rule.hasDirectPath( piece, 44 ) ).isTrue();
	}
	
	@Test
	public void testRuleRookIncorrectSteps() {
		Piece piece = new Piece( PieceType.ROOK_BLACK, 40 );
		assertThat( rule.hasDirectPath( piece,  3 ) ).isFalse();
	}

	@Test
	public void testRuleKnightBasicSteps() {
		Piece piece = new Piece( PieceType.KNIGHT_BLACK, 22 );
		assertThat( rule.hasDirectPath( piece,  3 ) ).isTrue();
		assertThat( rule.hasDirectPath( piece,  5 ) ).isTrue();
		assertThat( rule.hasDirectPath( piece, 11 ) ).isTrue();
		assertThat( rule.hasDirectPath( piece, 15 ) ).isTrue();
		assertThat( rule.hasDirectPath( piece, 29 ) ).isTrue();
		assertThat( rule.hasDirectPath( piece, 33 ) ).isTrue();
		assertThat( rule.hasDirectPath( piece, 39 ) ).isTrue();
		assertThat( rule.hasDirectPath( piece, 41 ) ).isTrue();
	}
	
	@Test
	public void testRuleKnightIncorrectSteps() {
		Piece piece = new Piece( PieceType.KNIGHT_BLACK, 22 );
		assertThat( rule.hasDirectPath( piece,  2 ) ).isFalse();
	}

	@Test
	public void testRuleBishopBasicSteps() {
		Piece piece = new Piece( PieceType.BISHOP_BLACK, 22 );
		assertThat( rule.hasDirectPath( piece,  2 ) ).isTrue();
		assertThat( rule.hasDirectPath( piece,  6 ) ).isTrue();
		assertThat( rule.hasDirectPath( piece, 38 ) ).isTrue();
		assertThat( rule.hasDirectPath( piece, 42 ) ).isTrue();
		
		piece = new Piece( PieceType.BISHOP_RED, 63 );
		assertThat( rule.hasDirectPath( piece, 47 ) ).isTrue();
		assertThat( rule.hasDirectPath( piece, 83 ) ).isTrue();
	}
	
	@Test
	public void testRuleBishopIncorrectSteps() {
		Piece piece = new Piece( PieceType.BISHOP_BLACK, 22 );
		assertThat( rule.hasDirectPath( piece, 18 ) ).isFalse();

		piece = new Piece( PieceType.BISHOP_RED, 47 );
		assertThat( rule.hasDirectPath( piece, 31 ) ).isFalse();
	}

	@Test
	public void testRuleAdvisorBasicSteps() {
		Piece piece = new Piece( PieceType.ADVISOR_BLACK, 13 );
		assertThat( rule.hasDirectPath( piece,  3 ) ).isTrue();
		assertThat( rule.hasDirectPath( piece,  5 ) ).isTrue();
		assertThat( rule.hasDirectPath( piece, 21 ) ).isTrue();
		assertThat( rule.hasDirectPath( piece, 23 ) ).isTrue();
		
		piece = new Piece( PieceType.ADVISOR_RED, 76 );
		assertThat( rule.hasDirectPath( piece, 66 ) ).isTrue();
		assertThat( rule.hasDirectPath( piece, 68 ) ).isTrue();
		assertThat( rule.hasDirectPath( piece, 84 ) ).isTrue();
		assertThat( rule.hasDirectPath( piece, 86 ) ).isTrue();
	}
	
	@Test
	public void testRuleAdvisorIncorrectSteps() {
		Piece piece = new Piece( PieceType.ADVISOR_BLACK, 13 );
		assertThat( rule.hasDirectPath( piece,  4 ) ).isFalse();
		assertThat( rule.hasDirectPath( piece, 12 ) ).isFalse();
		assertThat( rule.hasDirectPath( piece, 14 ) ).isFalse();
		assertThat( rule.hasDirectPath( piece, 22 ) ).isFalse();

		piece = new Piece( PieceType.ADVISOR_BLACK, 3 );
		assertThat( rule.hasDirectPath( piece,   4 ) ).isFalse();
		assertThat( rule.hasDirectPath( piece,  11 ) ).isFalse();
		assertThat( rule.hasDirectPath( piece,  12 ) ).isFalse();
		
		piece = new Piece( PieceType.ADVISOR_RED, 68 );
		assertThat( rule.hasDirectPath( piece, 78 ) ).isFalse();
	}

	@Test
	public void testRuleKingBasicSteps() {
		Piece piece = new Piece( PieceType.KING_BLACK, 13 );
		assertThat( rule.hasDirectPath( piece,  4 ) ).isTrue();
		assertThat( rule.hasDirectPath( piece, 12 ) ).isTrue();
		assertThat( rule.hasDirectPath( piece, 14 ) ).isTrue();
		assertThat( rule.hasDirectPath( piece, 22 ) ).isTrue();
		
		piece = new Piece( PieceType.KING_RED, 76 );
		assertThat( rule.hasDirectPath( piece, 67 ) ).isTrue();
		assertThat( rule.hasDirectPath( piece, 75 ) ).isTrue();
		assertThat( rule.hasDirectPath( piece, 77 ) ).isTrue();
		assertThat( rule.hasDirectPath( piece, 85 ) ).isTrue();
	}
	
	@Test
	public void testRuleKingIncorrectSteps() {
		Piece piece = new Piece( PieceType.KING_BLACK, 13 );
		assertThat( rule.hasDirectPath( piece,  3 ) ).isFalse();
		assertThat( rule.hasDirectPath( piece,  5 ) ).isFalse();

		piece = new Piece( PieceType.KING_BLACK, 3 );
		assertThat( rule.hasDirectPath( piece,   2 ) ).isFalse();
		
		piece = new Piece( PieceType.KING_RED, 67 );
		assertThat( rule.hasDirectPath( piece, 58 ) ).isFalse();
	}

	@Test
	public void testRulePawnBasicSteps() {
		Piece piece = new Piece( PieceType.PAWN_BLACK, 27 );
		assertThat( rule.hasDirectPath( piece, 36 ) ).isTrue();
		
		piece = new Piece( PieceType.PAWN_BLACK, 29 );
		assertThat( rule.hasDirectPath( piece, 38 ) ).isTrue();

		piece = new Piece( PieceType.PAWN_BLACK, 46 );
		assertThat( rule.hasDirectPath( piece, 45 ) ).isTrue();
		assertThat( rule.hasDirectPath( piece, 47 ) ).isTrue();
		assertThat( rule.hasDirectPath( piece, 55 ) ).isTrue();

		piece = new Piece( PieceType.PAWN_RED, 58 );
		assertThat( rule.hasDirectPath( piece, 49 ) ).isTrue();
	}
	
	@Test
	public void testRulePawnIncorrectSteps() {
		Piece piece = new Piece( PieceType.PAWN_BLACK, 29 );
		assertThat( rule.hasDirectPath( piece, 20 ) ).isFalse();
		assertThat( rule.hasDirectPath( piece, 28 ) ).isFalse();
		assertThat( rule.hasDirectPath( piece, 30 ) ).isFalse();

		piece = new Piece( PieceType.PAWN_RED, 49 );
		assertThat( rule.hasDirectPath( piece, 48 ) ).isFalse();
	}
	
	@Test
	public void testRulehasPassPath() {
		Tiles tiles = new Tiles( null );
		FenRecord fenRecord = new FenRecord( "3rPPb2/n3a4/1CN1C1cnr/1P2p4/2b1r4/2P6/9/5p3/4AK3/5R3 r - - 0 0" );
		tiles.loadFromFen( fenRecord );
		assertThat( rule.isRightPath( tiles, 40,  4 ) ).isFalse();			/* 车隔子不能吃子	*/
		assertThat( rule.isRightPath( tiles, 40, 31 ) ).isFalse();			/* 车不能吃己方子	*/
		assertThat( rule.isRightPath( tiles, 40, 44 ) ).isTrue();			/* 车可以移动		*/
		
		assertThat( rule.isRightPath( tiles, 24, 20 ) ).isTrue();			/* 炮隔子可打子	*/
		assertThat( rule.isRightPath( tiles, 24, 22 ) ).isFalse();			/* 炮不能直接吃子	*/
		assertThat( rule.isRightPath( tiles, 24, 26 ) ).isFalse();			/* 炮不可打己方子	*/
		assertThat( rule.isRightPath( tiles, 24, 86 ) ).isFalse();			/* 炮可以移动		*/
		
		assertThat( rule.isRightPath( tiles, 20,  1 ) ).isTrue();			/* 马可以移动		*/
		assertThat( rule.isRightPath( tiles, 20,  3 ) ).isTrue();			/* 马可以吃子		*/
		assertThat( rule.isRightPath( tiles, 20, 27 ) ).isFalse();			/* 马踏被阻挡		*/
		
		assertThat( rule.isRightPath( tiles,  6, 26 ) ).isFalse();			/* 相不可以移动	*/
		assertThat( rule.isRightPath( tiles, 38, 18 ) ).isFalse();			/* 相飞被阻挡		*/
		assertThat( rule.isRightPath( tiles, 38, 22 ) ).isTrue();			/* 相可以吃子		*/
		
		assertThat( rule.isRightPath( tiles, 13,  3 ) ).isFalse();			/* 士不可以移动	*/
		assertThat( rule.isRightPath( tiles, 13,  5 ) ).isTrue();			/* 士可以吃子		*/
		assertThat( rule.isRightPath( tiles, 76, 68 ) ).isTrue();			/* 士可以吃子		*/
		assertThat( rule.isRightPath( tiles, 76, 86 ) ).isFalse();			/* 士不可以移动	*/

		assertThat( rule.isRightPath( tiles, 77, 68 ) ).isTrue();			/* 帅可以吃子		*/
		assertThat( rule.isRightPath( tiles, 77, 76 ) ).isFalse();			/* 帅不可以移动	*/
		assertThat( rule.isRightPath( tiles, 77, 86 ) ).isFalse();			/* 帅不可以移动	*/

		assertThat( rule.isRightPath( tiles, 47, 38 ) ).isTrue();			/* 兵可以过河吃子	*/
		assertThat( rule.isRightPath( tiles, 47, 46 ) ).isFalse();			/* 兵未过河不乱动	*/
	}
	
	@Test
	public void testVerify() {
		Tiles tiles = new Tiles( null );
		FenRecord fenSimpleRecord = new FenRecord( "1r7/2c6/1n7/1N7/9/9/9/2C6/9/9 b - - 20 50" );
		tiles.loadFromFen( fenSimpleRecord );
		assertThat( rule.isRightPath( tiles, 65, 64 ) ).isTrue();
		tiles.movePiece( 65, 64 );
		assertThat( tiles.getPiece( 64 ).getType() ).isEqualTo( PieceType.CANNON_RED );
		tiles.movePiece( 64,  1 );
		assertThat( tiles.getPiece(  1 ).getType() ).isEqualTo( PieceType.ROOK_BLACK );
		tiles.movePiece( 64, 19 );
		assertThat( tiles.getPiece( 19 ).getType() ).isEqualTo( PieceType.CANNON_RED );
	}
	
	@Test
	public void testGetBasicSteps() {
		Piece piece = new Piece( PieceType.ROOK_BLACK, 20 );
		List<Integer> ret = new ArrayList<>();
		ret.add( 18 ); ret.add( 19 ); ret.add( 21 ); ret.add( 22 ); ret.add( 23 ); ret.add( 24 );
		ret.add( 25 ); ret.add( 26 );
		ret.add(  2 ); ret.add( 11 ); ret.add( 29 ); ret.add( 38 ); ret.add( 47 ); ret.add( 56 );
		ret.add( 65 ); ret.add( 74 ); ret.add( 83 );
		assertThat( rule.getBasicSteps( piece ) ).isEqualTo( ret );

		piece = new Piece( PieceType.CANNON_BLACK, 20 );
		ret.clear();
		ret.add( 18 ); ret.add( 19 ); ret.add( 21 ); ret.add( 22 ); ret.add( 23 ); ret.add( 24 );
		ret.add( 25 ); ret.add( 26 );
		ret.add(  2 ); ret.add( 11 ); ret.add( 29 ); ret.add( 38 ); ret.add( 47 ); ret.add( 56 );
		ret.add( 65 ); ret.add( 74 ); ret.add( 83 );
		assertThat( rule.getBasicSteps( piece ) ).isEqualTo( ret );

		piece = new Piece( PieceType.KNIGHT_BLACK, 20 );
		ret.clear();
		ret.add(  1 ); ret.add(  3 );
		ret.add(  9 ); ret.add( 13 );
		ret.add( 27 ); ret.add( 31 );
		ret.add( 37 ); ret.add( 39 );
		assertThat( rule.getBasicSteps( piece ) ).isEqualTo( ret );

		piece = new Piece( PieceType.BISHOP_BLACK, 22 );
		ret.clear();
		ret.add(  2 ); ret.add(  6 );
		ret.add( 38 ); ret.add( 42 );
		assertThat( rule.getBasicSteps( piece ) ).isEqualTo( ret );

		piece = new Piece( PieceType.ADVISOR_BLACK, 13 );
		ret.clear();
		ret.add(  3 ); ret.add(  5 );
		ret.add( 21 ); ret.add( 23 );
		assertThat( rule.getBasicSteps( piece ) ).isEqualTo( ret );

		piece = new Piece( PieceType.KING_BLACK, 13 );
		ret.clear();
		ret.add(  4 ); ret.add( 12 );
		ret.add( 14 ); ret.add( 22 );
		assertThat( rule.getBasicSteps( piece ) ).isEqualTo( ret );

		piece = new Piece( PieceType.PAWN_BLACK, 31 );
		ret.clear();
		ret.add( 22 ); ret.add( 30 );
		ret.add( 32 ); ret.add( 40 );
		assertThat( rule.getBasicSteps( piece ) ).isEqualTo( ret );
	}
}
