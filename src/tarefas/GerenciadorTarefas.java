package tarefas;


import java.util.ArrayList;
import java.util.List;

public class GerenciadorTarefas {
    private List<Tarefa> tarefas = new ArrayList<>();

    public void adicionarTarefa(Tarefa tarefa) {
        if (tarefa == null) {
            throw new IllegalArgumentException("Não foi possivel adicionar uma tarefa vazia!");
        }
        System.out.println("Tarefa adicionada: " + tarefa.getDescricao());
        tarefas.add(tarefa);
    }

    public Tarefa buscaPorDescricao(String descricao) {

        for(Tarefa tarefa : tarefas) {
            if(tarefa.getDescricao().equalsIgnoreCase(descricao)) {
                return tarefa;
            }
        }
        return null;
    }

    public Tarefa buscarPorIndex(int index) {

        if (index < 0 || index >= tarefas.size()) {
            throw new IllegalArgumentException("Posição invalida dentro da lista de tarefas");

        }
        return tarefas.get(index);
    }
    public void removerTarefa(Tarefa tarefa) {
        if(!tarefas.remove(tarefa)) {
            throw new IllegalArgumentException("Não foi possivel remover uma tarefa que não está na lista");
        }

    }

    public Tarefa removerUltimaTarefa() {
        if (tarefas.isEmpty()) {
            throw new IllegalArgumentException("Não há tarefas para remover");
        }
        Tarefa removida = tarefas.remove(tarefas.size() - 1);
        System.out.println("Tarefa removida: " + removida.getDescricao());
        return removida;

    }

    public void reverterPorDescricao(String descricao) {
        for (Tarefa tarefa : tarefas) {
            if (tarefa.getDescricao().equalsIgnoreCase(descricao)) {
                tarefa.setConcluida(false);
                System.out.println("Tarefa voltou para pendente " + tarefa.getDescricao());
                return;
            }

        }
        throw new IllegalArgumentException("Tarefa não encontrada");

    }

    public void reverterPorIndex(int index) {
        if (index < 0 || index >= tarefas.size()) {
            throw  new IllegalArgumentException("Posição invalida dentro da lista de tarefas");

        }
        Tarefa tarefa = tarefas.get(index);
        tarefa.setConcluida(false);
        System.out.println("Tarefa voltou para pendente: " + tarefa.getDescricao());


    }
    public void concluirTarefaDescricao(String descricao) {

        for (Tarefa tarefa : tarefas) {
            if (tarefa.getDescricao().equalsIgnoreCase(descricao)) {
                tarefa.setConcluida(true);
                System.out.println("Tarefa concluida: " + tarefa.getDescricao());
                return;
            }

        }
       throw new IllegalArgumentException("Tarefa não encontrada");

    }

        public void concluirTarefaIndex ( int index) {

            if (index < 0 || index >= tarefas.size()) {
                throw  new IllegalArgumentException("Posição invalida dentro da lista de tarefas");

            }
            Tarefa tarefa = tarefas.get(index);
            tarefa.setConcluida(true);
            System.out.println("Tarefa concluida: " + tarefa.getDescricao());

        }

    public void exibirTarefas() {
        System.out.println("================ Lista atual de Tarefas ================ ");
        if(tarefas.isEmpty()) {
            System.out.println("Não há tarefas no sistema");

        } else {
            for(Tarefa tarefa : tarefas) {
                System.out.println(tarefa);
            }
            System.out.println("___________________________________________");
        }

    }






}
