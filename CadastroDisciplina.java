/*
 * UNIVERSIDADE ESTADUAL DO SUDOESTE DA BAHIA - UESB
 * CENTRO DE EDUCACAO ABERTA E A DISTANCIA - CEAD
 * CURSO: Tecnologia em Analise e Desenvolvimento de Sistemas
 * DISCIPLINA: Programacao Orientada a Objeto - 2026.2
 * PROFESSOR: Murilo Silva Santana
 * ALUNO: Thiago Ferreira Prates Neves
 * ATIVIDADE: Telas Swing - Cadastro de Disciplina
 *
 * Objetivo: construir a terceira tela proposta na Apostila Java Swing.
 * A ementa usa JTextField e os botoes nao possuem eventos, como determinado.
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

/** Tela independente para o cadastro de disciplinas da UHS. */
public class CadastroDisciplina extends JFrame {

    /** Construtor: configura a janela e monta seus componentes. */
    public CadastroDisciplina() {
        configurarJanela();
        criarInterface();
    }

    /** Define as propriedades principais da janela. */
    private void configurarJanela() {
        setTitle("Cadastro de Disciplina - UHS");
        setSize(760, 590);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    /** Monta cabecalho, identificacao, oferta academica e acoes. */
    private void criarInterface() {
        JPanel painelPrincipal = new JPanel(new BorderLayout(12, 12));
        painelPrincipal.setBorder(BorderFactory.createEmptyBorder(15, 20, 15, 20));

        JPanel painelTitulo = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel titulo = new JLabel("Cadastro de Disciplina");
        titulo.setFont(new Font("Arial", Font.BOLD, 22));
        painelTitulo.add(titulo);

        JPanel painelFormularios = new JPanel(new GridLayout(2, 1, 10, 10));

        JPanel painelIdentificacao = new JPanel(new GridLayout(5, 2, 8, 8));
        painelIdentificacao.setBorder(BorderFactory.createTitledBorder("Identificacao"));
        adicionarCampo(painelIdentificacao, "Codigo:", 12);
        adicionarCampo(painelIdentificacao, "Nome:", 25);
        adicionarCampo(painelIdentificacao, "Ementa resumida:", 30);
        adicionarCampo(painelIdentificacao, "Curso relacionado:", 25);
        adicionarCampo(painelIdentificacao, "Departamento responsavel:", 20);

        JPanel painelOferta = new JPanel(new GridLayout(7, 2, 8, 8));
        painelOferta.setBorder(BorderFactory.createTitledBorder("Oferta academica"));
        adicionarCampo(painelOferta, "Carga horaria:", 10);
        adicionarCampo(painelOferta, "Creditos:", 10);
        adicionarCampo(painelOferta, "Periodo recomendado:", 10);
        adicionarCampo(painelOferta, "Professor responsavel:", 25);
        adicionarCampo(painelOferta, "Modalidade:", 15);
        adicionarCampo(painelOferta, "Sala:", 12);
        adicionarCampo(painelOferta, "Horario:", 15);

        painelFormularios.add(painelIdentificacao);
        painelFormularios.add(painelOferta);

        JPanel painelBotoes = criarPainelBotoes();

        painelPrincipal.add(painelTitulo, BorderLayout.NORTH);
        painelPrincipal.add(painelFormularios, BorderLayout.CENTER);
        painelPrincipal.add(painelBotoes, BorderLayout.SOUTH);
        setContentPane(painelPrincipal);
    }

    /** Adiciona o par rotulo/campo ao painel recebido. */
    private void adicionarCampo(JPanel painel, String texto, int colunas) {
        painel.add(new JLabel(texto));
        painel.add(new JTextField(colunas));
    }

    /** Cria os botoes visuais solicitados, sem cadastrar eventos. */
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
            CadastroDisciplina tela = new CadastroDisciplina();
            tela.setVisible(true);
        });
    }
}
