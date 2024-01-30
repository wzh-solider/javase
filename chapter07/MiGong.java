public class MiGong {
	public static void main(String[] args) {
		// �����ά���飬�����Թ����
		int[][] map = new int[8][7];
		for (int i = 0; i < 7; i++) {
			map[0][i] = 1; map[7][i] = 1;
			map[i][0] = 1; map[i][6] = 1;
		}
		map[3][1] = 1; map[3][2] = 1; map[2][2] = 1;
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 7; j++)
				System.out.print(" " + map[i][j]);
			System.out.println();
		}
		T1.findWay(map, 1, 1);
		System.out.println("=====�Թ�·��=====");
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 7; j++)
				System.out.print(" " + map[i][j]);
			System.out.println();
		}
	}
}

class T1 {
	public static boolean findWay(int[][] map, int i, int j) {
		if (map[6][5] == 2) { // �ж��Ƿ񵽴��Թ��յ�
			return true;
		} else {
			if (map[i][j] == 0) { // �жϵ�ǰλ���Ƿ����
				map[i][j] = 2; // �����ߵ�λ�üٶ�Ϊ2
				if (findWay(map, i + 1, j)) { // ʹ·�������ƣ�������� ����true
					return true;
				} else if (findWay(map, i, j + 1)) { // �����ߣ������ж�
					return true;
				} else if (findWay(map, i - 1, j)) { // �����ߣ������ж�
					return true;
				} else if (findWay(map, i, j - 1)) { // �����ߣ� �����ж�
					return true;
				} else {
					map[i][j] = 3; // ����������Ҷ������ߣ��򽫴�λ����Ϊ3
					return false;
				}
			}
			return false;
		}
	}
}