package command;

import tarefas.GerenciadorTarefas;

public class ConcluirTarefaCommand implements Command{
    private GerenciadorTarefas gerenciador;
    private String descricao;

    public ConcluirTarefaCommand(GerenciadorTarefas gerenciador, String descricao) {
        this.gerenciador = gerenciador;
        this.descricao = descricao;

    }

    @Override
    public void execute() {
        gerenciador.concluirTarefaDescricao(descricao);
    }

    @Override
    public void undo() {
       gerenciador.reverterPorDescricao(descricao);
    }
}
