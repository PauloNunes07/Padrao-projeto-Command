package painelControler;

import command.Command;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class PainelControler {
    private Stack<Command> historico = new Stack<>();
    private Queue<Command> fila = new LinkedList<>();

    public void executarComando(Command command) {
        try {
            command.execute();
            historico.push(command);
        } catch(IllegalArgumentException erro) {
            System.out.println(erro.getMessage());
        }
    }

    public void desfazerUltimoComando() {
        if(historico.isEmpty()) {
             System.out.println("Nenhum comando para desfazer");
             return;
        }

        System.out.println("Desfazendo último comando...");
        try {
            Command command = historico.pop();
            command.undo();

        } catch(IllegalArgumentException erro) {
            System.out.println(erro.getMessage());
        }

    }

    public void adicionarNaFila(Command command) {
        if(command == null) {
            throw new IllegalArgumentException("Não foi possivel adicionar um commando a lista");
        }
        System.out.println("Comando adicionado a fila");
        fila.add(command);

    }

    public void processarFila() {
        System.out.println("Processando fila...");
        while(!fila.isEmpty()) {
            Command comando = fila.poll();
            try {
                comando.execute();
                historico.push(comando);
            } catch(IllegalArgumentException erro) {
                System.out.println(erro.getMessage());
            }
        }
    }

}