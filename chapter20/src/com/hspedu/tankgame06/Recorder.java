package com.hspedu.tankgame06;

import java.io.*;
import java.util.Vector;

/**
 * @author Solider
 * @version 1.0
 * 该类用来记录玩家的成绩
 */
public class Recorder {
    // 初始化敌方坦克被打掉的数量
    private static int AllEnemyTankNum = 0;

    // 声明IO流，用来将玩家成绩读写文件
    private static BufferedWriter bw = null;
    private static BufferedReader br = null;
    private static String recordFile = "D:\\myTankGameRecord.txt";
    // 声明一个集合，用来记录退出时，敌方坦克的坐标
    private static Vector<EnemyTank> enemyTanks = null;
    // 声明一个vector集合，用来存取Node对象的信息
    private static Vector<Node> nodes = new Vector<>();

    // 声明方法，获取myTankGameRecord.txt记录的信息
    public static Vector<Node> getNodeInfoAndAllEnemyTankNum() {
        try {
            int count = 0;
            String line;
            br = new BufferedReader(new FileReader(recordFile));
            setAllEnemyTankNum(Integer.parseInt(br.readLine()));
            while((line = br.readLine()) != null) {
                String[] str = line.split(" ");
                nodes.add(new Node(Integer.parseInt(str[0]), Integer.parseInt(str[1]), Integer.parseInt(str[2])));
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return nodes;
    }

    public static void setEnemyTanks(Vector<EnemyTank> enemyTanks) {
        Recorder.enemyTanks = enemyTanks;
    }

    // 声明get, set方法，用来修改和得到击毁敌方坦克的数量
    public static int getAllEnemyTankNum() {
        return AllEnemyTankNum;
    }

    public static void setAllEnemyTankNum(int allEnemyTankNum) {
        AllEnemyTankNum = allEnemyTankNum;
    }

    // 声明一个方法，用来使得击毁敌方坦克的值增加
    public static void addAllEnemyTankNum() {
        AllEnemyTankNum++;
    }

    // 声明一个用来保存用户游戏记录的方法，当主线程退出时，就被调用
    public static void record() {
        // 声明一个文件，用来获取对应文件的位置
        File file = new File(recordFile);

        // 初始化IO流，将玩家成绩写入文件
        try {
            bw = new BufferedWriter(new FileWriter(file));
            bw.write(AllEnemyTankNum + "\r\n");
            for (int i = 0; i < enemyTanks.size(); i++) {
                // 获取剩余坦克
                EnemyTank enemyTank = enemyTanks.get(i);
                if (enemyTank.isLoop()) {
                    String str = enemyTank.getX() + " " +  enemyTank.getY() + " " + enemyTank.getDirection() + "";
                    bw.write(str + "\r\n");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                bw.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }


    }
}
