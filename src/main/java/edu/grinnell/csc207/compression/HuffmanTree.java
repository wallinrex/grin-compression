package edu.grinnell.csc207.compression;

import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.function.BiConsumer;

/**
 * A HuffmanTree derives a space-efficient coding of a collection of byte
 * values.
 *
 * The huffman tree encodes values in the range 0--255 which would normally
 * take 8 bits. However, we also need to encode a special EOF character to
 * denote the end of a .grin file. Thus, we need 9 bits to store each
 * byte value. This is fine for file writing (modulo the need to write in
 * byte chunks to the file), but Java does not have a 9-bit data type.
 * Instead, we use the next larger primitive integral type, short, to store
 * our byte values.
 */
public class HuffmanTree {

    private PriorityQueue<Node> queue;

    private Node root;

    private class Node {

        private short bits;

        private int frequency;

        private Node left;

        private Node right;

        public Node(short bits, int frequency, Node left, Node right) {
            this.bits = bits;
            this.frequency = frequency;
            this.left = left;
            this.right = right;
        }

        public Node(short bits, int frequency) {
            this(bits, frequency, null, null);
        }

        public Node(Node left, Node right) {
            this((short) -1, left.getFrequency() + right.getFrequency(), left, right);
        }

        public Node() {
            this((short) -1, 0, null, null);
        }

        public Node(short bits) {
            this(bits, 0, null, null);
        }

        public int getFrequency() {
            return this.frequency;
        }
    }

    private class Enqueue implements BiConsumer<Short, Integer> {

        @Override
        public void accept(Short bits, Integer frequency) {
            Node newNode = new Node(bits, frequency);
            queue.add(newNode);
        }
    }

    private class CompareNodes implements Comparator<Node> {

        @Override
        public int compare(Node o1, Node o2) {
            if (o1.getFrequency() < o2.getFrequency()) {
                return -1;
            } else if (o1.getFrequency() > o2.getFrequency()) {
                return 1;
            } else {
                return 0;
            }
        }

    }

    /**
     * Constructs a new HuffmanTree from a frequency map.
     * 
     * @param freqs a map from 9-bit values to frequencies.
     */
    public HuffmanTree(Map<Short, Integer> freqs) {
        queue = new PriorityQueue<>(new CompareNodes());
        freqs.forEach(new Enqueue());
        while (queue.size() > 1) {
            Node newNode = new Node(queue.poll(), queue.poll());
            queue.add(newNode);
        }
        this.root = queue.poll();
    }

    /**
     * Constructs a new HuffmanTree from the given file.
     * 
     * @param in the input file (as a BitInputStream)
     */
    public HuffmanTree(BitInputStream in) {
        Stack<Node> path = new Stack<>();
        Node root = null;
        int bit = in.readBit();
        if (bit != 1) {
            throw new IllegalArgumentException();
        }
        Node newNode = new Node();
        path.push(newNode);
        while (!path.isEmpty()) {
            if (path.peek().left == null) {
                bit = in.readBit();
                if (bit == 1) {
                    newNode = new Node();
                    path.peek().left = newNode;
                    path.push(newNode);
                } else if (bit == 0) {
                    int bitSequence = in.readBits(9);
                    if (bitSequence < 0) {
                        throw new IllegalArgumentException();
                    }
                    newNode = new Node((short) bitSequence);
                    path.peek().left = newNode;
                } else {
                    throw new IllegalArgumentException();
                }
            } else if (path.peek().right == null) {
                bit = in.readBit();
                if (bit == 1) {
                    newNode = new Node();
                    path.peek().right = newNode;
                    path.push(newNode);
                } else if (bit == 0) {
                    int bitSequence = in.readBits(9);
                    if (bitSequence < 0) {
                        throw new IllegalArgumentException();
                    }
                    newNode = new Node((short) bitSequence);
                    path.peek().right = newNode;
                    path.pop();
                } else {
                    throw new IllegalArgumentException();
                }
            } else {
                root = path.pop();
            }
        }
        this.root = root;
    }

    /**
     * Writes this HuffmanTree to the given file as a stream of bits in a
     * serialized format.
     * 
     * @param out the output file as a BitOutputStream
     */
    public void serialize(BitOutputStream out) {
        // TODO: fill me in!
    }

    /**
     * Encodes the file given as a stream of bits into a compressed format
     * using this Huffman tree. The encoded values are written, bit-by-bit
     * to the given BitOuputStream.
     * 
     * @param in  the file to compress.
     * @param out the file to write the compressed output to.
     */
    public void encode(BitInputStream in, BitOutputStream out) {
        // TODO: fill me in!
    }

    /**
     * Decodes a stream of huffman codes from a file given as a stream of
     * bits into their uncompressed form, saving the results to the given
     * output stream. Note that the EOF character is not written to out
     * because it is not a valid 8-bit chunk (it is 9 bits).
     * 
     * @param in  the file to decompress.
     * @param out the file to write the decompressed output to.
     */
    public void decode(BitInputStream in, BitOutputStream out) {
        // TODO: fill me in!
    }
}
