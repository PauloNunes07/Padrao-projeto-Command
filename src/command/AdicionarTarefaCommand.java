package command;

import tarefas.GerenciadorTarefas;
import tarefas.Tarefa;

public class AdicionarTarefaCommand implements Command {
    private GerenciadorTarefas gerenciador;
    private Tarefa tarefa;

    public AdicionarTarefaCommand(GerenciadorTarefas gerenciador, Tarefa tarefa) {
        this.gerenciador = gerenciador;
        this.tarefa = tarefa;
    }

    @Override
    public void execute() {
        gerenciador.adicionarTarefa(tarefa);


    }

    @Override
    public void undo() {
        gerenciador.removerTarefa(tarefa);
    }
}
