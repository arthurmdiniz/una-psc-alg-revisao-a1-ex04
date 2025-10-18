import java.util.Scanner;
import java.text.NumberFormat;

public class SimuladorTributario {

    public static void main(String[] args){
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        NumberFormat milhar = NumberFormat.getCurrencyInstance();

        double valorFaturamento = 0.0, propostaAAntigo = 0.0, propostaANovo = 0.0, propostaBAntigo = 0.0, propostaBNovo = 0.0, diferencaA = 0.0, diferencaB = 0.0;
       

        System.out.print("Digite o valor do faturamento da empresa: R$");
        valorFaturamento = scanner.nextDouble();

        System.out.println("\n=== Análise de Tributação de Fintechs ===");

        System.out.println("Faturamento base: " + milhar.format(valorFaturamento) + "\n");

        System.out.println("-- Proposta A (9% -> 15%):");
        propostaAAntigo = calcularImpostoAntigo(valorFaturamento, 9);
        propostaANovo = calcularImpostoProposto(valorFaturamento, 15);
        diferencaA = calcularDiferenca(propostaAAntigo, propostaANovo);

        System.out.println("Imposto Antigo (9%): " + milhar.format(propostaAAntigo) );
        System.out.println("Imposto Proposto (15%): " + milhar.format(propostaANovo) );
        System.out.println("Diferença de Imposto: " + milhar.format(diferencaA) + "\n");
        
        
        System.out.println("-- Proposta B (15% -> 20%):");
        propostaBAntigo = calcularImpostoAntigo(valorFaturamento, 15);
        propostaBNovo = calcularImpostoProposto(valorFaturamento, 20);
        diferencaB = calcularDiferenca(propostaBAntigo, propostaBNovo);

        System.out.println("Imposto Antigo (15%): " + milhar.format(propostaBAntigo) );
        System.out.println("Imposto Proposto (20%): " + milhar.format(propostaBNovo) );
        System.out.println("Diferença de Imposto: " + milhar.format(diferencaB) + "\n");


        System.out.println("-- Análise de Diálogo --");
        statusDialogo(true);
        statusDialogo(false);



        scanner.close();
    }

    public static double calcularImpostoAntigo(double valorFaturamento, int aliquotaBase){
        return ((valorFaturamento /100) * aliquotaBase);
    }

    public static double calcularImpostoProposto(double valorFaturamento, int aliquotaProposta){
        return ((valorFaturamento /100) * aliquotaProposta);
    }

    public static double calcularDiferenca(double impostoAntigo, double impostoProposto){

        return (impostoProposto - impostoAntigo);
    }

    public static void statusDialogo(boolean acessoAoGoverno){
        if(acessoAoGoverno){
            System.out.println("STATUS: Diálogo aberto. Há espaço para negociação.");
        } else {
            System.out.println("STATUS: Fintechs reclamam de falta de acesso ao governo. Risco de derrota política.");
        }

    }

    
}
