public class HuffmanNode implements Comparable<HuffmanNode>{
    public char character;
    public int frequency;
    public HuffmanNode left;
    public HuffmanNode right;

    public HuffmanNode(char character, int frequency) {
        this.character = character;
        this.frequency = frequency;
        left = null;
        right = null;
    }

    public HuffmanNode(char character, int frequency, HuffmanNode left, HuffmanNode right) {
        this.character = character;
        this.frequency = frequency;
        this.left = left;
        this.right = right;
    }

    public int compareTo(HuffmanNode otherNode) {
        return frequency - otherNode.frequency;
    }
}
