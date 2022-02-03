
//PACOTE
package programa;

import java.util.Scanner;    

//CLASSE PRINCIPAL.
public class Calculadora {    
    
    //MÉTODO PRINCIPAL.
    public static void main (String args[]){   
        
        //DECLARAÇÃO DAS VARIÁVEIS.
        short operacao;
        double num1 = 0;
        double num2 = 0;
        
        //Criando um objeto da CLASSE SCANNER
        Scanner entrada = new Scanner(System.in);
        
        //ESTRUTURA DE REPETIÇÃO.
        do {
            System.out.println("))---> CALCULADORA AE1 <---((\n");
            System.out.println("DIGITE UMA OPÇÃO: ");  
            System.out.println("[1] - SOMAR");    
            System.out.println("[2] - SUBTRAIR");    
            System.out.println("[3] - MULTIPLICAR");    
            System.out.println("[4] - DIVIDIR");
            System.out.println("[5] - ELEVAR AO QUADRADO");
            System.out.println("[0] - SAIR DA CALCULADORA\n");
            System.out.print("OPÇÃO: ");
            operacao = entrada.nextShort();
             
            if (operacao == 0) {
            	System.out.println("PROGRAMA ENCERRADO!");
            	break;
            }             
            if (!OperacaoExiste(operacao)) {
            	continue;
            }
            //------------------------------------------------------------------
            if (operacao == 1 || operacao == 2 || operacao == 3 || operacao == 4){
                System.out.println("DIGITE O PRIMEIRO NÚMERO: ");
                num1 = entrada.nextDouble();  
                System.out.println("DIGITE O SEGUNDO NÚMERO: ");  
                num2 = entrada.nextDouble();
            }else if(operacao == 5) {
                System.out.println("DIGITE UM NÚMERO PARA SER ELEVADO AO QUADRADO: ");  
                num1 = entrada.nextDouble();
            }else 
            //------------------------------------------------------------------ 
                        
            if (!ValidaDadosDeEntrada(operacao, num1, num2)) {
            	continue;
            }
        
            System.out.println("O RESULTADO DA OPERAÇÃO " 
                    + getNomeOperacao(operacao) 
                    + " É: " 
                    + Calcular(operacao, num1, num2) + "\n\n");
        } while (operacao != 0);
    }
    
    //MÉTODO QUE REALIZA O CÁLCULO DAS OPERAÇÕES.
    static double Calcular (short operacao, double num1, double num2) {
    	double resultado = 0;
    	switch (operacao) {
    		case 1: //CÁLCULO DA SOMA.
    			resultado = num1 + num2;
    			break;
    		case 2: //CÁLCULO DA SUBTRAÇÃO.
    			resultado = num1 - num2;
    			break;
    		case 3: //CÁLCULO DA MULTIPLICAÇÃO.
    			resultado = num1 * num2;
    			break;
    		case 4: //CÁLCULO DA DIVISÃO.
    			resultado = num1 / num2;
    			break;
                case 5: //CÁLCULO DO QUADRADO.
    			resultado = num1 * num1;
    			break;
    	}
    	return resultado;
    }
    
    //MÉTODO QUE VERIFICA SE A OPERAÇÃO EXISTE.
    static boolean OperacaoExiste (short operacao) {
       	boolean retorno = true;
    	if (operacao > 5) {
       		System.out.println("ERRO: OPÇÃO INVÁLIDA! TENTE NOVAMENTE ...\n\n\n");
       		retorno = false;
       	}
        if (operacao < 0) {
       		System.out.println("ERRO: OPÇÃO INVÁLIDA! TENTE NOVAMENTE ...\n\n\n");
       		retorno = false;
       	}
    	return retorno;
    }
    
    //MÉTODO QUE VALIDA OS DADOS DE ENTRADA.
    static boolean ValidaDadosDeEntrada (short operacao, double num1, double num2) {
    	boolean retorno = true; 
    	if (operacao == 4 & num2 == 0) {
        	System.out.println("ERRO: O DIVISOR NÃO PODE SER ZERO !!!\n");
        	retorno = false;
        }
    	return retorno;
    }
    
    static String getNomeOperacao (short operacao) {
    	
    	switch (operacao) {
		case 1:
			return "SOMA";
		case 2:
			return "SUBTRAÇÃO";
		case 3: 
			return "MULTIPLICAÇÃO";
		case 4: 
			return "DIVISÃO";
                case 5: 
			return "QUADRADO";
    	default:
    		return "OPERAÇÃO NÃO EXISTE!";
    	}
    	
    }
} 