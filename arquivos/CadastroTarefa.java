import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class CadastroTarefa {

    // Listas para armazenar as informações das tarefas
    static List<String> descricoesTarefas = new ArrayList<>();
    static List<String> prioridadesTarefas = new ArrayList<>();
    static List<Boolean> finalizadoTarefas = new ArrayList<>();


    public static void main(String[] args) {

        // Objeto que possibilita a criação da janela de cadastro
        JFrame janelaPrincipal = new JFrame("Cadastro de Tarefas");

        // Definindo o tamanho da janela
        janelaPrincipal.setSize(390, 360);

        // Possibilita que o programa pare a partir do momento que o usuário fecha a janela pelo X
        janelaPrincipal.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Definindo que a tela fique centralizado na tela
        janelaPrincipal.setLocationRelativeTo(null);

        // Objeto que define qual tipo de layout será usado na janela
        GroupLayout layout = new GroupLayout(janelaPrincipal.getContentPane());

        // Definindo uma margem para o layout
        layout.setAutoCreateContainerGaps(true);

        // Configurando o layout no frame
        janelaPrincipal.setLayout(layout);

        // Definindo os labels do programa
        JLabel lblTarefa = new JLabel("Tarefa");
        JLabel lblPrioridade = new JLabel("Prioridade");

        // Definindo o campo da tarefa
        JTextField campoTarefa = new JTextField();

        // Definindo a lista de prioridades e o campo
        String[] prioridades = {"Alta", "Média", "Baixa"};
        JComboBox campoPrioridade = new JComboBox(prioridades);

        // Definindo o checkbox de caso a tarefa esteja finalizado
        JCheckBox campoFinalizado = new JCheckBox("Finalizado");

        // Definindo os botões de cancelar e salvar
        JButton btnCancelar = new JButton("Cancelar");
        JButton btnSalvar = new JButton("Salvar");

        // DEFININDO OS LAYOUTS NAS PARTES HORIZONTAIS E VERTICAIS

        layout.setHorizontalGroup(
                layout
                        .createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)

                                .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblTarefa, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                )

                                .addGroup(layout.createSequentialGroup()
                                        .addComponent(campoTarefa, GroupLayout.PREFERRED_SIZE, 350, GroupLayout.PREFERRED_SIZE)
                                )

                                .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblPrioridade, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                )

                                .addGroup(layout.createSequentialGroup()
                                        .addComponent(campoPrioridade, GroupLayout.PREFERRED_SIZE, 350, GroupLayout.PREFERRED_SIZE)
                                )

                                .addGroup(layout.createSequentialGroup()
                                        .addComponent(campoFinalizado, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                )

                                .addGroup(layout.createSequentialGroup()
                                        .addGap(115)
                                        .addComponent(btnCancelar, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                        .addGap(25)
                                        .addComponent(btnSalvar, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                )
                        )
        );

        layout.setVerticalGroup(
                layout
                        .createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()

                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(lblTarefa, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                )
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(campoTarefa, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
                                )

                                .addGap(15)

                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(lblPrioridade, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                )

                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(campoPrioridade, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                                )

                                .addGap(15)

                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(campoFinalizado, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                                )

                                .addGap(15)

                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(btnCancelar, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnSalvar, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                                )
                        )
        );

        // Possibilita que a janela fique visível quando executa o programa
        janelaPrincipal.setVisible(true);

        // Adicionando o evento de parada do programa para o botão Cancelar
        btnCancelar.addActionListener((e -> System.exit(0)));

        // Adicionando o evento para o botão Salvar
        btnSalvar.addActionListener((e -> salvarDados(
                campoTarefa.getText(),
                campoPrioridade.getSelectedItem().toString(),
                campoFinalizado.isSelected()
        )));
    }

    // Método para salvar as informações da tarefa nas respectivas listas
    static void salvarDados(String descricaoTarefa, String prioridadeTarefa, boolean finalizadoTarefa){

        // Adição dos dados nas respectivas listas
        descricoesTarefas.add(descricaoTarefa);
        prioridadesTarefas.add(prioridadeTarefa);
        finalizadoTarefas.add(finalizadoTarefa);

        // Chamado do método para mostrar os dados de todas as tarefas
        mostrarDados();
    }

    // Método para mostrar os dados de todas as tarefas no terminal
    static void mostrarDados(){

        // Estrutura de repetição para percorrer os dados de cada lista
        for (int i = 0; i < descricoesTarefas.size(); i++) {

            System.out.println("\nTarefa " + (i + 1));
            System.out.println("\nDescrição: " + descricoesTarefas.get(i) +
                    "\nPrioridade: " + prioridadesTarefas.get(i) +
                    "\nFinalizado: "  + finalizadoTarefas.get(i));
        }
    }
}
