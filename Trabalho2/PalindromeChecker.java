package Trabalho2;
import java.util.Scanner;
import java.util.Stack;

public class PalindromeChecker {
    public static boolean isPalindrome(String word) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < word.length(); i++) {
            stack.push(word.charAt(i));
        }

        StringBuilder reversedWord = new StringBuilder();

        while (!stack.isEmpty()) {
            reversedWord.append(stack.pop());
        }

        printStack(stack);

        return word.equals(reversedWord.toString());
    }

    public static void printStack(Stack<Character> stack) {
        System.out.println("Pilha:");
        System.out.println("-----");

        for (Character character : stack) {
            System.out.println("| " + character + " |");
            System.out.println("-----");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Insire a palavra: ");
        String word = sc.nextLine();
        boolean isPalindrome = isPalindrome(word);

        if (isPalindrome) {
            System.out.println(word + " é um palíndromo.");
        } else {
            System.out.println(word + " não é um palíndromo.");
        }

        Stack<String> studentsStack = new Stack<>();
        studentsStack.push("Alice");
        studentsStack.push("Bob");
        studentsStack.push("Charlie");

        System.out.println("Tamanho da pilha de alunos: " + studentsStack.size());
        System.out.println("Pilha de alunos vazia? " + studentsStack.isEmpty());
        System.out.println("Elemento no topo da pilha de alunos: " + studentsStack.peek());

        // Utilizando a pilha para inverter a ordem dos alunos em uma fila representada por uma Lista Simplesmente Encadeada (LSE)
        LSEQueue<String> studentsQueue = new LSEQueue<>();
        studentsQueue.enqueue("David");
        studentsQueue.enqueue("Eve");
        studentsQueue.enqueue("Frank");

        System.out.println("Fila original:");
        studentsQueue.printQueue();

        System.out.println("Fila invertida usando a pilha:");
        while (!studentsQueue.isEmpty()) {
            studentsStack.push(studentsQueue.dequeue());
        }

        while (!studentsStack.isEmpty()) {
            studentsQueue.enqueue(studentsStack.pop());
        }

        studentsQueue.printQueue();
    }
}
