package gao.javabase.algorithm.leetcode.dp;

import java.util.HashSet;
import java.util.Set;

/**
 * @author  gaosd
 * @description ：游戏背包的代码实现
 */
public class GameBag {

    /*处理过程中需要的二维数组的元素定义*/
    private static class ArrayElement {
        /*计算后的数组元素值*/
        private int value;
        /*哪些物品的值组成了当前数组元素*/
        private Set<Element> elements;

        public ArrayElement(int value, Element element) {
            this.value = value;
            this.elements = new HashSet<>();
            this.elements.add(element);
        }

        public ArrayElement(int value, Set<Element> elements) {
            this.value = value;
            this.elements = elements;
        }

        @Override
        public String toString() {
            return "BagElement{" +
                    "value=" + value +
                    ", elements=" + elements +
                    '}';
        }
    }

    /*放入背包的物品*/
    private static class Element{
        private final String name;
        private final int value;/*物品的价值*/
        private final int cost;/*物品的花费*/

        public Element(String name,  int cost,int value) {
            this.name = name;
            this.value = value;
            this.cost = cost;
        }

        @Override
        public String toString() {
            return "Element{" +
                    "name='" + name + '\'' +
                    ", value=" + value +
                    ", cost=" + cost +
                    '}';
        }
    }

    public void printArray(Element[] goods, int bagSize, ArrayElement[][] calc){
        for(int i=0;i<goods.length;i++){
            for(int j=0;j<bagSize;j++){
                //if( calc[i][j] !=null)
                System.out.print("i="+i+",j="+j+","+calc[i][j]+" ");
            }
            System.out.println("");
        }
    }

    public void printRow(int rowNo, int bagSize, ArrayElement[][] calc){
        System.out.println("当前行号："+ rowNo);
        for(int j=0;j<bagSize;j++){
            if( calc[rowNo][j] !=null)
            System.out.print("j="+j+","+calc[rowNo][j]+" ");
        }
        System.out.println("");
    }

    public void putBag(Element[] goods,int bagSize){
        ArrayElement[][] calcArray = new ArrayElement[goods.length][bagSize];
        for(int i=0;i<goods.length;i++){
            for(int j=0;j<bagSize;j++){
                if(i==0){/*第一行数据做特殊处理*/
                    calcArray[i][j] = new ArrayElement(goods[i].value,goods[i]);
                }else{
                    /*计算本单元格是否能放下当前物品*/
                    int spareSpace = j+1-goods[i].cost;
                    if(spareSpace < 0){/*放不下，直接使用上一行同列的数据*/
                        calcArray[i][j] = calcArray[i-1][j];
                    }else{/*可以放下，需要判断上一行同列的值和当前商品的价值+剩余空间的价值哪个更大*/
                        int preRow = i-1;
                        /*上一行同列的值*/
                        int preRowValue = calcArray[preRow][j].value;
                        /*当前商品的价值*/
                        int currentGoodsValue = goods[i].value;
                        /*是否有剩余空间，如果有，获得剩余空间最大价值*/
                        if(spareSpace > 0) currentGoodsValue += calcArray[preRow][spareSpace-1].value;
                        if(preRowValue >= currentGoodsValue){
                            /*使用上一行同列的数据*/
                            calcArray[i][j] = calcArray[preRow][j];
                        }else{
                            if(spareSpace == 0){/*空间只够存放当前物品*/
                                calcArray[i][j] = new ArrayElement(currentGoodsValue,goods[i]);
                            }else{
                                Set<Element> newElement =
                                        (HashSet<Element>)((HashSet<Element>)calcArray[preRow][spareSpace-1].elements).clone();
                                newElement.add(goods[i]);
                                calcArray[i][j] = new ArrayElement(currentGoodsValue,newElement);
                            }
                        }
                    }
                }
            }
            //printArray(goods,bagSize,calcArray);
            printRow(i,bagSize,calcArray);
            System.out.println("------------------------------------");
        }
        System.out.println("最终结果： "+calcArray[goods.length-1][bagSize-1]);
    }

    public static void main(String[] args) {
        Element[] gameElements = {new Element("断玉匕",1,1500)
                ,new Element("金精玉魄剑",3,2000)
                ,new Element("天蚕甲",4,3000)};
        new GameBag().putBag(gameElements,4);


//        Element[] tourElements = {new Element("天安门广场",1,9),
//            new Element("故宫",4,9),
//            new Element("颐和园",2,9),
//            new Element("八达岭长城",1,7),
//            new Element("天坛",1,6),
//            new Element("圆明园",2,8),
//            new Element("恭王府",1,5)};
//        new GameBag().putBag(tourElements,6);
    }

}
