import java.io.PrintStream;
import java.util.*;

public class HuffmanTree {
     public HuffmanNode overallRoot;

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
         overallRoot = new HuffmanNode(0,null,null);
        while(input.hasNextLine()){
            int character = Integer.parseInt(input.nextLine());
            String code = input.nextLine();
            HuffmanNode node = new HuffmanNode(character, 0,null,null);
            // resursive method
            overallRoot = treeBuilder(overallRoot,node,code);
        }
     }

     public void decode(BitInputStream input, PrintStream output, int eof){
         int choice = input.readBit();
         HuffmanNode traverse = overallRoot;
         while((choice == 0 || choice == 1) && traverse.character != eof) {
             while (traverse.left != null && traverse.right != null && traverse.character != eof) {
                 if (choice == 0) {
                     traverse = traverse.left;
                     choice = input.readBit();
                 } else if (choice == 1) {
                     traverse = traverse.right;
                     choice = input.readBit();
                 }
             }

             if (traverse.character != eof) {
                 output.write(traverse.character);
                 System.out.println((char) traverse.character);
                 traverse = overallRoot;
             }
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

    private HuffmanNode treeBuilder(HuffmanNode rootNode, HuffmanNode currentNode, String path){
            if(path.isEmpty()){
                return currentNode;
            }
             if(path.charAt(0) == '0'){
                    if(rootNode.left == null){
                        rootNode.left = new HuffmanNode(0,null,null);
                    }
                    rootNode.left = treeBuilder(rootNode.left ,currentNode,path.substring(1));
             }
             if(path.charAt(0) == '1'){
                 if(rootNode.right == null){
                     rootNode.right = new HuffmanNode(0,null,null);
                 }
                    rootNode.right = treeBuilder(rootNode.right,currentNode,path.substring(1));
             }
             return rootNode;
    }
}
