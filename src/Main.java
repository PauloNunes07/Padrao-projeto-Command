import command.*;
import painelControler.PainelControler;
import tarefas.GerenciadorTarefas;
import tarefas.Tarefa;

public class Main {
    public static void main(String[] args) {
        GerenciadorTarefas gerenciador = new GerenciadorTarefas();
        PainelControler painel = new PainelControler();

        Tarefa task1 = new Tarefa("Estudar Command");
        Tarefa task2 = new Tarefa("Implementar exercicio");

        System.out.println(" ============== Etapa 1 — execução imediata ==============");
        painel.executarComando(new AdicionarTarefaCommand(gerenciador, task1));
        painel.executarComando(new AdicionarTarefaCommand(gerenciador, task2));
        painel.executarComando(new ConcluirTarefaCommand(gerenciador,  "Estudar Command"));

        System.out.println(" ============== Etapa 2 — desfazer ==============");
        painel.desfazerUltimoComando();

        System.out.println(" ============== Etapa 3 — fila ==============");
        Tarefa task3 = new Tarefa("Revisar Observer");
        Tarefa task4 = new Tarefa("Estudar Chain of Responsibility");
        painel.adicionarNaFila(new AdicionarTarefaCommand(gerenciador, task3));
        painel.adicionarNaFila(new AdicionarTarefaCommand(gerenciador, task4));
        painel.adicionarNaFila(new ConcluirTarefaCommand(gerenciador, "Implementar exercicio"));

        painel.processarFila();

        System.out.println(" ============== Etapa 4 — exibição final ==============");
        gerenciador.exibirTarefas();







    }
}
