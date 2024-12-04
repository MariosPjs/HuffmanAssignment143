import java.util.*;

public class HuffmanTree {

    HuffmanTree(int[] count){
        Queue<HuffmanNode> list = new PriorityQueue<>();
        for(int i = 0; i < count.length; i++){
            if(count[i] != 0){
                HuffmanNode node = new HuffmanNode((char) i,count[i]);
                list.add(node);
            }
        }
        //need to think of a different loop so that the loop stops when the
//        for(HuffmanNode node : list){
//            HuffmanNode temp = list.remove();
//            if(list.remove() != null){
//                HuffmanNode temp2 = list.remove();
//
//            }
//        }
    }
}
