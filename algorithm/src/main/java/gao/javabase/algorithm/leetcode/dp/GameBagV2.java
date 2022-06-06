package gao.javabase.algorithm.leetcode.dp;

import java.util.HashSet;
import java.util.Set;

/**
 * @author  gaosd
 * @description ：游戏背包的代码实现
 * 去除辅助类
 */
public class GameBagV2 {

    /*放入背包的物品*/
    private static class Element{
        private final String name;
        private final int value;
        private final int cost;

        public Element(String name,  int cost,int value) {
            this.name = name;
            this.value = value;
            this.cost = cost;
        }
    }

    public void printArray(int arrayX, int arrayY,int[][] calcArray){
        for(int i=0;i<arrayX;i++){
            for(int j=0;j<arrayY;j++){
                System.out.print("[i="+i+",j="+j+"]="+calcArray[i][j]+" ,");
            }
            System.out.println("");
        }
    }

    public void printRow(int rowNo, int[][] calcArray){
        System.out.println("当前行号："+ rowNo);
        int arrayY = 0;
        for(int j:calcArray[rowNo]){
            System.out.print("[arrayY="+arrayY+++"]="+j+" ,");
        }
        System.out.println("");
    }

    public void putBag(Element[] goods,int bagSize){
        int arrayX = goods.length + 1;
        int arrayY = bagSize + 1;
        int[][] calcArray = new int[arrayX][arrayY];
        for(int i=0;i<arrayX;i++){
            for(int j=0;j<arrayY;j++){
                if(i==0||j==0){/*第0行，第0列赋0值*/
                    calcArray[i][j] = 0;
                }else{
                    /*当前物品在物品数组中的下标*/
                    int goodsIndex = i-1;
                    /*上一行同列的值*/
                    int preRow = i-1;
                    int preRowValue = calcArray[preRow][j];
                    /*计算本单元格是否能放下当前物品*/
                    int spareSpace = j-goods[goodsIndex].cost;
                    if(spareSpace < 0){/*放不下，直接使用上一行同列的数据*/
                        calcArray[i][j] = preRowValue;
                    }else{/*可以放下，需要判断上一行同列的值和当前商品的价值+剩余空间的价值哪个更大*/
                        /*当前商品的价值*/
                        int currentGoodsValue = goods[goodsIndex].value;
                        /*是否有剩余空间，如果有，获得剩余空间最大价值*/
                        if(spareSpace >= 0) currentGoodsValue += calcArray[preRow][spareSpace];
                        calcArray[i][j] = Math.max(preRowValue,currentGoodsValue);
                    }
                }
            }
            printRow(i,calcArray);
            System.out.println("------------------------------------");
        }
        //printArray(arrayX,arrayY,calcArray);
        System.out.println("最终结果： "+calcArray[goods.length][bagSize]);
        System.out.println(findWhich(goods.length,bagSize,calcArray,goods));
    }

    /*通过最终结果反推组成的物品*/
    public String findWhich(int axisX,int axisY,int[][] calcArray,Element[] goods){
        StringBuffer sb = new StringBuffer();
        if(axisX>0){
            if(calcArray[axisX-1][axisY] == calcArray[axisX][axisY]){
                sb.append(findWhich(axisX-1,axisY,calcArray,goods));
            }else{
                sb.append(goods[axisX-1].name+",");
                sb.append(findWhich(axisX-1,axisY-goods[axisX-1].cost,calcArray,goods));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Element[] gameElements = {
                new Element("天蚕甲",4,3000),
                new Element("断玉匕",1,1500)
                ,new Element("金精玉魄剑",3,2000)
                };

        Element[] tourElements = {new Element("天安门广场",1,9),
                new Element("故宫",4,9),
                new Element("颐和园",2,9),
                new Element("八达岭长城",1,7),
                new Element("天坛",1,6),
                new Element("圆明园",2,8),
                new Element("恭王府",1,5)};

        new GameBagV2().putBag(tourElements,6);
        new GameBagV2().putBag(gameElements,4);
    }

}
