import java.io.PrintStream;
import java.util.*;

public class HuffmanTree {
    HuffmanNode overallRoot;

     public HuffmanTree(int[] count){
        int size = count.length;
        Queue<HuffmanNode> list = new PriorityQueue<>();

        for(int i = 0; i < count.length; i++){
            if(count[i] != 0){
                HuffmanNode node = new HuffmanNode( i, count[i]);
                list.add(node);
                System.out.println(node.character +" how many times did this character appear: " + node.frequency);
            }
        }

         HuffmanNode eofNode = new HuffmanNode(size,1);
         list.add(eofNode);

         while(list.size() > 1) {
            HuffmanNode leftNode = list.remove();
            HuffmanNode rightNode = list.remove();
            HuffmanNode root = new HuffmanNode(leftNode.frequency + rightNode.frequency, leftNode, rightNode);
            list.add(root);
        }
        this.overallRoot = list.remove();
     }
     public HuffmanTree(Scanner input){
        while(input.hasNextLine()){
            int n = Integer.parseInt(input.nextLine());
            String code = input.nextLine();
            HuffmanNode node = new HuffmanNode(n,null,null);
            // resursive method
        }

     }

    public void write(PrintStream output){
         writeHelper(output,overallRoot,"");
    }
    private void writeHelper(PrintStream output, HuffmanNode rootNode, String location){
         if(rootNode != null){
             //base case
             if(rootNode.left == null && rootNode.right == null){
                 output.println(rootNode.character);
                 output.println(location);
             }else{
                 writeHelper(output,rootNode.left,location + 0);
                 writeHelper(output,rootNode.right,location + 1);
             }
         }
    }
}
