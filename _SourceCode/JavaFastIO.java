// import java.io.*;
// import java.math.*;
// import java.security.*;
// import java.text.*;
// import java.util.*;
// import java.util.concurrent.*;
// import java.util.function.*;
// import java.util.regex.*;
// import java.util.stream.*;
// import static java.util.stream.Collectors.joining;
// import static java.util.stream.Collectors.toList;

// class Result {
//     public static List<Integer> shortestReach(int n, List<List<Integer>> edges, int s) {
//         // Your code here
//         return null;
//     }

// }

// class InputReader {

//     private InputStream stream;
//     private byte[] buf = new byte[1024];
//     private int curChar;
//     private int numChars;
//     private SpaceCharFilter filter;

//     public InputReader(InputStream stream) {
//         this.stream = stream;
//     }

//     public int read() {
//         if (numChars == -1)
//             throw new InputMismatchException();
//         if (curChar >= numChars) {
//             curChar = 0;
//             try {
//                 numChars = stream.read(buf);
//             } catch (IOException e) {
//                 throw new InputMismatchException();
//             }
//             if (numChars <= 0)
//                 return -1;
//         }
//         return buf[curChar++];
//     }

//     public int readInt() {
//         int c = read();
//         while (isSpaceChar(c))
//             c = read();
//         int sgn = 1;
//         if (c == '-') {
//             sgn = -1;
//             c = read();
//         }
//         int res = 0;
//         do {
//             if (c < '0' || c > '9')
//                 throw new InputMismatchException();
//             res *= 10;
//             res += c - '0';
//             c = read();
//         } while (!isSpaceChar(c));
//         return res * sgn;
//     }

//     public String readString() {
//         int c = read();
//         while (isSpaceChar(c))
//             c = read();
//         StringBuilder res = new StringBuilder();
//         do {
//             res.appendCodePoint(c);
//             c = read();
//         } while (!isSpaceChar(c));
//         return res.toString();
//     }

//     public boolean isSpaceChar(int c) {
//         if (filter != null)
//             return filter.isSpaceChar(c);
//         return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
//     }

//     public String next() {
//         return readString();
//     }

//     public interface SpaceCharFilter {
//         public boolean isSpaceChar(int ch);
//     }
// }

// class OutputWriter {
//     private final PrintWriter writer;

//     public OutputWriter(OutputStream outputStream) {
//         writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
//     }

//     public OutputWriter(Writer writer) {
//         this.writer = new PrintWriter(writer);
//     }

//     public void print(Object... objects) {
//         for (int i = 0; i < objects.length; i++) {
//             if (i != 0)
//                 writer.print(' ');
//             writer.print(objects[i]);
//         }
//     }

//     public void printLine(Object... objects) {
//         print(objects);
//         writer.println();
//     }

//     public void close() {
//         writer.close();
//     }

//     public void flush() {
//         writer.flush();
//     }

// }

// class IOUtils {
//     public static int[] readIntArray(InputReader in, int size) {
//         int[] array = new int[size];
//         for (int i = 0; i < size; i++)
//             array[i] = in.readInt();
//         return array;
//     }

// }

// public class Solution {
//     public static void main(String[] args) {
//         InputReader in = new InputReader(System.in);
//         OutputWriter out = new OutputWriter(System.out);

//         int t = in.readInt();
//         while (t > 0) {
//             int n = in.readInt();
//             int m = in.readInt();
//             List<List<Integer>> edges = new ArrayList<>();
//             for (int i = 0; i < m; i++) {
//                 List<Integer> e = new ArrayList<>();
//                 e.add(in.readInt());
//                 e.add(in.readInt());
//                 e.add(in.readInt());
//                 edges.add(e);
//             }
//             int start = in.readInt();
//             var result = Result.shortestReach(n, edges, start);
//             for (Integer integer : result) {
//                 out.print(integer + " ");
//             }
//             out.printLine();
//             t--;
//         }
//         out.flush();
//         out.close();
//     }
// }
