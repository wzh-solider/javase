public class MiGong {
	public static void main(String[] args) {
		// 定义二维数组，画出迷宫框架
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
		System.out.println("=====迷宫路径=====");
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 7; j++)
				System.out.print(" " + map[i][j]);
			System.out.println();
		}
	}
}

class T1 {
	public static boolean findWay(int[][] map, int i, int j) {
		if (map[6][5] == 2) { // 判断是否到达迷宫终点
			return true;
		} else {
			if (map[i][j] == 0) { // 判断当前位置是否可走
				map[i][j] = 2; // 将可走的位置假定为2
				if (findWay(map, i + 1, j)) { // 使路径向下移，如果可走 返回true
					return true;
				} else if (findWay(map, i, j + 1)) { // 向右走，进行判断
					return true;
				} else if (findWay(map, i - 1, j)) { // 向上走，进行判断
					return true;
				} else if (findWay(map, i, j - 1)) { // 向下走， 进行判断
					return true;
				} else {
					map[i][j] = 3; // 如果上下左右都不能走，则将此位置置为3
					return false;
				}
			}
			return false;
		}
	}
}