package edu.grinnell.csc207.compression;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * The driver for the Grin compression program.
 */
public class Grin {
    /**
     * Decodes the .grin file denoted by infile and writes the output to the
     * .grin file denoted by outfile.
     * @param infile the file to decode
     * @param outfile the file to ouptut to
     * @throws IOException if either of the files cannot be opened
     */
    public static void decode (String infile, String outfile) throws IOException {
        BitInputStream in = new BitInputStream(infile);
        BitOutputStream out = new BitOutputStream(outfile);
        int magicNumber = in.readBits(32);
        if(magicNumber != 1846) {
            throw new IllegalArgumentException();
        }
        HuffmanTree tree = new HuffmanTree(in);
        tree.decode(in, out);
    }

    /**
     * Creates a mapping from 8-bit sequences to number-of-occurrences of
     * those sequences in the given file. To do this, read the file using a
     * BitInputStream, consuming 8 bits at a time.
     * @param file the file to read
     * @return a freqency map for the given file
     * @throws IOException if the file cannot be opened
     */
    public static Map<Short, Integer> createFrequencyMap (String file) throws IOException{
        BitInputStream in = new BitInputStream(file);
        Map<Short, Integer> freqs = new HashMap<>();
        while(in.hasBits()) {
            short bits = (short) in.readBits(8);
            if(freqs.containsKey(bits)) {
                freqs.replace(bits, freqs.get(bits) + 1);
            } else {
                freqs.put(bits, 1);
            }
        }
        return freqs;
    }

    /**
     * Encodes the given file denoted by infile and writes the output to the
     * .grin file denoted by outfile.
     * @param infile the file to encode.
     * @param outfile the file to write the output to.
     * @throws IOException if either of the files cannot be opened
     */
    public static void encode(String infile, String outfile) throws IOException {
        BitInputStream in = new BitInputStream(infile);
        BitOutputStream out = new BitOutputStream(outfile);
        HuffmanTree tree = new HuffmanTree(createFrequencyMap(infile));
        out.writeBits(1846, 32);
        tree.serialize(out);
        tree.encode(in, out);
    }

    /**
     * The entry point to the program.
     * @param args the command-line arguments.
     * @throws IOException if either of the filenames provided can't be opened
     */
    public static void main(String[] args) throws IOException {
        if(args.length != 3) {
            System.out.println("Usage: java Grin <encode|decode> <infile> <outfile>");
            return;
        }
        if(!args[0].equals("encode") || !args[0].equals("decode")) {
            System.out.println("Usage: java Grin <encode|decode> <infile> <outfile>");
            return;
        }
        if(args[0].equals("encode")) {
            encode(args[1], args[2]);
        } else {
            decode(args[1], args[2]);
        }
    }
}
