/*
 * UNIVERSIDADE ESTADUAL DO SUDOESTE DA BAHIA - UESB
 * CENTRO DE EDUCACAO ABERTA E A DISTANCIA - CEAD
 * CURSO: Tecnologia em Analise e Desenvolvimento de Sistemas
 * DISCIPLINA: Programacao Orientada a Objeto - 2026.2
 * PROFESSOR: Murilo Silva Santana
 * ALUNO: Thiago Ferreira Prates Neves
 * ATIVIDADE: Telas Swing - Cadastro de Professor
 *
 * Objetivo: construir a tela solicitada na Apostila Java Swing usando
 * JFrame, JPanel, JLabel, JTextField, JButton e gerenciadores de layout.
 * Conforme o enunciado, os botoes sao apenas visuais e nao possuem eventos.
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

/** Tela independente para o cadastro de professores da UHS. */
public class CadastroProfessor extends JFrame {

    /** Construtor: configura a janela e monta seus componentes. */
    public CadastroProfessor() {
        configurarJanela();
        criarInterface();
    }

    /** Define as propriedades basicas do JFrame. */
    private void configurarJanela() {
        setTitle("Cadastro de Professor - UHS");
        setSize(720, 520);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    /** Cria e organiza cabecalho, formularios e botoes. */
    private void criarInterface() {
        JPanel painelPrincipal = new JPanel(new BorderLayout(12, 12));
        painelPrincipal.setBorder(BorderFactory.createEmptyBorder(15, 20, 15, 20));

        JPanel painelTitulo = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel titulo = new JLabel("Cadastro de Professor");
        titulo.setFont(new Font("Arial", Font.BOLD, 22));
        painelTitulo.add(titulo);

        JPanel painelFormularios = new JPanel(new GridLayout(2, 1, 10, 10));

        JPanel painelDadosPessoais = new JPanel(new GridLayout(5, 2, 8, 8));
        painelDadosPessoais.setBorder(BorderFactory.createTitledBorder("Dados pessoais"));
        adicionarCampo(painelDadosPessoais, "Nome completo:", 25);
        adicionarCampo(painelDadosPessoais, "Matricula funcional:", 15);
        adicionarCampo(painelDadosPessoais, "CPF:", 15);
        adicionarCampo(painelDadosPessoais, "E-mail institucional:", 25);
        adicionarCampo(painelDadosPessoais, "Telefone:", 15);

        JPanel painelDadosProfissionais = new JPanel(new GridLayout(5, 2, 8, 8));
        painelDadosProfissionais.setBorder(BorderFactory.createTitledBorder("Dados profissionais"));
        adicionarCampo(painelDadosProfissionais, "Area de formacao:", 25);
        adicionarCampo(painelDadosProfissionais, "Titulacao:", 20);
        adicionarCampo(painelDadosProfissionais, "Departamento:", 20);
        adicionarCampo(painelDadosProfissionais, "Data de admissao:", 12);
        adicionarCampo(painelDadosProfissionais, "Carga horaria semanal:", 10);

        painelFormularios.add(painelDadosPessoais);
        painelFormularios.add(painelDadosProfissionais);

        JPanel painelBotoes = criarPainelBotoes();

        painelPrincipal.add(painelTitulo, BorderLayout.NORTH);
        painelPrincipal.add(painelFormularios, BorderLayout.CENTER);
        painelPrincipal.add(painelBotoes, BorderLayout.SOUTH);
        setContentPane(painelPrincipal);
    }

    /** Adiciona um rotulo e seu campo de texto ao formulario informado. */
    private void adicionarCampo(JPanel painel, String texto, int colunas) {
        painel.add(new JLabel(texto));
        painel.add(new JTextField(colunas));
    }

    /** Cria o painel de acoes apenas visual, sem ActionListener. */
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
            CadastroProfessor tela = new CadastroProfessor();
            tela.setVisible(true);
        });
    }
}
