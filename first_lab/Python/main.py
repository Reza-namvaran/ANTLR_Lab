import sys
from antlr4 import *
from antlr4.tree.Tree import TerminalNode
from NamvaranLexer import NamvaranLexer
from NamvaranParser import NamvaranParser

def print_tree(node, parser, indent=""):
    if isinstance(node, TerminalNode):
        print(f"{indent}{node.getText()} [{parser.symbolicNames[node.symbol.type]}]")
    else:
        rule_name = parser.ruleNames[node.getRuleIndex()]
        print(f"{indent}{rule_name}")
        for child in node.getChildren():
            print_tree(child, parser, indent + " ")

def main() -> None:
    if len(sys.argv) < 2:
        print("Usage: python main.py <input.txt>")
        sys.exit(1)

    input_file = sys.argv[1]

    input_stream = FileStream(input_file)
    lexer = NamvaranLexer(input_stream)
    tokens = CommonTokenStream(lexer)
    parser = NamvaranParser(tokens)

    tree = parser.p()

    print("\nParse Tree:")
    print(tree.toStringTree(recog=parser))
    print_tree(tree, parser)

if __name__ == "__main__":
    main()

