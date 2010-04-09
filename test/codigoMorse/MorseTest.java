package codigoMorse;


import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class MorseTest {
	
	private Morse morse;
	
	@Before
	public void inicializa(){
		morse = new Morse();
	}
	
	@Test
	public void testCodifica(){
		morse.setMensagem("SOS");
		assertEquals("*** --- ***", morse.codifica());
		morse.setMensagem("S O S");
		assertEquals("***  ---  ***", morse.codifica());
		morse.setMensagem("suco doce");
		assertEquals("*** **- -*-* ---  -** --- -*-* *", morse.codifica());
		morse.setMensagem("manga Doce");
		assertEquals("-- *- -* --* *-  -** --- -*-* *", morse.codifica());		
		morse.setMensagem("O suco da manga é Doce");
		assertEquals("---  *** **- -*-* ---  -** *-  -- *- -* --* *-  *  -** --- -*-* *", morse.codifica());
	}
	@Test
	public void testCaixaAlta(){
		morse.setMensagem("luan");
		assertEquals("LUAN", morse.getMensagem());
		morse.setMensagem("aLaN");
		assertEquals("ALAN", morse.getMensagem());
		
	}
	
	@Test
	public void testCaracteresEspeciais(){
		morse.setMensagem("açúcar");
		assertEquals("ACUCAR", morse.getMensagem());
		morse.setMensagem("Manhã de Solzão");
		assertEquals("MANHA DE SOLZAO", morse.getMensagem());
		morse.setMensagem("degenerativo");
		assertEquals("DEGENERATIVO", morse.getMensagem());
		morse.setMensagem("mÚsicas MÍSticas Não violÃo");
		assertEquals("MUSICAS MISTICAS NAO VIOLAO", morse.getMensagem());
	}
	
	@Test
	public void testCaracteresInvalidos(){
		morse.setMensagem("açúcar?!");
		assertEquals("ACUCAR  ", morse.getMensagem());
		
		morse.setMensagem("cacildes!do@monçÃo?");
		assertEquals("CACILDES DO MONCAO ", morse.getMensagem());
		
		morse.setMensagem("teste@dojo.com/ifpiPHB");
		assertEquals("TESTE DOJO.COM IFPIPHB", morse.getMensagem());
		
		morse.setMensagem("Ú?ltimo tesTE de @rromb@?");
		assertEquals("U LTIMO TESTE DE  RROMB  ", morse.getMensagem());
	}
	
	
	
}
