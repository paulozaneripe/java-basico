package br.com.paulo.sunset;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ProgramaData {
	public static void main(String[] args) {
		
		String dataNasc;
		String dataFuturo;
		Integer diasVividos = 0;
		
        try(Scanner ler = new Scanner(System.in)) {
                System.out.print("Informe sua data de nascimento (dd/mm/aaaa): ");
                dataNasc = ler.next();
                
                LocalDate dataNascFormatada = LocalDate.parse(dataNasc, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                LocalDate dataAtual = LocalDate.now();
                Integer anos = dataAtual.getYear() - dataNascFormatada.getYear();
                Integer meses = dataAtual.getMonthValue() - dataNascFormatada.plusYears(anos).getMonthValue();
                Integer dias = dataAtual.getDayOfMonth() - dataNascFormatada.getDayOfMonth();
                		
                if(dataNascFormatada.isAfter(dataAtual)) {
                	
                	System.out.print("Você veio do futuro! ");
                	System.out.print("Informe a data do tempo que você veio (dd/mm/aaaa): ");
                	dataFuturo = ler.next();
                	
                	LocalDate dataFuturoFormatada = LocalDate.parse(dataFuturo, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                	
                	if(dataFuturoFormatada.isBefore(dataNascFormatada)) {
                		System.out.println("Data incompatível com a data do seu nascimento!");
                	} else {
                		
                        while(!dataAtual.plusDays(diasVividos).equals(dataFuturoFormatada)) {
                        	diasVividos++;
                        }
                        
                        if(diasVividos == 1) {
                        	System.out.println("Você está em um futuro após " + diasVividos + " dia da data atual!");
                        } else {
                        	System.out.println("Você está em um futuro após " + diasVividos + " dias da data atual!");
                        }
                        
                        Integer idade = dataFuturoFormatada.getYear() - dataNascFormatada.getYear();
                        if(idade == 0) {
                        	System.out.println("Você, viajante do tempo, nasceu no mesmo ano em que voltou no tempo!");
                        } else if(idade == 1) {
                        	System.out.println("Você, viajante do tempo, tem a idade de " + idade + " ano!");
                        } else {
                        	System.out.println("Você, viajante do tempo, tem a idade de " + idade + " anos!");
                        }
                        
                	}
           
                } else {
                	
                    while(!dataNascFormatada.plusDays(diasVividos).equals(dataAtual)) {
                    	diasVividos++;
                    }
                    
                    if(diasVividos == 1) {
                    	System.out.println("Você já viveu " + diasVividos + " dia em sua vida!");
                    } else if(diasVividos == 0) {
                    	System.out.println("Você está vivendo seu primeiro dia na vida!");
                    } else {
                    	System.out.println("Você já viveu " + diasVividos + " dias em sua vida!");
                    }
          
                    long horasVividas = diasVividos * 24;
                    
                    if(horasVividas > 0) {
                    	System.out.println("Você já viveu " + horasVividas + " horas em sua vida!");
                    }

                    if(anos > 0) {
                        if(meses == 0) {
                        	if(dias == 0) {
                        		System.out.println("Você faz aniversário hoje, parabéns!");
                        	} else if(dias > 0) {
                        		if(dias == 1) {
                        			System.out.println("Você já fez aniversário há " + dias + " dia atrás!");
                        		} else {
                        			System.out.println("Você já fez aniversário há " + dias + " dias atrás!");
                        		}
                        		
                        	} else {
                        		if(dias == -1) {
                        			System.out.println("Você irá fazer aniversário daqui à " + dias * -1 + " dia!");
                        		} else {
                        			System.out.println("Você irá fazer aniversário daqui à " + dias * -1 + " dias!");
                        		}
                        	}
                        } else if (meses > 0) {
                        	if(meses == 1) {
                        		System.out.println("Você já fez aniversário há " + meses + " mês atrás!");
                        	} else {
                        		System.out.println("Você já fez aniversário há " + meses + " meses atrás!");
                        	}
                    	} else {
                        	if(meses == -1) {
                        		System.out.println("Você irá fazer aniversário daqui à " + meses * -1 + " mês!");
                        	} else {
                        		System.out.println("Você irá fazer aniversário daqui à " + meses * -1 + " meses!");
                        	}
                    	}
                    } else {
                    	System.out.println("Você nasceu esse ano!");
                    }

                    
                }
                
        } catch (Exception e) {
            System.err.println("Valor inválido!");
        }
	}
}
