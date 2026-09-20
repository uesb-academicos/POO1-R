/*
 * UNIVERSIDADE ESTADUAL DO SUDOESTE DA BAHIA - UESB
 * CENTRO DE EDUCACAO ABERTA E A DISTANCIA - CEAD
 * CURSO: Tecnologia em Analise e Desenvolvimento de Sistemas
 * DISCIPLINA: Programacao Orientada a Objeto - 2026.2
 * PROFESSOR: Murilo Silva Santana
 * ALUNO: Thiago Ferreira Prates Neves
 * ATIVIDADE: Telas Swing - Cadastro de Aluno
 *
 * Objetivo: desenvolver a tela de aluno descrita na Apostila Java Swing.
 * Os botoes sao exibidos sem eventos, conforme solicitado no exercicio.
 */

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/** Tela independente para o cadastro de alunos da UHS. */
public class CadastroAluno extends JFrame {

    /** Construtor: configura a janela e monta seus componentes. */
    public CadastroAluno() {
        configurarJanela();
        criarInterface();
    }

    /** Define titulo, dimensoes, fechamento e centralizacao da janela. */
    private void configurarJanela() {
        setTitle("Cadastro de Aluno - UHS");
        setSize(720, 540);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    /** Cria os paineis exigidos e organiza todos os campos. */
    private void criarInterface() {
        JPanel painelPrincipal = new JPanel(new BorderLayout(12, 12));
        painelPrincipal.setBorder(BorderFactory.createEmptyBorder(15, 20, 15, 20));

        JPanel painelTitulo = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel titulo = new JLabel("Cadastro de Aluno");
        titulo.setFont(new Font("Arial", Font.BOLD, 22));
        painelTitulo.add(titulo);

        JPanel painelFormularios = new JPanel(new GridLayout(2, 1, 10, 10));

        JPanel painelDadosPessoais = new JPanel(new GridLayout(6, 2, 8, 8));
        painelDadosPessoais.setBorder(BorderFactory.createTitledBorder("Dados pessoais"));
        adicionarCampo(painelDadosPessoais, "Nome completo:", 25);
        adicionarCampo(painelDadosPessoais, "Matricula academica:", 15);
        adicionarCampo(painelDadosPessoais, "CPF:", 15);
        adicionarCampo(painelDadosPessoais, "Data de nascimento:", 12);
        adicionarCampo(painelDadosPessoais, "E-mail:", 25);
        adicionarCampo(painelDadosPessoais, "Telefone:", 15);

        JPanel painelDadosAcademicos = new JPanel(new GridLayout(4, 2, 8, 8));
        painelDadosAcademicos.setBorder(BorderFactory.createTitledBorder("Dados academicos"));
        adicionarCampo(painelDadosAcademicos, "Curso:", 25);
        adicionarCampo(painelDadosAcademicos, "Periodo atual:", 10);
        adicionarCampo(painelDadosAcademicos, "Turno:", 12);
        adicionarCampo(painelDadosAcademicos, "Cidade de origem:", 20);

        painelFormularios.add(painelDadosPessoais);
        painelFormularios.add(painelDadosAcademicos);

        JPanel painelRodape = new JPanel(new BorderLayout());
        JPanel painelBotoes = criarPainelBotoes();
        JLabel informacao = new JLabel(
                "Preencha todos os campos antes de concluir o cadastro.", JLabel.CENTER);
        painelRodape.add(informacao, BorderLayout.NORTH);
        painelRodape.add(painelBotoes, BorderLayout.SOUTH);

        painelPrincipal.add(painelTitulo, BorderLayout.NORTH);
        painelPrincipal.add(painelFormularios, BorderLayout.CENTER);
        painelPrincipal.add(painelRodape, BorderLayout.SOUTH);
        setContentPane(painelPrincipal);
    }

    /** Adiciona um JLabel e um JTextField alinhados no formulario. */
    private void adicionarCampo(JPanel painel, String texto, int colunas) {
        painel.add(new JLabel(texto));
        painel.add(new JTextField(colunas));
    }

    /** Agrupa os tres botoes requeridos, ainda sem comportamento. */
    private JPanel criarPainelBotoes() {
        JPanel painelBotoes = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 6));
        Dimension tamanhoBotao = new Dimension(105, 32);

        JButton botaoSalvar = new JButton("Salvar");
        JButton botaoLimpar = new JButton("Limpar");
        JButton botaoCancelar = new JButton("Cancelar");

        botaoSalvar.setPreferredSize(tamanhoBotao);
        botaoLimpar.setPreferredSize(tamanhoBotao);
        botaoCancelar.setPreferredSize(tamanhoBotao);

        painelBotoes.add(botaoSalvar);
        painelBotoes.add(botaoLimpar);
        painelBotoes.add(botaoCancelar);
        return painelBotoes;
    }

    /** Inicia a tela na fila de eventos do Swing. */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CadastroAluno tela = new CadastroAluno();
            tela.setVisible(true);
        });
    }
}
