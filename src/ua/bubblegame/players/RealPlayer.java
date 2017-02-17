package ua.bubblegame.players;

import ua.bubblegame.objects.BallsType;

public class RealPlayer extends Player {

	public RealPlayer(String name, BallsType type) {
		super(name, type);
	}
	
	@Override
	public int[] makeSteepFrom(int[][] field) {
		int row = 0, col = 0;
		// �������� ���������� (������� �� ������) ���������� ����� ���������� notify wait pair
		// ��������� ����� �� ��������
		// ������� ����� ��� ��������� ��������� �������
		
		return new int[]{row, col};
	}
	

	@Override
	public int[] makeSteepTo(int[][] field, int row, int col) {

		int rowRes = 0, colRes = 0;
		// �������� �������� ������� ���� ������. ���� ����������
		// ����� ���� ����� ��������
		
		return new int[]{rowRes, colRes};
	}
}
