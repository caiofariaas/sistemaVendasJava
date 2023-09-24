import javax.swing.*;

public class Main{

// Função para o usuário inserir as suas vendas

    public static void addVendas(int [][] matriz, int produtos, int mes){
        for (int p = 0; p < produtos; p++){
            JOptionPane.showMessageDialog(null,"Vendas do produto " + (p+1) );
            for (int m = 0; m < mes; m++){
                matriz[p][m] = Integer.parseInt(JOptionPane.showInputDialog("Vendas do mês "+(m+1)+":"));
            }
        }
    }

//Função para o usuário consultar as vendas de um determinado produto

    public static void vendasProd(int [][] matriz, int produtos, int mes) {
        boolean loop = true;

        while (loop) {
            int numProduto = Integer.parseInt(JOptionPane.showInputDialog("Digite o numero referente ao produto: "));
            if (numProduto <= produtos && numProduto > 0) {
                JOptionPane.showMessageDialog(null, "Vendas do produto " + numProduto);
                for (int m = 0; m < mes; m++) {
                    JOptionPane.showMessageDialog(null, "Mês " + (m + 1) + ": " + matriz[numProduto - 1][m]);
                }
                loop = false;
            }
            else {
                JOptionPane.showMessageDialog(null, "Valor inválido, tente novamente");
            }
        }
    }

//função principal principal

    public static void main(String[] args) {

        int produtosU, mesesU, escolha;
        int[][] matriz;

// Entrada do usuário
        produtosU = Integer.parseInt(JOptionPane.showInputDialog("Quantos produtos quer cadastrar: "));
        mesesU = Integer.parseInt(JOptionPane.showInputDialog("Quantos meses deseja cadastrar: "));
        matriz = new int[produtosU][mesesU];

        while (true) {
            escolha = Integer.parseInt(JOptionPane.showInputDialog("Oque deseja fazer?\n1 <- Inserir suas vendas\n2 <- Consultar minhas vendas\n0 <- Finalizar\n"));
//Ocasiões, processamento e saídas
            switch (escolha) {
                case 1 ->
                        addVendas(matriz, produtosU, mesesU);
                case 2 ->
                    vendasProd(matriz, produtosU, mesesU);
                case 0 -> {
                    JOptionPane.showMessageDialog(null, "Até a proxima!");
                    return;
                }
                default -> JOptionPane.showMessageDialog(null, "Digite um valor válido!");
            }
        }
    }
}