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
                	
                	System.out.print("Voc� veio do futuro! ");
                	System.out.print("Informe a data do tempo que voc� veio (dd/mm/aaaa): ");
                	dataFuturo = ler.next();
                	
                	LocalDate dataFuturoFormatada = LocalDate.parse(dataFuturo, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                	
                	if(dataFuturoFormatada.isBefore(dataNascFormatada)) {
                		System.out.println("Data incompat�vel com a data do seu nascimento!");
                	} else {
                		
                        while(!dataAtual.plusDays(diasVividos).equals(dataFuturoFormatada)) {
                        	diasVividos++;
                        }
                        
                        if(diasVividos == 1) {
                        	System.out.println("Voc� est� em um futuro ap�s " + diasVividos + " dia da data atual!");
                        } else {
                        	System.out.println("Voc� est� em um futuro ap�s " + diasVividos + " dias da data atual!");
                        }
                        
                        Integer idade = dataFuturoFormatada.getYear() - dataNascFormatada.getYear();
                        if(idade == 0) {
                        	System.out.println("Voc�, viajante do tempo, nasceu no mesmo ano em que voltou no tempo!");
                        } else if(idade == 1) {
                        	System.out.println("Voc�, viajante do tempo, tem a idade de " + idade + " ano!");
                        } else {
                        	System.out.println("Voc�, viajante do tempo, tem a idade de " + idade + " anos!");
                        }
                        
                	}
           
                } else {
                	
                    while(!dataNascFormatada.plusDays(diasVividos).equals(dataAtual)) {
                    	diasVividos++;
                    }
                    
                    if(diasVividos == 1) {
                    	System.out.println("Voc� j� viveu " + diasVividos + " dia em sua vida!");
                    } else if(diasVividos == 0) {
                    	System.out.println("Voc� est� vivendo seu primeiro dia na vida!");
                    } else {
                    	System.out.println("Voc� j� viveu " + diasVividos + " dias em sua vida!");
                    }
          
                    long horasVividas = diasVividos * 24;
                    
                    if(horasVividas > 0) {
                    	System.out.println("Voc� j� viveu " + horasVividas + " horas em sua vida!");
                    }

                    if(anos > 0) {
                        if(meses == 0) {
                        	if(dias == 0) {
                        		System.out.println("Voc� faz anivers�rio hoje, parab�ns!");
                        	} else if(dias > 0) {
                        		if(dias == 1) {
                        			System.out.println("Voc� j� fez anivers�rio h� " + dias + " dia atr�s!");
                        		} else {
                        			System.out.println("Voc� j� fez anivers�rio h� " + dias + " dias atr�s!");
                        		}
                        		
                        	} else {
                        		if(dias == -1) {
                        			System.out.println("Voc� ir� fazer anivers�rio daqui � " + dias * -1 + " dia!");
                        		} else {
                        			System.out.println("Voc� ir� fazer anivers�rio daqui � " + dias * -1 + " dias!");
                        		}
                        	}
                        } else if (meses > 0) {
                        	if(meses == 1) {
                        		System.out.println("Voc� j� fez anivers�rio h� " + meses + " m�s atr�s!");
                        	} else {
                        		System.out.println("Voc� j� fez anivers�rio h� " + meses + " meses atr�s!");
                        	}
                    	} else {
                        	if(meses == -1) {
                        		System.out.println("Voc� ir� fazer anivers�rio daqui � " + meses * -1 + " m�s!");
                        	} else {
                        		System.out.println("Voc� ir� fazer anivers�rio daqui � " + meses * -1 + " meses!");
                        	}
                    	}
                    } else {
                    	System.out.println("Voc� nasceu esse ano!");
                    }

                    
                }
                
        } catch (Exception e) {
            System.err.println("Valor inv�lido!");
        }
	}
}
