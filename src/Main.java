import command.*;
import painelControler.PainelControler;
import tarefas.GerenciadorTarefas;
import tarefas.Tarefa;

public class Main {
    public static void main(String[] args) {
        GerenciadorTarefas gerenciador = new GerenciadorTarefas();
        PainelControler painel = new PainelControler();

        System.out.println(" ============== Etapa 1 — execução imediata ==============");
        painel.executarComando(new AdicionarTarefaCommand(gerenciador, new Tarefa("Estudar Command")));
        painel.executarComando(new AdicionarTarefaCommand(gerenciador, new Tarefa("Implementar exercicio")));
        painel.executarComando(new ConcluirTarefaCommand(gerenciador, "Estudar Command"));

        System.out.println(" ============== Etapa 2 — desfazer ==============");
        painel.desfazerUltimoComando();

        System.out.println(" ============== Etapa 3 — fila ==============");
        painel.adicionarNaFila(new AdicionarTarefaCommand(gerenciador, new Tarefa("Revisar Observer")));
        painel.adicionarNaFila(new AdicionarTarefaCommand(gerenciador, new Tarefa("Estudar Chain of Responsibility")));
        painel.adicionarNaFila(new ConcluirTarefaCommand(gerenciador, "Implementar exercicio"));

        painel.processarFila();

        System.out.println(" ============== Etapa 4 — exibição final ==============");
        gerenciador.exibirTarefas();







    }
}
