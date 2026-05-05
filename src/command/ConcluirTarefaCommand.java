package command;

import tarefas.GerenciadorTarefas;

public class ConcluirTarefaCommand implements Command{
    private GerenciadorTarefas gerenciador;
    String descricao;
    private int index;

    public ConcluirTarefaCommand(GerenciadorTarefas gerenciador, int index) {
        this.gerenciador = gerenciador;
        this.index = index;

    }

    public ConcluirTarefaCommand(GerenciadorTarefas gerenciador, String descricao) {
        this.gerenciador = gerenciador;
        this.descricao = descricao;
    }

    @Override
    public void execute() {
        if(descricao == null) {
            gerenciador.concluirTarefa(index);
        }
        else {
            gerenciador.concluirTarefa(descricao);
        }
    }

    @Override
    public void undo() {
        if(descricao == null) {
            gerenciador.reverter(index);
        }
        else {
            gerenciador.reverter(descricao);
        }
    }
}
