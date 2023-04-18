package aplicacao;

import java.util.Scanner;
import entidades.Mensagem;
import fila.FilaMensagens;

public class AtendimentoMensagem {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		FilaMensagens filaReclamacao = new FilaMensagens();
		FilaMensagens filaSugestao = new FilaMensagens();
		FilaMensagens filaResolucao = new FilaMensagens();
		
		int escolha;
		
		System.out.print(
				  "0 - Encerrar programa."
				+ "\n1 - Recebimento de mensagem."
				+ "\n2 - Atendimento de mensagem."
				+ "\n3 - Recebimento e Encaminhamento de Resolução."
				+ "\nDigite sua opção: ");
		escolha = input.nextInt();
	
		while(escolha != 0) {
			switch(escolha) {
				case 1:
					Mensagem mensagem = new Mensagem("", "", "", 0);
					
					System.out.print("\nNome: ");
					String nome = input.next();
					mensagem.setNome(nome);
					
					System.out.print("Email ou Telefone: ");
					String emailTelefone = input.next();
					mensagem.setEmailTelefone(emailTelefone);					
					
					System.out.print("Mensagem: ");
					String mensagens = input.next();
					mensagem.setMensagem(mensagens);
					
					System.out.print("Motivo do Contato (1 - Reclamação / 2 - Sugestão): ");
					int motivo = input.nextInt();
					mensagem.setMotivoContato(motivo);
					
					
					switch(motivo) {
						case 1:
							filaReclamacao.enqueue(mensagem);
							
							break;
						case 2:
							filaSugestao.enqueue(mensagem);
							
							break;
						default:
							System.out.println("\nEscolha do motivo inválida!");
							
					}
					
					
					break;
				case 2:
					int escolha2, escolha3;
					
					/*
					 1) Escolhe o tipo de mensagem (1reclamação ou 2sugestão)
					 2) Retirar da fila correspondente
					 3) Duas ações a seguir
					 	3.1) respondida agora e enviar uma mensagem avisando que foi resolvida
					 	3.2) encaminhar para outro setor, enviar resposta avisando e enviar para filaResolução
					 
					 */
					
					System.out.println(
							  "\nEscolha o tipo de mensagem para responder!"
							+ "\n1 - Reclamação"
							+ "\n2 - Sugestão");
					
					escolha2 = input.nextInt();
					
					switch(escolha2) {
						case 1:
							if(!filaReclamacao.isEmpty()) {
								
								System.out.println(filaReclamacao.exibir());
								
								System.out.println(
										  "\nComo seguir?"
										+ "\n1 - Responder agora"
										+ "\n2 - Encaminhar para o setor responsável.");
								escolha3 = input.nextInt();
								
								if(escolha3 == 1)
									System.out.println("\nEnviada resposta para cliente: sua solicitação já foi resolvida. Obrigado!!!");
								
								else 
									if(escolha == 2) {
										System.out.println("\nEm breve você receberá sua resposta!");
										filaResolucao.enqueue(filaReclamacao.dequeue());
										filaResolucao.exibir();
									}
								
								else
									System.out.println("\nOpção inválida");
								
							}
							
							else
								System.out.println("\nFila de reclamações está vazia!");
							
							break;
						case 2:
							
							break;
						default:
							System.out.println("\nOpção inválida!");
					}
					
					
					break;
				case 3:
					filaResolucao.exibir();
					/*
					 1) retira da filaReolução
					 2) Enviar resposta pra io cliente
					 */
					
					
					break;
				default:
					System.out.println("Opção inválida!");
			}
			
			System.out.print(
					  "\n0 - Encerrar programa."
					+ "\n1 - Recebimento de mensagem."
					+ "\n2 - Atendimento de mensagem."
					+ "\n3 - Recebimento e Encaminhamento de Resolução."
					+ "\nDigite sua opção: ");
			
			escolha = input.nextInt();
			
		}
		
		System.out.println("\nPrograma encerrado!");
		
		
		
		
		input.close();
	}

}
