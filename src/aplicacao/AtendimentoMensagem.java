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
		System.out.print("-----------------------------------");
		
		while(escolha != 0) {
			switch(escolha) {
				//Escolha entre os 3 itens do menu
				case 1:
					Mensagem mensagem = new Mensagem("", "", "", 0);
					
					System.out.print("\n\nMotivo do Contato (1 - Reclamação / 2 - Sugestão): ");
					int motivo = input.nextInt();
					mensagem.setMotivoContato(motivo);
	
					//Motivo do contato
					switch(motivo) {
						case 1:
							if(!filaReclamacao.isFull()) {
								System.out.print("Nome: ");
								String nome = input.next();
								mensagem.setNome(nome);
								
								System.out.print("Email ou Telefone: ");
								String emailTelefone = input.next();
								mensagem.setEmailTelefone(emailTelefone);					
								
								System.out.print("Mensagem: ");
								String mensagens = input.next();
								mensagem.setMensagem(mensagens);
								
								filaReclamacao.enqueue(mensagem);
							}
							else {
								System.out.println(
										"\n---|---|---|---|---"
										+ "\nFila de reclamações está cheia!"
										+ "\n---|---|---|---|---");
							}
							
							break;
						case 2:
							if(!filaSugestao.isFull()) {
								System.out.print("Nome: ");
								String nome = input.next();
								mensagem.setNome(nome);
								
								System.out.print("Email ou Telefone: ");
								String emailTelefone = input.next();
								mensagem.setEmailTelefone(emailTelefone);					
								
								System.out.print("Mensagem: ");
								String mensagens = input.next();
								mensagem.setMensagem(mensagens);
								
								filaSugestao.enqueue(mensagem);
							}
							else {
								System.out.println(
										"\n---|---|---|---|---"
										+ "\nFila de reclamações está cheia!"
										+ "\n---|---|---|---|---");
							}
							
							break;
						default:
							System.out.println("\nEscolha do motivo inválida!");
					}
					
				break;
				//Escolha entre os 3 itens do menu
				case 2:
					int escolha2, escolha3;
					
					System.out.println(
							  "\n\nEscolha o tipo de mensagem para responder!"
							+ "\n1 - Reclamação"
							+ "\n2 - Sugestão");
					escolha2 = input.nextInt();
					
					switch(escolha2) {
						//Escolha do TIPO de mensagem	
						case 1:
							if(!filaReclamacao.isEmpty()) {
				
								System.out.println(filaReclamacao.exibir());
								System.out.println(
										  "\nComo seguir?"
										+ "\n1 - Responder agora"
										+ "\n2 - Encaminhar para o setor responsável.");
								escolha3 = input.nextInt();
								
								if(escolha3 == 1) {
									System.out.println(
											"\n---|---|---|---|---"
											+ "\nEnviada resposta para cliente: sua solicitação já foi resolvida. Obrigado!!!"
											+ "\n---|---|---|---|---");
									filaReclamacao.dequeue();
								}
								else 
									if(escolha == 2) {
										System.out.println(
												"\n---|---|---|---|---"
												+ "\nEm breve você receberá sua resposta!"
												+ "\n---|---|---|---|---");
										filaResolucao.enqueue(filaReclamacao.dequeue());
										filaResolucao.exibir();
									}
								
								else
									System.out.println("\nOpção inválida");
							}
							
							else
								System.out.println(
										"\n---|---|---|---|---"
										+ "\nFila de reclamações está vazia!"
										+ "\n---|---|---|---|---");
							
							break;
						//Escolha do TIPO de mensagem
						case 2:
							if(!filaSugestao.isEmpty()) {
								
								System.out.println(filaSugestao.exibir());
								System.out.println(
										  "\nComo seguir?"
										+ "\n1 - Responder agora"
										+ "\n2 - Encaminhar para o setor responsável.");
								escolha3 = input.nextInt();
								
								if(escolha3 == 1) {
									System.out.println(
											"\n---|---|---|---|---"
											+ "\nEnviada resposta para cliente: sua solicitação já foi resolvida. Obrigado!!"
											+ "\n---|---|---|---|---");
									filaSugestao.dequeue();
								}
								else 
									if(escolha == 2) {
										System.out.println(
												"\n---|---|---|---|---"
												+ "\nEm breve você receberá sua resposta!"
												+ "\n---|---|---|---|---");
										filaResolucao.enqueue(filaSugestao.dequeue());
										filaResolucao.exibir();
									}
								
								else
									System.out.println("\nOpção inválida");
							}
							
							else
								System.out.println(
										"\n---|---|---|---|---"
										+ "\nFila de sugestões está vazia!"
										+ "\n---|---|---|---|---");
							
							break;
						//Escolha do TIPO de mensagem
						default:
							System.out.println("\nOpção inválida!");
					}
					
					break;
				//Escolha entre os 3 itens do menu
				case 3:
					int escolha4;
					
					if(!filaResolucao.isEmpty()) {
						System.out.println(filaResolucao.exibir());
						System.out.println("\nDeseja responder essa mensagem??"
								+ "\n1 - Sim"
								+ "\n2 - Não");
						escolha4 = input.nextInt();
						
						if(escolha4 == 1) {
							filaResolucao.dequeue();
							System.out.println(
									"\n---|---|---|---|---"
									+ "\nEnviada resposta para cliente: sua solicitação já foi resolvida pelo setor responsável. Obrigado!!!"
									+ "\n---|---|---|---|---");
						}
						else
							if(escolha4 == 2) {
								System.out.println(
										"\n---|---|---|---|---"
										+ "\nVoltando para o menu..."
										+ "\n---|---|---|---|---");
							}
						
					}
					else
						System.out.println(
								"\n\n---|---|---|---|---"
								+ "\nFila de Resoluções está vazia!"
								+ "\n---|---|---|---|---");

					break;
				//Escolha entre os 3 itens do menu
				default:
					System.out.println("Opção inválida!");
			}
			System.out.print(
					  "\n-----------------------------------"
					+ "\n0 - Encerrar programa."
					+ "\n1 - Recebimento de mensagem."
					+ "\n2 - Atendimento de mensagem."
					+ "\n3 - Recebimento e Encaminhamento de Resolução."
					+ "\nDigite sua opção: ");
			escolha = input.nextInt();
			System.out.print("-----------------------------------");
			
		}
		
		System.out.println("\nPrograma encerrado!");
		input.close();
	}
	
}
