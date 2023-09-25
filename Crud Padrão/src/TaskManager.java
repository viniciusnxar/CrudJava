import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Task {
    private int id;
    private String description;

    public Task(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

public class TaskManager {
    private List<Task> tasks;
    private int nextId;

    public TaskManager() {
        tasks = new ArrayList<>();
        nextId = 1;
    }

    public void createTask(String description) {
        Task task = new Task(nextId, description);
        tasks.add(task);
        nextId++;
    }

    public Task readTask(int id) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                return task;
            }
        }
        return null;
    }

    public void updateTask(int id, String newDescription) {
        Task task = readTask(id);
        if (task != null) {
            task.setDescription(newDescription);
        }
    }

    public void deleteTask(int id) {
        Task task = readTask(id);
        if (task != null) {
            tasks.remove(task);
        }
    }

    public List<Task> getAllTasks() {
        return tasks;
    }

    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Escolha uma operacao:");
            System.out.println("1 - Criar tarefa");
            System.out.println("2 - Ler tarefa");
            System.out.println("3 - Atualizar tarefa");
            System.out.println("4 - Excluir tarefa");
            System.out.println("5 - Listar todas as tarefas");
            System.out.println("0 - Sair");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            switch (choice) {
                case 1:
                    System.out.print("Digite a descricao da tarefa: ");
                    String description = scanner.nextLine();
                    taskManager.createTask(description);
                    System.out.println("Tarefa criada com sucesso!");
                    break;
                case 2:
                    System.out.print("Digite o ID da tarefa: ");
                    int taskId = scanner.nextInt();
                    Task task = taskManager.readTask(taskId);
                    if (task != null) {
                        System.out.println("ID: " + task.getId() + ", Descricao: " + task.getDescription());
                    } else {
                        System.out.println("Tarefa nao encontrada.");
                    }
                    break;
                case 3:
                    System.out.print("Digite o ID da tarefa que deseja atualizar: ");
                    int taskIdToUpdate = scanner.nextInt();
                    scanner.nextLine(); // Limpar o buffer
                    System.out.print("Digite a nova descricao: ");
                    String newDescription = scanner.nextLine();
                    taskManager.updateTask(taskIdToUpdate, newDescription);
                    System.out.println("Tarefa atualizada com sucesso!");
                    break;
                case 4:
                    System.out.print("Digite o ID da tarefa que deseja excluir: ");
                    int taskIdToDelete = scanner.nextInt();
                    taskManager.deleteTask(taskIdToDelete);
                    System.out.println("Tarefa excluída com sucesso!");
                    break;
                case 5:
                    List<Task> allTasks = taskManager.getAllTasks();
                    System.out.println("Lista de Tarefas:");
                    for (Task t : allTasks) {
                        System.out.println("ID: " + t.getId() + ", Descricao: " + t.getDescription());
                    }
                    break;
                case 0:
                    System.out.println("Saindo do programa.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opcao inválida. Tente novamente.");
            }
        }
    }
}
