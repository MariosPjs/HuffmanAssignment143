public class HuffmanNode implements Comparable<HuffmanNode>{
    public int character;
    public int frequency;
    public HuffmanNode left;
    public HuffmanNode right;

    public HuffmanNode(int frequency, HuffmanNode left, HuffmanNode right) {
        this.frequency = frequency;
        this.right = right;
        this.left = left;
    }

    public HuffmanNode(int character, int frequency) {
        this.character = character;
        this.frequency = frequency;
        this.left = null;
        this.right = null;
    }

    public HuffmanNode(int character, int frequency, HuffmanNode left, HuffmanNode right){
        this.character = character;
        this.frequency = frequency;
        this.left = left;
        this.right = right;
    }

    public int compareTo(HuffmanNode otherNode) {
        return this.frequency - otherNode.frequency;
    }
}
