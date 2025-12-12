import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.nio.file.*;
import org.antlr.v4.gui.TreeViewer;
import javax.swing.*;
import java.util.Arrays;

public class NamvaranMain {
    public static void main(String[] args) throws Exception {
        if (args.length == 0) {
            System.err.println("Usage: java NamvaranMain <input.txt>");
            return;
        }

        String input = Files.readString(Path.of(args[0]));
    
        CharStream chars = CharStreams.fromString(input);
        NamvaranLexer lexer = new NamvaranLexer(chars);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        NamvaranParser parser = new NamvaranParser(tokens);

        ParseTree tree = parser.p();

        System.out.println(tree.toStringTree(parser));
    
        JFrame frame = new JFrame("Parse Tree");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        TreeViewer viewer = new TreeViewer(Arrays.asList(parser.getRuleNames()), tree);
        viewer.setScale(1.5);
        
        frame.add(viewer);
        frame.setSize(800, 600);
        frame.setVisible(true);
    }
}